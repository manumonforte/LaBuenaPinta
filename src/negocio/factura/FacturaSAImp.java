package negocio.factura;

import negocio.factura.FacturaSA;
import presentacion.transfer.TFactura;

import java.util.List;

public class FacturaSAImp implements FacturaSA{//TODO
	@Override
	public boolean insertar_factura(TFactura tFactura) {
		return false;
	}

	@Override
	public TFactura mostrar_factura(TFactura tFactura) {
		return null;
	}

	@Override
	public List<TFactura> mostrar_todos_factura() {
		return null;
	}

	@Override
	public boolean modificar_factura(TFactura tFactura) {
		return false;
	}

	@Override
	public boolean baja_factura(TFactura tFactura) {
		return false;
	}
}
