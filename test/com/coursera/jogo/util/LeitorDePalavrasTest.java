package com.coursera.jogo.util;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.coursera.jogo.util.LeitorDePalavras;

public class LeitorDePalavrasTest {
	private LeitorDePalavras leitor;

	@Before
	public void setUp() {
		this.leitor = new LeitorDePalavras("palavras.txt");
	}

	@Test
	public void deveCarregarPalavrasDeArquivo() throws IOException {
		this.leitor.carregarNomes();
		assertTrue(this.leitor.isPalavrasCarregadas());
		assertEquals(20, this.leitor.getPalavrasEncontradas().size());
	}
}