package uvm;

public class Recurso {
  //atributos
    private int id;
    private Tipor tipo;
    private double cantidad;
    private double tasa;

    //metodos
    public Recurso(int id, Tipor tipo, double cantidad, double tasa) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = Math.max(0, cantidad);
        this.tasa = tasa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Tipor getTipo() { return tipo; }
    public void setTipo(Tipor tipo) { this.tipo = tipo; }
    public double getCantidad() { return cantidad; }
    public void setCantidad(double cantidad) {
        this.cantidad = Math.max(0, cantidad);
    }
    public double getTasa() { return tasa; }
    public void setTasa(double tasa) { this.tasa = tasa; }

    public void agregar(double monto) {
        if (monto > 0) {
            this.cantidad += monto;
        }
    }
    public boolean gastar(double monto) {
        if (monto <= 0) return false;
        if (!tieneSuficiente(monto)) return false;
        this.cantidad -= monto;
        return true;
    }
    public boolean tieneSuficiente(double monto) {
        return this.cantidad >= monto;
    }

}
