package presentacion.empleado;

import presentacion.util.TipoTurno;

public class TEmpleadoParcial extends TEmpleado {
	private TipoTurno turno;

	public TEmpleadoParcial() {

	}

	public TEmpleadoParcial(int id_empleado, String nombre, String DNI, boolean activo, TipoTurno turno) {
		super(id_empleado, DNI, nombre, activo, false);
		this.turno = turno;
	}

	public TipoTurno getTurno() {
		return turno;
	}

	public void setTurno(TipoTurno turno) {
		this.turno = turno;
	}

	public String toString() {
		return "******Empleado*******\n" +
				"ID: " + this.getId_empleado() + "\n" +
				"DNI: " + this.getDNI() + "\n" +
				"Nombre: " + this.getNombre() + "\n" +
				"TiempoCompleto: " + this.isTiempo_completo() + "\n" +
				"Activo: " + this.isActivo() + "\n" +
				"Turno: " + this.getTurno() + "\n";
	}
}
