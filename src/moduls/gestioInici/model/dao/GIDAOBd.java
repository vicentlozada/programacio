/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioInici.model.dao;

import classes.Connexio;
import classes.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import moduls.gestioUsuaris.model.classes.SingletonUsuaris;
import moduls.gestioUsuaris.model.classes.Usuari;

/**
 *
 * @author Vicent
 */
public class GIDAOBd {
/*
    public static boolean cercarUsuariDAO(String usuari, Connection conn) {
        String nom, dni, login, password, email, tipus, avatar;
        byte estat;
        Data datan, datac;
        int edat;
        String query = ("SELECT * FROM usuari WHERE login=?");
        try {
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
            stmt.setString(1, usuari);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nom = rs.getString("nom");
                    dni = rs.getString("dni");
                    datan = new Data(rs.getString("datanaixement"), 0);
                    edat = rs.getInt("edat");
                    login = rs.getString("login");
                    password = rs.getString("password");
                    datac = new Data(rs.getString("datalta"), 0);
                    email = rs.getString("email");
                    tipus = rs.getString("tipus");
                    estat = rs.getByte("estat");
                    avatar = rs.getString("avatar");
                    SingletonUsuaris.us2 = new Usuari(nom, dni, datan, edat, login,
                            password, datac, email, tipus, estat, avatar);
                    rs.close();
                    stmt.close();
                    return true;
                }
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            Connexio.desconnectar(conn);
        }
        return false;
    }
*/
    public static boolean cercarEmailDAO(String email, Connection conn) {
        String login, nom, avatar, tipus, password, dni;
        int edat;
        Data datanaixement, datalta;

        String query = ("SELECT * FROM usuari WHERE email=?");
        try {
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    login = rs.getString("login");
                    avatar = rs.getString("avatar");
                    tipus = rs.getString("tipus");
                    dni = rs.getString("dni");
                    email = rs.getString("email");
                    SingletonUsuaris.us = new Usuari(dni, login, email, tipus, avatar);

                    rs.close();
                    stmt.close();
                    return true;
                }
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            Connexio.desconnectar(conn);
        }
        return false;
    }
    /*
     public static int afegirUsuari(Connection conn) {
     int resultat = 0;
     String query = ("INSERT INTO catering.usuari VALUES(?,?,?,?,?,?,?,?,?,?,?)");
     try {
     try (PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query)) {
     stmt.setString(1, SingletonUsuaris.us.getNom());
     stmt.setString(2, SingletonUsuaris.us.getDni());
     stmt.setString(3, Data.datatoString2(SingletonUsuaris.us.getDatanaixement(), 0));
     stmt.setInt(4, SingletonUsuaris.us.getEdat());
     stmt.setString(5, SingletonUsuaris.us.getLogin());
     stmt.setString(6, SingletonUsuaris.us.getPassword());
     stmt.setString(7, Data.datatoString2(SingletonUsuaris.us.getDatalta(), 0));
     stmt.setString(8, SingletonUsuaris.us.getEmail());
     stmt.setString(9, SingletonUsuaris.us.getTipus());
     stmt.setByte(10, SingletonUsuaris.us.getEstat());
     stmt.setString(11, SingletonUsuaris.us.getAvatar());

     resultat = stmt.executeUpdate();
     if (resultat == 1) {
     System.out.println("Usuari afegit correctament !!!");
     } else {
     System.out.println("L'Usuari no s'ha afegit");
     }
     }
     } catch (SQLException sqlex) {
     System.out.println("Afegir Usuari:" + sqlex.getMessage());
     } catch (Exception ex) {
     System.out.println("Afegir Usuari:" + ex.getMessage());
     } finally {
     Connexio.desconnectar(conn);
     }
     return resultat;
     }
     */
}
