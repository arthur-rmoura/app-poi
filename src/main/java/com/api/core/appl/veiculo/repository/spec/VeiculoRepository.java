package com.api.core.appl.veiculo.repository.spec;

import org.springframework.data.domain.Page;

import com.api.core.appl.dadosposicao.DadosPosicao;
import com.api.core.appl.util.Filtro;

public interface VeiculoRepository {

	DadosPosicao inserirDadosPosicionamento(DadosPosicao dadosPosicao);

	Page<DadosPosicao> listarDadosPosicionamento(Filtro filtro);
}
