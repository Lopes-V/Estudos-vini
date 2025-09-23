package FormatacaoDeDatas;

// Importa a classe para formatação de datas.
import java.text.DateFormat;
// Importa a classe para manipular datas e horas.
import java.util.Calendar;
// Importa a classe para representar uma região/cultura específica.
import java.util.Locale;

public class Locale01 {
    // Método principal, ponto de entrada do programa.
    public static void main(String[] args) {
        // --- Passo 1: Criação de objetos Locale ---
        // Um Locale é criado com um código de idioma (minúsculo) e um código de país (maiúsculo).
        // Ex: new Locale("idioma", "PAÍS");

        // Cria um Locale para o idioma italiano ("it") na Itália ("IT").
        Locale localiItaly = new Locale("it", "IT");
        // Cria um Locale para o idioma italiano ("it") na Suíça ("CH"). Demonstra que um mesmo idioma pode ser usado em diferentes países.
        Locale localiSuica = new Locale("it", "CH");
        // Cria um Locale para o idioma hindi ("hi") na Índia ("IN").
        Locale localIndia = new Locale("hi", "IN");
        // Cria um Locale para o idioma japonês ("ja") no Japão ("JP").
        Locale localJapao = new Locale("ja", "JP");
        // Cria um Locale para o idioma holandês ("nl") na Holanda ("NL").
        Locale localHolanda = new Locale("nl", "NL");

        // Obtém a data e hora atuais do sistema.
        Calendar calendar = Calendar.getInstance();

        // --- Passo 2: Criação de formatadores de data para cada Locale ---
        // DateFormat.getDateInstance(estilo, locale) cria um formatador para a localidade especificada.
        // O estilo DateFormat.FULL é o mais completo, geralmente incluindo o dia da semana.

        // Cria um formatador de data completo para a Itália.
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, localiItaly);
        // Cria um formatador de data completo para a Suíça, usando as convenções do idioma italiano.
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, localiSuica);
        // Cria um formatador de data completo para a Índia.
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, localIndia);
        // Cria um formatador de data completo para o Japão.
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, localJapao);
        // Cria um formatador de data completo para a Holanda.
        DateFormat df5 = DateFormat.getDateInstance(DateFormat.FULL, localHolanda);

        // --- Passo 3: Formatação e impressão da data atual ---
        // O método format() converte o objeto Date (obtido com calendar.getTime()) em uma String formatada.

        // Imprime a data atual formatada para a Itália.
        System.out.println("Italy: " + df1.format(calendar.getTime()));
        // Imprime a data atual formatada para a Suíça.
        System.out.println("Suiça: " + df2.format(calendar.getTime()));
        // Imprime a data atual formatada para a Índia.
        System.out.println("India: " + df3.format(calendar.getTime()));
        // Imprime a data atual formatada para o Japão.
        System.out.println("Japao: " + df4.format(calendar.getTime()));
        // Imprime a data atual formatada para a Holanda.
        System.out.println("Holanda: " + df5.format(calendar.getTime()));

        // --- Passo 4: Exibição de informações sobre os Locales ---
        // Os métodos getDisplay... retornam nomes legíveis para humanos.

        // Imprime o nome do país do Locale (Itália), no idioma da sua localidade padrão (ex: "Itália" em um sistema pt-BR).
        System.out.println(localiItaly.getDisplayCountry());
        // Imprime o nome completo do Locale (idioma e país), também no idioma padrão. Ex: "holandês (Holanda)".
        System.out.println(localHolanda.getDisplayName());
        // Imprime apenas o nome do idioma do Locale. Ex: "holandês".
        System.out.print(localHolanda.getDisplayLanguage());
    }
}