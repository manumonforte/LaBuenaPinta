package negocio.factura;

import presentacion.factura.TFactura;
import presentacion.factura.TLineaFactura;

import java.util.List;

public interface FacturaSA {

	boolean insertar_factura(TFactura tFactura);

	TFactura mostrar_factura(TFactura tFactura);

	List<TFactura> mostrar_todos_factura();

	boolean baja_factura(TFactura tFactura);

	boolean anadir_producto(TLineaFactura lineaFactura);

	boolean cerrar_factura(TFactura tFactura);
}
