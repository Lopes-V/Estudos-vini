package Coleções;
import java.util.Objects;

/**
 * Uma classe simples para demonstrar equals() e seu contrato.
 */
class Pessoa {
    private int id;
    private String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    // 1. Sobrescrevendo o método equals() - Este é o foco
    @Override
    public boolean equals(Object o) {
        
        // --- REGRA DE OTIMIZAÇÃO (e parte da Regra Reflexiva) ---
        // Se 'o' aponta para o *mesmo* objeto que 'this', eles são iguais.
        if (this == o) return true;

        // --- REGRAS DE SEGURANÇA (Regra Nula e de Tipo) ---
        // Se 'o' é nulo, ou se não é da classe 'Pessoa', não pode ser igual.
        if (o == null || getClass() != o.getClass()) return false;

        // --- A LÓGICA DE NEGÓCIO ---
        // Agora sabemos que 'o' é um objeto 'Pessoa' não-nulo.
        // Podemos converter 'o' para 'Pessoa' com segurança.
        Pessoa pessoa = (Pessoa) o;

        // Definimos nossa "igualdade lógica":
        // Duas Pessoas são iguais se o 'id' for igual E o 'nome' for igual.
        // Usamos Objects.equals() para comparar o 'nome', pois ele trata 'null'
        // de forma segura, evitando um NullPointerException.
        return id == pessoa.id && 
               Objects.equals(nome, pessoa.nome);
    }

    // 2. O Companheiro Obrigatório: hashCode()
    @Override
    public int hashCode() {
        // REGRA: Se você sobrescreveu o equals(), você DEVE sobrescrever o hashCode().
        // O cálculo do hash deve usar os MESMOS CAMPOS que o equals() usou.
        return Objects.hash(id, nome);
    }
}

// --- Classe principal para testar ---
public class ExemploEquals01 {
    public static void main(String[] args) {
        // Criamos duas instâncias *diferentes* na memória,
        // mas com valores *logicamente iguais*.
        Pessoa p1 = new Pessoa(1, "Ana");
        Pessoa p2 = new Pessoa(1, "Ana");

        // Criamos uma terceira instância, diferente
        Pessoa p3 = new Pessoa(2, "Bruno");

        // --- Teste de Identidade (==) ---
        // p1 e p2 são objetos diferentes na memória? Sim.
        System.out.println("p1 == p2 ? " + (p1 == p2)); // Saída: false

        // --- Teste de Igualdade Lógica (.equals()) ---
        // p1 é "logicamente igual" a p2 (de acordo com nossa regra)? Sim.
        System.out.println("p1.equals(p2)? " + p1.equals(p2)); // Saída: true

        System.out.println("---");

        // p1 é "logicamente igual" a p3? Não.
        System.out.println("p1.equals(p3)? " + p1.equals(p3)); // Saída: false
    }
}