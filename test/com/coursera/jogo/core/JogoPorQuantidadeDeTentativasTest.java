package com.coursera.jogo.core;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.coursera.jogo.embaralhador.Embaralhador;

public class JogoPorQuantidadeDeTentativasTest {
	private MecanicaDoJogo jogo;

	@Before
	public void setUp() {
		BancoDePalavras bancoDePalavras = Mockito.mock(BancoDePalavras.class);
		Mockito.when(bancoDePalavras.recuperaPalavraAleatoria()).thenReturn("brasil");
		
		Embaralhador embaralhador = Mockito.mock(Embaralhador.class);
		Mockito.when(embaralhador.embaralhar("brasil")).thenReturn("rbsali");
		
		this.jogo = FabricaMecanicaDoJogo.newJogo(TipoJogo.QUANTIDADE_TENTATIVAS, bancoDePalavras, 5);
		this.jogo.setEmbaralhador(embaralhador);
	}

	@Test
	public void deveMarcarComoVencedorAoAcertarCincoTentativas() {
		while(!this.jogo.isJogoEncerrado()) {
			this.jogo.recuperaPalavraEmbaralhada();
			this.jogo.computaTentativa("brasil");
		}
		assertEquals(EstadoDaPartida.VENCEDOR, this.jogo.resultado());
	}
	
	@Test
	public void deveMarcarComoPerdedorAoErrarCincoTentativas() {
		while(!this.jogo.isJogoEncerrado()) {
			this.jogo.recuperaPalavraEmbaralhada();
			this.jogo.computaTentativa("abc");
		}
		assertEquals(EstadoDaPartida.PERDEDOR, this.jogo.resultado());
	}
}