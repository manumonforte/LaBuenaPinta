package presentacion.factura;

import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//devolver producto

public class PanelFactura extends JPanel {

	private Controlador controlador;
	private JToolBar toolBarFactura;
	private JDialog panelFormAlta;
	private JDialog panelFormBaja;
	private JDialog panelFormMostrar;
	private JDialog panelFormModificar;

	public PanelFactura(Controlador controlador){
		super();
		this.controlador = controlador;
		this.setLayout(new BorderLayout());
		this.add(toolBarFactura(), BorderLayout.NORTH);
	}

	private JToolBar toolBarFactura() {
		toolBarFactura = new JToolBar();

		// crear marca
		JButton botonCrear = new JButton("Crear Factura",new ImageIcon("resources/images/add-32.png"));
		botonCrear.setToolTipText("Crear Factura");
		botonCrear.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonCrear.setHorizontalTextPosition(SwingConstants.CENTER);
		botonCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.accion(Eventos.insertar_Factura, null);
			}
		});

		// eliminar marca
		JButton botonElimiar = new JButton("Eliminar Factura", new ImageIcon("resources/images/remove-32.png"));
		botonElimiar.setToolTipText("Eliminar Factura");
		botonElimiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonElimiar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonElimiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.accion(Eventos.eliminar_Factura, null);
			}
		});

		// mostrar marca
		JButton botonMostrar = new JButton("Mostrar Factura",new ImageIcon( "resources/images/eye-32.png"));
		botonMostrar.setToolTipText("Mostrar Factura");
		botonMostrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonMostrar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonMostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.accion(Eventos.mostrar_Factura, null);
			}
		});

		// modificar marca
		JButton botonModificar = new JButton("Modificar Factura", new ImageIcon("resources/images/edit-32.png"));
		botonModificar.setToolTipText("Modificar Factura");
		botonModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.accion(Eventos.modificar_Factura, null);
			}
		});

		JButton botonDevolverProd= new JButton("Devolver Producto", new ImageIcon("resources/images/return-32.png"));
		botonDevolverProd.setToolTipText("Modificar Factura");
		botonDevolverProd.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonDevolverProd.setHorizontalTextPosition(SwingConstants.CENTER);
		botonDevolverProd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.accion(Eventos.devolver_Producto, null);
			}
		});
		toolBarFactura.add(botonCrear);
		toolBarFactura.add(botonModificar);
		toolBarFactura.add(botonMostrar);
		toolBarFactura.add(botonElimiar);
		toolBarFactura.add(botonDevolverProd);

		return toolBarFactura;
	}

	}

