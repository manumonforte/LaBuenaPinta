package presentacion.factura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//NOTA: EL FORMULARIO DE DEVOLVER PRODUCTO NO ES CORRECTO

public class ToolbarFactura extends JToolBar {

	public ToolbarFactura() {
		super();
		this.initGUI();
	}

	private void initGUI() {

		// crear marca
		JButton botonCrear = new JButton("Crear Factura",new ImageIcon("resources/images/add-32.png"));
		botonCrear.setToolTipText("Crear Factura");
		botonCrear.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonCrear.setHorizontalTextPosition(SwingConstants.CENTER);
		botonCrear.setPreferredSize(new Dimension(200, 58));
		botonCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormAltaFactura formAltaFactura = new FormAltaFactura();
				formAltaFactura.setVisible(true);
				//controlador.accion(Eventos.insertar_Factura, null);
			}
		});

		// eliminar marca
		JButton botonElimiar = new JButton("Eliminar Factura", new ImageIcon("resources/images/remove-32.png"));
		botonElimiar.setToolTipText("Eliminar Factura");
		botonElimiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonElimiar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonElimiar.setPreferredSize(new Dimension(200, 58));
		botonElimiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormBajaFactura formBajaFactura = new FormBajaFactura();
				formBajaFactura.setVisible(true);
				//controlador.accion(Eventos.eliminar_Factura, null);
			}
		});

		// mostrar marca
		JButton botonMostrar = new JButton("Mostrar Factura",new ImageIcon( "resources/images/eye-32.png"));
		botonMostrar.setToolTipText("Mostrar Factura");
		botonMostrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonMostrar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonMostrar.setPreferredSize(new Dimension(200, 58));
		botonMostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormMostrarFactura formMostrarFactura = new FormMostrarFactura();
				formMostrarFactura.setVisible(true);
				//controlador.accion(Eventos.mostrar_Factura, null);
			}
		});

		// modificar marca
		JButton botonModificar = new JButton("Modificar Factura", new ImageIcon("resources/images/edit-32.png"));
		botonModificar.setToolTipText("Modificar Factura");
		botonModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonModificar.setPreferredSize(new Dimension(200, 58));
		botonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormModificarFactura formModificarFactura = new FormModificarFactura();
				formModificarFactura.setVisible(true);
				//controlador.accion(Eventos.modificar_Factura, null);
			}
		});

		JButton botonDevolverProd= new JButton("Devolver Producto", new ImageIcon("resources/images/return-32.png"));
		botonDevolverProd.setToolTipText("Modificar Factura");
		botonDevolverProd.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonDevolverProd.setHorizontalTextPosition(SwingConstants.CENTER);
		botonDevolverProd.setPreferredSize(new Dimension(200, 58));
		botonDevolverProd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormDevolverProducto formDevolverProducto = new FormDevolverProducto();
				formDevolverProducto.setVisible(true);
				//controlador.accion(Eventos.devolver_Producto, null);
			}
		});

		this.add(botonCrear);
		this.add(botonModificar);
		this.add(botonMostrar);
		this.add(botonElimiar);
		this.add(botonDevolverProd);
	}
}