package presentacion.transfer;

public class TFactura {
	private int id_factura;
	private int precio_total;
	private int empleado;

	public TFactura() {
	}

	public TFactura(int id_factura, int precio_total, int empleado) {
		this.id_factura = id_factura;
		this.precio_total = precio_total;
		this.empleado = empleado;
	}

	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	public int getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(int precio_total) {
		this.precio_total = precio_total;
	}

	public int getEmpleado() {
		return empleado;
	}

	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}
}
