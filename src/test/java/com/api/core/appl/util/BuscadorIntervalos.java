package com.api.core.appl.util;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class BuscadorIntervalos {

	@Test
	void test() {
		
		try {
			double[] intervalos = FuncoesLib.calcularIntervalos(new BigDecimal("-25.56742701740896"),new BigDecimal("-51.47653363645077"), new BigDecimal("300.0").divide(new BigDecimal("1000.0")));
			//System.out.println(new BigDecimal("300.0").divide(new BigDecimal("1000.0")).doubleValue());
			
			System.out.println(intervalos[0]);
			System.out.println(intervalos[1]);
			System.out.println("\n");
			System.out.println(intervalos[2]);
			System.out.println(intervalos[3]);
			System.out.println(intervalos[4]);
			System.out.println(intervalos[5]);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Falha ao encontrar os intervalos");
		}
	}

}
