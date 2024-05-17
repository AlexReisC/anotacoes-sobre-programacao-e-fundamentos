package DataHora.formatacao;

import java.util.Locale;
import java.text.DateFormat;
import java.util.Calendar;

public class LocaleTest01 {
    public static void main(String[] args) {
        @SuppressWarnings("deprecation")
        Locale localeItaly = new Locale("it", "IT");
        @SuppressWarnings("deprecation")
        Locale localeJapan = new Locale("ja", "JP");
        @SuppressWarnings("deprecation")
        Locale localeNettherlands = new Locale("nl", "NL");
        @SuppressWarnings("deprecation")
        Locale localeIndia = new Locale("hi", "IN");

        Calendar calendar = Calendar.getInstance();
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, localeJapan);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, localeNettherlands);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, localeIndia);
        
        System.out.println("Italy " + df1.format(calendar.getTime()));
        System.out.println("Japan " + df2.format(calendar.getTime()));
        System.out.println("Nettherlands " + df3.format(calendar.getTime()));
        System.out.println("India " + df4.format(calendar.getTime()));

        System.out.println(localeItaly.getDisplayCountry());
        System.out.println(localeNettherlands.getDisplayCountry());
    }
}
