package integracion.DAO.mariadb;

import integracion.DAO.interfaces.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariadDBGestorDAO implements GestorDAO {

	private static MariadDBGestorDAO instancia = new MariadDBGestorDAO();

	private Connection conn;

	private MariadDBGestorDAO() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LBP", "empleado", "password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static MariadDBGestorDAO getInstancia() {
		return instancia;
	}

	@Override
	public CervezaDAO getCervezaDAO() {
		return new MariaDBCervezaDAO(conn);
	}

	@Override
	public EmpleadoDAO getEmpleadoDAO() {
		return new MariaDBEmpleadoDAO(conn);

	}

	@Override
	public FacturaDAO getFacturaDAO() {
		return new MariaDBFacturaDAO(conn);

	}

	@Override
	public MarcaDAO getMarcaDAO() {
		return new MariaDBMarcaDAO(conn);

	}

	public void cerrarConnection(){
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
