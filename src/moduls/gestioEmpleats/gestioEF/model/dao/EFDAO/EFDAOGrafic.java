/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioEmpleats.gestioEF.model.dao.EFDAO;

import classes.Data;
import com.toedter.calendar.JTextFieldDateEditor;
import main.Core;
import moduls.gestioEmpleats.classes.Empleat;
import static moduls.gestioEmpleats.gestioEF.controlador.ControladorEF.frmAltaEF;
import static moduls.gestioEmpleats.gestioEF.controlador.ControladorEF.frmModiEF;
import moduls.gestioEmpleats.gestioEF.model.bll.EFBLL;
import moduls.gestioEmpleats.gestioEF.model.classes.EmpleatFix;
import moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF;
import static moduls.gestioInici.model.classes.SingletonInici.buit;
import static moduls.gestioInici.model.classes.SingletonInici.cancel;
import static moduls.gestioInici.model.classes.SingletonInici.ok;
import utils.Format;
import utils.Funcions;
import utils.Menus;
import utils.Validate;

/**
 *
 * @author Vicent
 */
public class EFDAOGrafic {

    public static void validarNomAEFDAO() {
        if (frmAltaEF.txtNom.getText().isEmpty()) {
            frmAltaEF.lblbNom.setIcon(buit);
        } else {
            if (!Validate.isValidFormatNom(frmAltaEF.txtNom.getText())) {
                frmAltaEF.lblbNom.setIcon(cancel);
            } else {
                frmAltaEF.lblbNom.setIcon(ok);
            }
        }
    }

    private void validarNomMDAO() {
        if (frmModiEF.txtNom.getText().isEmpty()) {
            frmModiEF.lblbNom.setIcon(buit);
        } else {
            if (!Validate.isValidFormatNom(frmModiEF.txtNom.getText())) {
                frmModiEF.lblbNom.setIcon(cancel);
            } else {
                frmModiEF.lblbNom.setIcon(ok);
            }
        }
    }

    public static void validarDniDAO() {
        if (frmAltaEF.txtDni.getText().isEmpty()) {
            frmAltaEF.lblbDni.setIcon(buit);
        } else {
            if (!Validate.isValidFormatDNI(frmAltaEF.txtDni.getText())) { // valida si té un format de dni-nie
                frmAltaEF.lblbDni.setIcon(cancel);
            } else {
                frmAltaEF.txtDni.setText(Funcions.nifnie(frmAltaEF.txtDni.getText())); // canvia la lletra de dni si és incorrecta
            }
        }
    }

    public static void validarEmailMDAO() {
        if (frmModiEF.txtEmail.getText().isEmpty()) {
            frmModiEF.lblbEmail.setIcon(buit);
        } else {
            if (!Validate.isValidFormatEmailAddress(frmModiEF.txtEmail.getText())) {
                frmModiEF.lblbEmail.setIcon(cancel);
            } else {
                frmModiEF.lblbEmail.setIcon(ok);
            }
        }
    }

    public static boolean validarSalariADAO() {
        if (frmAltaEF.txtSalariBase.getText().isEmpty()) {
            frmAltaEF.lblbSalariBase.setIcon(buit);
        } else {
            if (!Validate.isValidFormatNombre(frmAltaEF.txtSalariBase.getText())) {
                frmAltaEF.lblbSalariBase.setIcon(cancel);
            } else {
                frmAltaEF.lblbSalariBase.setIcon(ok);
                return true;
            }
        }
        return false;
    }

    public static void validarSalariMDAO() {
        if (frmModiEF.txtSalariBase.getText().isEmpty()) {
            frmModiEF.lblbSalariBase.setIcon(buit);
        } else {
            if (!Validate.isValidFormatNombre(frmModiEF.txtSalariBase.getText())) {
                frmModiEF.lblbSalariBase.setIcon(cancel);
            } else {
                frmModiEF.lblbSalariBase.setIcon(ok);
            }
        }
    }

    public static void validarEmailADAO() {
        if (frmAltaEF.txtEmail.getText().isEmpty()) {
            frmAltaEF.lblbEmail.setIcon(buit);
        } else {
            if (!Validate.isValidFormatEmailAddress(frmAltaEF.txtEmail.getText())) {
                frmAltaEF.lblbEmail.setIcon(cancel);
            } else {
                frmAltaEF.lblbEmail.setIcon(ok);
            }
        }
    }

    public static boolean demanaSalariADAO() {
        // Salari Base
        if (frmAltaEF.txtSalariBase.getText().isEmpty()) {
            frmAltaEF.lblbSalariBase.setIcon(buit);
        } else {
            if (!Validate.isValidFormatNombre(frmAltaEF.txtSalariBase.getText())) { // valida si té un format
                frmAltaEF.lblbSalariBase.setIcon(cancel);
            } else {
                frmAltaEF.lblbDni.setIcon(ok);
                return true;
            }
        }
        return false;
    }
    
    public static boolean demanaSalariMDAO() {
        // Salari Base
        if (frmModiEF.txtSalariBase.getText().isEmpty()) {
            frmModiEF.lblbSalariBase.setIcon(buit);
        } else {
            if (!Validate.isValidFormatNombre(frmModiEF.txtSalariBase.getText())) { // valida si té un format
                frmModiEF.lblbSalariBase.setIcon(cancel);
            } else {
                frmModiEF.lblbDni.setIcon(ok);
                return true;                
            }
        }
        return false;
    }    

    public static boolean demanaDniEFDAO() {
        if (Validate.isValidFormatDNI(frmAltaEF.txtDni.getText())) {
            if (EFBLL.cercarBLL(frmAltaEF.txtDni.getText())) {
                frmAltaEF.lblbDni.setIcon(cancel);
                Menus.warning("DNI ja donat d'alta!", "Empleat Fix");
            } else {
                if (Validate.isValidFormatDNI(frmAltaEF.txtDni.getText())) {
                    frmAltaEF.lblbDni.setIcon(ok);
                    return true;

                } else {
                    frmAltaEF.lblbDni.setIcon(cancel);
                }
            }
        }
        return false;
    }

    public static void guardarMEFDAO() {
        SingletonEF.ef = null;
        int difer = 0;
        int antiguitat = 0;
        int edat = 0;
        byte estat = 0;
        float soubase = 0.0f;
        float sou = 0.0f;
        float percent = 0.0f;
        String nom = null, dni = "", login = null, password = null, email = null, tipus = null;
        Data datanaixement = null;
        Data datacontratacio = null;

        // si els camps no tenen dades
        if (frmModiEF.txtNom.getText().isEmpty()) {
            frmModiEF.lblbNom.setIcon(cancel);
        }
        if (frmModiEF.txtEmail.getText().isEmpty()) {
            frmModiEF.lblbEmail.setIcon(cancel);
        }
        if (frmModiEF.DateDataNaixement.getDate() == null) {
            frmModiEF.lblbDnaixement.setIcon(cancel);
        }
        if (frmModiEF.DateDatacontratacio.getDate() == null) {
            frmModiEF.lblbDcontratacio.setIcon(cancel);
        }
        if (frmModiEF.txtSalariBase.getText().isEmpty()) {
            frmModiEF.lblbSalariBase.setIcon(cancel);
        }

        if (!Validate.isValidFormatNom(frmModiEF.txtNom.getText())) {
            frmModiEF.lblbNom.setIcon(cancel);
        } else {
            frmModiEF.lblbNom.setIcon(ok);
            nom = frmModiEF.txtNom.getText();
        }

        if (!Validate.isValidFormatEmailAddress(frmModiEF.txtEmail.getText())) {
            frmModiEF.lblbEmail.setIcon(cancel);
        } else {
            frmModiEF.lblbEmail.setIcon(ok);
            email = frmModiEF.txtEmail.getText();
        }

        // Data naixement
        try {

            // si el JDateChooser torna un String
            String dn = ((JTextFieldDateEditor) frmModiEF.DateDataNaixement.getDateEditor()).getText();
            datanaixement = new Data(dn, Core.conf.getFormatdata());

            // si el JDateChooser torna un Date()   
            //datanaixement = new Data((FrmConfig.DateDataNaixement.getDate()));
            edat = Empleat.calcularEdat(datanaixement);
            if (edat < 16) {
                frmModiEF.lblbDnaixement.setIcon(cancel);
                Menus.warning("Ha de ser major de 16 anys", "Atenció");
            } else {
                frmModiEF.lblbDnaixement.setIcon(ok);
                frmModiEF.lblEdat.setText("" + edat);
            }
        } catch (Exception ex) {
            frmModiEF.lblbDnaixement.setIcon(cancel);
        }

        // Data contratacio
        try {
            datacontratacio = new Data(frmModiEF.DateDatacontratacio.getDate());
            frmModiEF.lblbDcontratacio.setIcon(ok);
        } catch (Exception ex) {
            frmModiEF.lblbDcontratacio.setIcon(cancel);
        }
        try {
            difer = Data.diferanys(datanaixement, datacontratacio);
            if ((difer >= 16) && (Data.comparaDatadespres(datacontratacio, datanaixement))) { // difer
                antiguitat = EmpleatFix.calcularAntiguitat(datacontratacio);
                percent = EmpleatFix.calcularPercent(antiguitat);
                frmModiEF.lblAntiguitat1.setText(Integer.toString(antiguitat));
                frmModiEF.lblAntiguitat2.setText(Float.toString(percent));
                frmModiEF.lblbDcontratacio.setIcon(ok);
            }
        } catch (Exception ex) {
            frmModiEF.lblbDcontratacio.setIcon(cancel);
        }

        // Salari Base        
        try {
            soubase = Float.parseFloat(frmModiEF.txtSalariBase.getText());
            if (soubase >= 0) {
                sou = soubase * (1 + (percent / 100));
                frmModiEF.lblSalari.setText(Format.formatConfig(sou, Core.conf));
                frmModiEF.lblbSalariBase.setIcon(ok);
            } else {
                soubase = 1 / 0;
            }
        } catch (Exception ex) {
            frmModiEF.lblbSalariBase.setIcon(cancel);
            frmModiEF.lblSalari.setText(null);
        }

        if ((frmModiEF.lblbNom.getIcon().equals(ok))
                && (frmModiEF.lblbSalariBase.getIcon().equals(ok))
                && (frmModiEF.lblbEmail.getIcon().equals(ok))
                && (frmModiEF.lblbDcontratacio.getIcon().equals(ok))
                && (frmModiEF.lblbDnaixement.getIcon().equals(ok))) {
            dni = frmModiEF.txtDni.getText();

            String avatar = "";

            if (Menus.confirmar("Guardar les dades?", "Guardar")) {
                SingletonEF.ef = new EmpleatFix(nom, dni, datanaixement, edat, soubase, sou, login, password, email, tipus, estat, avatar,
                        datacontratacio, antiguitat, percent);
            }
        }
    }

    public static void guardarAEFDAO() {
        SingletonEF.ef = null;
        int difer = 0;
        int antiguitat = 0;
        int edat = 0;
        float soubase = 0.0f;
        float sou = 0.0f;
        float percent = 0.0f;
        byte estat = 0;
        String login = null, password = null, email = null;
        String tipus = "user", avatar = "src/images/avatar.png";
        String nom = "";
        String dni = "";
        Data datanaixement = null;
        Data datacontratacio = null;

        if (frmAltaEF.txtDni.getText().isEmpty()) {
            frmAltaEF.lblbDni.setIcon(cancel);
        }
        if (frmAltaEF.txtNom.getText().isEmpty()) {
            frmAltaEF.lblbNom.setIcon(cancel);
        }
        if (frmAltaEF.txtEmail.getText().isEmpty()) {
            frmAltaEF.lblbEmail.setIcon(cancel);
        }
        if (frmAltaEF.DateDataNaixement.getDate() == null) {
            frmAltaEF.lblbDnaixement.setIcon(cancel);
        }
        if (frmAltaEF.DateDatacontratacio.getDate() == null) {
            frmAltaEF.lblbDcontratacio.setIcon(cancel);
        }
        if (frmAltaEF.txtSalariBase.getText().isEmpty()) {
            frmAltaEF.lblbSalariBase.setIcon(cancel);
        }

        if (!Validate.isValidFormatNom(frmAltaEF.txtNom.getText())) {
            frmAltaEF.lblbNom.setIcon(cancel);
        } else {
            frmAltaEF.lblbNom.setIcon(ok);
            nom = frmAltaEF.txtNom.getText();
        }

        if (!Validate.isValidFormatEmailAddress(frmAltaEF.txtEmail.getText())) {
            frmAltaEF.lblbEmail.setIcon(cancel);
        } else {
            frmAltaEF.lblbEmail.setIcon(ok);
            email = frmAltaEF.txtEmail.getText();
        }

        dni = frmAltaEF.txtDni.getText();
        if (!Validate.isValidFormatDNI(dni)) {
            frmAltaEF.lblbDni.setIcon(cancel);
        } else {
            int pos = EFBLL.cercarEmpleat(dni);
            if (pos != -1) {
                frmAltaEF.lblbDni.setIcon(cancel);
                Menus.warning("DNI ja donat d'alta!", "Empleat Fix");
            } else {
                frmAltaEF.lblbDni.setIcon(ok);
                frmAltaEF.txtDni.setText(Funcions.nifnie(dni));
            }
        }

        // Data naixement
        try {

            // si el JDateChooser torna un String
            String dn = ((JTextFieldDateEditor) frmAltaEF.DateDataNaixement.getDateEditor()).getText();
            datanaixement = new Data(dn, Core.conf.getFormatdata());

            // si el JDateChooser torna un Date()   
            //datanaixement = new Data((FrmConfig.DateDataNaixement.getDate()));
            edat = Empleat.calcularEdat(datanaixement);
            if (edat < 16) {
                frmAltaEF.lblbDnaixement.setIcon(cancel);
                Menus.warning("Ha de ser major de 16 anys", "Atenció");
            } else {
                frmAltaEF.lblbDnaixement.setIcon(ok);
                frmAltaEF.lblEdat.setText("" + edat);
            }
        } catch (Exception ex) {
            frmAltaEF.lblbDnaixement.setIcon(cancel);
        }

        // Data contratacio
        try {
            datacontratacio = new Data(frmAltaEF.DateDatacontratacio.getDate());
            frmAltaEF.lblbDcontratacio.setIcon(ok);
        } catch (Exception ex) {
            frmAltaEF.lblbDcontratacio.setIcon(cancel);
        }
        try {
            difer = Data.diferanys(datanaixement, datacontratacio);
            if ((difer >= 16) && (Data.comparaDatadespres(datacontratacio, datanaixement))) { // difer
                antiguitat = EmpleatFix.calcularAntiguitat(datacontratacio);
                percent = EmpleatFix.calcularPercent(antiguitat);
                frmAltaEF.lblAntiguitat1.setText(Integer.toString(antiguitat));
                frmAltaEF.lblAntiguitat2.setText(Float.toString(percent));
                frmAltaEF.lblbDcontratacio.setIcon(ok);
            }
        } catch (Exception ex) {
            frmAltaEF.lblbDcontratacio.setIcon(cancel);
        }

        // Salari Base        
        try {
            soubase = Float.parseFloat(frmAltaEF.txtSalariBase.getText());
            if (soubase >= 0) {
                sou = soubase * (1 + (percent / 100));
                frmAltaEF.lblSalari.setText(Format.formatConfig(sou, Core.conf));
                frmAltaEF.lblbSalariBase.setIcon(ok);
            } else {
                soubase = 1 / 0;
            }
        } catch (Exception ex) {
            frmAltaEF.lblbSalariBase.setIcon(cancel);
            frmAltaEF.lblSalari.setText(null);
        }

        if ((frmAltaEF.lblbDni.getIcon().equals(ok))
                && (frmAltaEF.lblbNom.getIcon().equals(ok))
                && (frmAltaEF.lblbEmail.getIcon().equals(ok))
                && (frmAltaEF.lblbSalariBase.getIcon().equals(ok))
                && (frmAltaEF.lblbDcontratacio.getIcon().equals(ok))
                && (frmAltaEF.lblbDnaixement.getIcon().equals(ok))) {

            if (dni != null) {

                if (EFBLL.cercarBLL(dni)) {
                    frmAltaEF.lblbDni.setIcon(cancel);
                    Menus.warning("DNI ja donat d'alta!", "Empleat Fix");
                } else {
                    if (Menus.confirmar("Guardar les dades?", "Guardar")) {

                        SingletonEF.ef = new EmpleatFix(nom, dni, datanaixement, edat, soubase, sou, login, password, email, tipus, estat, avatar,
                                datacontratacio, antiguitat, percent);
                        System.out.println(SingletonEF.ef.getDatacontratacio());
                    }
                }
            }
        }
    }

}
