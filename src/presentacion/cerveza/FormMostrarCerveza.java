package presentacion.cerveza;

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

public class FormMostrarCerveza extends  JDialog{

	private JTextField textID;

	public FormMostrarCerveza() {
		setTitle("Mostrar Cerveza");
		setLocationRelativeTo(null);
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
		pack();
	}

	private JPanel camposFormulario() {

		JPanel panelCampos = new JPanel(new GridLayout(1, 2, 0, 7));
		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10, 10, 10, 10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//ID
		JLabel panelID = new JLabel("ID");
		panelCampos.add(panelID);

		textID = new JTextField(10);
		textID.setBounds(100, 10, 160, 25);
		panelCampos.add(textID);

		return panelCampos;
	}

	private JPanel botonesFormulario(){
		//Botones
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton mostrar = new JButton("MOSTRAR");
		mostrar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TCerveza cerveza = new TCerveza();
				try {
					cerveza.setId_cerveza(Util.parseaIntNoNegativo(textID.getText()));
					Controlador.getInstancia().accion(Eventos.insertar_Cerveza, cerveza);
				}catch (Exception ex){
					JOptionPane.showMessageDialog(getRootPane(), ex.getMessage(), "Error Mostrar Cerveza", JOptionPane.ERROR_MESSAGE);
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
		panelBotones.add(mostrar);

		return panelBotones;
	}
}