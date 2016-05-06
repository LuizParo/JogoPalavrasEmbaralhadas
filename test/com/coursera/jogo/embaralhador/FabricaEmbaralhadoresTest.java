package com.coursera.jogo.embaralhador;

import static org.junit.Assert.*;

import org.junit.Test;

public class FabricaEmbaralhadoresTest {

	@Test
	public void deveRetornarEmbaralhadoresAleatoriamente() {
		assertNotNull(FabricaEmbaralhadores.newEmbaralhador());
		assertNotNull(FabricaEmbaralhadores.newEmbaralhador());
	}
}