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

public class FormAltaFactura extends JDialog {

	private JTextField textCantidadTotal;
	private JComboBox comboEmpleado;

	public FormAltaFactura() {
		setTitle("Alta Factura");
		setLocationRelativeTo(null);
		setResizable(false);
		Util.addEscapeListener(this);
		initGUI();
	}

	public int getTextCantidadTotal() {
		return Integer.parseInt(textCantidadTotal.getText());
	}

	public int getComboEmpleado() {
		return (int) comboEmpleado.getSelectedItem();
	}

	private void initGUI() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));

		panelPrincipal.add(camposFormulario());
		panelPrincipal.add(botonesFormulario());

		this.add(panelPrincipal);
		this.setVisible(false);
		this.pack();
	}

	private JPanel camposFormulario(){

		JPanel panelCampos = new JPanel(new GridLayout(2,2,0,7));
		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10,10,10,10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//Cantidad total
		JLabel panelNombre = new JLabel("Cantidad total");
		panelCampos.add(panelNombre);

		textCantidadTotal = new JTextField(10);
		panelCampos.add(textCantidadTotal);

		//Empleado
		JLabel panelActiva= new JLabel("Empleado");
		panelCampos.add(panelActiva);

		comboEmpleado = seleccionarEmpleado(); //TODO hay que pasarle al combo box la lista de los empleados de la BBDD
		panelCampos.add(comboEmpleado);

		return panelCampos;
	}

	private  JPanel botonesFormulario(){
		//Botones
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton crear = new JButton("GENERAR");
		crear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TFactura factura = new TFactura();
				factura.setPrecio_total(getTextCantidadTotal());
				factura.setEmpleado(getComboEmpleado());
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

	private JComboBox seleccionarEmpleado() {
		comboEmpleado = new JComboBox();
		/*
		for(int i = 0; i < ; i++){
			Controlador.getInstancia().accion(Eventos.mostrar_Empleado,i);
			comboEmpleado.add();
		}
		*/
		return comboEmpleado;
	}
}
