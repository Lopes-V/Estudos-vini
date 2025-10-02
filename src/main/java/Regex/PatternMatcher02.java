// Define o pacote da classe.
package Regex;

// Importa as classes Matcher e Pattern para trabalhar com expressões regulares.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher02 {
    public static void main(String[] args) {
        // --- Metacaracteres Comuns em Regex ---
        // \d = Procura por todos os dígitos. (Ex: 0, 1, 2, 3...)
        // \D = Procura por tudo o que NÃO for dígito. (Ex: a, b, !, @)
        // \s = Procura por espaços em branco, incluindo \t (tab), \n (nova linha), \f, \r.
        // \S = Procura por todos os caracteres, EXCLUINDO os espaços em branco.
        // \w = Procura por caracteres de "palavra": letras (a-z, A-Z), dígitos (0-9) e o underscore (_).
        // \W = Procura por tudo o que NÃO for um caractere de "palavra". (Oposto do \w).

        // A expressão regular a ser usada.
        // "\\W" em uma String Java significa o metacaractere \W.
        // A primeira barra '\' é um caractere de escape da própria String Java.
        // Portanto, estamos procurando por qualquer caractere que NÃO seja letra, número ou underscore.
        String regex = "\\W";

        // O texto onde a busca será realizada.
        String texto2 = "@fhsfnd_121sdfi\nsnf23mj1";

        // Compila a regex para criar um objeto Pattern.
        Pattern pattern = Pattern.compile(regex);
        // Cria um Matcher para conectar o padrão (regex) com o texto.
        Matcher matcher = pattern.matcher(texto2);

        // Imprime informações de referência no console.
        System.out.println("Texto:  " + texto2);
        System.out.println("Indice: 0123456789..."); // Apenas uma referência visual dos índices
        System.out.println("Regex:  " + regex);
        System.out.println("Posicoes encontradas");

        // Loop para encontrar todas as ocorrências que correspondem à regex.
        while (matcher.find()) {
            // Para cada correspondência encontrada, imprime:
            // matcher.start(): O índice onde a correspondência começou.
            // matcher.group(): O próprio caractere ou texto que foi encontrado.
            System.out.print(matcher.start() + "  " + matcher.group() + "\n");
        }
        /*
         * SAÍDA ESPERADA:
         * 0  @
         * 15
         *
         * Por quê?
         * - O caractere '@' no índice 0 corresponde a \W (não é letra, número ou _).
         * - O caractere '\n' (nova linha) no índice 15 também corresponde a \W.
         */
    }
}