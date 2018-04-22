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

public class FormMostrarCerveza extends  JDialog{

	private Controlador controlador;

	public FormMostrarCerveza() {
		super();
		this.setTitle("Mostrar Cerveza");
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.initGUI();
	}

	private void initGUI() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		panelPrincipal.setPreferredSize(new Dimension(200, 80));
		panelPrincipal.add(camposFormularioBaja(), BorderLayout.CENTER);
		panelPrincipal.add(botonesFormnulario(), BorderLayout.SOUTH);

		this.add(panelPrincipal);
		this.setVisible(false);
		this.pack();
	}

	private JPanel camposFormularioBaja() {

		JPanel panelCampos = new JPanel(new GridLayout(1,2));

		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10, 10, 10, 10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//ID
		JLabel panelID = new JLabel("ID");
		panelID.setBounds(10, 10, 80, 25);
		panelCampos.add(panelID);

		JTextField textID = new JTextField(20);
		textID.setBounds(100, 10, 160, 25);
		panelCampos.add(textID);

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
				controlador.accion(Eventos.eliminar_Cerveza, null);
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
}