package negocio.factoria;

import negocio.cerveza.CervezaSA;
import negocio.empleado.EmpleadoSA;
import negocio.factura.FacturaSA;
import negocio.marca.MarcaSA;
import negocio.cerveza.CervezaSAImp;
import negocio.empleado.EmpleadoSAImp;
import negocio.factura.FacturaSAImp;
import negocio.marca.MarcaSAImp;

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
