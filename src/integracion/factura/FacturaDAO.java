package integracion.factura;



import integracion.DAO;
import presentacion.transfer.TFactura;

public interface FacturaDAO extends DAO<TFactura> {
	void devolver_producto(int id_factura, int id_empleado);
}
