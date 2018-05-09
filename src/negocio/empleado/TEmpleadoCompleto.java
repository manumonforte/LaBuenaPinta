package negocio.empleado;

import negocio.empleado.TEmpleado;

public class TEmpleadoCompleto extends TEmpleado {
	private int horas_extra;

	public TEmpleadoCompleto() {

	}

	public TEmpleadoCompleto(int id_empleado, String nombre, String DNI, boolean activo, int horas_extra) {
		super(id_empleado, DNI, nombre, activo, true);
		this.horas_extra = horas_extra;
	}

	public int getHoras_extra() {
		return horas_extra;
	}

	public void setHoras_extra(int horas_extra) {
		this.horas_extra = horas_extra;
	}

	public String toString() {
		return "******Empleado*******\n" +
				"ID: " + this.getId_empleado() + "\n" +
				"DNI: " + this.getDNI() + "\n" +
				"Nombre: " + this.getNombre() + "\n" +
				"TiempoCompleto: " + this.isTiempo_completo() + "\n" +
				"Activo: " + this.isActivo() + "\n" +
				"HorasExtra: " + this.getHoras_extra() + "\n";
	}
}
