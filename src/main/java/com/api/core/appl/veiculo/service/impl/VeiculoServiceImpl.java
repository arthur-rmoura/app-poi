package com.api.core.appl.veiculo.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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
		Page<DadosPosicao> paginaDadosPosicao = veiculoRepository.listarDadosPosicaoVeiculoIntervalo(intervalo, filtro);
		return paginaDadosPosicao.getContent();
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
				filtro.setPlaca(veiculoDTO.getPlaca());

				List<DadosPosicao> listaDadosPosicao = this.listarDadosPosicaoVeiculoIntervalo(intervalos, filtro);
//				listaDadosPosicao = listaDadosPosicao.stream().sorted(Comparator.comparing(DadosPosicao::getEpochSecondPosicao)).collect(Collectors.toList());
				List<Long> listaEpochSecond = listaDadosPosicao.stream().map(e->e.getEpochSecondPosicao()).collect(Collectors.toList());
				listaEpochSecond.sort(Comparator.comparingLong(Long::longValue));
				
				Long limiteTempo = 500L;
				Long somaTempoLong = 0L; 
				Long ultimoDadoPosicao = Long.MAX_VALUE;
				ArrayList<Long> listaTemposPOI = new ArrayList<Long>();
				for(Long epochsecond : listaEpochSecond) {
					if(epochsecond - ultimoDadoPosicao > limiteTempo) {
						listaTemposPOI.add(somaTempoLong);
						somaTempoLong = 0L;
						ultimoDadoPosicao = Long.MAX_VALUE;
					}
					else {
						somaTempoLong = somaTempoLong + epochsecond;
						ultimoDadoPosicao = epochsecond;
					}
				}
				somaTempoLong = listaTemposPOI.stream().reduce(0L, Long::sum);
				System.out.println();
				System.out.println("POI: " +  poiDTO.getNome() + " Tamanho da Lista: " + listaTemposPOI.size());
				System.out.println("Soma Total:" +  somaTempoLong);
				System.out.println();
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
