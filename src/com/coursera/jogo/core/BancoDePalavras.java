package com.coursera.jogo.core;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import com.coursera.jogo.util.LeitorDePalavras;

public class BancoDePalavras {
	private ThreadLocalRandom random;
	private LeitorDePalavras leitor;
	
	public BancoDePalavras(LeitorDePalavras leitor) throws IOException {
		this.random = ThreadLocalRandom.current();
		this.leitor = leitor;
		this.leitor.carregarNomes();
	}
	
	public String recuperaPalavraAleatoria() {
		int indice = this.random.nextInt(0, this.quantidadeDePalavrasEncontradas());
		if(this.leitor.isPalavrasCarregadas()) {
			return this.leitor.getPalavrasEncontradas().get(indice);
		}
		return "";
	}
	
	public int quantidadeDePalavrasEncontradas() {
		return this.leitor.getPalavrasEncontradas().size();
	}
}