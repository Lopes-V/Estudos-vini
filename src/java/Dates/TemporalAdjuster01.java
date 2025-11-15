package Dates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
// A interface TemporalAdjuster permite criar uma lógica personalizada para ajustar um objeto de data/hora.
import java.time.temporal.TemporalAdjuster;

// Esta classe implementa a interface TemporalAdjuster para criar uma regra de negócio específica:
// encontrar o próximo dia útil (considerando apenas sábado e domingo como não úteis).
class obterProximoDiaUtil implements TemporalAdjuster {

    // Sobrescreve o método obrigatório da interface TemporalAdjuster.
    @Override
    // Este método recebe um objeto temporal (como um LocalDate) e retorna um novo objeto temporal com a data ajustada.
    public Temporal adjustInto(Temporal temporal) {
        // Obtém o dia da semana da data de entrada (ex: THURSDAY).
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        // Inicializa a variável que definirá quantos dias serão adicionados.
        int addDays = 1;
        // Analisa o dia da semana para decidir a ação.
        switch (dayOfWeek) {
            // Se for SEXTA-FEIRA, adiciona 3 dias para pular o Sábado e o Domingo, resultando em Segunda-feira.
            case FRIDAY:
                addDays = 3;
                break;
            // Se for SÁBADO, adiciona 2 dias para pular o Domingo, resultando em Segunda-feira.
            case SATURDAY:
                addDays = 2;
                break;
            // Para qualquer outro dia (Segunda, Terça, Quarta, Quinta), adiciona apenas 1 dia.
            default:
                addDays = 1;
                break;
        }

        // Retorna um novo objeto temporal com a quantidade de dias calculada adicionada.
        // A imutabilidade é mantida; o objeto 'temporal' original não é modificado.
        return temporal.plus(addDays, ChronoUnit.DAYS);
    }
}

// Classe principal para demonstrar o uso do TemporalAdjuster personalizado.
public class TemporalAdjuster01 {
    public static void main(String[] args) {
        // Obtém a data atual. Para os exemplos, vamos assumir que hoje é 25 de Setembro de 2025.
        LocalDate now = LocalDate.now();
        System.out.println(now); // Saída: 2025-09-25
        System.out.println(now.getDayOfWeek()); // Saída: THURSDAY

        // ---- Testando o TemporalAdjuster personalizado ----

        // Aplica nosso ajustador personalizado à data atual.
        // Como hoje é QUINTA-FEIRA (THURSDAY), a regra 'default' é aplicada e 1 dia é adicionado.
        now = LocalDate.now().with(new obterProximoDiaUtil());
        System.out.println(now); // Saída: 2025-09-26
        System.out.println(now.getDayOfWeek()); // Saída: FRIDAY

        // ---- Testando para uma SEXTA-FEIRA ----

        // Força a data para 26/09/2025 (uma SEXTA-FEIRA) e aplica o ajustador.
        // A regra para 'FRIDAY' no nosso ajustador adiciona 3 dias.
        now = LocalDate.now().withDayOfMonth(26).with(new obterProximoDiaUtil());
        System.out.println(now); // Saída: 2025-09-29
        System.out.println(now.getDayOfWeek()); // Saída: MONDAY

        // ---- Testando para um SÁBADO ----

        // Força a data para 27/09/2025 (um SÁBADO) e aplica o ajustador.
        // A regra para 'SATURDAY' no nosso ajustador adiciona 2 dias.
        now = LocalDate.now().withDayOfMonth(27).with(new obterProximoDiaUtil());
        System.out.println(now); // Saída: 2025-09-29
        System.out.println(now.getDayOfWeek()); // Saída: MONDAY
    }
}