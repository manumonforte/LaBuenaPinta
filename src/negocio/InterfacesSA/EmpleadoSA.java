package negocio.InterfacesSA;

import negocio.transfer.TEmpleado;

public interface EmpleadoSA {

	public boolean insertar_emplado(TEmpleado tEmpleado);

	public boolean mostrar_empleado((TEmpleado tEmpleado);

	public boolean mostrar_todos_empleado(TEmpleado tEmpleado);

	public boolean modificar_empleado(TEmpleado tEmpleado);

	public boolean baja_empleado(TEmpleado tEmpleado);

}