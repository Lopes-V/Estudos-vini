package Dates;

import java.util.Calendar;
import java.util.Date;

public class Calendar01 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        if(c.getFirstDayOfWeek() == Calendar.SUNDAY){
            System.out.println("Hoje é domingo");
        }
        System.out.println(c.get(Calendar.WEEK_OF_MONTH));// Semana do mes
        System.out.println(c.get(Calendar.DAY_OF_MONTH));// Dia do mes
        System.out.println(c.get(Calendar.DAY_OF_WEEK)); //Dia da semana
        System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));// Dia da semana e mes
        System.out.println(c.get(Calendar.DATE));

        c.add(Calendar.DAY_OF_WEEK, 3);
        c.roll(Calendar.HOUR, 20);
        Date date = c.getTime();
        System.out.println(date);
        System.out.println();
    }
}
