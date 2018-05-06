package presentacion.factura;

public class TLineaFactura {

    private int id_factura;
    private int id_cerveza;
    private int cantidad;

    public TLineaFactura(){};

    public TLineaFactura(int id_factura, int id_cerveza, int cantidad){
        this.id_factura = id_factura;
        this.id_cerveza = id_cerveza;
        this.cantidad = cantidad;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }
    public int getId_cerveza() {
        return id_cerveza;
    }

    public void setId_cerveza(int id_cerveza) {
        this.id_cerveza = id_cerveza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "-->"
                +"Cerveza: "+getId_cerveza() + " "
                +"Cantidad: "+getCantidad()+"\n";
    }
}
