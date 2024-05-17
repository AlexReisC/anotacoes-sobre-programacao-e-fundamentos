package DataHora.formatacao;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest02 {
    public static void main(String[] args) {
        Locale localeBR = Locale.getDefault();
        Locale localeJP = Locale.JAPAN;
        Locale localeFR = Locale.FRANCE;
        
        NumberFormat[] nfa = new NumberFormat[3];
        nfa[0] = NumberFormat.getCurrencyInstance(localeBR);
        nfa[1] = NumberFormat.getCurrencyInstance(localeJP);
        nfa[2] = NumberFormat.getCurrencyInstance(localeFR);
        double valor = 10_000.2130;
        for (NumberFormat numberFormat : nfa) {
            System.out.println(numberFormat.format(valor));
        }
    }
}
