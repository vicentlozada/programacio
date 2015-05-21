package llibreries;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import java.awt.HeadlessException;

import javax.swing.filechooser.FileNameExtensionFilter;
import utils.Menus;
import moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF;
import moduls.gestioEmpleats.gestioEF.model.classes.EmpleatFix;

public class Txt {

    public static void generatxtOcultEF() {
        String PATH = null;
        try {
            File f;
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/catering/moduls/gestioE/gestioEF/model/arxius/ef.txt";

            f = new File(PATH);

            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream o = new ObjectOutputStream(fo);
            o.writeObject(SingletonEF.efix);
            o.close();

        } catch (Exception e) {
        }
    }

    public static void obrirTxtEF() {
        String PATH;

        try {
            File f;

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Texto (*.txt)", "txt"));

            int seleccion = fileChooser.showOpenDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                f = new File(PATH);

                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);

                SingletonEF.efix = (ArrayList<EmpleatFix>) ois.readObject();
                ois.close();

                Menus.information("Arxiu TXT obert amb �xit!", "Arxiu TXT");
            }
        } catch (HeadlessException | IOException | ClassNotFoundException e) {
            Menus.warning("Error en llegir el TXT", "Error");
        }

    }

    public static void obrirTxtOcultEF() {
        String PATH = null;
        try {
            File f;
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/moduls/gestioE/gestioEF/model/arxius/ef.txt";

            f = new File(PATH);

            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream oi = new ObjectInputStream(fi);
            SingletonEF.efix = (ArrayList<EmpleatFix>) oi.readObject();
            oi.close();

        } catch (Exception e) {

        }
    }

    public static void guardarTxtEF() {
        String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Texto (*.txt)", "txt"));
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                if (!PATH.endsWith(".txt")) {
                    PATH = PATH + ".txt";
                }
                f = new File(PATH);
                FileOutputStream fo = new FileOutputStream(f);
                ObjectOutputStream o = new ObjectOutputStream(fo);
                o.writeObject(SingletonEF.efix);
                o.close();
                Menus.information("Arxiu TXT guardat amb Èxit!", "Arxiu TXT");
            }
        } catch (Exception e) {
            Menus.warning("Error en llegir el TXT", "Error");
        }
    }

}
