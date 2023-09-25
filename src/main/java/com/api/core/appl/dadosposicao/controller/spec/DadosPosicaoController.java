package com.api.core.appl.dadosposicao.controller.spec;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.api.core.appl.dadosposicao.DadosPosicaoDTO;

public interface DadosPosicaoController  {
	

	ResponseEntity<ArrayList<DadosPosicaoDTO>> listarDadosPosicionamento(Integer numeroPagina, Integer tamanhoPagina, String placa, String dataPosicao);

	ResponseEntity<DadosPosicaoDTO> inserirDadosPosicionamento(DadosPosicaoDTO dadosPosicaoDTO);

}
