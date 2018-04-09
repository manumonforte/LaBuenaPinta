package negocio;

import negocio.transfer.TCerveza;
import negocio.transfer.TEmpleado;
import negocio.transfer.TFactura;
import negocio.transfer.TMarca;

public interface Controlador {
	void ejecutarCerveza(Acciones accion, TCerveza tCerveza);

	void ejecutarEmpleado(Acciones accion, TEmpleado tEmpleado);

	void ejecutarFactura(Acciones accion, TFactura tFactura);

	void ejecutarMarca(Acciones accion, TMarca tMarca);
}
