package presentacion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import presentacion.controlador.Controlador;

public class Menu extends JMenuBar {

	public Menu(VentanaPrincipal ventanaPrincipal, Controlador controlador) {
		super();

		this.setBackground(new Color(255, 255, 255));

		// Create
		JMenu create = new JMenu("Crear");
		this.add(create);
		this.addCreateMenu(create, ventanaPrincipal);

		//Delete
		JMenu delete = new JMenu("Eliminar");
		this.add(delete);
		this.addDeleteMenu(delete, ventanaPrincipal);
		
		//Modify
		JMenu modify = new JMenu("Modificar");
		this.add(modify);
		this.addModifyMenu(modify, ventanaPrincipal);
	}
	
	private void addCreateMenu(JMenu jMenu, VentanaPrincipal ventanaPrincipal){
		JMenuItem crearMarca = new JMenuItem("Crear Marca");
		crearMarca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// IMPLEMENTAR ACCION CREAR MARCA
			}
		});

		JMenuItem crearCerveza = new JMenuItem("Crear Cerveza");
		crearCerveza.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// IMPLEMENTAR ACCION CREAR CERVERZA
			}
		});

		JMenuItem crearEmpleado = new JMenuItem("Crear Empleado");
		crearEmpleado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// IMPLEMENTAR ACCION CREAR EMPLEADDO
			}
		});

		JMenuItem crearFactura = new JMenuItem("Crear Factura");
		crearFactura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// IMPLEMENTAR ACCION CREAR FACURA
			}
		});

		jMenu.add(crearMarca);
		jMenu.add(crearCerveza);
		jMenu.add(crearEmpleado);
		jMenu.add(crearFactura);
	}
	
	public void addDeleteMenu(JMenu jMenu, VentanaPrincipal ventanaPrincipal) {
		JMenuItem eliminarMarca = new JMenuItem("Eliminar Marca");
		eliminarMarca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// IMPLEMENTAR ACCION ELIMINAR MARCA
			}
		});

		JMenuItem eliminarCerveza = new JMenuItem("Eliminar Cerveza");
		eliminarCerveza.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// IMPLEMENTAR ACCION ELIMINAR CERVERZA
			}
		});

		JMenuItem eliminarEmpleado = new JMenuItem("Eliminar Empleado");
		eliminarEmpleado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// IMPLEMENTAR ACCION ELIMINAR EMPLEADO
			}
		});

		JMenuItem eliminarFactura = new JMenuItem("Eliminar Factura");
		eliminarFactura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// IMPLEMENTAR ACCION ELIMINAR FACTURA
			}
		});

		jMenu.add(eliminarMarca);
		jMenu.add(eliminarCerveza);
		jMenu.add(eliminarEmpleado);
		jMenu.add(eliminarFactura);
	}
	
	public void addModifyMenu(JMenu jMenu, VentanaPrincipal ventanaPrincipal) {
		JMenuItem modificarMarca = new JMenuItem("Modificar Marca");
		modificarMarca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// IMPLEMENTAR ACCION ELIMINAR MARCA
			}
		});

		JMenuItem modificarCerveza = new JMenuItem("Modificar Cerveza");
		modificarCerveza.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// IMPLEMENTAR ACCION ELIMINAR CERVERZA
			}
		});

		JMenuItem modificarEmpleado = new JMenuItem("Modificar Empleado");
		modificarEmpleado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// IMPLEMENTAR ACCION ELIMINAR EMPLEADO
			}
		});

		JMenuItem modificarFactura = new JMenuItem("Modificar Factura");
		modificarFactura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// IMPLEMENTAR ACCION ELIMINAR FACTURA
			}
		});

		jMenu.add(modificarMarca);
		jMenu.add(modificarCerveza);
		jMenu.add(modificarEmpleado);
		jMenu.add(modificarFactura);
	}
}
