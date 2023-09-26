package com.api.core.appl.util;

import java.math.BigDecimal;

public class Filtro {
	
	private String placa;
	private String marca;
	private String modelo;
	private String data;
	private String dataInicial;
	private String dataFinal;
	private String nome;
	private BigDecimal raio;
	private Integer numeroPagina;
	private Integer tamanhoPagina;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Integer getNumeroPagina() {
		return numeroPagina;
	}
	public void setNumeroPagina(Integer numeroPagina) {
		this.numeroPagina = numeroPagina;
	}
	public Integer getTamanhoPagina() {
		return tamanhoPagina;
	}
	public void setTamanhoPagina(Integer tamanhoPagina) {
		this.tamanhoPagina = tamanhoPagina;
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
	public String getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
}
