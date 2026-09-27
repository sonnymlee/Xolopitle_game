package uvm;

import java.util.ArrayList;

public class Partida {
//atributos

private int id;
private Estado estadoActual;
private String name;
// Conecto las clases Dummy
private EstadoJugadorActual jugador;
private Localizacion localizacionActual;
private InventarioRecursos recursos;
private EstadoPartidaActual estadoDeLaPartida;
// Listas para guardar los varios personajes y objetivos
private ArrayList<Personaje> personajes;
private ArrayList<Objetivo> objetivos;

//metodos

public Partida (int id, String name, EstadoJugadorActual jugador, Localizacion localizacionActual){

    this.id=id;
    this.name=name;
    this.jugador=jugador;
    this.localizacionActual=localizacionActual;
    this.estadoActual=Estado.NO_INICIADA; //por defecto esto inicia asi porque pues no hay partida cuando habres el juego por 1ra vez XD
    // se inician listas array para que no den algun error de que no se iniciaran y asi 
    this.personajes=new ArrayList<>();
    this.objetivos=new ArrayList<>();
    this.recursos=new InventarioRecursos();
    this.estadoDeLaPartida = new EstadoPartidaActual();
}

    //getters y setters
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public Estado getEstadoActual(){return estadoActual;} public void setEstadoActual(Estado estadoActual){this.estadoActual=estadoActual;}
    public EstadoJugadorActual getJugador(){return jugador;} public void setJugador(EstadoJugadorActual jugador){this.jugador=jugador;}
    public ArrayList<Personaje> getPersonajes(){return personajes;} public void setPersonajes(ArrayList<Personaje> personajes){this.personajes=personajes;}
    public ArrayList<Objetivo> getObjetivos(){return objetivos;} public void setObjetivos(ArrayList<Objetivo> objetivos){this.objetivos=objetivos;}
    public Localizacion getLocalizacionActual(){return localizacionActual;} public void setLocalizacionActual(Localizacion localizacionActual){this.localizacionActual=localizacionActual;}
    public InventarioRecursos getRecursos(){return recursos;} public void setRecursos(InventarioRecursos recursos){this.recursos=recursos;}
    public EstadoPartidaActual getEstadoPartidaActual(){return estadoDeLaPartida;} public void setEstadoPartidaActual(EstadoPartidaActual estadoPartidaActual){
        this.estadoDeLaPartida=estadoPartidaActual;}

    //metodos de actualizar y agregar datos
    public void iniciarPartida(){
        this.estadoActual=Estado.EN_CURSO; 
    }

    public void agregarPersonaje(Personaje p){
        this.personajes.add(p);
    }

    public void agregarObjetivo(Objetivo o){
        this.objetivos.add(o);
    }

    public void cambiarLocalizacion(Localizacion nuevaLocalizacion){
        this.localizacionActual=nuevaLocalizacion;
    }

    //metodos para agregar los enemigos y los aliados a la partida
    public ArrayList<Personaje> obtenerAliados(){
        ArrayList<Personaje> aliados = new ArrayList<>();
        for (Personaje p: this.personajes){
            if (p.esAliado()){
                aliados.add(p);
            }
        }
        return aliados;
    }

    public ArrayList<Personaje> obtenerEnemigos(){
        ArrayList<Personaje> enemigos = new ArrayList<>();
        for (Personaje p: this.personajes){
            if (p.esEnemigo()){
                enemigos.add(p);
            }
        }
        return enemigos;
    }

}
