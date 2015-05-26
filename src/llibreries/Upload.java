/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llibreries;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import moduls.gestioInici.model.classes.SingletonInici;
import moduls.gestioUsuaris.model.classes.SingletonUsuaris;
import utils.Funcions;
import utils.Menus;

/**
 *
 * @author Vicent
 */
public class Upload {
    public static String PATH_auto="";
    public static void lista_blanca(JFileChooser buscador) {
        buscador.setAcceptAllFileFilterUsed(false);
        buscador.addChoosableFileFilter(new FileNameExtensionFilter("Images (*.jpg,"
                + " *.jpeg, *.gif, *.png)", "jpg", "jpeg", "gif", "png"));
    }

    public static String pintar_guardar_imag(JLabel etiqueta, int ancho, int alto, String ruta) {

        File imagen;
        BufferedImage image; // = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
        JFileChooser fileChooser = new JFileChooser();

        lista_blanca(fileChooser);
        fileChooser.setCurrentDirectory(null);
        fileChooser.setSelectedFile(null);
        
        int seleccion = fileChooser.showOpenDialog(null);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            imagen = fileChooser.getSelectedFile();

            ruta = imagen.getAbsolutePath();
            
            System.out.println(ruta);
            
            if (ruta.length() > 256) {
                Menus.warning("La ruta de la imatge ha de ser menor de 256 caràcters", "Atenció");
            } else {
                ImageIcon icon = new ImageIcon(ruta);
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                etiqueta.setIcon(newIcon); //pintamos la imagen en jlabel1

                try {
                    //guardamos la imagen                    
                    image = ImageIO.read(fileChooser.getSelectedFile().toURL());
                    String extension = fileChooser.getSelectedFile().toURL().toString().substring(
                            fileChooser.getSelectedFile().toURL().toString().length() - 3);                    
                    String cad = Funcions.getCadenaAleatoria3(5);                  
                    PATH_auto = new java.io.File("") + "src/images/" + cad + "." + extension; 
                    ruta=PATH_auto;
                    File f = new File(PATH_auto);
                    ImageIO.write(image, extension, f);                    
                } catch (Exception ex) {
                    Menus.error("Error upload image", "Error");                    
                }                
            }
        } else { //avatar anterior
            //ruta = SingletonUsuaris.us.getAvatar();
            ImageIcon icon = new ImageIcon(ruta);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            etiqueta.setIcon(newIcon); //pintamos la imagen_default en jlabel1

            try {
                //guardamos la imagen
                PATH_auto = new java.io.File("") + ruta;
                File f = new File(PATH_auto);
                image = ImageIO.read(f);
                ImageIO.write(image, "png", f);
            } catch (Exception ex) {
                Menus.error("Error upload imagen: Avatar per defecte", "Error");
            }
            
        }

        return ruta;
    }
    
        public static void pintar_imatge(JLabel etiqueta, int ancho, int alto, String ruta){
            try {
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(ruta);
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);                
                etiqueta.setIcon(newIcon);
            } catch (Exception ex) {
               Menus.error("Error upload imagen: Avatar per defecte", "Error");
            }
    }
    
    
       public static String getExtensionFile(String filename) {
            File f = new File(filename);
            if (f == null || f.isDirectory()){
                  return "nulo o directorio";
            }else if (f.isFile()){
                  int index = filename.lastIndexOf('.');
                  if (index == -1) {
                        return "";
                  } else {
                        return filename.substring(index + 1);
                  }
            }else{
                  return "que has enviado?";
            }
      }  

}
