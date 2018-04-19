package presentacion;

import presentacion.cerveza.PanelCerveza;
import presentacion.controlador.Controlador;
import presentacion.empleado.PanelEmpleado;
import presentacion.factura.PanelFactura;
import presentacion.marca.PanelMarca;

import javax.swing.*;


import java.awt.*;
import java.awt.event.KeyEvent;

public class PanelTabs extends JTabbedPane {

    private PanelCerveza panelCerveza;
    private PanelEmpleado panelEmpleado;
	private PanelMarca panelMarca;
	private PanelFactura panelFactura;
	private JToolBar toolBar;

    public PanelTabs(VentanaPrincipal ventanaPrincipal, Controlador controlador) {
        toolBar = new ToolBar(ventanaPrincipal, controlador);

        JComponent tabCerveza = makeTextPanel("PanelTabs de Cervezas");
        addTab("Cervezas", new ImageIcon("resources/images/beer-16.png"), tabCerveza,"Does nothing");
        setMnemonicAt(0, KeyEvent.VK_1);
        panelCerveza = new PanelCerveza();
		panelCerveza.setLayout(new BorderLayout());
		tabCerveza.add(panelCerveza);
        panelCerveza.add(toolBar, BorderLayout.NORTH);


        JComponent tabEmpleado = makeTextPanel("PanelTabs de Empleados");
        addTab("Empleados", new ImageIcon("resources/images/employee-16.png"), tabEmpleado, "Does twice as much nothing");
        setMnemonicAt(1, KeyEvent.VK_2);
        panelEmpleado = new PanelEmpleado();
        tabEmpleado.add(panelEmpleado);

        JComponent tabMarca = makeTextPanel("PanelTabs de Marcas");
        addTab("Marcas", new ImageIcon("resources/images/company-16.png"), tabMarca, "Still does nothing");
        setMnemonicAt(2, KeyEvent.VK_3);
		tabMarca.add(createPage());

        JComponent tabFactura = makeTextPanel("PanelTabs de Facturas");
        addTab("Facturas", new ImageIcon("resources/images/bill-16.png"), tabFactura, "Does nothing at all");
        setMnemonicAt(3, KeyEvent.VK_4);
		tabFactura.add(createPage());

        //The following line enables to use scrolling tabs.
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        panel.setLayout(new GridLayout(2, 1));
        return panel;
    }

    private JPanel createPage() {
        return new JPanel(new BorderLayout());
    }
}