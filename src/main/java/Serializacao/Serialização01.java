package Serializacao;

import java.io.FileOutputStream; // (Esta importação não está sendo usada no código)
import java.io.IOException; // Importa para tratar exceções de I/O (Entrada/Saída).
import java.io.ObjectInput; // (Esta importação não está sendo usada no código)
import java.io.ObjectInputStream; // Importa o stream usado para LER objetos (deserializar).
import java.io.ObjectOutputStream; // Importa o stream usado para ESCREVER objetos (serializar).
import java.nio.file.Files; // Importa a classe Files (para 'newOutputStream' e 'newInputStream').
import java.nio.file.Paths; // Importa a classe Paths (para criar objetos Path).

import Serializacao.Dominio.Aluno; // Importa a classe de domínio.
                                  // **IMPORTANTE**: A classe 'Aluno' DEVE implementar a interface 'java.io.Serializable'
                                  // para que este código funcione.

public class Serialização01 {
    public static void main(String[] args) {
        // 1. Cria uma instância do objeto 'Aluno' em memória RAM.
        Aluno aluno = new Aluno(1L, "Ana", "12345");
        
        // 2. Chama o método para "congelar" (serializar) o estado deste objeto e salvá-lo em disco.
        serializar(aluno);
        
        // 3. Chama o método para "descongelar" (deserializar) o objeto, lendo-o do disco
        //    de volta para uma nova instância na memória.
        deserializar();
    }

    /**
     * Serializa um objeto Aluno, salvando seu estado em um arquivo binário.
     * @param aluno O objeto a ser salvo.
     */
    // 
    private static void serializar(Aluno aluno) {
        // Usa um try-with-resources para garantir que o 'ObjectOutputStream' (oos)
        // seja fechado automaticamente no final.
        try(ObjectOutputStream oos = new ObjectOutputStream((Files.newOutputStream(Paths.get("Aluno.ser")))) ){
            // A linha acima cria uma "cadeia" de streams:
            // 1. Paths.get("Aluno.ser"): Define o arquivo de destino (a extensão .ser é uma convenção).
            // 2. Files.newOutputStream(...): Cria um fluxo de saída (OutputStream) para o arquivo.
            // 3. new ObjectOutputStream(...): "Envolve" o fluxo de saída com um stream
            //    especializado em converter objetos Java em uma sequência de bytes.
            
            // O comando principal: escreve o objeto 'aluno' no stream (e, portanto, no arquivo).
            oos.writeObject(aluno);
            
        } catch (IOException e) {
            // Captura erros de I/O (ex: falta de permissão para escrever no disco).
            e.printStackTrace();
        }
    }

    /**
     * Deserializa um objeto Aluno, lendo seu estado de um arquivo binário.
     */
    private static void deserializar() {
        // Usa um try-with-resources para garantir que o 'ObjectInputStream' (ois)
        // seja fechado automaticamente.
        try(ObjectInputStream ois = new ObjectInputStream((Files.newInputStream(Paths.get("Aluno.ser")))) ){
            // A "cadeia" reversa:
            // 1. Paths.get("Aluno.ser"): Aponta para o arquivo que foi salvo.
            // 2. Files.newInputStream(...): Cria um fluxo de entrada (InputStream) para ler o arquivo.
            // 3. new ObjectInputStream(...): "Envolve" o fluxo de entrada com um stream
            //    especializado em converter uma sequência de bytes de volta em um objeto Java.

            // O comando principal:
            // 1. ois.readObject(): Lê os bytes e reconstrói o objeto na memória.
            //    (Este método retorna um 'Object' genérico).
            // 2. (Aluno): É necessário fazer o "cast" (conversão) do 'Object'
            //    de volta para o seu tipo original ('Aluno').
            Aluno aluno = (Aluno) ois.readObject();
            
            // Imprime o objeto restaurado (deve ter os mesmos dados: 1L, "Ana", "12345").
            System.out.println(aluno);
            
        } catch (IOException | ClassNotFoundException e) {
            // Captura dois tipos principais de exceção:
            // 1. IOException: Se houver um erro de I/O (arquivo não encontrado, arquivo corrompido).
            // 2. ClassNotFoundException: Se o programa (classpath) não tiver a definição da
            //    classe 'Aluno.class', o Java não saberá como "remontar" o objeto.
            e.printStackTrace();
        }
    }
}