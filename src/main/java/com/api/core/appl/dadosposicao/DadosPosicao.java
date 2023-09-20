package com.api.core.appl.dadosposicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DadosPosicao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String placa;

	@Column(nullable = false)
	private Long timestampPosicao;

	@Column(nullable = false)
	private Integer timezonePosicao;

	@Column(nullable = false)
	private Float velocidade;

	@Column(nullable = false)
	private Double longitude;

	@Column(nullable = false)
	private Double latitude;

	@Column(nullable = false)
	private Boolean ignicao;

	protected DadosPosicao() {
		// no-args constructor required by JPA spec
		// this one is protected since it should not be used directly
	}

	public DadosPosicao(Long id, String placa, Long timestampPosicao, Integer timezonePosicao, Float velocidade,
			Double longitude, Double latitude, Boolean ignicao) {
		super();
		this.id = id;
		this.placa = placa;
		this.timestampPosicao = timestampPosicao;
		this.timezonePosicao = timezonePosicao;
		this.velocidade = velocidade;
		this.longitude = longitude;
		this.latitude = latitude;
		this.ignicao = ignicao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Long getTimestampPosicao() {
		return timestampPosicao;
	}

	public void setTimestampPosicao(Long timestampPosicao) {
		this.timestampPosicao = timestampPosicao;
	}

	public Integer getTimezonePosicao() {
		return timezonePosicao;
	}

	public void setTimezonePosicao(Integer timezonePosicao) {
		this.timezonePosicao = timezonePosicao;
	}

	public Float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Float velocidade) {
		this.velocidade = velocidade;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Boolean getIgnicao() {
		return ignicao;
	}

	public void setIgnicao(Boolean ignicao) {
		this.ignicao = ignicao;
	}

}