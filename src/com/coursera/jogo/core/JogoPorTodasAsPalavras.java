package com.coursera.jogo.core;

import com.coursera.jogo.embaralhador.Embaralhador;

class JogoPorTodasAsPalavras implements MecanicaDoJogo {
	private BancoDePalavras bancoDePalavras;
	private Embaralhador embaralhador;
	private String palavraEmbaralhada;
	private int quantidadeDeAcertos;
	private int quantidadeDeErros;

	@Override
	public boolean isJogoEncerrado() {
		return this.bancoDePalavras.quantidadeDePalavrasEncontradas() <= 0;
	}

	@Override
	public String recuperaPalavraEmbaralhada() {
		this.verificaSeEmbaralhadorFoiDefinido();
		String palavraAleatoria = this.bancoDePalavras.recuperaPalavraAleatoria();
		this.palavraEmbaralhada = this.embaralhador.embaralhar(palavraAleatoria);
		return this.palavraEmbaralhada;
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
	public int quantidadeAcertos() {
		return this.quantidadeDeAcertos;
	}

	@Override
	public int quantidadeErros() {
		return this.quantidadeDeErros;
	}

	@Override
	public EstadoDaPartida resultado() {
		if(this.isJogoEncerrado()) {
			if(this.quantidadeDeAcertos >= this.quantidadeDeErros) {
				return EstadoDaPartida.VENCEDOR;
			}
			return EstadoDaPartida.PERDEDOR;
		}
		return EstadoDaPartida.JOGO_NAO_FINALIZADO;
	}

	@Override
	public void setBancoDePalavras(BancoDePalavras bancoDePalavras) {
		this.bancoDePalavras = bancoDePalavras;
	}

	@Override
	public void setEmbaralhador(Embaralhador embaralhador) {
		this.embaralhador = embaralhador;
	}
	
	private void verificaSeEmbaralhadorFoiDefinido() {
		if(this.embaralhador == null) {
			throw new IllegalStateException("O embaralhador ainda não foi definido para esta rodada!");
		}
	}
}