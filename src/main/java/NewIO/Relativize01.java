package NewIO;

// Importamos a interface que representa o caminho.
import java.nio.file.Path;
// Importamos a classe estática para criar objetos Path.
import java.nio.file.Paths;

/**
 * Classe de exemplo para demonstrar o método crucial 'relativize()'.
 * Este método calcula o caminho RELATIVO entre dois caminhos existentes.
 *
 * @author Seu Professor de TI
 */
public class Relativize01 {
    public static void main(String[] args) {

        // --- Demonstração Simples: Caminhos no Mesmo Tronco (Subdiretórios) ---

        // Caminho BASE (o ponto de partida)
        Path dir = Paths.get("/home/vinicius");
        // Caminho ALVO (o ponto de chegada)
        Path clazz = Paths.get("/home/vinicius/devDojoGood/OlaMundo.java");

        // Executando dir.relativize(clazz)
        // Significa: Qual caminho preciso para ir de '/home/vinicius' até
        // '/home/vinicius/devDojoGood/OlaMundo.java'?
        // O resultado será o que vem DEPOIS do Path base.
        Path pathToClazz = dir.relativize(clazz);
        // Saída Esperada: devDojoGood/OlaMundo.java
        System.out.println(pathToClazz);


        // --- O Grande Teste: Regras do Relativize ---

        // Definindo as variáveis para os testes
        Path absoluto1 = Paths.get("/home/vinicius");
        Path absoluto2 = Paths.get("/usr/local");
        Path absoluto3 = Paths.get("/home/vinicius/devDojoGood/OlaMundo.java");
        Path relativo1 = Paths.get("temp");
        // Nota: Seu código original nomeou esta variável como 'relativo2' mas
        // o caminho é ABSOLUTO. Isso demonstra a importância de verificar!
        Path absoluto4 = Paths.get("/home/temp.20211921");


        // 1. absoluto1.relativize(absoluto3)
        // DE: /home/vinicius PARA: /home/vinicius/devDojoGood/OlaMundo.java
        // Regra: Caminhos absolutos no mesmo tronco (root). Apenas pega a diferença.
        // Saída Esperada: 1 devDojoGood/OlaMundo.java
        System.out.println("1 " + absoluto1.relativize(absoluto3));

        // 2. absoluto3.relativize(absoluto1)
        // DE: /home/vinicius/devDojoGood/OlaMundo.java PARA: /home/vinicius
        // Regra: Precisamos SUBIR diretórios usando '..'.
        // Temos que voltar de 'OlaMundo.java' e voltar de 'devDojoGood'.
        // Saída Esperada: 2 ../..
        System.out.println("2 " + absoluto3.relativize(absoluto1));

        // 3. absoluto1.relativize(absoluto2)
        // DE: /home/vinicius PARA: /usr/local
        // Regra: Caminhos absolutos em TRONCOS DIFERENTES ('/home' vs '/usr').
        // O Java NIO.2 LANÇA uma exceção se a root (raiz) do sistema de arquivos
        // for diferente (ex: C:\ vs D:\ no Windows).
        // No Linux/Mac, se a raiz é a mesma ('/'), ele calcula subindo e descendo.
        // Vamos subir de 'vinicius' -> 'home' -> '/' e descer para '/usr/local'.
        // Saída Esperada: 3 ../../usr/local
        System.out.println("3 " + absoluto1.relativize(absoluto2));

        // 4. absoluto1.relativize(absoluto4)
        // DE: /home/vinicius PARA: /home/temp.20211921
        // Regra: Paths ABSOLUTOS e RELATIVOS não podem ser relativizados entre si.
        // Se ambos não forem absolutos, OU ambos não forem relativos, é lançado
        // uma java.lang.IllegalArgumentException (Exception in thread "main" java.lang.IllegalArgumentException).
        // Seu código original tem um erro de digitação no nome da variável, mas o caminho é absoluto.
        // Considerando o caminho: /home/vinicius -> /home/temp.20211921
        // Saída Esperada: 4 ../temp.20211921
        System.out.println("4 " + absoluto1.relativize(absoluto4));

        // 5. absoluto1.relativize(relativo1)
        // DE: /home/vinicius PARA: temp
        // Regra: Paths ABSOLUTOS e RELATIVOS não podem ser relativizados! (Mismatched Paths)
        // Este teste VAI CAUSAR um erro (java.lang.IllegalArgumentException) se executado.
        // Isso é uma regra de segurança para evitar caminhos ambíguos.
        // (Por motivos didáticos, vou deixar o código original que gera o erro.)
        System.out.println("5 " + absoluto1.relativize(relativo1));
    }
}