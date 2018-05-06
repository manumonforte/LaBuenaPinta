package presentacion.factura;

import java.util.List;

public class TFactura {
	private int id_factura;
	private double precio_total;
	private int empleado;
	private List<TLineaFactura> lineaFacturas;
	private boolean abierta;

	public TFactura() {
	}

	public TFactura(int id_factura, double precio_total, int empleado, boolean abierta,List<TLineaFactura> lineaFacturaLista) {
		this.id_factura = id_factura;
		this.precio_total = precio_total;
		this.empleado = empleado;
		this.abierta = abierta;
		this.lineaFacturas = lineaFacturaLista;
	}

	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	public double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(double precio_total) {
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

	public List<TLineaFactura> getLineaFacturas() { return lineaFacturas; }

	public void setLineaFacturas(List<TLineaFactura> lineaFacturas) { this.lineaFacturas = lineaFacturas; }

	@Override
	public String toString() {
		String s = "";
		s = "*****Factura*****\n"
				+"ID: " +getId_factura() + "\n"
				+"Empleado : " +getEmpleado() +"\n"
				+"Precio_total: "+ getPrecio_total()+ "\n";
		for (TLineaFactura l: getLineaFacturas()) {
			s+= l.toString();
		}
		return s;
	}
}
