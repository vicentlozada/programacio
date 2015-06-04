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
import utils.Menus;

/**
 *
 * @author Vicent
 */
public class GEBLL {

    public static boolean omplirArrayComboBLL() {
        Connection conn = Connexio.connectar();
        if (conn != null) {
            if (GTEDAOBd.omplirArrayTipusEventDAO(conn)) {
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

    public static boolean nouEvent() {
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

    public static void cercarEvent() {
        int pos = buscarIdEvent();
        if (pos != -1) {
            SingletonEvent.ev = SingletonEvent.evAL.get(pos);
        }
    }

    public static int buscarIdEvent() {
        int pos = -1;
        for (int i = 0; i < SingletonEvent.evAL.size(); i++) {
            if ((SingletonEvent.evAL.get(i)).getIdevent() == SingletonEvent.ev.getIdevent()) {
                System.out.println(SingletonEvent.evAL.get(i).getLogin());
                pos = i;
            }
        }
        return pos;
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
    
    public static boolean modificarEvent() {
        if (GEDAOGrafic.guardarEventDAO()) {
            Connection conn = Connexio.connectar();
            if (conn != null) {
                if (GEDAOBd.updateEventDAOBd(conn) == 1) {
                    Connexio.desconnectar(conn);
                    return true;
                }
            }
        }
        return false;
    }    

    public static void setAmpleColumnesBLL() {
        GEDAOGrafic.setAmpleColumnesDAO();
    }

    public static int posicioAbsolutaBLL() {
        return GEDAOGrafic.posicioAbsolutaDAO();
    }

    public static boolean eliminarEV() {
        int idevent;
        int pos = buscarIdEvent();
        if (pos != -1) {
            idevent = SingletonEvent.evAL.get(pos).getIdevent();
            Boolean correcte = Menus.confirmar("Eliminar\n"
                    + "Event núm.: " + SingletonEvent.evAL.get(pos).getIdevent() + "?", "Eliminar Event");
            if (correcte) {
                Connection conn = Connexio.connectar();
                if (conn != null) {
                    if (GEDAOBd.eliminarEventDAOBd(idevent, conn) == 1) {
                        Connexio.desconnectar(conn);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void omplirCampsMBLL() {
        GEDAOGrafic.omplirCampsMDAO();
    }

}
