package presentacion.empleado;

import javax.swing.*;

import presentacion.controlador.Controlador;

import java.awt.*;

public class PanelEmpleado extends JPanel {

	public PanelEmpleado() {
		setLayout(new BorderLayout());
		add(new ToolBarEmpleado(), BorderLayout.NORTH);
	}
}

