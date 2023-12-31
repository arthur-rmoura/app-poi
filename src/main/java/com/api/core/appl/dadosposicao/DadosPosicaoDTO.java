package com.api.core.appl.dadosposicao;

import java.io.Serializable;
import java.math.BigDecimal;


public class DadosPosicaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String placa;

	private String dataPosicao;

	private Float velocidade;

	private BigDecimal longitude;

	private BigDecimal latitude;

	private Boolean ignicao;
	
	protected DadosPosicaoDTO() {
	
	}
	
	public DadosPosicaoDTO(String placa, String dataPosicao, Float velocidade, BigDecimal longitude,
			BigDecimal latitude, Boolean ignicao) {
		super();
		this.placa = placa;
		this.dataPosicao = dataPosicao;
		this.velocidade = velocidade;
		this.longitude = longitude;
		this.latitude = latitude;
		this.ignicao = ignicao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDataPosicao() {
		return dataPosicao;
	}

	public void setDataPosicao(String dataPosicao) {
		this.dataPosicao = dataPosicao;
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
	
}
