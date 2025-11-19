package NewIO;

import java.io.IOException; // Importa para tratamento de exceções
import java.nio.file.DirectoryStream; // Importa para iterar sobre o conteúdo de um diretório
import java.nio.file.Files; // Importa a classe Files (métodos 'newOutputStream', 'newDirectoryStream', 'copy')
import java.nio.file.Path; // Importa a interface Path
import java.nio.file.Paths; // Importa a classe Paths para criar objetos Path
import java.util.zip.ZipEntry; // Importa para representar uma entrada (arquivo) dentro do .zip
import java.util.zip.ZipOutputStream; // Importa o stream que escreve dados no formato .zip

public class ZipOutPutStream01 {
    public static void main(String[] args) {
        // Define o Path do arquivo .zip que será *criado* (o arquivo de saída).
        Path arquivoZip = Paths.get("pasta\\arquivo.zip");
        
        // Define o Path de um arquivo que está *dentRO* do diretório que queremos zipar.
        // NOTA: O nome 'arquivoParaZipar' pode ser um pouco enganoso.
        // O código não vai zipar *apenas* este arquivo, mas sim o diretório onde ele está.
        Path arquivoParaZipar = Paths.get("C:\\Users\\lopea\\Desktop\\Estudos-vini\\pasta\\SubSubPasta 1\\Arquivo.txt");
        
        // Chama o método que faz a compactação.
        zip(arquivoZip, arquivoParaZipar);
    }

    /**
     * Compacta *todo o conteúdo* do diretório pai do 'arquivoParaZipar'
     * e salva no 'arquivoZip'.
     *
     * @param arquivoZip O Path do arquivo .zip de saída (destino).
     * @param arquivoParaZipar Um Path de exemplo; o método usará o .getParent()
     * deste Path como a *origem* a ser zipada.
     */
    private static void zip (Path arquivoZip, Path arquivoParaZipar) {
        
        // 
        // Utiliza um bloco try-with-resources, que garante que ambos os "streams"
        // (zipOutputStream e o stream do diretório) sejam fechados automaticamente no final.
        try(
            // 1. Cria o stream de saída para o arquivo .zip final.
            ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));
            
            // 2. Obtém o diretório "pai" do arquivo (ex: "SubSubPasta 1") e
            //    cria um DirectoryStream para iterar sobre *todo* o conteúdo desse diretório.
            DirectoryStream<Path> stream = Files.newDirectoryStream(arquivoParaZipar.getParent())
        ) {
            
            // 3. Itera sobre cada Path (arquivo ou subpasta) encontrado dentro do diretório.
            for (Path path : stream) {
                
                // 4. Cria uma nova "entrada" no arquivo .zip.
                //    O nome da entrada será apenas o nome do arquivo (ex: "Arquivo.txt").
                //    (Nota: Este código não preserva a estrutura de subdiretórios dentro do zip).
                ZipEntry zipEntry = new ZipEntry(path.getFileName().toString());
                
                // 5. "Abre" a entrada no stream do .zip. Tudo que for escrito agora
                //    irá para *dentro* deste 'zipEntry'.
                zipOutputStream.putNextEntry(zipEntry);
                
                // 6. Copia o conteúdo do arquivo de origem (path) diretamente para
                //    o stream do .zip (que está apontando para a nova entrada).
                Files.copy(path, zipOutputStream);
                
                // 7. "Fecha" a entrada atual. Isso é obrigatório antes de
                //    chamar 'putNextEntry' para o próximo arquivo.
                zipOutputStream.closeEntry();
            }
            
            // (O try-with-resources fecha o zipOutputStream aqui, finalizando o arquivo .zip)
            System.out.println("Arquivo zipado com sucesso!");
            
        } catch (IOException e) { // (Mudado de Exception para o mais específico IOException)
            // Captura erros que podem ocorrer durante a leitura ou escrita dos arquivos.
            e.printStackTrace();
        }
    }
}