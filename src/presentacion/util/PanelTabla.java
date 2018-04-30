package presentacion.util;

import javax.swing.*;
import java.awt.*;

public class PanelTabla<T> extends JPanel {
	private ModeloTabla<T> modelo;

	public PanelTabla(ModeloTabla<T> modelo) {
		setLayout(new GridLayout(1, 1));
		this.modelo = modelo;
		JTable tabla = new JTable(modelo);
		add(new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
	}
}