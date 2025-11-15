package Exercicios;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ExercicioDate {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // --- Demonstração da API Legada (Calendar, Date, DateFormat) ---
        
        // Pega uma instância do Calendar com a data e hora atuais.
        Calendar calendar = Calendar.getInstance(); 
        
        // Pega e imprime apenas o dia do mês do objeto Calendar.
        System.out.println("Dia do mês: " + calendar.get(calendar.DAY_OF_MONTH));
        
        // Adiciona 10 horas ao objeto 'calendar'. OBS: Essa modificação não é usada em nenhum lugar depois.
        calendar.add(calendar.HOUR_OF_DAY, 10); 
        
        // Cria um novo objeto Date, também com a data e hora atuais.
        Date agora = new Date(); 
        
        // Define o Locale para Português do Brasil, para formatação correta.
        Locale localeBR = new Locale("pt", "BR"); 
        
        // Cria um formatador de data no estilo CURTO (ex: 23/09/25) para o Brasil.
        DateFormat dataBR = DateFormat.getDateInstance(DateFormat.SHORT, localeBR); 
        
        // Formata e imprime a data atual usando o estilo CURTO.
        System.out.println("Formatador Curto (BR) : " + dataBR.format(agora));
        
        // Cria um formatador de data no estilo LONGO (ex: 23 de setembro de 2025) para o Brasil.
        DateFormat formatadorLongo = DateFormat.getDateInstance(DateFormat.LONG, localeBR); 
        
        // Formata e imprime a data atual usando o estilo LONGO.
        System.out.println("Formato Longo (BR): " + formatadorLongo.format(agora));
        
        // Cria um formatador de data no estilo MÉDIO (ex: 23 de set. de 2025) para o Brasil.
        DateFormat formatadorMedio = DateFormat.getDateInstance(DateFormat.MEDIUM, localeBR); 
        
        // Formata e imprime a data atual usando o estilo MÉDIO.
        System.out.println("Formatador Médio (BR): " + formatadorMedio.format(agora));
        
        // --- Cálculo de Idade com a API Moderna (java.time) ---
        
        System.out.println("Insira a sua data de nascimento: ");
        String dataNascimento = sc.nextLine();
        
        // Define a data máxima permitida como hoje. ChronoLocalDate é uma visão mais abstrata de LocalDate.
        ChronoLocalDate dataMaxima = LocalDate.now(); 
        
        // Define uma data mínima permitida como 01/01/1950.
        ChronoLocalDate dataMinima = LocalDate.of(1950, 1, 1); 
        
        // Converte a String digitada para um objeto LocalDate.
        // ATENÇÃO: Isso espera o formato "AAAA-MM-DD". Pode dar erro se o usuário digitar "DD/MM/YYYY".
        LocalDate dataN = LocalDate.parse(dataNascimento); 
        
        // Verifica se a data de nascimento está dentro do intervalo permitido.
        if (dataN.isBefore(dataMaxima) && dataN.isAfter(dataMinima)) {
            // Pega a data atual novamente.
            LocalDate dataAgora = LocalDate.now(); 
            
            // Calcula o TOTAL de anos entre as duas datas. (Isso está correto).
            Long idade = ChronoUnit.YEARS.between(dataN, dataAgora); 
            
            // Calcula o TOTAL de meses entre as duas datas. (Ex: para 2 anos, isso dará 24+ meses).
            Long meses = ChronoUnit.MONTHS.between(dataN, dataAgora);
            
            // Loop para tentar ajustar os meses, subtraindo 12 até que sobrem menos de 12.
            if (meses >= 12) {
                do {
                    meses -= 12L;
                } while (meses >= 12);
            }
            
            // Calcula o TOTAL de dias entre as duas datas. (Ex: para 1 ano, isso dará 365+ dias).
            Long dias = ChronoUnit.DAYS.between(dataN, dataAgora);
            
            // Loop para tentar ajustar os dias. ATENÇÃO: Isso é incorreto, pois assume que todo mês tem 30 dias.
            if (dias >= 30) {
                do {
                    dias -= 30L;
                } while (dias >= 30L);
            }
            
            System.out.println("Sua Idade é: " + idade + " anos " + meses + " meses e " + dias + " dias.");
        } else {
            System.out.println("Data errada");
        }
    }
}