package com.coursera.jogo.core;

public enum TipoJogo {
	QUANTIDADE_TENTATIVAS("Por quantidade de acertos ou erros."),
	TODAS_PALAVRAS("Por quantidade de acertos utilizando todas as palavras.");
	
	private String descricaoDoJogo;

	private TipoJogo(String descricaoDoJogo) {
		this.descricaoDoJogo = descricaoDoJogo;
	}
	
	public String getDescricaoDoJogo() {
		return descricaoDoJogo;
	}
}