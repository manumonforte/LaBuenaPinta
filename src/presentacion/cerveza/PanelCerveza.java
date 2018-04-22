package presentacion.cerveza;

import javax.swing.*;

import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCerveza extends JPanel {

	private Controlador controlador;

	public PanelCerveza(Controlador controlador){
		super();
		this.controlador = controlador;
		this.setLayout(new BorderLayout());
		this.add(new ToolBarCerveza(), BorderLayout.NORTH);
	}
}
