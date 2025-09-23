package Dates;

// Importa a classe LocalDate, que representa uma data (ano, mês, dia).
import java.time.LocalDate;
// Importa a classe Period, usada para medir uma quantidade de tempo em termos de anos, meses e dias.
// É ideal para intervalos de tempo "humanos", em contraste com a classe 'Duration' que é baseada em segundos.
import java.time.Period;

public class Period01 {
    // Método principal, o ponto de entrada para a execução do programa.
    public static void main(String[] args) {
        // Cria um objeto com a data atual.
        LocalDate ldt1 = LocalDate.now();
        // Cria um segundo objeto com uma data no futuro: 2 anos, 1 mês e 3 dias a partir de agora.
        LocalDate ldt2 = LocalDate.now().plusYears(2).plusDays(3).plusMonths(1);

        // ---- Calculando o Período entre duas datas ----

        // Calcula o período de tempo entre as duas datas. O resultado será representado em anos, meses e dias.
        Period p1 = Period.between(ldt1, ldt2);

        // Imprime o período. A saída é no formato padrão ISO-8601 (ex: P2Y1M3D).
        // "P" significa "Período" (Period), seguido pelos valores de Anos (Y), Meses (M) e Dias (D).
        System.out.println(p1);

        // ---- Criando Períodos específicos com métodos 'of' ----

        // Cria um período de exatamente 10 dias.
        Period p2 = Period.ofDays(10);
        System.out.println(p2); // Saída: P10D

        // Cria um período de 5 meses.
        Period p3 = Period.ofMonths(5);
        System.out.println(p3); // Saída: P5M

        // Cria um período de 3 anos.
        Period p4 = Period.ofYears(3);
        System.out.println(p4); // Saída: P3Y

        // Cria um período composto de 2 anos, 3 meses e 5 dias.
        Period p5 = Period.of(2, 3, 5);
        System.out.println(p5); // Saída: P2Y3M5D

        // Cria um período de 3 semanas.
        // IMPORTANTE: A classe Period armazena internamente apenas anos, meses e dias.
        // O método 'ofWeeks' converte as semanas para dias (3 semanas = 21 dias).
        Period p6 = Period.ofWeeks(3);
        System.out.println(p6); // Saída: P21D
    }
}