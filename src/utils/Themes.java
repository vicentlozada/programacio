package utils;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Themes {

    /**
     *
     * @param op
     */
    public static void temaElegit(int op) {
        try {
            switch (op) {
                case 2:// Metal
                    try {
                        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    } catch (Exception e) {
                    }
                    break;
                case 0:// GTK - WINDOWS
                    try {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    } catch (Exception e) {
                    }

                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;

                case 3:// CDE/Motif
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;

                case 1:// Nimbus
                    try {
                        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    } catch (Exception e) {
                    }

                    //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;

                case 4: //Obtener lista look&feel disponibles en el SO
                    //http://www.codigofantasma.com/blog/java-look-feel-parte-1/
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No s'ha pogut carregar l'apari�ncia desitjada",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
