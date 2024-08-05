package org.example.ra0824.controller.util;

import java.text.NumberFormat;

public final class StringUtil {
    private StringUtil() {}

    public static String formatAmountUSCurrency(final double amount) {
        final NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        return numberFormatter.format(amount);
    }

    public static String formatPercent(final int percent) {
        double decimalPercent = (percent * 1.0) / 100;
        final NumberFormat numberFormatter = NumberFormat.getPercentInstance();
        return numberFormatter.format(decimalPercent);
    }
}
