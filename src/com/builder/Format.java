package com.builder;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.regex.Pattern;

public class Format {
    private DecimalFormat format;
    private String currency;

    public Format() {
        this.currency = "$";
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(',');
        String variable = "###,###,##0.00";
        variable.concat("00");
        format = new DecimalFormat(variable,symbols);
    }

    public String setValue(Double numero){
        return currency + " " + format.format(numero);
    }

    public String setValue(String numero) {
        String regex = "^[0-9]+(.[0-9]+)?$";
        if (Pattern.matches(regex, numero)) {
            return this.setValue(Double.parseDouble(numero));
        } else {
            return "No se puede convertir a double";
        }
    }
}
