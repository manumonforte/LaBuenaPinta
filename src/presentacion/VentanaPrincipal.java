package presentacion;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import presentacion.controlador.Controlador;

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

		pack();
		setVisible(true);
	}

	//main para probar la ejecucion de la clase
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaPrincipal();
			}
		});
	}
}
