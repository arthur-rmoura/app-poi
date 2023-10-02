package com.api.core.appl.util;

import java.math.BigDecimal;

public class FuncoesLib {
	
	private static final double EARTH_RADIUS = 6371; //6373 -> Valor para aumentar a precisão;
	
	public static double calculateEquirectangularDistance(double lat1, double lon1, double lat2, double lon2) {
	    double lat1Rad = Math.toRadians(lat1);
	    double lat2Rad = Math.toRadians(lat2);
	    double lon1Rad = Math.toRadians(lon1);
	    double lon2Rad = Math.toRadians(lon2);

	    double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
	    double y = (lat2Rad - lat1Rad);
	    double distance = Math.sqrt(x * x + y * y) * EARTH_RADIUS;

	    return distance;
	}

	public static double calcularDistancia(double[] latlong) {
		return calculateEquirectangularDistance(latlong[0],latlong[1],latlong[2],latlong[3]);
	}
	
	public static double calcularDistancia(BigDecimal latitude, BigDecimal longitude, BigDecimal latitudeCentro, BigDecimal longitudeCentro) {
		return calculateEquirectangularDistance(latitude.doubleValue(),longitude.doubleValue(),latitudeCentro.doubleValue(),longitudeCentro.doubleValue());
	}
			
	public static double[] calcularIntervalos(BigDecimal latitude, BigDecimal longitude, BigDecimal raio) {
		double minLat=latitude.doubleValue();;
		double maxLat=latitude.doubleValue();;
		double minLong=longitude.doubleValue();
		double maxLong=longitude.doubleValue();
		
		double centroLat = latitude.doubleValue();
		double centroLong = longitude.doubleValue();
		
		double distancia=0.0d;
		double variacao=0.0000005d; //Para aumentar a precisão basta dividir por 10
		
		distancia=0.0d;
		while(distancia < raio.doubleValue()) {
			maxLat = maxLat + variacao;
			distancia = calculateEquirectangularDistance(centroLat, centroLong, maxLat, centroLong);
		}
		
		distancia=0.0d;
		while(distancia < raio.doubleValue()) {
			minLat = minLat - variacao;
			distancia = calculateEquirectangularDistance(centroLat, centroLong, minLat, centroLong);
		}
		
		distancia=0.0d;
		while(distancia < raio.doubleValue()) {
			maxLong = maxLong + variacao;
			distancia = calculateEquirectangularDistance(centroLat, centroLong, centroLat, maxLong);
		}
		
		distancia=0.0d;
		while(distancia < raio.doubleValue()) {
			minLong = minLong - variacao;
			distancia = calculateEquirectangularDistance(centroLat, centroLong, centroLat, minLong);
		}
		
		double[] intervaloFinal = {minLat, maxLat, minLong, maxLong}; 
		return intervaloFinal;
	}
	
	public static String secondsToTime(Long totalSeconds) {
		
		long hours = totalSeconds / 3600;
		long minutes = (totalSeconds % 3600) / 60;
		long seconds = totalSeconds % 60;
		
		return String.format("%02dh %02dm %02ds", hours, minutes, seconds);
	}

}
