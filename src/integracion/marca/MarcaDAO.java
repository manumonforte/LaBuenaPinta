package integracion.marca;

import integracion.DAO;
import negocio.marca.TMarca;

public interface MarcaDAO extends DAO<TMarca> {
	TMarca mostrarPorNombre(String nombre);
}
