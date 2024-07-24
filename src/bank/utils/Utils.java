package bank.utils;

import java.text.DecimalFormat;

public class Utils {
    // TODO: implement brazilian formaterr
    public static DecimalFormat df = new DecimalFormat("0.00");

    public static String formatBrazillianCurrency(double value) {
        return "R$ " + df.format(value);
    }

}
