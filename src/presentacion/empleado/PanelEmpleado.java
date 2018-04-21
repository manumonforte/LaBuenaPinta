package presentacion.empleado;

import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEmpleado extends JPanel {

	private Controlador controlador;
	private JToolBar toolBarEmpleado;
	private JDialog panelFormAlta;
	private JDialog panelFormBaja;
	private JDialog panelFormMostrar;
	private JDialog panelFormModificar;

	public PanelEmpleado(Controlador controlador){
		super();
		this.controlador = controlador;
		this.setLayout(new BorderLayout());
		this.add(toolBarEmpleado(), BorderLayout.NORTH);
	}

	private JToolBar toolBarEmpleado() {

		toolBarEmpleado = new JToolBar();

		// crear empleado
		JButton botonCrear = new JButton("Crear Empleado", new ImageIcon("resources/images/add-32.png"));
		botonCrear.setToolTipText("Crear empleado");
		botonCrear.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonCrear.setHorizontalTextPosition(SwingConstants.CENTER);
		botonCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.accion(Eventos.insertar_Empleado, null);
			}
		});

		// eliminar empleado
		JButton botonElimiar = new JButton("Eliminar Empleado", new ImageIcon("resources/images/remove-32.png"));
		botonElimiar.setToolTipText("Eliminar empleado");
		botonElimiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonElimiar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonElimiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.accion(Eventos.eliminar_Empleado, null);
			}
		});

		// mostrar empleado
		JButton botonMostrar = new JButton("Mostrar Empleado", new ImageIcon("resources/images/eye-32.png"));
		botonMostrar.setToolTipText("Mostrar empleado");
		botonMostrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonMostrar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonMostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.accion(Eventos.mostrar_Empleado, null);
			}
		});

		// modificar empleado
		JButton botonModificar = new JButton("Modificar Empleado", new ImageIcon("resources/images/edit-32.png"));
		botonModificar.setToolTipText("Modificar empleado");
		botonModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.accion(Eventos.modificar_Empleado, null);
			}
		});

		toolBarEmpleado.add(botonCrear);
		toolBarEmpleado.add(botonModificar);
		toolBarEmpleado.add(botonMostrar);
		toolBarEmpleado.add(botonElimiar);

		return  toolBarEmpleado;
	}
}

