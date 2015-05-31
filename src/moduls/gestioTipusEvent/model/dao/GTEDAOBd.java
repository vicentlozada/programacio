/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioTipusEvent.model.dao;

import classes.Connexio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import moduls.gestioTipusEvent.model.classes.SingletonTipusEvent;
import static moduls.gestioTipusEvent.model.classes.SingletonTipusEvent.tevnt;
import moduls.gestioTipusEvent.model.classes.TipusEvent;

/**
 *
 * @author Vicent
 */
public class GTEDAOBd {

    public static boolean cercarTipusEventDAO(Connection conn) {
        String tipusevent;

        String query = ("SELECT * FROM tipusevent ORDER BY tipusevent");
        try {
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    tipusevent = rs.getString("tipusevent");                                        
                    tevnt = new TipusEvent(tipusevent);
                    SingletonTipusEvent.tevntAl.add(tevnt);
                }
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

}
