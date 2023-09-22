package com.api.core.appl.dadosposicao.repository.impl;

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
	public Page<DadosPosicao> listarDadosPosicionamento(Filtro filtro) {
		Pageable pageable = PageRequest.of(filtro.getNumeroPagina(), filtro.getTamanhoPagina());
		return dadosPosicaoRepositoryData.findAll(pageable);
	}


	@Override
	public DadosPosicao inserirDadosPosicionamento(DadosPosicao dadosPosicao) {
		return dadosPosicaoRepositoryData.save(dadosPosicao);
	}

}
