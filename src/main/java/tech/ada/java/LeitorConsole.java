package tech.ada.java;

import java.util.Locale;
import java.util.Scanner;

public class LeitorConsole implements AutoCloseable {

	private Scanner leitor;
	
	
	public LeitorConsole() {
		leitor = new Scanner(System.in);
		leitor.useLocale(Locale.US);
	}
	
    public String obterEntrada(){
        return leitor.nextLine();
    }

    public Integer obterEntradaAsInt(){
        Integer retorno = leitor.nextInt();
        leitor.nextLine();
        return retorno;
    }
	
	
	public void close(){
		leitor.close();

	}

}
