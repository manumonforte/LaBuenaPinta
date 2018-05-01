package presentacion.transfer;

import presentacion.util.tipoTurno;

public class TEmpleadoParcial extends TEmpleado {


    private tipoTurno turno;

    public TEmpleadoParcial(){

    }

    public TEmpleadoParcial(int id_empleado, String nombre, String DNI, boolean activo,tipoTurno turno) {
        super(id_empleado,DNI,nombre,activo,false);
        this.turno = turno;
    }

    public tipoTurno getTurno() {
        return turno;
    }

    public void setTurno(tipoTurno turno) {
        this.turno = turno;
    }

    public String toString() {
        return  "******Empleado*******\n"+
                "ID: "+this.getId_empleado() + "\n"+
                "DNI: "+this.getDNI() + "\n"+
                "TiempoCompleto: "+this.isTiempo_completo() + "\n"+
                "Activo: " +this.isActivo()+"\n"+
                "Turno: "+this.getTurno() + "\n";
    }
}
