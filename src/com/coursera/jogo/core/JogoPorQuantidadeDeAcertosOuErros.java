package com.coursera.jogo.core;

import com.coursera.jogo.embaralhador.Embaralhador;

class JogoPorQuantidadeDeAcertosOuErros implements MecanicaDoJogo {
	private BancoDePalavras bancoDePalavras;
	private String palavraEmbaralhada;
	private int quantidadeDeAcertos;
	private int quantidadeDeErros;
	private Embaralhador embaralhador;
	private int limiteDePontos;
	
	public JogoPorQuantidadeDeAcertosOuErros(int limiteDePontos) {
		this.limiteDePontos = limiteDePontos;
	}
	
	@Override
	public void setBancoDePalavras(BancoDePalavras bancoDePalavras) {
		this.bancoDePalavras = bancoDePalavras;
	}
	
	@Override
	public void setEmbaralhador(Embaralhador embaralhador) {
		this.embaralhador = embaralhador;
	}
	
	public void setLimiteDePontos(int limiteDePontos) {
		this.limiteDePontos = limiteDePontos;
	}

	@Override
	public boolean isJogoEncerrado() {
		return this.quantidadeDeErros == this.limiteDePontos || this.quantidadeDeAcertos == this.limiteDePontos;
	}

	@Override
	public int quantidadeAcertos() {
		return quantidadeDeAcertos;
	}
	
	@Override
	public int quantidadeErros() {
		return quantidadeDeErros;
	}

	@Override
	public boolean computaTentativa(String palavra) {
		this.verificaSeEmbaralhadorFoiDefinido();
		if(this.palavraEmbaralhada.equals(this.embaralhador.embaralhar(palavra))) {
			this.quantidadeDeAcertos++;
			return true;
		}
		this.quantidadeDeErros++;
		return false;
	}

	@Override
	public String recuperaPalavraEmbaralhada() {
		this.verificaSeEmbaralhadorFoiDefinido();
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
	
	private void verificaSeEmbaralhadorFoiDefinido() {
		if(this.embaralhador == null) {
			throw new IllegalStateException("O embaralhador ainda não foi definido para esta rodada!");
		}
	}
}