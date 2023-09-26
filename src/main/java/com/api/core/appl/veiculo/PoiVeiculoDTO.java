package com.api.core.appl.veiculo;

import java.util.HashMap;

public class PoiVeiculoDTO {

	private String poi;
	private HashMap<String, String> veiculoPOI;
	
	protected PoiVeiculoDTO() {
		
	}

	public PoiVeiculoDTO(String poi, HashMap<String, String> veiculoPOI) {
		super();
		this.poi = poi;
		this.veiculoPOI = veiculoPOI;
	}


	public String getPoi() {
		return poi;
	}

	public void setPoi(String poi) {
		this.poi = poi;
	}

	public HashMap<String, String> getVeiculoPOI() {
		return veiculoPOI;
	}

	public void setVeiculoPOI(HashMap<String, String> veiculoPOI) {
		this.veiculoPOI = veiculoPOI;
	}

}
