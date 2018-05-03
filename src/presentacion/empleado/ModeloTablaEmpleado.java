package presentacion.empleado;

import presentacion.util.ModeloTabla;

public class ModeloTablaEmpleado extends ModeloTabla<TEmpleado> {
	public ModeloTablaEmpleado(String[] columnIds) {
		super(columnIds);
	}

	@Override
	public Object getValueAt(int indiceFil, int indiceCol) {
		Object s = null;
		switch (indiceCol) {
			case 0:
				s = lista.get(indiceFil).getId_empleado();
				break;
			case 1:
				s = lista.get(indiceFil).getNombre();
				break;
			case 2:
				s = lista.get(indiceFil).getDNI();
				break;
			case 3:
				//s = lista.get(indiceFil).get();
				break;
			case 4:
				//s = lista.get(indiceFil).isActiva(); TODO !!!!!!!!!!!!!
				break;
			default:
				assert (false);
		}
		return s;
	}
}
