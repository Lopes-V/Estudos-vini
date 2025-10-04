package Regex; // Define o pacote (pasta lógica) onde a classe está localizada.

import java.util.regex.Matcher; // Importa a classe Matcher, usada para realizar operações de busca na string.
import java.util.regex.Pattern; // Importa a classe Pattern, usada para compilar a expressão regular em um padrão.

public class PatternMatcher04 {
    public static void main(String[] args) {
        // --- Comentários sobre os Metacaracteres (São ótimas anotações!) ---
        // \d = Todos os dígitos [0-9]
        // \D = Tudo o que não for dígito [^0-9]
        // \s = Espaços em branco [\t\n\f\r ]
        // \S = Todos os caracteres excluindo os brancos [^\s]
        // \w = Caractere de palavra: [a-zA-Z_0-9]
        // \W = Tudo que não for incluso no \w [^\w]
        // [] = Define um conjunto (ou classe) de caracteres
        // $ = Fim da linha/string (âncora)
        // * = Zero ou mais ocorrências do elemento anterior
        // + = Uma ou mais ocorrências do elemento anterior
        // ? = Zero ou uma ocorrência (opcional) do elemento anterior
        // {n,m} = Ocorrências de n até m vezes
        // () = Agrupamento (cria um grupo de captura)
        // | = OU (alternativa)

        // --- Expressão Regular (Regex) ---
        // Esta regex busca por números hexadecimais formatados:
        // 0[xX]     -> Começa com '0' seguido de 'x' ou 'X' (Case-insensitive para o prefixo).
        // ([0-9a-fA-F])+ -> Grupo de captura 1: Pelo menos um (+) caractere hexadecimal
        //                   (dígitos 0-9 OU letras a-f/A-F).
        // (\\s|$)   -> Grupo de captura 2: Deve ser seguido por um espaço em branco (\s)
        //              OU ($) pelo final da string. Isso garante que o número hexadecimal
        //              não termine em um caractere inválido (como o 'G' em '0X10G').
        String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";

        String texto = "12 0X 0X 0XFFABC 0X10G 0X1"; // A string onde a busca será realizada.

        Pattern pattern = Pattern.compile(regex); // Compila a regex em um objeto Pattern para desempenho.
        Matcher matcher = pattern.matcher(texto); // Cria o objeto Matcher para buscar a regex no texto.

        System.out.println("Texto:  "+ texto);
        // Imprime a string para referência.
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