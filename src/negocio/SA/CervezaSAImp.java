package negocio.SA;

import integracion.DAO.mariadb.MariadDBGestorDAO;
import negocio.InterfacesSA.CervezaSA;
import negocio.transfer.TCerveza;

import java.util.List;

public class CervezaSAImp implements CervezaSA{

	@Override
	public boolean insertar_cerveza(TCerveza tCerveza) {
		TCerveza tl = MariadDBGestorDAO.getInstancia().getCervezaDAO().mostrarPorNombre(tCerveza.getNombre());

		if (tl == null){
			MariadDBGestorDAO.getInstancia().getCervezaDAO().insertar(tCerveza);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TCerveza mostrar_cerveza(TCerveza tCerveza) {
		return MariadDBGestorDAO.getInstancia().getCervezaDAO().mostrar(tCerveza.getId_cerveza());
	}

	@Override
	public List<TCerveza> mostrar_todos_cerveza() {
		return MariadDBGestorDAO.getInstancia().getCervezaDAO().mostrarTodos();
	}

	@Override
	public boolean modificar_cerveza(TCerveza tCerveza) {
		TCerveza tl = MariadDBGestorDAO.getInstancia().getCervezaDAO().mostrar(tCerveza.getId_cerveza());

		if (tl == null) {
			return false;
		} else if (MariadDBGestorDAO.getInstancia().getCervezaDAO().mostrarPorNombre(tCerveza.getNombre()).getId_cerveza()
				!= tl.getId_cerveza()) {
			return false;
		} else {
			MariadDBGestorDAO.getInstancia().getCervezaDAO().modificar(tCerveza);
			return true;
		}	}

	@Override
	public boolean baja_cerveza(TCerveza tCerveza) {
		TCerveza tl = MariadDBGestorDAO.getInstancia().getCervezaDAO().mostrar(tCerveza.getId_cerveza());

		if (tl == null || tl.getStock() != 0){
			return false;
		} else {
			MariadDBGestorDAO.getInstancia().getCervezaDAO().eliminar(tCerveza.getId_cerveza());
			return true;
		}
	}
}
