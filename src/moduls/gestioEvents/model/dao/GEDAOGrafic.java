/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioEvents.model.dao;

import classes.Data;
import static moduls.gestioEvents.controlador.ControladorEvents.frmEvents;
import moduls.gestioEvents.model.classes.Event;
import moduls.gestioEvents.model.classes.SingletonEvent;
import static moduls.gestioInici.model.classes.SingletonInici.cancel;
import static moduls.gestioInici.model.classes.SingletonInici.ok;

/**
 *
 * @author Vicent
 */
public class GEDAOGrafic {

    public static boolean guardarEventDAO() {
        int idevent;
        Data dataevent = null;
        Data dataidevent = Data.datactual();
        String login, observacionsevent;

        idevent = Integer.valueOf(frmEvents.txtEvent.getText());
        login = frmEvents.txtUsuari.getText();
        observacionsevent = frmEvents.txtObservacions.getText();

        if (frmEvents.dataEvent.getDate() == null) {
            frmEvents.lblbDataEvent.setIcon(cancel);
        }

        try {
            dataevent = new Data(frmEvents.dataEvent.getDate());
            frmEvents.lblbDataEvent.setIcon(ok);
        } catch (Exception ex) {
            frmEvents.lblbDataEvent.setIcon(cancel);
        }

        try {
            if ((Data.comparaDatadespres(dataevent, dataidevent))) {
                frmEvents.lblbDataEvent.setIcon(ok);
            } else {
                frmEvents.lblbDataEvent.setIcon(cancel);
            }
        } catch (Exception ex) {
            frmEvents.lblbDataEvent.setIcon(cancel);
        }

        if (frmEvents.lblbDataEvent.getIcon().equals(ok)) {
            String[] da = new String[2];
            String tipusevent = (String) frmEvents.cmbTipus.getSelectedItem();
            if (tipusevent != "Selecciona de la llista") {

                SingletonEvent.ev = new Event(idevent, login, tipusevent,
                        dataidevent, dataevent, observacionsevent);
                return true;
            }
        }

        return false;
    }

}
