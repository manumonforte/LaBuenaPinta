package integracion.empleado;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.empleado.TEmpleado;
import negocio.empleado.TEmpleadoCompleto;
import negocio.empleado.TEmpleadoParcial;
import presentacion.util.TipoTurno;


class EmpleadoDAOImpTest {

	private static Connection conn;
	private EmpleadoDAOImp empleadoDAOImp;
	private TEmpleadoCompleto empCompleto;
	private TEmpleadoParcial empParcial;


	@BeforeAll
	static void beforeAll() {

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LBP", "empleado", "password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@BeforeEach
	void BeforeEach() {

		try (Statement st = conn.createStatement()) {
			st.execute("DELETE FROM empleado_tparcial");
			st.execute("DELETE FROM empleado_tcompleto");
			st.execute("DELETE FROM factura"); // Por si hay algun empleado asociado a factura
			st.execute("DELETE FROM empleado");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		empleadoDAOImp = new EmpleadoDAOImp();
		empCompleto = new TEmpleadoCompleto();
		empParcial = new TEmpleadoParcial();

		// Tiempo completo
		empCompleto.setActivo(true);
		empCompleto.setDNI("xvz123");
		empCompleto.setNombre("EmpComp");
		empCompleto.setTiempo_completo(true);
		empCompleto.setHoras_extra(2);

		// Tiempo Parcial
		empParcial.setActivo(true);
		empParcial.setDNI("tsfsv54");
		empParcial.setNombre("EmpParcial");
		empParcial.setTiempo_completo(false);
		empParcial.setTurno(TipoTurno.m);

	}

	@Test
	void insertarCompleto() {


		empleadoDAOImp.insertar(empCompleto);

		if (empCompleto.getId_empleado() != 0) {
			TEmpleado empleadoInsertado = empleadoDAOImp.mostrar(empCompleto.getId_empleado());
			TEmpleadoCompleto insertado = (TEmpleadoCompleto) empleadoInsertado;
			assertTrue(igualesCompleto(empCompleto, insertado));
		}

	}

	@Test
	void insertarParcial() {
		empleadoDAOImp.insertar(empParcial);

		if (empParcial.getId_empleado() != 0) {
			TEmpleado empleadoInsertado = empleadoDAOImp.mostrar(empParcial.getId_empleado());
			assertTrue(igualesParcial(empParcial, (TEmpleadoParcial) empleadoInsertado));
		}

	}

	@Test
	void eliminarCompleto() {
		empleadoDAOImp.insertar(empCompleto);
		empleadoDAOImp.eliminar(empCompleto.getId_empleado());

		TEmpleado empleadoEliminado = empleadoDAOImp.mostrar(empCompleto.getId_empleado());
		assertFalse(empleadoEliminado.isActivo());
	}

	@Test
	void eliminarParcial() {
		empleadoDAOImp.insertar(empParcial);
		empleadoDAOImp.eliminar(empParcial.getId_empleado());

		TEmpleado empleadoEliminado = empleadoDAOImp.mostrar(empParcial.getId_empleado());
		assertFalse(empleadoEliminado.isActivo());
	}


	@Test
	void modificarCompleto() {

		empleadoDAOImp.insertar(empCompleto);

		empCompleto.setNombre("cambio");
		empCompleto.setDNI("12132h");
		empCompleto.setHoras_extra(5);

		empleadoDAOImp.modificar(empCompleto);
		TEmpleado empleadoModificado = empleadoDAOImp.mostrar(empCompleto.getId_empleado());

		assertTrue(igualesCompleto(empCompleto, (TEmpleadoCompleto) empleadoModificado));

	}

	@Test
	void modificarParcial() {

		empleadoDAOImp.insertar(empParcial);

		empParcial.setNombre("Changes");
		empParcial.setDNI("12isdns7");
		empParcial.setTurno(TipoTurno.t);

		empleadoDAOImp.modificar(empParcial);
		TEmpleado empleadoModificado = empleadoDAOImp.mostrar(empParcial.getId_empleado());

		assertTrue(igualesParcial(empParcial, (TEmpleadoParcial) empleadoModificado));


	}

	@Test
	void mostrarTodos() {


	}

	@Test
	void mostrarPorDNICompleto() {


	}

	@Test
	void mostrarPorDNIParcial() {


	}

	@AfterAll
	static void afterAll() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private boolean igualesParcial(TEmpleadoParcial esper, TEmpleadoParcial resul) {

		return esper.getDNI().equals(resul.getDNI()) &&
				esper.getId_empleado() == resul.getId_empleado() &&
				esper.getNombre().equals(resul.getNombre()) &&
				esper.isTiempo_completo() == resul.isTiempo_completo() &&
				esper.isActivo() == resul.isActivo() &&
				esper.getTurno().equals(esper.getTurno());
	}

	private boolean igualesCompleto(TEmpleadoCompleto esper, TEmpleadoCompleto resul) {

		return esper.getDNI().equals(resul.getDNI()) &&
				esper.getId_empleado() == resul.getId_empleado() &&
				esper.getNombre().equals(resul.getNombre()) &&
				esper.isTiempo_completo() == resul.isTiempo_completo() &&
				esper.isActivo() == resul.isActivo() &&
				esper.getHoras_extra() == resul.getHoras_extra();
	}


}
