package Dates;

import java.time.LocalDateTime;
import java.time.Month;
// Importa a enumeração ChronoUnit, que define um conjunto padrão de unidades de data e hora (dias, meses, anos, etc.).
// É uma forma versátil de calcular a distância entre dois pontos no tempo em uma unidade específica.
import java.time.temporal.ChronoUnit;

public class ChronoUnit01 {
    // Método principal, o ponto de entrada para a execução do programa.
    public static void main(String[] args) {
        // Cria um objeto com uma data e hora específicas no passado: 6 de Outubro de 2008, 06:01:01.
        LocalDateTime ldt1 = LocalDateTime.of(2008, Month.OCTOBER, 6, 6, 1, 1);
        // Cria um objeto com a data e hora atuais do sistema.
        LocalDateTime now = LocalDateTime.now();

        // O método 'between' da enumeração ChronoUnit calcula o tempo total em uma unidade específica entre dois pontos no tempo.

        // Calcula a quantidade de ANOS completos entre a data passada e a data atual.
        System.out.println(ChronoUnit.YEARS.between(ldt1, now));
        // Calcula a quantidade de MESES completos entre as duas datas.
        System.out.println(ChronoUnit.MONTHS.between(ldt1, now));
        // Calcula o número total de DIAS entre as duas datas.
        System.out.println(ChronoUnit.DAYS.between(ldt1, now));
        // Calcula o número total de HORAS entre as duas datas e horas.
        System.out.println(ChronoUnit.HOURS.between(ldt1, now));
        // Calcula o número total de MINUTOS entre as duas datas e horas.
        System.out.println(ChronoUnit.MINUTES.between(ldt1, now));
        // Calcula o número total de SEGUNDOS entre as duas datas e horas.
        System.out.println(ChronoUnit.SECONDS.between(ldt1, now));
    }
}