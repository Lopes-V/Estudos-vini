package Dates;

// Importa a classe LocalDate para trabalhar com datas (ano, mês, dia).
import java.time.LocalDate;
// Importa a classe LocalDateTime, que combina uma data e um horário.
import java.time.LocalDateTime;
// Importa a classe LocalTime para trabalhar com horários (hora, minuto, segundo).
import java.time.LocalTime;

public class LocalDateTime01 {
    // Método principal, o ponto de entrada para a execução do programa.
    public static void main(String[] args) {
        // Cria um objeto LocalDateTime com a data e hora atuais do sistema.
        LocalDateTime localDateTime = LocalDateTime.now();

        // Cria um objeto LocalDate a partir de uma String no formato padrão ISO (AAAA-MM-DD).
        LocalDate date = LocalDate.parse("2025-08-06");
        // Cria um objeto LocalTime para um horário específico: 09 horas, 45 minutos e 21 segundos.
        LocalTime time = LocalTime.of(9, 45, 21);

        // Imprime a data e hora atuais, separadas por um 'T'. Ex: 2025-09-23T13:27:05.123
        System.out.println(localDateTime);
        // Imprime a data criada a partir da String. Saída: 2025-08-06
        System.out.println(date);
        // Imprime o horário criado. Saída: 09:45:21
        System.out.println(time);

        // ---- Combinando LocalDate e LocalTime ----

        // Junta a data ('date') com o horário ('time') para criar um novo LocalDateTime.
        LocalDateTime ldt1 = date.atTime(time);
        // Faz a mesma junção, mas de forma inversa: junta o horário ('time') com a data ('date').
        // O resultado de 'ldt1' e 'ldt2' será exatamente o mesmo.
        LocalDateTime ldt2 = time.atDate(date);

        // Imprime o objeto LocalDateTime resultante da junção. Saída: 2025-08-06T09:45:21
        System.out.println(ldt2);
    }
}