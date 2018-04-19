package presentacion;

import presentacion.controlador.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar {

	public ToolBar(VentanaPrincipal ventanaPrincipal, Controlador controlador) {
		// crear
		JButton botonCrear = new JButton(new ImageIcon("resources/images/add-32.png"));
		botonCrear.setToolTipText("Carga un fichero de ventos");
		botonCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//IMPLEMENTAR
			}
		});

		// eliminar
		JButton botonElimiar = new JButton(new ImageIcon("resources/images/remove-32.png"));
		botonElimiar.setToolTipText("Carga un fichero de ventos");
		botonElimiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//IMPLEMENTAR
			}
		});

		// mostrar
		JButton botonMostrar = new JButton(new ImageIcon("resources/images/eye-32.png"));
		botonMostrar.setToolTipText("Carga un fichero de ventos");
		botonMostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// IMPLEMENTAR
			}
		});

		// modificar
		JButton botonCModificar = new JButton(new ImageIcon("resources/images/edit-32.png"));
		botonCModificar.setToolTipText("Carga un fichero de ventos");
		botonCModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		add(botonCrear);
		add(botonCModificar);
		add(botonMostrar);
		add(botonElimiar);
	}
}