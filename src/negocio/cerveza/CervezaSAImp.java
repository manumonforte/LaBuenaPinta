package negocio.cerveza;

import integracion.factoriaDAO.FactoriaDAOImp;
import presentacion.cerveza.TCerveza;

import java.util.List;

public class CervezaSAImp implements CervezaSA{

	@Override
	public boolean insertar_cerveza(TCerveza tCerveza) {
		TCerveza tl = FactoriaDAOImp.getInstancia().getCervezaDAO().mostrarPorNombre(tCerveza.getNombre());

		if (tl == null){
			FactoriaDAOImp.getInstancia().getCervezaDAO().insertar(tCerveza);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TCerveza mostrar_cerveza(TCerveza tCerveza) {
		return FactoriaDAOImp.getInstancia().getCervezaDAO().mostrar(tCerveza.getId_cerveza());
	}

	@Override
	public List<TCerveza> mostrar_todos_cerveza() {
		return FactoriaDAOImp.getInstancia().getCervezaDAO().mostrarTodos();
	}

	@Override
	public boolean modificar_cerveza(TCerveza tCerveza) {
		TCerveza tl = FactoriaDAOImp.getInstancia().getCervezaDAO().mostrar(tCerveza.getId_cerveza());
		TCerveza c = FactoriaDAOImp.getInstancia().getCervezaDAO().mostrarPorNombre(tCerveza.getNombre());

		if (tl == null) {
			return false;
		} else if ( c != null && c.getId_cerveza() != tl.getId_cerveza()) {
			return false;
		} else {
			FactoriaDAOImp.getInstancia().getCervezaDAO().modificar(tCerveza);
			return true;
		}
	}

	@Override
	public boolean baja_cerveza(TCerveza tCerveza) {
		TCerveza tl = FactoriaDAOImp.getInstancia().getCervezaDAO().mostrar(tCerveza.getId_cerveza());

		if (tl == null || tl.getStock() != 0){
			return false;
		} else {
			FactoriaDAOImp.getInstancia().getCervezaDAO().eliminar(tCerveza.getId_cerveza());
			return true;
		}
	}
}
