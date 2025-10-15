package Regex; // Define o pacote (pasta lógica) onde a classe está localizada.

import java.util.regex.Matcher; // Importa a classe Matcher, usada para realizar operações de busca na string.
import java.util.regex.Pattern; // Importa a classe Pattern, usada para compilar a expressão regular em um padrão.

public class PatternMatcher04 {
    public static void main(String[] args) {
        // \d = Todos od dígitos
        // \D = Tudo o que não for dígito
        // \s = Espaços em branco \t \n \f \r
        // \S = Todos os caracteres excluindo os brancos
        // \w = a-Z A-Z, todos os digitos, _
        // \W = Tudo que não for incluso no \w
        // []
        String regex = "0[xX][0-9a-fA-F]";
        String texto = "12 0X 0X 0XFFABC 0X109 0X1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("Texto:  "+ texto);
        System.out.println("Indice: 0123456789");
        // Imprime os índices (simplificado) para ajudar na visualização da posição.
        System.out.println("Regex:   "+ regex);
        System.out.println("Posicoes encontradas");

        // Loop principal para encontrar todas as ocorrências da regex no texto.
        while (matcher.find()) {
            // matcher.find(): Tenta encontrar a próxima correspondência que satisfaça a regex.
            System.out.print(matcher.start()+"  "+matcher.group()+"\n");
            // matcher.start(): Retorna o índice inicial da correspondência.
            // matcher.group(): Retorna a substring completa que correspondeu à regex.
        }
    }
}