class_name Guardado
extends Node

const RUTA_GUARDADO := "user://partida.json"

var inv: Inv = preload("res://inventory/PlayerInv.tres")

func _unhandled_input(event: InputEvent) -> void:
	if event is InputEventKey and event.pressed and not event.echo:
		if event.keycode == KEY_G:
			guardar()
		elif event.keycode == KEY_C:
			cargar()

func guardar() -> void:
	var lista_inv := []
	for slot in inv.slots:
		if slot.item == null:
			lista_inv.append(null)
		else:
			lista_inv.append({
				"ruta": slot.item.resource_path,
				"cantidad": slot.amount,
			})
	var archivo := FileAccess.open(RUTA_GUARDADO, FileAccess.WRITE)
	if archivo == null:
		push_error("No se pudo abrir el archivo para guardar")
		return
	archivo.store_string(JSON.stringify({"inventario": lista_inv}))
	archivo.close()
	print("Partida guardada")

func cargar() -> void:
	if not FileAccess.file_exists(RUTA_GUARDADO):
		print("No hay partida guardada")
		return
	var archivo := FileAccess.open(RUTA_GUARDADO, FileAccess.READ)
	var datos = JSON.parse_string(archivo.get_as_text())
	archivo.close()
	if typeof(datos) != TYPE_DICTIONARY:
		push_error("Archivo de guardado inválido")
		return
	var lista_inv: Array = datos.get("inventario", [])
	for i in range(inv.slots.size()):
		var slot = inv.slots[i]
		if i < lista_inv.size() and lista_inv[i] != null:
			slot.item = load(lista_inv[i]["ruta"]) as InvItem
			slot.amount = int(lista_inv[i]["cantidad"])
		else:
			slot.item = null
			slot.amount = 0
	inv.update.emit()
	print("Partida cargada")
