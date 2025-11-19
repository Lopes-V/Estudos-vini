package FormatacaoDeDatas;

// Importa a classe abstrata para formatação de datas, que é sensível à localização (locale).
import java.text.DateFormat;
// Importa a classe para manipular datas e horas.
import java.util.Calendar;

public class DateFormat01 {
    // Método principal, o ponto de entrada do programa.
    public static void main(String[] args) {
        // Cria uma instância de Calendar, obtendo a data e hora atuais do sistema.
        Calendar c = Calendar.getInstance();

        // Declara e inicializa um array para armazenar 7 tipos diferentes de formatadores de data.
        DateFormat[] df = new DateFormat[7];

        // Obtém um formatador padrão para data e hora juntos (geralmente estilo SHORT).
        df[0] = DateFormat.getInstance();

        // Obtém um formatador padrão apenas para a data (geralmente estilo MEDIUM).
        df[1] = DateFormat.getDateInstance();

        // Obtém um formatador padrão para data e hora juntos (geralmente estilo MEDIUM para ambos).
        df[2] = DateFormat.getDateTimeInstance();

        // Obtém um formatador de data no estilo CURTO (ex: 23/09/25).
        df[3] = DateFormat.getDateInstance(DateFormat.SHORT);

        // Obtém um formatador de data no estilo MÉDIO (ex: 23 de set. de 2025).
        df[4] = DateFormat.getDateInstance(DateFormat.MEDIUM);

        // Obtém um formatador de data no estilo LONGO (ex: 23 de setembro de 2025).
        df[5] = DateFormat.getDateInstance(DateFormat.LONG);

        // Obtém um formatador de data no estilo COMPLETO, que é o mais detalhado (ex: terça-feira, 23 de setembro de 2025).
        df[6] = DateFormat.getDateInstance(DateFormat.FULL);

        // Inicia um loop "for-each" para percorrer cada formatador ('d') dentro do array 'df'.
        for (DateFormat d : df){
            // Dentro do loop, para cada formatador:
            // 1. c.getTime() converte o objeto Calendar para um objeto Date.
            // 2. d.format(...) usa o formatador atual para converter o objeto Date em uma String.
            // 3. System.out.println(...) imprime a String formatada no console.
            System.out.println(d.format(c.getTime()));
        }
    }
}