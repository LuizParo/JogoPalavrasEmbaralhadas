package com.coursera.jogo.core;

public final class FabricaMecanicaDoJogo {
	private FabricaMecanicaDoJogo() {}
	
	public static MecanicaDoJogo newJogo(TipoJogo tipoJogo, BancoDePalavras bancoDePalavras, int limiteDePontos) {
		MecanicaDoJogo jogo = null;
		if(tipoJogo == TipoJogo.QUANTIDADE_TENTATIVAS) {
			jogo = new JogoPorQuantidadeDeAcertosOuErros(limiteDePontos);
		} else {
			jogo = new JogoPorTodasAsPalavras();
		}
		jogo.setBancoDePalavras(bancoDePalavras);
		
		return jogo;
	}
}