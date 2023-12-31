package com.api.core.appl.poi.repository.spec;

import org.springframework.data.domain.Page;

import com.api.core.appl.poi.Poi;
import com.api.core.appl.util.Filtro;

public interface PoiRepository {

	Poi inserirPoi(Poi poi);

	Page<Poi> listarPoi(Filtro filtro);

	Page<Poi> listarPoiPorNome(Filtro filtro);

	Page<Poi> listarPoiPorRaio(Filtro filtro);

	Page<Poi> listarPoiPorNomeRaio(Filtro filtro);
}
