package negocio;

import negocio.transfer.TCerveza;
import negocio.transfer.TEmpleado;
import negocio.transfer.TFactura;
import negocio.transfer.TMarca;

public interface Controlador {
	public void ejecutarCerveza(Acciones accion, TCerveza tCerveza);
	public void ejecutarEmpleado(Acciones accion, TEmpleado tEmpleado);
	public void ejecutarFactura(Acciones accion, TFactura tFactura);
	public void ejecutarMarca(Acciones accion, TMarca tMarca);
}
