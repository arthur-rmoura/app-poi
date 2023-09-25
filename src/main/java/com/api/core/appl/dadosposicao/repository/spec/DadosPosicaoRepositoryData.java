package com.api.core.appl.dadosposicao.repository.spec;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.api.core.appl.dadosposicao.DadosPosicao;

public interface DadosPosicaoRepositoryData extends PagingAndSortingRepository<DadosPosicao, Long> {
	
	Page<DadosPosicao> findAll(Pageable pageable);

	Page<DadosPosicao> findByEpochSecondPosicaoAndTimezonePosicao(long timestampPosicao, String timezonePosicao,
			Pageable pageable);

	Page<DadosPosicao> findByPlaca(String placa, Pageable pageable);
	
}
