package presentacion.marca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarMarca extends JToolBar {

	public ToolBarMarca(){
		initGUI();
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}

	private void initGUI() {
		// crear marca
		JButton botonCrear = new JButton("Crear Marca",new ImageIcon("resources/images/add-32.png"));
		botonCrear.setToolTipText("Crear marca");
		botonCrear.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonCrear.setHorizontalTextPosition(SwingConstants.CENTER);
		botonCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormAltaMarca formAltaMarca = new FormAltaMarca();
				formAltaMarca.setVisible(true);
				//controlador.accion(Eventos.insertar_Marca, null);
			}
		});

		// eliminar marca
		JButton botonElimiar = new JButton("Eliminar Marca", new ImageIcon("resources/images/remove-32.png"));
		botonElimiar.setToolTipText("Eliminar marca");
		botonElimiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonElimiar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonElimiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormBajaMarca formBajaMarca = new FormBajaMarca();
				formBajaMarca.setVisible(true);
				//controlador.accion(Eventos.eliminar_Marca, null);
			}
		});

		// mostrar marca
		JButton botonMostrar = new JButton("Mostrar Marca",new ImageIcon( "resources/images/eye-32.png"));
		botonMostrar.setToolTipText("Mostrar marca");
		botonMostrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonMostrar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonMostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormMostrarMarca formMostrarMarca = new FormMostrarMarca();
				formMostrarMarca.setVisible(true);
				//controlador.accion(Eventos.mostrar_Marca, null);
			}
		});

		// modificar marca
		JButton botonModificar = new JButton("Modificar Marca", new ImageIcon("resources/images/edit-32.png"));
		botonModificar.setToolTipText("Modificar marca");
		botonModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormModificarMarca formModificarMarca = new FormModificarMarca();
				formModificarMarca.setVisible(true);
				//controlador.accion(Eventos.modificar_Marca, null);
			}
		});

		add(botonCrear);
		add(botonModificar);
		add(botonMostrar);
		add(botonElimiar);
	}
}
