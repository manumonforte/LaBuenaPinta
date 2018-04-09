package negocio.SA;

import integracion.DAO.mariadb.MariadDBGestorDAO;
import negocio.InterfacesSA.MarcaSA;
import negocio.transfer.TCerveza;
import negocio.transfer.TMarca;

import java.util.List;

public class MarcaSAImp implements MarcaSA {
	//TODO

	@Override
	public boolean insertar_marca(TMarca tMarca) {
		TMarca tl = MariadDBGestorDAO.getInstancia().getMarcaDAO().mostrarPorNombre(tMarca.getNombre());

		if (tl == null){
			MariadDBGestorDAO.getInstancia().getMarcaDAO().insertar(tMarca);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TMarca mostrar_marca(TMarca tMarca) {
		return MariadDBGestorDAO.getInstancia().getMarcaDAO().mostrar(tMarca.getId_marca());
	}

	@Override
	public List<TMarca> mostrar_todos_marca() {
		return MariadDBGestorDAO.getInstancia().getMarcaDAO().mostrarTodos();
	}

	@Override
	public boolean modificar_marca(TMarca tMarca) { //TODO revisar
		TMarca tl = MariadDBGestorDAO.getInstancia().getMarcaDAO().mostrar(tMarca.getId_marca());

		if (tl == null) {
			return false;
		} else if (MariadDBGestorDAO.getInstancia().getMarcaDAO().mostrarPorNombre(tMarca.getNombre()).getId_marca()
				!= tl.getId_marca()) {
			return false;
		} else {
			MariadDBGestorDAO.getInstancia().getMarcaDAO().modificar(tMarca);
			return true;
		}
	}

	@Override
	public boolean baja_marca(TMarca tMarca) {//TODO revisar
		TMarca tl = MariadDBGestorDAO.getInstancia().getMarcaDAO().mostrar(tMarca.getId_marca());
		List<TCerveza> tlCerveza = MariadDBGestorDAO.getInstancia().getCervezaDAO().mostrarPorMarca(tMarca.getId_marca());

		for (TCerveza tCerveza : tlCerveza) {
			if (tCerveza.isActiva()) {
				return false;
			}
		}

		MariadDBGestorDAO.getInstancia().getMarcaDAO().eliminar(tMarca.getId_marca());
		return true;
	}
}
