package uvm;

public class EstadoPartidaActual {
    //atributos
    private Estado estado;
    private double tiempoRestante;
    private int dia;
    private String fase;

    //metodos
    public EstadoPartidaActual(){
        this.estado = Estado.EN_CURSO;
        this.tiempoRestante = 0;
        this.dia = 1;
        this.fase = "INICIO";
    }

    public Estado getEstado(){return estado;}
    public void setEstado(Estado estado){this.estado = estado;}

    public double getTiempoRestante(){return tiempoRestante;}
    public void setTiempoRestante(double tiempoRestante){this.tiempoRestante = tiempoRestante;}

    public String getFase(){return fase;}
    public void setFase(String fase){this.fase = fase;}

    public int getDia(){return dia;}
    public void setDia(int dia){this.dia = dia;}

    public void avanzarDia(){
        dia++;
    }

    public void pausar(){
        estado = Estado.PAUSADA;
    }

    public void finalizar(){
        estado = Estado.FINALIZADA;
    }

    public boolean haTerminado(){
        return estado == Estado.FINALIZADA;
    }
}