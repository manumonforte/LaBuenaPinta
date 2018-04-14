package negocio.InterfacesSA;

import negocio.transfer.TFactura;

import java.util.List;

public interface FacturaSA {

	boolean insertar_factura(TFactura tFactura);

	TFactura mostrar_factura(TFactura tFactura);

	List<TFactura> mostrar_todos_factura();

	boolean modificar_factura(TFactura tFactura);

	boolean baja_factura(TFactura tFactura);

	//boolean devolver_producto() //TODO necesita 2 parametros
}
