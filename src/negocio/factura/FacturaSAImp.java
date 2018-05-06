package negocio.factura;

import integracion.factoriaDAO.FactoriaDAOImp;
import presentacion.factura.TFactura;
import presentacion.cerveza.TCerveza;
import presentacion.factura.TLineaFactura;

import java.util.List;

public class FacturaSAImp implements FacturaSA{//TODO
	@Override
	public boolean insertar_factura(TFactura tFactura) {
		FactoriaDAOImp.getInstancia().getFacturaDAO().insertar(tFactura);
		return true;
	}

	@Override
	public TFactura mostrar_factura(TFactura tFactura) {
		return FactoriaDAOImp.getInstancia().getFacturaDAO().mostrar(tFactura.getId_factura());
	}

	@Override
	public List<TFactura> mostrar_todos_factura() {
		return FactoriaDAOImp.getInstancia().getFacturaDAO().mostrarTodos();
	}

	@Override
	public boolean baja_factura(TFactura tFactura) {
		TFactura tl = FactoriaDAOImp.getInstancia().getFacturaDAO().mostrar(tFactura.getId_factura());

		if (tl == null){
			return false;
		} else {
			FactoriaDAOImp.getInstancia().getFacturaDAO().eliminar(tFactura.getId_factura());
			return true;
		}
	}
	@Override
	public boolean anadir_producto(TLineaFactura lineaFactura){
		TCerveza c = FactoriaDAOImp.getInstancia().getCervezaDAO().mostrar(lineaFactura.getId_cerveza());
		if (lineaFactura.getCantidad()> c.getStock()){
			return false;
		}
		else {
			FactoriaDAOImp.getInstancia().getFacturaDAO().anadirProducto(lineaFactura, c);
			return true;
		}
	}
}
