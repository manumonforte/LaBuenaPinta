package integracion.empleado;

import integracion.DAO;
import presentacion.empleado.TEmpleado;

public interface EmpleadoDAO extends DAO<TEmpleado> {
	TEmpleado mostrarPorDNI(String DNI);

}
