package com.api.core.appl.poi.controller.impl;

import java.math.BigDecimal;
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

import com.api.core.appl.poi.PoiDTO;
import com.api.core.appl.poi.service.spec.PoiService;
import com.api.core.appl.poi.controller.spec.PoiController;
import com.api.core.appl.util.Filtro;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;


@RestController
public class PoiControllerImpl implements PoiController {

	@Autowired
	PoiService poiService;
	
	
	@Operation(	
		summary = "Recupera POIs", 
		description = "Recupera POIs paginados e filtrados por placa e data"
	)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Dados recuperados com sucesso.", content = {@Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = PoiDTO.class)))}), 
	        @ApiResponse(responseCode = "404", description = "Não Encontrado - Não foram encontrados dados com os parâmetros de entrada fornecidos.", content = @Content),
	        @ApiResponse(responseCode = "500", description = "Erro Interno do Servidor", content = @Content)
	})
	@GetMapping("/pois")
	@ResponseBody
	@Override
    public ResponseEntity<ArrayList<PoiDTO>> listarPoi(
    		@RequestParam(name = "numeroPagina", required = false, defaultValue = "0") @Parameter(name = "numeroPagina", description = "Número da página", example = "1") Integer numeroPagina,
    		@RequestParam(name = "tamanhoPagina", required = false, defaultValue = "10") @Parameter(name = "tamanhoPagina", description = "Tamanho da página", example = "1") Integer tamanhoPagina,
    		@RequestParam(name = "nome", required = false) @Parameter(name = "nome", description = "Nome do POI", example = "Ponto 1") String nome, 
    		@RequestParam(name = "raio", required = false) @Parameter(name = "raio", description = "Tamanho do raio do POI em metros", example = "500.0") BigDecimal raio
    ) {
		Filtro filtro = new Filtro();
		filtro.setNumeroPagina(numeroPagina);
		filtro.setTamanhoPagina(tamanhoPagina);
		filtro.setNome(nome);
		filtro.setRaio(raio);
		
		ArrayList<PoiDTO> listaPoiDTO = poiService.listarPoi(filtro);
		
        return new ResponseEntity<ArrayList<PoiDTO>>(listaPoiDTO, HttpStatus.OK);
    }
	
	
	@Operation(	
			summary = "Insere POIs", 
			description = "Insere novos POIs"
		)
		@ApiResponses(value = {
		        @ApiResponse(responseCode = "201", description = "Dados inseridos com sucesso.", content = {@Content(
	                    mediaType = "application/json",
	                    schema = @Schema(implementation = PoiDTO.class))}), 
		        @ApiResponse(responseCode = "500", description = "Erro Interno do Servidor", content = @Content)
		})
		@PostMapping("/pois")
		@ResponseBody
		@Override
	    public ResponseEntity<PoiDTO> inserirPoi(@io.swagger.v3.oas.annotations.parameters.RequestBody(
	    		required = true,
	    		description = "Payload da requisição contendo o conteúdo json do novo dado de posicionamento a ser inserido",
	    		content = {@Content(
	                    mediaType = "application/json",
	                    schema = @Schema(implementation = PoiDTO.class))}
	    		)  
	    		@RequestBody PoiDTO poiDTO) {
			
			poiDTO = poiService.inserirPoi(poiDTO);
			return new ResponseEntity<PoiDTO>(poiDTO, HttpStatus.CREATED);
			
	    }
}

