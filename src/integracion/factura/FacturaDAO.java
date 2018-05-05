package integracion.factura;



import integracion.DAO;
import presentacion.cerveza.TCerveza;
import presentacion.factura.TFactura;
import presentacion.factura.TLineaFactura;

public interface FacturaDAO extends DAO<TFactura> {

	void anadirProducto(TLineaFactura lineaFactura, TCerveza c);

}
