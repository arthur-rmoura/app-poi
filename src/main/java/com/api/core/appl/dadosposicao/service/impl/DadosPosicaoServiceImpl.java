package com.api.core.appl.dadosposicao.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.api.core.appl.dadosposicao.DadosPosicao;
import com.api.core.appl.dadosposicao.DadosPosicaoDTO;
import com.api.core.appl.dadosposicao.repository.spec.DadosPosicaoRepository;
import com.api.core.appl.dadosposicao.service.spec.DadosPosicaoService;
import com.api.core.appl.util.Filtro;

@Service
public class DadosPosicaoServiceImpl implements DadosPosicaoService {

	@Autowired
	DadosPosicaoRepository dadosPosicaoRepository;

	@Override
	public ArrayList<DadosPosicaoDTO> listarDadosPosicionamento(Filtro filtro) {

		Page<DadosPosicao> paginaDadosPosicao = dadosPosicaoRepository.listarDadosPosicionamento(filtro);
		List<DadosPosicao> listaDadosPosicao = paginaDadosPosicao.getContent();
		DadosPosicaoDTO dadosPosicaoDTO = new DadosPosicaoDTO();
		dadosPosicaoDTO.setPlaca(listaDadosPosicao.get(0).getPlaca());
		dadosPosicaoDTO.setDataPosicao(listaDadosPosicao.get(0).getTimestampPosicao() + " Timezone "
				+ listaDadosPosicao.get(0).getTimezonePosicao());

		ArrayList<DadosPosicaoDTO> listaDadosPosicaoDTO = new ArrayList<>();
		listaDadosPosicaoDTO.add(dadosPosicaoDTO);

		return listaDadosPosicaoDTO;

	}

	@Override
	public DadosPosicaoDTO inserirDadosPosicionamento(DadosPosicaoDTO dadosPosicaoDTO) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate localDate = LocalDate.parse(dadosPosicaoDTO.getDataPosicao(), formatter);
		
		Long timestampPosicao = 1000L; // extrair da localDate
		Integer timezonePosicao = -3; // extrair da localDate

		DadosPosicao dadosPosicao = new DadosPosicao(dadosPosicaoDTO.getPlaca(), timestampPosicao, timezonePosicao,
				dadosPosicaoDTO.getVelocidade(), dadosPosicaoDTO.getLongitude(), dadosPosicaoDTO.getLatitude(),
				dadosPosicaoDTO.getIgnicao());

		dadosPosicaoRepository.inserirDadosPosicionamento(dadosPosicao);

		return dadosPosicaoDTO;
	}

}
