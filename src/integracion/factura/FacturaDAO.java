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

package integracion.factura;


import integracion.DAO;
import negocio.cerveza.TCerveza;
import negocio.factura.TFactura;
import negocio.factura.TLineaFactura;

public interface FacturaDAO extends DAO<TFactura> {
	void anadirProducto(TLineaFactura lineaFactura, TCerveza c);

	void cerrar(int id);
}
