package presentacion.marca;

import presentacion.transfer.TMarca;
import presentacion.util.PanelTabla;

import javax.swing.*;
import java.awt.*;

public class PanelMarca extends JPanel{
	private final String[] columnId = {"Id" , "Nombre", "Sede", "Pais", "Activa"};

	public PanelMarca(){
		setLayout(new BorderLayout());
		add(new ToolBarMarca(), BorderLayout.NORTH);
		add(new PanelTabla<TMarca>(new ModeloTablaMarca(columnId)), BorderLayout.CENTER);
	}
}
