package presentacion.factura;

import negocio.factura.TFactura;
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

public class FormBajaFactura extends JDialog {

	private JTextField textID;

	public FormBajaFactura() {
		setTitle("Baja Factura");
		setResizable(false);
		Util.addEscapeListener(this);
		initGUI();
	}

	private void initGUI() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));
		panelPrincipal.add(camposFormulario());
		panelPrincipal.add(botonesFormulario());

		add(panelPrincipal);
		setVisible(false);
		pack();
		setLocationRelativeTo(null);
	}

	private JPanel camposFormulario() {

		JPanel panelCampos = new JPanel(new GridLayout(1,2,0,7));
		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10, 10, 10, 10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//ID
		JLabel panelID = new JLabel("ID");
		panelCampos.add(panelID);

		textID = new JTextField(10);
		panelCampos.add(textID);

		return panelCampos;
	}

	private  JPanel botonesFormulario(){
		//Botones
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton eliminar = new JButton("ELIMINAR");
		eliminar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					TFactura factura = new TFactura();
					factura.setId_factura(Util.parseaIntNoNegativo(textID.getText()));
					dispose();
					Controlador.getInstancia().accion(Eventos.eliminar_Factura, factura);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(getRootPane(), ex.getMessage(), "Error eliminar Factura", JOptionPane.ERROR_MESSAGE);
				}
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
		panelBotones.add(eliminar);

		return panelBotones;
	}
}