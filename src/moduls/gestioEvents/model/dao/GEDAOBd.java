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
import moduls.gestioUsuaris.model.classes.SingletonUsuari;

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

    public static void omplirArray(Connection conn) {
        String tipusevent, observacionsevent;
        Data dataidevent, dataevent;
        int idevent;
        String login = SingletonUsuari.us2.getLogin();
        String query = ("SELECT * FROM event WHERE login=?");
        try {
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
            stmt.setString(1, login);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    idevent = rs.getInt("idevent");
                    login = rs.getString("login");
                    tipusevent = rs.getString("tipusevent");
                    dataidevent = new Data(rs.getString("dataidevent"), 0);
                    dataevent = new Data(rs.getString("dataevent"), 0);
                    observacionsevent = rs.getString("observacionsevent");
                    Event e = new Event(idevent, login, tipusevent, dataidevent, dataevent,
                            observacionsevent);
                    SingletonEvent.evAL.add(e);
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException sqlex) {
            System.out.println("Error SQL: " + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error no SQL: " + ex.getMessage());
        } finally {
            Connexio.desconnectar(conn);
        }
    }

        public static void omplirArray2(Connection conn) {
        String tipusevent, observacionsevent, login;
        Data dataidevent, dataevent;
        int idevent;
        String query = ("SELECT * FROM event");
        try {
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    idevent = rs.getInt("idevent");
                    login = rs.getString("login");
                    tipusevent = rs.getString("tipusevent");
                    dataidevent = new Data(rs.getString("dataidevent"), 0);
                    dataevent = new Data(rs.getString("dataevent"), 0);
                    observacionsevent = rs.getString("observacionsevent");
                    Event e = new Event(idevent, login, tipusevent, dataidevent, dataevent,
                            observacionsevent);
                    SingletonEvent.evAL.add(e);
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException sqlex) {
            System.out.println("Error SQL: " + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error no SQL: " + ex.getMessage());
        } finally {
            Connexio.desconnectar(conn);
        }
    }
    
    public static int eliminarEventDAOBd(int idevent, Connection conn) {
        int reseliminar = 0;
        String query = "DELETE FROM event WHERE idevent=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idevent);
            reseliminar = stmt.executeUpdate();
            if (reseliminar == 1) {
                System.out.println("Event eliminat correctament !!!");
            } else {
                System.out.println("No s'ha eliminat l'Event");
            }
            stmt.close();
        } catch (SQLException sqlex) {
            System.out.println("Error SQL eliminar Event:" + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error no SQL eliminar Event:" + ex.getMessage());
        } finally {
            Connexio.desconnectar(conn);
        }
        return reseliminar;
    }

    public static int updateEventDAOBd(Connection conn) {
        int resultat = 0;
        int idevent = SingletonEvent.ev.getIdevent();
        String login = SingletonEvent.ev.getLogin();
        String tipusevent = SingletonEvent.ev.getTipusevent();
        String dataidevent = Data.datatoString2(SingletonEvent.ev.getDataidevent(), 0);
        String dataevent = Data.datatoString2(SingletonEvent.ev.getDataevent(), 0);
        String observacionsevent = SingletonEvent.ev.getObservacionsevent();
        String query = ("UPDATE event SET login=?, tipusevent=?, dataidevent=?, "
                + "dataevent=?, observacionsevent=? WHERE idevent=?");
        try {
            try (PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query)) {
                stmt.setString(1, login);
                stmt.setString(2, tipusevent);
                stmt.setString(3, dataidevent);
                stmt.setString(4, dataevent);
                stmt.setString(5, observacionsevent);
                stmt.setInt(6, idevent);
                resultat = stmt.executeUpdate();
                if (resultat == 1) {
                    System.out.println("Event modificat correctament !!!");
                } else {
                    System.out.println("Event no s'ha modificat");
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Error SQL modificar Event:" + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error no SQL modificar Event:" + ex.getMessage());
        } finally {
            Connexio.desconnectar(conn);
        }
        return resultat;
    }
}
