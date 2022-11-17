package ar.edu.unlam.pb2.eva03;

public class Persona {
	private String nombre;
	private Integer DNI;
	private Integer edad;

	public Persona(String nombre, Integer DNI, Integer edad) {
		super();
		this.nombre = nombre;
		this.DNI = DNI;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDNI() {
		return DNI;
	}

	public void setDNI(Integer dNI) {
		DNI = dNI;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
