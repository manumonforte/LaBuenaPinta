package integracion.DAO.interfaces;


import negocio.transfer.TCerveza;
import negocio.transfer.TFactura;

public interface FacturaDAO extends DAO<TFactura> {
	public void devolver_producto(int id_factura, int id_empleado);
}
