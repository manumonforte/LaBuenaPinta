package presentacion.controlador;

import negocio.factoria.FactoriaSA;
import presentacion.cerveza.TCerveza;
import presentacion.empleado.TEmpleado;
import presentacion.factura.TFactura;
import presentacion.marca.TMarca;

import javax.swing.*;
import java.util.List;

public class ControladorImp extends Controlador {

	@Override
	public void accion(Eventos evento, Object datos) {
		switch (evento) {
			case insertar_Marca:
				if (FactoriaSA.getInstancia().generarSAMarca().insertar_marca((TMarca) datos)) {
					JOptionPane.showMessageDialog(null, "Marca registrada con exito");
				} else {
					JOptionPane.showMessageDialog(null, "Marca no registrada");
				}
				break;
			case mostrar_Marca:
				TMarca marcaMostrar = FactoriaSA.getInstancia().generarSAMarca().mostrar_marca((TMarca) datos);
				if (marcaMostrar != null) {
					JOptionPane.showMessageDialog(null, marcaMostrar.toString());
				} else {
					JOptionPane.showMessageDialog(null, "El ID de la marca no existe");
				}
				break;
			case mostraTodos_Marca:
				List listaMarca = (List) datos;
				listaMarca.addAll(FactoriaSA.getInstancia().generarSAMarca().mostrar_todos_marca());
				break;
			case modificar_Marca:
				if (FactoriaSA.getInstancia().generarSAMarca().modificar_marca((TMarca) datos)) {
					JOptionPane.showMessageDialog(null, "Marca modificada con exito");
				} else {
					JOptionPane.showMessageDialog(null, "Marca no modificada");
				}
				break;
			case eliminar_Marca:
				if (FactoriaSA.getInstancia().generarSAMarca().baja_marca((TMarca) datos)) {
					JOptionPane.showMessageDialog(null, "Marca eliminada con exito");
				} else {
					JOptionPane.showMessageDialog(null, "Marca no eliminada");
				}
				break;
			case insertar_Cerveza:
				if (FactoriaSA.getInstancia().generarSACerveza().insertar_cerveza((TCerveza) datos)) {
					JOptionPane.showMessageDialog(null, "Cerveza registrada con exito");
				} else {
					JOptionPane.showMessageDialog(null, "Cerveza no registrada");
				}
				break;
			case mostrar_Cerveza:
				TCerveza cervezaMostrar = FactoriaSA.getInstancia().generarSACerveza().mostrar_cerveza((TCerveza) datos);
				if (cervezaMostrar != null) {
					JOptionPane.showMessageDialog(null, cervezaMostrar.toString());
				} else {
					JOptionPane.showMessageDialog(null, "El ID de la cerveza no existe");
				}
				break;
			case mostraTodos_Cerveza:
				List listCerveza = (List) datos;
				listCerveza.addAll(FactoriaSA.getInstancia().generarSACerveza().mostrar_todos_cerveza());
				break;
			case modificar_Cerveza:
				if (FactoriaSA.getInstancia().generarSACerveza().modificar_cerveza((TCerveza) datos)) {
					JOptionPane.showMessageDialog(null, "Cerveza modificada con exito");
				} else {
					JOptionPane.showMessageDialog(null, "Cerveza no modificada");
				}
				break;
			case eliminar_Cerveza:
				if (FactoriaSA.getInstancia().generarSACerveza().baja_cerveza((TCerveza) datos)) {
					JOptionPane.showMessageDialog(null, "Cerveza eliminada con exito");
				} else {
					JOptionPane.showMessageDialog(null, "Cerveza no eliminada");
				}
				break;
			case insertar_Empleado:
				if (FactoriaSA.getInstancia().generarSAEmpleado().insertar_emplado((TEmpleado) datos)) {
					JOptionPane.showMessageDialog(null, "Empleado registrado con exito");
				} else {
					JOptionPane.showMessageDialog(null, "Empleado no eliminado");
				}
				break;
			case mostrar_Empleado:
				TEmpleado empleadoMostrar = FactoriaSA.getInstancia().generarSAEmpleado().mostrar_empleado((TEmpleado) datos);
				if (empleadoMostrar != null) {
					JOptionPane.showMessageDialog(null, empleadoMostrar.toString());
				} else {
					JOptionPane.showMessageDialog(null, "El ID del empleado no existe");
				}
				break;
			case mostraTodos_Empleado:
				List listaEmpleado = (List) datos;
				listaEmpleado.addAll(FactoriaSA.getInstancia().generarSAEmpleado().mostrar_todos_empleado());
				break;
			case modificar_Empleado:
				if (FactoriaSA.getInstancia().generarSAEmpleado().modificar_empleado((TEmpleado) datos)) {
					JOptionPane.showMessageDialog(null, "Empleado modificado con exito");
				} else {
					JOptionPane.showMessageDialog(null, "Empleado no modificado");
				}
				break;
			case eliminar_Empleado:
				if (FactoriaSA.getInstancia().generarSAEmpleado().baja_empleado((TEmpleado) datos)) {
					JOptionPane.showMessageDialog(null, "Empleado eliminado con exito");
				} else {
					JOptionPane.showMessageDialog(null, "Empleado no eliminado");
				}
				break;
			case insertar_Factura:
				if (FactoriaSA.getInstancia().generarSAFactura().insertar_factura((TFactura) datos)) {
					JOptionPane.showMessageDialog(null, "Factura generada con exito");
				} else {
					JOptionPane.showMessageDialog(null, "Factura no generada");
				}
				break;
			case mostrar_Factura:
				TFactura facturaMostrar = FactoriaSA.getInstancia().generarSAFactura().mostrar_factura((TFactura) datos);
				if (facturaMostrar != null) {
					JOptionPane.showMessageDialog(null, facturaMostrar.toString());
				} else {
					JOptionPane.showMessageDialog(null, "El ID de la marca no existe");
				}
				break;
			case mostraTodos_Factura:
				List listaFactura = (List) datos;
				listaFactura.addAll(FactoriaSA.getInstancia().generarSAFactura().mostrar_todos_factura());
				break;
			case modificar_Factura:
				if (FactoriaSA.getInstancia().generarSAFactura().modificar_factura((TFactura) datos)) {
					JOptionPane.showMessageDialog(null, "Factura modificada con exito");
				} else {
					JOptionPane.showMessageDialog(null, "Factura no modificada");
				}
				break;
			case eliminar_Factura:
				if (FactoriaSA.getInstancia().generarSAFactura().baja_factura((TFactura) datos)) {
					JOptionPane.showMessageDialog(null, "Factura eliminada con exito");
				} else {
					JOptionPane.showMessageDialog(null, "Factura no eliminada");
				}
				break;
		}
	}
}
