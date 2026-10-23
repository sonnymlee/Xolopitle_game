@tool
extends EditorScript

const CARPETA_PNG = "res://assets/items/"
const CARPETA_TRES = "res://inventory/Items/"

func _run() -> void:
	var dir = DirAccess.open(CARPETA_PNG)
	if not dir:
		print("Error: No se encontró la carpeta de PNGs")
		return
		
	dir.list_dir_begin()
	var file_name = dir.get_next()
	
	while file_name != "":
		if not dir.current_is_dir() and file_name.ends_with(".png"):
			var nombre_limpio = file_name.get_basename()
			
			var nuevo_item = InvItem.new()
			nuevo_item.name = nombre_limpio.capitalize()
			nuevo_item.texture = load(CARPETA_PNG + file_name)
			
			var ruta_guardado = CARPETA_TRES + nombre_limpio + ".tres"
			ResourceSaver.save(nuevo_item, ruta_guardado)
			
		file_name = dir.get_next()
	
	print("¡Ítems generados!")
	EditorInterface.get_resource_filesystem().scan()
