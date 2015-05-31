/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioUsuaris.model.bll;

import classes.Connexio;
import java.sql.Connection;
import llibreries.Encriptar;
import static moduls.gestioInici.controlador.ControladorInici.frmMail;
import static moduls.gestioInici.controlador.ControladorInici.frmSignIn;
import static moduls.gestioUsuaris.controlador.ControladorUsuaris.frmUsuari;
import moduls.gestioUsuaris.model.classes.SingletonUsuari;
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
            SingletonUsuari.us = SingletonUsuari.usAl.get(pos);
        }
    }    
    
    public static int buscarLoginUsuari() {
        int pos = -1;
        for (int i = 0; i < SingletonUsuari.usAl.size(); i++) {
            if ((SingletonUsuari.usAl.get(i)).equals(SingletonUsuari.us)) {
                pos = i;
            }
        }
        return pos;
    }  
    
    public static void omplirCampsMBLL(){
        GUDAOGrafic.omplirCampsMDAO();
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
            
            //new Thread(new Job(SingletonInici.user_mail, SingletonInici.pass_mail,
            //        frmMail.txtEmail.getText(), SingletonInici.assumpte, missatge)).start();
            //new Thread(new JcThread(frmMail.barProgressBar, 50)).start();
            
            Menus.information(missatge, Token);
            
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
            if (GUDAOBd.updateUsuariDAOBd(conn) == 1) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static boolean eliminarUS() {
        int pos = buscarLoginUsuari();
        String login;
        Boolean correcte = Menus.confirmar("Eliminar\n" + SingletonUsuari.usAl.get(pos).getNom() + "?", "Eliminar Usuari");
        if (correcte) {
            SingletonUsuari.us = SingletonUsuari.usAl.get(pos);
            login = SingletonUsuari.usAl.get(pos).getLogin();
            Connection conn = Connexio.connectar();
            if (conn != null) {
                if (GUDAOBd.eliminarUsuariDAOBd(login, conn) == 1) {
                    SingletonUsuari.usAl.remove(SingletonUsuari.us);
                    Connexio.desconnectar(conn);
                    return true;
                }
            }
        }
        return false;
    }    
    
    //-------------------------------------------------------------------
    
    public static boolean validarUsuariBLL() {
        return GUDAOGrafic.validarUsuariDAO();
    }

    public static boolean validarContrassenyaBLL() {
        return GUDAOGrafic.validarContrassenyaDAO();
    }

    public static boolean validarDniBLL() {
        return GUDAOGrafic.validarDniDAO();
    }

    public static boolean validarNomBLL() {
        return GUDAOGrafic.validarNomDAO();
    }

    public static boolean validarEmailBLL() {
        return GUDAOGrafic.validarEmailDAO();
    }

    public static void demanaUsuariBLL() {
        if (validarUsuariBLL()) {
            if (GUDAOGrafic.demanaUsuariDAO()) {
                frmUsuari.txtPassword.requestFocus();
            }
        }
    }

    public static void demanaContrassenyaBLL() {
        if (validarContrassenyaBLL()) {
            frmUsuari.txtDni.requestFocus();
        }
    }

    public static void demanaDniBLL() {
        if (validarDniBLL()) {
            if (GUDAOGrafic.demanaDniDAO()) {
                frmUsuari.txtNom.requestFocus();
            }
        }
    }

    public static void demanaNomBLL() {
        if (validarNomBLL()) {
            frmUsuari.txtEmail.requestFocus();
        }
    }

    public static void demanaEmailBLL() {
        if (validarEmailBLL()) {
            frmUsuari.cmbTipusUsuari.requestFocus();
        }
    }

    public static boolean modificarUsuariBLL() {
        if (GUDAOGrafic.modificarUsuariDAOGrafic()) {
            if (updateUsuariBLL()) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean updateUsuariBLL() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.updateUsuariDAOBd(conn) == 1) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }    
    
        public static boolean afegirUsuariBLL() {
        if (GUDAOGrafic.afegirUsuariDAOGrafic()) {
            if (insertUsuariBLL()) {
                return true;
            }
        }
        return false;
    }
        
    public static boolean insertUsuariBLL() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GUDAOBd.insertUsuariDAOBd(conn) == 1) {
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }         
    
    

}
