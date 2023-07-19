package tech.ada.java;

import java.util.HashMap;
import java.util.List;


public class VerficarPartidas {

	public HashMap<String , Integer> classificacaoHistorica(List<Partida> partidas){
		
		HashMap<String , Integer> classificaoGeral = new HashMap<>();
		
		int vitoria = 3;
		int empate = 1;
		
		for (Partida partida : partidas) {
			if (partida.vencedor().equals("-")) {
				classificaoGeral.putIfAbsent(partida.mandante(), empate);
				classificaoGeral.putIfAbsent(partida.visitante(), empate);
				classificaoGeral.computeIfPresent(partida.mandante(),
                        (key, val) -> val + empate);
				classificaoGeral.computeIfPresent(partida.visitante(),
                        (key, val) -> val + empate);
			} else {
				classificaoGeral.putIfAbsent(partida.vencedor(), vitoria);
				classificaoGeral.computeIfPresent(partida.vencedor(),
                        (key, val) -> val + vitoria);
			}
		}
		
		
		return classificaoGeral ;
	}
	
}
