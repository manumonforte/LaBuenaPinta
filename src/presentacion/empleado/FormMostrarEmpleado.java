package presentacion.empleado;

import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;
import presentacion.transfer.TEmpleado;
import presentacion.util.Util;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMostrarEmpleado extends JDialog{

	private JTextField textID;

	public FormMostrarEmpleado() {
		setTitle("Mostrar Empleado");
		setLocationRelativeTo(null);
		setResizable(false);
		Util.addEscapeListener(this);
		initGUI();
	}
	public String getTextID() {
		return textID.getText();
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

	private JPanel camposFormulario() {

		JPanel panelCampos = new JPanel(new GridLayout(1, 2, 0, 7));
		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10, 10, 10, 10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//ID
		JLabel panelID = new JLabel("ID");
		panelCampos.add(panelID);

		textID = new JTextField(10);
		panelCampos.add(textID);

		return panelCampos;
	}

	private  JPanel botonesFormulario(){
		//Botones
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton mostrar = new JButton("MOSTRAR");
		mostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TEmpleado empleado = new TEmpleado();
				empleado.setNombre(getTextID());
				Controlador.getInstancia().accion(Eventos.mostrar_Empleado, empleado);
				dispose();
			}
		});

		JButton cancelar = new JButton("CANCELAR");
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		panelBotones.add(cancelar);
		panelBotones.add(mostrar);

		return panelBotones;

	}
}
