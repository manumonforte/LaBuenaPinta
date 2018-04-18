package integracion.marca;

import integracion.DAO;
import presentacion.transfer.TMarca;

public interface MarcaDAO extends DAO<TMarca> {
	TMarca mostrarPorNombre(String nombre);
}
