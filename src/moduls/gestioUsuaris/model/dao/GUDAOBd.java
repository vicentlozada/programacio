/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioUsuaris.model.dao;

import classes.Connexio;
import classes.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import llibreries.Encriptar;
import moduls.gestioUsuaris.model.classes.SingletonUsuaris;
import moduls.gestioUsuaris.model.classes.Usuari;

/**
 *
 * @author Vicent
 */
public class GUDAOBd {

    public static int activaUsuariDAO(byte estat, Connection conn) {

        int resultat = 0;
        String login = SingletonUsuaris.us2.getLogin();

        String query = ("UPDATE catering.usuari SET estat=? "
                + " WHERE login=?");

        try {
            try (PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query)) {
                stmt.setByte(1, estat);
                stmt.setString(2, login);
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

    public static boolean cercarDniDAO(String dni, Connection conn) {
        String query = ("SELECT * FROM usuari WHERE dni=?");
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
                    SingletonUsuaris.us = new Usuari(nom, dni, datan, edat, login,
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

    public static boolean cercarEmailDAO(String email, Connection conn) {
        String query = ("SELECT * FROM usuari WHERE email=?");
        try {
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
            stmt.setString(1, email);
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

    public static boolean validarUsuariPasswordDAO(String usuari, String pass, Connection conn) {
        String login, nom, avatar, tipus, email, password, dni;
        int edat;
        Data datanaixement, datalta;
        byte estat;

        String query = ("SELECT * FROM usuari WHERE login=?");
        try {
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
            stmt.setString(1, usuari);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    if (Encriptar.validarTokenMD5(pass, rs.getString("password"))) {

                        login = rs.getString("login");
                        tipus = rs.getString("tipus");
                        estat = rs.getByte("estat");
                        avatar = rs.getString("avatar");

                        SingletonUsuaris.us2 = new Usuari(login, tipus, estat, avatar);

                        rs.close();
                        stmt.close();
                        return true;
                    }
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

    public static int insertUsuariDAOBd(Connection conn) {
        int resultat = 0;
        String query = ("INSERT INTO catering.usuari"
                + "(nom, dni, datanaixement, edat, "
                + "login,password, datalta, email, "
                + "tipus, estat, avatar) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
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

    public static int updateUsuariDAOBd(Connection conn) {
        int resultat = 0;
        String login = SingletonUsuaris.us.getLogin();
        String password = SingletonUsuaris.us.getPassword();
        String dni = SingletonUsuaris.us.getDni();
        String nom = SingletonUsuaris.us.getNom();
        String datanaixement = Data.datatoString2(SingletonUsuaris.us.getDatanaixement(), 0);
        int edat = SingletonUsuaris.us.getEdat();
        String email = SingletonUsuaris.us.getEmail();
        String tipus = SingletonUsuaris.us.getTipus();
        byte estat = SingletonUsuaris.us.getEstat();
        String avatar = SingletonUsuaris.us.getAvatar();

        String query = ("UPDATE catering.usuari SET password=?, dni=?, nom=?, email=?, "
                + "datanaixement=?, edat=?, estat=?, tipus=?, avatar=?"
                + " WHERE login=?");

        try {
            try (PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query)) {
                stmt.setString(1, password);
                stmt.setString(2, dni);
                stmt.setString(3, nom);
                stmt.setString(4, email);
                stmt.setString(5, datanaixement);
                stmt.setInt(6, edat);
                stmt.setByte(7, estat);
                stmt.setString(8, tipus);
                stmt.setString(9, avatar);
                stmt.setString(10, login);
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

    public static int modificarPassDAO(String password, Connection conn) {
        int resultat = 0;

        String login = SingletonUsuaris.us.getLogin();

        String query = ("UPDATE catering.usuari SET password=? "
                + " WHERE login=?");
        try {
            try (PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query)) {
                stmt.setString(1, password);
                stmt.setString(2, login);
                resultat = stmt.executeUpdate();
                if (resultat == 1) {
                    System.out.println("Dades Modificades Correctament !!!");
                } else {
                    System.out.println("Les Dades no s'han modificat");
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Modificar Dadessdfzsdfasd:" + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println("Modificar Dadessdfasd:" + ex.getMessage());
        } finally {
            Connexio.desconnectar(conn);
        }
        return resultat;
    }

    public static boolean validarUsuariEmailDAO(String email, Connection conn) {
        String login, nom, avatar, tipus, password, dni;
        int edat;
        Data datanaixement, datalta;
        byte estat;

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

    public static boolean cercarEmailDAO_(String email, Connection conn) {
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

    public static void omplirArray(Connection conn) {
        String query = ("SELECT * FROM usuari ORDER BY login");
        String nom, dni, login, password, email, tipus, avatar;
        byte estat;
        Data datan, datac;
        int edat;
        try {
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
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
                    Usuari u = new Usuari(nom, dni, datan, edat, login,
                            password, datac, email, tipus, estat, avatar);
                    SingletonUsuaris.usAl.add(u);
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

    public static int eliminarUsuariDAOBd(String login, Connection conn) {
        int reseliminar = 0;
        String query = "DELETE FROM usuari WHERE login=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, login);
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
}
