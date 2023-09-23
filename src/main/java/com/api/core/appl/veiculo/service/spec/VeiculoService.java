package com.api.core.appl.veiculo.service.spec;

import java.util.ArrayList;

import com.api.core.appl.dadosposicao.DadosPosicaoDTO;
import com.api.core.appl.util.Filtro;

public interface VeiculoService {

	ArrayList<DadosPosicaoDTO> listarDadosPosicionamento(Filtro filtro);

	DadosPosicaoDTO inserirDadosPosicionamento(DadosPosicaoDTO dadosPosicaoDTO);

}
