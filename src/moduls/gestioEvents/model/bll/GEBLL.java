/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioEvents.model.bll;

import classes.Connexio;
import java.sql.Connection;
import javax.swing.DefaultComboBoxModel;
import static moduls.gestioEvents.controlador.ControladorEvents.frmEvents;
import moduls.gestioEvents.model.classes.SingletonEvent;
import moduls.gestioEvents.model.dao.GEDAOBd;
import moduls.gestioEvents.model.dao.GEDAOGrafic;
import moduls.gestioTipusEvent.model.classes.SingletonTipusEvent;
import moduls.gestioTipusEvent.model.dao.GTEDAOBd;
import moduls.gestioUsuaris.model.classes.SingletonUsuari;

/**
 *
 * @author Vicent
 */
public class GEBLL {

    public static boolean omplirArrayComboBLL() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GTEDAOBd.cercarTipusEventDAO(conn)) {
                omplirCombo();
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static void omplirCombo() {
        String tipus;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Selecciona de la llista");
        for (int i = 1; i < (SingletonTipusEvent.tevntAl.size()); i++) {
            tipus = SingletonTipusEvent.tevntAl.get(i).getTipusevent();
            model.addElement(tipus);
        }

        frmEvents.cmbTipus.setModel(model);
    }

    public static boolean omplirEvent() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GEDAOBd.darrerEventDAO(conn)) {
                frmEvents.txtEvent.setText(Integer.toString(SingletonEvent.ev.getIdevent()));
                String usuari = SingletonUsuari.us2.getLogin();
                frmEvents.txtUsuari.setText(usuari);
                Connexio.desconnectar(conn);
                return true;
            }
        }
        return false;
    }

    public static boolean guardarEvent() {
        if (GEDAOGrafic.guardarEventDAO()) {
            Connection conn = Connexio.connectar();
            if (conn != null) {
                if (GEDAOBd.afegirEventDAO(conn) == 1) {
                    Connexio.desconnectar(conn);
                    return true;
                }
            }
        }
        return false;
    }

}
