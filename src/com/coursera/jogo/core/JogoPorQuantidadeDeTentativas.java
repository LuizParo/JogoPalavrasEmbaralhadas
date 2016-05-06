package com.coursera.jogo.core;

import com.coursera.jogo.embaralhador.Embaralhador;

class JogoPorQuantidadeDeTentativas implements MecanicaDoJogo {
	private BancoDePalavras bancoDePalavras;
	private String palavraEmbaralhada;
	private int quantidadeDeAcertos;
	private int quantidadeDeErros;
	private Embaralhador embaralhador;
	private int limiteDePontos;
	
	public JogoPorQuantidadeDeTentativas(BancoDePalavras bancoDePalavras, Embaralhador embaralhador, int limiteDePontos) {
		this.bancoDePalavras = bancoDePalavras;
		this.embaralhador = embaralhador;
		this.limiteDePontos = limiteDePontos;
	}

	@Override
	public boolean isJogoEncerrado() {
		return this.quantidadeDeErros == this.limiteDePontos || this.quantidadeDeAcertos == this.limiteDePontos;
	}

	@Override
	public int pontuacaoFinalDoJogador() {
		return quantidadeDeAcertos;
	}

	@Override
	public void computaTentativa(String palavra) {
		if(this.palavraEmbaralhada.equals(this.embaralhador.embaralhar(palavra))) {
			this.quantidadeDeAcertos++;
		} else {
			this.quantidadeDeErros++;
		}
	}

	@Override
	public String recuperaPalavraEmbaralhada() {
		String palavraAleatoria = this.bancoDePalavras.recuperaPalavraAleatoria();
		this.palavraEmbaralhada = this.embaralhador.embaralhar(palavraAleatoria);
		return this.palavraEmbaralhada;
	}

	@Override
	public String resultado() {
		if(this.isJogoEncerrado()) {
			if(this.quantidadeDeAcertos == this.limiteDePontos) {
				return "Venceu!";
			}
			return "Perdeu!";
		}
		return "Jogo não finalizado!";
	}
}