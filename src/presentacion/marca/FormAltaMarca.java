package presentacion.marca;

import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormAltaMarca extends JDialog {

	private Controlador controlador;

	public FormAltaMarca() {
		super();
		this.setTitle("Alta Marca");
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.initGUI();
	}

	private void initGUI() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(2,1));
		panelPrincipal.setPreferredSize(new Dimension(300, 300));

		panelPrincipal.add(camposFormularioAlta());

		//Botones
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton crear = new JButton("CREAR");
		crear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//NOTA: LOS DATOS A RETORNAR POR EL BOTON ACEPTAR ESTAN A NULL
				controlador.accion(Eventos.insertar_Marca, null);
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
		panelPrincipal.add(panelBotones);

		this.add(panelPrincipal);
		this.setVisible(false);
		this.pack();
	}

	private JPanel camposFormularioAlta(){

		JPanel panelCampos = new JPanel();
		Border border = panelCampos.getBorder();
		Border margin = new EmptyBorder(10, 10, 10, 10);
		panelCampos.setBorder(new CompoundBorder(border, margin));

		GridBagLayout panelGridBagLayout = new GridBagLayout();
		panelGridBagLayout.columnWidths = new int[] { 86, 86, 0 };
		panelGridBagLayout.rowHeights = new int[] { 20, 20, 20, 20, 20, 0 };
		panelGridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panelGridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelCampos.setLayout(panelGridBagLayout);

		addLabelAndTextField("ID:", 0, panelCampos);
		addLabelAndTextField("Nombre:", 1, panelCampos);
		addLabelAndTextField("Sede:", 2, panelCampos);
		addLabelAndTextField("Pais:", 3, panelCampos);
		addLabelAndTextField("Activa:", 4, panelCampos);

		return panelCampos;
	}

	private void addLabelAndTextField(String labelText, int yPos, Container containingPanel) {

		JLabel label = new JLabel(labelText);
		GridBagConstraints gridBagConstraintForLabel = new GridBagConstraints();
		gridBagConstraintForLabel.fill = GridBagConstraints.BOTH;
		gridBagConstraintForLabel.insets = new Insets(0, 0, 5, 5);
		gridBagConstraintForLabel.gridx = 0;
		gridBagConstraintForLabel.gridy = yPos;
		containingPanel.add(label, gridBagConstraintForLabel);

		JTextField textField = new JTextField();
		GridBagConstraints gridBagConstraintForTextField = new GridBagConstraints();
		gridBagConstraintForTextField.fill = GridBagConstraints.BOTH;
		gridBagConstraintForTextField.insets = new Insets(0, 0, 5, 0);
		gridBagConstraintForTextField.gridx = 1;
		gridBagConstraintForTextField.gridy = yPos;
		containingPanel.add(textField, gridBagConstraintForTextField);
		textField.setColumns(10);
	}
}