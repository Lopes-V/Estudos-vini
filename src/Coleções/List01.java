package Coleções; // Define o pacote onde a classe está localizada.

import java.util.ArrayList; // Importa a classe concreta 'ArrayList', que é uma implementação de Lista redimensionável.
import java.util.List; // Importa a interface 'List', que define o contrato para coleções ordenadas.

public class List01 {
    public static void main(String[] args) {
        
        // 
        
        // Cria uma nova lista.
        // - 'List<Object>': Declara a variável 'nomes' como uma Lista.
        //   Programar para a interface ('List') é uma boa prática.
        // - '<Object>': É o tipo genérico. Usar 'Object' permite que a lista
        //   armazene *qualquer* tipo de objeto (Strings, Números, Booleanos, etc.).
        //   Geralmente, é melhor usar tipos específicos (ex: List<String>).
        // - 'new ArrayList<Object>(16)': Cria a instância concreta da lista
        //   com uma capacidade inicial de 16 elementos. Isso é uma otimização
        //   para evitar redimensionamentos iniciais se você já sabe que terá
        //   pelo menos 16 itens.
        List<Object> nomes = new ArrayList<Object>(16); // capacidade inicial
        
        // Adiciona elementos à lista. O método 'add' insere no final.
        nomes.add("Pedro"); // Adiciona uma String
        nomes.add("Ana"); // Adiciona outra String
        nomes.add(1321); // Adiciona um 'int', que sofre "autoboxing" para 'Integer' (um objeto)
        nomes.add(true); // Adiciona um 'boolean', que sofre "autoboxing" para 'Boolean' (um objeto)

        // Itera sobre a lista usando um loop "for-each".
        // Para cada 'nome' (do tipo Object) dentro da lista 'nomes'...
        for(Object nome : nomes) {
            // ...imprime o elemento. O método 'println' chama o 'toString()' de cada objeto.
            System.out.println(nome);
        }
        
        System.out.println("---"); // Separador visual

        // Cria uma segunda lista, também de 'Object'.
        List<Object> nomes1 = new ArrayList<Object>(16);
        
        // Adiciona um elemento a esta segunda lista.
        nomes1.add("Carla");
        
        // Tenta adicionar *todos* os elementos da lista 'nomes1' ao *final* da lista 'nomes'.
        // O método 'addAll' retorna 'true' se a lista 'nomes' foi modificada
        // (o que acontecerá, já que 'nomes1' não está vazia).
        System.out.println("A lista 'nomes' foi modificada? " + nomes.addAll(nomes1));
        
        // Imprime a lista 'nomes1' original.
        // Note que 'nomes1' *não* é alterada pela operação 'addAll'.
        System.out.println("Conteúdo de nomes1 (não mudou): " + nomes1);
        
        System.out.println("---"); // Separador visual

        // (Vamos imprimir a lista 'nomes' para ver o resultado final)
        System.out.println("Conteúdo final de 'nomes': " + nomes);
    } 
}