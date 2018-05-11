/*
 *     This file is part of LaBuenaPinta.
 *
 *     LaBuenaPinta is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     LaBuenaPinta is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with LaBuenaPinta.  If not, see <http://www.gnu.org/licenses/>.
 */

package integracion.factura;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import integracion.empleado.EmpleadoDAOImp;
import negocio.empleado.TEmpleadoCompleto;
import negocio.factura.TFactura;


class FacturaDAOImpTest {

	private static Connection conn;
	private FacturaDAOImp facturaDAOImp;
	private TFactura factura;

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
			st.execute("DELETE FROM factura");
			st.execute("DELETE FROM empleado");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Para poder crear una factura tiene que haber 
		// algun empleado registrado previamente

		facturaDAOImp = new FacturaDAOImp();
		EmpleadoDAOImp empleadoDAOImp = new EmpleadoDAOImp();


		factura = new TFactura();

		TEmpleadoCompleto empleadoAsociado = new TEmpleadoCompleto();
		empleadoAsociado.setActivo(true);
		empleadoAsociado.setDNI("N123");
		empleadoAsociado.setNombre("Employer");
		empleadoAsociado.setTiempo_completo(true);
		empleadoAsociado.setHoras_extra(2);


		empleadoDAOImp.insertar(empleadoAsociado);
		factura.setEmpleado(empleadoAsociado.getId_empleado());
	}

	@Test
	void insertar() {

		facturaDAOImp.insertar(factura);

		if (factura.getId_factura() != 0) {
			TFactura facturaInsertada = facturaDAOImp.mostrar(factura.getId_factura());
			assertTrue(iguales(factura, facturaInsertada));
		}

	}

	@Test
	void eliminar() {
		facturaDAOImp.insertar(factura);
		facturaDAOImp.eliminar(factura.getId_factura());

		assertNull(facturaDAOImp.mostrar(factura.getId_factura()));

	}

	void anadirPorducto() {


	}

	void mostrarTodos() {


	}

	@AfterAll
	static void afterAll() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private boolean iguales(TFactura esper, TFactura resul) {

		return esper.getId_factura() == resul.getId_factura() &&
				esper.getEmpleado() == resul.getEmpleado() &&
				esper.getPrecio_total() == resul.getPrecio_total();
		// falta comparar dos listas
		//esper.getLineaFacturas().equals(resul.getLineaFacturas());
	}


}
