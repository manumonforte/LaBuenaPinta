package presentacion.marca;

import presentacion.transfer.TMarca;
import presentacion.util.ModeloTabla;
import presentacion.util.PanelTabla;

import javax.swing.*;
import java.awt.*;

public class PanelMarca extends JPanel{
	private final String[] columnId = {"Id" , "Nombre", "Sede", "Pais", "Activa"};
	private ModeloTabla modelo;

	public PanelMarca(){
		setLayout(new BorderLayout());
		add(new ToolBarMarca(), BorderLayout.NORTH);
		modelo = new ModeloTablaMarca(columnId);
		add(new PanelTabla<TMarca>(modelo), BorderLayout.CENTER);
	}

	public ModeloTabla getModelo() {
		return modelo;
	}
}
