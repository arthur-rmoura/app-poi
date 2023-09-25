package com.api.core.appl.poi.repository.spec;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.api.core.appl.poi.Poi;


public interface PoiRepositoryData extends PagingAndSortingRepository<Poi, Long> {
	
	Page<Poi> findAll(Pageable pageable);

	Page<Poi> findByNome(String nome, Pageable pageable);

	Page<Poi> findByRaio(BigDecimal raio, Pageable pageable);
	
}
