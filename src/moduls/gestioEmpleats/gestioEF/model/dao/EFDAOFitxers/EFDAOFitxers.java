/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioEmpleats.gestioEF.model.dao.EFDAOFitxers;

import java.awt.HeadlessException;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import llibreries.Json;
import llibreries.Txt;
import llibreries.Xml;
import main.Core;
import utils.Menus;

/**
 *
 * @author Vicent
 */
public class EFDAOFitxers {

    /**
     * obrir arxius a petició de l'usuari
     */
    public static void obrirArxiuEFDAO() {
        String opc = Core.conf.getArxiu();
        switch (opc) {
            case "JSON":
                Json.obrirJsonEF();
                break;
            case "XML":
                Xml.obrirXmlEF();
                break;
            case "TXT":
                Txt.obrirTxtEF();
                break;
        }

    }

    /**
     * guardar arxius a petició de l'usuari
     */
    public static void guardarArxiuEFDAO() {
        String opc = Core.conf.getArxiu();
        switch (opc) {
            case "JSON":
                Json.guardarJsonEF();
                break;
            case "TXT":
                Txt.guardarTxtEF();
                break;
            case "XML":
                Xml.guardarXmlEF();
                break;
        }
    }

    /**
     * guardar arxiu format TXT a petició de l'usuari
     */
    public static void guardarArxiuTXTEFDAO() {
        Txt.guardarTxtEF();
    }

    /**
     * guardar arxiu format XML a petició de l'usuari
     */
    public static void guardarArxiuXMLEFDAO() {
        Xml.guardarXmlEF();
    }

    /**
     * guardar arxiu format JSON a petició de l'usuari
     */
    public static void guardarArxiuJSONEFDAO() {
        Json.guardarJsonEF();
    }

    public static String obrirAvatarDAO() {
        String PATH = null;

        try {

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PNG (*.png)", "png"));

            int seleccion = fileChooser.showOpenDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                Menus.information("Imatge oberta amb èxit!", "Imatge");
            }
        } catch (HeadlessException e) {
            Menus.warning("Error en obrir la imatge!", "Atenció");
        }

        return PATH;

    }

}
