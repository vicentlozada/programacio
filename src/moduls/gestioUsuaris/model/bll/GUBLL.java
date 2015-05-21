/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioUsuaris.model.bll;

import classes.Connexio;
import java.sql.Connection;
import moduls.gestioInici.model.classes.Job;
import moduls.gestioInici.model.classes.JcThread;
import llibreries.Encriptar;
import static moduls.gestioInici.controlador.ControladorInici.frmMail;
import static moduls.gestioInici.controlador.ControladorInici.frmSignIn;
import moduls.gestioInici.model.classes.SingletonInici;
import static moduls.gestioUsuaris.controlador.ControladorUsuaris.frmUsuari;
import static moduls.gestioUsuaris.model.bll.GUBLL.validarUsuari_1BLL;
import moduls.gestioUsuaris.model.classes.SingletonUsuaris;
import moduls.gestioUsuaris.model.dao.GUDAOBd;
import moduls.gestioUsuaris.model.dao.GUDAOGrafic;
import utils.Funcions;
import utils.Menus;

/**
 *
 * @author Vicent
 */
public class GUBLL {
    
    
    public static void cercarUsuari() {
        int pos = buscarLoginUsuari();
        if (pos != -1) {
            SingletonUsuaris.us = SingletonUsuaris.usAl.get(pos);
        }
    }    
    
    public static int buscarLoginUsuari() {
        int pos = -1;
        for (int i = 0; i < SingletonUsuaris.usAl.size(); i++) {
            if ((SingletonUsuaris.usAl.get(i)).equals(SingletonUsuaris.us)) {
                pos = i;
            }
        }
        return pos;
    }    
    
    public static void omplirCampsMBLL(){
        GUDAOGrafic.omplirCampsMDAO();
    }
    
    public static void omplirCampsMBLL2(){
        GUDAOGrafic.omplirCampsMDAO2();
    }    
    
    
    public static void activaUsuariBLL(byte estat) {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.activaUsuariDAO(estat, conn) == 1) {
                Connexio.desconnectar(conn);
            }
        }

    }    

    public static boolean cercarDniBLL(String dni) {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.cercarDniDAO(dni, conn)) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static boolean cercarUsuariBLL(String usuari) {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.cercarUsuariDAO(usuari, conn)) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static boolean cercarEmailBLL(String email) {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.cercarEmailDAO(email, conn)) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    // 0
    public static void validarUsuari_0BLL() {
        GUDAOGrafic.validarUsuari_0DAO();
    }

    public static void validarContrassenya_0BLL() {
        GUDAOGrafic.validarContrassenya_0DAO();
    }

    public static void demanaUsuari_0BLL() {
        if (GUDAOGrafic.validarUsuari_0DAO()) {
            frmSignIn.txtPassword.requestFocus();
        }
    }

    public static void demanaContrassenya_0BLL() {
        if (GUDAOGrafic.validarContrassenya_0DAO()) {
            frmSignIn.btnIniciSessio.requestFocus();
        }
    }

    // 1
    public static boolean validarUsuari_1BLL() {
        return GUDAOGrafic.validarUsuari_1DAO();
    }

    public static boolean validarContrassenya_1BLL() {
        return GUDAOGrafic.validarContrassenya_1DAO();
    }

    public static boolean validarDni_1BLL() {
        return GUDAOGrafic.validarDni_1DAO();
    }

    public static boolean validarNom_1BLL() {
        return GUDAOGrafic.validarNom_1DAO();
    }

    public static boolean validarEmail_1BLL() {
        return GUDAOGrafic.validarEmail_1DAO();
    }

    public static void demanarUsuari_1BLL() {
        if (validarUsuari_1BLL()) {
            if (GUDAOGrafic.demanaUsuari_1DAO()) {
                frmUsuari.txtPassword.requestFocus();
            }
        }
    }

    public static void demanarContrassenya_1BLL() {
        if (validarContrassenya_1BLL()) {
            frmUsuari.txtDni.requestFocus();
        }
    }

    public static void demanaDni_1BLL() {
        if (validarDni_1BLL()) {
            if (GUDAOGrafic.demanaDni_1DAO()) {
                frmUsuari.txtNom.requestFocus();
            }
        }
    }

    public static void demanaNom_1BLL() {
        if (validarNom_1BLL()) {
            frmUsuari.txtEmail.requestFocus();
        }
    }

    public static void demanaEmail_1BLL() {
        if (validarEmail_1BLL()) {
            frmUsuari.cmbTipusUsuari.requestFocus();
        }
    }

    public static boolean guardar_1BLL() {
        if (GUDAOGrafic.guardar_2DAO()) {
            if (guardarGUBLL()) {
                return true;
            }
        }
        return false;
    }

    public static boolean guardarGUBLL() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.modificarUsuari(conn) == 1) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static boolean modificarGIBLL() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.modificarUsuari(conn) == 1) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static boolean validaUsuariPasswordBLL(String usuari, String pass) {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.validarUsuariPasswordDAO(usuari, pass, conn)) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static boolean validarEmailRecordarPass() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.validarUsuariEmailDAO(frmMail.txtEmail.getText(), conn)) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static boolean recordarDadesBLL() {

        if (validarEmailRecordarPass()) {
            String novaContrassenaya = Funcions.getCadenaAleatoria1(9);
            String Token = Funcions.getCadenaAleatoria3(24);
            String missatge = "Contrassenya: " + novaContrassenaya + "       " + "Token: " + Token;
            String passEncriptat = Encriptar.encriptarTokenMD5(novaContrassenaya);
            modificarPassBLL(passEncriptat);
            //Mail mail = new Mail(SingletonInici.user_mail, SingletonInici.pass_mail,
            //      frmMail.txtEmail.getText(), SingletonInici.assumpte, missatge);
            //mail.send();

            new Thread(new Job(SingletonInici.user_mail, SingletonInici.pass_mail,
                    frmMail.txtEmail.getText(), SingletonInici.assumpte, missatge)).start();
            new Thread(new JcThread(frmMail.barProgressBar, 50)).start();
            return true;
        } else {
            Menus.warning("Correu electrònic no registrat!", "Recordar dades");
        }
        return false;
    }

    public static boolean modificarPassBLL(String pass) {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.modificarPassDAO(pass, conn) == 1) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static boolean modificarPass() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.modificarUsuari(conn) == 1) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    
    //public static boolean iniciSessioBLL() {
      //  return GUDAOGrafic.iniciSessioDAO();
   // }

    //-------------------------------------------------------------------
    // 2
    public static boolean validarUsuari_2BLL() {
        return GUDAOGrafic.validarUsuari_2DAO();
    }

    public static boolean validarContrassenya_2BLL() {
        return GUDAOGrafic.validarContrassenya_2DAO();
    }

    public static boolean validarDni_2BLL() {
        return GUDAOGrafic.validarDni_2DAO();
    }

    public static boolean validarNom_2BLL() {
        return GUDAOGrafic.validarNom_2DAO();
    }

    public static boolean validarEmail_2BLL() {
        return GUDAOGrafic.validarEmail_2DAO();
    }

    public static void demanarUsuari_2BLL() {
        if (validarUsuari_2BLL()) {
            if (GUDAOGrafic.demanaUsuari_2DAO()) {
                frmUsuari.txtPassword.requestFocus();
            }
        }
    }

    public static void demanarContrassenya_2BLL() {
        if (validarContrassenya_2BLL()) {
            frmUsuari.txtDni.requestFocus();
        }
    }

    public static void demanaDni_2BLL() {
        if (validarDni_2BLL()) {
            if (GUDAOGrafic.demanaDni_2DAO()) {
                frmUsuari.txtNom.requestFocus();
            }
        }
    }

    public static void demanaNom_2BLL() {
        if (validarNom_2BLL()) {
            frmUsuari.txtEmail.requestFocus();
        }
    }

    public static void demanaEmail_2BLL() {
        if (validarEmail_2BLL()) {
            frmUsuari.cmbTipusUsuari.requestFocus();
        }
    }

    public static boolean guardar_2BLL() {
        if (GUDAOGrafic.guardar_2DAO()) {
            if (guardarGUBLL()) {
                return true;
            }
        }
        return false;
    }

}
