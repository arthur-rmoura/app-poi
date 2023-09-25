package com.api.core.appl.veiculo.service.impl;

import java.math.BigInteger;
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
import com.api.core.appl.dadosposicao.DadosPosicaoDTO;
import com.api.core.appl.dadosposicao.service.spec.DadosPosicaoService;
import com.api.core.appl.poi.PoiDTO;
import com.api.core.appl.poi.service.spec.PoiService;
import com.api.core.appl.util.Filtro;
import com.api.core.appl.util.FuncoesLib;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Autowired
	PoiService poiService;
	
	@Autowired
	DadosPosicaoService dadosPosicaoService;

	@Override
	public ArrayList<VeiculoDTO> listarVeiculoDTO(Filtro filtro) {

		Page<Veiculo> paginaVeiculo;

		if (filtro.getPlaca() != null) {
			paginaVeiculo = veiculoRepository.listarVeiculoPorPlaca(filtro);
		}
		else if (filtro.getMarca() != null) {
			paginaVeiculo = veiculoRepository.listarVeiculoPorMarca(filtro);
		} else if (filtro.getModelo() != null) {
			paginaVeiculo = veiculoRepository.listarVeiculoPorModelo(filtro);
		} else {
			paginaVeiculo = veiculoRepository.listarVeiculo(filtro);
		}

		List<Veiculo> listaVeiculo = paginaVeiculo.getContent();

		ArrayList<VeiculoDTO> listaVeiculoDTO = new ArrayList<>();

		for (Veiculo veiculo : listaVeiculo) {
			VeiculoDTO veiculoDTO = new VeiculoDTO(veiculo.getPlaca(), veiculo.getMarca(), veiculo.getModelo());
			listaVeiculoDTO.add(veiculoDTO);
		}

		return listaVeiculoDTO;

	}
	
	@Override
	public List<Veiculo> listarVeiculo(Filtro filtro) {

		Page<Veiculo> paginaVeiculo;

		if (filtro.getPlaca() != null) {
			paginaVeiculo = veiculoRepository.listarVeiculoPorPlaca(filtro);
		}
		else if (filtro.getMarca() != null) {
			paginaVeiculo = veiculoRepository.listarVeiculoPorMarca(filtro);
		} else if (filtro.getModelo() != null) {
			paginaVeiculo = veiculoRepository.listarVeiculoPorModelo(filtro);
		} else {
			paginaVeiculo = veiculoRepository.listarVeiculo(filtro);
		}

		return paginaVeiculo.getContent();

	}

	@Override
	public VeiculoDTO inserirVeiculoDTO(VeiculoDTO veiculoDTO) {

		Veiculo veiculo = new Veiculo(veiculoDTO.getPlaca(), veiculoDTO.getMarca(), veiculoDTO.getModelo());
		veiculo.setDadosPosicao(new ArrayList<>());

		veiculoRepository.inserirVeiculo(veiculo);

		return veiculoDTO;
	}
	
	@Override
	public Veiculo inserirVeiculo(VeiculoDTO veiculoDTO) {

		Veiculo veiculo = new Veiculo(veiculoDTO.getPlaca(), veiculoDTO.getMarca(), veiculoDTO.getModelo());

		veiculo = veiculoRepository.inserirVeiculo(veiculo);

		return veiculo;
	}

	@Override
	public ArrayList<VeiculoPoiDTO> listarTempoVeiculoPOI(Filtro filtro) {
		HashMap<String, String> tempoPOI = new HashMap<String, String>();
		ArrayList<VeiculoPoiDTO> listaVeiculoPoiDTO = new ArrayList<>();
		
		List<PoiDTO> listaPoiDTO = poiService.listarPoi(filtro);
		List<VeiculoDTO> listaVeiculoDTO = this.listarVeiculoDTO(filtro);
		
		for(PoiDTO poiDTO : listaPoiDTO) {
			
			double[] intervalos = FuncoesLib.calcularIntervalos(poiDTO.getLatitude(), poiDTO.getLongitude(), poiDTO.getRaio());
			
			for(VeiculoDTO veiculoDTO : listaVeiculoDTO) {
				List<DadosPosicaoDTO> listaDadosPosicao = dadosPosicaoService.listarDadosPosicaoVeiculoIntervalo(intervalos, veiculoDTO.getPlaca());
				BigInteger somaTempoInteiro = new BigInteger("0"); 
				for(DadosPosicaoDTO dadosPosicaoDTO : listaDadosPosicao) {
					//somar o tempo aqui
				}
			}
		}
		
		/*Mock*/
		String veiculo = "TESTE001";
		tempoPOI.put("PONTO 1", "3 dias 5 horas 2 minutos 5 segundos");
		tempoPOI.put("PONTO 2", "3 horas 20 minutos 30 segundos");
		VeiculoPoiDTO veiculoPoiDTO = new VeiculoPoiDTO(veiculo, tempoPOI);
		listaVeiculoPoiDTO.add(veiculoPoiDTO);

		return listaVeiculoPoiDTO;

	}

}
