package presentacion.empleado;

import negocio.empleado.TEmpleado;
import negocio.empleado.TEmpleadoCompleto;
import negocio.empleado.TEmpleadoParcial;
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
				s = lista.get(indiceFil).isActivo();
				break;
			case 4:
				s = lista.get(indiceFil).isTiempo_completo() ?
						((TEmpleadoCompleto) lista.get(indiceFil)).getHoras_extra() : "";
				break;
			case 5:
				s = !lista.get(indiceFil).isTiempo_completo() ?
						((TEmpleadoParcial) lista.get(indiceFil)).getTurno() : "";
				break;
			default:
				assert (false);
		}
		return s;
	}
}
