// Importa a classe File, usada para representar um arquivo ou diretório no sistema.
import java.io.File;
// Importa a classe FileWriter, usada para escrever caracteres em um arquivo.
import java.io.FileWriter;
// Importa a classe IOException, para tratar exceções que podem ocorrer durante operações de entrada/saída.
import java.io.IOException;

// O nome da classe tem um pequeno erro de digitação, "FIleWriter" em vez de "FileWriter".
public class FIleWriter01 {
    public static void main(String[] args) {
        // 1. Cria um objeto File que representa o arquivo "file.txt" no diretório atual.
        //    Isso ainda não cria ou abre o arquivo, apenas o representa em memória.
        File file = new File("file.txt");

        // 2. Usa um bloco "try-with-resources". Esta é a forma moderna e segura de trabalhar com recursos
        //    que precisam ser fechados (como arquivos). O 'FileWriter' (fw) será fechado automaticamente
        //    no final do bloco, mesmo que ocorra um erro.
        try (FileWriter fw = new FileWriter(file, true)) {
            // A parte 'new FileWriter(file, true)' faz duas coisas importantes:
            // - 'file': Especifica o arquivo no qual queremos escrever.
            // - 'true': Este é o argumento 'append' (anexar). Quando 'true', o novo texto
            //           será adicionado AO FINAL do arquivo existente. Se fosse 'false' ou
            //           omitido, o conteúdo do arquivo seria apagado antes de escrever.

            // 3. Escreve a string "Borba" seguida de um caractere de nova linha (\n) no buffer do escritor.
            //    Neste ponto, o texto pode estar apenas na memória, não necessariamente no disco.
            fw.write("Borba\n");

            // 4. Garante que o conteúdo do buffer seja gravado no arquivo físico no disco.
            //    É como "descarregar" o que está na memória para o destino final. ✍️
            fw.flush();

        } catch (IOException e) {
            // 5. Se ocorrer um erro durante a criação, escrita ou fechamento do arquivo
            //    (ex: falta de permissão, disco cheio), uma IOException será capturada.
            //    Aqui, ela é relançada como uma RuntimeException.
            throw new RuntimeException(e);
        }
    }
}