package negocio.factoria;

import negocio.InterfacesSA.CervezaSA;
import negocio.InterfacesSA.EmpleadoSA;
import negocio.InterfacesSA.FacturaSA;
import negocio.InterfacesSA.MarcaSA;
import negocio.SA.CervezaSAImp;
import negocio.SA.EmpleadoSAImp;
import negocio.SA.FacturaSAImp;
import negocio.SA.MarcaSAImp;

public class FactoriaSAImp extends FactoriaSA{

	@Override
	public MarcaSA generarSAMarca() {
		return new MarcaSAImp();
	}

	@Override
	public CervezaSA generarSACerveza() {
		return new CervezaSAImp();
	}

	@Override
	public EmpleadoSA generarSAEmpleado() {
		return new EmpleadoSAImp();
	}

	@Override
	public FacturaSA generarSAFactura() {
		return new FacturaSAImp();
	}
}
