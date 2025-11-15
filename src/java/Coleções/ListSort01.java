package Coleções;

import java.util.ArrayList; // Importa a classe de implementação 'ArrayList'.
import java.util.Collections; // Importa a classe utilitária 'Collections' (para sort, shuffle, etc.).
import java.util.List; // Importa a interface 'List'.
import java.util.Objects; // Importa a classe utilitária 'Objects' (para null-checks, etc.).

public class ListSort01 {
    public static void main(String[] args) {
        
        // --- Demonstração de Objects.requireNonNullElse ---
        String teste = null; // Cria uma string nula.
        
        // 'requireNonNullElse' verifica se o primeiro argumento ('teste') é nulo.
        // Se *não* for nulo, ele retorna o próprio 'teste'.
        // Se *for* nulo (como é o caso), ele retorna o valor padrão (segundo argumento, "teste").
        teste = Objects.requireNonNullElse(teste, "teste");
        
        System.out.println("Resultado do requireNonNullElse: " + teste);
        System.out.println("---");

        // --- Criação da Lista ---
        // Cria uma nova ArrayList para armazenar números inteiros.
        List<Integer> lista = new ArrayList<Integer>();
        
        // Adiciona elementos à lista (em ordem de inserção).
        lista.add(5);
        lista.add(3);
        lista.add(4);
        lista.add(1);
        lista.add(2);
        
        // Imprime a lista na ordem em que foi inserida.
        System.out.println("Lista original: " + lista);

        // --- Embaralhando a Lista ---
        // Utiliza a classe 'Collections' para "embaralhar" (randomizar) a ordem
        // dos elementos *dentro* da própria lista ('in-place').
        Collections.shuffle(lista);
        
        // Imprime a lista com os elementos em ordem aleatória.
        System.out.println("Lista embaralhada: " + lista);

        // --- Ordenando a Lista ---
        // Utiliza a classe 'Collections' para "ordenar" (sort) a lista.
        // Como 'Integer' implementa 'Comparable', a ordenação natural (ascendente) é usada.
        // A ordenação também é feita 'in-place'.
        // 
        Collections.sort(lista);
        
        // Imprime a lista agora ordenada numericamente.
        System.out.println("Lista ordenada: " + lista);
    }
}