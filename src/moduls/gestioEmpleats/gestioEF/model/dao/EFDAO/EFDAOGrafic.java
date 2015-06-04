/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioEmpleats.gestioEF.model.dao.EFDAO;

import classes.Data;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.JViewport;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import llibreries.Upload;
import main.Core;
import moduls.gestioEmpleats.classes.Empleat;
import static moduls.gestioEmpleats.gestioEF.controlador.ControladorEF.frmAltaEF;
import static moduls.gestioEmpleats.gestioEF.controlador.ControladorEF.frmModiEF;
import static moduls.gestioEmpleats.gestioEF.controlador.ControladorEF.frmPagerEF;
import static moduls.gestioEmpleats.gestioEF.controlador.ControladorEF.frmPagerEF;
import moduls.gestioEmpleats.gestioEF.model.bll.EFBLL;
import moduls.gestioEmpleats.gestioEF.model.classes.EmpleatFix;
import moduls.gestioEmpleats.gestioEF.model.classes.SimpleTableModelEF;
import moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF;
import moduls.gestioEmpleats.gestioEF.pager.Pagina;
import static moduls.gestioInici.model.classes.SingletonInici.avatar_temp;
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
        String avatar = SingletonEF.ef.getAvatar();
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
        String tipus = "user", avatar = avatar_temp;
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

    public static int posicioAbsolutaDAOGrafic() {
        int n, selection, inicio, selection1 = 0;
        n = ((SimpleTableModelEF) frmPagerEF.taula.getModel()).getRowCount();
        if (n != 0) {
            inicio = (Pagina.currentPageIndex - 1) * Pagina.itemsPerPage;
            selection = frmPagerEF.taula.getSelectedRow();
            selection1 = inicio + selection;
        } else {
            selection1 = -1;
        }
        return selection1;
    }

    /**
     * personalitzem l'ample de les columnes
     */
    public static void setAmpleColumnesDAOGrafic() {
        JViewport scroll = (JViewport) frmPagerEF.taula.getParent();
        int ample = scroll.getWidth();
        int ampleColumna = 0;
        TableColumnModel modelColumna = frmPagerEF.taula.getColumnModel();
        TableColumn columnaTaula;
        for (int i = 0; i < frmPagerEF.taula.getColumnCount(); i++) {
            columnaTaula = modelColumna.getColumn(i);
            switch (i) {
                case 0:
                    ampleColumna = (17 * ample) / 100;
                    break;
                case 1:
                    ampleColumna = (30 * ample) / 100;
                    break;
                case 2:
                    ampleColumna = (18 * ample) / 100;
                    break;
                case 3:
                    ampleColumna = (18 * ample) / 100;
                    break;
                case 4:
                    ampleColumna = (17 * ample) / 100;
                    break;
            }
            columnaTaula.setPreferredWidth(ampleColumna);
        }
    }

    /**
     *
     */
    public static void omplirCampsMDAOGrafic() {
        float soubase1 = SingletonEF.ef.getSoubase();
        float soubase2 = soubase1 * Core.conf.getFactorconv();
        float sou1 = SingletonEF.ef.getSou();
        float sou2 = sou1 * Core.conf.getFactorconv();

        Upload.pintar_imatge(frmModiEF.lblAvatar, 80, 80, SingletonEF.ef.getAvatar());
        frmModiEF.txtDni.setText(SingletonEF.ef.getDni());
        frmModiEF.txtNom.setText(SingletonEF.ef.getNom());
        frmModiEF.txtEmail.setText(SingletonEF.ef.getEmail());
        frmModiEF.DateDataNaixement.setDate(Data.datatodate(SingletonEF.ef.getDatanaixement()));

        frmModiEF.DateDatacontratacio.setDate(Data.datatodate(SingletonEF.ef.getDatacontratacio()));
        frmModiEF.txtSalariBase.setText("" + soubase2);
        frmModiEF.lblEdat.setText("" + SingletonEF.ef.getEdat());
        frmModiEF.lblAntiguitat1.setText("" + SingletonEF.ef.getAntiguitat());
        frmModiEF.lblAntiguitat2.setText("" + SingletonEF.ef.getPercent());
        frmModiEF.lblSalari.setText(Format.formatConfig(sou2, Core.conf));
        frmModiEF.lblbDni.setIcon(buit);
        frmModiEF.lblbNom.setIcon(buit);
        frmModiEF.lblbDnaixement.setIcon(buit);
        frmModiEF.lblbDcontratacio.setIcon(buit);
        frmModiEF.lblbSalariBase.setIcon(buit);
        frmModiEF.lblbEmail.setIcon(buit);
    }

    public static void cancelarEFADAOGrafic() {
        frmAltaEF.txtNom.setText(null);
        frmAltaEF.txtDni.setText(null);
        frmAltaEF.DateDataNaixement.setCalendar(null);
        frmAltaEF.DateDatacontratacio.setCalendar(null);
        frmAltaEF.txtSalariBase.setText(null);
        frmAltaEF.lblEdat.setText(null);
        frmAltaEF.lblSalari.setText(null);
        frmAltaEF.lblbDni.setIcon(buit);
        frmAltaEF.lblbNom.setIcon(buit);
        frmAltaEF.lblbSalariBase.setIcon(buit);
        frmAltaEF.lblbDnaixement.setIcon(buit);
        frmAltaEF.lblbDcontratacio.setIcon(buit);
        frmAltaEF.lblAntiguitat1.setText(null);
        frmAltaEF.lblAntiguitat2.setText(null);
        frmAltaEF.txtDni.requestFocus();
    }
}
