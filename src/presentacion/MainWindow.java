package presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import presentacion.controlador.Controlador;

public class MainWindow extends JFrame{
	
	private Controlador controlador;

	private MenuBar menuBar;
	
	public MainWindow(Controlador controlador){
		super("La Buena Pinta");
		this.controlador = this.controlador;
		this.initGUI();
	}
	
	public Controlador getControlador() {
		return controlador;
	}
	
	private void initGUI() {
	    this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
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
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JPanel mainPanel = this.createMainPanel();
		//this.setContentPane(mainPanel);
		
		//Panel superior
		MenuBar menuBar = new MenuBar(this, this.controlador);
		this.setJMenuBar(menuBar);
		
		TabbedPane tabbedPane = new TabbedPane(this, this.controlador);
		JPanel centerPanel = new JPanel(new GridLayout(1, 1));
		centerPanel.add(tabbedPane);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		setContentPane(tabbedPane);
		
		this.pack();
		this.setVisible(true);
	}
	
	private JPanel createMainPanel() {
		return new JPanel(new BorderLayout());
	}
	
	//main para probar la ejecucion de la clase
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainWindow(null);
			}
		});
	}
}
