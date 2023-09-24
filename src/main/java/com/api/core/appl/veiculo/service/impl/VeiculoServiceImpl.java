package com.api.core.appl.veiculo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.api.core.appl.veiculo.Veiculo;
import com.api.core.appl.veiculo.VeiculoDTO;
import com.api.core.appl.veiculo.VeiculoPoiDTO;
import com.api.core.appl.veiculo.repository.spec.VeiculoRepository;
import com.api.core.appl.veiculo.service.spec.VeiculoService;
import com.api.core.appl.util.Filtro;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	VeiculoRepository veiculoRepository;

	@Override
	public ArrayList<VeiculoDTO> listarVeiculo(Filtro filtro) {
		
		Page<Veiculo> paginaVeiculo;
		
		if(filtro.getPlaca() != null) {
			paginaVeiculo = veiculoRepository.listarVeiculoPorPlaca(filtro);
		}
		
		else if(filtro.getMarca() != null) {
			paginaVeiculo = veiculoRepository.listarVeiculoPorMarca(filtro);
		}
		else if(filtro.getModelo() != null) {
			paginaVeiculo = veiculoRepository.listarVeiculoPorModelo(filtro);
		}
		else {
			paginaVeiculo = veiculoRepository.listarVeiculo(filtro);
		}
		
		List<Veiculo> listaVeiculo = paginaVeiculo.getContent();
		
		ArrayList<VeiculoDTO> listaVeiculoDTO = new ArrayList<>();
		
		for(Veiculo veiculo : listaVeiculo) {
			VeiculoDTO veiculoDTO = new VeiculoDTO(veiculo.getPlaca(), veiculo.getMarca(), veiculo.getModelo());
			listaVeiculoDTO.add(veiculoDTO);
		}

		return listaVeiculoDTO;

	}

	@Override
	public VeiculoDTO inserirVeiculo(VeiculoDTO veiculoDTO) {

		Veiculo veiculo = new Veiculo(veiculoDTO.getPlaca(), veiculoDTO.getMarca(), veiculoDTO.getModelo());

		veiculoRepository.inserirVeiculo(veiculo);

		return veiculoDTO;
	}

	@Override
	public ArrayList<VeiculoPoiDTO> listarTempoVeiculoPOI(Filtro filtro) {
		HashMap<String, String> tempoPOI = new HashMap<String, String>();
		ArrayList<VeiculoPoiDTO> listaVeiculoPoiDTO = new ArrayList<>();
		
		String veiculo = "TESTE001";
		tempoPOI.put("PONTO 1", "3 dias 5 horas 2 minutos 5 segundos");
		VeiculoPoiDTO veiculoPoiDTO = new VeiculoPoiDTO(veiculo, tempoPOI);
		listaVeiculoPoiDTO.add(veiculoPoiDTO);
		
		return listaVeiculoPoiDTO;
		
	}

}

