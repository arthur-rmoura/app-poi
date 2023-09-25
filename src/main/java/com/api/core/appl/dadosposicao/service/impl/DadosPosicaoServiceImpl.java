package com.api.core.appl.dadosposicao.service.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.api.core.appl.dadosposicao.DadosPosicao;
import com.api.core.appl.dadosposicao.DadosPosicaoDTO;
import com.api.core.appl.dadosposicao.repository.spec.DadosPosicaoRepository;
import com.api.core.appl.dadosposicao.service.spec.DadosPosicaoService;
import com.api.core.appl.util.Filtro;
import com.api.core.appl.veiculo.Veiculo;
import com.api.core.appl.veiculo.VeiculoDTO;
import com.api.core.appl.veiculo.service.spec.VeiculoService;

@Service
public class DadosPosicaoServiceImpl implements DadosPosicaoService {

	@Autowired
	DadosPosicaoRepository dadosPosicaoRepository;

	@Autowired
	VeiculoService veiculoService;
	
	@Override
	public ArrayList<DadosPosicaoDTO> listarDadosPosicao(Filtro filtro) {

		Page<DadosPosicao> paginaDadosPosicao;
		
		if(filtro.getPlaca() != null) {
			paginaDadosPosicao = dadosPosicaoRepository.listarDadosPosicaoPorPlaca(filtro);
		}
		else if (filtro.getData() != null) {
			paginaDadosPosicao = dadosPosicaoRepository.listarDadosPosicaoPorData(filtro);
		}
		else {
			paginaDadosPosicao = dadosPosicaoRepository.listarDadosPosicao(filtro);
		}
		
		List<DadosPosicao> listaDadosPosicao = paginaDadosPosicao.getContent();
		

		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
			    .parseCaseInsensitive()
			    .appendPattern("EEE MMM dd uuuu HH:mm:ss zXX (zzzz)")
			    .toFormatter(Locale.ENGLISH);
		
		ArrayList<DadosPosicaoDTO> listaDadosPosicaoDTO = new ArrayList<>();
		Instant instant = Instant.now();
		
		for(DadosPosicao dadosPosicao : listaDadosPosicao) {
			LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(dadosPosicao.getEpochSecondPosicao().longValue(), 0, ZoneId.of(dadosPosicao.getTimezonePosicao()).getRules().getOffset(instant));
			ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of(dadosPosicao.getTimezonePosicao()));
			DadosPosicaoDTO dadosPosicaoDTO = new DadosPosicaoDTO(dadosPosicao.getPlaca(), zonedDateTime.format(formatter), dadosPosicao.getVelocidade(), dadosPosicao.getLongitude(), dadosPosicao.getLatitude(), dadosPosicao.getIgnicao());
			listaDadosPosicaoDTO.add(dadosPosicaoDTO);
		}

		return listaDadosPosicaoDTO;

	}

	@Override
	public DadosPosicaoDTO inserirDadosPosicao(DadosPosicaoDTO dadosPosicaoDTO) {
		
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
			    .parseCaseInsensitive()
			    .appendPattern("EEE MMM dd uuuu HH:mm:ss zXX (zzzz)")
			    .toFormatter(Locale.ENGLISH);
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(dadosPosicaoDTO.getDataPosicao().replace("(Hora oficial do Brasil)", "(Brasilia Time)"), formatter);
		long timestampPosicao = zonedDateTime.toEpochSecond();
		String timezonePosicao = zonedDateTime.getZone().getId();

		DadosPosicao dadosPosicao = new DadosPosicao(dadosPosicaoDTO.getPlaca(), timestampPosicao, timezonePosicao,
				dadosPosicaoDTO.getVelocidade(), dadosPosicaoDTO.getLongitude(), dadosPosicaoDTO.getLatitude(),
				dadosPosicaoDTO.getIgnicao());

		Filtro filtro = new Filtro();
		filtro.setPlaca(dadosPosicaoDTO.getPlaca());
		filtro.setNumeroPagina(0);
		filtro.setTamanhoPagina(10);
		List<Veiculo> listaVeiculo = veiculoService.listarVeiculo(filtro);
		
		if(listaVeiculo.isEmpty()) {
			VeiculoDTO veiculoDTO = new VeiculoDTO(dadosPosicaoDTO.getPlaca(), "", "");
			Veiculo veiculo = veiculoService.inserirVeiculo(veiculoDTO);
			dadosPosicao.setVeiculo(veiculo);
			dadosPosicaoRepository.inserirDadosPosicao(dadosPosicao);
		}
		else {
			dadosPosicao.setVeiculo(listaVeiculo.get(0));
			dadosPosicaoRepository.inserirDadosPosicao(dadosPosicao);
		}

		return dadosPosicaoDTO;
	}

}
