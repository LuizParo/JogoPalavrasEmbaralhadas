package com.coursera.jogo.core;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.coursera.jogo.util.LeitorDePalavras;

public class BancoDePalavrasTest {
	private BancoDePalavras bancoDePalavras;

	@Before
	public void setUp() throws IOException {
		this.bancoDePalavras = new BancoDePalavras(new LeitorDePalavras("palavras.txt"));
	}

	@Test
	public void deveCarregarArquivoCom20Nomes() throws IOException {
		assertEquals(20, this.bancoDePalavras.quantidadeDePalavrasEncontradas());
	}
	
	@Test
	public void deveCarregarArquivoRandomicamente() {
		assertNotEquals("", this.bancoDePalavras.recuperaPalavraAleatoria());
		assertNotEquals("", this.bancoDePalavras.recuperaPalavraAleatoria());
	}
}