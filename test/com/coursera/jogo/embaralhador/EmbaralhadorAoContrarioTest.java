package com.coursera.jogo.embaralhador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class EmbaralhadorAoContrarioTest {
	private Embaralhador embaralhador;

	@Before
	public void setUp() {
		this.embaralhador = TipoEmbaralhador.INVERSO.getEmbaralhador();
	}

	@Test
	public void deveEmbaralharStringAoContrario() {
		String palavra = "FILET";
		assertEquals("TELIF", embaralhador.embaralhar(palavra));
	}
}