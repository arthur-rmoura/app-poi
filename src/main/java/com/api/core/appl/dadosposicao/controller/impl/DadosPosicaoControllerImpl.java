package com.api.core.appl.dadosposicao.controller.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.core.appl.dadosposicao.DadosPosicaoDTO;
import com.api.core.appl.dadosposicao.controller.spec.DadosPosicaoController;
import com.api.core.appl.dadosposicao.service.spec.DadosPosicaoService;
import com.api.core.appl.util.Filtro;

import javax.ws.rs.QueryParam;

@RestController
public class DadosPosicaoControllerImpl implements DadosPosicaoController {

	@Autowired
	DadosPosicaoService dadosPosicaoService;
	
	@GetMapping("/dados-posicao")
	@Override
    public ArrayList<DadosPosicaoDTO> listaDadosPosicionamento(
    		@QueryParam(value = "numeroPagina")Integer numeroPagina,
    		@QueryParam(value = "tamanhoPagina")Integer tamanhoPagina,
    		@QueryParam(value = "placa")String placa, 
    		@QueryParam(value = "dataPosicao")String dataPosicao
    ) {
		Filtro filtro = new Filtro();
		filtro.setNumeroPagina(numeroPagina == null ? 0 : numeroPagina);
		filtro.setTamanhoPagina(tamanhoPagina == null ? 10 : tamanhoPagina);
		filtro.setPlaca(placa);
		filtro.setData(dataPosicao);
		
		ArrayList<DadosPosicaoDTO> listaDadosPosicaoDTO = dadosPosicaoService.listaDadosPosicionamento(filtro);
		
        return listaDadosPosicaoDTO;
    }
}
