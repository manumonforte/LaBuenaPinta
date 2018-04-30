package presentacion.empleado;

import presentacion.transfer.TEmpleado;
import presentacion.util.PanelTabla;

import javax.swing.*;
import java.awt.*;

public class PanelEmpleado extends JPanel {
	private final String[] columnId = {"Id" , "Nombre", "DNI", "Pais", "Activo"};

	public PanelEmpleado() {
		setLayout(new BorderLayout());
		add(new ToolBarEmpleado(), BorderLayout.NORTH);
		add(new PanelTabla<TEmpleado>(new ModeloTablaEmpleado(columnId)), BorderLayout.CENTER);
	}
}

