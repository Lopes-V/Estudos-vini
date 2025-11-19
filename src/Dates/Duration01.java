package Dates;

// Importa a classe Duration, que é usada para medir uma quantidade de tempo em termos de segundos e nanossegundos.
// É ideal para calcular a diferença entre pontos no tempo (Instants, LocalTimes, etc.) de forma precisa.
import java.time.Duration;
// Importa a classe Instant, que representa um ponto específico na linha do tempo (timestamp).
import java.time.Instant;
// Importa a classe LocalDateTime, que representa data e hora.
import java.time.LocalDateTime;
// Importa a classe LocalTime, que representa apenas a hora.
import java.time.LocalTime;
// Importa a enumeração ChronoUnit, que define um conjunto padrão de unidades de data e hora (dias, horas, minutos...).
import java.time.temporal.ChronoUnit;

public class Duration01 {
    // Método principal, o ponto de entrada para a execução do programa.
    public static void main(String[] args) {
        // Cria um objeto com a data e hora atuais.
        LocalDateTime ldt1 = LocalDateTime.now();
        // Cria um segundo objeto com uma data e hora no futuro.
        LocalDateTime ldt2 = LocalDateTime.now().plusYears(2).plusMinutes(2);
        // Cria um objeto com o horário atual.
        LocalTime timeNow = LocalTime.now();
        // Cria um segundo objeto com um horário 7 minutos no futuro.
        LocalTime timeAfter = LocalTime.now().plusMinutes(7);

        // ---- Calculando a duração entre dois pontos no tempo com .between() ----

        // Calcula a duração entre as duas datas e horas. A classe Duration trabalha com base em segundos e nanossegundos.
        Duration dd1 = Duration.between(ldt1, ldt2);
        // Calcula a duração entre os dois horários.
        Duration dt1 = Duration.between(timeNow, timeAfter);
        // Calcula a duração entre dois Instants. Esta é a forma mais precisa, pois Instant representa um timestamp.
        Duration dt2 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000));

        // Imprime as durações. A saída é no formato padrão ISO-8601 (ex: PT2H3M4S).
        // "P" significa "Período" (Period), "T" é o designador que separa a parte de tempo.
        System.out.println(dd1);
        System.out.println(dt1);
        System.out.println(dt2);

        // ---- Criando durações específicas com métodos .of() ----

        // Cria uma duração de exatamente 10 dias. Note que a saída será em horas (PT240H).
        Duration dt3 = Duration.ofDays(10);
        System.out.println(dt3);

        // Cria uma duração de 3 minutos (PT3M).
        Duration dt4 = Duration.ofMinutes(3);
        System.out.println(dt4);

        // Cria uma duração de 20 segundos (PT20S).
        Duration dt5 = Duration.ofSeconds(20);
        System.out.println(dt5);

        // Cria uma duração de 25 milissegundos (PT0.025S).
        Duration dt6 = Duration.ofMillis(25);
        System.out.println(dt6);
        
        // Cria uma duração de 4 dias usando ChronoUnit, uma forma mais flexível. A saída será em horas (PT96H).
        Duration dt7 = Duration.of(4, ChronoUnit.DAYS);
        System.out.println(dt7);
    }
}