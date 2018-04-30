package presentacion;

import presentacion.cerveza.PanelCerveza;
import presentacion.empleado.PanelEmpleado;
import presentacion.factura.PanelFactura;
import presentacion.marca.PanelMarca;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;

class PanelTabs extends JTabbedPane {

	private PanelCerveza panelCerveza;
	private PanelEmpleado panelEmpleado;
	private PanelMarca panelMarca;
	private PanelFactura panelFactura;

	PanelTabs() {
		//vista marca
		JComponent tabMarca = new JPanel(new GridLayout(1, 1));
		addTab("Marcas", new ImageIcon("resources/images/company-16.png"), tabMarca, "Vista marca");
		setMnemonicAt(0, KeyEvent.VK_1);
		panelMarca = new PanelMarca();
		tabMarca.add(panelMarca);

		//vista cerveza
		JComponent tabCerveza = new JPanel(new GridLayout(1, 1));
		addTab("Cervezas", new ImageIcon("resources/images/beer-16.png"), tabCerveza, "Vista cerveza");
		setMnemonicAt(1, KeyEvent.VK_2);
		panelCerveza = new PanelCerveza();
		tabCerveza.add(panelCerveza);

		//vista empleado
		JComponent tabEmpleado = new JPanel(new GridLayout(1, 1));
		addTab("Empleados", new ImageIcon("resources/images/employee-16.png"), tabEmpleado, "Vista empleado");
		setMnemonicAt(2, KeyEvent.VK_3);
		panelEmpleado = new PanelEmpleado();
		tabEmpleado.add(panelEmpleado);

		//vista factura
		JComponent tabFactura = new JPanel(new GridLayout(1, 1));
		addTab("Facturas", new ImageIcon("resources/images/bill-16.png"), tabFactura, "Vista factura");
		setMnemonicAt(3, KeyEvent.VK_4);
		panelFactura = new PanelFactura();
		tabFactura.add(panelFactura);

		//The following line enables to use scrolling tabs.
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent changeEvent) {
				switch (getSelectedIndex()) {//TODO
					case 1:
						//Controlador.getInstancia().accion(Eventos.mostraTodos_Marca, null);
						break;
					case 2:
						//Controlador.getInstancia().accion(Eventos.mostraTodos_Cerveza, null);
						break;
					case 3:
						//Controlador.getInstancia().accion(Eventos.mostraTodos_Empleado, null);
						break;
					case 4:
						//Controlador.getInstancia().accion(Eventos.mostraTodos_Factura, null);
						break;
				}
			}
		});
	}
}