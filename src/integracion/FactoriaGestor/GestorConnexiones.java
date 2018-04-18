package integracion.FactoriaGestor;

import java.sql.Connection;

public abstract class GestorConnexiones {
	private static GestorConnexiones instancia = null;

	public static GestorConnexiones getInstancia() {
		if (instancia == null) {
			instancia = new GestorConexionesImp();
		}
		return instancia;
	}
	public abstract Connection getConnection();
}
