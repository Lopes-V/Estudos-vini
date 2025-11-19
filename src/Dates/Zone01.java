package Dates;

// Importa as classes da API java.time relacionadas a fusos horários, offsets e cronologias alternativas.
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.JapaneseDate;
import java.util.Map;

public class Zone01 {
    public static void main(String[] args) {
        // ---- Trabalhando com ZoneId (Identificadores de Fuso Horário) ----

        // Obtém um mapa com os IDs curtos de fusos horários (ex: EST, PST) e seus nomes completos.
        Map<String, String> shorId = ZoneId.SHORT_IDS;
        System.out.println(shorId);

        // Imprime o fuso horário padrão do sistema onde o código está rodando (ex: America/Sao_Paulo).
        System.out.println(ZoneId.systemDefault());

        // Cria um objeto ZoneId para um fuso horário específico, neste caso, Tóquio.
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        System.out.println(tokyoZone);

        // ---- Combinando LocalDateTime com Zonas ----

        // Obtém a data e hora LOCAIS, SEM informação de fuso horário.
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now); // Ex: 2025-09-25T12:43:28

        // ATENÇÃO: Pega a data/hora local 'now' e anexa o fuso horário de Tóquio.
        // Isso NÃO converte o tempo, apenas interpreta o tempo local como se estivesse em Tóquio.
        ZonedDateTime zonedDateTime = now.atZone(tokyoZone);
        System.out.println(zonedDateTime); // Saída: 2025-09-25T12:43:28+09:00[Asia/Tokyo]

        // ---- Trabalhando com Instant (Ponto na Linha do Tempo UTC) ----

        // Obtém o 'Instant' atual, que é um ponto único na linha do tempo, sempre em UTC (Z).
        Instant nowInstant = Instant.now();
        System.out.println(nowInstant); // Saída: 2025-09-25T15:43:28Z (considerando -03:00 como fuso local)

        // Esta linha repete a operação anterior, usando a mesma variável 'now' (LocalDateTime).
        ZonedDateTime zonedDateTime2 = now.atZone(tokyoZone);
        System.out.println(zonedDateTime2);

        // ---- Trabalhando com ZoneOffset (Deslocamento Fixo de UTC) ----

        // Imprime o deslocamento mínimo de UTC (-18:00).
        System.out.println(ZoneOffset.MIN);
        // Imprime o deslocamento máximo de UTC (+18:00).
        System.out.println(ZoneOffset.MAX);

        // Cria um ZoneOffset para um deslocamento fixo de -4 horas (ex: Manaus).
        ZoneOffset offsetManaus = ZoneOffset.of("-04:00");
        // Pega a data/hora local 'now' e anexa o offset de Manaus.
        // Novamente, isso não converte, apenas associa o offset.
        OffsetDateTime offsetDateTime = now.atOffset(offsetManaus);
        System.out.println(offsetDateTime); // Saída: 2025-09-25T12:43:28-04:00

        // Outra forma de fazer a mesma coisa, usando o método estático 'of'.
        OffsetDateTime offsetDateTime2 = OffsetDateTime.of(now, offsetManaus);
        System.out.println(offsetDateTime2);

        // Pega o 'Instant' (que está em UTC) e CONVERTE para o offset de Manaus.
        // Se o Instant era 15:43Z, ele se torna 11:43 no fuso -04:00.
        OffsetDateTime offsetDateTime3 = nowInstant.atOffset(offsetManaus);
        System.out.println(offsetDateTime3);

        // ---- Trabalhando com Cronologias Alternativas ----

        // Converte a data atual do calendário ISO (padrão) para o calendário Japonês.
        JapaneseDate japaneseNow = JapaneseDate.from(LocalDate.now());
        System.out.println(japaneseNow); // Saída: Japanese Reiwa 7-09-25

        // Cria uma data no passado.
        LocalDate meijiEraLocalDate = LocalDate.of(1900, 2, 1);
        // Converte essa data para o calendário Japonês para ver a era correspondente.
        JapaneseDate meijiEra = JapaneseDate.from(meijiEraLocalDate);
        System.out.println(meijiEra); // Saída: Japanese Meiji 33-02-01
    }
}