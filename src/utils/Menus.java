package utils;

import javax.swing.JOptionPane;

public class Menus {

    /**
     * showInputDialog tipo combo
     *
     * @param obj
     * @param msg
     * @param titol
     * @return
     */
    public static Object combo(Object[] obj, String msg, String titol) {
        Object opc = JOptionPane.showInputDialog(null, // component pare
                msg, // missatge
                titol, // t�tol
                JOptionPane.QUESTION_MESSAGE, // tipus de missatge
                null, // icona per defecte
                obj, // objecte de les opcions
                obj[0]); // opci� per defecte (agafa el focus)
        return opc;
    }

    /**
     * showOptionDialog
     *
     * @param obj
     * @param msg
     * @param titol
     * @return
     */
    public static int botons(Object[] obj, String msg, String titol) {
        int opc = JOptionPane.showOptionDialog(null, // component pare
                msg, // missatge
                titol, // t�tol
                JOptionPane.DEFAULT_OPTION, // tipud d'opci�
                JOptionPane.QUESTION_MESSAGE, // tipus de missatge
                null, // icona per defecte
                obj,// string de les opcions
                obj[0]);// opci� per defecte (agafa el focus)
        return opc;
    }

    /**
     * showConfirmDialog
     *
     * @param msg
     * @param titol
     * @return confirmar = true si hem pres el bot� "Acceptar" o tanquem la
     * finestra
     */
    public static boolean confirmar(String msg, String titol) {
        boolean confirmar = false;
        int sel = JOptionPane.showConfirmDialog(null, // component pare
                msg, // missatge
                titol, // t�tol
                JOptionPane.OK_CANCEL_OPTION, // tipud d'opci�
                JOptionPane.QUESTION_MESSAGE); // tipus de missatge
        if ((sel == 0) || (sel == -1)) {
            confirmar = true;
        }
        return confirmar;
    }

    /**
     * showMessageDialog: missatges d'error
     *
     * @param msg
     * @param titol
     */
    public static void error(String msg, String titol) {
        JOptionPane.showMessageDialog(null, // component pare
                msg, // missatge
                titol, // t�tol
                JOptionPane.ERROR_MESSAGE, // tipus de missatge
                null);
    }

    /**
     * showMessageDialog: missatges d'informaci�
     *
     * @param msg
     * @param titol
     */
    public static void information(String msg, String titol) {
        JOptionPane.showMessageDialog(null, // component pare
                msg, // missatge
                titol, // t�tol
                JOptionPane.INFORMATION_MESSAGE, // tipus de missatge
                null);
    }

    /**
     *
     * @param msg
     * @param titol
     */
    public static void defaultmissatge(String msg, String titol) {
        JOptionPane.showMessageDialog(null, // component pare
                msg, // missatge
                titol, // t�tol
                JOptionPane.DEFAULT_OPTION, // tipus de missatge
                null);
    }

    /**
     * showMessageDialog: missatges d'atenci�
     *
     * @param msg
     * @param titol
     */
    public static void warning(String msg, String titol) {
        JOptionPane.showMessageDialog(null, // component pare
                msg, // missatge
                titol, // t�tol
                JOptionPane.WARNING_MESSAGE, // tipus de missatge
                null);
    }

}
