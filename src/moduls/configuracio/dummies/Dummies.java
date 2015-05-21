package moduls.configuracio.dummies;

import static moduls.gestioEmpleats.gestioEF.model.bll.EFBLL.cercarEmpleat;
import static moduls.gestioEmpleats.gestioEF.model.bll.EFBLL.cercarEmpleatNom;
import moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF;
import moduls.gestioEmpleats.gestioEF.model.classes.EmpleatFix;
import static moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF.ef;
import static utils.Funcions.getCadenaAleatoriaDni;
import static utils.Funcions.getCadenaAleatoriaSalari;
import static utils.Funcions.getData;

public class Dummies {

    public static void carregarDasdes() {
        String nom = "";
        String dni = "";
        byte estat = 0;
        int pos1 = -1;
        int pos2 = -1;
        for (int i = 0; i < 10000; i++) {
            nom = getCadenaAleatoriaNoms();
            dni = getCadenaAleatoriaDni();
            ef = new EmpleatFix(nom, dni,
                    getData("01/01/1956", "31/12/1990"), 1, getCadenaAleatoriaSalari(400, 3000),
                    1, "", "", "", "", estat, "", getData("01/01/2000", "31/12/2014"), i, i);

            pos2 = cercarEmpleatNom(nom);
            if (pos2 == -1) {
                pos1 = cercarEmpleat(dni);
                if ((pos1 == -1)) {
                    SingletonEF.efix.add(ef);
                }
            }

        }
        try {
            Thread.sleep(1); //1 milliseconds
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String getCadenaAleatoriaNoms() {

        String noms = "";
        String[] nom = {"Vicent", "Joan", "Maria", "Josep", "Sara", "Anna", "Rosa",
            "Jaume", "Francesc", "Violant", "Alfons", "Eduard", "Gemma", "Helena", "Marcel",
            "Roger", "Tomeu", "Sònia", "Núria", "Laia"};
        String[] cognom1 = {"Esplugues", "Fuster", "Santonja", "Martí", "Ferrer", "Valls",
            "Soler", "Lluch", "Aragó", "Vinyes", "Albert", "Roig", "Bartomeu", "Batle", "Benevent",
            "Vidal", "Estornell", "Forner", "Seguí", "Martorell"};
        String[] cognom2 = {"Pons", "Vives", "Estruch", "Borja ", "Boronat", "Borrull",
            "Canet", "Castell", "Cots", "Ferriol", "Fenollar", "Geli", "Germà", "Gil", "Illa",
            "Jover", "Llosa", "Marull", "Micó", "Nicolau"};

        int posicio0 = (int) (Math.random() * 222) % 10;
        int posicio1 = (int) (Math.random() * 222) % 10;
        int posicio2 = (int) (Math.random() * 222) % 10;

        return noms = nom[posicio0] + " " + cognom1[posicio1] + " " + cognom2[posicio2];
    }

}
