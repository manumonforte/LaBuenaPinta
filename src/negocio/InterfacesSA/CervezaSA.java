package negocio.InterfacesSA;

import negocio.transfer.TCerveza;

public interface CervezaSA {

    public boolean insertar_cerveza(TCerveza tCerveza);
    public boolean mostrar_cerveza(TCerveza tCerveza);
    public boolean mostrar_todos_cerveza(TCerveza tCerveza);
    public boolean modificar_cerveza(TCerveza tCerveza);
    public boolean baja_cerveza(TCerveza tCerveza);

}
