package uvm;

public class Personaje {
    //atributos
    private int id;
    private String nombre;
    private String rol;
    private Bando bando;
    private int lealtad;
    private int habilidad;
    private boolean activo;

    //metodos
    public Personaje(int id, String nombre, String rol, Bando bando,int lealtad, int habilidad, boolean activo){
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.bando = bando;
        this.lealtad = lealtad;
        this.habilidad = habilidad;
        this.activo = activo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    public Bando getBando() { return bando; }
    public void setBando(Bando bando) { this.bando = bando; }
    public int getLealtad() { return lealtad; }
    public void setLealtad(int lealtad) { this.lealtad = lealtad; }
    public int getHabilidad() { return habilidad; }
    public void setHabilidad(int habilidad) { this.habilidad = habilidad; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
    
    public boolean esAliado() {return bando == Bando.ALIADO;}
    public boolean esEnemigo() {return bando == Bando.ENEMIGO;}
    public void ajustarLeatad(int cambio){
        this.lealtad = this.lealtad + cambio;
    }
    public void cambiarBando(Bando nBando){
        if (nBando != null) {
            this.bando = nBando;
        }
    }

}