package com.coursera.jogo.embaralhador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmbaralhadorAoContrarioTest {
	private Embaralhador embaralhador;

	@Before
	public void setUp() {
		this.embaralhador = FabricaEmbaralhadores.newEmbaralhador(TipoEmbaralhador.INVERSO);
	}

	@Test
	public void deveEmbaralharStringAoContrario() {
		String palavra = "FILET";
		assertEquals("TELIF", embaralhador.embaralhar(palavra));
	}
}