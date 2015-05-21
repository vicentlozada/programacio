package moduls.gestioEmpleats.classes;

import classes.Data;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Empleat")
public abstract class Empleat implements Comparable<Empleat>, Serializable {

    @XStreamAlias("nom")
    private String nom;
    @XStreamAlias("dni")
    private String dni;
    @XStreamAlias("datanaixement")
    private Data datanaixement;
    @XStreamAlias("edat")
    private int edat;
    @XStreamAlias("soubase")
    private float soubase;
    @XStreamAlias("sou")
    private float sou;
    @XStreamAlias("login")
    private String login;
    @XStreamAlias("password")
    private String password;
    @XStreamAlias("email")
    private String email;
    @XStreamAlias("tipus")
    private String tipus;    
    @XStreamAlias("estat")
    private byte estat;
    @XStreamAlias("avatar")
    private String avatar;

    public Empleat() {
    }

    public Empleat(String nom, String dni, Data datanaixement, int edat, float soubase, float sou,
                String login, String password, String email, String tipus, byte estat, String avatar) {
        this.nom = nom;
        this.dni = dni;
        this.datanaixement = datanaixement;
        this.edat = calcularEdat(datanaixement);
        this.soubase = soubase;
        this.sou = sou;
        this.login = login;
        this.password = password;
        this.email = email;
        this.tipus = tipus;
        this.estat = estat;        
        this.avatar = avatar;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Empleat(String dni) {
        this.dni = dni;
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

    public int getEdat() {
        return edat;
    }

    public static int calcularEdat(Data datanaixement) {
        return Data.diferanys(datanaixement, Data.datactual());
    }

    public void setEdat(Data datanaixement) {
        this.edat = Data.diferanys(datanaixement, Data.datactual());
    }

    public float getSoubase() {
        return soubase;
    }

    public void setSoubase(float soubase) {
        this.soubase = soubase;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public float getSou() {
        return sou;
    }

    public void setSou(float sou) {
        this.sou = sou;
    }

    @Override
    public int compareTo(Empleat emp) {// para ordenar los empleados
        if (this.getDni().compareTo(emp.getDni()) > 0) {
            return 1;
        }
        if (this.getDni().compareTo(emp.getDni()) < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object c) {
        return getDni().equals(((Empleat) c).getDni());
    }

    @Override
    public String toString() {
        return "Empleat{" + "nom=" + nom + ", dni=" + dni + ", datanaixement=" + datanaixement + ", edat=" + edat + ", soubase=" + soubase + ", sou=" + sou + ", login=" + login + ", password=" + password + ", email=" + email + ", estat=" + estat + ", avatar=" + avatar + '}';
    }


}
