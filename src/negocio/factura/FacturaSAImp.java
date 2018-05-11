/*
 *     This file is part of LaBuenaPinta.
 *
 *     LaBuenaPinta is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     LaBuenaPinta is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with LaBuenaPinta.  If not, see <http://www.gnu.org/licenses/>.
 */

package negocio.factura;

import integracion.factoriaDAO.FactoriaDAOImp;
import negocio.cerveza.TCerveza;

import java.util.List;

public class FacturaSAImp implements FacturaSA{
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

	@Override
	public boolean cerrar_factura(TFactura tFactura) {
		TFactura tl = FactoriaDAOImp.getInstancia().getFacturaDAO().mostrar(tFactura.getId_factura());

		if (tl == null){
			return false;
		} else {
			FactoriaDAOImp.getInstancia().getFacturaDAO().cerrar(tFactura.getId_factura());
			return true;
		}
	}
}
