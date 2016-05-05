package com.coursera.jogo.embaralhador;

public final class FabricaEmbaralhadores {
	private FabricaEmbaralhadores() {}
	
	public static Embaralhador newEmbaralhador(TipoEmbaralhador tipoEmbaralhador) {
		return tipoEmbaralhador.getEmbaralhador();
	}
}