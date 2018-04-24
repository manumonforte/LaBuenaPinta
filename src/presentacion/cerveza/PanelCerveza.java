package presentacion.cerveza;

import javax.swing.*;

import presentacion.controlador.Controlador;

import java.awt.*;

public class PanelCerveza extends JPanel {

	private Controlador controlador;

	public PanelCerveza(Controlador controlador){
		super();
		this.controlador = controlador;
		this.setLayout(new BorderLayout());
		this.add(new ToolBarCerveza(), BorderLayout.NORTH);
	}
}
