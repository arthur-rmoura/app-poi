package com.api.core.appl.dadosposicao.controller.spec;

import java.util.ArrayList;

import com.api.core.appl.dadosposicao.DadosPosicaoDTO;

public interface DadosPosicaoController  {
	

	ArrayList<DadosPosicaoDTO> listarDadosPosicionamento(Integer numeroPagina, Integer tamanhoPagina, String placa, String dataPosicao);

	DadosPosicaoDTO inserirDadosPosicionamento(DadosPosicaoDTO dadosPosicaoDTO);

}
