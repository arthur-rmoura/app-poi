package com.api.core.appl.util;

import java.math.BigDecimal;

public class Filtro {
	
	private String placa;
	private String data;
	private String nome;
	private BigDecimal raioPoi;
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
	public BigDecimal getRaioPoi() {
		return raioPoi;
	}
	public void setRaioPoi(BigDecimal raioPoi) {
		this.raioPoi = raioPoi;
	}
}
