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

public class FormAltaCerveza extends JDialog{

	private JTextField textNombre;
	private JTextField textStock;
	private JTextField textGraduacion;
	private JTextField textPrecio;
	private JTextField textMarca;
	private JComboBox comboBox;

	public FormAltaCerveza() {
		setTitle("Alta Cerveza");
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
		setLocationRelativeTo(null);
	}

	private JPanel camposFormulario(){

		JPanel panelCampos = new JPanel(new GridLayout(6,2,0,7));
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

		//Marca
		JLabel panelMarca = new JLabel("Marca(ID)");
		panelCampos.add(panelMarca);

		textMarca = new JTextField(10);
		panelCampos.add(textMarca);

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
				try {
					cerveza.setNombre(Util.parseaString(textNombre.getText()));
					cerveza.setGraduacion(Util.parseaIntNoNegativo(textGraduacion.getText()));
					cerveza.setPrecio(Util.parseaFloatNoNegativo(textPrecio.getText()));
					cerveza.setStock(Util.parseaIntNoNegativo(textStock.getText()));
					cerveza.setActiva(Util.parseaActiva(comboBox.getSelectedItem().toString()));
					cerveza.set_marca(Util.parseaIntNoNegativo(textMarca.getText()));
					dispose();
					Controlador.getInstancia().accion(Eventos.insertar_Cerveza, cerveza);
				}catch (Exception ex){
					JOptionPane.showMessageDialog(getRootPane(), ex.getMessage(), "Error Alta Cerveza", JOptionPane.ERROR_MESSAGE);
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