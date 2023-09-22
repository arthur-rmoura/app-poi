package com.api.core.appl.dadosposicao;

import java.io.Serializable;


public class DadosPosicaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String placa;

	private String dataPosicao;

	private Float velocidade;

	private Double longitude;

	private Double latitude;

	private Boolean ignicao;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
