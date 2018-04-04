package negocio;

import integracion.DAO.mariadb.MariadDBGestorDAO;
import negocio.transfer.TCerveza;
import negocio.transfer.TEmpleado;
import negocio.transfer.TFactura;
import negocio.transfer.TMarca;

public class ControladorImp implements Controlador{
	//TODO
	public boolean ejecutarCerveza(Acciones accion, TCerveza tCerveza){
		switch (accion) {
			case insertar:
				break;
			case mostrar:
				break;
			case mostraTodos:
				break;
			case modificar:
				break;
			case eliminar:
				break;
		}
		return false;
	}

	public boolean ejecutarEmpleado(Acciones accion, TEmpleado tEmpleado){
		switch (accion) {
			case insertar:
				break;
			case mostrar:
				break;
			case mostraTodos:
				break;
			case modificar:
				break;
			case eliminar:
				break;
		}
		return false;
	}

	public boolean ejecutarFactura(Acciones accion, TFactura tFactura){
		switch (accion) {
			case insertar:
				break;
			case mostrar:
				break;
			case mostraTodos:
				break;
			case modificar:
				break;
			case eliminar:
				break;
		}
		return false;
	}

	public boolean ejecutarMarca(Acciones accion, TMarca tMarca){
		switch (accion) {
			case insertar:
				break;
			case mostrar:
				break;
			case mostraTodos:
				break;
			case modificar:
				break;
			case eliminar:
				break;
		}
		return false;
	}
}
