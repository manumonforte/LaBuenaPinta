package presentacion.cerveza;

import presentacion.PanelTabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarCerveza extends  JToolBar{

	public ToolBarCerveza(PanelTabs panelTabs){
		initGUI(panelTabs);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(new Color(240,240,240));
	}

	private void initGUI(PanelTabs panelTabs){
		// crear cerveza
		JButton botonCrear = new JButton("Crear Cerveza",new ImageIcon("resources/images/add-32.png"));
		botonCrear.setToolTipText("Crear Cerveza");
		botonCrear.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonCrear.setHorizontalTextPosition(SwingConstants.CENTER);
		botonCrear.setBorder(BorderFactory.createEmptyBorder());
		botonCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormAltaCerveza formAltaCerveza = new FormAltaCerveza();
				formAltaCerveza.setVisible(true);
			}
		});

		// eliminar cerveza
		JButton botonElimiar = new JButton("Eliminar Cerveza", new ImageIcon("resources/images/remove-32.png"));
		botonElimiar.setToolTipText("Eliminar Cerveza");
		botonElimiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonElimiar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonElimiar.setBorder(BorderFactory.createEmptyBorder());
		botonElimiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormBajaCerveza formBajaCerveza = new FormBajaCerveza();
				formBajaCerveza.setVisible(true);
			}
		});

		// mostrar cerveza
		JButton botonMostrar = new JButton("Mostrar Cerveza",new ImageIcon( "resources/images/eye-32.png"));
		botonMostrar.setToolTipText("Mostrar Cerveza");
		botonMostrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonMostrar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonMostrar.setBorder(BorderFactory.createEmptyBorder());
		botonMostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormMostrarCerveza formMostrarCerveza = new FormMostrarCerveza();
				formMostrarCerveza.setVisible(true);
			}
		});

		// modificar cerveza
		JButton botonModificar = new JButton("Modificar Cerveza", new ImageIcon("resources/images/edit-32.png"));
		botonModificar.setToolTipText("Modificar Cerveza");
		botonModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonModificar.setBorder(BorderFactory.createEmptyBorder());
		botonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormModificarCerveza formModificarCerveza = new FormModificarCerveza();
				formModificarCerveza.setVisible(true);
			}
		});

		// actualizar cerveza
		JButton botonactualizar = new JButton("Actualizar cerveza", new ImageIcon("resources/images/refresh-32.png"));
		botonactualizar.setToolTipText("Actualizar cerveza");
		botonactualizar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonactualizar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonactualizar.setBorder(BorderFactory.createEmptyBorder());
		botonactualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelTabs.actualizarCerveza();
			}
		});

		add(botonCrear);
		addSeparator();
		add(botonModificar);
		addSeparator();
		add(botonMostrar);
		addSeparator();
		add(botonElimiar);
		addSeparator();
		add(botonactualizar);
	}
}
