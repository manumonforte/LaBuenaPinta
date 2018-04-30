package presentacion.controlador;

import negocio.factoria.FactoriaSA;
import presentacion.transfer.TCerveza;
import presentacion.transfer.TEmpleado;
import presentacion.transfer.TFactura;
import presentacion.transfer.TMarca;

public class ControladorImp extends Controlador {

	@Override
	public void accion(Eventos evento, Object datos) {
		switch (evento) {//TODO lanzar JDialog con cada resultado
			case insertar_Marca:
				FactoriaSA.getInstancia().generarSAMarca().insertar_marca((TMarca) datos);
				break;
			case mostrar_Marca:
				FactoriaSA.getInstancia().generarSAMarca().mostrar_marca((TMarca) datos);
				break;
			case mostraTodos_Marca:
				FactoriaSA.getInstancia().generarSAMarca().mostrar_todos_marca();
				break;
			case modificar_Marca:
				FactoriaSA.getInstancia().generarSAMarca().modificar_marca((TMarca) datos);
				break;
			case eliminar_Marca:
				FactoriaSA.getInstancia().generarSAMarca().baja_marca((TMarca) datos);
				break;
			case insertar_Cerveza:
				FactoriaSA.getInstancia().generarSACerveza().insertar_cerveza((TCerveza) datos);
				break;
			case mostrar_Cerveza:
				FactoriaSA.getInstancia().generarSACerveza().mostrar_cerveza((TCerveza) datos);
				break;
			case mostraTodos_Cerveza:
				FactoriaSA.getInstancia().generarSACerveza().mostrar_todos_cerveza();
				break;
			case modificar_Cerveza:
				FactoriaSA.getInstancia().generarSACerveza().modificar_cerveza((TCerveza) datos);
				break;
			case eliminar_Cerveza:
				FactoriaSA.getInstancia().generarSACerveza().baja_cerveza((TCerveza) datos);
				break;
			case insertar_Empleado:
				FactoriaSA.getInstancia().generarSAEmpleado().insertar_emplado((TEmpleado) datos);
				break;
			case mostrar_Empleado:
				FactoriaSA.getInstancia().generarSAEmpleado().mostrar_empleado((TEmpleado) datos);
				break;
			case mostraTodos_Empleado:
				FactoriaSA.getInstancia().generarSAEmpleado().mostrar_todos_empleado();
				break;
			case modificar_Empleado:
				FactoriaSA.getInstancia().generarSAEmpleado().modificar_empleado((TEmpleado) datos);
				break;
			case eliminar_Empleado:
				FactoriaSA.getInstancia().generarSAEmpleado().baja_empleado((TEmpleado) datos);
				break;
			case insertar_Factura:
				FactoriaSA.getInstancia().generarSAFactura().insertar_factura((TFactura) datos);
				break;
			case mostrar_Factura:
				FactoriaSA.getInstancia().generarSAFactura().mostrar_factura((TFactura) datos);
				break;
			case mostraTodos_Factura:
				FactoriaSA.getInstancia().generarSAFactura().mostrar_todos_factura();
				break;
			case modificar_Factura:
				FactoriaSA.getInstancia().generarSAFactura().modificar_factura((TFactura) datos);
				break;
			case eliminar_Factura:
				FactoriaSA.getInstancia().generarSAFactura().baja_factura((TFactura) datos);
				break;
		}
	}
}
