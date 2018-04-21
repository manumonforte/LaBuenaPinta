package presentacion;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import presentacion.controlador.Controlador;

public class VentanaPrincipal extends JFrame{
	
	private Controlador controlador;

	private Menu menu;
	
	public VentanaPrincipal(Controlador controlador){
		super("La Buena Pinta");
		this.controlador = controlador;
		this.initGUI();
	}
	
	public Controlador getControlador() {
		return controlador;
	}
	
	private void initGUI() {
	    this.setPreferredSize(new Dimension( 1024, 720 ));
	    this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				System.exit(0);				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
			}
			
		});

		//PanelTabs superior
		Menu menu = new Menu(this, controlador);
		this.setJMenuBar(menu);
		
		PanelTabs tabbedPane = new PanelTabs(this, controlador);
		setContentPane(tabbedPane);

		this.pack();
		this.setVisible(true);
	}

	//main para probar la ejecucion de la clase
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaPrincipal(null);
			}
		});
	}
}
