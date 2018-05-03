package presentacion.factura;

import presentacion.PanelTabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//NOTA: EL FORMULARIO DE DEVOLVER PRODUCTO NO ES CORRECTO

public class ToolbarFactura extends JToolBar {

	public ToolbarFactura(PanelTabs panelTabs) {
		initGUI(panelTabs);
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}

	private void initGUI(PanelTabs panelTabs) {
		// crear factura
		JButton botonCrear = new JButton("Crear Factura",new ImageIcon("resources/images/add-32.png"));
		botonCrear.setToolTipText("Crear Factura");
		botonCrear.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonCrear.setHorizontalTextPosition(SwingConstants.CENTER);
		botonCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormAltaFactura formAltaFactura = new FormAltaFactura();
				formAltaFactura.setVisible(true);
			}
		});

		// eliminar factura
		JButton botonElimiar = new JButton("Eliminar Factura", new ImageIcon("resources/images/remove-32.png"));
		botonElimiar.setToolTipText("Eliminar Factura");
		botonElimiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonElimiar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonElimiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormBajaFactura formBajaFactura = new FormBajaFactura();
				formBajaFactura.setVisible(true);
			}
		});

		// mostrar factura
		JButton botonMostrar = new JButton("Mostrar Factura",new ImageIcon( "resources/images/eye-32.png"));
		botonMostrar.setToolTipText("Mostrar Factura");
		botonMostrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonMostrar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonMostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormMostrarFactura formMostrarFactura = new FormMostrarFactura();
				formMostrarFactura.setVisible(true);
			}
		});

		// modificar factura
		JButton botonModificar = new JButton("Modificar Factura", new ImageIcon("resources/images/edit-32.png"));
		botonModificar.setToolTipText("Modificar Factura");
		botonModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormModificarFactura formModificarFactura = new FormModificarFactura();
				formModificarFactura.setVisible(true);
			}
		});

		// devolver producto
		JButton botonDevolverProd= new JButton("Devolver Producto", new ImageIcon("resources/images/return-32.png"));
		botonDevolverProd.setToolTipText("Modificar Factura");
		botonDevolverProd.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonDevolverProd.setHorizontalTextPosition(SwingConstants.CENTER);
		botonDevolverProd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormDevolverProducto formDevolverProducto = new FormDevolverProducto();
				formDevolverProducto.setVisible(true);
			}
		});

		// actualizar factura
		JButton botonactualizar = new JButton("Actualizar factura");
		botonactualizar.setToolTipText("Actualizar factura");
		botonactualizar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonactualizar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonactualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelTabs.actualizarFactura();
			}
		});

		add(botonCrear);
		add(botonModificar);
		add(botonMostrar);
		add(botonElimiar);
		add(botonDevolverProd);
		add(botonactualizar);
	}
}
