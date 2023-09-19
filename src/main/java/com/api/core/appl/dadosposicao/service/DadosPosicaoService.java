package com.api.core.appl.dadosposicao.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.api.core.appl.dadosposicao.DadosPosicaoDTO;
import com.api.core.appl.util.Filtro;

public class DadosPosicaoService {

	public ArrayList<DadosPosicaoDTO> listaDadosPosicionamento(Filtro filtro) {
		DadosPosicaoDTO dadosPosicaoDTO = new DadosPosicaoDTO();
		dadosPosicaoDTO.setPlaca("FRG1010");
		dadosPosicaoDTO.setDataPosicao(LocalDate.now().toString());
		
		ArrayList<DadosPosicaoDTO> listaDadosPosicaoDTO = new ArrayList<>();
		listaDadosPosicaoDTO.add(dadosPosicaoDTO);
		
		return listaDadosPosicaoDTO;
		
	}

}
