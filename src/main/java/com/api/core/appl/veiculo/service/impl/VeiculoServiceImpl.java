package com.api.core.appl.veiculo.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.api.core.appl.veiculo.Veiculo;
import com.api.core.appl.veiculo.VeiculoDTO;
import com.api.core.appl.veiculo.VeiculoPoiDTO;
import com.api.core.appl.veiculo.repository.spec.VeiculoRepository;
import com.api.core.appl.veiculo.service.spec.VeiculoService;
import com.api.core.appl.dadosposicao.DadosPosicao;
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
	public List<DadosPosicao> listarDadosPosicaoVeiculoIntervalo(double[] intervalo, Filtro filtro) {
		return veiculoRepository.listarDadosPosicaoVeiculoIntervalo(intervalo, filtro);
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
		LinkedHashMap<String, String> veiculoPOI = new LinkedHashMap<String, String>();
		ArrayList<VeiculoPoiDTO> listaVeiculoPoiDTO = new ArrayList<>();
		
		List<PoiDTO> listaPoiDTO = poiService.listarPoi(filtro);
		listaPoiDTO = listaPoiDTO.stream().sorted(Comparator.comparing(PoiDTO::getNome)).collect(Collectors.toList());
		List<VeiculoDTO> listaVeiculoDTO = this.listarVeiculoDTO(filtro);
		
			
		for(VeiculoDTO veiculoDTO : listaVeiculoDTO) {
			filtro.setPlaca(veiculoDTO.getPlaca());
			
			for(PoiDTO poiDTO : listaPoiDTO) {
				
				double[] intervalos = FuncoesLib.calcularIntervalos(poiDTO.getLatitude(), poiDTO.getLongitude(), poiDTO.getRaio().divide(new BigDecimal("1000.0")));
				List<DadosPosicao> listaDadosPosicao = this.listarDadosPosicaoVeiculoIntervalo(intervalos, filtro);
				List<Long> listaEpochSecond = listaDadosPosicao.stream().map(e->e.getEpochSecondPosicao()).collect(Collectors.toList());
				listaEpochSecond.sort(Comparator.comparingLong(Long::longValue));
				
				Long limiteTempo = 10000L; //2.7horas
				Long somaTempoLong = 0L; 
				Long ultimoDadoPosicao = Long.MAX_VALUE;
				Long diferenca = 0L;
				ArrayList<Long> listaTemposPOI = new ArrayList<Long>();
				Boolean inicioLista = true;
				for(Long epochsecond : listaEpochSecond) {
					if(epochsecond - ultimoDadoPosicao > limiteTempo) {
						listaTemposPOI.add(somaTempoLong);
						somaTempoLong = 0L;
						ultimoDadoPosicao = epochsecond;
						diferenca = 0L;
					}
					else {
						if(inicioLista) {
							diferenca = 0L;
							inicioLista = false;
						}
						else {
							diferenca = epochsecond - ultimoDadoPosicao;
						}
						
						somaTempoLong = somaTempoLong + diferenca;
						ultimoDadoPosicao = epochsecond;
					}
				}
				listaTemposPOI.add(somaTempoLong);
				somaTempoLong = listaTemposPOI.stream().reduce(0L, Long::sum);
				veiculoPOI.put(poiDTO.getNome(), FuncoesLib.secondsToTime(somaTempoLong));
			}

			VeiculoPoiDTO veiculoPoiDTO = new VeiculoPoiDTO(veiculoDTO.getPlaca(), veiculoPOI);
			listaVeiculoPoiDTO.add(veiculoPoiDTO);
			veiculoPOI = new LinkedHashMap<String, String>();
		}
		
	

		return listaVeiculoPoiDTO;

	}

}
