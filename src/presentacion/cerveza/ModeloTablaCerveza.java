package presentacion.cerveza;

import negocio.cerveza.TCerveza;
import presentacion.util.ModeloTabla;

public class ModeloTablaCerveza extends ModeloTabla<TCerveza> {
	public ModeloTablaCerveza(String[] columnIds) {
		super(columnIds);
	}

	@Override
	public Object getValueAt(int indiceFil, int indiceCol) {
		Object s = null;
		switch (indiceCol) {
			case 0:
				s = lista.get(indiceFil).getId_cerveza();
				break;
			case 1:
				s = lista.get(indiceFil).getNombre();
				break;
			case 2:
				s = lista.get(indiceFil).getStock();
				break;
			case 3:
				s = lista.get(indiceFil).getGraduacion();
				break;
			case 4:
				s = lista.get(indiceFil).getPrecio();
				break;
			case 5:
				s = lista.get(indiceFil).get_marca();
				break;
			case 6:
				s = lista.get(indiceFil).isActiva();
				break;
			default:
				assert (false);
		}
		return s;
	}
}
