package uvm;

public class EstadoPartidaActual {
    //atributos
    private String estado;
    private double tiempoRestante;
    private int dia;
    private String fase;

    //metodos
    public EstadoPartidaActual(){
        this.estado = "EN_CURSO";
        this.tiempoRestante = 0;
        this.dia = 1;
        this.fase = "INICIO";
    }

    public String getEstado(){return estado;}
    public void setEstado(String estado){this.estado = estado;}

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
        estado = "PAUSADA";
    }

    public void finalizar(){
        estado = "FINALIZADA";
    }

    public boolean haTerminado(){
        return estado.equals("FINALIZADA");
    }
}