package Regex; // Define o pacote onde a classe está localizada.

import java.util.Arrays; // Importa a classe Arrays (embora não seja usada no código principal, é útil para manipulação de arrays).
import java.util.regex.Matcher; // Importa a classe Matcher para realizar buscas.
import java.util.regex.Pattern; // Importa a classe Pattern para compilar a expressão regular.

public class PatternMatcher05 {
    public static void main(String[] args) {
        // --- Comentários sobre Metacaracteres (Referência) ---
        // \d = Todos os dígitos [0-9]
        // \D = Tudo o que não for dígito [^0-9]
        // \s = Espaços em branco [\t\n\f\r ]
        // \S = Todos os caracteres excluindo os brancos [^\s]
        // \w = Caractere de palavra: [a-zA-Z_0-9]
        // \W = Tudo que não for incluso no \w [^\w]
        // [] = Define um conjunto (ou classe) de caracteres
        // $ = Fim da linha/string
        // * = Zero ou mais ocorrências
        // + = Uma ou mais ocorrências
        // ? = Zero ou uma ocorrência (opcional)
        // {n,m} = Ocorrências de n até m vezes
        // () = Agrupamento (cria um grupo de captura)
        // | = OU (alternativa)
        // . = Qualquer caractere (exceto \n)
        // ^ = Início da linha/string

        // --- Expressão Regular (Regex) ---
        // Objetivo: Encontrar endereços de e-mail com domínios específicos (@gmail.com OU @hotmail.com).
        // [a-zA-Z0-9\\_-]+  -> O nome de usuário do e-mail:
        //                      - Conjunto de caracteres: letras (maiúsculas e minúsculas), dígitos (0-9), sublinhado (_) e hífen (-).
        //                      - O '+' indica que deve haver pelo menos um desses caracteres.
        // @gmail.com|@hotmail.com -> O final do e-mail.
        //                            - O '|' (OU) alterna entre '@gmail.com' e '@hotmail.com'.
        // NOTA: Esta regex não está bem balanceada. O '|' aplica-se a toda a expressão
        //       (ou [a-zA-Z0-9\\_-]+@gmail.com) OU (@hotmail.com). Para corrigir,
        //       o ideal seria usar um grupo para o domínio: [a-zA-Z0-9\\_-]+@(gmail|hotmail).com
        String regex = "[a-zA-Z0-9\\_-]+@gmail.com|@hotmail.com";

        String texto = "123@gmail.com, asvb@hotmail.com, eqes@email.com, teste312@#!@email.com.br"; // O texto a ser analisado.

        // --- Teste com String.matches() ---
        // O método matches() exige que A STRING INTEIRA corresponda à regex.
        // Retorna 'false' porque a regex só aceita e-mails terminados em '@gmail.com' ou apenas '@hotmail.com' (devido ao problema do '|').
        // O domínio '@email.com' não corresponde.
        System.out.println("eqes@email.com".matches(regex));

        // --- Teste com String.split() e manipulação de String ---
        // 1. texto.split(",") -> Divide a string em um array, usando a vírgula como delimitador.
        //    Resultado: ["123@gmail.com", " asvb@hotmail.com", " eqes@email.com", " teste312@#!@email.com.br"]
        // 2. [1] -> Acessa o segundo elemento do array (o e-mail " asvb@hotmail.com").
        // 3. .trim() -> Remove espaços em branco no início e no fim da string.
        System.out.println(texto.split(",")[1].trim());

        // --- Uso Padrão de Pattern e Matcher ---
        Pattern pattern = Pattern.compile(regex); // Compila a regex.
        Matcher matcher = pattern.matcher(texto); // Cria o Matcher para buscar no texto.

        System.out.println("Texto:  "+ texto);
        System.out.println("Indice: 0123456789"); // Referência visual dos índices.
        System.out.println("Regex:   "+ regex);
        System.out.println("Posicoes encontradas");

        // Loop para encontrar e exibir todas as ocorrências da regex no texto.
        while (matcher.find()) {
            // matcher.start(): Posição inicial da correspondência.
            // matcher.group(): O texto que correspondeu à regex.
            System.out.print(matcher.start()+"  "+matcher.group()+"\n");
        }
    }
}