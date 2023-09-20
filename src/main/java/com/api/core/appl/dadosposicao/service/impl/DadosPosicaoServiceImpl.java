package com.api.core.appl.dadosposicao.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.core.appl.dadosposicao.DadosPosicaoDTO;
import com.api.core.appl.dadosposicao.repository.spec.DadosPosicaoRepository;
import com.api.core.appl.dadosposicao.service.spec.DadosPosicaoService;
import com.api.core.appl.util.Filtro;

@Service
public class DadosPosicaoServiceImpl implements DadosPosicaoService{

	@Autowired
	DadosPosicaoRepository dadosPosicaoRepository;
	
	@Override
	public ArrayList<DadosPosicaoDTO> listaDadosPosicionamento(Filtro filtro) {
		
		//dadosPosicaoRepository.listaDadosPosicionamento(filtro);
		DadosPosicaoDTO dadosPosicaoDTO = new DadosPosicaoDTO();
		dadosPosicaoDTO.setPlaca("FRG1010");
		dadosPosicaoDTO.setDataPosicao(LocalDate.now().toString());
		
		ArrayList<DadosPosicaoDTO> listaDadosPosicaoDTO = new ArrayList<>();
		listaDadosPosicaoDTO.add(dadosPosicaoDTO);
		
		return listaDadosPosicaoDTO;
		
	}

}
