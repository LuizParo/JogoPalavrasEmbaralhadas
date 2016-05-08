package com.coursera.jogo.core;

import com.coursera.jogo.embaralhador.Embaralhador;

public interface MecanicaDoJogo {
	public boolean isJogoEncerrado();
	public String recuperaPalavraEmbaralhada();
	public boolean computaTentativa(String palavra);
	public int quantidadeAcertos();
	public int quantidadeErros();
	public EstadoDaPartida resultado();
	public void setBancoDePalavras(BancoDePalavras bancoDePalavras);
	public void setEmbaralhador(Embaralhador embaralhador);
}