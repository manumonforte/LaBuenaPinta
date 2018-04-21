package presentacion.marca;

import javax.swing.*;

import presentacion.controlador.Controlador;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMarca extends JPanel{

	private JToolBar toolBarMarca;

	private JPanel panelMarca;

	private JPanel panelFormAlta;
	private JPanel panelFormBaja;
	private JPanel panelFormMostrar;
	private JPanel panelFormModificar;

	public PanelMarca(Controlador controlador){
		super();

		panelMarca = new JPanel(new BorderLayout());

		panelMarca.add(toolbarMarca(), BorderLayout.NORTH);

		this.add(panelMarca);
	}

	private JToolBar toolbarMarca() {

		toolBarMarca = new JToolBar();

		// crear marca
		JButton botonCrear = new JButton(new ImageIcon("resources/images/add-32.png"));
		botonCrear.setToolTipText("Crear marca");
		botonCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				formularioAltaMarca();
				//controlador.accion(Eventos.insertar_Marca, null);
			}
		});

		// eliminar marca
		JButton botonElimiar = new JButton(new ImageIcon("resources/images/remove-32.png"));
		botonElimiar.setToolTipText("Eliminar marca");
		botonElimiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				formularioBajaMarca();
				//controlador.accion(Eventos.eliminar_Marca, null);
			}
		});

		// mostrar marca
		JButton botonMostrar = new JButton(new ImageIcon("resources/images/eye-32.png"));
		botonMostrar.setToolTipText("Mostrar marca");
		botonMostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				formularioMostrarMarca();
				//controlador.accion(Eventos.mostrar_Marca, null);
			}
		});

		// modificar marca
		JButton botonCModificar = new JButton(new ImageIcon("resources/images/edit-32.png"));
		botonCModificar.setToolTipText("Modificar marca");
		botonCModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				formularioModificarMarca();
				//controlador.accion(Eventos.modificar_Marca, null);
			}
		});

		toolBarMarca.add(botonCrear);
		toolBarMarca.add(botonCModificar);
		toolBarMarca.add(botonMostrar);
		toolBarMarca.add(botonElimiar);

		return toolBarMarca;
	}

	private void formularioAltaMarca() {
		panelFormAlta = new JPanel(new GridLayout(2, 1));

		panelFormAlta.add(camposFormularioAlta());
		panelFormAlta.add(botonesFormulario());

		panelMarca.add(panelFormAlta, BorderLayout.CENTER);

		panelFormBaja.setVisible(false);
		panelFormModificar.setVisible(false);
		panelFormMostrar.setVisible(false);
	}

	private void formularioBajaMarca() {
		panelFormBaja = new JPanel(new GridLayout(2, 1));

		panelFormBaja.add(camposFormularioBaja());
		panelFormBaja.add(botonesFormulario());

		panelMarca.add(panelFormBaja, BorderLayout.CENTER);

		panelFormAlta.setVisible(false);
		panelFormModificar.setVisible(false);
		panelFormMostrar.setVisible(false);
	}

	private void formularioMostrarMarca() {
		panelFormMostrar = new JPanel(new GridLayout(2, 1));

		panelFormMostrar.add(camposFormularioMostrar());
		panelFormMostrar.add(botonesFormulario());

		panelMarca.add(panelFormMostrar, BorderLayout.CENTER);

		panelFormBaja.setVisible(false);
		panelFormModificar.setVisible(false);
		panelFormAlta.setVisible(false);
	}

	private void formularioModificarMarca() {
		panelFormModificar = new JPanel(new GridLayout(2, 1));

		panelFormModificar.add(camposFormularioModificar());
		panelFormModificar.add(botonesFormulario());

		panelMarca.add(panelFormModificar, BorderLayout.CENTER);

		panelFormAlta.setVisible(false);
		panelFormBaja.setVisible(false);
		panelFormMostrar.setVisible(false);
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

	private JPanel camposFormularioBaja(){

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

		return panelCampos;
	}

	private JPanel camposFormularioModificar(){

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

		addLabelAndTextField("Nombre:", 1, panelCampos);
		addLabelAndTextField("Sede:", 2, panelCampos);
		addLabelAndTextField("Pais:", 3, panelCampos);
		addLabelAndTextField("Activa:", 4, panelCampos);


		return panelCampos;
	}
	private JPanel camposFormularioMostrar(){

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

	private JPanel botonesFormulario() {

		JPanel panelBotones = new JPanel(new GridLayout(1,2));

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setPreferredSize(new Dimension(40, 40));
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//IMPLEMENTAR ACEPTAR
			}
		});

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setPreferredSize(new Dimension(40, 40));
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//IMPLEMENTAR CANCELAR
			}
		});

		panelBotones.add(botonCancelar);
		panelBotones.add(botonAceptar);

		return panelBotones;
	}
}
