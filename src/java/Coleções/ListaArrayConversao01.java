package Coleções; // Define o pacote da classe.

import java.util.ArrayList; // Importa a classe ArrayList (lista redimensionável).
import java.util.Arrays; // Importa a classe utilitária Arrays (para 'asList' e 'toString').
import java.util.List; // Importa a interface List.

public class ListaArrayConversao01 {

    public static void main(String[] args) {
        
        // --- 1. CRIAÇÃO DA LISTA ORIGINAL ---
        
        // Cria uma ArrayList padrão, que é dinâmica e mutável.
        List<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // --- 2. CONVERSÃO: LISTA -> ARRAY ---
        
        // Converte a 'List' (numeros) em um array de 'Integer'.
        // O método 'toArray' recebe um "array modelo" para saber o tipo.
        // 
        //
        // NOTA: Passar 'new Integer[0]' (um array de tamanho zero) é a forma
        // moderna e eficiente. O Java ignora o tamanho 0 e cria
        // automaticamente um novo array com o tamanho exato da lista (3, neste caso).
        Integer [] integerLists = numeros.toArray(new Integer[0]); // Conversão para array
        
        // Imprime o conteúdo do array.
        // É preciso usar 'Arrays.toString()' para formatar a saída
        // corretamente (ex: [10, 20, 30]).
        System.out.println("Array: " + Arrays.toString(integerLists)); 
        
        
        // --- 3. CONVERSÃO: ARRAY -> LISTA (Método 1: 'Arrays.asList') ---
        
        // Converte o 'array' de volta para uma 'List'.
        // 
        //
        // *** ALERTA IMPORTANTE ***
        // A lista ('numerosArray') retornada por 'Arrays.asList' NÃO é um ArrayList!
        // É uma lista especial de *tamanho fixo* que é "linkada" (backed)
        // ao array original ('integerLists').
        //
        // CONSEQUÊNCIAS:
        // 1. Você NÃO PODE adicionar/remover elementos (ex: 'numerosArray.add(40)'
        //    lançaria uma UnsupportedOperationException).
        // 2. Se você *alterar* o array original, a lista também muda (e vice-versa).
        List<Integer> numerosArray = Arrays.asList(integerLists); // Conversão de volta para lista
        
        System.out.println("Lista (linkada/tamanho fixo): " + numerosArray);
        
        
        // --- 4. CONVERSÃO: ARRAY -> LISTA (Método 2: Cópia Segura) ---
        
        // Esta é a forma correta de criar uma *verdadeira ArrayList*
        // (mutável e redimensionável) a partir de um array existente.
        //
        // Como funciona:
        // 1. 'Arrays.asList(integerLists)' cria a lista de tamanho fixo (como acima).
        // 2. 'new ArrayList<>(...)' usa o construtor da ArrayList, que *copia*
        //    todos os elementos da lista interna para uma *nova* e *independente*
        //    ArrayList.
        List<Integer> numerosList2 = new ArrayList<>(Arrays.asList(integerLists));
        
        // Agora, 'numerosList2' é uma ArrayList normal e podemos adicionar elementos.
        numerosList2.add(40); // Adicionando um elemento para mostrar que é uma lista mutável
        
        System.out.println("ArrayList (real/mutável): " + numerosList2);
        
        // (Nota: A lista original 'numeros' e o array 'integerLists'
        // não são afetados por esta adição).
    }
}