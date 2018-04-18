package integracion.empleado;

import integracion.FactoriaGestor.GestorConnexiones;
import presentacion.transfer.TEmpleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOImp implements EmpleadoDAO {
	private Connection conn;

	private final String INSERT = "INSERT INTO empleado(nombre, telefono, tiempo_completo) VALUES(?, ?, ?)";
	private final String READALL = "SELECT * FROM empleado";
	private final String READ = READALL + " WHERE id_empleado = ?";
	private final String UPDATE = "UPDATE empleado SET nombre = ?, telefono = ?, tiempo_completo = ? WHERE id_marca = ?";
	private final String DELETE = "DELETE FROM empleado WHERE id_empleado = ?";

	public EmpleadoDAOImp() {
		this.conn = GestorConnexiones.getInstancia().getConnection();
	}

	@Override
	public void insertar(TEmpleado e) {
		try (PreparedStatement st = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			st.setString(1, e.getNombre());
			st.setInt(2, e.getTelefono());
			st.setBoolean(3, e.isTiempo_completo());
			st.executeUpdate();
			try (ResultSet rs = st.getGeneratedKeys()) {
				if (rs.next()) {
					e.setId_empleado(rs.getInt(1));
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public TEmpleado mostrar(int id) {
		TEmpleado e = null;
		try (PreparedStatement st = conn.prepareStatement(READ)) {
			st.setInt(1, id);
			try(ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					e = new TEmpleado(id,
							rs.getString("nombre"),
							rs.getInt("telefono"),
							rs.getBoolean("tiempo_completo"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@Override
	public List<TEmpleado> mostrarTodos() {
		ArrayList<TEmpleado> lista = new ArrayList<TEmpleado>();
		try (PreparedStatement st = conn.prepareStatement(READALL); ResultSet rs = st.executeQuery()) {
			while (rs.next()) {
				lista.add(new TEmpleado(rs.getInt("id_empleado"),
						rs.getString("nombre"),
						rs.getInt("telefono"),
						rs.getBoolean("tiempo_completo")));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return lista;
	}

	@Override
	public void modificar(TEmpleado e) {
		try (PreparedStatement st = conn.prepareStatement(UPDATE)) {
			st.setString(1, e.getNombre());
			st.setInt(2, e.getTelefono());
			st.setBoolean(3, e.isTiempo_completo());
			st.setInt(5, e.getId_empleado());
			st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void eliminar(int id) {
		try (PreparedStatement st = conn.prepareStatement(DELETE)) {
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
