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

public class FormModificarEmpleado extends  JDialog{

	private JTextField textNombre;
	private JTextField textDNI;
	private JComboBox comboTCompleto;

	public FormModificarEmpleado() {
		super();
		setTitle("Modificar Empleado");
		setLocationRelativeTo(null);
		setResizable(false);
		Util.addEscapeListener(this);
		initGUI();
	}

	public String getTextNombre() {
		return textNombre.getText();
	}

	public String getTextDNI() {
		return textDNI.getText();
	}

	public boolean getTextTCompleto() {
		return comboTCompleto.getSelectedItem() == "true";
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

		JPanel panelCampos = new JPanel(new GridLayout(3,2,0,7));
		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10,10,10,10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		//Nombre
		JLabel panelNombre = new JLabel("Nombre");
		panelCampos.add(panelNombre);

		textNombre = new JTextField(10);
		panelCampos.add(textNombre);

		//DNI
		JLabel panelDNI = new JLabel("DNI");
		panelCampos.add(panelDNI);

		textDNI = new JTextField(10);
		panelCampos.add(textDNI);

		//Tiempo Completo
		JLabel panelTCompleto= new JLabel("Tiempo completo");
		panelCampos.add(panelTCompleto);

		comboTCompleto = seleccionarTiempo();
		panelCampos.add(comboTCompleto);

		return panelCampos;
	}

	private  JPanel botonesFormulario(){
		//Botones
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton modificar = new JButton("MODIFICAR");
		modificar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TEmpleado empleado = new TEmpleado();
				empleado.setNombre(getTextNombre());
				empleado.setDNI(getTextDNI());
				empleado.setTiempo_completo(getTextTCompleto());
				Controlador.getInstancia().accion(Eventos.modificar_Empleado, empleado);
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
		panelBotones.add(modificar);

		return panelBotones;
	}

	private JComboBox seleccionarTiempo() {
		comboTCompleto = new JComboBox();
		comboTCompleto.addItem("true");
		comboTCompleto.addItem("false");

		return comboTCompleto;
	}
}
