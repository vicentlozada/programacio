/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioInici.model.dao;

import classes.Data;
import com.toedter.calendar.JTextFieldDateEditor;
import llibreries.Encriptar;
import main.Core;
import static moduls.gestioInici.controlador.ControladorInici.frmMail;
import static moduls.gestioInici.controlador.ControladorInici.frmSignIn;
import static moduls.gestioInici.controlador.ControladorInici.frmSignUp;
import moduls.gestioInici.model.bll.GIBLL;
import moduls.gestioInici.model.classes.SingletonInici;
import static moduls.gestioInici.model.classes.SingletonInici.buit;
import static moduls.gestioInici.model.classes.SingletonInici.cancel;
import static moduls.gestioInici.model.classes.SingletonInici.ok;
import static moduls.gestioUsuaris.controlador.ControladorUsuaris.frmUsuari;
import moduls.gestioUsuaris.model.bll.GUBLL;
import moduls.gestioUsuaris.model.classes.SingletonUsuari;
import moduls.gestioUsuaris.model.classes.Usuari;
import utils.Menus;
import utils.Validate;

/**
 *
 * @author Vicent
 */
public class GIDAOGrafic {

    public static boolean validarEmail_3DAO() {
        if (frmMail.txtEmail.getText().isEmpty()) {
            frmMail.lblbEmail.setIcon(buit);
        } else {
            if (!Validate.isValidFormatEmailAddress(frmMail.txtEmail.getText())) {
                frmMail.lblbEmail.setIcon(cancel);
            } else {
                frmMail.lblbEmail.setIcon(ok);
                return true;
            }
        }
        return false;
    }

    public static boolean validarEmail_1DAO() {
        if (frmSignUp.txtEmail.getText().isEmpty()) {
            frmSignUp.lblbEmail.setIcon(buit);
        } else {
            if (!Validate.isValidFormatEmailAddress(frmSignUp.txtEmail.getText())) {
                frmSignUp.lblbEmail.setIcon(cancel);
            } else {
                frmSignUp.lblbEmail.setIcon(ok);
                return true;
            }
        }
        return false;
    }

    public static boolean validarUsuari_0DAO() {
        if (frmSignIn.txtUsuari.getText().isEmpty()) {
            frmSignIn.lblbUsuari.setIcon(buit);
        } else {
            if (!Validate.isValidFormatUsuari(frmSignIn.txtUsuari.getText())) {
                frmSignIn.lblbUsuari.setIcon(cancel);
            } else {
                frmSignIn.lblbUsuari.setIcon(ok);
                return true;
            }
        }
        return false;
    }

    public static boolean validarUsuari_1DAO() {
        if (frmSignUp.txtUsuari.getText().isEmpty()) {
            frmSignUp.lblbUsuari.setIcon(buit);
        } else {
            if (!Validate.isValidFormatUsuari(frmSignUp.txtUsuari.getText())) {
                frmSignUp.lblbUsuari.setIcon(cancel);
            } else {
                frmSignUp.lblbUsuari.setIcon(ok);
                return true;
            }
        }
        return false;
    }

    public static boolean validarContrassenya_0DAO() {
        char[] p = frmSignIn.txtPassword.getPassword();
        String passText = new String(p);
        if (passText.isEmpty()) {
            frmSignIn.lblbPassword.setIcon(buit);
        } else {
            if (!Validate.isValidFormatPassword(passText)) {
                frmSignIn.lblbPassword.setIcon(cancel);
            } else {
                frmSignIn.lblbPassword.setIcon(ok);
                return true;
            }
        }
        return false;
    }

    public static boolean validarContrassenya_1DAO() {
        char[] p = frmSignUp.txtPassword.getPassword();
        String passText = new String(p);
        if (passText.isEmpty()) {
            frmSignUp.lblbPassword.setIcon(buit);
        } else {
            if (!Validate.isValidFormatPassword(passText)) {
                frmSignUp.lblbPassword.setIcon(cancel);
            } else {
                frmSignUp.lblbPassword.setIcon(ok);
                return true;
            }
        }
        return false;
    }

    public static boolean demanaUsuari_1DAO() {
        if (GIBLL.cercarUsuariBLL(frmSignUp.txtUsuari.getText())) {
            Menus.warning("Usuari ja donat d'alta!", "Usuaris");
            frmSignUp.txtUsuari.setText(null);
            frmSignUp.txtPassword.setText(null);
            frmSignUp.txtEmail.setText(null);
            frmSignUp.DateDataNaixement.setDate(null);
            frmSignUp.lblbUsuari.setIcon(buit);
            frmSignUp.lblbPassword.setIcon(buit);
            frmSignUp.lblbEmail.setIcon(buit);
            frmSignUp.lblbDnaixement.setIcon(buit);
            return false;
        } else {
            frmSignUp.lblbUsuari.setIcon(ok);
            return true;
        }
    }

    public static boolean demanaEmail_1DAO() {
        if (GIBLL.cercarEmailBLL(frmSignUp.txtEmail.getText())) {
            Menus.warning("Email ja donat d'alta!", "Usuaris");
            frmSignUp.txtUsuari.setText(null);
            frmSignUp.txtPassword.setText(null);
            frmSignUp.txtEmail.setText(null);
            frmSignUp.DateDataNaixement.setDate(null);
            frmSignUp.lblbUsuari.setIcon(buit);
            frmSignUp.lblbPassword.setIcon(buit);
            frmSignUp.lblbEmail.setIcon(buit);
            frmSignUp.lblbDnaixement.setIcon(buit);
            return false;
        } else {
            frmSignUp.lblbUsuari.setIcon(ok);
            return true;
        }
    }

    public static boolean demanaEmail_3DAO() {
        if (!frmMail.txtEmail.getText().isEmpty()) {
            if (!GIBLL.cercarEmailBLL(frmMail.txtEmail.getText())) {
                Menus.warning("Email no registrat!", "Recover");
                frmMail.txtEmail.setText(null);
                frmMail.lblbEmail.setIcon(buit);
                return false;
            } else {
                frmSignUp.lblbUsuari.setIcon(ok);
                return true;
            }
        }
        return false;
    }

    public static boolean guardar_1DAO() {
        boolean val1 = false, val2 = false;
        int edat = 0;
        byte estat = 0;
        String tipus = SingletonInici.default_tipus;
        String avatar = SingletonInici.default_avatar;
        String nom = null, dni = null;
        Data datanaixement = null;
        Data datalta = Data.datactual();

        if (frmSignUp.txtEmail.getText().isEmpty()) {
            frmSignUp.lblbEmail.setIcon(cancel);
        }
        if (frmSignUp.DateDataNaixement.getDate() == null) {
            frmSignUp.lblbDnaixement.setIcon(cancel);
        }

        String login = frmSignUp.txtUsuari.getText(); // usuari
        if (!Validate.isValidFormatUsuari(frmSignUp.txtUsuari.getText())) {
            frmSignUp.lblbUsuari.setIcon(cancel);
        } else {
            frmSignUp.lblbUsuari.setIcon(ok);
        }

        char[] p = frmSignUp.txtPassword.getPassword();
        String passText = new String(p);
        String password = Encriptar.encriptarTokenMD5(passText);
        if (!Validate.isValidFormatPassword(passText)) {
            frmSignUp.lblbPassword.setIcon(cancel);
        } else {
            frmSignUp.lblbPassword.setIcon(ok);
        }

        String email = frmSignUp.txtEmail.getText();       // email
        if (!Validate.isValidFormatEmailAddress(frmSignUp.txtEmail.getText())) {
            frmSignUp.lblbEmail.setIcon(cancel);
        } else {
            frmSignUp.lblbEmail.setIcon(ok);
        }

        // Data naixement
        try {

            // si el JDateChooser torna un String
            String dn = ((JTextFieldDateEditor) frmSignUp.DateDataNaixement.getDateEditor()).getText();
            datanaixement = new Data(dn, Core.conf.getFormatdata());    // datanaixement
            datalta = Data.datactual();                                 // datalta
            // si el JDateChooser torna un Date()   
            //datanaixement = new Data((FrmConfig.DateDataNaixement.getDate()));
            edat = Usuari.calcularEdat(datanaixement);          // edat
            if (edat < 16) {
                frmSignUp.lblbDnaixement.setIcon(cancel);
                Menus.warning("Ha de ser major de 16 anys", "Atenció");
            } else {
                frmSignUp.lblbDnaixement.setIcon(ok);
            }
        } catch (Exception ex) {
            frmUsuari.lblbDnaixement.setIcon(cancel);
        }

        if ((frmSignUp.lblbEmail.getIcon().equals(ok))
                && (frmSignUp.lblbUsuari.getIcon().equals(ok))
                && (frmSignUp.lblbPassword.getIcon().equals(ok))
                && (frmSignUp.lblbDnaixement.getIcon().equals(ok))) {

            if ((login != null) && (email != null)) {

                if (GIBLL.cercarUsuariBLL(login)) {
                    frmSignUp.lblbUsuari.setIcon(cancel);
                    Menus.warning("Usuari ja donat d'alta!", "Usuaris");
                    val1 = false;
                } else {
                    val1 = true;
                }

                if (GIBLL.cercarEmailBLL(email)) {
                    frmSignUp.lblbEmail.setIcon(cancel);
                    Menus.warning("Email ja donat d'alta!", "Usuaris");
                    val2 = false;
                } else {
                    val2 = true;
                }

                if ((val1 == true) && (val2 == true)) {
                    if (Menus.confirmar("Registrar les dades?", "Registrar")) {
                        SingletonUsuari.us = new Usuari(nom, dni, datanaixement,
                                edat, login, password, datalta, email, tipus, estat, avatar);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean iniciSessioDAO() {
        char[] p = frmSignIn.txtPassword.getPassword();
        String passText = new String(p);

        if ((passText.isEmpty()) || (frmSignIn.txtUsuari.getText().isEmpty())) {
        } else {
            if ((frmSignIn.lblbUsuari.getIcon().equals(ok))
                    && (frmSignIn.lblbPassword.getIcon().equals(ok))) {
                if (!GUBLL.cercarUsuariBLL(frmSignIn.txtUsuari.getText())) {
                    frmSignIn.lblbUsuari.setIcon(cancel);
                    Menus.warning("Usuari no donat d'alta!", "Usuaris");
                } else {
                    if (GIBLL.validaUsuariPasswordBLL(frmSignIn.txtUsuari.getText(), passText)) {
                        return true;
                    } else {
                        Menus.warning("Usuari o contrassenya errori!", "Usuaris");
                    }
                }
            }
        }
        return false;
    }

}
