package presentacion.marca;

import negocio.marca.TMarca;
import presentacion.PanelTabs;
import presentacion.util.ModeloTabla;
import presentacion.util.PanelTabla;

import javax.swing.*;
import java.awt.*;

public class PanelMarca extends JPanel {
	private final String[] columnId = {"Id", "Nombre", "Sede", "Pais", "Activa"};
	private ModeloTabla modelo;

	public PanelMarca(PanelTabs panelTabs) {
		setLayout(new BorderLayout());
		add(new ToolBarMarca(panelTabs), BorderLayout.NORTH);
		modelo = new ModeloTablaMarca(columnId);
		add(new PanelTabla<TMarca>(modelo), BorderLayout.CENTER);
	}

	public ModeloTabla getModelo() {
		return modelo;
	}
}
