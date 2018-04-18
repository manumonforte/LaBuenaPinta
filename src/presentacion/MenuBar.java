package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import presentacion.controlador.Controlador;

public class MenuBar extends JMenuBar {

	public MenuBar(MainWindow mainWindow, Controlador controlador) {
		super();
		
		//Create
		JMenu create = new JMenu("Create");
		this.add(create);
		this.addCreateMenu(create, mainWindow);
		
		//Delete
		JMenu delete = new JMenu("Delete");
		this.add(delete);
		this.addDeleteMenu(delete, mainWindow);
		
	}
	
	private void addCreateMenu(JMenu jMenu, MainWindow mainWindow){
		
		JMenuItem createMark = new JMenuItem("Create Mark");
		createMark.setMnemonic(KeyEvent.VK_M);
		createMark.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
		createMark.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				//IMPLEMENTAR ACCION CREAR MARCA
			}
		});
		
		JMenuItem createBeer = new JMenuItem("Create Beer");
		createBeer.setMnemonic(KeyEvent.VK_B);
		createBeer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
		createBeer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//IMPLEMENTAR ACCION CREAR CERVERZA
			}
		});
		
		JMenuItem createEmployee = new JMenuItem("Create Employee");
		createEmployee.setMnemonic(KeyEvent.VK_E);
		createEmployee.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
		createEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//IMPLEMENTAR ACCION CREAR EMPLEADDO
			}
		});
		
		JMenuItem createBill = new JMenuItem("Create Bill");
		createBill.setMnemonic(KeyEvent.VK_F);
		createBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
		createBill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//IMPLEMENTAR ACCION CREAR FACURA
			}
		});
				
		jMenu.add(createMark);
		jMenu.add(createBeer);
		jMenu.add(createEmployee);
		jMenu.add(createBill);
	}
	
	public void addDeleteMenu(JMenu jMenu, MainWindow mainWindow) {
		
		JMenuItem deleteMark = new JMenuItem("Delete Mark");
		deleteMark.setMnemonic(KeyEvent.VK_M);
		deleteMark.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
		deleteMark.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				//IMPLEMENTAR ACCION ELIMINAR MARCA
			}
		});
		
		JMenuItem deleteBeer = new JMenuItem("Delete beer");
		deleteBeer.setMnemonic(KeyEvent.VK_B);
		deleteBeer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
		deleteBeer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//IMPLEMENTAR ACCION ELIMINAR CERVERZA
			}
		});
		
		JMenuItem deleteEmployee = new JMenuItem("Delete Employee");
		deleteEmployee.setMnemonic(KeyEvent.VK_E);
		deleteEmployee.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
		deleteEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//IMPLEMENTAR ACCION ELIMINAR EMPLEADO
			}
		});
		
		JMenuItem deleteBill = new JMenuItem("Delete Bill");
		deleteBill.setMnemonic(KeyEvent.VK_F);
		deleteBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
		deleteBill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//IMPLEMENTAR ACCION ELIMINAR FACTURA
			}
		});
				
		jMenu.add(deleteMark);
		jMenu.add(deleteBeer);
		jMenu.add(deleteEmployee);
		jMenu.add(deleteBill);
	}
	
	public void addModifyMenu(JMenu jMenu, MainWindow mainWindow) {
		
		JMenuItem modifyMark = new JMenuItem("Modify Mark");
		modifyMark.setMnemonic(KeyEvent.VK_M);
		modifyMark.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
		modifyMark.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				//IMPLEMENTAR ACCION ELIMINAR MARCA
			}
		});
		
		JMenuItem deleteBeer = new JMenuItem("Modify Beer");
		deleteBeer.setMnemonic(KeyEvent.VK_B);
		deleteBeer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
		deleteBeer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//IMPLEMENTAR ACCION ELIMINAR CERVERZA
			}
		});
		
		JMenuItem deleteEmployee = new JMenuItem("Modify Employee");
		deleteEmployee.setMnemonic(KeyEvent.VK_E);
		deleteEmployee.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
		deleteEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//IMPLEMENTAR ACCION ELIMINAR EMPLEADO
			}
		});
		
		JMenuItem deleteBill = new JMenuItem("Modify Bill");
		deleteBill.setMnemonic(KeyEvent.VK_F);
		deleteBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
		deleteBill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//IMPLEMENTAR ACCION ELIMINAR FACTURA
			}
		});
				
		jMenu.add(modifyMark);
		jMenu.add(deleteBeer);
		jMenu.add(deleteEmployee);
		jMenu.add(deleteBill);
	}
}
