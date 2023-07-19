package tech.ada.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarregarPartidas {
	private static String filePath = "src/main/resources/campeonato-brasileiro-full.csv";
	
	public List<Partida> carregarPartidas(){
		
		List<Partida> partidas = new ArrayList<>();
		
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine(); 

            String linha;
            while ((linha = br.readLine()) != null) {
            	
            	//0 : "ID"
            	//2 : "data"
            	//3 : "mandante",
            	//4 : "visitante",
            	//9 : "vencedor",
            	//11: "mandante_Placar"
            	//12: "visitante_Placar"
            	
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0].trim());
	            String[] dataFormatada = dados[2].split("/");
	                int ano = Integer.parseInt(dataFormatada[2]);
	                int mes = Integer.parseInt(dataFormatada[1]);
	                int dia = Integer.parseInt(dataFormatada[0]);
                LocalDate data = LocalDate.of(ano, mes, dia);
                String mandante = dados[4].trim();
                String visitante = dados[5].trim();
                String vencedor = dados[10].trim();
                int mandante_placar = Integer.parseInt(dados[12].trim());
                int visitante_placar = Integer.parseInt(dados[13].trim());

                Partida partida = new Partida(id, data, mandante, visitante, vencedor, mandante_placar, visitante_placar);
                partidas.add(partida);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return partidas;
	}
}
