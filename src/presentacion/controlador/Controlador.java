package presentacion.controlador;

public abstract class Controlador {
	private static Controlador instancia = null;

	abstract public void accion(Eventos evento, Object datos);

	public static Controlador getInstancia() {
		if (instancia == null) {
			instancia = new ControladorImp();
		}
		return instancia;
	}
}
