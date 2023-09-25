package com.api.core.appl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
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
			
			ArrayList<String> listaDataHoraZona = new ArrayList<String>();

			String file = "src/test/java/com/api/core/appl/datas.txt";
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String currentLine = "";
			while(currentLine != null) {
				currentLine = reader.readLine();
				if(currentLine != null) {
					listaDataHoraZona.add(currentLine);
				}
			}
			reader.close();

			DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive()
					.appendPattern("EEE MMM dd uuuu HH:mm:ss zXX (zzzz)").toFormatter(Locale.ENGLISH);

	
			int i = 1;
			for (String dataHoraZona : listaDataHoraZona) {
				//System.out.println(dataHoraZona);
				ZonedDateTime zonedDateTime = ZonedDateTime
						.parse(dataHoraZona.replace("(Hora oficial do Brasil)", "(Brasilia Time)"), formatter);
				long epochSecondPosicao = zonedDateTime.toEpochSecond();
				String timezonePosicao = zonedDateTime.getZone().getId();
				//if(i > 470+252+206 && i <= 470+252+206) {
				if(i > 722 && i <= 722+206) {
					System.out.println(epochSecondPosicao + "," + "\"" + timezonePosicao + "\"");
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha na transformação de datas");
		}

		return;
	}

}
