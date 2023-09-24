package com.api.core.appl.dadosposicao.repository.spec;

import org.springframework.data.domain.Page;

import com.api.core.appl.dadosposicao.DadosPosicao;
import com.api.core.appl.util.Filtro;

public interface DadosPosicaoRepository {

	DadosPosicao inserirDadosPosicao(DadosPosicao dadosPosicao);

	Page<DadosPosicao> listarDadosPosicao(Filtro filtro);

	Page<DadosPosicao> listarDadosPosicaoPorData(Filtro filtro);

	Page<DadosPosicao> listarDadosPosicaoPorPlaca(Filtro filtro);
}
