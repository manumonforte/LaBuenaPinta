package presentacion.transfer;

public class TEmpleado {

	private int id_empleado;
	private String nombre;
	private String DNI;
	private boolean tiempo_completo;
	private boolean activo;

	public TEmpleado(int id_empleado, String nombre, String DNI, boolean tiempo_completo) {
		this.id_empleado = id_empleado; //TODO revisar
		this.nombre = nombre;
		this.DNI = DNI;
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

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public boolean isTiempo_completo() {
		return tiempo_completo;
	}

	public void setTiempo_completo(boolean tiempo_completo) {
		this.tiempo_completo = tiempo_completo;
	}

	public boolean isActivo() {
		return activo;
	}

	public TEmpleado setActivo(boolean activo) {
		this.activo = activo;
		return this;
	}
}
