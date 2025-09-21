package FormatacaoDeDatas;

import java.text.DateFormat;
import java.util.Calendar;

public class DateFormat01 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        DateFormat[] df = new DateFormat[7];
        df[0] = DateFormat.getInstance(); //21/09/2025 12:35
        df[1] = DateFormat.getDateInstance(); //21 de set. de 2025
        df[2] = DateFormat.getDateTimeInstance(); //21 de set. de 2025 12:35:35
        df[3] = DateFormat.getDateInstance(DateFormat.SHORT); //21/09/2025
        df[4] = DateFormat.getDateInstance(DateFormat.MEDIUM); //21 de set. de 2025
        df[5] = DateFormat.getDateInstance(DateFormat.LONG); //21 de setembro de 2025
        df[6] = DateFormat.getDateInstance(DateFormat.FULL); //domingo, 21 de setembro de 2025
        for (DateFormat d : df){
            System.out.println(d.format(c.getTime()));
        }
    }
}
