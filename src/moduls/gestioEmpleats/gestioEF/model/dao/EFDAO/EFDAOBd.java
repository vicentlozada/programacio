package moduls.gestioEmpleats.gestioEF.model.dao.EFDAO;

import classes.Connexio;
import classes.Data;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.Core;
import moduls.gestioEmpleats.gestioEF.model.classes.EmpleatFix;
import moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF;

public class EFDAOBd {

    public static int eliminar(String dni, Connection conn) {
        int reseliminar = 0;
        String query = "DELETE FROM empleatfix WHERE dni=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, dni);
            reseliminar = stmt.executeUpdate();
            if (reseliminar == 1) {
                System.out.println("Dades eliminades correctament !!!");
            } else {
                System.out.println("No s'han eliminat les Dades");
            }
            stmt.close();
        } catch (SQLException sqlex) {
            System.out.println("Eliminar Dades:" + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println("Eliminar Dades:" + ex.getMessage());
        } finally {
            Connexio.desconnectar(conn);
        }
        return reseliminar;
    }

    public static void omplirArray(Connection conn) {
        String query = ("SELECT * FROM empleatfix ORDER BY nom");
        String nom, dni, login, password, email, tipus, avatar;
        byte estat;
        Data datan, datac;
        int edat, antiguitat;
        float soubase, sou, percent;
        try {
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    nom = rs.getString("nom");
                    dni = rs.getString("dni");
                    datan = new Data(rs.getString("datanaixement"), 0);
                    edat = rs.getInt("edat");
                    soubase = rs.getFloat("soubase");
                    sou = rs.getFloat("sou");
                    login = rs.getString("login");
                    password = rs.getString("password");
                    email = rs.getString("email");
                    tipus = rs.getString("tipus");
                    estat = rs.getByte("estat");
                    avatar = rs.getString("avatar");
                    datac = new Data(rs.getString("datacontratacio"), 0);
                    antiguitat = rs.getInt("antiguitat");
                    percent = rs.getFloat("percent");
                    EmpleatFix ef = new EmpleatFix(nom, dni, datan, edat, soubase, sou,
                            login, password, email, tipus, estat, avatar, datac,
                            antiguitat, percent);
                    SingletonEF.efix.add(ef);
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            Connexio.desconnectar(conn);
        }
    }

    public static int afegir(Connection conn) {
        int resultat = 0;
        String query = ("INSERT INTO catering.empleatfix VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        try {
            try (PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query)) {
                stmt.setString(1, SingletonEF.ef.getNom());
                stmt.setString(2, SingletonEF.ef.getDni());
                stmt.setString(3, Data.datatoString2(SingletonEF.ef.getDatanaixement(), 0));
                stmt.setInt(4, SingletonEF.ef.getEdat());
                stmt.setFloat(5, SingletonEF.ef.getSoubase() / Core.conf.getFactorconv());
                stmt.setFloat(6, SingletonEF.ef.getSou() / Core.conf.getFactorconv());
                stmt.setString(7, SingletonEF.ef.getLogin());
                stmt.setString(8, SingletonEF.ef.getPassword());
                stmt.setString(9, SingletonEF.ef.getEmail());
                stmt.setString(10, SingletonEF.ef.getTipus());
                stmt.setByte(11, SingletonEF.ef.getEstat());
                stmt.setString(12, SingletonEF.ef.getAvatar());
                stmt.setString(13, Data.datatoString2(SingletonEF.ef.getDatacontratacio(), 0));
                stmt.setInt(14, SingletonEF.ef.getAntiguitat());
                stmt.setFloat(15, SingletonEF.ef.getPercent());
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

    public static int modificar(Connection conn) {
        int resultat = 0;
        String nom = SingletonEF.ef.getNom();
        String email = SingletonEF.ef.getEmail();
        String avatar = SingletonEF.ef.getAvatar();
        String dni = SingletonEF.ef.getDni();
        String datanaixement = Data.datatoString2(SingletonEF.ef.getDatanaixement(), 0);
        String datacontratacio = Data.datatoString2(SingletonEF.ef.getDatacontratacio(), 0);
        int edat = SingletonEF.ef.getEdat();
        int antiguitat = SingletonEF.ef.getAntiguitat();
        float soubase = SingletonEF.ef.getSoubase() / Core.conf.getFactorconv();
        float sou = SingletonEF.ef.getSou() / Core.conf.getFactorconv();
        float percent = SingletonEF.ef.getPercent();

        String query = ("UPDATE empleatfix SET nom=?, email=?, avatar=?, datanaixement=?, edat=?, "
                + "soubase=?, sou=?, datacontratacio=?, antiguitat=?, percent=?"
                + " WHERE dni=?");

        try {
            try (PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query)) {
                stmt.setString(1, nom);
                stmt.setString(2, email);
                stmt.setString(3, avatar);
                stmt.setString(4, datanaixement);
                stmt.setInt(5, edat);
                stmt.setFloat(6, soubase);
                stmt.setFloat(7, sou);
                stmt.setString(8, datacontratacio);
                stmt.setInt(9, antiguitat);
                stmt.setFloat(10, percent);
                stmt.setString(11, dni);
                resultat = stmt.executeUpdate();
                if (resultat == 1) {
                    System.out.println("Dades Modificades Correctament !!!");
                } else {
                    System.out.println("Les Dades no s'han modificat");
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Modificar Dades:" + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println("Modificar Dades:" + ex.getMessage());
        } finally {
            Connexio.desconnectar(conn);
        }
        return resultat;
    }

    public static boolean cercar(String dni, Connection conn) {
        String query = ("SELECT * FROM empleatfix WHERE dni=?");
        try {
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
            stmt.setString(1, dni);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
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

    public static String empleatMesAnticDAO(Connection conn) {
        CallableStatement cstmt = null;
        String resultat = null;

        try {

            cstmt = (CallableStatement) conn.prepareCall("{call empleat_mes_antic(?, ?, ?)}");
            cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
            cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
            cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            cstmt.execute();
            resultat = cstmt.getString(1);
            resultat = resultat + " - " + cstmt.getString(2);
            resultat = resultat + " - " + cstmt.getString(3);
            
            System.out.println(resultat);

        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
                if (conn != null) {
                    Connexio.desconnectar(conn);
                }
            } catch (Exception fe) {
                System.out.println(fe.getMessage());
            }
        }
        return resultat;
    }

}
