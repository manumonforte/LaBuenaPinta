package presentacion.marca;

import presentacion.VentanaPrincipal;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;
import presentacion.transfer.TMarca;
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

	public String getTextNombre() {
		return Util.parseaString(textNombre.getText());
	}

	public String getTextSede() {
		return Util.parseaString(textSede.getText());
	}

	public String getTextPais() {
		return Util.parseaString(textPais.getText());
	}

	public boolean getTextActiva() {
		return Util.parseaActiva(comboBox.getSelectedItem().toString());
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
					marca.setNombre(getTextNombre());
					marca.setSede(getTextSede());
					marca.setPais(getTextPais());
					marca.setActiva(getTextActiva());
					dispose();
					Controlador.getInstancia().accion(Eventos.insertar_Marca, marca);
				}catch (Exception ex){
					JOptionPane.showMessageDialog(getRootPane(),"Error", "Error Alta Marca", JOptionPane.ERROR_MESSAGE);
				}
				System.out.println(getTextNombre() + getTextPais() + getTextSede());
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