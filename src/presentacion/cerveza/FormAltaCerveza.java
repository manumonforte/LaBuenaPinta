package presentacion.cerveza;

import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;
import presentacion.transfer.TCerveza;

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
		super();
		this.setTitle("Alta Cerveza");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.initGUI();
	}

	public String getTextNombre() {
		return textNombre.getText();
	}

	public int getTextStock() {
		return Integer.parseInt(textStock.getText());
	}

	public int getTextGraduacion() {
		return Integer.parseInt(textGraduacion.getText());
	}

	public float getTextPrecio() {
		return Float.parseFloat(textPrecio.getText());
	}

	public boolean getTextActiva() {
		return comboBox.getSelectedItem() == "true";
	}


	private void initGUI() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		panelPrincipal.setPreferredSize(new Dimension(300, 300));

		panelPrincipal.add(camposFormularioAlta(), BorderLayout.CENTER);
		panelPrincipal.add(botonesFormnulario(), BorderLayout.SOUTH);

		this.add(panelPrincipal);
		this.setVisible(false);
		this.pack();
	}

	private JPanel camposFormularioAlta(){

		JPanel panelCampos = new JPanel(new GridLayout(6,2,0,7));
		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10,10,-50,10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//Nombre
		JLabel panelNombre = new JLabel("Nombre");
		panelCampos.add(panelNombre);

		textNombre = new JTextField(20);
		panelCampos.add(textNombre);

		//Stock
		JLabel panelStock = new JLabel("Stock");
		panelCampos.add(panelStock);

		textStock = new JTextField(20);
		panelCampos.add(textStock);

		//Graduacion
		JLabel panelGraduacion = new JLabel("Graduacion");
		panelCampos.add(panelGraduacion);

		textGraduacion = new JTextField(20);
		panelCampos.add(textGraduacion);

		//Precio
		JLabel panelPrecio = new JLabel("Precio");
		panelCampos.add(panelPrecio);

		textPrecio = new JTextField(20);
		panelCampos.add(textPrecio);

		//Activa
		JLabel panelActiva= new JLabel("Activa");
		panelCampos.add(panelActiva);

		comboBox = selecionarActiva();
		panelCampos.add(comboBox);

		return panelCampos;
	}

	private JPanel botonesFormnulario(){
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

	private JComboBox selecionarActiva() {
		comboBox = new JComboBox();
		comboBox.addItem("true");
		comboBox.addItem("false");

		return comboBox;
	}
}