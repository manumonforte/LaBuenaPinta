package presentacion.marca;

import negocio.marca.TMarca;
import presentacion.util.ModeloTabla;

public class ModeloTablaMarca extends ModeloTabla<TMarca> {
	public ModeloTablaMarca(String[] columnIds) {
		super(columnIds);
	}

	@Override
	public Object getValueAt(int indiceFil, int indiceCol) {
		Object s = null;
		switch (indiceCol) {
			case 0:
				s = lista.get(indiceFil).getId_marca();
				break;
			case 1:
				s = lista.get(indiceFil).getNombre();
				break;
			case 2:
				s = lista.get(indiceFil).getSede();
				break;
			case 3:
				s = lista.get(indiceFil).getPais();
				break;
			case 4:
				s = lista.get(indiceFil).isActiva();
				break;
			default:
				assert (false);
		}
		return s;
	}
}
