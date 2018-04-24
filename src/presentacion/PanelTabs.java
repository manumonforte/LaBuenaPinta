package presentacion;

import presentacion.cerveza.PanelCerveza;
import presentacion.empleado.PanelEmpleado;
import presentacion.factura.PanelFactura;
import presentacion.marca.PanelMarca;

import javax.swing.*;


import java.awt.*;
import java.awt.event.KeyEvent;

class PanelTabs extends JTabbedPane {

    private PanelCerveza panelCerveza;
    private PanelEmpleado panelEmpleado;
	private PanelMarca panelMarca;
	private PanelFactura panelFactura;

    PanelTabs() {
        //vista cerveza
        JComponent tabCerveza = crearPanelDeTexto("PanelTabs de Cervezas");
        addTab("Cervezas", new ImageIcon("resources/images/beer-16.png"), tabCerveza,"Vista cerveza");
        setMnemonicAt(0, KeyEvent.VK_1);
        panelCerveza = new PanelCerveza();
        tabCerveza.add(panelCerveza);

        //vista empleado
        JComponent tabEmpleado = crearPanelDeTexto("PanelTabs de Empleados");
        addTab("Empleados", new ImageIcon("resources/images/employee-16.png"), tabEmpleado, "Vista empleado");
        setMnemonicAt(1, KeyEvent.VK_2);
        panelEmpleado = new PanelEmpleado();
        tabEmpleado.add(panelEmpleado);

        //vista marca
        JComponent tabMarca = new JPanel(new GridLayout(1, 1));
        addTab("Marcas", new ImageIcon("resources/images/company-16.png"), tabMarca, "Vista marca");
        setMnemonicAt(2, KeyEvent.VK_3);
        panelMarca = new PanelMarca();
        tabMarca.add(panelMarca);

        //vista factura
        JComponent tabFactura = crearPanelDeTexto("PanelTabs de Facturas");
        addTab("Facturas", new ImageIcon("resources/images/bill-16.png"), tabFactura, "Vista factura");
        setMnemonicAt(3, KeyEvent.VK_4);
        panelFactura = new PanelFactura();
        tabFactura.add(panelFactura);

        //The following line enables to use scrolling tabs.
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    private JComponent crearPanelDeTexto(String text) {
        JPanel panel = new JPanel(false);
        panel.setLayout(new GridLayout(2, 1));
        return panel;
    }
}