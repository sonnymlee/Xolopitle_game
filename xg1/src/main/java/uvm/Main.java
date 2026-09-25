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
    }
}
