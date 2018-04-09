package integracion.DAO.mariadb;

import integracion.DAO.interfaces.CervezaDAO;
import negocio.transfer.TCerveza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MariaDBCervezaDAO implements CervezaDAO {
	private Connection conn;

	private final String INSERT = "INSERT INTO cerveza(nombre, stock, graduacion, precio, activa) VALUES(?, ?, ?, ?, ?)";
	private final String READALL = "SELECT * FROM cerveza";
	private final String READ = READALL + " WHERE id_cerveza = ?";
	private final String READBYNAME = READALL + " WHERE nombre = ?";
	private final String READBYBRAND = READALL + " JOIN produce ON id_cerveza = cerveza WHERE marca = ?";
	private final String UPDATE = "UPDATE cerveza SET nombre = ?, stock = ?, graduacion = ?, precio = ?, activa = ? WHERE id_cerveza = ?";
	private final String DELETE = "UPDATE cerveza SET activa = 0 WHERE id_marca = ?";

	public MariaDBCervezaDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertar(TCerveza e) {
		try (PreparedStatement st = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			st.setString(1, e.getNombre());
			st.setInt(2, e.getStock());
			st.setDouble(3, e.getGraduacion());
			st.setDouble(4, e.getPrecio());
			st.setBoolean(5, e.isActiva());
			st.executeUpdate();
			try(ResultSet rs = st.getGeneratedKeys()) {
				if (rs.next()) {
					e.setId_cerveza(rs.getInt(1));
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public TCerveza mostrar(int id) {
		TCerveza c = null;
		try (PreparedStatement st = conn.prepareStatement(READ)) {
			st.setInt(1, id);
			try(ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					c = new TCerveza(id, rs.getString("nombre"), rs.getInt("stock"),
							rs.getDouble("graduacion"), rs.getDouble("precio"), rs.getBoolean("activa"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public TCerveza mostrarPorNombre(String nombre) {
		TCerveza c = null;
		try (PreparedStatement st = conn.prepareStatement(READBYNAME)) {
			st.setString(1, nombre);
			try(ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					c = new TCerveza(rs.getInt("id_cerveza"), rs.getString("nombre"), rs.getInt("stock"),
							rs.getDouble("graduacion"), rs.getDouble("precio"), rs.getBoolean("activa"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<TCerveza> mostrarPorMarca(int id){
		ArrayList<TCerveza> lista = new ArrayList<TCerveza>();
		try (PreparedStatement st = conn.prepareStatement(READBYBRAND); ResultSet rs = st.executeQuery()) {
			while (rs.next()){
				lista.add(new TCerveza(rs.getInt("id_cerveza"), rs.getString("nombre"), rs.getInt("stock"),
						rs.getDouble("graduacion"),rs.getDouble("precio"), rs.getBoolean("activa")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<TCerveza> mostrarTodos() {
		ArrayList<TCerveza> lista = new ArrayList<TCerveza>();
		try (PreparedStatement st = conn.prepareStatement(READALL); ResultSet rs = st.executeQuery()) {
			while (rs.next()){
				lista.add(new TCerveza(rs.getInt("id_cerveza"), rs.getString("nombre"), rs.getInt("stock"),
						rs.getDouble("graduacion"),rs.getDouble("precio"), rs.getBoolean("activa")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void modificar(TCerveza e) {
		try (PreparedStatement st = conn.prepareStatement(UPDATE)) {
			st.setString(1, e.getNombre());
			st.setInt(2, e.getStock());
			st.setDouble(3, e.getGraduacion());
			st.setDouble(4, e.getPrecio());
			st.setBoolean(5, e.isActiva());
			st.setInt(5, e.getId_cerveza());
			st.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void eliminar(int id) {
		try (PreparedStatement st = conn.prepareStatement(DELETE)) {
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
