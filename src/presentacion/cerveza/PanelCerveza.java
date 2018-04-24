package presentacion.cerveza;


import javax.swing.*;
import java.awt.*;

public class PanelCerveza extends JPanel {
	public PanelCerveza(){
		setLayout(new BorderLayout());
		add(new ToolBarCerveza(), BorderLayout.NORTH);
	}
}
