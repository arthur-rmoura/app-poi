package com.api.core.appl.veiculo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.api.core.appl.veiculo.Veiculo;
import com.api.core.appl.veiculo.repository.spec.VeiculoRepository;
import com.api.core.appl.veiculo.repository.spec.VeiculoRepositoryData;
import com.api.core.appl.dadosposicao.DadosPosicao;
import com.api.core.appl.dadosposicao.repository.spec.DadosPosicaoRepository;
import com.api.core.appl.util.Filtro;

@Repository
public class VeiculoRepositoryImpl implements VeiculoRepository{
	
	private final VeiculoRepositoryData veiculoRepositoryData;
	
	
	@Autowired
	private DadosPosicaoRepository dadosRepository;
	
	public VeiculoRepositoryImpl(VeiculoRepositoryData veiculoRepositoryData) {
		super();
		this.veiculoRepositoryData = veiculoRepositoryData;
	}


	@Override
	public Page<Veiculo> listarVeiculo(Filtro filtro) {
		Pageable pageable = PageRequest.of(filtro.getNumeroPagina(), filtro.getTamanhoPagina());
		return veiculoRepositoryData.findAll(pageable);
	}


	@Override
	public Veiculo inserirVeiculo(Veiculo veiculo) {
		return veiculoRepositoryData.save(veiculo);
	}

	@Override
	public Page<Veiculo> listarVeiculoPorPlaca(Filtro filtro) {
		Pageable pageable = PageRequest.of(filtro.getNumeroPagina(), filtro.getTamanhoPagina());
		return veiculoRepositoryData.findByPlaca(filtro.getPlaca(), pageable);
	}


	@Override
	public Page<Veiculo> listarVeiculoPorMarca(Filtro filtro) {
		Pageable pageable = PageRequest.of(filtro.getNumeroPagina(), filtro.getTamanhoPagina());
		return veiculoRepositoryData.findByMarca(filtro.getMarca(), pageable);
	}
	
	@Override
	public Page<Veiculo> listarVeiculoPorModelo(Filtro filtro) {
		Pageable pageable = PageRequest.of(filtro.getNumeroPagina(), filtro.getTamanhoPagina());
		return veiculoRepositoryData.findByModelo(filtro.getModelo(), pageable);
	}


	@Override
	public List<DadosPosicao> listarDadosPosicaoVeiculoIntervalo(double[] intervalo, Filtro filtro) {
		return dadosRepository.listarDadosPosicaoVeiculoIntervalo(intervalo, filtro);
	}

}
