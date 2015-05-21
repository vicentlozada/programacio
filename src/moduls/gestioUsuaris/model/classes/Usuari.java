/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioUsuaris.model.classes;

import classes.Data;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

@XStreamAlias("Usuari")
public  class Usuari implements Comparable<Usuari>, Serializable {
    @XStreamAlias("nom")
    private String nom;
    @XStreamAlias("dni")
    private String dni;
    @XStreamAlias("datanaixement")
    private Data datanaixement;
    @XStreamAlias("edat")
    private int edat;
    @XStreamAlias("login")
    private String login;
    private String password;
    @XStreamAlias("datalta")
    private Data datalta;    
    @XStreamAlias("email")
    private String email;
    @XStreamAlias("tipus")
    private String tipus;    
    @XStreamAlias("estat")
    private byte estat;
    @XStreamAlias("avatar")
    private String avatar;

    public Usuari(String nom, String dni, Data datanaixement, int edat, String login, String password, Data datalta, String email, String tipus, byte estat, String avatar) {
        this.nom = nom;
        this.dni = dni;
        this.datanaixement = datanaixement;
        this.edat = calcularEdat(datanaixement);
        this.login = login;
        this.password = password;
        this.datalta = datalta;
        this.email = email;
        this.tipus = tipus;
        this.estat = estat;
        this.avatar = avatar;
    }

    public Usuari(String dni, String login, String email, String tipus, String avatar) {
        this.dni = dni;
        this.login = login;
        this.email = email;
        this.tipus = tipus;
        this.avatar = avatar;
    }

    public Usuari(String login, String tipus, byte estat, String avatar) {
        this.login = login;
        this.tipus = tipus;
        this.estat = estat;
        this.avatar = avatar;
    }

    public Usuari(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Data getDatanaixement() {
        return datanaixement;
    }

    public void setDatanaixement(Data datanaixement) {
        this.datanaixement = datanaixement;
    }

    public void setEdat(Data datanaixement) {
        this.edat = Data.diferanys(datanaixement, Data.datactual());
    }
    public static int calcularEdat(Data datanaixement) {
        return Data.diferanys(datanaixement, Data.datactual());
    }
    public void setEdat(int edat) {
        this.edat = edat;
    }

    public int getEdat() {
        return edat;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Data getDatalta() {
        return datalta;
    }

    public void setDatalta(Data datalta) {
        this.datalta = datalta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public byte getEstat() {
        return estat;
    }

    public void setEstat(byte estat) {
        this.estat = estat;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public int compareTo(Usuari us) {// para ordenar
        if (this.getLogin().compareTo(us.getLogin()) > 0) {
            return 1;
        }
        if (this.getLogin().compareTo(us.getLogin()) < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object c) {
        return getLogin().equals(((Usuari) c).getLogin());
    }
    
    @Override
    public String toString() {
        return "Usuari{" + "nom=" + nom + ", dni=" + dni + ", datanaixement=" + datanaixement + ", edat=" + edat + ", login=" + login + ", password=" + password + ", datalta=" + datalta + ", email=" + email + ", tipus=" + tipus + ", estat=" + estat + ", avatar=" + avatar + '}';
    }


}
