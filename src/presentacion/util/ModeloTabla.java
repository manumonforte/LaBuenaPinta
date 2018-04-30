package presentacion.util;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public abstract class ModeloTabla<T> extends DefaultTableModel {
	protected String[] columnIds;
	protected List<T> lista;

	public ModeloTabla(String[] columnIds) {
		lista = null;
		this.columnIds = columnIds;
	}

	@Override
	public String getColumnName(int col) {
		return columnIds[col];
	}

	@Override
	public int getColumnCount() {
		return columnIds.length;
	}

	@Override
	public int getRowCount() {
		return lista == null ? 0 : lista.size();
	}
}