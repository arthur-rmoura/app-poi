package com.api.core.appl.poi;

import java.io.Serializable;
import java.math.BigDecimal;

public class PoiDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	private BigDecimal raio;

	private BigDecimal latitude;

	private BigDecimal longitude;

	protected PoiDTO() {

	}

	public PoiDTO(String nome, BigDecimal raio, BigDecimal latitude, BigDecimal longitude) {
		super();
		this.nome = nome;
		this.raio = raio;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getRaio() {
		return raio;
	}

	public void setRaio(BigDecimal raio) {
		this.raio = raio;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

}
