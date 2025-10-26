package Dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
// Importa a classe DateTimeFormatter, a principal ferramenta para formatar e analisar (parse) datas e horas.
import java.time.format.DateTimeFormatter;
// Importa a classe Locale, usada para especificar formatações regionais (como nomes de meses em diferentes idiomas).
import java.util.Locale;

public class DateTimeFormatter01 {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();

        // ---- Formatação: Convertendo Data/Hora para String ----
        // A classe DateTimeFormatter oferece vários formatos pré-definidos (constantes).

        // BASIC_ISO_DATE formata a data no padrão "yyyyMMdd" (sem separadores).
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        // ISO_DATE formata a data no padrão "yyyy-MM-dd".
        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        // ISO_LOCAL_DATE é similar ao ISO_DATE, formatando no padrão "yyyy-MM-dd".
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(s1); // Saída: 20250925
        System.out.println(s2); // Saída: 2025-09-25
        System.out.println(s3); // Saída: 2025-09-25

        // ---- Parse: Convertendo String para Data/Hora ----
        // O método 'parse' faz o caminho inverso, transformando uma String em um objeto de data.

        // Converte a String "20250925" para um objeto LocalDate, usando o formatador correspondente.
        LocalDate parse1 = LocalDate.parse("20250925", DateTimeFormatter.BASIC_ISO_DATE);
        // O formatador ISO_DATE é flexível e consegue analisar datas mesmo com informações de offset, extraindo apenas a parte da data.
        LocalDate parse2 = LocalDate.parse("2025-09-25+13:11", DateTimeFormatter.ISO_DATE);
        // Converte a String "2025-09-25" para um objeto LocalDate.
        LocalDate parse3 = LocalDate.parse("2025-09-25", DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(parse1);
        System.out.println(parse2);
        System.out.println(parse3);

        // ---- Formatando e fazendo Parse de LocalDateTime ----
        LocalDateTime now = LocalDateTime.now();
        // ISO_DATE_TIME formata data e hora no padrão "yyyy-MM-dd'T'HH:mm:ss.SSSSSS".
        String s4 = now.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(s4);

        // Faz o parse de uma String de data e hora completa para um objeto LocalDateTime.
        LocalDateTime parse4 = LocalDateTime.parse("2025-09-25T13:12:49.257272", DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(parse4);

        // ---- Criando Formatadores Personalizados com ofPattern() ----

        // Cria um formatador com um padrão customizado para o formato de data brasileiro.
        // dd = dia do mês, MM = mês do ano, yyyy = ano com 4 dígitos.
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Formata a data atual usando o padrão brasileiro.
        String formatBR = LocalDate.now().format(formatterBR);
        System.out.println(formatBR); // Saída: 25/09/2025

        // Usa o mesmo formatador para converter uma String no formato brasileiro para um objeto LocalDate.
        LocalDate parseBr = LocalDate.parse("19/02/2021", formatterBR);
        System.out.println(parseBr);

        // ---- Formatadores Personalizados com Localização (Locale) ----

        // Cria um formatador para o padrão alemão, especificando o Locale.
        // MMMM = nome completo do mês. O Locale.GERMAN garante que o nome do mês será em alemão.
        DateTimeFormatter formatterGR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.GERMAN);
        // Formata a data atual. "September" será escrito em alemão.
        String formatGR = LocalDate.now().format(formatterGR);
        System.out.println(formatGR); // Saída: 25.September.2025

        // Para fazer o parse de uma String com o nome do mês em alemão, é essencial usar o formatador com o Locale correto.
        LocalDate parseGR = LocalDate.parse("19.Februar.2025", formatterGR);
        System.out.println(parseGR);
    }
}