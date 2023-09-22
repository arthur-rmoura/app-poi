package com.api.core.appl.dadosposicao.service.spec;

import java.util.ArrayList;

import com.api.core.appl.dadosposicao.DadosPosicaoDTO;
import com.api.core.appl.util.Filtro;

public interface DadosPosicaoService {

	ArrayList<DadosPosicaoDTO> listarDadosPosicionamento(Filtro filtro);

	DadosPosicaoDTO inserirDadosPosicionamento(DadosPosicaoDTO dadosPosicaoDTO);

}
