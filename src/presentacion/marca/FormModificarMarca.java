package presentacion.marca;

import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;
import presentacion.transfer.TMarca;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormModificarMarca extends JDialog{

	private JTextField textID;
	private JTextField textNombre;
	private JTextField textSede;
	private JTextField textPais;

	public FormModificarMarca() {
		super();
		this.setTitle("Modificar Marca");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.initGUI();
	}

	public int getTextID() {
		return Integer.parseInt(textID.getText());
	}

	public String getTextNombre() {
		return textNombre.getText();
	}

	public String getTextSede() {
		return textSede.getText();
	}

	public String getTextPais() {
		return textPais.getText();
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

		JPanel panelCampos = new JPanel(new GridLayout(4,2,0,7));
		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10,10,10,10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//ID
		JLabel panelID = new JLabel("ID");
		panelCampos.add(panelID);

		textID = new JTextField(10);
		panelCampos.add(textID);

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

		return panelCampos;
	}

	private  JPanel botonesFormulario(){
		//Botones
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton crear = new JButton("MODIFICAR");
		crear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TMarca marca = new TMarca();
				marca.setId_marca(getTextID());
				marca.setNombre(getTextNombre());
				marca.setSede(getTextSede());
				marca.setPais(getTextPais());
				Controlador.getInstancia().accion(Eventos.insertar_Marca, marca);
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
}
