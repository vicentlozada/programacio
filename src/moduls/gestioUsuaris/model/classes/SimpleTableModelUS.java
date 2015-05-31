/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioUsuaris.model.classes;

import classes.Connexio;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import moduls.gestioUsuaris.model.dao.GUDAOBd;
import moduls.gestioUsuaris.pager.Pagina;
import moduls.gestioUsuaris.vista.FrmPagerUsuari;

public class SimpleTableModelUS extends AbstractTableModel {

    public static ArrayList<Usuari> dades = new ArrayList<>();
    public static ArrayList<Usuari> dadesauxiliar = new ArrayList<>();
    String[] columnes = {"Login", "Nom", "Email", "Tipus", "Edat"};

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
        Usuari fila;

        fila = (Usuari) SimpleTableModelUS.dades.get(row);
        switch (col) {
            case 0:
                dev = fila.getLogin();
                break;
            case 1:
                dev = fila.getNom();
                break;
            case 2:
                dev = fila.getEmail();
                break;
            case 3:
                dev = fila.getTipus();
                break;
            case 4:
                dev = Integer.toString(fila.getEdat());
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
        Usuari fila = (Usuari) dades.get(row);
        switch (col) {
            case 0:
                fila.setLogin(value.toString());
                break;            
            case 1:
                fila.setNom(value.toString());
                break;
            case 2:
                fila.setEmail(value.toString());
                break;
            case 3:
                fila.setTipus(value.toString());
                break;
            case 4:
                fila.setEdat(Integer.parseInt(value.toString()));
                break;
        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Usuari u) {
        dades.add(u);
        fireTableDataChanged();
    }

    public void removeRow(int fila) {
        dades.remove(fila);
        fireTableDataChanged();
    }

    public void cargar() {
        dades.clear();
        dadesauxiliar.clear();
        SingletonUsuari.usAl.clear();
        Connection conn = Connexio.connectar();

        GUDAOBd.omplirArray(conn);

        Connexio.desconnectar(conn);
        try {
            for (Usuari usAl : SingletonUsuari.usAl) {
                addRow(usAl);
                dadesauxiliar.add(usAl);
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
        String nom = FrmPagerUsuari.txtFiltre.getText();
        for (int i = 0; i < dadesauxiliar.size(); i++) {
            if (dadesauxiliar.get(i).getNom().contains(nom)) {
                addRow(dadesauxiliar.get(i));
                cont++;
            }
        }
        FrmPagerUsuari.lblContador.setText("" + cont);
        Pagina.initLinkBox();
    }

    public Usuari buscar(String u) {
        dades.clear();
        cargar();

        String res;
        for (int i = 0; i < dades.size(); i++) {
            res = dades.get(i).toString();
            if (res.contains(u)) {
                return dades.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(Usuari u) {
        dades.clear();
        cargar();

        for (int i = 0; i < dades.size(); i++) {
            if (dades.get(i).equals(u)) {
                return i;
            }
        }
        return -1;
    }

}
