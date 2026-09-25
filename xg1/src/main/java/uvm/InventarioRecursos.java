package uvm;

import java.util.HashMap;
import java.util.Map;

public class InventarioRecursos {

    private Map<TipoRecurso, Double> recursos;

    public InventarioRecursos(){
        this.recursos = new HashMap<>();
    }

    public Map<TipoRecurso, Double> getRecursos(){
        return recursos;
    }

    public void setRecursos(Map<TipoRecurso, Double> recursos){
        this.recursos = recursos;
    }

    public void agregar(TipoRecurso tipo, double cantidad){
        double actual = consultar(tipo);
        recursos.put(tipo, actual + cantidad);
    }

    public void gastar(TipoRecurso tipo, double cantidad){
        double actual = consultar(tipo);

        if (actual >= cantidad){
            recursos.put(tipo, actual - cantidad);
        }
    }

    public double consultar(TipoRecurso tipo){
        return recursos.getOrDefault(tipo, 0.0);
    }

    public double balance(){
        double total = 0;

        for (double cantidad : recursos.values()){
            total = total + cantidad;
        }

        return total;
    }
}