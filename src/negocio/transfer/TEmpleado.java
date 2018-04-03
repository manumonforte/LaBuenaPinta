package negocio.transfer;

public class TEmpleado {

	private int id_empleado;
	private String nombre;
	private int telefono;
	private boolean tiempo_completo;

	public TEmpleado(int id_empleado, String nombre, int telefono, boolean tiempo_completo) {
		this.id_empleado = id_empleado; //TODO revisar
		this.nombre = nombre;
		this.telefono = telefono;
		this.tiempo_completo = tiempo_completo;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public boolean isTiempo_completo() {
		return tiempo_completo;
	}

	public void setTiempo_completo(boolean tiempo_completo) {
		this.tiempo_completo = tiempo_completo;
	}
}
