package negocio.SA;

import negocio.InterfacesSA.EmpleadoSA;
import presentacion.transfer.TEmpleado;

import java.util.List;

public class EmpleadoSAImp implements EmpleadoSA {//TODO
	@Override
	public boolean insertar_emplado(TEmpleado tEmpleado) {
		return false;
	}

	@Override
	public TEmpleado mostrar_empleado(TEmpleado tEmpleado) {
		return null;
	}

	@Override
	public List<TEmpleado> mostrar_todos_empleado() {
		return null;
	}

	@Override
	public boolean modificar_empleado(TEmpleado tEmpleado) {
		return false;
	}

	@Override
	public boolean baja_empleado(TEmpleado tEmpleado) {
		return false;
	}
}
