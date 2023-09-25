package com.api.core.appl.veiculo.repository.spec;

import org.springframework.data.domain.Page;

import com.api.core.appl.veiculo.Veiculo;
import com.api.core.appl.util.Filtro;

public interface VeiculoRepository {

	Veiculo inserirVeiculo(Veiculo veiculo);

	Page<Veiculo> listarVeiculo(Filtro filtro);

	Page<Veiculo> listarVeiculoPorPlaca(Filtro filtro);

	Page<Veiculo> listarVeiculoPorMarca(Filtro filtro);

	Page<Veiculo> listarVeiculoPorModelo(Filtro filtro);
}
