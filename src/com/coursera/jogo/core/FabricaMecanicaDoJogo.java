package com.coursera.jogo.core;

public final class FabricaMecanicaDoJogo {
	private FabricaMecanicaDoJogo() {}
	
	public static MecanicaDoJogo newJogo(TipoJogo tipoJogo, BancoDePalavras bancoDePalavras, int limiteDePontos) {
		MecanicaDoJogo jogo = tipoJogo.getJogo();
		jogo.setBancoDePalavras(bancoDePalavras);
		jogo.setLimiteDePontos(limiteDePontos);
		
		return jogo;
	}
}