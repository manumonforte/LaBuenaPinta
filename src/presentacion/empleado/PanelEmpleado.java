package presentacion.empleado;

import presentacion.factura.ModeloTablaFactura;
import presentacion.transfer.TEmpleado;
import presentacion.util.ModeloTabla;
import presentacion.util.PanelTabla;

import javax.swing.*;
import java.awt.*;

public class PanelEmpleado extends JPanel {
	private final String[] columnId = {"Id" , "Nombre", "DNI", "Pais", "Activo"};
	private ModeloTabla modelo;

	public PanelEmpleado() {
		setLayout(new BorderLayout());
		add(new ToolBarEmpleado(), BorderLayout.NORTH);
		modelo = new ModeloTablaFactura(columnId);
		add(new PanelTabla<TEmpleado>(modelo), BorderLayout.CENTER);
	}

	public ModeloTabla getModelo() {
		return modelo;
	}
}

