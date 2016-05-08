package com.coursera.jogo.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.coursera.jogo.embaralhador.Embaralhador;

public class JogoPorTodasAsPalavrasTest {
	
	private MecanicaDoJogo jogo;
	private BancoDePalavras bancoDePalavras;

	@Before
	public void setUp() {
		// Cria um mock de BancoDePalavras.
		this.bancoDePalavras = Mockito.mock(BancoDePalavras.class);
		Mockito.when(this.bancoDePalavras.recuperaPalavraAleatoria()).thenReturn("brasil");
		
		// Cria um mock de Embaralhador.
		Embaralhador embaralhador = Mockito.mock(Embaralhador.class);
		Mockito.when(embaralhador.embaralhar("brasil")).thenReturn("rbsali");
		
		this.jogo = FabricaMecanicaDoJogo.newJogo(TipoJogo.TODAS_PALAVRAS, this.bancoDePalavras, 20);
		this.jogo.setEmbaralhador(embaralhador);
	}
	
	@Test
	public void deveMarcarComoVencedorAoAcertarTodasAsTentativas() {
		Mockito.when(this.bancoDePalavras.quantidadeDePalavrasEncontradas()).thenReturn(1);
		while(!this.jogo.isJogoEncerrado()) {
			this.jogo.recuperaPalavraEmbaralhada();
			this.jogo.computaTentativa("brasil");
			Mockito.when(this.bancoDePalavras.quantidadeDePalavrasEncontradas()).thenReturn(0);
		}
		assertEquals(EstadoDaPartida.VENCEDOR, this.jogo.resultado());
	}
	
	@Test
	public void deveMarcarComoPerdedTodasAsTentativas() {
		Mockito.when(this.bancoDePalavras.quantidadeDePalavrasEncontradas()).thenReturn(1);
		while(!this.jogo.isJogoEncerrado()) {
			this.jogo.recuperaPalavraEmbaralhada();
			this.jogo.computaTentativa("abc");
			Mockito.when(this.bancoDePalavras.quantidadeDePalavrasEncontradas()).thenReturn(0);
		}
		assertEquals(EstadoDaPartida.PERDEDOR, this.jogo.resultado());
	}
}