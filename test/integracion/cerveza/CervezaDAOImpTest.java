package integracion.cerveza;

import org.junit.jupiter.api.*;

import integracion.marca.MarcaDAOImp;
import presentacion.cerveza.TCerveza;
import presentacion.marca.TMarca;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


class CervezaDAOImpTest {

	private CervezaDAOImp cervezaDAOImp;
	private MarcaDAOImp marcaDAOImp;
	private static Connection conn;
	private TCerveza cerveza1;
	private TCerveza cerveza2;
	private TMarca marcaAsociada;
	
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
		
		try(Statement st = conn.createStatement()){
			st.execute("DELETE FROM cerveza");
			st.execute("DELETE FROM marca");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cervezaDAOImp = new CervezaDAOImp();
		marcaDAOImp = new MarcaDAOImp();
		
		cerveza1 = new TCerveza();
		cerveza2 = new TCerveza();
		
		// Cerveza 1
		cerveza1.setGraduacion(30.2);
		cerveza1.setNombre("5estrellas");
		cerveza1.setPrecio(10);
		cerveza1.setActiva(true);
		cerveza1.setStock(10);
		
		// Cerveza 2
		cerveza2.setGraduacion(40.2);
		cerveza2.setNombre("Clasica");
		cerveza2.setPrecio(20);
		cerveza2.setActiva(true);
		cerveza2.setStock(5);
		
		// Precondicion marca asociada a las cervezas
		marcaAsociada = new TMarca();
		marcaAsociada.setNombre("nuevaaMarca");
		marcaAsociada.setPais("Spain");
		marcaAsociada.setSede("Barcelona");
		marcaAsociada.setActiva(true);	
		
		marcaDAOImp.insertar(marcaAsociada);
		cerveza1.set_marca(marcaAsociada.getId_marca());
		cerveza2.set_marca(marcaAsociada.getId_marca());
	}

	@Test
	public void insertar() {
		
		cervezaDAOImp.insertar(cerveza1);
		
		if (cerveza1.getId_cerveza() != 0) {
			TCerveza cervezaInsertada = cervezaDAOImp.mostrar(cerveza1.getId_cerveza());
			assertTrue(iguales(cerveza1, cervezaInsertada));
		}
	}

	@Test
	public void modificar() {
		
		cervezaDAOImp.insertar(cerveza1);
		
		cerveza1.setNombre("changed");
		cerveza1.setStock(5);
		cerveza1.setGraduacion(30.0);
		cerveza1.setPrecio(25);
		cerveza1.setActiva(true);

		cervezaDAOImp.modificar(cerveza1);
		TCerveza cervezaModificada = cervezaDAOImp.mostrar(cerveza1.getId_cerveza());
		
		assertTrue(iguales(cerveza1,cervezaModificada));	

	}
	
	@Test
	void mostrarTodos() {
		
		List<TCerveza> original = new ArrayList<TCerveza>();
		original.add(cerveza1);
		original.add(cerveza2);

		for (TCerveza tCerveza : original) {
			cervezaDAOImp.insertar(tCerveza);
		}

		List<TCerveza> tl = cervezaDAOImp.mostrarTodos();

		for (int i = 0; i < original.size(); i++) {
			if (!iguales(original.get(i), tl.get(i))) {
				fail("La cerveza leida no se corresponde con la insertada");
			}
		}
	}
	
	@Test
	void mostrarPorNombre() {
		cervezaDAOImp.insertar(cerveza1);
		
		assertTrue(iguales(cerveza1, cervezaDAOImp.mostrarPorNombre(cerveza1.getNombre())));
	}
	
	@Test
	public void eliminar() {
		cervezaDAOImp.insertar(cerveza1);
		
		cervezaDAOImp.eliminar(cerveza1.getId_cerveza());
		assertFalse(cervezaDAOImp.mostrar(cerveza1.getId_cerveza()).isActiva());
	
	}
	
	@AfterAll
	static void afterAll() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean iguales(TCerveza esper, TCerveza resul) {

		return esper.getId_cerveza() == resul.getId_cerveza() && 
				esper.get_marca() == resul.get_marca() &&
				esper.getGraduacion() == resul.getGraduacion() &&
				esper.getPrecio() == resul.getPrecio() &&
				esper.getStock() == resul.getStock() && 
				esper.isActiva() == resul.isActiva()&& 
				esper.getNombre().equals(resul.getNombre());

	}

}
