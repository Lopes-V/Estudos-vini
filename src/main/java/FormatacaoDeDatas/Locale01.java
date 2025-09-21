package FormatacaoDeDatas;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Locale01 {
    public static void main(String[] args) {
        // Cria objetos Locale para diferentes países e idiomas
        Locale localiItaly = new Locale( "it","IT"); // Itália (idioma: italiano)
        Locale localiSuica = new Locale( "it","CH"); // Suíça (idioma: italiano)
        Locale localIndia = new Locale("hi", "IN"); // Índia (idioma: hindi)
        Locale localJapao = new Locale("ja", "JP"); // Japão (idioma: japonês)
        Locale localHolanda = new Locale("nl", "NL"); // Holanda (idioma: holandês)

        Calendar calendar = Calendar.getInstance(); // Obtém a data e hora atuais do sistema

        // Cria formatadores de data em formato "FULL" para cada localidade
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, localiItaly); // Formato completo para Itália
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, localiSuica); // Formato completo para Suíça (idioma italiano)
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, localIndia);  // Formato completo para Índia
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, localJapao);  // Formato completo para Japão
        DateFormat df5 = DateFormat.getDateInstance(DateFormat.FULL, localHolanda); // Formato completo para Holanda

        // Formata e imprime a data atual de acordo com as diferentes localidades
        System.out.println("Italy: "+ df1.format(calendar.getTime())); // Exemplo: domenica 21 settembre 2025
        System.out.println("Suiça: "+ df2.format(calendar.getTime()));
        System.out.println("India: "+ df3.format(calendar.getTime()));
        System.out.println("Japao: "+ df4.format(calendar.getTime()));
        System.out.println("Holanda: "+ df5.format(calendar.getTime()));

        // Imprime informações de exibição das localidades
        System.out.println(localiItaly.getDisplayCountry()); // Imprime o nome do país da localidade
        System.out.println(localHolanda.getDisplayName()); // Imprime o nome completo da localidade (país e idioma)
        System.out.print(localHolanda.getDisplayLanguage()); // Imprime apenas o nome do idioma da localidade
    }
}