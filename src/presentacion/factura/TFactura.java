package presentacion.factura;

public class TFactura {
	private int id_factura;
	private int precio_total;
	private int empleado;
	private boolean abierta;

	public TFactura() {
	}

	public TFactura(int id_factura, int precio_total, int empleado, boolean abierta) {
		this.id_factura = id_factura;
		this.precio_total = precio_total;
		this.empleado = empleado;
		this.abierta = abierta;
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

	public boolean isAbierta() {
		return abierta;
	}

	public void setAbierta(boolean abierta) {
		this.abierta = abierta;
	}
}
