package integracion.factura;


import integracion.DAO;
import negocio.cerveza.TCerveza;
import negocio.factura.TFactura;
import negocio.factura.TLineaFactura;

public interface FacturaDAO extends DAO<TFactura> {
	void anadirProducto(TLineaFactura lineaFactura, TCerveza c);

	void cerrar(int id);
}
