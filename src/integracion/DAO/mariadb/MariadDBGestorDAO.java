package integracion.DAO.mariadb;

import integracion.DAO.interfaces.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariadDBGestorDAO implements GestorDAO {

	private static MariadDBGestorDAO instancia = new MariadDBGestorDAO();

	private Connection conn;

	private CervezaDAO cerveza = null;
	private EmpleadoDAO empleado = null;
	private FacturaDAO factura = null;
	private MarcaDAO marca = null;

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
		if (cerveza == null) {
			cerveza = new MariaDBCervezaDAO(conn);
		}
		return cerveza;
	}

	@Override
	public EmpleadoDAO getEmpleadoDAO() {
		if (empleado == null) {
			empleado = new MariaDBEmpleadoDAO(conn);
		}
		return empleado;
	}

	@Override
	public FacturaDAO getFacturaDAO() {
		if (factura == null) {
			factura = new MariaDBFacturaDAO(conn);
		}
		return factura;
	}

	@Override
	public MarcaDAO getMarcaDAO() {
		if (marca == null) {
			marca = new MariaDBMarcaDAO(conn);
		}
		return marca;
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
