package negocio.cerveza;

import presentacion.transfer.TCerveza;

import java.util.List;

public interface CervezaSA {
	boolean insertar_cerveza(TCerveza tCerveza);

	TCerveza mostrar_cerveza(TCerveza tCerveza);

	List<TCerveza> mostrar_todos_cerveza();

	boolean modificar_cerveza(TCerveza tCerveza);

	boolean baja_cerveza(TCerveza tCerveza);
}
