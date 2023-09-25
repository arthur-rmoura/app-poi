package com.api.core.appl.dadosposicao.repository.impl;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.api.core.appl.dadosposicao.DadosPosicao;
import com.api.core.appl.dadosposicao.repository.spec.DadosPosicaoRepository;
import com.api.core.appl.dadosposicao.repository.spec.DadosPosicaoRepositoryData;
import com.api.core.appl.util.Filtro;

@Repository
public class DadosPosicaoRepositoryImpl implements DadosPosicaoRepository{
	
	private final DadosPosicaoRepositoryData dadosPosicaoRepositoryData;
	
	public DadosPosicaoRepositoryImpl(DadosPosicaoRepositoryData dadosPosicaoRepositoryData) {
		super();
		this.dadosPosicaoRepositoryData = dadosPosicaoRepositoryData;
	}


	@Override
	public Page<DadosPosicao> listarDadosPosicao(Filtro filtro) {
		Pageable pageable = PageRequest.of(filtro.getNumeroPagina(), filtro.getTamanhoPagina());
		return dadosPosicaoRepositoryData.findAll(pageable);
	}


	@Override
	public DadosPosicao inserirDadosPosicao(DadosPosicao dadosPosicao) {
		return dadosPosicaoRepositoryData.save(dadosPosicao);
	}


	@Override
	public Page<DadosPosicao> listarDadosPosicaoPorData(Filtro filtro) {
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
			    .parseCaseInsensitive()
			    .appendPattern("EEE MMM dd uuuu HH:mm:ss zXX (zzzz)")
			    .toFormatter(Locale.ENGLISH);
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(filtro.getData().replace("(Hora oficial do Brasil)", "(Brasilia Time)"), formatter);
		long timestampPosicao = zonedDateTime.toEpochSecond();
		String timezonePosicao = zonedDateTime.getZone().getId();
		
		Pageable pageable = PageRequest.of(filtro.getNumeroPagina(), filtro.getTamanhoPagina());
		return dadosPosicaoRepositoryData.findByEpochSecondPosicaoAndTimezonePosicao(timestampPosicao, timezonePosicao, pageable);
	}


	@Override
	public Page<DadosPosicao> listarDadosPosicaoPorPlaca(Filtro filtro) {
		Pageable pageable = PageRequest.of(filtro.getNumeroPagina(), filtro.getTamanhoPagina());
		return dadosPosicaoRepositoryData.findByPlaca(filtro.getPlaca(), pageable);

	}


	@Override
	public Page<DadosPosicao> listarDadosPosicaoVeiculoIntervalo(double[] intervalo, Filtro filtro) {
		Pageable pageable = PageRequest.of(filtro.getNumeroPagina(), filtro.getTamanhoPagina());
		//colocar a data depois 
		return dadosPosicaoRepositoryData.findByCustomQuery(filtro.getPlaca(), new BigDecimal(intervalo[0]), new BigDecimal(intervalo[1]), new BigDecimal(intervalo[2]), new BigDecimal(intervalo[3]), pageable);
	}

}
