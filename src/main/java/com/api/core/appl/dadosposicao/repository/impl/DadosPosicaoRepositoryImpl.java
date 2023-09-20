package com.api.core.appl.dadosposicao.repository.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.api.core.appl.dadosposicao.DadosPosicao;
import com.api.core.appl.dadosposicao.repository.spec.DadosPosicaoRepository;
import com.api.core.appl.util.Filtro;

public class DadosPosicaoRepositoryImpl implements DadosPosicaoRepository{

	@Override
	public Page<DadosPosicao> findAll(Pageable pageable) {
		return this.findAll(pageable);
	}

	@Override
	public Page<DadosPosicao> listaDadosPosicionamento(Filtro filtro) {
		Pageable page = PageRequest.of(filtro.getNumeroPagina(), filtro.getTamanhoPagina());
		return this.findAll(page);
	}

	
}
