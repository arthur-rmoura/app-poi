package com.api.core.appl.dadosposicao.repository.spec;

import java.util.List;

import org.springframework.data.domain.Page;

import com.api.core.appl.dadosposicao.DadosPosicao;
import com.api.core.appl.util.Filtro;

public interface DadosPosicaoRepository {

	DadosPosicao inserirDadosPosicao(DadosPosicao dadosPosicao);

	Page<DadosPosicao> listarDadosPosicao(Filtro filtro);

	Page<DadosPosicao> listarDadosPosicaoPorData(Filtro filtro);

	Page<DadosPosicao> listarDadosPosicaoPorPlaca(Filtro filtro);

	List<DadosPosicao> listarDadosPosicaoVeiculoIntervalo(double[] intervalo, Filtro filtro);

	Page<DadosPosicao> listarDadosPosicaoPorDataTime(Filtro filtro);

	Page<DadosPosicao> listarDadosPosicaoPorDataPlaca(Filtro filtro);

}
