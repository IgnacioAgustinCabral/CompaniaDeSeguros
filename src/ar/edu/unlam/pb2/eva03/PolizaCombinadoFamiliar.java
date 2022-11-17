package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeBeneficiario;
import ar.edu.unlam.pb2.eva03.interfaces.Bien;
import ar.edu.unlam.pb2.eva03.interfaces.SegurosDeVida;
import ar.edu.unlam.pb2.eva03.interfaces.SegurosGenerales;

public class PolizaCombinadoFamiliar extends Poliza implements SegurosGenerales, SegurosDeVida {

	private Set<Bien> bienAsegurado = new HashSet<Bien>();
	private Map<Persona, TipoDeBeneficiario> beneficiarios = new HashMap<Persona, TipoDeBeneficiario>();

	public PolizaCombinadoFamiliar(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
		super(numeroDePoliza, asegurado, prima, prima);
	}

	public Map<Persona, TipoDeBeneficiario> getBeneficiarios() {
		return beneficiarios;
	}

	public Set<Bien> getBienAsegurado() {
		return bienAsegurado;
	}

	public void setBienAsegurado(Set<Bien> bienAsegurado) {
		this.bienAsegurado = bienAsegurado;
	}

	public void setBeneficiarios(Map<Persona, TipoDeBeneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	@Override
	public void agregarBeneficiario(Persona persona, TipoDeBeneficiario tipoBeneficiario) {
		this.getBeneficiarios().put(persona, tipoBeneficiario);
	}

	public Integer obtenerCantidadDeBeneficiarios() {
		return this.getBeneficiarios().size();
	}

	@Override
	public void agregarBienAsegurado(Bien bien) {
		this.getBienAsegurado().add(bien);
	}

	public Integer obtenerCantidadDeBeneficiario() {
		return this.getBeneficiarios().size();
	}

	@Override
	public void denunciar() {
		// TODO Auto-generated method stub
		
	}

}
