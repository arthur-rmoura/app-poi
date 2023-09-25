package com.api.core.appl.veiculo.service.spec;

import java.util.ArrayList;
import java.util.List;

import com.api.core.appl.veiculo.Veiculo;
import com.api.core.appl.veiculo.VeiculoDTO;
import com.api.core.appl.veiculo.VeiculoPoiDTO;
import com.api.core.appl.util.Filtro;

public interface VeiculoService {

	ArrayList<VeiculoDTO> listarVeiculoDTO(Filtro filtro);
	
	List<Veiculo> listarVeiculo(Filtro filtro);

	VeiculoDTO inserirVeiculoDTO(VeiculoDTO veiculoDTO);
	
	Veiculo inserirVeiculo(VeiculoDTO veiculoDTO);

	ArrayList<VeiculoPoiDTO> listarTempoVeiculoPOI(Filtro filtro);

	

}
