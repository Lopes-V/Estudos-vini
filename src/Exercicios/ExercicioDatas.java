package Exercicios;
import java.util.Date;
import java.util.Calendar;
public class ExercicioDatas {
        public static void main(String[] args) {
            Date data = new Date();
            Calendar cal = Calendar.getInstance();
            System.out.println("Date: " + cal.getTime());
            // --- Passo 1: Mostrar a data e hora atuais ---
            // Crie um objeto Date e imprima no console.
            System.out.println("--- Data e Hora Atuais ---");
            // Digite seu código aqui:


            // --- Passo 2: Definir uma data de aniversário ---
            // Use a classe Calendar para definir uma data (ex: 21 de Setembro de 1990).
            // Você vai precisar usar o método set(). Lembre-se que os meses em Calendar
            // são baseados em zero (Janeiro é 0, Fevereiro é 1, etc.).
            System.out.println("\n--- Data de Aniversário ---");
            Calendar aniversario = Calendar.getInstance();
            // Digite seu código aqui:


            // Imprima a data de aniversário. Use o getTime() para converter para um objeto Date.
            System.out.println("Meu aniversário é: " + aniversario.getTime());


            // --- Passo 3: Adicionar 10 dias ao seu aniversário ---
            // Use o método add() de Calendar.
            System.out.println("\n--- 10 Dias Após o Aniversário ---");
            // Crie um novo objeto Calendar ou use o mesmo.
            Calendar dezDiasDepois = (Calendar) aniversario.clone(); // Usamos clone para não modificar a data original.
            // Digite seu código aqui:


            System.out.println("10 dias depois do meu aniversário será: " + dezDiasDepois.getTime());


            // --- Passo 4: Subtrair 15 dias do seu aniversário ---
            // Use o método add() com um valor negativo para subtrair.
            System.out.println("\n--- 15 Dias Antes do Aniversário ---");
            Calendar quinzeDiasAntes = (Calendar) aniversario.clone();
            // Digite seu código aqui:


            System.out.println("15 dias antes do meu aniversário foi: " + quinzeDiasAntes.getTime());
        }
    }
