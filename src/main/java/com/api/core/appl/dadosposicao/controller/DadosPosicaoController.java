package com.api.core.appl.dadosposicao.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.core.appl.dadosposicao.DadosPosicaoDTO;
import com.api.core.appl.dadosposicao.service.DadosPosicaoService;
import com.api.core.appl.util.Filtro;

import javax.ws.rs.QueryParam;

@RestController
public class DadosPosicaoController {

	@Autowired
	DadosPosicaoService dadosPosicaoService;
	
	@GetMapping("/dados-posicao")
    public ArrayList<DadosPosicaoDTO> listaDadosPosicionamento(
    		@QueryParam(value = "placa")String placa, 
    		@QueryParam(value = "dataPosicao")String dataPosicao
    ) {
		Filtro filtro = new Filtro();
		filtro.setPlaca(placa);
		filtro.setData(dataPosicao);
		
		ArrayList<DadosPosicaoDTO> listaDadosPosicaoDTO = dadosPosicaoService.listaDadosPosicionamento(filtro);
		
        return listaDadosPosicaoDTO;
    }
}
