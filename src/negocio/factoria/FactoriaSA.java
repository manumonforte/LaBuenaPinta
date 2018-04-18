package negocio.factoria;

import negocio.InterfacesSA.CervezaSA;
import negocio.InterfacesSA.EmpleadoSA;
import negocio.InterfacesSA.FacturaSA;
import negocio.InterfacesSA.MarcaSA;

public abstract class FactoriaSA {
	private static FactoriaSA instancia = null;

	public abstract MarcaSA generarSAMarca();

	public abstract CervezaSA generarSACerveza();

	public abstract EmpleadoSA generarSAEmpleado();

	public abstract FacturaSA generarSAFactura();

	public static FactoriaSA getInstancia() {
		if (instancia == null) {
			instancia = new FactoriaSAImp();
		}
		return instancia;
	}
}