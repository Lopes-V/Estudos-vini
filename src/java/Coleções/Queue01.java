package Coleções;

import java.util.LinkedList;
import java.util.Queue;

public class Queue01 {

    public static void main(String[] args) {

        // A interface Queue representa uma FILA (estrutura FIFO — First In, First Out).
        // A implementação mais comum é o LinkedList, que permite enfileirar e desenfileirar elementos.
        Queue<String> filaBanco = new LinkedList<>();

        // Adiciona elementos à fila com o método add().
        // O primeiro a entrar será o primeiro a sair.
        filaBanco.add("João");
        filaBanco.add("Maria");
        filaBanco.add("Pedro");

        // Mostra todos os elementos da fila.
        // A ordem segue a sequência de inserção.
        System.out.println("Fila inicial: " + filaBanco);

        // peek(): retorna o primeiro elemento da fila (cabeça da fila),
        // sem removê-lo. Se a fila estiver vazia, retorna null.
        System.out.println("Primeiro da fila (peek): " + filaBanco.peek());

        // poll(): retorna e REMOVE o primeiro elemento da fila.
        // Após chamar poll(), o próximo elemento passa a ser o primeiro.
        String atendido = filaBanco.poll();
        System.out.println("Atendendo: " + atendido);

        // Mostra a fila depois de remover o primeiro elemento.
        System.out.println("Fila após atendimento: " + filaBanco);

        // offer(): adiciona um elemento ao final da fila.
        // A diferença para add() é que offer() não lança exceção se a fila estiver cheia.
        filaBanco.offer("Ana");
        System.out.println("Fila após nova chegada (Ana): " + filaBanco);

        // element(): obtém o primeiro elemento SEM removê-lo, como peek(),
        // mas lança exceção se a fila estiver vazia.
        System.out.println("Primeiro da fila (element): " + filaBanco.element());

        // Exemplo de processamento completo: atendendo todos até a fila esvaziar.
        System.out.println("\nAtendendo todos os clientes:");
        while (!filaBanco.isEmpty()) {
            System.out.println("Atendendo: " + filaBanco.poll());
        }

        System.out.println("Fila vazia: " + filaBanco);
    }
}