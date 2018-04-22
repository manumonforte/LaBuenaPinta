package presentacion.factura;

import javax.swing.*;

import presentacion.controlador.Controlador;

import java.awt.*;

public class PanelFactura extends JPanel {

	private Controlador controlador;

	public PanelFactura(Controlador controlador){
		super();
		this.controlador = controlador;
		this.setLayout(new BorderLayout());
		this.add(new ToolbarFactura(), BorderLayout.NORTH);
	}
}

