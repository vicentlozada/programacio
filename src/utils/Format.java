package utils;

import classes.Configuracio;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Format {

    /**
     *
     * @param number
     * @return
     */
    public static String formatnombre1d(double number) {
        DecimalFormat nformat = new DecimalFormat(".#");
        return nformat.format(number);
    }

    /**
     *
     * @param number
     * @return
     */
    public static String formatnombre2d(double number) {
        DecimalFormat nformat = new DecimalFormat(".##");
        return nformat.format(number);
    }

    /**
     *
     * @param number
     * @return
     */
    public static String formatnombre3d(double number) {
        DecimalFormat nformat = new DecimalFormat(".###");
        return nformat.format(number);
    }

    /**
     *
     * @param number
     * @param txt
     * @return
     */
    public static String formatnombre(double number, String txt) {
        DecimalFormat nformat = new DecimalFormat();
        try {
            nformat = new DecimalFormat(txt);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return nformat.format(number);
    }

    /**
     *
     * @param moneda
     * @return
     */
    public static String formatDollar(double moneda) {
        NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.US);// Dolar
        return coin.format(moneda);
    }

    public static String formatLibra(double moneda) {
        NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.UK);// Libras
        return coin.format(moneda);
    }

    public static String formatEuro(double moneda) {
        NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.FRANCE);// Euro
        return coin.format(moneda);
    }

    /**
     *
     * @param valor
     * @param regio
     * @return
     */
    public static String formatRegio(double valor, String regio) {
        NumberFormat moneda = null;
        switch (regio) {
            case "EU":
                moneda = NumberFormat.getCurrencyInstance(Locale.FRANCE);// Euro
                break;
            case "US":
                moneda = NumberFormat.getCurrencyInstance(Locale.US);// Dolar
                break;
            case "UK":
                moneda = NumberFormat.getCurrencyInstance(Locale.UK);// Lliura
                break;
        }
        return moneda.format(valor);
    }

    /**
     *
     * @param valor
     * @param c
     * @return
     */
    public static String formatConfig(double valor, Configuracio c) {
        NumberFormat moneda = null;
        switch (c.getMoneda()) {
            case "Euro":
                moneda = NumberFormat.getCurrencyInstance(Locale.FRANCE);// Euro
                break;
            case "Dolar":
                moneda = NumberFormat.getCurrencyInstance(Locale.US);// Dolar
                break;
            case "Lliura esterlina":
                moneda = NumberFormat.getCurrencyInstance(Locale.UK);// Lliura
                break;
        }
        return moneda.format(valor);
    }

    /**
     *
     * @param valor
     * @param c
     * @return
     */
    public static String formatRegio(double valor, Configuracio c) {
        NumberFormat moneda = null;
        switch (c.getRegio()) {
            case "EU":
                moneda = NumberFormat.getCurrencyInstance(Locale.FRANCE);// Euro
                break;
            case "US":
                moneda = NumberFormat.getCurrencyInstance(Locale.US);// Dolar
                break;
            case "UK":
                moneda = NumberFormat.getCurrencyInstance(Locale.UK);// Lliura
                break;
        }
        return moneda.format(valor);
    }

    /**
     *
     * @param number
     * @param c
     * @return
     */
    public static String formatnombre(double number, Configuracio c) {
        DecimalFormat nformat = new DecimalFormat();
        switch (c.getNumdecimal()) {
            case 1:
                nformat = new DecimalFormat(".#");
                break;
            case 2:
                nformat = new DecimalFormat(".##");
                break;
            case 3:
                nformat = new DecimalFormat(".###");
                break;
        }
        return nformat.format(number);
    }
}
