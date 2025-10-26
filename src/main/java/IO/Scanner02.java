package IO;

// Importa a classe Scanner, uma ferramenta poderosa para "ler" e analisar entradas de dados.
import java.util.Scanner;

public class Scanner02 {
    public static void main(String[] args) {
        // 1. A String de entrada, com diferentes tipos de dados separados por vírgula.
        String nome = "nome,noms,noml,true,123";

        // 2. Cria uma instância do Scanner para "ler" diretamente da String 'nome'.
        //    O Scanner não serve apenas para ler do teclado, mas de qualquer fonte de dados. 📝
        Scanner scanner = new Scanner(nome);

        // 3. Define a vírgula ',' como o delimitador.
        //    Isso diz ao Scanner para considerar cada trecho entre vírgulas como um "token" separado.
        scanner.useDelimiter(",");

        // 4. O loop continua enquanto houver mais tokens para serem lidos na String.
        while (scanner.hasNext()) {

            // 5. Verifica se o PRÓXIMO token pode ser interpretado como um booleano (true/false).
            //    O método hasNext...() apenas "espia" o token, sem consumi-lo. 🔍
            if (scanner.hasNextBoolean()) {
                // Se for um booleano, o método nextBoolean() o lê (consome) e o armazena.
                boolean b = scanner.nextBoolean();
                System.out.println("Boolean: " + b);

                // 6. Se não for booleano, verifica se pode ser um número inteiro.
            } else if (scanner.hasNextInt()) {
                // Se for um inteiro, o método nextInt() o lê (consome). 🔢
                int i = scanner.nextInt();
                System.out.println("Inteiro: " + i);

                // 7. Se não for nem booleano nem inteiro, trata-o como uma String comum.
            } else {
                // O método next() lê (consome) o token como uma String.
                System.out.println(scanner.next());
            }
        }
        scanner.close();
    }
}