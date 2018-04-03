package integracion.DAO.mariadb;

import integracion.DAO.interfaces.MarcaDAO;
import negocio.transfer.TMarca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MariaDBMarcaDAO implements MarcaDAO {
	private Connection conn;

	private final String INSERT = "INSERT INTO marca(nombre, sede, pais, activa) VALUES(?, ?, ?, ?)";
	private final String READALL = "SELECT * FROM marca";
	private final String READ = READALL + " WHERE id_marca = ?";
	private final String UPDATE = "UPDATE marca SET nombre = ?, sede = ?, pais = ?, activa = ? WHERE id_marca = ?";
	private final String DELETE = "DELETE FROM marca WHERE id_marca = ?";

	public MariaDBMarcaDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertar(TMarca e) {
		try (PreparedStatement st = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			st.setString(1, e.getNombre());
			st.setString(2, e.getSede());
			st.setString(3, e.getPais());
			st.setBoolean(4, e.isActiva());
			st.executeUpdate();
			try(ResultSet rs = st.getGeneratedKeys()){
				if (rs.next()) {
					e.setId_marca(rs.getInt(1));
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public TMarca mostrar(int id) {
		TMarca m = null;
		try (PreparedStatement st = conn.prepareStatement(READ)) {
			st.setInt(1, id);
			try(ResultSet rs = st.executeQuery()){
				if (rs.next()){
					m = new TMarca(id, rs.getString("nombre"), rs.getString("sede"),
							rs.getString("pais"), rs.getBoolean("activa"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public List<TMarca> mostrarTodos() {
		ArrayList<TMarca> lista = new ArrayList<TMarca>();
		try (PreparedStatement st = conn.prepareStatement(READALL); ResultSet rs = st.executeQuery()) {
			while (rs.next()) {
				lista.add(new TMarca(rs.getInt("id_marca"), rs.getString("nombre"), rs.getString("sede"),
						rs.getString("pais"), rs.getBoolean("activa")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void modificar(TMarca e) {
		try (PreparedStatement st = conn.prepareStatement(UPDATE)) {
			st.setString(1, e.getNombre());
			st.setString(2, e.getSede());
			st.setString(3, e.getPais());
			st.setBoolean(4, e.isActiva());
			st.setInt(5, e.getId_marca());
			st.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void eliminar(TMarca e) {
		try (PreparedStatement st = conn.prepareStatement(DELETE)) {
			st.setInt(1, e.getId_marca());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
