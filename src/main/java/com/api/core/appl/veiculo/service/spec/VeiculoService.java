package com.api.core.appl.veiculo.service.spec;

import java.util.ArrayList;

import com.api.core.appl.veiculo.VeiculoDTO;
import com.api.core.appl.veiculo.VeiculoPoiDTO;
import com.api.core.appl.util.Filtro;

public interface VeiculoService {

	ArrayList<VeiculoDTO> listarVeiculo(Filtro filtro);

	VeiculoDTO inserirVeiculo(VeiculoDTO veiculoDTO);

	ArrayList<VeiculoPoiDTO> listarTempoVeiculoPOI(Filtro filtro);

}
