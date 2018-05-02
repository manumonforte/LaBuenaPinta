package presentacion.factura;

import presentacion.transfer.TFactura;
import presentacion.util.ModeloTabla;
import presentacion.util.PanelTabla;

import javax.swing.*;
import java.awt.*;

public class PanelFactura extends JPanel {
	private final String[] columnId = {"Id" , "Cantidad Total", "Empleado"};
	private ModeloTabla modelo;

	public PanelFactura() {
		setLayout(new BorderLayout());
		add(new ToolbarFactura(), BorderLayout.NORTH);
		modelo = new ModeloTablaFactura(columnId);
		add(new PanelTabla<TFactura>(modelo), BorderLayout.CENTER);
	}

	public ModeloTabla getModelo() {
		return modelo;
	}
}

