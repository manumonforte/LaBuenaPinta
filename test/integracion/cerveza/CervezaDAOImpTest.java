package integracion.cerveza;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import presentacion.transfer.TCerveza;

class CervezaDAOImpTest {

	private CervezaDAOImp cervezaDAOImp;
	private TCerveza cerveza;

	@BeforeEach
	void setUp() {
		cervezaDAOImp = new CervezaDAOImp();
		cerveza = new TCerveza();
		
		cerveza.setNombre("cerve");
		cerveza.set_marca(1);
		cerveza.setGraduacion(20.0);
		cerveza.setPrecio(10);
		cerveza.setStock(1);
		cerveza.setActiva(true);
	}

	@Test
	public void insertar() {

		
		cervezaDAOImp.insertar(cerveza);

		if (cerveza.getId_cerveza() != 0) {
			TCerveza cervezaInsertada = cervezaDAOImp.mostrar(cerveza.getId_cerveza());

			assertTrue(iguales(cerveza, cervezaInsertada));
		}
	}

	@Test
	public void modificar() {
		
		// Precondicion que este en la base de datos
		cervezaDAOImp.insertar(cerveza);
		
		cerveza.setNombre("changed");
		cerveza.setStock(5);
		cerveza.setGraduacion(30.0);
		cerveza.setPrecio(25);
		cerveza.set_marca(1);
		cerveza.setActiva(true);

		cervezaDAOImp.modificar(cerveza);
		TCerveza cervezaModificada = cervezaDAOImp.mostrar(cerveza.getId_cerveza());
		
		assertTrue(iguales(cerveza,cervezaModificada));	

	}
	
	@Test
	public void eliminar() {
		
		// Precondicion que este en la base de datos
		cervezaDAOImp.insertar(cerveza);
		
		cervezaDAOImp.eliminar(cerveza.getId_cerveza());
		assertNull(cervezaDAOImp.mostrar(cerveza.getId_cerveza()));
	
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
