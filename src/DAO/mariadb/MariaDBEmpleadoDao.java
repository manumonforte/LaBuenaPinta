package DAO.mariadb;

import DAO.interfaces.EmpleadoDAO;
import modelo.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MariaDBEmpleadoDao implements EmpleadoDAO {
    private Connection conn;

    private final String INSERT = "INSERT INTO empleado(nombre, telefono, tiempo_completo) VALUES(?, ?, ?)";
    private final String READALL = "SELECT * FROM empleado";
    private final String READ = READALL + "WHERE id_empleado = ?";
    private final String UPDATE = "UPDATE empleado SET nombre = ?, telefono = ?, tiempo_completo = ? WHERE id_marca = ?";
    private final String DELETE = "DELETE FROM empleado WHERE id_empleado = ?";

    public MariaDBEmpleadoDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Empleado e) {
        try (PreparedStatement st = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            st.setString(1, e.getNombre());
            st.setInt(2, e.getTelefono());
            st.setBoolean(3, e.isTiempo_completo());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                e.setId_empleado(rs.getInt(1));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Empleado mostrar(int id) {
        Empleado e = null;
        try (PreparedStatement st = conn.prepareStatement(READ)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                e = new Empleado(id,
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getBoolean("tiempo_completo"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }

    @Override
    public List<Empleado> mostrarTodos() {
        ArrayList<Empleado> lista = new ArrayList<Empleado>();
        try (PreparedStatement st = conn.prepareStatement(READALL)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                lista.add(new Empleado(rs.getInt("id_empleado"),
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
    public void modificar(Empleado e) {
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
    public void eliminar(Empleado e) {
        try (PreparedStatement st = conn.prepareStatement(DELETE)) {
            st.setInt(1, e.getId_empleado());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
