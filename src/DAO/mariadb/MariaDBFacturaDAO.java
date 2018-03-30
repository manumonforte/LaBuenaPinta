package DAO.mariadb;

import DAO.interfaces.FacturaDAO;
import modelo.transfer.TFactura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MariaDBFacturaDAO implements FacturaDAO{
	private Connection conn;

	private final String INSERT = "INSERT INTO factura(precio_total, empleado) VALUES(?, ?)";
	private final String READALL = "SELECT * FROM factura";
	private final String READ = READALL + "WHERE id_factura = ?";
	private final String UPDATE = "UPDATE factura SET precio_total = ?, empleado = ? WHERE id_factura = ?";
	private final String DELETE = "DELETE FROM factura WHERE id_factura = ?";

	public MariaDBFacturaDAO(Connection conn) {
		this.conn = conn;
	}


	@Override
	public void insertar(TFactura e) {
		try (PreparedStatement st = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			st.setInt(1, e.getPrecio_total());
			st.setInt(2, e.getEmpleado());
			st.executeUpdate();
			try(ResultSet rs = st.getGeneratedKeys()) {
				if (rs.next()) {
					e.setId_factura(rs.getInt(1));
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public TFactura mostrar(int id) {
		TFactura f = null;
		try (PreparedStatement st = conn.prepareStatement(READ)) {
			st.setInt(1, id);
			try(ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					f = new TFactura(id, rs.getInt("precio_total"), rs.getInt("empleado"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<TFactura> mostrarTodos() {
		ArrayList<TFactura> lista = new ArrayList<TFactura>();
		try (PreparedStatement st = conn.prepareStatement(READALL); ResultSet rs = st.executeQuery()) {
			while (rs.next()){
				lista.add(new TFactura(rs.getInt("id_factura"), rs.getInt("precio_total"), rs.getInt("empleado")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void modificar(TFactura e) {
		try (PreparedStatement st = conn.prepareStatement(UPDATE)) {
			st.setInt(1, e.getPrecio_total());
			st.setInt(2, e.getEmpleado());
			st.setInt(3, e.getId_factura());
			st.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void eliminar(TFactura e) {
		try (PreparedStatement st = conn.prepareStatement(DELETE)) {
			st.setInt(1, e.getId_factura());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
