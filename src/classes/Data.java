package classes;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Data")
public class Data implements Serializable {

    @XStreamAlias("dia")
    private int dia;
    @XStreamAlias("mes")
    private int mes;
    @XStreamAlias("any")
    private int any;

    /**
     * constructor de la classe buit
     */
    public Data() {
    }

    /**
     * constructor de la classe
     *
     * @param dia
     * @param mes
     * @param any
     */
    public Data(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    /**
     * constructor de la classe: li passem un string de la data i un string del
     * format
     *
     * @param data
     * @param format
     */
    public Data(String data, String format) {
        String[] dades = new String[3];

        switch (format) {
            case "dd/MM/yyyy":
                dades = data.split("/");
                this.dia = Integer.parseInt(dades[0]);
                this.mes = Integer.parseInt(dades[1]);
                this.any = Integer.parseInt(dades[2]);
                break;
            case "dd-MM-yyyy":
                dades = data.split("-");
                this.dia = Integer.parseInt(dades[0]);
                this.mes = Integer.parseInt(dades[1]);
                this.any = Integer.parseInt(dades[2]);
                break;
            case "MM/dd/yyyy":
                dades = data.split("/");
                this.dia = Integer.parseInt(dades[1]);
                this.mes = Integer.parseInt(dades[0]);
                this.any = Integer.parseInt(dades[2]);
                break;
            case "MM-dd-yyyy":
                dades = data.split("-");
                this.dia = Integer.parseInt(dades[1]);
                this.mes = Integer.parseInt(dades[0]);
                this.any = Integer.parseInt(dades[2]);
                break;
            case "yyyy/MM/dd":
                dades = data.split("/");
                this.dia = Integer.parseInt(dades[2]);
                this.mes = Integer.parseInt(dades[1]);
                this.any = Integer.parseInt(dades[0]);
                break;
            case "yyyy-MM-dd":
                dades = data.split("-");
                this.dia = Integer.parseInt(dades[2]);
                this.mes = Integer.parseInt(dades[1]);
                this.any = Integer.parseInt(dades[0]);
                break;
        }
    }

    /**
     * constructor de la classe: li passem un string de la data i un enter del
     * format
     *
     * @param data
     * @param format
     */
    public Data(String data, int format) {
        String[] dades = new String[3];

        switch (format) {
            case 0:
                dades = data.split("/");
                this.dia = Integer.parseInt(dades[0]);
                this.mes = Integer.parseInt(dades[1]);
                this.any = Integer.parseInt(dades[2]);
                break;
            case 1:
                dades = data.split("-");
                this.dia = Integer.parseInt(dades[0]);
                this.mes = Integer.parseInt(dades[1]);
                this.any = Integer.parseInt(dades[2]);
                break;
            case 2:
                dades = data.split("/");
                this.dia = Integer.parseInt(dades[1]);
                this.mes = Integer.parseInt(dades[0]);
                this.any = Integer.parseInt(dades[2]);
                break;
            case 3:
                dades = data.split("-");
                this.dia = Integer.parseInt(dades[1]);
                this.mes = Integer.parseInt(dades[0]);
                this.any = Integer.parseInt(dades[2]);
                break;
            case 4:
                dades = data.split("/");
                this.dia = Integer.parseInt(dades[2]);
                this.mes = Integer.parseInt(dades[1]);
                this.any = Integer.parseInt(dades[0]);
                break;
            case 5:
                dades = data.split("-");
                this.dia = Integer.parseInt(dades[2]);
                this.mes = Integer.parseInt(dades[1]);
                this.any = Integer.parseInt(dades[0]);
                break;
            case 6:
                this.dia = Integer.parseInt(data.substring(0, 1));
                this.mes = Integer.parseInt(data.substring(4, 5));
                this.any = Integer.parseInt(data.substring(6, 9));
                break;
        }
    }

    public static int formatdata;

    public static int getFormatdata() {
        return formatdata;
    }

    public static void setFormatdata(int formatdata) {
        Data.formatdata = formatdata;
    }

    public static String formato(int formato) {
        String[] s = {"dd/MM/yyyy", "dd-MM-yyyy", "MM/dd/yyyy", "MM-dd-yyyy", "yyyy/MM/dd", "yyyy-MM-dd"};

        return s[formato];
    }

    /**
     *
     * @param formato: retorna un enter segons el format de la data
     * @return
     */
    public static int formato2(String formato) {
        int i = 0;
        switch (formato) {
            case "dd/MM/yyyy":
                i = 0;
                break;
            case "dd-MM-yyyy":
                i = 1;
                break;
            case "MM/dd/yyyy":
                i = 2;
                break;
            case "MM-dd-yyyy":
                i = 3;
                break;
            case "yyyy/MM/dd":
                i = 4;
                break;
            case "yyyy-MM-dd":
                i = 5;
                break;
        }

        return i;
    }

    /**
     * Constructor de la classe.
     *
     * @param fecha : li passes un Date.
     */
    public Data(Date data) {// evito utilizar m�todos obsoletos
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        this.dia = cal.get(Calendar.DATE);
        this.mes = cal.get(Calendar.MONTH) + 1;
        this.any = cal.get(Calendar.YEAR);
    }

    /**
     * Constructor de la clase.
     *
     * @param fecha : li passes un Calendar.
     */
    public Data(Calendar data) {
        this.dia = data.get(Calendar.DATE);
        this.mes = data.get(Calendar.MONTH) + 1;
        this.any = data.get(Calendar.YEAR);
    }

    /**
     * Constructor de la classe.
     *
     * @param data : le pasas un GregorianCalendar.
     */
    public Data(GregorianCalendar data) {
        this.dia = data.get(Calendar.DATE);
        this.mes = data.get(Calendar.MONTH) + 1;
        this.any = data.get(Calendar.YEAR);
    }

    /**
     *
     * @param data1
     * @param data2
     * @return
     */
    public static int diferanys(Data data1, Data data2) {
        int any, mes, dia;

        any = data2.getAny() - data1.any;
        mes = data2.mes - data1.mes;
        dia = data2.dia - data1.dia;
        if (mes < 0 || (mes == 0 && dia < 0)) {
            any--;
        }
        return any;
    }

    /**
     *
     * @param data1
     * @param data2
     * @return
     */
    public static int diferdies(Data data1, Data data2) {
        long milisegons = 0, dies = 0;

        Calendar d1 = datatoGregCalendar(data1);
        Calendar d2 = datatoGregCalendar(data2);

        milisegons = Math.abs((d2.getTimeInMillis() - d1.getTimeInMillis()));
        dies = milisegons / (1000 * 60 * 60 * 24);

        return (int) (dies + 1);
    }

    /**
     * retorna la data actual
     *
     * @return
     */
    public static Data datactual() {
        Calendar cal = Calendar.getInstance();
        Data data = new Data(cal);
        return data;
    }

    /**
     *
     * @param data
     * @return
     */
    public int comparaData(Data data) {
        int comp;
        Calendar data1 = Calendar.getInstance();
        Calendar data2 = Calendar.getInstance();

        data1.set(this.any, this.mes - 1, this.dia);
        data2.set(data.getAny(), data.getMes() - 1, data.getDia());
        comp = data1.compareTo(data2);

        return comp;

    }

    public static int comparaData(Data d1, Data d2) {
        int comp;
        Calendar data1 = Calendar.getInstance();
        Calendar data2 = Calendar.getInstance();

        data1.set(d1.any, d1.mes - 1, d1.dia);
        data2.set(d2.getAny(), d2.getMes() - 1, d2.getDia());
        comp = data1.compareTo(data2);

        return comp;

    }

    /**
     *
     * @param data1
     * @param data2
     * @return
     */
    public static boolean comparaDatadespres(Data data1, Data data2) {
        Calendar d1 = datatoGregCalendar(data1);
        Calendar d2 = datatoGregCalendar(data2);

        return d1.after(d2);
    }

    public static boolean comparaDatabans(Data data1, Data data2) {
        Calendar d1 = datatoGregCalendar(data1);
        Calendar d2 = datatoGregCalendar(data2);

        return d1.before(d2);

    }

    /**
     * Transforma una data Data a Date.
     *
     * @param data : le pasas la data Data.
     * @return: una data Date.
     */
    public static Date datatodate(Data data) {// evito utilizar m�todos
        // obsoletos (deprecated) de Date
        Date fec;
        Calendar cal = Calendar.getInstance();
        cal.set(data.getAny(), data.getMes() - 1, data.getDia());
        fec = cal.getTime();
        return fec;
    }

    /**
     * Transforma una data Data a Calendar.
     *
     * @param data : le pasas la data Data.
     * @return: una data Calendar.
     */
    public static Calendar datatoCalendar(Data data) {
        Calendar fec = Calendar.getInstance();

        fec.set(data.getAny(), data.getMes(), data.getDia());

        return fec;
    }

    public static String datatoString(Data data) {
        String d = data.toString();
        return d;
    }

    public static String datatoString2(Data data, int formatdelaData) {
        String d = data.toString2(formatdelaData);
        return d;
    }

    /**
     * Transforma una data Data a GregorianCalendar.
     *
     * @param data : le pasas la data Data.
     * @return: una data GregorianCalendar.
     */
    public static GregorianCalendar datatoGregCalendar(Data data) {
        GregorianCalendar fec = new GregorianCalendar();

        fec.set(data.getAny(), data.getMes(), data.getDia());

        return fec;
    }

    /**
     * Valida si una fecha Fecha es correcta (el d�a existe en el mes indicado).
     *
     * @return: si la fecha es correcta o no.
     */
    public boolean validadata() {
        boolean resultat = true;
        GregorianCalendar data = new GregorianCalendar();
        int dies_mes[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((this.mes < 1) || (this.mes > 12)) {
            resultat = false;
        }

        if (resultat) {
            data.set(this.any, this.mes, this.dia);

            if (data.isLeapYear(this.any)) {
                dies_mes[2] = 29;
            }

            if ((this.dia < 1) || (this.dia > dies_mes[this.mes])) {
                resultat = false;
            }
        }

        return resultat;
    }

    /**
     *
     * @param data
     * @return
     */
    public static boolean validadata(Data data) {
        boolean resultat = true;
        GregorianCalendar cal = new GregorianCalendar();
        cal = datatoGregCalendar(data);

        int dies_mes[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((cal.get(Calendar.MONTH) < 1) || (cal.get(Calendar.MONTH) > 12)) {
            resultat = false;
        }

        if (resultat) {
            if (cal.isLeapYear(cal.get(Calendar.YEAR))) {
                dies_mes[2] = 29;
            }
            if ((cal.get(Calendar.DATE) < 1) || (cal.get(Calendar.DATE) > dies_mes[cal.get(Calendar.MONTH)])) {
                resultat = false;
            }
        }

        return resultat;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    @Override
    public String toString() {
        String d = "";

        switch (getFormatdata()) {
            case 0:
                d = String.format("%02d", this.dia) + "/" + String.format("%02d", this.mes) + "/" + this.any;
                break;
            case 1:
                d = String.format("%02d", this.dia) + "-" + String.format("%02d", this.mes) + "-" + this.any;
                break;
            case 2:
                d = String.format("%02d", this.mes) + "/" + String.format("%02d", this.dia) + "/" + this.any;
                break;
            case 3:
                d = String.format("%02d", this.mes) + "-" + String.format("%02d", this.dia) + "-" + this.any;
                break;
            case 4:
                d = this.any + "/" + String.format("%02d", this.mes) + "/" + String.format("%02d", this.dia);
                break;
            case 5:
                d = this.any + "-" + String.format("%02d", this.mes) + "-" + String.format("%02d", this.dia);
                break;
        }

        return d;
    }

    public String toString2(int formatdelaData) {
        String d = "";

        switch (formatdelaData) {
            case 0:
                d = String.format("%02d", this.dia) + "/" + String.format("%02d", this.mes) + "/" + this.any;
                break;
            case 1:
                d = String.format("%02d", this.dia) + "-" + String.format("%02d", this.mes) + "-" + this.any;
                break;
            case 2:
                d = String.format("%02d", this.mes) + "/" + String.format("%02d", this.dia) + "/" + this.any;
                break;
            case 3:
                d = String.format("%02d", this.mes) + "-" + String.format("%02d", this.dia) + "-" + this.any;
                break;
            case 4:
                d = this.any + "/" + String.format("%02d", this.mes) + "/" + String.format("%02d", this.dia);
                break;
            case 5:
                d = this.any + "-" + String.format("%02d", this.mes) + "-" + String.format("%02d", this.dia);
                break;
        }

        return d;

    }
}
