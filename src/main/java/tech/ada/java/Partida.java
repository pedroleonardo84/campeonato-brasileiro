package tech.ada.java;

import java.time.LocalDate;

@SuppressWarnings("preview")
public record Partida(Integer id, LocalDate data, String mandante, String visitante, String vencedor, Integer mandante_placar, Integer visitante_placar) {

}
