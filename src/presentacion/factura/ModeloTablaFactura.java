package presentacion.factura;

import presentacion.util.ModeloTabla;

public class ModeloTablaFactura extends ModeloTabla<TFactura> {
	public ModeloTablaFactura(String[] columnIds) {
		super(columnIds);
	}

	@Override
	public Object getValueAt(int indiceFil, int indiceCol) {
		Object s = null;
		switch (indiceCol) {
			case 0:
				s = lista.get(indiceFil).getId_factura();
				break;
			case 1:
				s = lista.get(indiceFil).getPrecio_total();
				break;
			case 2:
				s = lista.get(indiceFil).getEmpleado();
				break;
			default:
				assert (false);
		}
		return s;
	}
}
