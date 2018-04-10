package negocio.factoria;

import negocio.InterfacesSA.CervezaSA;
import negocio.InterfacesSA.EmpleadoSA;
import negocio.InterfacesSA.MarcaSA;

public interface FactoriaSA {
	MarcaSA generarSAMarca();

	CervezaSA generarSACerveza();

	EmpleadoSA generarSAEmpleado();

	FactoriaSA generarSAFactura();
}