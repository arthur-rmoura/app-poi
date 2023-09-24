package com.api.core.appl.poi;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Poi implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, precision = 23, scale = 10)
	private BigDecimal raio;

	@Column(nullable = false, precision = 22, scale = 20)
	private BigDecimal latitude;

	@Column(nullable = false, precision = 23, scale = 20)
	private BigDecimal longitude;

	protected Poi() {
		// Construtor sem argumentos, requerido pela JPA
		// Definido como protegido já que não deve ser usado diretamente
	}

	public Poi(String nome, BigDecimal raio, BigDecimal latitude, BigDecimal longitude) {
		super();
		this.nome = nome;
		this.raio = raio;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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