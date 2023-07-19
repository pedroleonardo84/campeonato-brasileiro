package tech.ada.java;

import java.util.Comparator;

public class PontosComparator implements Comparator<Pontuacao> {

	@Override
	public int compare(Pontuacao time1, Pontuacao time2) {
		return Integer.compare(time1.pontos(),time2.pontos());
	}
	
}
