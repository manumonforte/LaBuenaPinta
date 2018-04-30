package presentacion.factura;

import presentacion.transfer.TFactura;
import presentacion.util.PanelTabla;

import javax.swing.*;
import java.awt.*;

public class PanelFactura extends JPanel {
	private final String[] columnId = {"Id" , "Cantidad Total", "Empleado"};

	public PanelFactura() {
		setLayout(new BorderLayout());
		add(new ToolbarFactura(), BorderLayout.NORTH);
		add(new PanelTabla<TFactura>(new ModeloTablaFactura(columnId)), BorderLayout.CENTER);
	}
}

