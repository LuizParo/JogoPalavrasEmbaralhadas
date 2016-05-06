package com.coursera.jogo.embaralhador;

import java.util.concurrent.ThreadLocalRandom;

public final class FabricaEmbaralhadores {
	private static TipoEmbaralhador[] embaralhadores = TipoEmbaralhador.values();

	private FabricaEmbaralhadores() {}
	
	public static Embaralhador newEmbaralhador() {
		int index = ThreadLocalRandom.current().nextInt(0, embaralhadores.length);
		
		return embaralhadores[index].getEmbaralhador();
	}
}