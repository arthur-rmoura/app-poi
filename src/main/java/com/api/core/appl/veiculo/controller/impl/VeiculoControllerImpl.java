package com.api.core.appl.veiculo.controller.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.core.appl.veiculo.VeiculoDTO;
import com.api.core.appl.veiculo.VeiculoPoiDTO;
import com.api.core.appl.veiculo.service.spec.VeiculoService;
import com.api.core.appl.veiculo.controller.spec.VeiculoController;
import com.api.core.appl.util.Filtro;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;


@RestController
public class VeiculoControllerImpl implements VeiculoController {

	@Autowired
	VeiculoService veiculoService;
	
	
	@Operation(	
		summary = "Recupera Veiculos", 
		description = "Recupera Veiculos paginados e filtrados por placa, marca e modelo"
	)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Dados recuperados com sucesso.", content = {@Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = VeiculoDTO.class)))}), 
	        @ApiResponse(responseCode = "404", description = "Não Encontrado - Não foram encontrados dados com os parâmetros de entrada fornecidos.", content = @Content),
	        @ApiResponse(responseCode = "500", description = "Erro Interno do Servidor", content = @Content)
	})
	@GetMapping("/veiculos")
	@ResponseBody
	@Override
    public ResponseEntity<ArrayList<VeiculoDTO>> listarVeiculo(
    		@RequestParam(name = "numeroPagina", required = false, defaultValue = "0") @Parameter(name = "numeroPagina", description = "Número da página", example = "1", in = ParameterIn.QUERY) Integer numeroPagina,
    		@RequestParam(name = "tamanhoPagina", required = false, defaultValue = "10") @Parameter(name = "tamanhoPagina", description = "Tamanho da página", example = "10", in = ParameterIn.QUERY) Integer tamanhoPagina,
    		@RequestParam(name = "placa", required = false) @Parameter(name = "placa", description = "Placa do Veículo", example = "TESTE001", in = ParameterIn.QUERY) String placa, 
    		@RequestParam(name = "marca", required = false) @Parameter(name = "marca", description = "Marca do Veículo", example = "Fiat", in = ParameterIn.QUERY) String marca,
    		@RequestParam(name = "modelo", required = false) @Parameter(name = "modelo", description = "Modelo do Veículo", example = "Uno", in = ParameterIn.QUERY) String modelo
    ) {
		Filtro filtro = new Filtro();
		filtro.setNumeroPagina(numeroPagina);
		filtro.setTamanhoPagina(tamanhoPagina);
		filtro.setPlaca(placa);
		filtro.setMarca(marca);
		filtro.setModelo(modelo);
		
		ArrayList<VeiculoDTO> listaVeiculoDTO = veiculoService.listarVeiculoDTO(filtro);
		
        return new ResponseEntity<ArrayList<VeiculoDTO>>(listaVeiculoDTO, HttpStatus.OK);
    }
	
	
	@Operation(	
			summary = "Insere Veículos", 
			description = "Insere novos Veículos"
		)
		@ApiResponses(value = {
		        @ApiResponse(responseCode = "201", description = "Dados inseridos com sucesso.", content = {@Content(
	                    mediaType = "application/json",
	                    schema = @Schema(implementation = VeiculoDTO.class))}), 
		        @ApiResponse(responseCode = "500", description = "Erro Interno do Servidor", content = @Content)
		})
		@PostMapping("/veiculos")
		@ResponseBody
		@Override
	    public ResponseEntity<VeiculoDTO> inserirVeiculo(@io.swagger.v3.oas.annotations.parameters.RequestBody(
	    		required = true,
	    		description = "Payload da requisição contendo o conteúdo json do novo veículo a ser inserido",
	    		content = {@Content(
	                    mediaType = "application/json",
	                    schema = @Schema(implementation = VeiculoDTO.class))}
	    		)  
	    		@RequestBody VeiculoDTO veiculoDTO) {
			
			veiculoDTO = veiculoService.inserirVeiculoDTO(veiculoDTO);
			return new ResponseEntity<VeiculoDTO>(veiculoDTO, HttpStatus.CREATED);
			
	    }
	
	
	@Operation(	
			summary = "Recupera Tempo de Todos os Veiculos em POIs", 
			description = "Recupera o tempo de todos veículos em POIs podendo filtrar por POI e data"
		)
		@ApiResponses(value = {
		        @ApiResponse(responseCode = "200", description = "Dados recuperados com sucesso.", content = {@Content(
	                    mediaType = "application/json",
	                    array = @ArraySchema(schema = @Schema(implementation = VeiculoPoiDTO.class)))}), 
		        @ApiResponse(responseCode = "404", description = "Não Encontrado - Não foram encontrados dados com os parâmetros de entrada fornecidos.", content = @Content),
		        @ApiResponse(responseCode = "500", description = "Erro Interno do Servidor", content = @Content)
		})
		@GetMapping("/veiculos/relatorio-pois")
		@ResponseBody
		@Override
	    public ResponseEntity<ArrayList<VeiculoPoiDTO>> listarTempoVeiculosPOI(
	    		@RequestParam(name = "nomePoi", required = false) @Parameter(name = "nomePoi", description = "Nome do POI desejado", example = "PONTO 1", in = ParameterIn.QUERY) String nomePoi, 
	    		@RequestParam(name = "data", required = false) @Parameter(name = "data", description = "Data para a pesquisa", example = "Mon Dec 31 2018 00:06:03 GMT-0200 (Hora oficial do Brasil)", in = ParameterIn.QUERY) String data
	    ) {
			Filtro filtro = new Filtro();
			filtro.setNome(nomePoi);
			filtro.setData(data);
			filtro.setNumeroPagina(0);
			filtro.setTamanhoPagina(1000000);
			
			ArrayList<VeiculoPoiDTO> listaVeiculoPoiDTO = veiculoService.listarTempoVeiculoPOI(filtro);
			
	        return new ResponseEntity<ArrayList<VeiculoPoiDTO>>(listaVeiculoPoiDTO, HttpStatus.OK);
	    }
	
	
	@Operation(	
			summary = "Recupera Tempo de um veículo em específico em POIs", 
			description = "Recupera o tempo do veículo passado como parâmetro em POIs podendo filtrar por POI e data"
		)
		@ApiResponses(value = {
		        @ApiResponse(responseCode = "200", description = "Dados recuperados com sucesso.", content = {@Content(
	                    mediaType = "application/json",
	                    array = @ArraySchema(schema = @Schema(implementation = VeiculoPoiDTO.class)))}), 
		        @ApiResponse(responseCode = "404", description = "Não Encontrado - Não foram encontrados dados com os parâmetros de entrada fornecidos.", content = @Content),
		        @ApiResponse(responseCode = "500", description = "Erro Interno do Servidor", content = @Content)
		})
		@GetMapping("/veiculos/{placa}/relatorio-pois")
		@ResponseBody
		@Override
	    public ResponseEntity<ArrayList<VeiculoPoiDTO>> listarTempoVeiculoPOI(
	    		@RequestParam(name = "nomePoi", required = false) @Parameter(name = "nomePoi", description = "Nome do POI desejado", example = "PONTO 1", in = ParameterIn.QUERY) String nomePoi, 
	    		@RequestParam(name = "data", required = false) @Parameter(name = "data", description = "Data para a pesquisa", example = "Mon Dec 31 2018 00:06:03 GMT-0200 (Hora oficial do Brasil)", in = ParameterIn.QUERY) String data,
	    		@PathVariable(name = "placa", required = true) @Parameter(name = "placa", description = "Placa do veículo para a pesquisa", example = "TESTE001", in = ParameterIn.PATH, required = true) String placa
	    ) {
			Filtro filtro = new Filtro();
			filtro.setNome(nomePoi);
			filtro.setData(data);
			filtro.setPlaca(placa);
			filtro.setNumeroPagina(0);
			filtro.setTamanhoPagina(1000000);
			
			ArrayList<VeiculoPoiDTO> listaVeiculoPoiDTO = veiculoService.listarTempoVeiculoPOI(filtro);
			
	        return new ResponseEntity<ArrayList<VeiculoPoiDTO>>(listaVeiculoPoiDTO, HttpStatus.OK);
	    }
}

