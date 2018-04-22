package presentacion.marca;

import javax.swing.*;

import presentacion.controlador.Controlador;

import java.awt.*;

public class PanelMarca extends JPanel{

	private Controlador controlador;

	public PanelMarca(Controlador controlador){
		super();
		this.controlador = controlador;
		this.setLayout(new BorderLayout());
		this.add(new ToolBarMarca(), BorderLayout.NORTH);
	}
}
