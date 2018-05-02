package presentacion.cerveza;

import presentacion.marca.ModeloTablaMarca;
import presentacion.transfer.TCerveza;
import presentacion.util.ModeloTabla;
import presentacion.util.PanelTabla;

import javax.swing.*;
import java.awt.*;

public class PanelCerveza extends JPanel {
	private final String[] columnId = {"Id" , "Nombre", "Stock", "Graduacion", "Precio", "Marca", "Activa"};
	private ModeloTabla modelo;

	public PanelCerveza(){
		setLayout(new BorderLayout());
		add(new ToolBarCerveza(), BorderLayout.NORTH);
		modelo = new ModeloTablaCerveza(columnId);
		add(new PanelTabla<TCerveza>(modelo), BorderLayout.CENTER);
	}

	public ModeloTabla getModelo() {
		return modelo;
	}
}
