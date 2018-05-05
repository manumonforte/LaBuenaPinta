package integracion.factura;

import integracion.gestor.GestorConnexiones;
import presentacion.cerveza.TCerveza;
import presentacion.factura.TFactura;
import presentacion.factura.TLineaFactura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAOImp implements FacturaDAO{
	private Connection conn;

	private final String INSERT = "INSERT INTO factura(empleado) VALUES(?)";
	private final String READALL = "SELECT * FROM factura";
	private final String READ = READALL + " WHERE id_factura = ?";
	private final String READBYCerveza = "SELECT * FROM asociada  WHERE cerveza = ? AND factura = ?";
	private final String UPDATE = "UPDATE factura SET precio_total = ?, empleado = ? WHERE id_factura = ?";
	private final String DELETE = "UPDATE factura  SET abierta = 0 WHERE id_factura = ?";
	private final String NEW = "INSERT INTO asociada VALUES (?,?,?,?)";
	private final String UPDATECantidad = "UPDATE asociada SET cantidad = ? WHERE factura = ? AND cerveza = ?";


	public FacturaDAOImp() {
		this.conn = GestorConnexiones.getInstancia().getConnection();
	}


	@Override
	public void insertar(TFactura e) {
		try (PreparedStatement st = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			st.setInt(1, e.getEmpleado());
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
					f = new TFactura(id, rs.getInt("precio_total"),
							rs.getInt("empleado"), rs.getBoolean("abierta"),null);
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
				lista.add(new TFactura(rs.getInt("id_factura"), rs.getInt("precio_total"),
						rs.getInt("empleado"), rs.getBoolean("abierta"),null));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void modificar(TFactura e) {
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

	@Override
	public void anadirProducto(TLineaFactura linea, TCerveza c) {//TODO MAL
		try (PreparedStatement st = conn.prepareStatement(READBYCerveza)) {
			st.setInt(1,linea.getId_cerveza());
			st.setInt(2,linea.getId_factura());
			try(ResultSet rs = st.executeQuery()) {
				if (!rs.next()) {
					try (PreparedStatement ste = conn.prepareStatement(NEW)) {
						ste.setInt(1, linea.getId_factura());
						ste.setInt(2, linea.getId_cerveza());
						ste.setInt(3, linea.getCantidad());
						ste.setDouble(4, c.getPrecio());
						ste.executeUpdate();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else{
					int parcial = rs.getInt("cantidad");
					try (PreparedStatement ste = conn.prepareStatement(UPDATECantidad)) {
						ste.setInt(1,linea.getCantidad()+parcial);
						ste.setInt(2, linea.getId_factura());
						ste.setInt(3, linea.getId_cerveza());
						ste.executeUpdate();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
}
