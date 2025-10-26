package Exercicios;

// Importa as classes necessárias para manipulação de datas e para ler a entrada do usuário.
import java.time.LocalDate; // Para representar uma data (ano-mês-dia).
import java.time.Period;    // Para representar um período de tempo (anos, meses, dias).
import java.time.format.DateTimeFormatter; // Para formatar e analisar strings de data.
import java.util.Scanner;   // Para ler a entrada do teclado.

public class ExerciciosChronoUnit {
    // Cria uma instância estática do Scanner para que possa ser usada em toda a classe.
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Define o formato de data que esperamos do usuário (padrão brasileiro). 📅
        //    "dd" = dia, "MM" = mês, "yyyy" = ano.
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // 2. Pede a data de nascimento da avó. 👵
        System.out.print("Data exemplo: (dd/MM/yyyy)"); // Mostra um exemplo.
        System.out.println("\nInsira a data de nascimento da sua avó: "); // O texto original pedia o ano, mas o código espera a data completa.
        String tempo = sc.nextLine(); // Lê a data como uma String. ⌨️

        // 3. Converte (faz o "parse") a String digitada para um objeto LocalDate.
        //    O 'formatterBR' é usado aqui para dizer ao Java como interpretar a String.
        LocalDate avoD = LocalDate.parse(tempo, formatterBR);

        // 4. Repete o processo para a data de nascimento do usuário.
        System.out.println("Insira a sua data de nascimento: ");
        tempo = sc.nextLine();
        LocalDate usuD = (LocalDate.parse(tempo, formatterBR));

        // 5. Calcula a diferença de tempo entre as duas datas. ⏳
        //    O Period.between() retorna um objeto Period que contém a diferença em anos, meses e dias.
        Period diferenca = Period.between(avoD, usuD);

        // 6. Imprime o resultado de forma formatada.
        //    O printf usa %d como um placeholder para os números (anos, meses, dias)
        //    e %n para uma nova linha.
        System.out.printf("A diferença entre as datas é de: %d anos, %d meses e %d dias.%n",
                diferenca.getYears(),  // Pega a parte dos anos da diferença.
                diferenca.getMonths(), // Pega a parte dos meses.
                diferenca.getDays());  // Pega a parte dos dias.
    }
}