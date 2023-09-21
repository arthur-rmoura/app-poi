package com.api.core.appl.dadosposicao.service.impl;

import java.util.ArrayList;

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
	public ArrayList<DadosPosicaoDTO> listaDadosPosicionamento(Filtro filtro) {
		
		Page<DadosPosicao> paginaDadosPosicao = dadosPosicaoRepository.listaDadosPosicionamento(filtro);
		ArrayList<DadosPosicao> listaDadosPosicao = (ArrayList<DadosPosicao>) paginaDadosPosicao.getContent();
		DadosPosicaoDTO dadosPosicaoDTO = new DadosPosicaoDTO();
		dadosPosicaoDTO.setPlaca(listaDadosPosicao.get(0).getPlaca());
		dadosPosicaoDTO.setDataPosicao(listaDadosPosicao.get(0).getTimestampPosicao() + " Timezone " + listaDadosPosicao.get(0).getTimezonePosicao());
		
		ArrayList<DadosPosicaoDTO> listaDadosPosicaoDTO = new ArrayList<>();
		listaDadosPosicaoDTO.add(dadosPosicaoDTO);
		
		return listaDadosPosicaoDTO;
		
	}

}
