package Dates;

// Importa a classe LocalDate, que representa uma data (ano, mês, dia) sem fuso horário ou hora. É a classe principal para trabalhar com datas a partir do Java 8.
import java.time.LocalDate;
// Importa a enumeração Month, que define os meses do ano de forma mais legível e segura (JANUARY, FEBRUARY, etc.).
import java.time.Month;
// Importa a enumeração ChronoField, que fornece uma maneira genérica de acessar campos de uma data (como ANO, MÊS_DO_ANO, DIA_DO_MÊS).
import java.time.temporal.ChronoField;

public class LocalDate01 {
    // Método principal, o ponto de entrada para a execução do programa.
    public static void main(String[] args) {
        // Cria um objeto LocalDate para uma data específica: 28 de Janeiro de 2025, usando o método estático 'of'.
        LocalDate date = LocalDate.of(2025, Month.JANUARY, 28);
        // Cria um objeto LocalDate com a data atual do sistema em que o código está rodando, usando o método estático 'now'.
        LocalDate agora = LocalDate.now();

        // ---- Obtendo informações da data ----

        // Imprime o ano da variável 'date' (2025).
        System.out.println(date.getYear());
        // Imprime o mês como um objeto Enum (JANUARY).
        System.out.println(date.getMonth());
        // Imprime o valor numérico do mês (1).
        System.out.println(date.getMonthValue());
        // Imprime o dia da semana (TUESDAY).
        System.out.println(date.getDayOfWeek());
        // Imprime o dia do mês (28).
        System.out.println(date.getDayOfMonth());
        // Imprime o total de dias no mês da data (31 para Janeiro).
        System.out.println(date.lengthOfMonth());
        // Verifica e imprime se o ano é bissexto (false para 2025).
        System.out.println(date.isLeapYear());

        // ---- Formas alternativas de obter informações ----

        // Outra forma de obter o ano, usando a enumeração ChronoField. É mais genérico.
        System.out.println(date.get(ChronoField.YEAR));
        // Outra forma de obter o dia do mês.
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));

        // ---- Imprimindo objetos e constantes ----

        // Imprime o objeto de data completo no formato padrão ISO 8601 (AAAA-MM-DD).
        System.out.println(date); // Saída: 2025-01-28
        // Imprime a data atual do sistema.
        System.out.println(agora);
        // Imprime a data mínima suportada pela classe LocalDate (-999999999-01-01).
        System.out.println(LocalDate.MIN);
        // Imprime a data máxima suportada pela classe LocalDate (+999999999-12-31).
        System.out.println(LocalDate.MAX);

        // ---- Manipulando a data ----

        // Adiciona 4 semanas à data atual.
        // IMPORTANTE: Objetos LocalDate são imutáveis. O método 'plusWeeks' não altera o objeto 'agora'.
        // Em vez disso, ele retorna um NOVO objeto LocalDate com a data modificada.
        // Por isso, é necessário reatribuir o resultado à variável 'agora' para armazenar a alteração.
        agora = agora.plusWeeks(4);

        // Imprime a nova data (4 semanas no futuro).
        System.out.println(agora);
    }
}