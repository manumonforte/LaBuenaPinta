package negocio.InterfacesSA;

import presentacion.transfer.TEmpleado;

import java.util.List;

public interface EmpleadoSA {

	boolean insertar_emplado(TEmpleado tEmpleado);

	TEmpleado mostrar_empleado(TEmpleado tEmpleado);

	List<TEmpleado> mostrar_todos_empleado();

	boolean modificar_empleado(TEmpleado tEmpleado);

	boolean baja_empleado(TEmpleado tEmpleado);

}