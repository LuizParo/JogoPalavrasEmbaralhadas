package com.coursera.jogo.embaralhador;

public class EmbaralhadorParPorImpar implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
		char[] palavraEmChars = palavra.toCharArray();
		char[] palavraEmbaralhadaEmChars = new char[palavraEmChars.length];
		
		for (int i = 0; i < palavraEmChars.length; i++) {
			if(i % 2 == 0) {
				if(i == palavraEmChars.length - 1) {
					palavraEmbaralhadaEmChars[i] = palavraEmChars[i];
				} else {
					palavraEmbaralhadaEmChars[i] = palavraEmChars[i + 1];
				}
			} else {
				palavraEmbaralhadaEmChars[i] = palavraEmChars[i - 1];
			}
		}
		return new String(palavraEmbaralhadaEmChars);
	}

	@Override
	public String dificuldade() {
		return "Fácil";
	}
}