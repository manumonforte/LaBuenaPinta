package presentacion.factura;

import javax.swing.*;

import presentacion.controlador.Controlador;

import java.awt.*;

public class PanelFactura extends JPanel {
	public PanelFactura() {
		setLayout(new BorderLayout());
		add(new ToolbarFactura(), BorderLayout.NORTH);
	}
}

