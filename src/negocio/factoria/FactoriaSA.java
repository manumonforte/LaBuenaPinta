package negocio.factoria;

import negocio.InterfacesSA.CervezaSA;
import negocio.InterfacesSA.EmpleadoSA;
import negocio.InterfacesSA.FacturaSA;
import negocio.InterfacesSA.MarcaSA;

public abstract class FactoriaSA {
	private static FactoriaSA instancia = null;

	abstract public MarcaSA generarSAMarca();

	abstract public CervezaSA generarSACerveza();

	abstract public EmpleadoSA generarSAEmpleado();

	abstract public FacturaSA generarSAFactura();

	public static FactoriaSA getInstancia() {
		if (instancia == null) {
			instancia = new FactoriaSAImp();
		}
		return instancia;
	}
}