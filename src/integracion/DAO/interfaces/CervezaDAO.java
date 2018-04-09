package integracion.DAO.interfaces;

import negocio.transfer.TCerveza;

import java.util.List;

public interface CervezaDAO extends DAO<TCerveza>{
	TCerveza mostrarPorNombre(String nombre);
	List<TCerveza> mostrarPorMarca(int id);
}
