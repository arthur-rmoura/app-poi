package com.api.core.appl.dadosposicao.repository.spec;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.api.core.appl.dadosposicao.DadosPosicao;

public interface DadosPosicaoRepositoryData extends PagingAndSortingRepository<DadosPosicao, Long> {
	
	Page<DadosPosicao> findAll(Pageable pageable);

	Page<DadosPosicao> findByEpochSecondPosicaoAndTimezonePosicao(long timestampPosicao, String timezonePosicao,
			Pageable pageable);

	Page<DadosPosicao> findByPlaca(String placa, Pageable pageable);

	@Query("SELECT dp FROM DadosPosicao dp WHERE dp.placa = :placa and dp.latitude >= :minLat and dp.latitude <= :maxLat and dp.longitude >= :minLong and dp.longitude <= :maxLong")
	List<DadosPosicao> findByCustomQuery(String placa, BigDecimal minLat, BigDecimal maxLat, BigDecimal minLong, BigDecimal maxLong);

	@Query("SELECT dp FROM DadosPosicao dp WHERE dp.placa = :placa and dp.latitude >= :minLat and dp.latitude <= :maxLat and dp.longitude >= :minLong and dp.longitude <= :maxLong and "
			+ "dp.epochSecondPosicao between :timestampPosicaoInicio and :timestampPosicaoFim and dp.timezonePosicao = :timezonePosicao")
	List<DadosPosicao> findByCustomQueryIntervaloDated(String placa, BigDecimal minLat, BigDecimal maxLat, BigDecimal minLong, BigDecimal maxLong, long timestampPosicaoInicio,  long timestampPosicaoFim, String timezonePosicao);

	@Query("SELECT dp FROM DadosPosicao dp WHERE dp.placa = :placa and dp.epochSecondPosicao between :timestampPosicaoInicio and :timestampPosicaoFim and dp.timezonePosicao = :timezonePosicao")
	Page<DadosPosicao> findByCustomQueryDataPlacadPaged(String placa, long timestampPosicaoInicio, long timestampPosicaoFim, String timezonePosicao, Pageable pageable);
	
	@Query("SELECT dp FROM DadosPosicao dp WHERE dp.epochSecondPosicao between :timestampPosicaoInicio and :timestampPosicaoFim and dp.timezonePosicao = :timezonePosicao")
	Page<DadosPosicao> findByCustomQueryDataPaged(long timestampPosicaoInicio, long timestampPosicaoFim, String timezonePosicao, Pageable pageable);
	
}
