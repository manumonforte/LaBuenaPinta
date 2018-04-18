package integracion.cerveza;

import integracion.DAO;
import presentacion.transfer.TCerveza;

import java.util.List;

public interface CervezaDAO extends DAO<TCerveza> {
	TCerveza mostrarPorNombre(String nombre);
	List<TCerveza> mostrarPorMarca(int id);
}
