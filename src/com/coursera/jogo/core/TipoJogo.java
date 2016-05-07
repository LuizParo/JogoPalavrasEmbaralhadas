package com.coursera.jogo.core;

public enum TipoJogo {
	QUANTIDADE_TENTATIVAS(JogoPorQuantidadeDeTentativas.class);
	
	private Class<? extends MecanicaDoJogo> jogo;

	/**
	 * Como as classes que extendem {@code} MecanicaDoJogo} possuem estado (atributos),
	 * não é interessante que elas possuam uma única intância por enum, então ao invés
	 * do objeto do jogo ser armazenado no atributo {@link TipoJogo jogo} do enum,
	 * somente uma referência ao seu objeto {@code Class} será armazenado, para que a cada
	 * chamada de um jogo, uma nova instância deste seja criada.
	 * @param jogo
	 */
	private TipoJogo(Class<? extends MecanicaDoJogo> jogo) {
		this.jogo = jogo;
	}
	
	MecanicaDoJogo getJogo() {
		try {
			return this.jogo.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}