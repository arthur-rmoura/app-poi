package com.api.core.appl.dadosposicao.repository.spec;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.api.core.appl.dadosposicao.DadosPosicao;
import com.api.core.appl.util.Filtro;

public interface DadosPosicaoRepository extends Repository<DadosPosicao, Long> {
	
    Page<DadosPosicao> findAll(Pageable pageable);

	Page<DadosPosicao> listaDadosPosicionamento(Filtro filtro);

}
