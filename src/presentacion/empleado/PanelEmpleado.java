package presentacion.empleado;

import javax.swing.*;

import presentacion.controlador.Controlador;

import java.awt.*;

public class PanelEmpleado extends JPanel {

	private Controlador controlador;

	public PanelEmpleado(Controlador controlador) {
		super();
		this.controlador = controlador;
		this.setLayout(new BorderLayout());
		this.add(new ToolBarEmpleado(), BorderLayout.NORTH);
	}
}

