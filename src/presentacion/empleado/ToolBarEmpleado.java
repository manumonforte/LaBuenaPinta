package presentacion.empleado;

import presentacion.factura.FormModificarFactura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarEmpleado extends JToolBar{

	public ToolBarEmpleado(){
		super();
		this.initGUI();
	}

	private void initGUI(){

		// crear empleado
		JButton botonCrear = new JButton("Crear Empleado", new ImageIcon("resources/images/add-32.png"));
		botonCrear.setToolTipText("Crear empleado");
		botonCrear.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonCrear.setHorizontalTextPosition(SwingConstants.CENTER);
		botonCrear.setPreferredSize(new Dimension(200, 58));
		botonCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormAltaEmpleado formAltaEmpleado = new FormAltaEmpleado();
				formAltaEmpleado.setVisible(true);
				//controlador.accion(Eventos.insertar_Empleado, null);
			}
		});

		// eliminar empleado
		JButton botonElimiar = new JButton("Eliminar Empleado", new ImageIcon("resources/images/remove-32.png"));
		botonElimiar.setToolTipText("Eliminar empleado");
		botonElimiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonElimiar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonElimiar.setPreferredSize(new Dimension(200, 58));
		botonElimiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormBajaEmpleado formBajaEmpleado = new FormBajaEmpleado();
				formBajaEmpleado.setVisible(true);
				//controlador.accion(Eventos.eliminar_Empleado, null);
			}
		});

		// mostrar empleado
		JButton botonMostrar = new JButton("Mostrar Empleado", new ImageIcon("resources/images/eye-32.png"));
		botonMostrar.setToolTipText("Mostrar empleado");
		botonMostrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonMostrar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonMostrar.setPreferredSize(new Dimension(200, 58));
		botonMostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormMostrarEmpleado formMostrarEmpleado = new FormMostrarEmpleado();
				formMostrarEmpleado.setVisible(true);
				//controlador.accion(Eventos.mostrar_Empleado, null);
			}
		});

		// modificar empleado
		JButton botonModificar = new JButton("Modificar Empleado", new ImageIcon("resources/images/edit-32.png"));
		botonModificar.setToolTipText("Modificar empleado");
		botonModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonModificar.setPreferredSize(new Dimension(200, 58));
		botonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormModificarEmpleado formModificarEmpleado = new FormModificarEmpleado();
				formModificarEmpleado.setVisible(true);
				//controlador.accion(Eventos.modificar_Empleado, null);
			}
		});

		this.add(botonCrear);
		this.add(botonModificar);
		this.add(botonMostrar);
		this.add(botonElimiar);
	}
}
