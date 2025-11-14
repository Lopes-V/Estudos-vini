package Colecoes;

import java.util.ArrayList;
import java.util.List;

// Classe principal que contém toda a lógica e as definições de classe
public class WildcardTest02 {

    // --- 1. DEFINIÇÃO DAS CLASSES DE DOMÍNIO ---
    // Elas estão "aninhadas" dentro da classe WildcardTest02
    // Usamos 'static' para que não precisem de uma instância de WildcardTest02 para existir.

    /**
     * Classe base abstrata.
     */
    static abstract class Animal {
        public abstract void consulta();
    }

    /**
     * Cachorro "É UM" Animal
     */
    static class Cachorro extends Animal {
        @Override
        public void consulta() {
            System.out.println("Consultando o cachorro (Au au!)");
        }
        
        @Override
        public String toString() {
            return "Cachorro";
        }
    }

    /**
     * Gato "É UM" Animal
     */
    static class Gato extends Animal {
        @Override
        public void consulta() {
            System.out.println("Consultando o gato (Miau!)");
        }
        
        @Override
        public String toString() {
            return "Gato";
        }
    }

    // --- 2. CLASSE PRINCIPAL E MÉTODOS ---

    public static void main(String[] args) {
        // List.of() cria listas imutáveis
        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato());

        // 1. CHAMANDO O "PRODUCER" (Leitor)
        // Ambas as listas podem ser passadas para um método
        // que "lê" (extends) Animais.
        printConsulta(cachorros);
        printConsulta(gatos);

        // 2. CHAMANDO O "CONSUMER" (Escritor)
        // Criamos uma lista mutável (ArrayList) que pode conter Animais.
        List<Animal> animals = new ArrayList<>();
        
        // Passamos esta lista para um método que "escreve" (super) Animais nela.
        printConsultaAnimal(animals);

        // 3. VERIFICANDO O RESULTADO
        System.out.println("\n--- Lista 'animals' após adição ---");
        System.out.println(animals); 
    }

    // --- MÉTODO 1: PRODUCER EXTENDS ---
    // 
    
    // Aceita qualquer lista de um tipo que SEJA (extends) Animal.
    // Esta lista é uma PRODUTORA (producer) - só podemos LER dela.
    private static void printConsulta(List<? extends Animal> animals) {
        System.out.println("--- Consultando ---");
        for (Animal animal : animals) {
            animal.consulta();
        }
        // animals.add(new Cachorro()); // <-- NÃO COMPILA
    }

    // --- MÉTODO 2: CONSUMER SUPER ---
    // 

    // Aceita qualquer lista de um tipo que SEJA SUPER-TIPO (super) de Animal.
    // (Neste caso, List<Animal> ou List<Object>)
    // Esta lista é uma CONSUMIDORA (consumer) - podemos ADICIONAR nela.
    private static void printConsultaAnimal(List<? super Animal> animals){
        System.out.println("\n--- Adicionando animais ---");
        
        // É seguro adicionar Cachorro e Gato, pois ambos são "Animais".
        animals.add(new Cachorro());
        animals.add(new Gato());
    }
}