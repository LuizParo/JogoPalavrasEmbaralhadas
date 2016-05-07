package com.coursera.jogo.core;

public enum EstadoDaPartida {
	VENCEDOR("Você venceu!"), PERDEDOR("Você perdeu!"), JOGO_NAO_FINALIZADO("Jogo não finalizado!");
	
	private String mensagem;

	private EstadoDaPartida(String mensagem) {
		this.mensagem = mensagem;
	}
	
	@Override
	public String toString() {
		return this.mensagem;
	}
}