/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioEvents.model.dao;

import classes.Data;
import javax.swing.JViewport;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import static moduls.gestioEvents.controlador.ControladorEvents.frmEvents;
import static moduls.gestioEvents.controlador.ControladorEvents.frmPagerEvent;
import moduls.gestioEvents.model.classes.Event;
import moduls.gestioEvents.model.classes.SimpleTableModelEV;
import moduls.gestioEvents.model.classes.SingletonEvent;
import moduls.gestioEvents.pager.Pagina;
import static moduls.gestioInici.model.classes.SingletonInici.buit;
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

    /**
     * personalitzem l'ample de les columnes
     */
    public static void setAmpleColumnesDAO() {
        JViewport scroll = (JViewport) frmPagerEvent.taula.getParent();
        int ample = scroll.getWidth();
        int ampleColumna = 0;
        TableColumnModel modelColumna = frmPagerEvent.taula.getColumnModel();
        TableColumn columnaTaula;
        for (int i = 0; i < frmPagerEvent.taula.getColumnCount(); i++) {
            columnaTaula = modelColumna.getColumn(i);
            switch (i) {
                case 0:
                    ampleColumna = (25 * ample) / 100;
                    break;
                case 1:
                    ampleColumna = (25 * ample) / 100;
                    break;
                case 2:
                    ampleColumna = (25 * ample) / 100;
                    break;
                case 3:
                    ampleColumna = (25 * ample) / 100;
                    break;
            }
            columnaTaula.setPreferredWidth(ampleColumna);
        }
    }

    public static int posicioAbsolutaDAO() {
        int n, selection, inicio, selection1 = 0;
        n = ((SimpleTableModelEV) frmPagerEvent.taula.getModel()).getRowCount();
        if (n != 0) {
            inicio = (Pagina.currentPageIndex - 1) * Pagina.itemsPerPage;
            selection = frmPagerEvent.taula.getSelectedRow();
            selection1 = inicio + selection;
        } else {
            selection1 = -1;
        }
        return selection1;
    }

    public static void omplirCampsMDAO() {

        frmEvents.txtEvent.setText(Integer.toString(SingletonEvent.ev.getIdevent()));
        frmEvents.txtUsuari.setText(SingletonEvent.ev.getLogin());
        frmEvents.cmbTipus.setSelectedItem(SingletonEvent.ev.getTipusevent());
        frmEvents.txtObservacions.setText(SingletonEvent.ev.getObservacionsevent());
        frmEvents.dataEvent.setDate(Data.datatodate(SingletonEvent.ev.getDataevent()));
        
        frmEvents.lblbDataEvent.setIcon(buit);        

    }

}
