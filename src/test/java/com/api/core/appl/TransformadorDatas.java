package com.api.core.appl;

import static org.junit.jupiter.api.Assertions.*;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class TransformadorDatas {

	@Test
	void test() {
		
		try {
			DateTimeFormatter formatter = new DateTimeFormatterBuilder()
				    .parseCaseInsensitive()
				    .appendPattern("EEE MMM dd uuuu HH:mm:ss zXX (zzzz)")
				    .toFormatter(Locale.ENGLISH);
			
			ArrayList<String> listaDataHoraZona = new ArrayList<String>();
			String aux = "Wed Dec 12 2018 00:04:03 GMT-0200 (Hora oficial do Brasil)";
			listaDataHoraZona.add(aux);
			
			for(String dataHoraZona : listaDataHoraZona) {
				ZonedDateTime zonedDateTime = ZonedDateTime.parse(dataHoraZona.replace("(Hora oficial do Brasil)", "(Brasilia Time)"), formatter);
				long timestampPosicao = zonedDateTime.toEpochSecond();
				String timezonePosicao = zonedDateTime.getZone().getId();
				
				System.out.println(timestampPosicao);
				System.out.println(timezonePosicao);
			}
		} catch (Exception e) {
			fail("Falha na transformação de datas");
		}
		
		return;
	}

}
