package negocio.SA;

import integracion.factoriaDAO.FactoriaDAOImp;
import negocio.InterfacesSA.EmpleadoSA;
import presentacion.transfer.TEmpleado;

import java.util.List;

public class EmpleadoSAImp implements EmpleadoSA {
	@Override
	public boolean insertar_emplado(TEmpleado tEmpleado) {
		TEmpleado tl = FactoriaDAOImp.getInstancia().getEmpleadoDAO().mostrarPorDNI(tEmpleado.getDNI());

		if (tl == null){
			FactoriaDAOImp.getInstancia().getEmpleadoDAO().insertar(tEmpleado);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TEmpleado mostrar_empleado(TEmpleado tEmpleado) {
		return FactoriaDAOImp.getInstancia().getEmpleadoDAO().mostrar(tEmpleado.getId_empleado());
	}

	@Override
	public List<TEmpleado> mostrar_todos_empleado() {
		return FactoriaDAOImp.getInstancia().getEmpleadoDAO().mostrarTodos();

	}

	@Override
	public boolean modificar_empleado(TEmpleado tEmpleado) {
		TEmpleado tl = FactoriaDAOImp.getInstancia().getEmpleadoDAO().mostrar(tEmpleado.getId_empleado());

		if (tl == null) {
			return false;
		} else if (FactoriaDAOImp.getInstancia().getEmpleadoDAO().mostrarPorDNI(tEmpleado.getDNI()).getId_empleado()
				!= tl.getId_empleado()) {
			return false;
		} else {
			FactoriaDAOImp.getInstancia().getEmpleadoDAO().modificar(tEmpleado);
			return true;
		}
	}

	@Override
	public boolean baja_empleado(TEmpleado tEmpleado) {
		TEmpleado tl = FactoriaDAOImp.getInstancia().getEmpleadoDAO().mostrar(tEmpleado.getId_empleado());

		if (tl == null){
			return false;
		} else {
			FactoriaDAOImp.getInstancia().getEmpleadoDAO().eliminar(tEmpleado.getId_empleado());
			return true;
		}
	}
}
