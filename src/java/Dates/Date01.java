package Dates;

// Importa a classe legada (antiga) java.util.Date, que não é recomendada para novos projetos.
import java.util.Date;

public class Date01 {
    // Método principal, o ponto de entrada do programa.
    public static void main(String[] args) {
        // Cria um objeto Date usando um construtor que aceita um valor 'long'.
        // Este número representa a quantidade de milissegundos desde a "Época Unix" (01 de janeiro de 1970, 00:00:00 UTC).
        // O valor 1758468334831L corresponde a 24 de setembro de 2025, 07:05:34 no fuso horário do Brasil (BRT).
        Date d = new Date(1758468334831L);

        // Modifica o objeto 'd', adicionando uma hora ao seu valor.
        // d.getTime() retorna o valor atual em milissegundos.
        // 3_600_000 é o número de milissegundos em uma hora (60min * 60s * 1000ms).
        // O método setTime() altera o objeto original, o que demonstra que a classe Date é MUTÁVEL.
        d.setTime(d.getTime() + 3_600_000);

        // Imprime o valor do objeto Date no console.
        // A saída será o momento original acrescido de uma hora, formatado com o fuso horário padrão do sistema.
        System.out.println(d);
    }
}