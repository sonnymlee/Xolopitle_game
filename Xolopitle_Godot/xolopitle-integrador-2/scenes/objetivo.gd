class_name Objetivo
extends Area2D

@export var nombre: String = "Cadena de suministros"
@export var dificultad: String = "Alta"
@export var valor: int = 500

var completado: bool = false
var jugador_cerca: bool = false

@onready var info: Label = $Info

func _ready() -> void:
	info.visible = false
	body_entered.connect(_on_body_entered)
	body_exited.connect(_on_body_exited)

func _on_body_entered(body: Node2D) -> void:
	if body is CharacterBody2D:
		jugador_cerca = true
		info.text = "Presiona Enter para interactuar"
		info.visible = true

func _on_body_exited(body: Node2D) -> void:
	if body is CharacterBody2D:
		jugador_cerca = false
		info.visible = false

func _unhandled_input(event: InputEvent) -> void:
	if jugador_cerca and event.is_action_pressed("ui_accept"):
		info.text = "Objetivo: %s\nDificultad: %s" % [nombre, dificultad]
