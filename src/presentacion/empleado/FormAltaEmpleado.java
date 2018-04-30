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

public class FormAltaEmpleado extends JDialog{

	private JTextField textNombre;
	private JTextField textDNI;
	private JComboBox comboActiva;
	private JComboBox comboTCompleto;

	public FormAltaEmpleado() {
		setTitle("Alta Empleado");
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

	public boolean getComboActiva() {
		return comboActiva.getSelectedItem() == "true";

	}

	public boolean getComboTCompleto() {
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

		JPanel panelCampos = new JPanel(new GridLayout(4,2,0,7));
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

		//Activa
		JLabel panelActiva= new JLabel("Activo");
		panelCampos.add(panelActiva);

		comboActiva = seleccionarActiva();
		panelCampos.add(comboActiva);

		//Tiempo Completo
		JLabel panelTCompleto= new JLabel("Tiempo completo");
		panelCampos.add(panelTCompleto);

		comboTCompleto = seleccionarTiempo();
		panelCampos.add(comboTCompleto);

		return panelCampos;
	}

	private JPanel botonesFormulario(){
		//Botones
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton crear = new JButton("CREAR");
		crear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TEmpleado empleado = new TEmpleado();
				empleado.setNombre(getTextNombre());
				empleado.setDNI(getTextDNI());
				empleado.setActivo(getComboActiva());
				empleado.setTiempo_completo(getComboTCompleto());
				Controlador.getInstancia().accion(Eventos.insertar_Empleado, empleado);
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
		comboActiva = new JComboBox();
		comboActiva.addItem("true");
		comboActiva.addItem("false");

		return comboActiva;
	}

	private JComboBox seleccionarTiempo() {
		comboTCompleto = new JComboBox();
		comboTCompleto.addItem("true");
		comboTCompleto.addItem("false");

		return comboTCompleto;
	}
}
