package com.coursera.jogo.embaralhador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmbaralhadorParPorImparTest {
	private Embaralhador embaralhador;

	@Before
	public void setUp() {
		this.embaralhador = FabricaEmbaralhadores.newEmbaralhador(TipoEmbaralhador.PAR_POR_IMPAR);
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