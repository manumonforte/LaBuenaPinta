package integracion.factoriaDAO;

import integracion.cerveza.CervezaDAO;
import integracion.cerveza.CervezaDAOImp;
import integracion.empleado.EmpleadoDAO;
import integracion.empleado.EmpleadoDAOImp;
import integracion.factura.FacturaDAO;
import integracion.factura.FacturaDAOImp;
import integracion.marca.MarcaDAO;
import integracion.marca.MarcaDAOImp;

public class FactoriaDAOImp extends FactoriaDAO {

	@Override
	public CervezaDAO getCervezaDAO() {
		return new CervezaDAOImp();
	}

	@Override
	public EmpleadoDAO getEmpleadoDAO() {
			return new EmpleadoDAOImp();
	}

	@Override
	public FacturaDAO getFacturaDAO() {
		return new FacturaDAOImp();
	}

	@Override
	public MarcaDAO getMarcaDAO() {
		return new MarcaDAOImp();
	}
}
