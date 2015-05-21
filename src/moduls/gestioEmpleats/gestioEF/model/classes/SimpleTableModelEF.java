package moduls.gestioEmpleats.gestioEF.model.classes;

import classes.Connexio;
import classes.Data;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import static moduls.gestioEmpleats.gestioEF.model.classes.SimpleTableModelEF.dades;
import moduls.gestioEmpleats.gestioEF.pager.Pagina;
import moduls.gestioEmpleats.gestioEF.vista.FrmInterfaceEF;
import main.Core;
import moduls.gestioEmpleats.gestioEF.model.dao.EFDAO.EFDAOBd;
import utils.Format;

public class SimpleTableModelEF extends AbstractTableModel {

    public static ArrayList<EmpleatFix> dades = new ArrayList<>();
    public static ArrayList<EmpleatFix> dadesauxiliar = new ArrayList<>();
    String[] columnes = {"DNI", "Nom", "Data Naixement", "Data Contratació", "Salari"};

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
        EmpleatFix fila;

        fila = (EmpleatFix) SimpleTableModelEF.dades.get(row);
        switch (col) {
            case 0:
                dev = fila.getDni();
                break;
            case 1:
                dev = fila.getNom();
                break;
            case 2:                
                dev = Data.datatoString(fila.getDatanaixement());
                break;
            case 3:
                dev = Data.datatoString(fila.getDatacontratacio());
                break;
            case 4:
                dev = Format.formatConfig(fila.getSou() * Core.conf.getFactorconv(), Core.conf);
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
        EmpleatFix fila = (EmpleatFix) dades.get(row);
        switch (col) {
            case 0:
                fila.setDni(value.toString());
                break;
            case 1:
                fila.setNom(value.toString());
                break;
            case 2:
                fila.setDatanaixement(new Data(value.toString(), Data.getFormatdata()));
                break;
            case 3:
                fila.setDatacontratacio(new Data(value.toString(), Data.getFormatdata()));
                break;
            case 4:
                fila.setSou(Float.parseFloat(value.toString()));
                break;
        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(EmpleatFix ef) {
        dades.add(ef);
        fireTableDataChanged();
    }

    public void removeRow(int fila) {
        dades.remove(fila);
        fireTableDataChanged();
    }

    public void cargar() {
        dades.clear();
        dadesauxiliar.clear();
        SingletonEF.efix.clear();
        Connection conn = Connexio.connectar();
        EFDAOBd.omplirArray(conn);
        Connexio.desconnectar(conn);
        try {
            for (EmpleatFix efix : SingletonEF.efix) {
                addRow(efix);
                dadesauxiliar.add(efix);                                
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
        String nom = FrmInterfaceEF.txtFiltre.getText();
        for (int i = 0; i < dadesauxiliar.size(); i++) {
            if (dadesauxiliar.get(i).getNom().contains(nom)) {
                addRow(dadesauxiliar.get(i));
                cont++;
            }
        }
        FrmInterfaceEF.lblContador.setText("" + cont);
        Pagina.initLinkBox();
    }

    public EmpleatFix buscar(String u) {
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

    public int buscaUsuario(EmpleatFix ef) {
        dades.clear();
        cargar();

        for (int i = 0; i < dades.size(); i++) {
            if (dades.get(i).equals(ef)) {
                return i;
            }
        }
        return -1;
    }

}
