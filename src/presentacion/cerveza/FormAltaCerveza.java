package presentacion.cerveza;

import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;
import presentacion.transfer.TCerveza;
import presentacion.util.Util;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormAltaCerveza extends JDialog{

	private JTextField textNombre;
	private JTextField textStock;
	private JTextField textGraduacion;
	private JTextField textPrecio;
	private JComboBox comboBox;

	public FormAltaCerveza() {
		setTitle("Alta Cerveza");
		setLocationRelativeTo(null);
		setResizable(false);
		Util.addEscapeListener(this);
		initGUI();
	}

	private String getTextNombre() {
		return textNombre.getText();
	}

	private int getTextStock() {
		return Integer.parseInt(textStock.getText());
	}

	private int getTextGraduacion() {
		return Integer.parseInt(textGraduacion.getText());
	}

	private float getTextPrecio() {
		return Float.parseFloat(textPrecio.getText());
	}

	private boolean getTextActiva() {
		return comboBox.getSelectedItem() == "true";
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

		JPanel panelCampos = new JPanel(new GridLayout(5,2,0,7));
		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10,10,10,10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//Nombre
		JLabel panelNombre = new JLabel("Nombre");
		panelCampos.add(panelNombre);

		textNombre = new JTextField(10);
		panelCampos.add(textNombre);

		//Stock
		JLabel panelStock = new JLabel("Stock");
		panelCampos.add(panelStock);

		textStock = new JTextField(10);
		panelCampos.add(textStock);

		//Graduacion
		JLabel panelGraduacion = new JLabel("Graduacion");
		panelCampos.add(panelGraduacion);

		textGraduacion = new JTextField(10);
		panelCampos.add(textGraduacion);

		//Precio
		JLabel panelPrecio = new JLabel("Precio");
		panelCampos.add(panelPrecio);

		textPrecio = new JTextField(10);
		panelCampos.add(textPrecio);

		//Activa
		JLabel panelActiva= new JLabel("Activa");
		panelCampos.add(panelActiva);

		comboBox = seleccionarActiva();
		panelCampos.add(comboBox);

		return panelCampos;
	}

	private JPanel botonesFormulario(){
		//Botones
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton crear = new JButton("CREAR");
		crear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TCerveza cerveza = new TCerveza();
				cerveza.setNombre(getTextNombre());
				cerveza.setGraduacion(getTextGraduacion());
				cerveza.setPrecio(getTextPrecio());
				cerveza.setStock(getTextStock());
				cerveza.setActiva(getTextActiva());
				Controlador.getInstancia().accion(Eventos.insertar_Cerveza, cerveza);
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

	private JComboBox seleccionarActiva() {
		comboBox = new JComboBox();
		comboBox.addItem("true");
		comboBox.addItem("false");

		return comboBox;
	}
}