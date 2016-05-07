package com.coursera.jogo.core;

import com.coursera.jogo.embaralhador.Embaralhador;

public interface MecanicaDoJogo {
	public boolean isJogoEncerrado();
	public String recuperaPalavraEmbaralhada();
	public void computaTentativa(String palavra);
	public int pontuacaoFinalDoJogador();
	public EstadoDaPartida resultado();
	public void setBancoDePalavras(BancoDePalavras bancoDePalavras);
	public void setEmbaralhador(Embaralhador embaralhador);
	public void setLimiteDePontos(int limiteDePontos);
}