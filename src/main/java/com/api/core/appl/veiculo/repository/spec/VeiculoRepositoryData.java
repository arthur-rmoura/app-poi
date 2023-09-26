package com.api.core.appl.veiculo.repository.spec;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.api.core.appl.veiculo.Veiculo;

public interface VeiculoRepositoryData extends PagingAndSortingRepository<Veiculo, String> {

	Page<Veiculo> findAll(Pageable pageable);

	Page<Veiculo> findByPlaca(String placa, Pageable pageable);

	Page<Veiculo> findByMarca(String marca, Pageable pageable);

	Page<Veiculo> findByModelo(String modelo, Pageable pageable);

}
