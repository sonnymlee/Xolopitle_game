extends CharacterBody2D
enum State{
	IDLE,
	MOVERAB,
	MOVERAR,
	MOVERX
}

@export_category("Estadisticas")
@export var Velocidad: int = 300
@export var Dinero: float = 100
@export var Crypt: float = 100
@export var Inventario = {"Herramienta": "Pinzas", "Arma": "Tubo"}


var state: State =State.IDLE
var moveDirection: Vector2 = Vector2(0,0)

@onready var animation_tree: AnimationTree = $AnimationTree
@onready var animation_playback: AnimationNodeStateMachinePlayback = $AnimationTree["parameters/playback"]

@warning_ignore("unused_parameter")
func _physics_process(delta: float) -> void:
	movementLoop()
	
func movementLoop() -> void:
	moveDirection.x = int(Input.is_action_pressed("right")) - int(Input.is_action_pressed("left"))
	moveDirection.y = int(Input.is_action_pressed("down")) - int(Input.is_action_pressed("up"))
	var motion: Vector2 = moveDirection.normalized() * Velocidad
	set_velocity(motion)
	move_and_slide()
	
	
	if state == State.IDLE or State.MOVERX:
		if moveDirection.x < -0.1:
			$Sprite2D.flip_h = true
		elif moveDirection.x > 0.1:
			$Sprite2D.flip_h = false
	
	if moveDirection.x != 0  and state == State.IDLE:
		state = State.MOVERX
		update_animation()
	elif motion == Vector2.ZERO and state != State.IDLE:
		state = State.IDLE
		update_animation()
	if moveDirection.y > 0 and state != State.MOVERAB:
		state = State.MOVERAB
		update_animation()
	if moveDirection.y < 0 and state != State.MOVERAR:
		state = State.MOVERAR
		update_animation()
func update_animation() -> void:
	match state:
		State.IDLE:
			animation_playback.travel("idle")
		State.MOVERX:
			animation_playback.travel("moverx")
		State.MOVERAB:
			animation_playback.travel("moverab")
		State.MOVERAR:
			animation_playback.travel("moverar")
