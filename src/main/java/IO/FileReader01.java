import java.io.File; // Importa a classe File para lidar com arquivos no sistema de arquivos.
import java.io.FileReader; // Importa a classe FileReader para ler arquivos de texto (caracteres).
import java.io.IOException; // Importa a classe IOException para tratar erros de entrada/saída.

public class FileReader01 {
    public static void main(String[] args) throws IOException {
        // 1. Cria um objeto File que representa o arquivo "file.txt".
        // O arquivo deve estar no diretório raiz do projeto para ser encontrado.
        File file = new File("file.txt");

        // 2. Usa um bloco "try-with-resources" para garantir que o FileReader seja fechado automaticamente.
        // Isso previne vazamentos de recursos. O FileReader é instanciado com o objeto File.
        try (FileReader flr = new FileReader(file)) {

            /*
             * --- Bloco de Código Comentado (Alternativa) ---
             * Este código leria os primeiros 11 caracteres do arquivo de uma só vez para dentro de um array.
             * * char[] in = new char[11]; // Cria um array de caracteres com 11 posições.
             * flr.read(in); // Lê do arquivo e preenche o array 'in'.
             * for(char c : in){ // Itera sobre o array.
             * System.out.print(c); // Imprime cada caractere, sem quebra de linha.
             * }
            */

            // 3. Declara uma variável inteira 'i' para armazenar o valor do caractere lido.
            int i;

            // 4. Inicia um loop para ler o arquivo caractere por caractere.
            // O método flr.read() lê um único caractere e retorna seu valor inteiro (código Unicode).
            // Se o final do arquivo for alcançado, o método retorna -1.
            // A condição continua o loop enquanto o valor lido for diferente de -1.
            while ((i = flr.read()) != -1) {
                // 5. Converte o valor inteiro 'i' de volta para um caractere (char) e o imprime.
                // System.out.println() imprime o caractere e adiciona uma nova linha em seguida.
                System.out.println((char) i);
            }
        } catch (IOException e) {
            // 6. Se ocorrer um erro de entrada/saída (ex: arquivo não encontrado),
            // o erro é capturado e seu rastreamento é impresso no console.
            e.printStackTrace();
        }
    }
}