package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unlam.pb2.eva03.interfaces.Bien;
import ar.edu.unlam.pb2.eva03.interfaces.SegurosGenerales;

public class PolizaDeAuto extends Poliza implements SegurosGenerales {
	private Boolean robado = Boolean.FALSE;

	private Set<Bien> bienAsegurado = new HashSet<Bien>();

	public PolizaDeAuto(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
		super(numeroDePoliza, asegurado, sumaAsegurada, prima);
	}

	public Set<Bien> getBienAsegurado() {
		return bienAsegurado;
	}

	public void setBienAsegurado(Set<Bien> bienAsegurado) {
		this.bienAsegurado = bienAsegurado;
	}

	@Override
	public void agregarBienAsegurado(Bien bien) {
		this.getBienAsegurado().add(bien);
	}

	public Double getPremio() {
		return this.getPrima() * 1.21;
	}

	public Boolean getRobado() {
		return robado;
	}

	public void setRobado(Boolean robado) {
		this.robado = robado;
	}

	@Override
	public void denunciar() {
		this.setRobado(Boolean.TRUE);
	}
	
	public Boolean fueRobado() {
		return this.getRobado();
	}

}
