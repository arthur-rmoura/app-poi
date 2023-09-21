package com.api.core.appl.dadosposicao.repository.spec;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.api.core.appl.dadosposicao.DadosPosicao;
import com.api.core.appl.util.Filtro;

public interface DadosPosicaoRepository extends PagingAndSortingRepository<DadosPosicao, Long> {	
	
	Page<DadosPosicao> listaDadosPosicionamento(Filtro filtro);
	
}
