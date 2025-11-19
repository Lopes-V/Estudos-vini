// package Coleções;

// import java.util.Objects;

// /**
//  * Uma classe simples para demonstrar hashCode() e equals().
//  */
// class Pessoa {
//     private int id;
//     private String nome;

//     public Pessoa(int id, String nome) {
//         this.id = id;
//         this.nome = nome;
//     }

//     public String getNome() {
//         return nome;
//     }

//     public int getId() {
//         return id;
//     }

//     // 1. Sobrescrevendo o método equals()
//     @Override
//     public boolean equals(Object o) {
//         // Verifica se é a mesma instância de memória
//         if (this == o) return true;
        
//         // Verifica se o objeto é nulo ou de classe diferente
//         if (o == null || getClass() != o.getClass()) return false;
        
//         // Converte o objeto para Pessoa para comparar os campos
//         Pessoa pessoa = (Pessoa) o;
        
//         // Nossa regra de negócio: Duas pessoas são iguais se tiverem o mesmo id e nome.
//         return id == pessoa.id && 
//                Objects.equals(nome, pessoa.nome);
//     }

//     // 2. Sobrescrevendo o método hashCode()
//     @Override
//     public int hashCode() {
//         // Usa o método 'Objects.hash()' para calcular um hashCode
//         // com base nos mesmos campos usados no 'equals()'.
//         // Esta é a forma moderna e recomendada.
//         return Objects.hash(id, nome);
//     }
// }

// // --- Classe principal para testar ---
// public class ExemploHashCode01 {
//     public static void main(String[] args) {
//         // Criamos dois objetos que são "iguais" pela nossa regra
//         Pessoa p1 = new Pessoa(1, "Ana");
//         Pessoa p2 = new Pessoa(1, "Ana");

//         // Criamos um objeto diferente
//         Pessoa p3 = new Pessoa(2, "Bruno");

//         // --- Teste de Igualdade ---
//         System.out.println("p1.equals(p2)? " + p1.equals(p2)); // Saída: true
//         System.out.println("p1.equals(p3)? " + p1.equals(p3)); // Saída: false

//         System.out.println("---");

//         // --- Teste de HashCode ---
//         // Como p1.equals(p2) é true, seus hashCodes DEVEM ser iguais.
//         System.out.println("Hash de p1: " + p1.hashCode());
//         System.out.println("Hash de p2: " + p2.hashCode());

//         // p3 é diferente, então seu hashCode é (muito provavelmente) diferente.
//         System.out.println("Hash de p3: " + p3.hashCode());
//     }
// }