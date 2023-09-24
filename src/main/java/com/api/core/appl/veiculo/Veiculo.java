package com.api.core.appl.veiculo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.api.core.appl.dadosposicao.DadosPosicao;

@Entity
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String placa;

	@Column(nullable = true, length = 50)
	private String marca;

	@Column(nullable = true, length = 50)
	private String modelo;
	
	@OneToMany(mappedBy="veiculo", cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	/*@JoinTable ( name =" veiculo_dados_posicao", joinColumns = @JoinColumn (name ="placa"),
	inverseJoinColumns = @JoinColumn (name ="id"))*/
	private List<DadosPosicao> dadosPosicao;

	protected Veiculo() {
		// Construtor sem argumentos, requerido pela JPA
		// Definido como protegido já que não deve ser usado diretamente
	}

	
	public Veiculo(String placa, String marca, String modelo) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
	}


	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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

}