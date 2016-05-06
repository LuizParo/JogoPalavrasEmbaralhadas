package com.coursera.jogo.embaralhador;

class EmbaralhadorAoContrario implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
		return new StringBuilder(palavra).reverse().toString();
	}

	@Override
	public String dificuldade() {
		return "Fácil";
	}
}