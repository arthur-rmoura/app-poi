package com.api.core.appl.dadosposicao.controller.spec;

import java.util.ArrayList;

import com.api.core.appl.dadosposicao.DadosPosicaoDTO;

public interface DadosPosicaoController  {
	
	public ArrayList<DadosPosicaoDTO> listaDadosPosicionamento(Integer numeroPagina, Integer tamanhoPagina, String placa, String dataPosicao);

}
