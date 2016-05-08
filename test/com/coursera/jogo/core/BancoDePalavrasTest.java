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
	public void deveCarregarPalavrasRandomicamente() {
		assertNotEquals(this.bancoDePalavras.recuperaPalavraAleatoria(), this.bancoDePalavras.recuperaPalavraAleatoria());
	}
	
	@Test
	public void deveExcluirPalavraJaLida() {
		int contador = 0;
		while(this.bancoDePalavras.quantidadeDePalavrasEncontradas() > 0) {
			this.bancoDePalavras.recuperaPalavraAleatoria();
			contador++;
		}
		assertEquals(20, contador);
		assertEquals(0, this.bancoDePalavras.quantidadeDePalavrasEncontradas());
	}
}