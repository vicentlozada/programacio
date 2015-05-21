package moduls.gestioEmpleats.gestioET.model.classes;

import classes.Data;
import java.io.Serializable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import moduls.gestioEmpleats.classes.Empleat;
import main.Core;
import utils.Format;

@XStreamAlias("EmpleatTemporal")
public class EmpleatTemporal extends Empleat implements Serializable {

    @XStreamAlias("datalta")
    private Data datalta;
    @XStreamAlias("databaixa")
    private Data databaixa;
    @XStreamAlias("preudia")
    private float preudia;
    @XStreamAlias("dies")
    private int dies;

    public EmpleatTemporal(String nom, String dni, Data datanaixement, int edat, float soubase,
                float sou, String login, String password, String email, String tipus, byte estat,
                    String avatar,Data datalta, Data databaixa, float preudia, int dies) {
        super(nom, dni, datanaixement, edat, soubase, sou, login, password, email, tipus, estat, avatar);
        this.datalta = datalta;
        this.databaixa = databaixa;
        this.preudia = preudia;
        this.dies = dies;
    }

    public EmpleatTemporal(String dni) {
        super(dni);
        super.setDni(dni);
    }

    public Data getDatalta() {
        return datalta;
    }

    public void setDatalta(Data datalta) {
        this.datalta = datalta;
    }

    public Data getDatabaixa() {
        return databaixa;
    }

    public void setDatabaixa(Data databaixa) {
        this.databaixa = databaixa;
    }

    public float getPreudia() {
        return preudia;
    }

    public void setPreudia(float preudia) {
        this.preudia = preudia;
    }

    public int getDies() {
        return dies;
    }

    public void setDies(Data data1, Data data2) {
        this.dies = Data.diferdies(data1, data2);
    }

    public int calculardies(Data data1, Data data2) {
        return Data.diferdies(data1, data2);
    }

    public float calcularsou(float preu, long q) {
        return preu * q;
    }

    public String toString() {
        StringBuffer tarjeta = new StringBuffer();
        tarjeta.append("Nom: " + super.getNom() + " || ");
        tarjeta.append("DNI: " + super.getDni() + " || ");
        tarjeta.append("Data naixement: " + super.getDatanaixement() + " || ");
        tarjeta.append("Edat: " + super.getEdat() + " anys" + " || ");
        tarjeta.append("Data alta: " + datalta + " || ");
        tarjeta.append("Data baixa: " + databaixa + " || ");
        tarjeta.append("Dies treballats: " + getDies() + " dies" + " || ");
        tarjeta.append("Preu dia: " + Format.formatConfig(preudia * (Core.conf.getFactorconv()), Core.conf) + " || ");
        tarjeta.append("Salari: " + Format.formatConfig(super.getSou() * (Core.conf.getFactorconv()), Core.conf));
        return tarjeta.toString();
    }

}
