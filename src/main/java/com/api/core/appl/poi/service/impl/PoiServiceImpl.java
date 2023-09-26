package com.api.core.appl.poi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.api.core.appl.poi.Poi;
import com.api.core.appl.poi.PoiDTO;
import com.api.core.appl.poi.repository.spec.PoiRepository;
import com.api.core.appl.poi.service.spec.PoiService;
import com.api.core.appl.util.Filtro;

@Service
public class PoiServiceImpl implements PoiService {

	@Autowired
	PoiRepository poiRepository;

	@Override
	public ArrayList<PoiDTO> listarPoi(Filtro filtro) {
		
		Page<Poi> paginaPoi;
		
		if(filtro.getNome() != null && filtro.getRaio() != null) {
			paginaPoi = poiRepository.listarPoiPorNomeRaio(filtro);
		}
		else if(filtro.getNome() != null) {
			paginaPoi = poiRepository.listarPoiPorNome(filtro);
		}	
		else if(filtro.getRaio() != null) {
			paginaPoi = poiRepository.listarPoiPorRaio(filtro);
		}
		else {
			paginaPoi = poiRepository.listarPoi(filtro);
		}
		
		List<Poi> listaPoi = paginaPoi.getContent();
		
		ArrayList<PoiDTO> listaPoiDTO = new ArrayList<>();
		
		for(Poi poi : listaPoi) {
			PoiDTO poiDTO = new PoiDTO(poi.getNome(), poi.getRaio(), poi.getLatitude(), poi.getLongitude());
			listaPoiDTO.add(poiDTO);
		}

		return listaPoiDTO;

	}

	@Override
	public PoiDTO inserirPoi(PoiDTO poiDTO) {

		Poi poi = new Poi(poiDTO.getNome(), poiDTO.getRaio(), poiDTO.getLatitude(), poiDTO.getLongitude());

		poiRepository.inserirPoi(poi);

		return poiDTO;
	}

}

