package moduls.gestioEmpleats.gestioEH.model.classes;

import classes.Data;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import moduls.gestioEmpleats.classes.Empleat;
import main.Core;
import utils.Format;

@XStreamAlias("EmpleatHores")
public class EmpleatHores extends Empleat implements Serializable {

    @XStreamAlias("preuhora")
    private float preuhora;
    @XStreamAlias("hores")
    private float hores;

    public EmpleatHores(String nom, String dni, Data datanaixement, int edat, float soubase, float sou,
            String login, String password, String email, String tipus, byte estat, String avatar,
            float preuhora, float hores) {
        super(nom, dni, datanaixement, edat, soubase, sou, login, password, email, tipus, estat, avatar);
        this.preuhora = preuhora;
        this.hores = hores;
        super.setSou(calcularsou(hores, preuhora));
    }

    public EmpleatHores(String dni) {
        super(dni);
        super.setDni(dni);
    }

    public float getPreuhora() {
        return preuhora;
    }

    public void setPreuhora(float preuhora) {
        this.preuhora = preuhora;
    }

    public float getHores() {
        return hores;
    }

    public void setHores(float hores) {
        this.hores = hores;
    }

    public float calcularsou(float hora, float preu) {
        return (hora * preu);
    }

    public String toString() {
        StringBuffer targeta = new StringBuffer();
        targeta.append("Nom: " + super.getNom() + " || ");
        targeta.append("DNI: " + super.getDni() + " || ");
        targeta.append("Data naixement: " + super.getDatanaixement() + " || ");
        targeta.append("Edat: " + super.getEdat() + " anys" + " || ");
        targeta.append("Hores: " + Format.formatnombre(hores, Core.conf) + " || ");
        targeta.append("Preu hora: " + Format.formatConfig(preuhora * (Core.conf.getFactorconv()), Core.conf)
                + " || ");
        targeta.append("Salari: " + Format.formatConfig(super.getSou() * (Core.conf.getFactorconv()), Core.conf));
        return targeta.toString();
    }

}
