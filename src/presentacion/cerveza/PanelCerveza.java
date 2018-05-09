package presentacion.cerveza;

import negocio.cerveza.TCerveza;
import presentacion.PanelTabs;
import presentacion.util.ModeloTabla;
import presentacion.util.PanelTabla;

import javax.swing.*;
import java.awt.*;

public class PanelCerveza extends JPanel {
	private final String[] columnId = {"Id" , "Nombre", "Stock", "Graduacion", "Precio", "Marca", "Activa"};
	private ModeloTabla modelo;

	public PanelCerveza(PanelTabs panelTabs){
		setLayout(new BorderLayout());
		add(new ToolBarCerveza(panelTabs), BorderLayout.NORTH);
		modelo = new ModeloTablaCerveza(columnId);
		add(new PanelTabla<TCerveza>(modelo), BorderLayout.CENTER);
	}

	public ModeloTabla getModelo() {
		return modelo;
	}
}
