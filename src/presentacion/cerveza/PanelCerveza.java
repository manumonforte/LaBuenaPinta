package presentacion.cerveza;

import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCerveza extends JPanel {

	private Controlador controlador;
	private JToolBar toolBarCerveza;
	private JDialog panelFormAlta;
	private JDialog panelFormBaja;
	private JDialog panelFormMostrar;
	private JDialog panelFormModificar;

	public PanelCerveza(Controlador controlador){
		super();
		this.controlador = controlador;
		this.setLayout(new BorderLayout());
		this.add(toolBarCerveza(), BorderLayout.NORTH);
	}

	private JToolBar toolBarCerveza() {

		toolBarCerveza = new JToolBar();

		// crear marca
		JButton botonCrear = new JButton("Crear Cerveza",new ImageIcon("resources/images/add-32.png"));
		botonCrear.setToolTipText("Crear Cerveza");
		botonCrear.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonCrear.setHorizontalTextPosition(SwingConstants.CENTER);
		botonCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.accion(Eventos.insertar_Cerveza, null);
			}
		});

		// eliminar marca
		JButton botonElimiar = new JButton("Eliminar Cerveza", new ImageIcon("resources/images/remove-32.png"));
		botonElimiar.setToolTipText("Eliminar Cerveza");
		botonElimiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonElimiar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonElimiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.accion(Eventos.eliminar_Cerveza, null);
			}
		});

		// mostrar marca
		JButton botonMostrar = new JButton("Mostrar Cerveza",new ImageIcon( "resources/images/eye-32.png"));
		botonMostrar.setToolTipText("Mostrar Cerveza");
		botonMostrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonMostrar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonMostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.accion(Eventos.mostrar_Cerveza, null);
			}
		});

		// modificar marca
		JButton botonModificar = new JButton("Modificar Cerveza", new ImageIcon("resources/images/edit-32.png"));
		botonModificar.setToolTipText("Modificar Cerveza");
		botonModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.accion(Eventos.modificar_Cerveza, null);
			}
		});

		toolBarCerveza.add(botonCrear);
		toolBarCerveza.add(botonModificar);
		toolBarCerveza.add(botonMostrar);
		toolBarCerveza.add(botonElimiar);

		return toolBarCerveza;
	}
}
