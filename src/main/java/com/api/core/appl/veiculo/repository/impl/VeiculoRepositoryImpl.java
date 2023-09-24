package com.api.core.appl.veiculo.repository.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.api.core.appl.veiculo.Veiculo;
import com.api.core.appl.veiculo.repository.spec.VeiculoRepository;
import com.api.core.appl.veiculo.repository.spec.VeiculoRepositoryData;
import com.api.core.appl.util.Filtro;

@Repository
public class VeiculoRepositoryImpl implements VeiculoRepository{
	
	private final VeiculoRepositoryData veiculoRepositoryData;
	
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

}
