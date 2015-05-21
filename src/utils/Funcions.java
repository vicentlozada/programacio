package utils;

import classes.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import static javafx.beans.binding.Bindings.length;

public class Funcions {

    /**
     * constant per a les lletres del NIF/NIE
     */
    public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";

    /**
     * Devuelve un NIF completo a partir de un DNI. Es decir, a�ade la letra del
     * NIF
     *
     * @param dni dni al que se quiere a�adir la letra del NIF
     * @return NIF completo.
     */
    public static String nif(int dni) {
        return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
    }

    /**
     * Retorna la lletra d'un NIF/NIE a partir d'un DNI o un NIE sense lletra
     *
     * @param dni al qual es vol afegir la letra del NIF/NIE
     * @return lletra
     */
    public static char nifnie(int dni) {
        return NIF_STRING_ASOCIATION.charAt(dni % 23);
    }

    /**
     *
     * @param dni
     * @return
     */
    public static String nifnie(String dni) {
        String dnitemp = dni.toUpperCase();
        dnitemp = dni.substring(0, 8);
        String dnitemp2 = dnitemp;
        char c = (dnitemp.toUpperCase()).charAt(0);
        switch (c) {
            case 'X':
                dnitemp = dnitemp.replace("X", "0");
                break;
            case 'Y':
                dnitemp = dnitemp.replace("Y", "1");
                break;
            case 'Z':
                dnitemp = dnitemp.replace("Z", "2");
                break;
        }
        dnitemp2 = dnitemp2 + nifnie(Integer.parseInt(dnitemp));
        return dnitemp2;
    }

    /**
     *
     * @param num
     * @return
     */
    public static boolean demanafloat(String num) {
        float i = 0.0f;
        boolean val = false;
        try {
            i = Float.parseFloat(num);
            val = true;
        } catch (Exception e) {
            val = false;
        }
        return val;
    }

    /**
     *
     * @param longitud
     * @return
     */
    public static String getCadenaAleatoria1(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    /**
     *
     * @param longitud
     * @return
     */
    public static String getCadenaAleatoria2(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    public static String getCadenaAleatoria3(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c == '$') || (c == '_')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    /**
     * retorna una cadena aleatòria de dni vàlid - per a omplir els dnis en els
     * Dummies
     *
     * @return
     */
    public static String getCadenaAleatoriaDni() {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        while (cadenaAleatoria.length() < 9) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9')) {
                cadenaAleatoria += c;
            }

        }
        return nifnie(cadenaAleatoria);
    }

    /**
     * retorna un valor amb 2 decimals entre n i m - per a omplir salaris
     * aleatoris en Dummies
     *
     * @param n
     * @param m
     * @return
     */
    public static float getCadenaAleatoriaSalari(int n, int m) {
        float valorAleatori = (float) (Math.random() * (n - m) + m);

        return (float) Math.rint(valorAleatori * 100) / 100;
    }

    /**
     * retorna 2 dates aleatòries entre d1 i d2 - per a omplir data naixement i
     * data contratació en Dummies
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Data getData(String d1, String d2) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date ddesde = null;
        Date dhasta = null;

        try {
            ddesde = df.parse(d1);
            dhasta = df.parse(d2);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        long ldesde = ddesde.getTime();
        long lhasta = dhasta.getTime();
        long randlimit = lhasta - ldesde;

        Double newmilis = new Double(ldesde + (Math.random() * randlimit)); //A la fecha de origen le sumamos el calculo aleatorio.
        Date randomDate = new Date(newmilis.longValue());

        return new Data(randomDate);

    }

}
