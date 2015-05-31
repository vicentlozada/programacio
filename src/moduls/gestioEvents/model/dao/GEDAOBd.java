/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioEvents.model.dao;

import classes.Connexio;
import classes.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import moduls.gestioEvents.model.classes.Event;
import moduls.gestioEvents.model.classes.SingletonEvent;

/**
 *
 * @author Vicent
 */
public class GEDAOBd {

    public static boolean darrerEventDAO(Connection conn) {

        int idevent = 0;

        String query = ("SELECT * FROM event WHERE idevent=(SELECT MAX(idevent) FROM event)");
        try {
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idevent = rs.getInt("idevent") + 1;
                } else {
                    idevent = 1;
                }
                SingletonEvent.ev = new Event(idevent);
                rs.close();
                stmt.close();
                return true;
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
    
    public static int afegirEventDAO(Connection conn) {
        int resultat = 0;
        String query = ("INSERT INTO catering.event VALUES(?,?,?,?,?,?)");
        try {
            try (PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query)) {
                stmt.setInt(1, SingletonEvent.ev.getIdevent());
                stmt.setString(2, SingletonEvent.ev.getLogin());
                stmt.setString(3, SingletonEvent.ev.getTipusevent());
                stmt.setString(4, Data.datatoString2(SingletonEvent.ev.getDataidevent(), 0));             
                stmt.setString(5, Data.datatoString2(SingletonEvent.ev.getDataevent(), 0));
                stmt.setString(6, SingletonEvent.ev.getObservacionsevent());                   
                resultat = stmt.executeUpdate();
                if (resultat == 1) {
                    System.out.println("Dades Afegides Correctament !!!");
                } else {
                    System.out.println("Les Dades no s'han afegit");
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Afegir Dades:" + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println("Afegir Dades:" + ex.getMessage());
        } finally {
            Connexio.desconnectar(conn);
        }
        return resultat;
    }    
}
