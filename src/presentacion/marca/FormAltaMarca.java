package presentacion.marca;

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


public class FormAltaMarca extends JDialog {

	private JTextField textNombre;
	private JTextField textSede;
	private JTextField textPais;
	private JComboBox comboBox;

	public FormAltaMarca() {
		setTitle("Alta Marca");
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

		JPanel panelCampos = new JPanel(new GridLayout(4,2,0,7));
		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10,10,10,10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//Nombre
		JLabel panelNombre = new JLabel("Nombre");
		panelCampos.add(panelNombre);

		textNombre = new JTextField(10);
		panelCampos.add(textNombre);

		//Stock
		JLabel panelStock = new JLabel("Sede");
		panelCampos.add(panelStock);

		textSede = new JTextField(10);
		panelCampos.add(textSede);

		//Graduacion
		JLabel panelGraduacion = new JLabel("Pais");
		panelCampos.add(panelGraduacion);

		textPais = new JTextField(10);
		panelCampos.add(textPais);

		//Activa
		JLabel panelActiva= new JLabel("Activa");
		panelCampos.add(panelActiva);

		comboBox = seleccionarActiva();
		panelCampos.add(comboBox);

		return panelCampos;
	}

	private  JPanel botonesFormulario(){
		//Botones
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton crear = new JButton("CREAR");
		crear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TMarca marca = new TMarca();
				try {
					marca.setNombre(Util.parseaString(textNombre.getText()));
					marca.setSede(Util.parseaString(textSede.getText()));
					marca.setPais(Util.parseaString(textPais.getText()));
					marca.setActiva(Util.parseaActiva(comboBox.getSelectedItem().toString()));
					dispose();
					Controlador.getInstancia().accion(Eventos.insertar_Marca, marca);
				}catch (Exception ex){
					JOptionPane.showMessageDialog(getRootPane(), ex.getMessage(), "Error Alta Marca", JOptionPane.ERROR_MESSAGE);
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