package com.api.core.appl.poi.service.spec;

import java.util.ArrayList;

import com.api.core.appl.poi.PoiDTO;
import com.api.core.appl.util.Filtro;

public interface PoiService {

	ArrayList<PoiDTO> listarPoi(Filtro filtro);

	PoiDTO inserirPoi(PoiDTO poiDTO);

}
