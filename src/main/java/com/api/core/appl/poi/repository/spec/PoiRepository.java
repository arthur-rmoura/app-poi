package com.api.core.appl.poi.repository.spec;

import org.springframework.data.domain.Page;

import com.api.core.appl.dadosposicao.DadosPosicao;
import com.api.core.appl.util.Filtro;

public interface PoiRepository {

	DadosPosicao inserirDadosPosicionamento(DadosPosicao dadosPosicao);

	Page<DadosPosicao> listarDadosPosicionamento(Filtro filtro);
}
