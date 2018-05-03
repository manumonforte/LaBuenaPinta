package presentacion;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame{

	public VentanaPrincipal(){
		setTitle("La Buena Pinta");
		initGUI();
	}

	private void initGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources/images/logo-64.png"));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

		PanelTabs tabbedPane = new PanelTabs();
		setContentPane(tabbedPane);
		tabbedPane.actualizarMarca();

		pack();
		setVisible(true);
	}
}
