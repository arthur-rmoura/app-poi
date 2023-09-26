package com.api.core.appl.veiculo;

import java.util.LinkedHashMap;

public class VeiculoPoiDTO {

	private String poi;
	private LinkedHashMap<String, String> veiculoPOI;
	
	protected VeiculoPoiDTO() {
		
	}
	

	public VeiculoPoiDTO(String poi, LinkedHashMap<String, String> veiculoPOI) {
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


	public LinkedHashMap<String, String> getVeiculoPOI() {
		return veiculoPOI;
	}

	public void setVeiculoPOI(LinkedHashMap<String, String> veiculoPOI) {
		this.veiculoPOI = veiculoPOI;
	}
	
	


}
