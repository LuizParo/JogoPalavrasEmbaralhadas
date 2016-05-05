package com.coursera.jogo.embaralhador;

public enum TipoEmbaralhador {
	INVERSO(new EmbaralhadorAoContrario()),
	PAR_POR_IMPAR(new EmbaralhadorParPorImpar());
	
	private Embaralhador embaralhador;
	
	private TipoEmbaralhador(Embaralhador embaralhador) {
		this.embaralhador = embaralhador;
	}
	
	Embaralhador getEmbaralhador() {
		return embaralhador;
	}
}