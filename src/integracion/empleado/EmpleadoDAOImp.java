package integracion.empleado;

import integracion.gestor.GestorConnexiones;
import presentacion.transfer.TEmpleado;
import presentacion.transfer.TEmpleadoCompleto;
import presentacion.transfer.TEmpleadoParcial;
import presentacion.util.tipoTurno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOImp implements EmpleadoDAO {
	private Connection conn;

	private final String INSERT = "INSERT INTO empleado(nombre, DNI, activo) VALUES(?, ?, ?)";
	private final String INSERTCompleto = "INSERT INTO empleado_tcompleto(id_empleado, horas_extra) VALUES(?, ?)";
	private final String INSERTParcial = "INSERT INTO empleado_tparcial(id_empleado, turno) VALUES(?, ?)";
	private final String READALL = "SELECT * FROM empleado\n" +"   LEFT JOIN empleado_tcompleto USING (id_empleado)\n" +
									"  LEFT JOIN empleado_tparcial USING (id_empleado)";
	private final String READ = READALL + " WHERE id_empleado = ?";
	private final String READBYDNI = READALL + " WHERE DNI = ?";
	private final String UPDATE = "UPDATE empleado SET nombre = ?, DNI = ?, tiempo_completo = ? WHERE id_empleado = ?";
	private final String DELETE = "UPDATE empleado SET activo = 0 WHERE id_empleado = ?";

	public EmpleadoDAOImp() {
		this.conn = GestorConnexiones.getInstancia().getConnection();
	}

	@Override
	public void insertar(TEmpleado e) {
		try (PreparedStatement st = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			st.setString(1, e.getNombre());
			st.setString(2, e.getDNI());
			st.setBoolean(3, e.isActivo());
			st.executeUpdate();
			try (ResultSet rs = st.getGeneratedKeys()) {
				if (rs.next()) {
					e.setId_empleado(rs.getInt(1));
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//Introducimos en la tabla empleado
		if(!e.isTiempo_completo()) {
			TEmpleadoParcial empleadoParcial = (TEmpleadoParcial) e;
			try (PreparedStatement ste = conn.prepareStatement(INSERTParcial, PreparedStatement.RETURN_GENERATED_KEYS)) {
				ste.setInt(1, e.getId_empleado());
				ste.setString(2, empleadoParcial.getTurno().toString());
				ste.executeUpdate();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else{
			TEmpleadoCompleto empleadoCompleto = (TEmpleadoCompleto) e;
			try (PreparedStatement ste = conn.prepareStatement(INSERTCompleto, PreparedStatement.RETURN_GENERATED_KEYS)) {
				ste.setInt(1, e.getId_empleado());
				ste.setInt(2, empleadoCompleto.getHoras_extra());
				ste.executeUpdate();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public TEmpleado mostrar(int id) {
		TEmpleado e = null;
		try (PreparedStatement st = conn.prepareStatement(READ)) {
			st.setInt(1, id);
			try(ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					int horas = rs.getInt("horas_extra");
					if(rs.wasNull()){
						tipoTurno turno;
						if(rs.getString("turno").equals("m")) turno =tipoTurno.m;
						else turno = tipoTurno.t;

						TEmpleadoParcial empleadoParcial = new TEmpleadoParcial(rs.getInt("id_empleado"),
								rs.getString("nombre"),
								rs.getString("DNI"),
								rs.getBoolean("activo"),
								turno);
						return empleadoParcial;
					}
					else{
						TEmpleadoCompleto empleadoCompleto = new TEmpleadoCompleto(rs.getInt("id_empleado"),
								rs.getString("nombre"),
								rs.getString("DNI"),
								rs.getBoolean("activo"),
								horas);
						return empleadoCompleto;
					}
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@Override
	public TEmpleado mostrarPorDNI(String DNI) {
		TEmpleado e = null;
		try (PreparedStatement st = conn.prepareStatement(READBYDNI)) {
			st.setString(1, DNI);
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					e = new TEmpleado(rs.getInt("id_empleado"),
							rs.getString("nombre"),
							rs.getString("DNI"),
							rs.getBoolean("activo"),
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
				int horas = rs.getInt("horas_extra");
				if(rs.wasNull()){
					tipoTurno turno;
					if(rs.getString("turno").equals("m")) turno =tipoTurno.m;
					else turno = tipoTurno.t;

					TEmpleadoParcial empleadoParcial = new TEmpleadoParcial(rs.getInt("id_empleado"),
							rs.getString("nombre"),
							rs.getString("DNI"),
							rs.getBoolean("activo"),
							turno);
					lista.add(empleadoParcial);
				}
				else{
					TEmpleadoCompleto empleadoCompleto = new TEmpleadoCompleto(rs.getInt("id_empleado"),
							rs.getString("nombre"),
							rs.getString("DNI"),
							rs.getBoolean("activo"),
							horas);
					lista.add(empleadoCompleto);
				}
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
			st.setString(2, e.getDNI());
			st.setInt(4, e.getId_empleado());
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
