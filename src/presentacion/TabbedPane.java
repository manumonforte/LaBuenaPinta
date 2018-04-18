package presentacion;

import presentacion.controlador.Controlador;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;


import java.awt.GridLayout;
import java.awt.event.KeyEvent;

public class TabbedPane extends JPanel {
	
    public TabbedPane(MainWindow mainWindow, Controlador controlador) {
        super(new GridLayout(1, 1));
        
        JTabbedPane tabbedPane = new JTabbedPane();

        JComponent panelBeer = makeTextPanel("Panel de Cervezas");
        tabbedPane.addTab("Cervezas", new ImageIcon("resources/images/beer-16.png"), panelBeer,"Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        JComponent panelEmployee = makeTextPanel("Panel de Empleados");
        tabbedPane.addTab("Empleados", new ImageIcon("resources/images/employee-16.png"), panelEmployee, "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        JComponent panelCompany = makeTextPanel("Panel de Marcas");
        tabbedPane.addTab("Marcas", new ImageIcon("resources/images/company-16.png"), panelCompany, "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        
        JComponent panelBill = makeTextPanel("Panel de Facturas");
        tabbedPane.addTab("Facturas", new ImageIcon("resources/images/bill-16.png"), panelBill, "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        
        //Add the tabbed pane to this panel.
        add(tabbedPane);
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
    
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}
