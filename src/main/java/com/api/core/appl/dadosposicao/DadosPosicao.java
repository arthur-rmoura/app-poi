package com.api.core.appl.dadosposicao;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.api.core.appl.veiculo.Veiculo;

@Entity
public class DadosPosicao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, insertable=false, updatable=false)
	private String placa;

	@Column(nullable = false)
	private Long epochSecondPosicao;

	@Column(nullable = false)
	private String timezonePosicao;

	@Column(nullable = false)
	private Float velocidade;

	@Column(nullable = false, precision=23, scale=20)
	private BigDecimal longitude;

	@Column(nullable = false, precision=22, scale=20)
	private BigDecimal latitude;

	@Column(nullable = false)
	private Boolean ignicao;
	
	@ManyToOne(optional=false, fetch = FetchType.LAZY)
	@JoinColumn(name="placa", nullable=false)
	private Veiculo veiculo;
	

	protected DadosPosicao() {
		// Construtor sem argumentos, requerido pela JPA
		// Definido como protegido já que não deve ser usado diretamente
	}

	public DadosPosicao(String placa, Long epochSecondPosicao, String timezonePosicao, Float velocidade,
			BigDecimal longitude, BigDecimal latitude, Boolean ignicao) {
		super();
		this.placa = placa;
		this.epochSecondPosicao = epochSecondPosicao;
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

	public String getTimezonePosicao() {
		return timezonePosicao;
	}

	public void setTimezonePosicao(String timezonePosicao) {
		this.timezonePosicao = timezonePosicao;
	}

	public Float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Float velocidade) {
		this.velocidade = velocidade;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public Boolean getIgnicao() {
		return ignicao;
	}

	public void setIgnicao(Boolean ignicao) {
		this.ignicao = ignicao;
	}

	public Long getEpochSecondPosicao() {
		return epochSecondPosicao;
	}

	public void setEpochSecondPosicao(Long epochSecondPosicao) {
		this.epochSecondPosicao = epochSecondPosicao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}