package uvm;

public class Objetivo {
  //atributos
    private int id;
    private String nombre;
    private String tipo;
    private int valor;
    private int dificultad;
    private boolean completado;
    //metodos

    public Objetivo(int id, String nombre, String tipo,int valor, int dificultad, boolean completado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.dificultad = dificultad;
        this.completado = completado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getValor() { return valor; }
    public int getDificultad() { return dificultad; }
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
    public boolean isCompletado() { return completado; }
    public void setCompletado(boolean completado) { this.completado = completado; }
    public void marcarCompletado() {
        this.completado = true;
    }
    public int calcularRecompensa() {
        if (!completado) return 0;
        return valor * dificultad / 10;
    }

}
