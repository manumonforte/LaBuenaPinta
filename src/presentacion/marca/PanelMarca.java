package presentacion.marca;

import javax.swing.*;

import presentacion.controlador.Controlador;

import java.awt.*;

public class PanelMarca extends JPanel{
	public PanelMarca(){
		setLayout(new BorderLayout());
		add(new ToolBarMarca(), BorderLayout.NORTH);
	}
}
