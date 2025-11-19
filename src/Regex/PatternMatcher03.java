package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher03 {
    public static void main(String[] args) {
        // --- Metacaracteres e Construtores Regex ---
        // \d = Todos os dígitos
        // \D = Tudo o que não for dígito
        // \s = Espaços em branco (\t \n \f \r)
        // \S = Todos os caracteres, exceto os brancos
        // \w = a-z, A-Z, todos os dígitos, _
        // \W = Tudo o que não for incluso no \w
        // [] = Usado para definir um conjunto ou intervalo de caracteres. Ex: [abc] encontra 'a', 'b' ou 'c'.

        // A expressão regular a ser usada para encontrar números hexadecimais básicos.
        // Vamos quebrar a regex "0[xX][0-9a-fA-F]":
        // 1. `0`         -> Encontra o caractere literal '0'.
        // 2. `[xX]`       -> Encontra UM caractere que seja 'x' minúsculo OU 'X' maiúsculo.
        // 3. `[0-9a-fA-F]`-> Encontra UM caractere que seja um dígito de 0 a 9, OU uma letra de 'a' a 'f', OU uma letra de 'A' a 'F'.
        // Em resumo, a regex busca por um prefixo hexadecimal (0x ou 0X) seguido por UM dígito hexadecimal.
        String regex = "0[xX][0-9a-fA-F]";

        // O texto onde a busca será realizada.
        String texto2 = "12 0X 0X 0XFFABC 0X109 0X1";

        // Compila a regex para criar um objeto Pattern.
        Pattern pattern = Pattern.compile(regex);
        // Cria um Matcher para conectar o padrão com o texto.
        Matcher matcher = pattern.matcher(texto2);

        // Imprime informações de referência no console.
        System.out.println("Texto:  " + texto2);
        System.out.println("Indice: 0123456789..."); // Apenas uma referência visual
        System.out.println("Regex:  " + regex);
        System.out.println("Posicoes encontradas");

        // Loop para encontrar todas as ocorrências que correspondem à regex.
        while (matcher.find()) {
            // Para cada correspondência, imprime o índice inicial e o texto encontrado.
            System.out.print(matcher.start() + "  " + matcher.group() + "\n");
        }
        /*
         * SAÍDA ESPERADA:
         * 9  0XF
         * 16  0X1
         * 22  0X1
         *
         * Por quê?
         * - Em "0XFFABC", ele encontra "0XF" (índice 9) e para, pois a regex só pede UM dígito hexadecimal após o "0X".
         * - Em "0X109", ele encontra "0X1" (índice 16) e para pela mesma razão.
         * - No final, ele encontra "0X1" (índice 22).
         * - Os "0X " sozinhos não são encontrados, pois falta o dígito hexadecimal no final.
         */
    }
}