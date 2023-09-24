package com.api.core.appl.veiculo;

import java.util.HashMap;

public class VeiculoPoiDTO {

	String veiculo;
	HashMap<String, String> tempoPOI;
	
	protected VeiculoPoiDTO() {
		
	}
	
	public VeiculoPoiDTO(String veiculo, HashMap<String, String> tempoPOI) {
		super();
		this.veiculo = veiculo;
		this.tempoPOI = tempoPOI;
	}

	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public HashMap<String, String> getTempoPOI() {
		return tempoPOI;
	}
	public void setTempoPOI(HashMap<String, String> tempoPOI) {
		this.tempoPOI = tempoPOI;
	}
	
	
	

}
