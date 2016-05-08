package com.coursera.jogo.core;

public enum TipoJogo {
	QUANTIDADE_TENTATIVAS("Por limite de acertos ou erro com 5 palavras."),
	TODAS_PALAVRAS("Por quantidade de acerto utilizando todas as palavras.");
	
	private String descricaoDoJogo;

	private TipoJogo(String descricaoDoJogo) {
		this.descricaoDoJogo = descricaoDoJogo;
	}
	
	public String getDescricaoDoJogo() {
		return descricaoDoJogo;
	}
}