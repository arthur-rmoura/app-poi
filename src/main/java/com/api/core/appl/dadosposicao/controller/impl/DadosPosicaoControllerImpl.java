package com.api.core.appl.dadosposicao.controller.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.core.appl.dadosposicao.DadosPosicaoDTO;
import com.api.core.appl.dadosposicao.controller.spec.DadosPosicaoController;
import com.api.core.appl.dadosposicao.service.spec.DadosPosicaoService;
import com.api.core.appl.util.Filtro;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;


@RestController
public class DadosPosicaoControllerImpl implements DadosPosicaoController {

	@Autowired
	DadosPosicaoService dadosPosicaoService;
	
	
	@Operation(	
		summary = "Recupera dados de posição", 
		description = "Recupera dados de posição paginados e filtrados por placa e data"
	)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Dados recuperados com sucesso.", content = {@Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = DadosPosicaoDTO.class)))}), 
	        @ApiResponse(responseCode = "404", description = "Não Encontrado - Não foram encontrados dados com os parâmetros de entrada fornecidos.", content = @Content),
	        @ApiResponse(responseCode = "500", description = "Erro Interno do Servidor", content = @Content)
	})
	@GetMapping("/dados-posicao")
	@ResponseBody
	@Override
    public ResponseEntity<ArrayList<DadosPosicaoDTO>> listarDadosPosicionamento(
    		@RequestParam(name = "numeroPagina", required = false, defaultValue = "0") @Parameter(name = "numeroPagina", description = "Número da página", example = "1") Integer numeroPagina,
    		@RequestParam(name = "tamanhoPagina", required = false, defaultValue = "10") @Parameter(name = "tamanhoPagina", description = "Tamanho da página", example = "10") Integer tamanhoPagina,
    		@RequestParam(name = "placa", required = false) @Parameter(name = "placa", description = "Placa do veículo", example = "TST0101") String placa, 
    		@RequestParam(name = "data", required = false) @Parameter(name = "data", description = "Data do dados de posição posição", example = "Mon Dec 31 2018 00:06:03 GMT-0200 (Hora oficial do Brasil)") String data
    ) {
		Filtro filtro = new Filtro();
		filtro.setNumeroPagina(numeroPagina);
		filtro.setTamanhoPagina(tamanhoPagina);
		filtro.setPlaca(placa);
		filtro.setData(data);
		
		ArrayList<DadosPosicaoDTO> listaDadosPosicaoDTO = dadosPosicaoService.listarDadosPosicao(filtro);
		
        return new ResponseEntity<ArrayList<DadosPosicaoDTO>>(listaDadosPosicaoDTO, HttpStatus.OK);
    }
	
	
	@Operation(	
			summary = "Insere dados de posição", 
			description = "Insere novos dados de posição"
		)
		@ApiResponses(value = {
		        @ApiResponse(responseCode = "201", description = "Dados inseridos com sucesso.", content = {@Content(
	                    mediaType = "application/json",
	                    schema = @Schema(implementation = DadosPosicaoDTO.class))}), 
		        @ApiResponse(responseCode = "500", description = "Erro Interno do Servidor", content = @Content)
		})
		@PostMapping("/dados-posicao")
		@ResponseBody
		@Override
	    public ResponseEntity<DadosPosicaoDTO> inserirDadosPosicionamento(@io.swagger.v3.oas.annotations.parameters.RequestBody(
	    		required = true,
	    		description = "Payload da requisição contendo o conteúdo json do novo dado de posicionamento a ser inserido",
	    		content = {@Content(
	                    mediaType = "application/json",
	                    schema = @Schema(implementation = DadosPosicaoDTO.class))}
	    		)  
	    		@RequestBody DadosPosicaoDTO dadosPosicaoDTO) {
			
			dadosPosicaoDTO = dadosPosicaoService.inserirDadosPosicao(dadosPosicaoDTO);
			return new ResponseEntity<DadosPosicaoDTO>(dadosPosicaoDTO, HttpStatus.CREATED);
			
	    }
}

