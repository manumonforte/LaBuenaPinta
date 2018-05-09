package presentacion.empleado;

import negocio.empleado.TEmpleado;
import presentacion.PanelTabs;
import presentacion.util.ModeloTabla;
import presentacion.util.PanelTabla;

import javax.swing.*;
import java.awt.*;

public class PanelEmpleado extends JPanel {
	private final String[] columnId = {"Id" , "Nombre", "DNI", "Activo", "Horas extras", "Turno"};
	private ModeloTabla modelo;

	public PanelEmpleado(PanelTabs panelTabs) {
		setLayout(new BorderLayout());
		add(new ToolBarEmpleado(panelTabs), BorderLayout.NORTH);
		modelo = new ModeloTablaEmpleado(columnId);
		add(new PanelTabla<TEmpleado>(modelo), BorderLayout.CENTER);
	}

	public ModeloTabla getModelo() {
		return modelo;
	}
}

