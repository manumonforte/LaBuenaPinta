package presentacion.cerveza;

import presentacion.transfer.TCerveza;
import presentacion.util.PanelTabla;

import javax.swing.*;
import java.awt.*;

public class PanelCerveza extends JPanel {
	private final String[] columnId = {"Id" , "Nombre", "Stock", "Graduacion", "Precio", "Marca", "Activa"};

	public PanelCerveza(){
		setLayout(new BorderLayout());
		add(new ToolBarCerveza(), BorderLayout.NORTH);
		add(new PanelTabla<TCerveza>(new ModeloTablaCerveza(columnId)), BorderLayout.CENTER);
	}
}
