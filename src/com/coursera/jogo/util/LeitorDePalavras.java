package com.coursera.jogo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LeitorDePalavras {
	private String fileName;
	private List<String> palavrasEncontradas = new ArrayList<>(20);

	public LeitorDePalavras(String fileName) {
		this.fileName = fileName;
	}

	public void carregarNomes() throws IOException {
		try(FileInputStream inputStream = new FileInputStream(new File(this.fileName));
		    Scanner scanner = new Scanner(inputStream, Charset.forName("UTF-8").toString())) {
			this.palavrasEncontradas.clear();
			while(scanner.hasNext()) {
				this.palavrasEncontradas.add(scanner.next());
			}
		}
	}

	public List<String> getPalavrasEncontradas() {
		return Collections.unmodifiableList(this.palavrasEncontradas);
	}

	public boolean isPalavrasCarregadas() {
		return !this.palavrasEncontradas.isEmpty();
	}
}