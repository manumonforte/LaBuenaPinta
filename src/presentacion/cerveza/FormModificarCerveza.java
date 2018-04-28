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

public class FormModificarCerveza extends JDialog{

	public FormModificarCerveza() {
		setTitle("Modificar Cerveza");
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

	private JPanel camposFormulario(){

		JPanel panelCampos = new JPanel(new GridLayout(3,2,0,7));
		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10, 10, 10, 10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//Nombre
		JLabel panelNombre = new JLabel("Nombre");
		panelCampos.add(panelNombre);

		JTextField textNombre = new JTextField(10);
		panelCampos.add(textNombre);

		//Stock
		JLabel panelStock = new JLabel("Stock");
		panelCampos.add(panelStock);

		JTextField textStock = new JTextField(10);
		panelCampos.add(textStock);

		//Graduacion
		JLabel panelGraduacion = new JLabel("Graduacion");
		panelCampos.add(panelGraduacion);

		JTextField textGraduacion = new JTextField(10);
		panelCampos.add(textGraduacion);

		return panelCampos;
	}

	private JPanel botonesFormulario(){
		//Botones
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton modificar = new JButton("MODIFICAR");
		modificar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstancia().accion(Eventos.insertar_Marca, null);//TODO
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
		panelBotones.add(modificar);

		return panelBotones;
	}
}
