package com.api.core.appl.veiculo;

import java.io.Serializable;


public class VeiculoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String placa;

	private String marca;
	
	private String modelo;

	protected VeiculoDTO() {
		
	}
	
	public VeiculoDTO(String placa, String marca, String modelo) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}	
	
}
