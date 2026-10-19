package uvm;

import java.util.HashMap;
import java.util.Map;

public class InventarioRecursos {
    
    private Map<Tipor, Recurso> recursos;

    public InventarioRecursos(){
        this.recursos = new HashMap<>();
    }

    public Map<Tipor, Recurso> getRecursos(){
        return recursos;
    }

    public void setRecursos(Map<Tipor, Recurso> recursos){
        this.recursos = recursos;
    }

    public void agregar(Tipor tipo, double cantidad){
        if (recursos.containsKey(tipo)) {
            recursos.get(tipo).agregar(cantidad);
        } else {
            recursos.put(tipo, new Recurso(recursos.size() + 1, tipo, cantidad, 1.0));
        }
    }

    public boolean gastar(Tipor tipo, double cantidad){
        if (recursos.containsKey(tipo)) {
            return recursos.get(tipo).gastar(cantidad);
        }
        return false;
    }

    public double consultar(Tipor tipo){
        if (recursos.containsKey(tipo)) {
            return recursos.get(tipo).getCantidad();
        }
        return 0.0;
    }

    public double balance(){
        double total = 0;

        for (Recurso r : recursos.values()){
            total = total + r.getCantidad();
        }

        return total;
    }
}