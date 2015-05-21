package moduls.gestioEmpleats.gestioEF.model.classes;

import classes.Data;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import moduls.gestioEmpleats.classes.Empleat;

@XStreamAlias("EmpleatFix")
public class EmpleatFix extends Empleat implements Serializable {

    @XStreamAlias("datacontratacio")
    private Data datacontratacio;
    @XStreamAlias("antiguitat")
    private int antiguitat;
    @XStreamAlias("percent")
    private float percent;

    public EmpleatFix() {
    }

    public EmpleatFix(String nom, String dni, Data datanaixement, int edat, float soubase, float sou,
                String login, String password, String email, String tipus, byte estat, String avatar,
                    Data datacontratacio, int antiguitat, float percent) {
        super(nom, dni, datanaixement, edat, soubase, sou, login, password, email, tipus, estat, avatar);
        this.datacontratacio = datacontratacio;
        this.antiguitat = calcularAntiguitat(getDatacontratacio());
        this.percent = calcularPercent(getAntiguitat());
        super.setSou(calcularsou(getPercent(), soubase));
    }

    public float getPercent() {
        return percent;
    }

    public static float calcularPercent(int anti) {
        float r = 0.0f;
        if (anti >= 15) {
            r = 9.0f;
        } else if (anti >= 10.0f) {
            r = 6;
        } else if (anti >= 5.0f) {
            r = 3.0f;
        } else {
            r = 0.0f;
        }
        return r;
    }

    public EmpleatFix(String dni) {
        super(dni);
        super.setDni(dni);
    }

    public EmpleatFix(String nom, String x) {
        super(nom);
        super.setNom(nom);
    }

    public Data getDatacontratacio() {
        return datacontratacio;
    }

    public void setDatacontratacio(Data datacontratacio) {
        this.datacontratacio = datacontratacio;
    }

    public int getAntiguitat() {
        return antiguitat;
    }

    public void setAntiguitat(Data datacontratacio) {
        this.antiguitat = Data.diferanys(datacontratacio, Data.datactual());
    }

    public void setAntiguitat(int antiguitat) {
        this.antiguitat = antiguitat;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public static int calcularAntiguitat(Data datacontratacio) {
        return Data.diferanys(datacontratacio, Data.datactual());
    }

    public float calcularsou(float r, float salaribase) {
        return salaribase * (1 + (r / 100));
    }

    /*
     public String toString() {
     StringBuffer targeta = new StringBuffer();
     targeta.append("Nom: " + super.getNom() + " || ");
     targeta.append("DNI: " + super.getDni() + " || ");
     targeta.append("Data naixement: " + super.getDatanaixement() + " || ");
     targeta.append("Edat " + super.getEdat() + " anys" + " || ");
     targeta.append("Data contrataci�: " + datacontratacio + " || ");
     targeta.append("Antiguitat: " + getAntiguitat() + " anys" + " || ");
     targeta.append("%Antiguitat: " + Format.formatConfig(percent, Core.conf) + " %" + " || ");
     targeta.append("Salari Base: "
     + Format.formatConfig(super.getSoubase() * (Core.conf.getFactorconv()), Core.conf) + " || ");
     targeta.append("Salari Net: " + Format.formatConfig(super.getSou() * (Core.conf.getFactorconv()), Core.conf) + " || ");
     targeta.append(Core.conf.getFactorconv());
     return targeta.toString();
     }
     */
    @Override
    public String toString() {
        return "EmpleatFix{" + "datacontratacio=" + datacontratacio + ", antiguitat=" + antiguitat + ", percent=" + percent + '}';
    }
}
