package negocio.InterfacesSA;

import negocio.transfer.TFactura;

public interface FacturaSA {

	public boolean insertar_factura(TFactura tFactura);

	public boolean mostrar_factura(TFactura tFactura);

	public boolean mostrar_todos_factura(TFactura tFactura);

	public boolean modificar_factura(TFactura tFactura);

	public boolean baja_factura(TFactura tFactura);

}
