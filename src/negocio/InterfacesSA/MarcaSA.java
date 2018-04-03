package negocio.InterfacesSA;

import negocio.transfer.TMarca;

public interface MarcaSA {
	public boolean insertar_marca(TMarca tMarca);
	public boolean mostrar_marca(TMarca tMarca);
	public boolean mostrar_todos_marca(TMarca tMarca);
	public boolean modificar_marca(TMarca tMarca);
	public boolean baja_marca(TMarca tMarca);
}
