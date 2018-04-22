package presentacion.cerveza;

import presentacion.empleado.FormModificarEmpleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarCerveza extends  JToolBar{

	public ToolBarCerveza(){
		super();
		this.initGUI();
	}

	private void initGUI(){

		// crear marca
		JButton botonCrear = new JButton("Crear Cerveza",new ImageIcon("resources/images/add-32.png"));
		botonCrear.setToolTipText("Crear Cerveza");
		botonCrear.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonCrear.setHorizontalTextPosition(SwingConstants.CENTER);
		botonCrear.setPreferredSize(new Dimension(200, 58));
		botonCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormAltaCerveza formAltaCerveza = new FormAltaCerveza();
				formAltaCerveza.setVisible(true);
				//controlador.accion(Eventos.insertar_Cerveza, null);
			}
		});

		// eliminar marca
		JButton botonElimiar = new JButton("Eliminar Cerveza", new ImageIcon("resources/images/remove-32.png"));
		botonElimiar.setToolTipText("Eliminar Cerveza");
		botonElimiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonElimiar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonElimiar.setPreferredSize(new Dimension(200, 58));
		botonElimiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormBajaCerveza formBajaCerveza = new FormBajaCerveza();
				formBajaCerveza.setVisible(true);
				//controlador.accion(Eventos.eliminar_Cerveza, null);
			}
		});

		// mostrar marca
		JButton botonMostrar = new JButton("Mostrar Cerveza",new ImageIcon( "resources/images/eye-32.png"));
		botonMostrar.setToolTipText("Mostrar Cerveza");
		botonMostrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonMostrar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonMostrar.setPreferredSize(new Dimension(200, 58));
		botonMostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormMostrarCerveza formMostrarCerveza = new FormMostrarCerveza();
				formMostrarCerveza.setVisible(true);
				//controlador.accion(Eventos.mostrar_Cerveza, null);
			}
		});

		// modificar marca
		JButton botonModificar = new JButton("Modificar Cerveza", new ImageIcon("resources/images/edit-32.png"));
		botonModificar.setToolTipText("Modificar Cerveza");
		botonModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonModificar.setPreferredSize(new Dimension(200, 58));
		botonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormModificarCerveza formModificarCerveza = new FormModificarCerveza();
				formModificarCerveza.setVisible(true);
				//controlador.accion(Eventos.modificar_Cerveza, null);
			}
		});

		this.add(botonCrear);
		this.add(botonModificar);
		this.add(botonMostrar);
		this.add(botonElimiar);
	}
}
