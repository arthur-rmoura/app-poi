package com.api.core.appl.poi.service.spec;

import java.util.ArrayList;

import com.api.core.appl.dadosposicao.DadosPosicaoDTO;
import com.api.core.appl.util.Filtro;

public interface PoiService {

	ArrayList<DadosPosicaoDTO> listarDadosPosicionamento(Filtro filtro);

	DadosPosicaoDTO inserirDadosPosicionamento(DadosPosicaoDTO dadosPosicaoDTO);

}
