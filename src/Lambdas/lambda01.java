package Lambdas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator; // Importante
import java.util.List;

public class lambda01 {

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();
        nomes.add("Ana");
        nomes.add("Cristóvão");
        nomes.add("Maria");
        nomes.add("Pedro");

        System.out.println("Lista Original: " + nomes);

        // --- 1. O JEITO ANTIGO (Antes do Java 8) ---
        // Classe Anônima (Anonymous Inner Class)
        
        System.out.println("\n--- Ordenando (Jeito Antigo) ---");
        
        // Classe, olhem quanta "cerimônia" (boilerplate) temos aqui.
        // Precisamos escrever "new Comparator<String>()" e implementar
        // o método "compare" só para passar a lógica "s1.length() - s2.length()".
        Comparator<String> porTamanhoAntigo = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // A lógica é simples:
                // Se s1.length() < s2.length(), retorna negativo.
                // Se s1.length() > s2.length(), retorna positivo.
                // Se forem iguais, retorna 0.
                return Integer.compare(s1.length(), s2.length());
            }
        };

        // (Precisamos de uma cópia para o próximo exemplo)
        List<String> nomesCopia1 = new ArrayList<>(nomes);
        Collections.sort(nomesCopia1, porTamanhoAntigo);
        System.out.println("Ordenada por tamanho: " + nomesCopia1);

        
        // --- 2. O JEITO NOVO (Com Expressão Lambda) ---
        // Agora, a mágica!
        
        System.out.println("\n--- Ordenando (Jeito Lambda) ---");

        // 

        // O compilador Java é inteligente. Ele sabe que o 'sort' espera
        // um 'Comparator'. E ele sabe que 'Comparator' é uma
        // INTERFACE FUNCIONAL (só tem 1 método abstrato: 'compare').
        //
        // Então, não precisamos de NADA daquilo. Só precisamos focar
        // no que importa:
        //   1. Os parâmetros do método: (String s1, String s2)
        //   2. A seta (->) que diz "executa"
        //   3. A lógica (o corpo) do método
        
        Comparator<String> porTamanhoNovo = (String s1, String s2) -> {
            return Integer.compare(s1.length(), s2.length());
        };

        // (Note: ainda é uma cópia, pois a lista já foi ordenada)
        List<String> nomesCopia2 = new ArrayList<>(nomes);
        Collections.sort(nomesCopia2, porTamanhoNovo);
        System.out.println("Ordenada por tamanho (Lambda): " + nomesCopia2);


        // --- 3. REFINANDO A LAMBDA (O jeito 100% idiomático) ---
        
        System.out.println("\n--- Ordenando (Lambda Refinada) ---");

        // O Java nos permite ser ainda mais concisos.
        // 1. O compilador sabe que os tipos são 'String', então podemos omitir (s1, s2).
        // 2. Se a lógica tem APENAS UMA LINHA (um 'return'), podemos
        //    omitir as chaves '{}' e a palavra 'return'.
        
        // Esta linha faz EXATAMENTE a mesma coisa que a Classe Anônima!
        Collections.sort(nomes, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        
        System.out.println("Ordenada por tamanho (Lambda Final): " + nomes);


        // --- BÔNUS: ONDE MAIS USAMOS? 'forEach' ---
        
        System.out.println("\n--- Usando Lambda no 'forEach' ---");
        
        // Antes:
        // for (String nome : nomes) {
        //     System.out.println(nome);
        // }

        // Agora: "Para cada 'nome' na lista, 'execute' (->) System.out.println(nome)"
        nomes.forEach(nome -> System.out.println(nome));
    }
}