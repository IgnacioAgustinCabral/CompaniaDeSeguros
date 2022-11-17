package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

import ar.edu.unlam.pb2.eva03.interfaces.Bien;

public class Auto implements Bien{

	private String marca;
	private String modelo;
	private Integer anio;
	private Double sumaAsegurada;

	public Auto(String marca, String modelo, Integer anio, Double sumaAsegurada) {
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.sumaAsegurada = sumaAsegurada;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anio, marca, modelo, sumaAsegurada);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		return Objects.equals(anio, other.anio) && Objects.equals(marca, other.marca)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(sumaAsegurada, other.sumaAsegurada);
	}

}
