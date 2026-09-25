package uvm;

public class EstadoJugadorActual {

    private String estado;
    private double salud;
    private int reputacion;
    private int nivelBusqueda;
    private boolean anonimato;

    public EstadoJugadorActual(String estado, double salud, int reputacion, int nivelBusqueda, boolean anonimato){
        this.estado = estado;
        this.salud = salud;
        this.reputacion = reputacion;
        this.nivelBusqueda = nivelBusqueda;
        this.anonimato = anonimato;
    }

    public String getEstado(){return estado;}
    public void setEstado(String estado){this.estado = estado;}

    public double getSalud(){return salud;}
    public void setSalud(double salud){this.salud = salud;}

    public int getReputacion(){return reputacion;}
    public void setReputacion(int reputacion){this.reputacion = reputacion;}

    public int getNivelBusqueda(){return nivelBusqueda;}
    public void setNivelBusqueda(int nivelBusqueda){this.nivelBusqueda = nivelBusqueda;}

    public boolean getAnonimato(){return anonimato;}
    public void setAnonimato(boolean anonimato){this.anonimato = anonimato;}

    public boolean estaActivo(){
        return estado.equals("ACTIVO") && salud > 0;
    }

    public boolean puedeActuar(){
        return estaActivo();
    }

    public void actualizarEstado(){
        if (salud <= 0){
            estado = "INACTIVO";
        } else {
            estado = "ACTIVO";
        }
    }
}