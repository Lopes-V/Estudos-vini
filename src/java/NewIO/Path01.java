package NewIO; // Define o pacote onde a classe está localizada.

import java.nio.file.Path; // Importa a interface 'Path', que representa o caminho de um arquivo ou diretório no sistema de arquivos.
import java.nio.file.Paths; // Importa a classe 'Paths', que é uma classe de fábrica (factory) usada para criar objetos 'Path'.

public class Path01 {
    public static void main(String[] args) {
        // --- Demonstração de diferentes formas de criar um objeto Path ---

        // Forma 1: Usando uma única String com o caminho completo.
        // As barras invertidas (\) precisam ser escapadas com outra barra invertida (\\) dentro de uma String em Java.
        Path path1 = Paths.get("C:\\Users\\User\\Desktop\\file.txt");

        // Forma 2: Usando uma sequência de Strings (varargs).
        // O método 'get' junta as partes com o separador de arquivos apropriado para o sistema operacional.
        // Esta forma é mais portável e evita problemas com caracteres de escape.
        Path path2 = Paths.get("C:","Users","User","Desktop","file.txt");

        // Forma 3: Similar à forma 2, mas incluindo os separadores nas próprias strings.
        // O método 'get' é inteligente o suficiente para normalizar o caminho e remover separadores redundantes.
        Path path3 = Paths.get("C:", "\\Users", "\\User", "\\Desktop", "\\file.txt");

        // --- Utilizando o método getFileName() ---

        // O método getFileName() retorna o nome do arquivo ou o último diretório na sequência do caminho.
        // Imprime o nome do arquivo do primeiro caminho. Saída esperada: file.txt
        System.out.println(path1.getFileName());

        // Imprime o nome do arquivo do segundo caminho. Saída esperada: file.txt
        System.out.println(path2.getFileName());

        // Imprime o nome do arquivo do terceiro caminho. Saída esperada: file.txt
        System.out.println(path3.getFileName());

        // O resultado para os três será o mesmo, mostrando que todas as formas de criação resultaram em um objeto Path equivalente.
    }
}