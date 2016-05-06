package com.coursera.jogo.core;

public interface MecanicaDoJogo {
	public boolean isJogoEncerrado();
	public String recuperaPalavraEmbaralhada();
	public void computaTentativa(String palavra);
	public int pontuacaoFinalDoJogador();
	public String resultado();
}