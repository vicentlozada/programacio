package classes;

import java.sql.Connection;
import java.util.ArrayList;
import moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF;
import moduls.gestioEmpleats.gestioEH.model.classes.ArraylistEH;
import moduls.gestioEmpleats.gestioET.model.classes.ArraylistET;
import main.Core;
import moduls.gestioEvents.model.classes.SingletonEvent;
import moduls.gestioTipusEvent.model.classes.SingletonTipusEvent;
import moduls.gestioUsuaris.model.classes.SingletonUsuari;
import utils.Menus;
import utils.Themes;

public class Configuracio {

    private int numdecimal;
    private String moneda;
    private int formatdata;
    private String regio;
    private float factorconv;
    private int tema;
    private String arxiu;
    private String image;

    /**
     * configuració inicial
     */
    public Configuracio() {
        this.numdecimal = 2;
        this.moneda = "Euro";
        this.formatdata = 0;
        this.regio = "EU";
        this.factorconv = 1;
        this.tema = 0;
        this.arxiu = "JSON";
        this.image = "/images/catering2.jpg";
        Data.formatdata = formatdata;
        Themes.temaElegit(tema);
        SingletonEF.efix = new ArrayList<>();
        SingletonUsuari.usAl = new ArrayList<>();
        SingletonEvent.evAL = new ArrayList<>();
        SingletonTipusEvent.tevntAl=new ArrayList<>();
        ArraylistEH.ehores = new ArrayList<>();
        ArraylistEH.ehores = new ArrayList<>();
        ArraylistET.etemporal = new ArrayList<>();

        Connection conn = Connexio.connectar();
        if (conn == null) {
            if (!Menus.confirmar("Obrir l'aplicació de totes maneres?", "Connexió fallida!!")) {
                System.exit(0);
            }
        } else {
            Connexio.desconnectar(conn);
        }
        
    }

    /**
     * configuració per defecte
     */
    public Configuracio(String x) {
        this.numdecimal = 2;
        this.moneda = "Euro";
        this.formatdata = 0;
        this.regio = "EU";
        this.factorconv = 1;
        this.arxiu = "JSON";
        Data.formatdata = formatdata;
    }

    public Configuracio(int numdecimal, String moneda, int formatdata, String regio, float factorconv, int tema, String arxiu, String image) {
        this.numdecimal = numdecimal;
        this.moneda = moneda;
        this.formatdata = formatdata;
        this.regio = regio;
        this.factorconv = factorconv;
        this.tema = tema;
        this.arxiu = arxiu;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNumdecimal() {
        return numdecimal;
    }

    public void setNumdecimal(int numdecimal) {
        this.numdecimal = numdecimal;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public int getFormatdata() {
        return formatdata;
    }

    public void setFormatdata(int formatdata) {
        this.formatdata = formatdata;
        Data.setFormatdata(formatdata);
    }

    public String getRegio() {
        return regio;
    }

    public void setRegio(String regio) {
        this.regio = regio;
    }

    public float getFactorconv() {
        return factorconv;
    }

    public void setFactorconv(float factorconv) {
        this.factorconv = factorconv;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
        Themes.temaElegit(tema);

    }

    public String getArxiu() {
        return arxiu;
    }

    public void setArxiu(String arxiu) {
        this.arxiu = arxiu;
    }

    /**
     *
     * @param coin establim el valor de les monedes respecte a l'euro
     * @return
     */
    public static float factorConversio(String coin) {
        float factor = 1.0f;
        switch (coin) {
            case "Euro":
                factor = 1.0f;
                break;
            case "Lliura esterlina":
                factor = 0.7476f;
                break;
            case "Dolar":
                factor = 1.13f;
                break;
        }
        return factor;
    }

    /**
     *
     * @param regio establim valors per defecte segons la regió seleccionada
     */
    public static void canviaRegio(String regio) {
        Core.conf.setRegio(regio);
        switch (regio) {
            case "EU":
                Core.conf.setFormatdata(0);
                Core.conf.setMoneda("Euro");
                Data.formatdata = 0;
                Core.conf.setFactorconv(factorConversio("Euro"));
                break;
            case "UK":
                Core.conf.setFormatdata(2);
                Core.conf.setMoneda("Lliura esterlina");
                Data.formatdata = 2;
                Core.conf.setFactorconv(factorConversio("Lliura esterlina"));
                break;
            case "US":
                Core.conf.setFormatdata(2);
                Core.conf.setMoneda("Dolar");
                Data.formatdata = 2;
                Core.conf.setFactorconv(factorConversio("Dolar"));
                break;
        }
    }

    @Override
    public String toString() {
        return "Configuracio [numdecimal=" + numdecimal + ", moneda=" + moneda + ", formatdata=" + formatdata
                + ", regio=" + regio + ", factorconv=" + factorconv + "]";
    }

}
