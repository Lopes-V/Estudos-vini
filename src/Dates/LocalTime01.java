package Dates;

// Importa a classe LocalTime, usada para representar um horário (hora, minuto, segundo) sem informações de data ou fuso horário.
import java.time.LocalTime;
// Importa a enumeração ChronoField, que fornece uma maneira genérica de acessar campos de um horário.
import java.time.temporal.ChronoField;

public class LocalTime01 {
    // Método principal, o ponto de entrada para a execução do programa.
    public static void main(String[] args) {
        // Cria um objeto LocalTime para um horário específico: 22 horas, 32 minutos e 12 segundos.
        LocalTime time = LocalTime.of(22, 32, 12);
        // Cria um objeto LocalTime com o horário atual do sistema em que o código está rodando.
        LocalTime agora = LocalTime.now();

        // Imprime o objeto de horário completo no formato padrão (HH:mm:ss). Saída: 22:32:12
        System.out.println(time);
        // Imprime o horário atual do sistema. Ex: 10:56:04.123456789
        System.out.println(agora);

        // ---- Obtendo informações do horário ----

        // Imprime a hora da variável 'time' (22).
        System.out.println(time.getHour());
        // Imprime o minuto da variável 'time' (32).
        System.out.println(time.getMinute());
        // Imprime o segundo da variável 'time' (12).
        System.out.println(time.getSecond());

        // ---- Formas alternativas de obter informações ----

        // Obtém a hora no formato de 12 horas (AM/PM). Para 22h, o valor retornado será 10.
        System.out.println(time.get(ChronoField.CLOCK_HOUR_OF_AMPM));

        // ---- Constantes da classe ----

        // Imprime o horário mínimo suportado pela classe, que é a meia-noite (00:00).
        System.out.println(LocalTime.MIN);
        // Imprime o horário máximo suportado, que é o último instante antes da meia-noite (23:59:59.999999999).
        System.out.println(LocalTime.MAX);
    }
}