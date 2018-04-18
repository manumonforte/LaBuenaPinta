package negocio.InterfacesSA;

import presentacion.transfer.TMarca;

import java.util.List;

public interface MarcaSA {
	boolean insertar_marca(TMarca tMarca);

	TMarca mostrar_marca(TMarca tMarca);

	List<TMarca> mostrar_todos_marca();

	boolean modificar_marca(TMarca tMarca);

	boolean baja_marca(TMarca tMarca);

}
