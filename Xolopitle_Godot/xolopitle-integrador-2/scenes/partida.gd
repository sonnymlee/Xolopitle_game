class_name Partida
extends Node2D

const RUTA_GUARDADO := "user://partida.json"

@export var escena_jugador: PackedScene
@export var escena_objetivo: PackedScene
@export var escena_inventario: PackedScene

@onready var nodo_personajes: Node2D = $Personajes
@onready var nodo_objetivos: Node2D = $Objetivos

# Es el mismo inventario que usan player e inv_ui (Godot lo comparte)
var inv: Inv = preload("res://inventory/PlayerInv.tres")

var estado: GlobalEnums.Estado = GlobalEnums.Estado.NO_INICIADA
var jugador: Node2D

func _ready() -> void:
	iniciar_partida()

func iniciar_partida() -> void:
	if escena_jugador:
		jugador = escena_jugador.instantiate()
		jugador.position = Vector2(100, 100)
		nodo_personajes.add_child(jugador)

	if escena_objetivo:
		_crear_objetivo("Banco", "Alta", Vector2(200, 50))
		_crear_objetivo("Hospital", "Media", Vector2(50, 180))
		_crear_objetivo("Cadena de suministros", "Alta", Vector2(200, 180))

	if escena_inventario:
		var capa := CanvasLayer.new()
		add_child(capa)
		capa.add_child(escena_inventario.instantiate())

	estado = GlobalEnums.Estado.EN_CURSO

func _crear_objetivo(n: String, d: String, pos: Vector2) -> void:
	var o := escena_objetivo.instantiate()
	o.nombre = n
	o.dificultad = d
	o.position = pos
	nodo_objetivos.add_child(o)

func _unhandled_input(event: InputEvent) -> void:
	if event is InputEventKey and event.pressed and not event.echo:
		if event.keycode == KEY_F5:
			guardar_partida()
		elif event.keycode == KEY_F9:
			cargar_partida()

func guardar_partida() -> void:
	var lista_inv := []
	for slot in inv.slots:
		if slot.item == null:
			lista_inv.append(null)
		else:
			print("Guardando ítem: ", slot.item.resource_path)
			lista_inv.append({
				"ruta": slot.item.resource_path,
				"cantidad": slot.amount,
			})

	var datos := {
		"estado": estado,
		"inventario": lista_inv,
	}
	if jugador != null:
		datos["jugador_x"] = jugador.position.x
		datos["jugador_y"] = jugador.position.y

	var archivo := FileAccess.open(RUTA_GUARDADO, FileAccess.WRITE)
	if archivo == null:
		push_error("No se pudo abrir el archivo para guardar")
		return
	archivo.store_string(JSON.stringify(datos))
	archivo.close()
	print("Partida guardada")

func cargar_partida() -> void:
	if not FileAccess.file_exists(RUTA_GUARDADO):
		print("No hay partida guardada")
		return
	var archivo := FileAccess.open(RUTA_GUARDADO, FileAccess.READ)
	var datos = JSON.parse_string(archivo.get_as_text())
	archivo.close()
	if typeof(datos) != TYPE_DICTIONARY:
		push_error("Archivo de guardado inválido")
		return

	estado = int(datos.get("estado", 0)) as GlobalEnums.Estado

	if jugador != null and datos.has("jugador_x"):
		jugador.position = Vector2(datos["jugador_x"], datos["jugador_y"])

	var lista_inv: Array = datos.get("inventario", [])
	for i in range(inv.slots.size()):
		var slot = inv.slots[i]
		if i < lista_inv.size() and lista_inv[i] != null:
			slot.item = load(lista_inv[i]["ruta"]) as InvItem
			slot.amount = int(lista_inv[i]["cantidad"])
		else:
			slot.item = null
			slot.amount = 0
	inv.update.emit()  # refresca la pantalla del inventario
	print("Partida cargada")

func pausar() -> void:
	estado = GlobalEnums.Estado.PAUSADA

func finalizar() -> void:
	estado = GlobalEnums.Estado.FINALIZADA
