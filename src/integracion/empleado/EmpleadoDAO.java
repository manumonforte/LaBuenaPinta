package integracion.empleado;

import integracion.DAO;
import negocio.empleado.TEmpleado;

public interface EmpleadoDAO extends DAO<TEmpleado> {
	TEmpleado mostrarPorDNI(String DNI);

}
