package com.coursera.jogo.core;

import com.coursera.jogo.embaralhador.Embaralhador;

class JogoPorQuantidadeDeTentativas implements MecanicaDoJogo {
	private BancoDePalavras bancoDePalavras;
	private String palavraEmbaralhada;
	private int quantidadeDeAcertos;
	private int quantidadeDeErros;
	private Embaralhador embaralhador;
	private int limiteDePontos;
	
	@Override
	public void setBancoDePalavras(BancoDePalavras bancoDePalavras) {
		this.bancoDePalavras = bancoDePalavras;
	}
	
	@Override
	public void setEmbaralhador(Embaralhador embaralhador) {
		this.embaralhador = embaralhador;
	}
	
	@Override
	public void setLimiteDePontos(int limiteDePontos) {
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
	public EstadoDaPartida resultado() {
		if(this.isJogoEncerrado()) {
			if(this.quantidadeDeAcertos == this.limiteDePontos) {
				return EstadoDaPartida.VENCEDOR;
			}
			return EstadoDaPartida.PERDEDOR;
		}
		return EstadoDaPartida.JOGO_NAO_FINALIZADO;
	}
}