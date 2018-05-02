package integracion.marca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presentacion.transfer.TMarca;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class MarcaDAOImpTest {

	private MarcaDAOImp marcaDAOImp;

	@BeforeEach
	void setUp() {
		marcaDAOImp = new MarcaDAOImp();
	}

	@Test
	void insertar() {
		TMarca tMarca = new TMarca();
		tMarca.setNombre("nombre");
		tMarca.setPais("pais");
		tMarca.setSede("sede");
		tMarca.setActiva(true);

		marcaDAOImp.insertar(tMarca);

		if (tMarca.getId_marca() != 0) {
			assertTrue(iguales(tMarca, marcaDAOImp.mostrar(tMarca.getId_marca())));
		} else {
			fail("la marca no se inserto");
		}
	}

	@Test
	void mostrarPorNombre() {
	}

	@Test
	void mostrarTodos() {
	}

	@Test
	void modificar() {
	}

	@Test
	void eliminar() {
	}

	private boolean iguales(TMarca expected, TMarca actual) {
		return expected.getId_marca() == actual.getId_marca() &&
				expected.getNombre().equals(actual.getNombre()) &&
				expected.getPais().equals(actual.getPais()) &&
				expected.getSede().equals(actual.getSede()) &&
				expected.isActiva() == actual.isActiva();
	}
}