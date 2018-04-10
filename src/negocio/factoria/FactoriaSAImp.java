package negocio.factoria;

import negocio.InterfacesSA.CervezaSA;
import negocio.InterfacesSA.EmpleadoSA;
import negocio.InterfacesSA.MarcaSA;
import negocio.SA.CervezaSAImp;
import negocio.SA.EmpleadoSAImp;
import negocio.SA.MarcaSAImp;

public class FactoriaSAImp implements FactoriaSA{

	@Override
	MarcaSA generarSAMarca() {
		return new MarcaSAImp();
	}
	/*
	@Override
	CervezaSA generarSACerveza() {
		return new CervezaSAImp();
	}

	@Override
	EmpleadoSA generarSAEmpleado() {
		return new EmpleadoSAImp();
	}

	@Override
	FactoriaSA generarSAFactura() {
		return new FactoriaSAImp();
	}
	*/
}
