package com.api.core.appl.dadosposicao.service.spec;

import java.util.ArrayList;

import com.api.core.appl.dadosposicao.DadosPosicaoDTO;
import com.api.core.appl.util.Filtro;

public interface DadosPosicaoService {

	ArrayList<DadosPosicaoDTO> listarDadosPosicao(Filtro filtro);

	DadosPosicaoDTO inserirDadosPosicao(DadosPosicaoDTO dadosPosicaoDTO);

	ArrayList<DadosPosicaoDTO> listarDadosPosicaoVeiculoIntervalo(double[] intervalos, String placa);

}
