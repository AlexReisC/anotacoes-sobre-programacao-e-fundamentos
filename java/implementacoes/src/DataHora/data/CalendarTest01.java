package DataHora.data;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest01 {
    public static void main(String[] args) {
        // A classe calendar nã tem implementação. Mais uma classe depreciada.
        Calendar c = Calendar.getInstance();        
        if(c.getFirstDayOfWeek() == Calendar.SUNDAY){
            System.out.println("Dominguera é nois");
        }
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        
        c.add(Calendar.DAY_OF_MONTH, 2);
        c.roll(Calendar.HOUR, 12); // evita mudar de dia caso passe um valor grande
        Date date  = c.getTime();
        System.out.println(date);
    }
}
