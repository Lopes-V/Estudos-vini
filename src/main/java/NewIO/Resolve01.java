// Definimos o pacote (package) onde esta classe reside.
package NewIO;

// Novamente, importamos as classes que precisamos do pacote java.nio.file.
// 'Path' é a interface que representa um caminho.
import java.nio.file.Path;
// 'Paths' é a classe "fábrica" que usamos para criar objetos 'Path'.
import java.nio.file.Paths;

/**
 * Classe de exemplo para demonstrar o método 'resolve()'.
 * Este é um dos métodos mais importantes (e às vezes confusos) da interface Path.
 */
public class Resolve01 {

    public static void main(String[] args) {

        // --- Demonstração Inicial (ignorada pelos prints, mas bom exemplo) ---

        // Criamos um Path RELATIVO (não começa com / ou C:/)
        Path dir = Paths.get("home/vinicius");
        // Criamos outro Path RELATIVO
        Path arquivo = Paths.get("dev/arquivo.txt");

        // O método 'resolve()' JUNTA os dois caminhos.
        // Pense assim: "a partir de 'dir', resolva o caminho para 'arquivo'".
        // Como 'arquivo' é relativo, ele é simplesmente anexado ao 'dir'.
        // O resultado em 'resolve' seria: "home/vinicius/dev/arquivo.txt"
        Path resolve = dir.resolve(arquivo);
        // System.out.println(resolve); // Se imprimíssemos isso, veríamos a junção.


        // --- O Grande Teste: Absoluto vs. Relativo ---

        // Agora, vamos criar os Paths que realmente usaremos nos testes.

        // 1. Um Path ABSOLUTO. No Linux/Mac, começa com "/".
        //    No Windows, começaria com algo como "C:/".
        Path absoluto = Paths.get("/home/vinicius");

        // 2. Um Path RELATIVO.
        Path relativo = Paths.get("dev");

        // 3. Outro Path RELATIVO, representando um arquivo.
        Path file = Paths.get("file.txt");


        // --- Analisando cada 'resolve()' ---

        // Turma, aqui está a REGRA DE OURO do resolve():
        // path1.resolve(path2)
        //
        // 1. Se 'path2' for ABSOLUTO: O resultado é SIMPLESMENTE 'path2'. O 'path1' é ignorado.
        // 2. Se 'path2' for RELATIVO:  O resultado é 'path1' + 'path2'. (Eles são juntados).
        //
        // Vamos testar isso!


        // Teste 1: absoluto.resolve(relativo)
        // 'absoluto' = /home/vinicius
        // 'relativo' = dev
        // O argumento ('dev') é RELATIVO, então JUNTAMOS.
        // Saída Esperada: 1 /home/vinicius/dev
        System.out.println("1 " + absoluto.resolve(relativo));

        // Teste 2: absoluto.resolve(file)
        // 'absoluto' = /home/vinicius
        // 'file' = file.txt
        // O argumento ('file.txt') é RELATIVO, então JUNTAMOS.
        // Saída Esperada: 2 /home/vinicius/file.txt
        System.out.println("2 " + absoluto.resolve(file));

        // Teste 3: relativo.resolve(absoluto)
        // 'relativo' = dev
        // 'absoluto' = /home/vinicius
        // O argumento ('/home/vinicius') é ABSOLUTO, então ele SUBSTITUI.
        // O 'relativo' ("dev") é totalmente ignorado.
        // Saída Esperada: 3 /home/vinicius
        System.out.println("3 " + relativo.resolve(absoluto));

        // Teste 4: relativo.resolve(file)
        // 'relativo' = dev
        // 'file' = file.txt
        // O argumento ('file.txt') é RELATIVO, então JUNTAMOS.
        // Saída Esperada: 4 dev/file.txt
        System.out.println("4 " + relativo.resolve(file));

        // Teste 5: file.resolve(absoluto)
        // 'file' = file.txt
        // 'absoluto' = /home/vinicius
        // O argumento ('/home/vinicius') é ABSOLUTO, então ele SUBSTITUI.
        // O 'file' ("file.txt") é totalmente ignorado.
        // Saída Esperada: 1 /home/vinicius (o '1' foi copiado do seu código)
        System.out.println("1 " + file.resolve(absoluto));

        // Teste 6: file.resolve(relativo)
        // 'file' = file.txt
        // 'relativo' = dev
        // O argumento ('dev') é RELATIVO, então JUNTAMOS.
        // Saída Esperada: 2 file.txt/dev (o '2' foi copiado do seu código)
        System.out.println("2 " + file.resolve(relativo));

        // Resumo da aula:
        // O método resolve() é perfeito para criar caminhos completos.
        // Ex: (Path para a pasta de logs).resolve("log-de-hoje.txt")
        // Mas CUIDADO: se o caminho que você passar já for absoluto,
        // ele "ganha" e substitui o caminho original.
    }
}