package com.api.core.appl.poi.repository.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.api.core.appl.poi.Poi;
import com.api.core.appl.poi.repository.spec.PoiRepository;
import com.api.core.appl.poi.repository.spec.PoiRepositoryData;
import com.api.core.appl.util.Filtro;

@Repository
public class PoiRepositoryImpl implements PoiRepository{
	
	private final PoiRepositoryData poiRepositoryData;
	
	public PoiRepositoryImpl(PoiRepositoryData poiRepositoryData) {
		super();
		this.poiRepositoryData = poiRepositoryData;
	}


	@Override
	public Page<Poi> listarPoi(Filtro filtro) {
		Pageable pageable = PageRequest.of(filtro.getNumeroPagina(), filtro.getTamanhoPagina());
		return poiRepositoryData.findAll(pageable);
	}


	@Override
	public Poi inserirPoi(Poi poi) {
		return poiRepositoryData.save(poi);
	}

}
