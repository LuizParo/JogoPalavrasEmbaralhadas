package com.coursera.jogo.embaralhador;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

class EmbaralhadorParPorImparTest {
	private Embaralhador embaralhador;

	@Before
	public void setUp() {
		this.embaralhador = TipoEmbaralhador.PAR_POR_IMPAR.getEmbaralhador();
	}
	
	@Test
	public void deveEmbaralharPorIndicePalavraComQuantidadeDeCaracteresPar() {
		String palavra = "BRASIL";
		assertEquals("RBSALI", this.embaralhador.embaralhar(palavra));
	}
	
	@Test
	public void deveEmbaralharPorIndicePalavraComQuantidadeDeCaracteresImpar() {
		String palavra = "EGITO";
		assertEquals("GETIO", this.embaralhador.embaralhar(palavra));
	}
	
	@Test
	public void deveEmbaralharPorIndicePalavraComQuantidadeDeCaracteresIgualAUm() {
		String palavra = "J";
		assertEquals("J", this.embaralhador.embaralhar(palavra));
	}
}