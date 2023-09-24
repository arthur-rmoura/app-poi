package com.api.core.appl.poi.controller.spec;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.api.core.appl.poi.PoiDTO;

public interface PoiController  {
	

	ResponseEntity<ArrayList<PoiDTO>> listarPoi(Integer numeroPagina, Integer tamanhoPagina, String nomePoi, BigDecimal raioPoi);

	ResponseEntity<PoiDTO> inserirPoi(PoiDTO poiDTO);

}
