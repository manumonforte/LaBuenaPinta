package integracion.factoriaDAO;

import integracion.marca.MarcaDAO;
import integracion.cerveza.CervezaDAO;
import integracion.empleado.EmpleadoDAO;
import integracion.factura.FacturaDAO;

public abstract class FactoriaDAO {
	private static FactoriaDAO instancia = null;

	public abstract CervezaDAO getCervezaDAO();

	public abstract EmpleadoDAO getEmpleadoDAO();

	public abstract FacturaDAO getFacturaDAO();

	public abstract MarcaDAO getMarcaDAO();

	public static FactoriaDAO getInstancia() {
		if (instancia == null) {
			instancia = new FactoriaDAOImp();
		}
		return instancia;
	}
}
