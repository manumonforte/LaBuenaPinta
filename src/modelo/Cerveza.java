package modelo;

public class Cerveza {
	private int id_cerveza;
	private String nombre;
	private int stock;
	private double graduacion;
	private double precio;
	private boolean activa;

	public Cerveza(int id_cerveza, String nombre, int stock, double graduacion, double precio, boolean activa) {
		this.id_cerveza = id_cerveza; //TODO revisar
		this.nombre = nombre;
		this.stock = stock;
		this.graduacion = graduacion;
		this.precio = precio;
		this.activa = activa;
	}

	public int getId_cerveza() {
		return id_cerveza;
	}

	public void setId_cerveza(int id_marca) {
		this.id_cerveza = id_marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getGraduacion() {
		return graduacion;
	}

	public void setGraduacion(double graduacion) {
		this.graduacion = graduacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

}
