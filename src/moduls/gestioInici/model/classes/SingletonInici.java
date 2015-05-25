/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioInici.model.classes;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Virtual
 */
public class SingletonInici {

    public static String default_avatar = "src/images/avatar.png";
    public static String logo = "src/images/logo_catering.png";
    public static String igatge_mail = "src/images/catering.jpg";
    public static String default_tipus = "user";
    public static String default_login = "login";
    
    public static String user_mail = "1erdaw2015@gmail.com";
    public static String pass_mail = "villadaw";

    /**
     *
     */
    public static String assumpte = "Nova contrassenya";
    public static byte _estat_;
    public static String missatge = null;

    public static ImageIcon cancel = new ImageIcon("src/images/cancel.png");
    public static ImageIcon ok = new ImageIcon("src/images/ok.png");
    public static ImageIcon buit = new ImageIcon("src/images/buit.png");
    public static ImageIcon afegir1 = new ImageIcon("src/images/edit_add.png");
    public static ImageIcon afegir2 = new ImageIcon("src/images/edit_add_bn.png");
    public static ImageIcon editar1 = new ImageIcon("src/images/color_line.png");
    public static ImageIcon editar2 = new ImageIcon("src/images/color_line_bn.png");
    public static ImageIcon eliminar1 = new ImageIcon("src/images/edit_remove.png");
    public static ImageIcon eliminar2 = new ImageIcon("src/images/edit_remove_bn.png");
    public static Image imageicono = Toolkit.getDefaultToolkit().getImage("src/images/logo_catering.png");
    public static Color verd = new Color(3, 133, 3);

    //public static ArrayList<Usuari> usAl;
    //public static Usuari us = new Usuari("","login", "email@email.com","user", "src/images/avatar.png");
}
