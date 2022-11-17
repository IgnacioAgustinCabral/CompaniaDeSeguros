package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeBeneficiario;
import ar.edu.unlam.pb2.eva03.interfaces.SegurosDeVida;

public class PolizaAccidentesPersonales extends Poliza implements SegurosDeVida {
	private Boolean siniestro = Boolean.FALSE;
	private Map<Persona, TipoDeBeneficiario> beneficiarios = new HashMap<Persona, TipoDeBeneficiario>();

	public PolizaAccidentesPersonales(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
		super(numeroDePoliza, asegurado, prima, prima);
	}

	public Map<Persona, TipoDeBeneficiario> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(Map<Persona, TipoDeBeneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}
	

	public final Boolean getSiniestro() {
		return siniestro;
	}

	public final void setSiniestro(Boolean siniestro) {
		this.siniestro = siniestro;
	}

	@Override
	public void agregarBeneficiario(Persona persona, TipoDeBeneficiario tipoBeneficiario) {
		this.getBeneficiarios().put(persona, tipoBeneficiario);
	}

	public Integer obtenerCantidadDeBeneficiarios() {
		return this.getBeneficiarios().size();
	}

	@Override
	public void denunciar() {
		this.setSiniestro(Boolean.TRUE);
	}
	
	public Boolean tuvoAlgunAccidente() {
		return this.getSiniestro();
	}

}
