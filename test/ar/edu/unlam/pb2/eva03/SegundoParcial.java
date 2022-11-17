package ar.edu.unlam.pb2.eva03;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeBeneficiario;
import ar.edu.unlam.pb2.eva03.excepciones.PolizaInexistenteException;
import ar.edu.unlam.pb2.eva03.interfaces.Bien;
import ar.edu.unlam.pb2.eva03.interfaces.SegurosDeVida;
import ar.edu.unlam.pb2.eva03.interfaces.SegurosGenerales;

public class SegundoParcial {

	@Test
	public void queSePuedaEmitirUnaPolizaDeAutos() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6050.0;

		Persona asegurado = new Persona("Camila", 45987345, 24);
		Auto auto = new Auto("Ford", "Fiesta", 2010, SUMA_ASEGURADA);
		SegurosGenerales poliza = new PolizaDeAuto(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA);
		poliza.agregarBienAsegurado(auto);

		Auto autoActual = null;
		for (Bien bien : ((PolizaDeAuto) poliza).getBienAsegurado()) {
			if (bien.equals(auto)) {
				autoActual = (Auto) bien;
			}
		}
		assertEquals(NUMERO_DE_POLIZA, ((PolizaDeAuto) poliza).getNumeroDePoliza());
		assertEquals(auto, autoActual);
		assertEquals(asegurado, ((PolizaDeAuto) poliza).getAsegurado());
		assertEquals(PREMIO, ((PolizaDeAuto) poliza).getPremio());
	}

	@Test
	public void queSePuedaEmitirUnaPolizaDeVida() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6050.0;

		Persona asegurado = new Persona("Camila", 45987345, 24);
		Persona hijo = new Persona("Arturo", 65456231, 2);
		Persona conyuge = new Persona("Arturo", 65456231, 2);

		SegurosDeVida poliza = new PolizaAccidentesPersonales(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA);
		poliza.agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		poliza.agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);

		Integer cantidadDeBeneficiariosEsperado = ((PolizaAccidentesPersonales) poliza)
				.obtenerCantidadDeBeneficiarios();

		assertEquals(cantidadDeBeneficiariosEsperado,
				((PolizaAccidentesPersonales) poliza).obtenerCantidadDeBeneficiarios());

		assertEquals(asegurado, ((PolizaAccidentesPersonales) poliza).getAsegurado());

		assertEquals(PREMIO, ((PolizaAccidentesPersonales) poliza).getPremio());
	}

	@Test
	public void queSePuedaEmitirUnaPolizaDeCombinadoFamiliar() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 20000000.0, PRIMA = 50000.0, PREMIO = 60500.0;

		Vivienda casa = new Vivienda("Florencio Varela 1800", "San Justo", "La Matanza", "Buenos Aires");
		Persona asegurado = new Persona("Camila", 45987345, 24);
		Persona hijo = new Persona("Arturo", 65456231, 2);
		Persona hija = new Persona("Maia", 65445231, 4);
		Persona conyuge = new Persona("Arturo", 65456231, 2);

		PolizaCombinadoFamiliar poliza = new PolizaCombinadoFamiliar(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA,
				PRIMA);
		poliza.agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		poliza.agregarBeneficiario(hija, TipoDeBeneficiario.HIJA);
		poliza.agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
		poliza.agregarBienAsegurado(casa);

		Integer cantidadDeBeneficiariosEsperado = ((PolizaCombinadoFamiliar) poliza).obtenerCantidadDeBeneficiarios();
		assertEquals(cantidadDeBeneficiariosEsperado,
				((PolizaCombinadoFamiliar) poliza).obtenerCantidadDeBeneficiario());
		assertEquals(asegurado, ((PolizaCombinadoFamiliar) poliza).getAsegurado());
		assertEquals(PREMIO, ((PolizaCombinadoFamiliar) poliza).getPremio());
	}

	@Test
	public void queSePuedanAdministrarDistintosTiposDePolizas() {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");

		libra.agregarPoliza(new PolizaDeAuto(1, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaDeAuto(2, new Persona("Juan", 2745123, 24), 1500000.0, 4000.0));
		libra.agregarPoliza(new PolizaAccidentesPersonales(3, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Natalia", 45987345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaDeAuto(4, new Persona("Victor", 652354, 24), 2000000.0, 5000.0));

		Integer cantidadPolizasEmitidas = 4;
		assertEquals(cantidadPolizasEmitidas, libra.obtenerLaCantidadDePolizasEmitidas());
	}

	@Test
	public void queSePuedaDenunciarElRoboDeUnAuto() {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");

		libra.agregarPoliza(new PolizaDeAuto(numeroDePoliza, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0));

		try {
			libra.denunciarSiniestro(1);
		} catch (PolizaInexistenteException e) {
			e.printStackTrace();
		}

		assertTrue(((PolizaDeAuto) libra.getPoliza(1)).fueRobado());

	}

	@Test
	public void queSePuedaDenunciarUnSiniestroParaUnaPolizaDeVida() {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");

		libra.agregarPoliza(
				new PolizaAccidentesPersonales(numeroDePoliza, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0));

		try {
			libra.denunciarSiniestro(1);
		} catch (PolizaInexistenteException e) {
			e.printStackTrace();
		}

		assertTrue(((PolizaAccidentesPersonales) libra.getPoliza(1)).tuvoAlgunAccidente());

	}

	@Test (expected = PolizaInexistenteException.class)
	public void verificarQueNoSePuedaDenunciarUnSiniestroParaUnaPolizaQueNoExista() throws PolizaInexistenteException {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaDeAuto(numeroDePoliza++, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaDeAuto(numeroDePoliza++, new Persona("Juan", 2745123, 24), 1500000.0, 4000.0));
		libra.agregarPoliza(new PolizaAccidentesPersonales(numeroDePoliza++, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(numeroDePoliza++, new Persona("Natalia", 45987345, 24), 2000000.0, 5000.0));

		libra.denunciarSiniestro(5);

	}

}
