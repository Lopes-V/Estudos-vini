package Parlamentizacao;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Parametrizacao01 {
    
    // Lista inicial de dados
    private static List<Carro> carros = List.of(
            new Carro("Fusca", "Verde", 1970),
            new Carro("Gol", "Vermelho", 2015),
            new Carro("Onix", "Branco", 2020),
            new Carro("Opala", "Verde", 1975)
    );

    // --- 1. O JEITO ANTIGO (Rígido, "Hardcoded") ---
    // Repare que a regra "cor.equals("Verde")" está "amarrada"
    // dentro do método. Se quisermos carros vermelhos, precisamos
    // de OUTRO método.
    public static List<Carro> filtrarCarrosVerdes(List<Carro> carros) {
        List<Carro> carrosFiltrados = new ArrayList<>();
        for (Carro carro : carros) {
            if (carro.getCor().equals("Verde")) {
                carrosFiltrados.add(carro);
            }
        }
        return carrosFiltrados;
    }

    
    // --- 2. A TRANSIÇÃO (Classe Anônima) ---
    // Este é o "coração" da Parametrização pt 01.
    // Primeiro, definimos um "contrato" (Interface)
    // para o comportamento que queremos passar.
    
    //     @FunctionalInterface // (Opcional, mas boa prática)
    interface CarroPredicate {
        // Este é o comportamento que queremos parametrizar:
        // um teste que recebe um Carro e retorna true ou false.
        boolean test(Carro carro); 
    }

    // Agora, criamos um método 'filtrar' que ACEITA o comportamento.
    // Em vez de "filtrarVerdes", é um "filtrar" genérico.
    // Ele recebe a lista E o "teste" (o comportamento).
    public static List<Carro> filtrar(List<Carro> carros, CarroPredicate predicado) {
        List<Carro> carrosFiltrados = new ArrayList<>();
        for (Carro carro : carros) {
            // Em vez de um 'if' hardcoded, chamamos o 'teste'
            // que recebemos como parâmetro!
            if (predicado.test(carro)) {
                carrosFiltrados.add(carro);
            }
        }
        return carrosFiltrados;
    }

    // --- 3. O JEITO MODERNO (Lambdas - Parametrização pt 02) ---
    // O Java 8 já nos dá a interface 'CarroPredicate'.
    // Ela se chama 'java.util.function.Predicate'.
    // Vamos refazer o método 'filtrar' usando a interface nativa do Java.
    
    public static List<Carro> filtrarComPredicate(List<Carro> carros, Predicate<Carro> predicado) {
        List<Carro> carrosFiltrados = new ArrayList<>();
        for (Carro carro : carros) {
            if (predicado.test(carro)) {
                carrosFiltrados.add(carro);
            }
        }
        return carrosFiltrados;
    }


    // --- O TESTE (main) ---
    public static void main(String[] args) {
        
        System.out.println("--- Jeito Antigo (Hardcoded) ---");
        System.out.println(filtrarCarrosVerdes(carros));

        
        System.out.println("\n--- Jeito Intermediário (Classe Anônima) ---");
        // Aqui, passamos o comportamento (o 'teste')
        // usando a sintaxe verbosa de classe anônima.
        List<Carro> carrosAntigos = filtrar(carros, new CarroPredicate() {
            @Override
            public boolean test(Carro carro) {
                return carro.getAno() < 2000;
            }
        });
        System.out.println(carrosAntigos);

        
        System.out.println("\n--- Jeito Moderno (Lambda!) ---");
        // O Java 8 percebe que 'Predicate' é uma interface funcional.
        // Não precisamos de toda a cerimônia da classe anônima.
        // Podemos passar SÓ O COMPORTAMENTO.
        
        // 
        // "Para cada 'carro', (->) execute a regra 'carro.getAno() < 2000'"
        List<Carro> carrosAntigosLambda = filtrarComPredicate(carros, carro -> carro.getAno() < 2000);
        
        // "Para cada 'carro', (->) execute a regra 'carro.getCor().equals("Verde")'"
        List<Carro> carrosVerdesLambda = filtrarComPredicate(carros, carro -> carro.getCor().equals("Verde"));

        System.out.println(carrosAntigosLambda);
        System.out.println(carrosVerdesLambda);
    }
}