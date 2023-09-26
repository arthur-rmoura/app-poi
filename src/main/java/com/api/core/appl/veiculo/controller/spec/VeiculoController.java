package com.api.core.appl.veiculo.controller.spec;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.api.core.appl.veiculo.VeiculoDTO;
import com.api.core.appl.veiculo.PoiVeiculoDTO;

public interface VeiculoController  {
	

	ResponseEntity<ArrayList<VeiculoDTO>> listarVeiculo(Integer numeroPagina, Integer tamanhoPagina, String placa, String marca, String modelo);

	ResponseEntity<VeiculoDTO> inserirVeiculo(VeiculoDTO veiculoDTO);

	ResponseEntity<ArrayList<PoiVeiculoDTO>> listarTempoVeiculoPOI(String placa, String data);

}
