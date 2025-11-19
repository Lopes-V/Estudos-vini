// Define o pacote da classe.
package Regex;

// Importa a classe Matcher, que interpreta um padrão e realiza operações de correspondência em uma string.
import java.util.regex.Matcher;
// Importa a classe Pattern, que é a representação compilada de uma expressão regular.
import java.util.regex.Pattern;

public class PatternMatcher01 {
    public static void main(String[] args) {
        // Define a expressão regular (regex) que queremos encontrar. Neste caso, a sequência exata "aba".
        String regex = "aba";
        // Define o texto onde faremos a busca.
        String texto2 = "abababa";

        // 1. Compila a expressão regular. Isso transforma a string "aba" em um objeto Pattern
        // que o Java pode usar para fazer buscas de forma eficiente.
        Pattern pattern = Pattern.compile(regex);

        // 2. Cria um objeto Matcher. Este objeto "conecta" o padrão (pattern) com o texto (texto2)
        // e será o responsável por executar a busca e guardar os resultados.
        Matcher matcher = pattern.matcher(texto2);

        // Imprime informações no console para facilitar o entendimento da saída.
        System.out.println("Texto:  " + texto2);
        System.out.println("Indice: 0123456789");
        System.out.println("Regex:  " + regex);
        System.out.println("Posicoes encontradas");

        // 3. Executa a busca.
        // O laço 'while' continua executando enquanto o método matcher.find() retornar 'true'.
        // O método find() tenta encontrar a PRÓXIMA subsequência do texto que corresponde ao padrão.
        while (matcher.find()) {
            // Se find() encontrou uma correspondência, o método matcher.start() retorna
            // o índice (a posição) inicial dessa correspondência no texto.
            // Ex: Na primeira vez, encontra "aba" no índice 0. Na segunda, no índice 2, e assim por diante.
            System.out.print(matcher.start() + "  ");
        }
        // A saída final será: 0  2  4
    }
}