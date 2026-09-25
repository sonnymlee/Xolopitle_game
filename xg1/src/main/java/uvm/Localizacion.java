package uvm;

public class Localizacion {
  //atributos
    private int id;
    private String nombre;
    private Tipol tipo;
    private int riesgo;
    private boolean segura;
    //metodos
    
    public Localizacion(int id, String nombre, Tipol tipo, int riesgo, boolean segura) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.riesgo = riesgo;
        this.segura = segura;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Tipol getTipo() { return tipo; }
    public void setTipo(Tipol tipo) { this.tipo = tipo; }
    public int getRiesgo() { return riesgo; }
    public void setRiesgo(int riesgo) { this.riesgo = riesgo; }
    public boolean isSegura() { return segura; }
    public void setSegura(boolean segura) { this.segura = segura; }

    public void cambiarRiesgo(int x) {
        this.riesgo = this.riesgo + x;
        this.segura = this.riesgo > 50;
    }

}
