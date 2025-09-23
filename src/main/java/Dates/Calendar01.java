package Dates;

// Importa a classe Calendar, usada para manipular datas e horas.
import java.util.Calendar;
// Importa a classe legada Date, frequentemente usada para obter a saída de um objeto Calendar.
import java.util.Date;

public class Calendar01 {
    // Método principal, o ponto de entrada do programa.
    public static void main(String[] args) {
        // Cria uma instância de Calendar, que é inicializada com a data e hora atuais do sistema.
        Calendar c = Calendar.getInstance();

        // ATENÇÃO: Esta verificação é um erro comum.
        // getFirstDayOfWeek() verifica qual é o PRIMEIRO dia da semana de acordo com a localidade (no Brasil, é DOMINGO).
        // Ele NÃO verifica se HOJE é domingo. Portanto, este 'if' será verdadeiro em qualquer dia da semana no Brasil.
        if (c.getFirstDayOfWeek() == Calendar.SUNDAY) {
            System.out.println("A semana, nesta localidade, começa no Domingo");
        }

        // Imprime a semana do mês atual. Ex: 4 (para a quarta semana).
        System.out.println("Semana do mês: " + c.get(Calendar.WEEK_OF_MONTH));
        // Imprime o dia do mês atual. Ex: 23.
        System.out.println("Dia do mês: " + c.get(Calendar.DAY_OF_MONTH));
        // Imprime o dia da semana (Domingo=1, Segunda=2, Terça=3, ...). Ex: 3 (para Terça-feira).
        System.out.println("Dia da semana: " + c.get(Calendar.DAY_OF_WEEK));
        // Imprime qual a ocorrência do dia da semana no mês. Ex: 4 (para a quarta Terça-feira do mês).
        System.out.println("Dia da semana no mês: " + c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        // Imprime o dia do mês. Calendar.DATE é um sinônimo para Calendar.DAY_OF_MONTH.
        System.out.println("Dia (usando .DATE): " + c.get(Calendar.DATE));

        // O método add() adiciona um valor a um campo de data.
        // Se a adição ultrapassar o limite do campo, os campos maiores são alterados.
        // Ex: Adicionar 3 dias a 23/09 resulta em 26/09. Adicionar 10 dias resultaria em 03/10 (o mês mudaria).
        c.add(Calendar.DAY_OF_MONTH, 3);

        // O método roll() é diferente do add().
        // Ele também adiciona um valor a um campo, mas se o limite for ultrapassado,
        // os campos maiores NÃO são alterados. O valor apenas "gira" dentro do campo atual.
        // Ex: Se a hora é 09:00 e fazemos roll(Calendar.HOUR, 20), a hora se torna 05:00, mas o DIA não muda.
        c.roll(Calendar.HOUR, 20);

        // Converte o objeto Calendar modificado de volta para um objeto Date para facilitar a impressão.
        Date date = c.getTime();
        // Imprime o resultado final após as modificações de 'add' e 'roll'.
        System.out.println(date);
    }
}