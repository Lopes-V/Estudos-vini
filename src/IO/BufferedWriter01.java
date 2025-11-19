package IO;

import java.io.*; // Importa as classes necessárias para manipulação de arquivos (Entrada/Saída).

public class BufferedWriter01 {
    public static void main(String[] args) {
        // Cria um objeto File que representa o arquivo "file.txt" no diretório do projeto.
        File file = new File("file.txt");

        // Utiliza um bloco try-with-resources, que garante que o FileWriter e o BufferedWriter
        // sejam fechados automaticamente ao final do bloco, mesmo que ocorram exceções.
        try (FileWriter flr = new FileWriter(file, true)) { // Cria um FileWriter para escrever no arquivo. O 'true' indica o modo "append" (acréscimo),
            // ou seja, o novo conteúdo será adicionado ao final do arquivo, sem apagar o que já existe.

            // Envolve o FileWriter em um BufferedWriter. Isso melhora o desempenho ao agrupar
            // as operações de escrita em um buffer, reduzindo o número de acessos diretos ao disco.
            BufferedWriter br = new BufferedWriter(flr);

            // Escreve um separador de linha no arquivo. É a forma mais portável (independente do sistema operacional) de pular uma linha.
            br.newLine();

            // Escreve a string "Faz o L" no buffer.
            br.write("Faz o L");

            // Garante que todos os dados que estão no buffer sejam imediatamente escritos no arquivo.
            // Embora o 'close()' (chamado automaticamente pelo try-with-resources) também chame o flush(),
            // usá-lo explicitamente assegura que os dados sejam gravados naquele exato momento.
            br.flush();

        } catch (IOException e) {
            // Captura qualquer exceção de Entrada/Saída (IOException) que possa ocorrer durante a manipulação do arquivo.
            // Por exemplo, se o arquivo não puder ser criado ou se não houver permissão de escrita.
            e.printStackTrace(); // Imprime o rastreamento da pilha da exceção no console, o que ajuda a identificar o erro.
        }
    }
}