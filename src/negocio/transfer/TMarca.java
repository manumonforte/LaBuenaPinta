package negocio.transfer;

public class TMarca {
	private int id_marca;
	private String nombre;
	private String sede;
	private String pais;
	private boolean activa;

	public TMarca(int id_marca, String nombre, String sede, String pais, boolean activa) {
		this.id_marca = id_marca; //TODO revisar
		this.nombre = nombre;
		this.sede = sede;
		this.pais = pais;
		this.activa = activa;
	}

	public int getId_marca() {
		return id_marca;
	}

	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
}
