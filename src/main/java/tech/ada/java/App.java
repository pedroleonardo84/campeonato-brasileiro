package tech.ada.java;

public class App {
    public static void main(String[] args) {

        try(LeitorConsole leitor = new LeitorConsole()) {
            new Console(leitor).processar();
        }

    }
}
