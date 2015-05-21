package utils;

import main.Core;

public class Validate {

    /**
     *
     * @param email
     * @return
     */
    public static boolean isValidFormatEmailAddress(String email) {
        String emailPattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        return email.matches(emailPattern);
    }

    /**
     *
     * @param url
     * @return
     */
    public static boolean isValidFormatUrl(String url) {
        String urlPattern = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        return url.matches(urlPattern);
    }

    /**
     *
     * @param data
     * @return
     */
    public static boolean isValidFormatData(String data) {
        // String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
        String dataPattern = "";

        switch (Core.conf.getFormatdata()) {
            case 0: // dd/MM/yyyy
                dataPattern = "^(([0-2]?\\d)|([3][0-1]))\\/(([0]?\\d)|([1][0-2]))\\/(\\d{4})$";
                break;
            case 1: // dd-MM-yyyy
                dataPattern = "^(([0-2]?\\d)|([3][0-1]))\\-(([0]?\\d)|([1][0-2]))\\-(\\d{4})$";
                break;
            case 2: // MM/dd/yyyy
                dataPattern = "^(0?[1-9]|1[012])[/](0?[1-9]|[12][0-9]|3[01])[/](19|20)?[0-9]{2}$";
                break;
            case 3: // MM-dd-yyyy
                dataPattern = "^(0?[1-9]|1[012])[-](0?[1-9]|[12][0-9]|3[01])[-](19|20)?[0-9]{2}$";
                break;
            case 4: // yyyy/MM/dd
                dataPattern = "^(19|20)?[0-9]{2}[/](0?[1-9]|1[012])[/](0?[1-9]|[12][0-9]|3[01])$";
                break;
            case 5: // yyyy-MM-dd
                dataPattern = "^(19|20)?[0-9]{2}[-](0?[1-9]|1[012])[-](0?[1-9]|[12][0-9]|3[01])$";
                break;
        }

        return data.matches(dataPattern);

    }

    /**
     *
     * @param nif
     * @param dni
     * @return
     */
    public static boolean isValidFormatDNI(String nif) {
        // String nifPattern = "([0-9]{8})([A-Z]|[a-z])";
        // String nifPattern = "[0-9A-Z][0-9]{7}[A-Z]";
        String nifPattern = "^[X-Zx-z0-9]{1}[0-9]{7}[A-Za-z]{1}$";

        return nif.matches(nifPattern);
    }

    /**
     *
     * @param cp
     * @return
     */
    public static boolean isValidFormatCP(String cp) {
        String cpPattern = "0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}";

        return cp.matches(cpPattern);
    }

    /**
     *
     * @param nom
     * @return
     */
    public static boolean isValidFormatNom(String nom) {
        String nomPattern = "^([A-Za-z ÑñÁÀÉÈÓÒÚàáéàíóàú]{1,60})";
        return nom.matches(nomPattern);
    }

    public static boolean isValidFormatNombre(String num) {
        String numPattern = "[0-9.]{0,7}";
        return num.matches(numPattern);
    }

    /**
     *
     * @param password
     * @return
     */
    public static boolean isValidFormatPassword(String password) {
        String passwordPattern = "(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{8,20})$";
        return password.matches(passwordPattern);
    }

    public static boolean isValidFormatUsuari(String usuari) {
        String usuariPattern = "^[A-Za-z0-9]{4,9}";
        return usuari.matches(usuariPattern);
    }
    
   

}
