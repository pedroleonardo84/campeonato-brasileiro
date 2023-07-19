package tech.ada.java;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Console {
	
	  List<Partida> partidas = new ArrayList<>();
	  HashMap<String, Integer> classificacao = new HashMap<>();
	
	 	private final LeitorConsole leitor;
	    private final String DIGITE_OPCAO_DESEJADA = "Digite a opção desejada: ";

	    private final String CARREGAR_PARTIDAS = "1";
	    private final String CLASSIFICACAO_HISTORICA= "2";
	    private final String OPCAO_SAIR = "x";
	    
	    public Console(LeitorConsole leitor) {
	    	this.leitor = leitor;
	    	iniciaApp();
	    }

		private void iniciaApp() {
			carregaNomeApp();
		}

		private void carregaNomeApp() {
	        System.out.println("*************************************************");
	        System.out.println("********* CAMPEONATO BRASILEIRO SERIE A *********");
	        System.out.println("*************************************************");
			
		}
		
	    private void carregaMenu() {
	        System.out.println("********  DIGITE A OPÇÃO DESEJADA   ******");
	        System.out.println("1 - CARREGAR PARTIDAS");
	        System.out.println("2 - CLASSIFICACAO HISTORICA");
	        System.out.println("X - SAIR");
	    }

		public void processar() {
	    
			String opcaoDigitada = obterEntradaDoUsuario(leitor);
		
		    while(!escolheuSair(opcaoDigitada)){
		        tratarOpcaoSelecionada(opcaoDigitada);
		        opcaoDigitada = obterEntradaDoUsuario(leitor);
		    }

		    finalizaApp();
	    
		}
		
		
	    private String obterEntradaDoUsuario(LeitorConsole leitor){
	        carregaMenu();
	        System.out.print(DIGITE_OPCAO_DESEJADA);
	        return leitor.obterEntrada().toLowerCase();
	    }
	    
	    private void tratarOpcaoSelecionada(String opcaoDigitada) {
	        switch (opcaoDigitada){
	            case OPCAO_SAIR:
	                break;
	            case CARREGAR_PARTIDAS:
	            	uploadPartidas();
	                System.out.println("Partidas carregadas com sucesso!");
	                pularLinha(2);
	                break;
	            case CLASSIFICACAO_HISTORICA:
	            	System.out.println("*** Na tabela abaixo a classificacão acumulada na era dos pontos corridos (2003 a 2022):");
	            	classificacaoHistorica();
	                pularLinha(2);
	                break;
	            default:
	                opcaoInvalida();
	                break;
	        }
	    }
	    
	    private void classificacaoHistorica() {
	    	classificacao = new VerficarPartidas().classificacaoHistorica(partidas);
	    	
	    	List<Entry<String, Integer>> lista = classificacao.entrySet().stream().collect(Collectors.toList());
	    	List<Pontuacao> listaOrdenada = new ArrayList<>();
	    	
	    	lista.sort(Entry.comparingByValue());
	    	
	    	for (Entry<String, Integer> item : lista) {
	    		Pontuacao pontuacao = new Pontuacao(item.getKey(), item.getValue());
	    		listaOrdenada.add(pontuacao);
	    	}
	    	
	    	listaOrdenada.sort(new PontosComparator().reversed());
	    	
	    	for(Pontuacao item : listaOrdenada) {
	    		System.out.println(item);
	    	}

		}

		private boolean escolheuSair(String opcaoDigitada){
	        return opcaoDigitada.equals(OPCAO_SAIR);
	    }

	    private void opcaoInvalida(){
	        System.out.println("Opção INVÁLIDA. Tente novamente.");
	    }
	    
	    public void pularLinha(int numeroDeLinhas){
	        for (int i = 1; i <= numeroDeLinhas; i++) {
	            System.out.println();
	        }
	    }
	    
	    private void finalizaApp(){
	        System.out.println("Até logo!!");
	    }
	    
	    
	    private void uploadPartidas(){
	        partidas = new CarregarPartidas().carregarPartidas();
	        
	        System.out.println(partidas.size());
	        
	        for (Partida p : partidas) {
	        	System.out.println(p);
	        }

	    }
}
