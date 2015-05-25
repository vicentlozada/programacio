/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioUsuaris.model.dao;

import classes.Data;
import com.toedter.calendar.JTextFieldDateEditor;
import llibreries.Encriptar;
import main.Core;
import static moduls.gestioInici.controlador.ControladorInici.frmMail;
import static moduls.gestioInici.controlador.ControladorInici.frmSignIn;
import static moduls.gestioInici.model.classes.SingletonInici.buit;
import static moduls.gestioInici.model.classes.SingletonInici.cancel;
import static moduls.gestioInici.model.classes.SingletonInici.ok;
import static moduls.gestioUsuaris.controlador.ControladorUsuaris.frmUsuari;
import moduls.gestioUsuaris.model.bll.GUBLL;
import moduls.gestioUsuaris.model.classes.SingletonUsuaris;
import moduls.gestioUsuaris.model.classes.Usuari;
import utils.Funcions;
import utils.Menus;
import utils.Validate;

/**
 *
 * @author Vicent
 */
public class GUDAOGrafic {

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

    public static boolean validarEmailDAO() {
        if (frmUsuari.txtEmail.getText().isEmpty()) {
            frmUsuari.lblbEmail.setIcon(buit);
        } else {
            if (!Validate.isValidFormatEmailAddress(frmUsuari.txtEmail.getText())) {
                frmUsuari.lblbEmail.setIcon(cancel);
            } else {
                frmUsuari.lblbEmail.setIcon(ok);
                return true;
            }
        }
        return false;
    }

    public static boolean validarDniDAO() {
        if (frmUsuari.txtDni.getText().isEmpty()) {
            frmUsuari.lblbDni.setIcon(buit);
        } else {
            if (!Validate.isValidFormatDNI(frmUsuari.txtDni.getText())) { // valida si té un format de dni-nie
                frmUsuari.lblbDni.setIcon(cancel);
            } else {
                frmUsuari.txtDni.setText(Funcions.nifnie(frmUsuari.txtDni.getText())); // canvia la lletra de dni si és incorrecta
                frmUsuari.lblbDni.setIcon(ok);
                return true;
            }
        }
        return false;
    }

    public static boolean validarUsuariDAO() {
        if (frmUsuari.txtUsuari.getText().isEmpty()) {
            frmUsuari.lblbUsuari.setIcon(buit);
        } else {
            if (!Validate.isValidFormatUsuari(frmUsuari.txtUsuari.getText())) {
                frmUsuari.lblbUsuari.setIcon(cancel);
            } else {
                frmUsuari.lblbUsuari.setIcon(ok);
                return true;
            }
        }
        return false;
    }

    public static boolean validarContrassenyaDAO() {
        char[] p = frmUsuari.txtPassword.getPassword();
        String passText = new String(p);
        if (passText.isEmpty()) {
            frmUsuari.lblbPassword.setIcon(buit);
        } else {
            if (!Validate.isValidFormatPassword(passText)) {
                frmUsuari.lblbPassword.setIcon(cancel);
            } else {
                frmUsuari.lblbPassword.setIcon(ok);
                return true;
            }
        }
        return false;
    }

    public static boolean validarNomDAO() {
        if (frmUsuari.txtNom.getText().isEmpty()) {
            frmUsuari.lblbNom.setIcon(buit);
        } else {
            if (!Validate.isValidFormatNom(frmUsuari.txtNom.getText())) {
                frmUsuari.lblbNom.setIcon(cancel);
            } else {
                frmUsuari.lblbNom.setIcon(ok);
                return true;
            }
        }
        return false;
    }

    public static boolean demanaUsuariDAO() {
        if (Validate.isValidFormatUsuari(frmUsuari.txtUsuari.getText())) {
            if (GUBLL.cercarUsuariBLL(frmUsuari.txtUsuari.getText())) {
                frmUsuari.lblbUsuari.setIcon(cancel);
                Menus.warning("Usuari ja donat d'alta!", "Usuaris");
                return false;
            } else {
                frmUsuari.lblbUsuari.setIcon(ok);
                return true;
            }
        } else {
            frmUsuari.lblbUsuari.setIcon(cancel);
            return false;
        }
    }

    public static boolean demanaDniDAO() {
        if (Validate.isValidFormatDNI(frmUsuari.txtDni.getText())) {

            if (GUBLL.cercarDniBLL(frmUsuari.txtDni.getText())) {
                if (!frmUsuari.txtDni.getText().equals(SingletonUsuaris.us.getDni())) {
                    frmUsuari.lblbDni.setIcon(cancel);
                    Menus.warning("DNI ja donat d'alta!", "Usuaris");
                    return false;
                } else {
                    return true;
                }
            } else {
                frmUsuari.lblbDni.setIcon(ok);
                return true;
            }
        } else {
            frmUsuari.lblbDni.setIcon(cancel);
        }
        return false;
    }

    public static boolean guardar_1DAO() {
        boolean val1 = false, val2 = false, val3 = false;
        int edat = 0;
        byte estat = 0;
        String tipus = SingletonUsuaris.us2.getTipus(), avatar = SingletonUsuaris.us.getAvatar();
        Data datanaixement = null;
        Data datalta = null;

        if (frmUsuari.txtUsuari.getText().isEmpty()) {
            frmUsuari.lblUsuari.setIcon(cancel);
        }
        if (frmUsuari.txtDni.getText().isEmpty()) {
            frmUsuari.lblbDni.setIcon(cancel);
        }
        if (frmUsuari.txtNom.getText().isEmpty()) {
            frmUsuari.lblbNom.setIcon(cancel);
        }
        if (frmUsuari.txtEmail.getText().isEmpty()) {
            frmUsuari.lblbEmail.setIcon(cancel);
        }
        if (frmUsuari.DateDataNaixement.getDate() == null) {
            frmUsuari.lblbDnaixement.setIcon(cancel);
        }

        String login = frmUsuari.txtUsuari.getText(); // usuari
        if (frmUsuari.txtUsuari.getText().isEmpty()) {
            frmUsuari.lblbUsuari.setIcon(cancel);
        } else {
            if (!Validate.isValidFormatUsuari(frmUsuari.txtUsuari.getText())) {
                frmUsuari.lblbUsuari.setIcon(cancel);
            } else {
                frmUsuari.lblbUsuari.setIcon(ok);
            }
        }

        /*
         if (!Validate.isValidFormatUsuari(frmUsuariRegistre.txtUsuari.getText())) {
         frmUsuariRegistre.lblbUsuari.setIcon(cancel);
         } else {
         frmUsuariRegistre.lblbUsuari.setIcon(ok);
         }
         */
        char[] p = frmUsuari.txtPassword.getPassword();
        String passText = new String(p);
        String password = Encriptar.encriptarTokenMD5(passText);
        if (!Validate.isValidFormatPassword(passText)) {
            frmUsuari.lblbPassword.setIcon(cancel);
        } else {
            frmUsuari.lblbPassword.setIcon(ok);
        }

        String nom = frmUsuari.txtNom.getText();           // nom
        if (frmUsuari.txtNom.getText().isEmpty()) {
            frmUsuari.lblbNom.setIcon(cancel);
        } else {
            if (!Validate.isValidFormatNom(frmUsuari.txtNom.getText())) {
                frmUsuari.lblbNom.setIcon(cancel);
            } else {
                frmUsuari.lblbNom.setIcon(ok);
            }
        }

        /*
         if (!Validate.isValidFormatNom(frmUsuariRegistre.txtNom.getText())) {
         frmUsuariRegistre.lblbNom.setIcon(cancel);
         } else {
         frmUsuariRegistre.lblbNom.setIcon(ok);
         }
         */
        String email = frmUsuari.txtEmail.getText();       // email
        if (frmUsuari.txtEmail.getText().isEmpty()) {
            frmUsuari.lblbEmail.setIcon(cancel);
        } else {
            if (!Validate.isValidFormatEmailAddress(frmUsuari.txtEmail.getText())) {
                frmUsuari.lblbEmail.setIcon(cancel);
            } else {
                frmUsuari.lblbEmail.setIcon(ok);
            }
        }

        /*
         if (!Validate.isValidFormatEmailAddress(frmUsuariRegistre.txtEmail.getText())) {
         frmUsuariRegistre.lblbEmail.setIcon(cancel);
         } else {
         frmUsuariRegistre.lblbEmail.setIcon(ok);
         }
         */
        String dni = frmUsuari.txtDni.getText();       // dni   

        if (!Validate.isValidFormatDNI(frmUsuari.txtDni.getText())) {
            frmUsuari.lblbDni.setIcon(cancel);
        } else {
            if (GUBLL.cercarDniBLL(dni)) {
                frmUsuari.lblbDni.setIcon(cancel);
                Menus.warning("DNI ja donat d'alta!", "Usuaris");
            } else {
                frmUsuari.lblbDni.setIcon(ok);
                frmUsuari.txtDni.setText(Funcions.nifnie(dni));
            }
        }

        // Data naixement
        try {

            // si el JDateChooser torna un String
            String dn = ((JTextFieldDateEditor) frmUsuari.DateDataNaixement.getDateEditor()).getText();
            datanaixement = new Data(dn, Core.conf.getFormatdata());    // datanaixement
            datalta = Data.datactual();                                 // datalta
            // si el JDateChooser torna un Date()   
            //datanaixement = new Data((FrmConfig.DateDataNaixement.getDate()));
            edat = Usuari.calcularEdat(datanaixement);          // edat
            if (edat < 16) {
                frmUsuari.lblbDnaixement.setIcon(cancel);
                Menus.warning("Ha de ser major de 16 anys", "Atenció");
            } else {
                frmUsuari.lblbDnaixement.setIcon(ok);
                frmUsuari.lblEdat.setText("" + edat);
            }
        } catch (Exception ex) {
            frmUsuari.lblbDnaixement.setIcon(cancel);
        }

        if ((frmUsuari.lblbDni.getIcon().equals(ok))
                && (frmUsuari.lblbEmail.getIcon().equals(ok))
                && (frmUsuari.lblbUsuari.getIcon().equals(ok))
                && (frmUsuari.lblbPassword.getIcon().equals(ok))
                && (frmUsuari.lblbNom.getIcon().equals(ok))
                && (frmUsuari.lblbDnaixement.getIcon().equals(ok))) {

            if ((dni != null) && (login != null) && (email != null)) {

                if (GUBLL.cercarDniBLL(dni)) {

                    frmUsuari.lblbDni.setIcon(cancel);
                    Menus.warning("DNI ja donat d'alta!", "Usuaris");
                    val1 = false;
                } else {
                    val1 = true;
                }

                if (GUBLL.cercarUsuariBLL(login)) {
                    frmUsuari.lblbUsuari.setIcon(cancel);
                    Menus.warning("Usuari ja donat d'alta!", "Usuaris");
                    val2 = false;
                } else {
                    val2 = true;
                }

                if (GUBLL.cercarEmailBLL(email)) {
                    frmUsuari.lblbEmail.setIcon(cancel);
                    Menus.warning("Email ja donat d'alta!", "Usuaris");
                    val3 = false;
                } else {
                    val3 = true;
                }

                if ((val1) && (val2) && (val3)) {
                    if (Menus.confirmar("Guardar les dades?", "Guardar")) {
                        SingletonUsuaris.us = new Usuari(nom, dni, datanaixement,
                                edat, login, password, datalta, email, tipus, estat, avatar);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean modificarUsuariDAOGrafic() {
        boolean val1 = false, val2 = false, val3 = false;

        int edat = SingletonUsuaris.us.getEdat();
        Data datalta = SingletonUsuaris.us.getDatalta();
        byte estat = SingletonUsuaris.us.getEstat();
        String avatar = SingletonUsuaris.us.getAvatar();
        String tipus = SingletonUsuaris.us.getTipus();

        Data datanaixement = null;
        String password = null;

        if (frmUsuari.txtUsuari.getText().isEmpty()) {
            frmUsuari.lblUsuari.setIcon(cancel);
        }
        if (frmUsuari.txtDni.getText().isEmpty()) {
            frmUsuari.lblbDni.setIcon(cancel);
        }
        if (frmUsuari.txtNom.getText().isEmpty()) {
            frmUsuari.lblbNom.setIcon(cancel);
        }
        if (frmUsuari.txtEmail.getText().isEmpty()) {
            frmUsuari.lblbEmail.setIcon(cancel);
        }
        if (frmUsuari.DateDataNaixement.getDate() == null) {
            frmUsuari.lblbDnaixement.setIcon(cancel);
        }

        if ("admin".equals(SingletonUsuaris.us2.getTipus())) {
            tipus = frmUsuari.cmbTipusUsuari.getSelectedItem().toString();
        }

        String login = frmUsuari.txtUsuari.getText(); // usuari
        if (frmUsuari.txtUsuari.getText().isEmpty()) {
            frmUsuari.lblbUsuari.setIcon(cancel);
        } else {
            if (!Validate.isValidFormatUsuari(frmUsuari.txtUsuari.getText())) {
                frmUsuari.lblbUsuari.setIcon(cancel);
            } else {
                frmUsuari.lblbUsuari.setIcon(ok);
            }
        }

        char[] p = frmUsuari.txtPassword.getPassword();

        String passText = new String(p);
        if ("1234567a".equals(passText)) {
            password = SingletonUsuaris.us.getPassword();
        } else {
            password = Encriptar.encriptarTokenMD5(passText);
        }
        if (!Validate.isValidFormatPassword(passText)) {
            frmUsuari.lblbPassword.setIcon(cancel);
        } else {
            frmUsuari.lblbPassword.setIcon(ok);
        }

        String dni = frmUsuari.txtDni.getText();       // dni   
        if (frmUsuari.txtUsuari.getText().isEmpty()) {
            //frmUsuari.lblbDni.setIcon(cancel);
        } else {
            if (!Validate.isValidFormatDNI(frmUsuari.txtDni.getText())) {
                frmUsuari.lblbDni.setIcon(cancel);
            } else {
                frmUsuari.lblbDni.setIcon(ok);
                frmUsuari.txtDni.setText(Funcions.nifnie(dni));
            }
        }

        /*
         if (!Validate.isValidFormatDNI(frmUsuariModificacio.txtDni.getText())) {
         frmUsuariModificacio.lblbDni.setIcon(cancel);
         val1 = false;
         } else {
         if (GUBLL.cercarDniBLL(dni)) {
         if (!dni.equals(SingletonInici.us.getDni())) {
         frmUsuariModificacio.lblbDni.setIcon(cancel);
         Menus.warning("DNI ja donat d'alta!", "Usuaris");
         val1 = false;
         } else {
         val1 = true;
         frmUsuariModificacio.lblbDni.setIcon(ok);
         frmUsuariModificacio.txtDni.setText(Funcions.nifnie(dni));
         }
         }
         }
         */
        String nom = frmUsuari.txtNom.getText();           // nom
        if (frmUsuari.txtNom.getText().isEmpty()) {
            frmUsuari.lblbNom.setIcon(cancel);
        } else {
            if (!Validate.isValidFormatNom(frmUsuari.txtNom.getText())) {
                frmUsuari.lblbNom.setIcon(cancel);
            } else {
                frmUsuari.lblbNom.setIcon(ok);
            }
        }
        /*
        
         if (!Validate.isValidFormatNom(frmUsuariModificacio.txtNom.getText())) {
         frmUsuariModificacio.lblbNom.setIcon(cancel);
         } else {
         frmUsuariModificacio.lblbNom.setIcon(ok);
         }
         */

        String email = frmUsuari.txtEmail.getText();       // email
        if (frmUsuari.txtEmail.getText().isEmpty()) {
            frmUsuari.lblbEmail.setIcon(cancel);
        } else {
            if (!Validate.isValidFormatEmailAddress(frmUsuari.txtEmail.getText())) {
                frmUsuari.lblbEmail.setIcon(cancel);
            } else {
                frmUsuari.lblbEmail.setIcon(ok);
            }
        }
        /*
         if (!Validate.isValidFormatEmailAddress(frmUsuariModificacio.txtEmail.getText())) {
         frmUsuariModificacio.lblbEmail.setIcon(cancel);
         } else {
         frmUsuariModificacio.lblbEmail.setIcon(ok);
         }
         */

        // Data naixement
        try {

            // si el JDateChooser torna un String
            String dn = ((JTextFieldDateEditor) frmUsuari.DateDataNaixement.getDateEditor()).getText();
            datanaixement = new Data(dn, Core.conf.getFormatdata());    // datanaixement                               // datalta
            // si el JDateChooser torna un Date()   
            //datanaixement = new Data((FrmConfig.DateDataNaixement.getDate()));
            edat = Usuari.calcularEdat(datanaixement);          // edat
            if (edat < 16) {
                frmUsuari.lblbDnaixement.setIcon(cancel);
                Menus.warning("Ha de ser major de 16 anys", "Atenció");
            } else {
                frmUsuari.lblbDnaixement.setIcon(ok);
                frmUsuari.lblEdat.setText("" + edat);
            }
        } catch (Exception ex) {
            frmUsuari.lblbDnaixement.setIcon(cancel);
        }

        if ((frmUsuari.lblbDni.getIcon().equals(ok))
                && (frmUsuari.lblbEmail.getIcon().equals(ok))
                && (frmUsuari.lblbUsuari.getIcon().equals(ok))
                && (frmUsuari.lblbPassword.getIcon().equals(ok))
                && (frmUsuari.lblbNom.getIcon().equals(ok))
                && (frmUsuari.lblbDnaixement.getIcon().equals(ok))) {

            if ((dni != null) && (login != null) && (email != null)) {

                if (GUBLL.cercarDniBLL(dni)) {
                    if (!dni.equals(SingletonUsuaris.us.getDni())) {
                        frmUsuari.lblbDni.setIcon(cancel);
                        Menus.warning("DNI ja donat d'alta!", "Usuaris");
                        val1 = false;
                    } else {
                        val1 = true;
                    }
                } else {
                    val1 = true;
                }

                if (GUBLL.cercarUsuariBLL(login)) {
                    if (!login.equals(SingletonUsuaris.us.getLogin())) {
                        frmUsuari.lblbUsuari.setIcon(cancel);
                        Menus.warning("Usuari ja donat d'alta!", "Usuaris");
                        val2 = false;
                    } else {
                        val2 = true;
                    }
                } else {
                    val2 = true;
                }

                if (GUBLL.cercarEmailBLL(email)) {
                    if (!email.equals(SingletonUsuaris.us.getEmail())) {
                        frmUsuari.lblbEmail.setIcon(cancel);
                        Menus.warning("Email ja donat d'alta!", "Usuaris");
                        val3 = false;
                    } else {
                        val3 = true;
                    }
                } else {
                    val3 = true;
                }

                if ((val1) && (val2) && (val3)) {
                    if (Menus.confirmar("Guardar les dades?", "Guardar")) {
                        SingletonUsuaris.us = new Usuari(nom, dni, datanaixement,
                                edat, login, password, datalta, email, tipus, estat, avatar);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean afegirUsuariDAOGrafic() {
        boolean val1 = false, val2 = false, val3 = false;
        int edat = 0;
        byte estat = SingletonUsuaris.us2.getEstat();
        String avatar = SingletonUsuaris.us.getAvatar();
        Data datanaixement = null;
        Data datalta = Data.datactual();
        String password = null;

        if (frmUsuari.txtUsuari.getText().isEmpty()) {
            frmUsuari.lblUsuari.setIcon(cancel);
        }
        if (frmUsuari.txtDni.getText().isEmpty()) {
            frmUsuari.lblbDni.setIcon(cancel);
        }
        if (frmUsuari.txtNom.getText().isEmpty()) {
            frmUsuari.lblbNom.setIcon(cancel);
        }
        if (frmUsuari.txtEmail.getText().isEmpty()) {
            frmUsuari.lblbEmail.setIcon(cancel);
        }
        if (frmUsuari.DateDataNaixement.getDate() == null) {
            frmUsuari.lblbDnaixement.setIcon(cancel);
        }

        String tipus = frmUsuari.cmbTipusUsuari.getSelectedItem().toString();

        String login = frmUsuari.txtUsuari.getText(); // usuari
        if (frmUsuari.txtUsuari.getText().isEmpty()) {
            frmUsuari.lblbUsuari.setIcon(cancel);
        } else {
            if (!Validate.isValidFormatUsuari(frmUsuari.txtUsuari.getText())) {
                frmUsuari.lblbUsuari.setIcon(cancel);
            } else {
                frmUsuari.lblbUsuari.setIcon(ok);
            }
        }

        char[] p = frmUsuari.txtPassword.getPassword();

        String passText = new String(p);
        password = Encriptar.encriptarTokenMD5(passText);

        if (!Validate.isValidFormatPassword(passText)) {
            frmUsuari.lblbPassword.setIcon(cancel);
        } else {
            frmUsuari.lblbPassword.setIcon(ok);
        }

        String dni = frmUsuari.txtDni.getText();       // dni   
        if (frmUsuari.txtUsuari.getText().isEmpty()) {
            frmUsuari.lblbDni.setIcon(cancel);
        } else {
            if (!Validate.isValidFormatDNI(frmUsuari.txtDni.getText())) {
                frmUsuari.lblbDni.setIcon(cancel);
            } else {
                frmUsuari.lblbDni.setIcon(ok);
                frmUsuari.txtDni.setText(Funcions.nifnie(dni));
            }
        }

        String nom = frmUsuari.txtNom.getText();           // nom
        if (frmUsuari.txtNom.getText().isEmpty()) {
            frmUsuari.lblbNom.setIcon(cancel);
        } else {
            if (!Validate.isValidFormatNom(frmUsuari.txtNom.getText())) {
                frmUsuari.lblbNom.setIcon(cancel);
            } else {
                frmUsuari.lblbNom.setIcon(ok);
            }
        }

        String email = frmUsuari.txtEmail.getText();       // email
        if (frmUsuari.txtEmail.getText().isEmpty()) {
            frmUsuari.lblbEmail.setIcon(cancel);
        } else {
            if (!Validate.isValidFormatEmailAddress(frmUsuari.txtEmail.getText())) {
                frmUsuari.lblbEmail.setIcon(cancel);
            } else {
                frmUsuari.lblbEmail.setIcon(ok);
            }
        }

        // Data naixement
        try {

            // si el JDateChooser torna un String
            String dn = ((JTextFieldDateEditor) frmUsuari.DateDataNaixement.getDateEditor()).getText();
            datanaixement = new Data(dn, Core.conf.getFormatdata());    // datanaixement                               // datalta
            // si el JDateChooser torna un Date()   
            //datanaixement = new Data((FrmConfig.DateDataNaixement.getDate()));
            edat = Usuari.calcularEdat(datanaixement);          // edat
            if (edat < 16) {
                frmUsuari.lblbDnaixement.setIcon(cancel);
                Menus.warning("Ha de ser major de 16 anys", "Atenció");
            } else {
                frmUsuari.lblbDnaixement.setIcon(ok);
                frmUsuari.lblEdat.setText("" + edat);
            }
        } catch (Exception ex) {
            frmUsuari.lblbDnaixement.setIcon(cancel);
        }

        if ((frmUsuari.lblbDni.getIcon().equals(ok))
                && (frmUsuari.lblbEmail.getIcon().equals(ok))
                && (frmUsuari.lblbUsuari.getIcon().equals(ok))
                && (frmUsuari.lblbPassword.getIcon().equals(ok))
                && (frmUsuari.lblbNom.getIcon().equals(ok))
                && (frmUsuari.lblbDnaixement.getIcon().equals(ok))) {

            if ((dni != null) && (login != null) && (email != null)) {

                if (GUBLL.cercarDniBLL(dni)) {
                    if (!dni.equals(SingletonUsuaris.us.getDni())) {
                        frmUsuari.lblbDni.setIcon(cancel);
                        Menus.warning("DNI ja donat d'alta!", "Usuaris");
                        val1 = false;
                    } else {
                        val1 = true;
                    }
                } else {
                    val1 = true;
                }

                if (GUBLL.cercarUsuariBLL(login)) {
                    if (!login.equals(SingletonUsuaris.us.getLogin())) {
                        frmUsuari.lblbUsuari.setIcon(cancel);
                        Menus.warning("Usuari ja donat d'alta!", "Usuaris");
                        val2 = false;
                    } else {
                        val2 = true;
                    }
                } else {
                    val2 = true;
                }

                if (GUBLL.cercarEmailBLL(email)) {
                    if (!email.equals(SingletonUsuaris.us.getEmail())) {
                        frmUsuari.lblbEmail.setIcon(cancel);
                        Menus.warning("Email ja donat d'alta!", "Usuaris");
                        val3 = false;
                    } else {
                        val3 = true;
                    }
                } else {
                    val3 = true;
                }

                if ((val1) && (val2) && (val3)) {
                    if (Menus.confirmar("Guardar les dades?", "Guardar")) {
                        SingletonUsuaris.us = new Usuari(nom, dni, datanaixement,
                                edat, login, password, datalta, email, tipus, estat, avatar);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void omplirCampsMDAO() {

        frmUsuari.txtUsuari.setText(SingletonUsuaris.us.getLogin());
        frmUsuari.txtPassword.setText("1234567a"); // pinta un pass sense encriptar
        frmUsuari.txtDni.setText(SingletonUsuaris.us.getDni());
        frmUsuari.txtNom.setText(SingletonUsuaris.us.getNom());
        frmUsuari.txtEmail.setText(SingletonUsuaris.us.getEmail());
        frmUsuari.DateDataNaixement.setDate(Data.datatodate(SingletonUsuaris.us.getDatanaixement()));
        frmUsuari.cmbTipusUsuari.setSelectedItem(SingletonUsuaris.us.getTipus());

        frmUsuari.lblEdat.setText(Integer.toString(SingletonUsuaris.us.getEdat()));

        frmUsuari.lblbUsuari.setIcon(buit);
        frmUsuari.lblbPassword.setIcon(buit);
        frmUsuari.lblbDni.setIcon(buit);
        frmUsuari.lblbNom.setIcon(buit);
        frmUsuari.lblbEmail.setIcon(buit);
        frmUsuari.lblbDnaixement.setIcon(buit);

    }

}
