package presentacion.factura;

import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;
import presentacion.util.Util;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormDevolverProducto extends  JDialog{
	private Controlador controlador;
	private JTextField textID;
	private JTextField textCantidad;
	private JComboBox comboBox;

	public FormDevolverProducto() {
		setTitle("Devolver Producto");
		setLocationRelativeTo(null);
		setResizable(false);
		Util.addEscapeListener(this);
		initGUI();
	}

	private void initGUI() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(2,1));
		panelPrincipal.setPreferredSize(new Dimension(300, 300));

		panelPrincipal.add(camposFormulario());
		panelPrincipal.add(botonesFormulario());

		pack();
	}

	private JPanel camposFormulario(){

		JPanel panelCampos = new JPanel(new GridLayout(2,2,0,7));
		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10,10,10,10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//ID
		JLabel panelID = new JLabel("ID factura");
		panelCampos.add(panelID);

		textID = new JTextField(10);
		panelCampos.add(textID);

		//Productos
		JLabel panelDevProd = new JLabel("Productos");
		panelCampos.add(panelDevProd);

		panelCampos.add(comboBox);

		//Cantidad
		JLabel panelCantidad = new JLabel("Cantidad a devolver");
		panelCampos.add(panelCampos);

		textCantidad = new JTextField(10);
		panelCampos.add(textCantidad);

		return panelCampos;
	}

	private  JPanel botonesFormulario(){
		//Botones
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton crear = new JButton("DEVOLVER PRODUCTO");
		crear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TFactura factura = new TFactura();
				//TODO
				Controlador.getInstancia().accion(Eventos.insertar_Factura, factura);
				dispose();
			}
		});

		JButton cancelar = new JButton("CANCELAR");
		cancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		panelBotones.add(cancelar);
		panelBotones.add(crear);

		return panelBotones;
	}

/*	private void comboProductos(){
		comboBox = new JComboBox();



		return comboBox;
	}*/
}
