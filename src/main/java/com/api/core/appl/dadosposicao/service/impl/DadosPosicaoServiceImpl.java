package com.api.core.appl.dadosposicao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.api.core.appl.dadosposicao.DadosPosicao;
import com.api.core.appl.dadosposicao.DadosPosicaoDTO;
import com.api.core.appl.dadosposicao.repository.spec.DadosPosicaoRepository;
import com.api.core.appl.dadosposicao.service.spec.DadosPosicaoService;
import com.api.core.appl.util.Filtro;

@Service
public class DadosPosicaoServiceImpl implements DadosPosicaoService{

	@Autowired
	DadosPosicaoRepository dadosPosicaoRepository;
	
	@Override
	public ArrayList<DadosPosicaoDTO> listarDadosPosicionamento(Filtro filtro) {
		
		Page<DadosPosicao> paginaDadosPosicao = dadosPosicaoRepository.listarDadosPosicionamento(filtro);
		List<DadosPosicao> listaDadosPosicao = paginaDadosPosicao.getContent();
		DadosPosicaoDTO dadosPosicaoDTO = new DadosPosicaoDTO();
		dadosPosicaoDTO.setPlaca(listaDadosPosicao.get(0).getPlaca());
		dadosPosicaoDTO.setDataPosicao(listaDadosPosicao.get(0).getTimestampPosicao() + " Timezone " + listaDadosPosicao.get(0).getTimezonePosicao());
		
		ArrayList<DadosPosicaoDTO> listaDadosPosicaoDTO = new ArrayList<>();
		listaDadosPosicaoDTO.add(dadosPosicaoDTO);
		
		return listaDadosPosicaoDTO;
		
	}

	@Override
	public DadosPosicaoDTO inserirDadosPosicionamento(DadosPosicaoDTO dadosPosicaoDTO) {
		Long timestampPosicao = 1000L; //converter do DTO
		Integer timezonePosicao = -3; //converter do DTO 
		
		DadosPosicao dadosPosicao = new DadosPosicao(dadosPosicaoDTO.getPlaca(), timestampPosicao, timezonePosicao, 
				dadosPosicaoDTO.getVelocidade(), dadosPosicaoDTO.getLongitude(), dadosPosicaoDTO.getLatitude(), dadosPosicaoDTO.getIgnicao());
		
		dadosPosicaoRepository.inserirDadosPosicionamento(dadosPosicao);
		
		return dadosPosicaoDTO;
	}

}
