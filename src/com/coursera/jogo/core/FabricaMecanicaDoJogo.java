package com.coursera.jogo.core;

import com.coursera.jogo.embaralhador.Embaralhador;

public final class FabricaMecanicaDoJogo {
	private FabricaMecanicaDoJogo() {}
	
	public static MecanicaDoJogo newJogo(TipoJogo tipoJogo, BancoDePalavras bancoDePalavras, Embaralhador embaralhador, int limiteDePontos) {
		MecanicaDoJogo jogo = tipoJogo.getJogo();
		jogo.setBancoDePalavras(bancoDePalavras);
		jogo.setEmbaralhador(embaralhador);
		jogo.setLimiteDePontos(limiteDePontos);
		
		return jogo;
	}
}