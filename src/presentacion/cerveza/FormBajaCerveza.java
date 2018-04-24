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

public class FormBajaCerveza extends  JDialog{

	private Controlador controlador;

	private JTextField textID;

	public FormBajaCerveza() {
		super();
		this.setTitle("Baja Cerveza");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
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

		JPanel panelCampos = new JPanel(new FlowLayout());

		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10, 10, -50, 10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//ID
		JLabel panelID = new JLabel("ID");
		panelCampos.add(panelID);

		textID = new JTextField(20);
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
				dispose();
			}
		});

		panelBotones.add(cancelar);
		panelBotones.add(crear);

		return panelBotones;
	}
}