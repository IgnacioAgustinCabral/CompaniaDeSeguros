package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unlam.pb2.eva03.excepciones.PolizaInexistenteException;

public class CompaniaDeSeguro {

	private String nombre;
	private Set<Poliza> polizas = new HashSet<Poliza>();

	public CompaniaDeSeguro(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Poliza> getPolizas() {
		return polizas;
	}

	public void setPolizas(Set<Poliza> polizas) {
		this.polizas = polizas;
	}

	public void agregarPoliza(Poliza poliza) {
		this.getPolizas().add(poliza);
	}

	public Integer obtenerLaCantidadDePolizasEmitidas() {
		return this.getPolizas().size();
	}

	public void denunciarSiniestro(Integer numeroDePoliza) throws PolizaInexistenteException {

		for(Poliza poliza : this.getPolizas()) {
			if(poliza.getNumeroDePoliza().equals(numeroDePoliza)) {
				poliza.denunciar();
			} else {
				throw new PolizaInexistenteException("Esta póliza no existe");
			}
		}
	}

	public Poliza getPoliza(Integer numeroDePoliza) {
		for(Poliza poliza : this.getPolizas()) {
			if(poliza.getNumeroDePoliza().equals(numeroDePoliza)) {
				 return poliza;
			}
		}
		return null;
	}

}
