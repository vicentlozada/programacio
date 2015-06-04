/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioEvents.model.classes;

import classes.Connexio;
import classes.Data;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import moduls.gestioEvents.model.dao.GEDAOBd;
import moduls.gestioEvents.pager.Pagina;
import moduls.gestioEvents.vista.FrmPagerEvent;
import moduls.gestioUsuaris.model.classes.SingletonUsuari;

/**
 *
 * @author Vicent
 */
public class SimpleTableModelEV extends AbstractTableModel {

    public static ArrayList<Event> dades = new ArrayList<>();
    public static ArrayList<Event> dadesauxiliar = new ArrayList<>();
    String[] columnes = {"Núm. Event", "Data Reserva", "Tipus Event", "Data Event"};

    ////////////////////estos métodos son necesarios para que jtable funcione/////////////////////
    @Override
    public String getColumnName(int col) {
        return columnes[col].toString();
    }

    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return dades.size();
    }

    //Devuelve el numero de columnes
    @Override
    public int getColumnCount() {
        return columnes.length;
    }

    //Devuelve el valor del objeto en la fila y columna
    @Override
    public Object getValueAt(int row, int col) {

        String dev = null;
        Event fila;

        fila = (Event) SimpleTableModelEV.dades.get(row);
        switch (col) {
            case 0:
                dev = Integer.toString(fila.getIdevent());
                break;
            case 1:
                dev = Data.datatoString(fila.getDataidevent());
                break;
            case 2:
                dev = fila.getTipusevent();
                break;
            case 3:
                dev = Data.datatoString(fila.getDataevent());
                break;
        }

        return dev;
    }

    //Determina si una fila y columna ha de ser editable
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    //Actualiza un objeto de una fila y columna
    @Override
    public void setValueAt(Object value, int row, int col) {
        Event fila = (Event) dades.get(row);
        switch (col) {
            case 0:
                fila.setIdevent(Integer.parseInt(value.toString()));
                break;
            case 1:
                fila.setDataidevent(new Data(value.toString(), Data.getFormatdata()));
                break;
            case 2:
                fila.setTipusevent(value.toString());
                break;
            case 3:
                fila.setDataevent(new Data(value.toString(), Data.getFormatdata()));
                break;
        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Event e) {
        dades.add(e);
        fireTableDataChanged();
    }

    public void removeRow(int fila) {
        dades.remove(fila);
        fireTableDataChanged();
    }

    public void cargar() {
        dades.clear();
        dadesauxiliar.clear();
        SingletonEvent.evAL.clear();
        Connection conn = Connexio.connectar();
        if ("admin".equals(SingletonUsuari.us2.getTipus())) {
            GEDAOBd.omplirArray2(conn);
        } else {
            GEDAOBd.omplirArray(conn);
        }
        Connexio.desconnectar(conn);
        try {
            for (Event evAl : SingletonEvent.evAL) {
                addRow(evAl);
                dadesauxiliar.add(evAl);
            }
        } catch (Exception e) {
        }

        try {
            Thread.sleep(1); //1 milliseconds
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void filtrar() {
        dades.clear();

        int cont = 0;
        String tipusevent = FrmPagerEvent.txtFiltre.getText();
        for (int i = 0; i < dadesauxiliar.size(); i++) {
            if (dadesauxiliar.get(i).getTipusevent().contains(tipusevent)) {
                addRow(dadesauxiliar.get(i));
                cont++;
            }
        }
        FrmPagerEvent.lblContador.setText("" + cont);
        Pagina.initLinkBox();
    }

    /*
     public Event buscar(String e) {
     dades.clear();
     cargar();

     String res;
     for (int i = 0; i < dades.size(); i++) {
     res = dades.get(i).toString();
     if (res.contains(e)) {
     return dades.get(i);
     }
     }
     return null;
     }

     public int buscaUsuario(Event e) {
     dades.clear();
     cargar();

     for (int i = 0; i < dades.size(); i++) {
     if (dades.get(i).equals(e)) {
     return i;
     }
     }
     return -1;
     }
     */
}
