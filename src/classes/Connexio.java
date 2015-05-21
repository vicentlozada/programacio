/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.Menus;

/**
 *
 * @author Vicent
 */
public class Connexio {

    static String driver = "com.mysql.jdbc.Driver";
    static String db = "catering";
    static String url = "jdbc:mysql://localhost:3306/";
    static String user = "catering";
    static String pass = "catering";

    public static Connection connectar() {
        Connection conn=null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url+db, user, pass);
        } catch (ClassNotFoundException cnfex) {
            Menus.warning("Ha estat impossible establir la connexió!","Atenció");
            System.out.println("Connectar:" + cnfex.getMessage());
        } catch (SQLException sqlex) {
            Menus.warning("Ha estat impossible establir la connexió!","Atenció");
            System.out.println("Connectar:" + sqlex.getMessage());
        } catch (Exception ex) {
            Menus.warning("Ha estat impossible establir la connexió!","Atenció");
            System.out.println("Connectar:" + ex.getMessage());
        }
        return conn;
    }

    public static void desconnectar(Connection conn) {
        try {
            conn.close();
        } catch (SQLException sqlex) {
            Menus.information("Ha estat impossible tancar la connexió!", "Atenció");
            System.out.println("Desconnectar:" + sqlex.getMessage());
        } catch (Exception ex) {
            Menus.information("Ha estat impossible tancar la connexió!", "Atenció");
            System.out.println("Desconnectar:" + ex.getMessage());
        }
    }

}
