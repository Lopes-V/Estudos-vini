package Dates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
// Importa a classe TemporalAdjusters, que fornece um conjunto de ajustadores de data úteis e pré-definidos.
// Eles são usados com o método .with() para manipular datas de forma declarativa e legível.
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusters01 {
    public static void main(String[] args) {
        // Obtém a data atual. Para os exemplos, vamos assumir que hoje é 24 de Setembro de 2025 (uma QUARTA-FEIRA).
        LocalDate now = LocalDate.now();

        // Usando o método .with() para fazer um ajuste simples: muda o dia do mês para 5.
        // Note que LocalDate é imutável. O método .with() retorna uma nova instância com a data alterada.
        now = now.with(ChronoField.DAY_OF_MONTH, 5);
        System.out.println(now); // Saída: 2025-09-05

        // ---- Usando TemporalAdjusters ----
        // Cada exemplo abaixo reseta a data para o dia atual antes de aplicar o ajustador.

        // Reseta a data para o dia atual para o próximo exemplo.
        now = LocalDate.now();
        // Ajusta a data para a próxima QUARTA-FEIRA ou para hoje, se hoje já for uma.
        // Como hoje (24/09/2025) é uma QUARTA-FEIRA, a data não muda.
        now = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY));
        System.out.println(now); // Saída: 2025-09-24

        // Reseta a data.
        now = LocalDate.now();
        // Ajusta a data para o próximo DOMINGO, estritamente após a data atual.
        // O próximo domingo após 24/09 é 28/09.
        now = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(now); // Saída: 2025-09-28

        // Reseta a data.
        now = LocalDate.now();
        // Ajusta a data para o DOMINGO anterior.
        // O domingo anterior a 24/09 é 21/09.
        now = now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
        System.out.println(now); // Saída: 2025-09-21

        // Reseta a data.
        now = LocalDate.now();
        // Ajusta para o primeiro dia do mês atual.
        now = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(now); // Saída: 2025-09-01
        System.out.println(now.getDayOfWeek()); // Saída: MONDAY

        // Reseta a data.
        now = LocalDate.now();
        // Ajusta para o primeiro dia do próximo mês.
        now = now.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(now); // Saída: 2025-10-01
        System.out.println(now.getDayOfWeek()); // Saída: WEDNESDAY

        // Reseta a data.
        now = LocalDate.now();
        // Ajusta para o último dia do mês atual.
        // Setembro tem 30 dias.
        now = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(now); // Saída: 2025-09-30
        System.out.println(now.getDayOfWeek()); // Saída: TUESDAY

        // Reseta a data.
        now = LocalDate.now();
        // Ajusta para o último dia do ano atual.
        now = now.with(TemporalAdjusters.lastDayOfYear());
        System.out.println(now); // Saída: 2025-12-31
        System.out.println(now.getDayOfWeek()); // Saída: WEDNESDAY
    }
}