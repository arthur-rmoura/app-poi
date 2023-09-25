package com.api.core.appl.util;

import java.math.BigDecimal;

public class FuncoesLib {
	
	private static final double EARTH_RADIUS = 6371;
	
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

	public static double[] calcularIntervalos(BigDecimal latitude, BigDecimal longitude, BigDecimal raio) {
		double minLat=latitude.doubleValue();;
		double maxLat=latitude.doubleValue();;
		double minLong=longitude.doubleValue();
		double maxLong=longitude.doubleValue();
		
		double centroLat = latitude.doubleValue();
		double centroLong = longitude.doubleValue();
		
		double distancia=0.0d;
		double variacao=0.00005d;
		
		while(distancia < raio.doubleValue()) {
			maxLat = maxLat + variacao;
			distancia = calculateEquirectangularDistance(centroLat, centroLong, maxLat, centroLong);
		}
		
		double[] intervaloFinal = {minLat, maxLat, minLong, maxLong}; 
		return intervaloFinal;
	}

}
