package moduls.gestioEmpleats.gestioEF.model.bll;

import classes.Connexio;
import java.sql.Connection;
import static moduls.gestioEmpleats.gestioEF.controlador.ControladorEF.frmAltaEF;
import static moduls.gestioEmpleats.gestioEF.controlador.ControladorEF.frmModiEF;
import utils.Menus;
import moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF;
import moduls.gestioEmpleats.gestioEF.model.classes.EmpleatFix;
import moduls.gestioEmpleats.gestioEF.model.dao.EFDAO.EFDAOBd;
import moduls.gestioEmpleats.gestioEF.model.dao.EFDAO.EFDAOGrafic;
import moduls.gestioEmpleats.gestioEF.model.dao.EFDAOFitxers.EFDAOFitxers;

public class EFBLL {

    public static void validarNomAEFBLL() {
        EFDAOGrafic.validarNomAEFDAO();
    }

    public static void validarNomMEFBLL() {
        EFDAOGrafic.validarNomAEFDAO();
    }

    public static void validarDniBLL() {
        EFDAOGrafic.validarDniDAO();
    }

    public static void validarEmailABLL() {
        EFDAOGrafic.validarEmailADAO();
    }

    public static void validarEmailMBLL() {
        EFDAOGrafic.validarEmailMDAO();
    }

    public static void validarSalariABLL() {
        if (!EFDAOGrafic.validarSalariADAO()) {
            frmAltaEF.txtSalariBase.requestFocus();
        }
    }

    public static void validarSalariMBLL() {
        EFDAOGrafic.validarSalariMDAO();
    }

    public static void guardarMEFBLL() {
        EFDAOGrafic.guardarMEFDAO();
    }

    public static void guardarAEFBLL() {
        EFDAOGrafic.guardarAEFDAO();
    }

    public static void demanaDniEFBLL() {
        if (EFDAOGrafic.demanaDniEFDAO()) {
            frmAltaEF.txtNom.requestFocus();
        }
    }

    public static void demanaSalariABLL() {
        if (EFDAOGrafic.demanaSalariADAO()) {
            frmAltaEF.btnGuardar.requestFocus();
        }
    }
    
    public static void demanaSalariMBLL(){
        if(EFDAOGrafic.demanaSalariMDAO()){
            frmModiEF.btnGuardar.requestFocus();
        }
    }

    public static void dniEmpleat(int pos) {
        EmpleatFix ef = SingletonEF.efix.get(pos);
        String dni = ef.getDni();
        SingletonEF.ef = new EmpleatFix(dni);
    }

    /**
     * ompli els camps després de seleccionar un empleat per a modificar-lo
     *
     * @return
     */
    public static void cercarEmpleatFix() {
        int pos = buscarDniEmpleat();
        if (pos != -1) {
            SingletonEF.ef = SingletonEF.efix.get(pos);
        }
    }

    public static String empleatMesAnticBLL() {
        Connection conn = Connexio.connectar();
        String resultat = null;
        if (conn != null) {
            resultat = EFDAOBd.empleatMesAnticDAO(conn);
            if (conn != null) {
                Connexio.desconnectar(conn);
            }
        }
        return resultat;
    }

    public static boolean cercarBLL(String dni) {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (EFDAOBd.cercar(dni, conn)) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static boolean guardarA() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (EFDAOBd.afegir(conn) == 1) {
                SingletonEF.efix.add(SingletonEF.ef);
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static boolean guardarM() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (EFDAOBd.modificar(conn) == 1) {
                int pos = buscarDniEmpleat();
                SingletonEF.efix.set(pos, SingletonEF.ef);
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    /**
     * elimina un empleat seleccionat en el pager
     *
     * @return
     */
    public static boolean eliminarEF() {
        int pos = buscarDniEmpleat();
        String dni;
        Boolean correcte = Menus.confirmar("Eliminar\n" + SingletonEF.efix.get(pos).getNom() + "?", "Empleat Fix: Eliminar");
        if (correcte) {
            SingletonEF.ef = SingletonEF.efix.get(pos);
            dni = SingletonEF.efix.get(pos).getDni();
            Connection conn = Connexio.connectar();
            if (conn != null) {
                if (EFDAOBd.eliminar(dni, conn) == 1) {
                    SingletonEF.efix.remove(SingletonEF.ef);
                    Connexio.desconnectar(conn);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param dni
     * @return pos: la posició del objecte en l'array
     */
    public static int cercarEmpleat(String dni) {
        int pos = -1;
        if (dni != null) {
            EmpleatFix ef = new EmpleatFix(dni); // creem un objecte EmpleatFix amb el DNI solament
            pos = buscar(ef);
        }
        return pos;
    }

    /**
     * la utilitze per a buscar noms duplicats quan omplim l'array des dels
     * dummies
     *
     * @param nom
     * @return pos: la posició del objecte en l'array
     */
    public static int cercarEmpleatNom(String nom) {
        int pos = -1;
        String x = "";
        if (nom != null) {
            EmpleatFix ef = new EmpleatFix(nom, x); // creem un objecte EmpleatFix amb el nom solament
            pos = buscar(ef);
        }
        return pos;
    }

    /**
     *
     * @return la posició de l'objecte ef en l'array
     */
    public static int buscarDniEmpleat() {
        int pos = -1;
        for (int i = 0; i < SingletonEF.efix.size(); i++) {
            if ((SingletonEF.efix.get(i)).equals(SingletonEF.ef2)) {
                pos = i;
            }
        }
        return pos;
    }

    /**
     *
     * @param ef
     * @return aux: la posició del objecte en l'array
     */
    public static int buscar(EmpleatFix ef) {
        int aux = -1;
        for (int i = 0; i < SingletonEF.efix.size(); i++) {
            if ((SingletonEF.efix.get(i)).equals(ef)) {
                aux = i;
            }
        }
        return aux;
    }

    /**
     * guardar a petició
     */
    public static void guardarArxiuEFBLL() {
        if (!SingletonEF.efix.isEmpty()) {
            EFDAOFitxers.guardarArxiuEFDAO();
        } else {
            Menus.error("ArrayList buit", "Error");
        }
    }

    /**
     * guardar a petició
     */
    public static void guardarArxiuTXTEFBLL() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            EFDAOBd.omplirArray(conn);
            Connexio.desconnectar(conn);
        }
        if (!SingletonEF.efix.isEmpty()) {
            EFDAOFitxers.guardarArxiuTXTEFDAO();
        } else {
            Menus.error("ArrayList buit", "Error");
        }
    }

    /**
     * guardar a petició
     */
    public static void guardarArxiuXMLEFBLL() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            EFDAOBd.omplirArray(conn);
            Connexio.desconnectar(conn);
        }
        if (!SingletonEF.efix.isEmpty()) {
            EFDAOFitxers.guardarArxiuXMLEFDAO();
        } else {
            Menus.error("ArrayList buit", "Error");
        }
    }

    /**
     * guardar a petició
     */
    public static void guardarArxiuJSONEFBLL() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            EFDAOBd.omplirArray(conn);
            Connexio.desconnectar(conn);
        }
        if (!SingletonEF.efix.isEmpty()) {
            EFDAOFitxers.guardarArxiuJSONEFDAO();
        } else {
            Menus.error("ArrayList buit", "Error");
        }
    }

    /**
     * obrir a petició
     */
    public static void obrirArxiuEFBLL() {
        EFDAOFitxers.obrirArxiuEFDAO();
    }

}
