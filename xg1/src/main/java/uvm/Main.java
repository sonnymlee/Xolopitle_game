package uvm;

public class Main {
    public static void main(String[] args) {
        Personaje lider = new Personaje(200, "dss", "lider", Bando.ALIADO, 20, 50, false);
        System.out.println("Hello world!");
        System.out.print(lider.getBando());
        lider.cambiarBando(Bando.ENEMIGO);
        System.out.print(lider.getBando());
        Objetivo o1 = new Objetivo(1000, "dsd", "null", 200, 5000, false);
        System.out.print(o1.getDificultad());
        o1.setDificultad(10);   
        System.out.print(o1.getDificultad());
        Localizacion l1= new Localizacion(2121, "dsd", Tipol.BASE, 10, true);
        System.out.print(l1.getRiesgo());
        l1.setRiesgo(50);
        System.out.print(l1.getRiesgo());
        Recurso r1 = new Recurso(2345, Tipor.DINERO, 1111, 10);
        System.out.print(r1.getCantidad());
        r1.gastar(1000);
        System.out.print(r1.getCantidad());




        // Prueba de InventarioRecursos
        InventarioRecursos inventario = new InventarioRecursos();

        inventario.agregar(TipoRecurso.DINERO, 1000);

        System.out.println("\n\nInventarioRecursos:");
        System.out.println("Dinero: " + inventario.consultar(TipoRecurso.DINERO));
        System.out.println("Balance: " + inventario.balance());

        inventario.gastar(TipoRecurso.DINERO, 250);

        System.out.println("Dinero despues de gastar: " + inventario.consultar(TipoRecurso.DINERO));


        // Prueba de EstadoJugadorActual
        EstadoJugadorActual jugador = new EstadoJugadorActual("ACTIVO", 100, 50, 1, true);

        System.out.println("\nEstadoJugadorActual:");
        System.out.println("Estado: " + jugador.getEstado());
        System.out.println("Salud: " + jugador.getSalud());
        System.out.println("Reputacion: " + jugador.getReputacion());
        System.out.println("Nivel de busqueda: " + jugador.getNivelBusqueda());
        System.out.println("Anonimato: " + jugador.getAnonimato());
        System.out.println("Puede actuar: " + jugador.puedeActuar());

        jugador.setSalud(0);
        jugador.actualizarEstado();

        System.out.println("Estado despues de perder salud: " + jugador.getEstado());
        System.out.println("Esta activo: " + jugador.estaActivo());


        // Prueba de EstadoPartidaActual
        EstadoPartidaActual estadoPartida = new EstadoPartidaActual();

        System.out.println("\nEstadoPartidaActual:");
        System.out.println("Estado: " + estadoPartida.getEstado());
        System.out.println("Dia: " + estadoPartida.getDia());
        System.out.println("Tiempo restante: " + estadoPartida.getTiempoRestante());
        System.out.println("Fase: " + estadoPartida.getFase());

        estadoPartida.avanzarDia();

        System.out.println("Dia despues de avanzar: " + estadoPartida.getDia());

        estadoPartida.pausar();

        System.out.println("Estado despues de pausar: " + estadoPartida.getEstado());

        estadoPartida.finalizar();

        System.out.println("Estado despues de finalizar: " + estadoPartida.getEstado());
        System.out.println("Ha terminado: " + estadoPartida.haTerminado());
    }
}
