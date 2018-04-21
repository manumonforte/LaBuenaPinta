package negocio.SA;

import integracion.factoriaDAO.FactoriaDAOImp;
import negocio.InterfacesSA.MarcaSA;
import presentacion.transfer.TCerveza;
import presentacion.transfer.TMarca;

import java.util.List;

public class MarcaSAImp implements MarcaSA {
	//TODO

	@Override
	public boolean insertar_marca(TMarca tMarca) {
		TMarca tl = FactoriaDAOImp.getInstancia().getMarcaDAO().mostrarPorNombre(tMarca.getNombre());

		if (tl == null){
			FactoriaDAOImp.getInstancia().getMarcaDAO().insertar(tMarca);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TMarca mostrar_marca(TMarca tMarca) {
		return FactoriaDAOImp.getInstancia().getMarcaDAO().mostrar(tMarca.getId_marca());
	}

	@Override
	public List<TMarca> mostrar_todos_marca() {
		return FactoriaDAOImp.getInstancia().getMarcaDAO().mostrarTodos();
	}

	@Override
	public boolean modificar_marca(TMarca tMarca) { //TODO revisar
		TMarca tl = FactoriaDAOImp.getInstancia().getMarcaDAO().mostrar(tMarca.getId_marca());

		if (tl == null) {
			return false;
		} else if (FactoriaDAOImp.getInstancia().getMarcaDAO().mostrarPorNombre(tMarca.getNombre()).getId_marca()
				!= tl.getId_marca()) {
			return false;
		} else {
			FactoriaDAOImp.getInstancia().getMarcaDAO().modificar(tMarca);
			return true;
		}
	}

	@Override
	public boolean baja_marca(TMarca tMarca) {//TODO revisar
		TMarca tl = FactoriaDAOImp.getInstancia().getMarcaDAO().mostrar(tMarca.getId_marca());
		List<TCerveza> tlCerveza = FactoriaDAOImp.getInstancia().getCervezaDAO().mostrarPorMarca(tMarca.getId_marca());

		if (tl == null){
			return false;
		}

		for (TCerveza tCerveza : tlCerveza) {
			if (tCerveza.isActiva()) {
				return false;
			}
		}

		FactoriaDAOImp.getInstancia().getMarcaDAO().eliminar(tMarca.getId_marca());
		return true;
	}
}
