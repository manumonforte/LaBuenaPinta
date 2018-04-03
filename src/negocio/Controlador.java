package negocio;

import negocio.transfer.TCerveza;
import negocio.transfer.TEmpleado;
import negocio.transfer.TFactura;
import negocio.transfer.TMarca;

public interface Controlador {
	public boolean ejecutarCerveza(Acciones accion, TCerveza tCerveza);
	public boolean ejecutarEmpleado(Acciones accion, TEmpleado tEmpleado);
	public boolean ejecutarFactura(Acciones accion, TFactura tFactura);
	public boolean ejecutarMarca(Acciones accion, TMarca tMarca);
}
