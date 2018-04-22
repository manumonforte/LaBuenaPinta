package presentacion.cerveza;

import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormAltaCerveza extends JDialog{

	private Controlador controlador;
	private JComboBox<String> lista;

	public FormAltaCerveza() {
		super();
		this.setTitle("Alta Cerveza");
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.initGUI();
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

		JPanel panelCampos = new JPanel(new GridLayout(6,2));

		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10, 10, 10, 10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//ID
		JLabel panelID = new JLabel("ID");
		panelID.setBounds(10, 10, 80, 25);
		panelCampos.add(panelID);

		JTextField textID = new JTextField(20);
		textID.setBounds(100, 10, 160, 25);
		textID.setText("autoincrement");
		textID.setEditable(false);
		panelCampos.add(textID);

		//Nombre
		JLabel panelNombre = new JLabel("Nombre");
		panelNombre.setBounds(10, 10, 80, 25);
		panelCampos.add(panelNombre);

		JTextField textNombre = new JTextField(20);
		textNombre.setBounds(100, 10, 160, 25);
		panelCampos.add(textNombre);

		//Stock
		JLabel panelStock = new JLabel("Stock");
		panelStock.setBounds(10, 10, 80, 25);
		panelCampos.add(panelStock);

		JTextField textStock = new JTextField(20);
		textStock.setBounds(100, 10, 160, 25);
		panelCampos.add(textStock);

		//Graduacion
		JLabel panelGraduacion = new JLabel("Graduacio");
		panelGraduacion.setBounds(10, 10, 80, 25);
		panelCampos.add(panelGraduacion);

		JTextField textGraduacion = new JTextField(20);
		textGraduacion.setBounds(100, 10, 160, 25);
		panelCampos.add(textGraduacion);

		//Precio
		JLabel panelPrecio = new JLabel("Precio");
		panelPrecio.setBounds(10, 10, 80, 25);
		panelCampos.add(panelPrecio);

		JTextField textPrecio = new JTextField(20);
		textPrecio.setBounds(100, 10, 160, 25);
		panelCampos.add(textPrecio);

		//Activa
		JLabel panelActiva= new JLabel("Activa");
		panelActiva.setBounds(10, 10, 80, 25);
		panelCampos.add(panelActiva);

		panelCampos.add(selecionarActiva());

		return panelCampos;
	}

	private JPanel botonesFormnulario(){
		//Botones
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton crear = new JButton("CREAR");
		crear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//NOTA: LOS DATOS A RETORNAR POR EL BOTON ACEPTAR ESTAN A NULL
				controlador.accion(Eventos.insertar_Cerveza, null);
			}
		});

		JButton cancelar = new JButton("CANCELAR");
		cancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		panelBotones.add(cancelar);
		panelBotones.add(crear);

		return panelBotones;
	}

	private JComboBox selecionarActiva() {
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(180, 285, 91, 20);
		comboBox.addItem("true");
		comboBox.addItem("false");

		return comboBox;
	}
}