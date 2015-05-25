/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioInici.model.bll;

import classes.Connexio;
import java.sql.Connection;
import moduls.gestioInici.model.classes.Job;
import moduls.gestioInici.model.classes.JcThread;
import llibreries.Encriptar;
import static moduls.gestioInici.controlador.ControladorInici.frmMail;
import static moduls.gestioInici.controlador.ControladorInici.frmSignIn;
import static moduls.gestioInici.controlador.ControladorInici.frmSignUp;
import moduls.gestioInici.model.classes.SingletonInici;
import moduls.gestioInici.model.dao.GIDAOBd;
import moduls.gestioInici.model.dao.GIDAOGrafic;
import static moduls.gestioInici.model.dao.GIDAOGrafic.demanaEmail_1DAO;
import static moduls.gestioInici.model.dao.GIDAOGrafic.demanaUsuari_1DAO;
import moduls.gestioUsuaris.model.dao.GUDAOBd;
import utils.Funcions;
import utils.Menus;

/**
 *
 * @author Vicent
 */
public class GIBLL {

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
            if (GIDAOBd.cercarEmailDAO(email, conn)) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static void validarEmail_3BLL() {
        GIDAOGrafic.validarEmail_3DAO();
    }

    public static void validarUsuari_0BLL() {
        GIDAOGrafic.validarUsuari_0DAO();
    }

    public static void demanaUsuari_0BLL() {
        if (GIDAOGrafic.validarUsuari_0DAO()) {
            frmSignIn.txtPassword.requestFocus();
        }
    }

    public static void demanaContrassenya_0BLL() {
        if (GIDAOGrafic.validarContrassenya_0DAO()) {
            frmSignIn.btnIniciSessio.requestFocus();
        }
    }

    public static boolean validarUsuari_1BLL() {
        return GIDAOGrafic.validarUsuari_1DAO();
    }

    public static void validarContrassenya_0BLL() {
        GIDAOGrafic.validarContrassenya_0DAO();
    }

    public static boolean validarContrassenya_1BLL() {
        return GIDAOGrafic.validarContrassenya_1DAO();
    }

    public static boolean validarEmail_1BLL() {
        return GIDAOGrafic.validarEmail_1DAO();
    }

    public static void demanaUsuari_1BLL() {
        if (validarUsuari_1BLL()) {
            if (demanaUsuari_1DAO()) {
                frmSignUp.txtPassword.requestFocus();
            }
        }
    }

    public static void demanaContrassenya_1BLL() {
        if (validarContrassenya_1BLL()) {
            frmSignUp.txtEmail.requestFocus();
        }
    }

    public static void demanaEmail_1BLL() {
        if (validarEmail_1BLL()) {
            if (demanaEmail_1DAO()) {
                frmSignUp.btnRegistre.requestFocus();
            } else {
                frmSignUp.txtUsuari.requestFocus();
            }
        }
    }

    public static void demanaEmail_3BLL() {
        if (GIDAOGrafic.demanaEmail_3DAO()) {
            frmMail.btnEnviarCorreu.requestFocus();
        }
    }

    public static boolean guardar_1BLL() {
        if (GIDAOGrafic.guardar_1DAO()) {
            if (guardarGIBLL()) {
                return true;
            }
        }
        return false;
    }

    public static boolean guardarGIBLL() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.insertUsuariDAOBd(conn) == 1) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static boolean modificarGIBLL() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.updateUsuariDAOBd(conn) == 1) {
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
            /*
            new Thread(new Job(SingletonInici.user_mail, SingletonInici.pass_mail,
                    frmMail.txtEmail.getText(), SingletonInici.assumpte, missatge)).start();
            new Thread(new JcThread(frmMail.barProgressBar, 50)).start();
            */
            Menus.information(missatge, Token);
            return true;
        } else {
            Menus.warning("Correu electrònic no registrat!", "Recordar dades");
        }
        return false;
    }

    public static void enviarCorreuRegistreBLL() {
        frmMail.btnEnviarCorreu.setEnabled(false);
        char[] p = frmSignUp.txtPassword.getPassword();
        String passText = new String(p);
        String usuari = frmSignUp.txtUsuari.getText();
        String Token = Funcions.getCadenaAleatoria3(24);
        String missatge = "Usuari: " + usuari + "       " + "Contrassenya: " + passText + "       " + "Token: " + Token;
        /*
        new Thread(new Job(SingletonInici.user_mail, SingletonInici.pass_mail,
                frmSignUp.txtEmail.getText(), SingletonInici.assumpte, missatge)).start();
        new Thread(new JcThread(frmMail.barProgressBar, 50)).start();
        */
        Menus.information(missatge, Token);
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
            if (GUDAOBd.updateUsuariDAOBd(conn) == 1) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static boolean iniciSessioBLL() {
        return GIDAOGrafic.iniciSessioDAO();
    }

    public static boolean enviarCorreuBLL() {
        if (GIDAOGrafic.validarEmail_3DAO()) {
            if (cercarEmailBLL(frmMail.txtEmail.getText())) {
                frmMail.btnEnviarCorreu.setEnabled(false);
                GIBLL.recordarDadesBLL();
            }
        }
        return false;

    }

    public static void eixir() {
        Menus.information("Eixint de l'aplicació", "Eixir");
        frmSignIn.dispose();
        System.exit(0);
    }

}
