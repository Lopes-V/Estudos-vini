package Dates;

// Importa a classe Instant, que representa um ponto específico e instantâneo na linha do tempo.
// É ideal para registrar timestamps e é sempre baseada no fuso horário UTC (Tempo Universal Coordenado).
import java.time.Instant;
// Importa a classe LocalDateTime para fins de comparação.
import java.time.LocalDateTime;

public class Instant01 {
    // Método principal, o ponto de entrada para a execução do programa.
    public static void main(String[] args) {
        // Cria um objeto Instant que representa o exato momento atual na linha do tempo universal (UTC).
        Instant now = Instant.now();

        // Imprime o Instant no formato ISO 8601 em UTC. Note o 'Z' no final, que significa "Zulu time" ou UTC.
        // Exemplo: 2025-09-23T16:37:31.123456789Z
        System.out.println(now);
        
        // Imprime a data e hora local do sistema (sem fuso horário) para mostrar a diferença.
        // Exemplo: 2025-09-23T13:37:31.123456789
        System.out.println(LocalDateTime.now());

        // Imprime o número de segundos que se passaram desde a "Época Unix" (01 de janeiro de 1970, 00:00:00 UTC).
        // Este é um valor muito comum para timestamps em sistemas de computação.
        System.out.println(now.getEpochSecond());

        // Imprime a fração de nanossegundos do segundo atual, para registrar momentos com altíssima precisão.
        System.out.println(now.getNano());

        // Cria um Instant que representa exatamente 3 segundos após a Época Unix.
        System.out.println(Instant.ofEpochSecond(3));

        // Cria um Instant 3 segundos após a Época, mais um ajuste de 1 bilhão de nanossegundos.
        // Como 1 bilhão de nanossegundos é igual a 1 segundo, o resultado final será um Instant de 4 segundos.
        System.out.println(Instant.ofEpochSecond(3, 1_000_000_000));

        // Cria um Instant 3 segundos após a Época, menos um ajuste de 1 bilhão de nanossegundos.
        // O resultado final será um Instant de 2 segundos.
        System.out.println(Instant.ofEpochSecond(3, -1_000_000_000));
    }
}