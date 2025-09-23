package FormatacaoDeDatas;

// Importa a classe SimpleDateFormat, que é usada para formatar e analisar datas de maneira personalizada.
import java.text.SimpleDateFormat;
// Importa a classe Date, que representa um instante específico no tempo.
import java.util.Date;

public class SimpleDateFormat01 {
    // Método principal, o ponto de entrada para a execução do programa.
    public static void main(String[] args) {
        // Define o padrão de como a data será formatada.
        // 'Brasil' e 'de' -> Textos que aparecerão exatamente como estão escritos.
        // d -> Representa o dia do mês em número (ex: 23).
        // MMMM -> Representa o nome completo do mês (ex: setembro).
        // y -> Representa o ano (ex: 2025).
        String pattern = "'Brasil' d 'de' MMMM 'de' y";

        // Cria um objeto (instância) de SimpleDateFormat, passando o padrão definido acima.
        // Este objeto "sabe" como converter uma data para o formato desejado.
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        // 1. 'new Date()' cria um objeto com a data e hora atuais.
        // 2. 'sdf.format(...)' usa o formatador para transformar a data atual em uma String, seguindo o padrão.
        // 3. 'System.out.println(...)' imprime a String resultante no console.
        // Exemplo de saída: Brasil 23 de setembro de 2025
        System.out.println(sdf.format(new Date()));
    }
}