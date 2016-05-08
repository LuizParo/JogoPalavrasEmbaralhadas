package com.coursera.jogo;

import java.io.IOException;
import java.util.Scanner;

import com.coursera.jogo.core.BancoDePalavras;
import com.coursera.jogo.core.FabricaMecanicaDoJogo;
import com.coursera.jogo.core.MecanicaDoJogo;
import com.coursera.jogo.core.TipoJogo;
import com.coursera.jogo.embaralhador.FabricaEmbaralhadores;
import com.coursera.jogo.util.LeitorDePalavras;

public class Principal {

	public void iniciaJogo() {
		try {
			System.out.println("Bem vindo ao jogo de adivinhação de palavras!");
			System.out.println("Escolha um dos modos do jogo:");
			this.exibeJogosDisponiveis();
			
			try(Scanner scanner = new Scanner(System.in)) {
				BancoDePalavras bancoDePalavras = new BancoDePalavras(new LeitorDePalavras("palavras.txt"));
				
				TipoJogo modoDeJogo = this.jogo(scanner.nextInt());
				System.out.println("\nOpção escolhida: " + modoDeJogo);
			
				int limiteDePontos = 0;
				if(modoDeJogo == TipoJogo.QUANTIDADE_TENTATIVAS) {
					System.out.println("\nEscolha a quantidade de tentativas: ");
					limiteDePontos = scanner.nextInt();
				}
				
				MecanicaDoJogo jogo = FabricaMecanicaDoJogo.newJogo(modoDeJogo, bancoDePalavras, limiteDePontos);
				this.executaJogo(jogo, scanner);
			}
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage() + "\nComece de novo!");
			e.printStackTrace();
		}
	}

	public void executaJogo(MecanicaDoJogo jogo, Scanner scanner) {
		System.out.println("\n\nJogo iniciado!!");
		while(!jogo.isJogoEncerrado()) {
			System.out.println("\nQuantidade de acertos: " + jogo.quantidadeAcertos());
			System.out.println("Quantidade de erros: " + jogo.quantidadeErros());
			
			jogo.setEmbaralhador(FabricaEmbaralhadores.newEmbaralhador());
			System.out.println("\nPalavra embaralhada: " + jogo.recuperaPalavraEmbaralhada());
			System.out.println("\nQual é a palavra?");
			
			String tentativa = scanner.next();
			if(jogo.computaTentativa(tentativa)) {
				System.out.println("\nParabéns, você acertou!");
			} else {
				System.out.println("\nOps, você errou!");
			}
			this.pausaConsole();
		}
		System.out.println(jogo.resultado());
	}
	
	private void exibeJogosDisponiveis() {
		TipoJogo[] jogos = TipoJogo.values();
		for(int i = 1; i <= jogos.length; i++) {
			System.out.println(i + " -> " + jogos[i - 1].getDescricaoDoJogo());
		}
	}

	private TipoJogo jogo(int modoDeJogo) {
		TipoJogo[] tipoJogos = TipoJogo.values();
		if(modoDeJogo <= 0 || modoDeJogo > tipoJogos.length) {
			throw new IllegalArgumentException("Opção de jogo inválida!");
		}
		return tipoJogos[modoDeJogo - 1];
	}
	
	private void pausaConsole() {
		try {
			System.in.read();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public static void main(String[] args) {
		new Principal().iniciaJogo();
	}
}