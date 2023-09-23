package com.api.core.appl.veiculo.repository.spec;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.api.core.appl.dadosposicao.DadosPosicao;

public interface VeiculoRepositoryData extends PagingAndSortingRepository<DadosPosicao, Long> {
	
	Page<DadosPosicao> findAll(Pageable pageable);
	
}
