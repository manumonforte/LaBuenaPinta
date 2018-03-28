package DAO.mariadb;

import DAO.interfaces.CervezaDAO;
import modelo.Cerveza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MariaDBCervezaDao implements CervezaDAO {
	private Connection conn;

	private final String INSERT = "INSERT INTO cerveza(nombre, stock, graduacion, precio, activa) VALUES(?, ?, ?, ?, ?)";
	private final String READALL = "SELECT * FROM cerveza";
	private final String READ = READALL + "WHERE id_cerveza = ?";
	private final String UPDATE = "UPDATE cerveza SET nombre = ?, stock = ?, graduacion = ?, precio = ?, activa = ? WHERE id_cerveza = ?";
	private final String DELETE = "DELETE FROM cerveza WHERE id_cerveza = ?";

	public MariaDBCervezaDao(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertar(Cerveza e) {
		try (PreparedStatement st = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			st.setString(1, e.getNombre());
			st.setInt(2, e.getStock());
			st.setDouble(3, e.getGraduacion());
			st.setDouble(4, e.getPrecio());
			st.setBoolean(5, e.isActiva());
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				e.setId_cerveza(rs.getInt(1));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public Cerveza mostrar(int id) {
		Cerveza c = null;
		try (PreparedStatement st = conn.prepareStatement(READ)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()){
				c = new Cerveza(id, rs.getString("nombre"), rs.getInt("stock"),
						rs.getDouble("graduacion"),rs.getDouble("precio"), rs.getBoolean("activa"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Cerveza> mostrarTodos() {
		ArrayList<Cerveza> lista = new ArrayList<Cerveza>();
		try (PreparedStatement st = conn.prepareStatement(READALL)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				lista.add(new Cerveza(rs.getInt("id_cerveza"), rs.getString("nombre"), rs.getInt("stock"),
						rs.getDouble("graduacion"),rs.getDouble("precio"), rs.getBoolean("activa")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void modificar(Cerveza e) {
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
	public void eliminar(Cerveza e) {
		try (PreparedStatement st = conn.prepareStatement(DELETE)) {
			st.setInt(1, e.getId_cerveza());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
