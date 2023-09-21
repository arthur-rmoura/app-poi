package com.api.core.appl.dadosposicao.repository.impl;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.api.core.appl.dadosposicao.DadosPosicao;
import com.api.core.appl.dadosposicao.repository.spec.DadosPosicaoRepository;
import com.api.core.appl.util.Filtro;

@Repository
public class DadosPosicaoRepositoryImpl implements DadosPosicaoRepository  {

	@Override
	public Page<DadosPosicao> listaDadosPosicionamento(Filtro filtro) {
		Pageable pageable = PageRequest.of(filtro.getNumeroPagina(), filtro.getTamanhoPagina());
		return this.findAll(pageable);
	}

	@Override
	public Iterable<DadosPosicao> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<DadosPosicao> findAll(Pageable pageable) {
		return DadosPosicaoRepository.super.findAll(pageable);
	}

	@Override
	public <S extends DadosPosicao> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends DadosPosicao> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<DadosPosicao> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<DadosPosicao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<DadosPosicao> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DadosPosicao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends DadosPosicao> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
