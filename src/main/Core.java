package main;

import classes.Configuracio;
import moduls.gestioInici.controlador.ControladorInici;
import moduls.gestioInici.model.classes.SingletonInici;
import moduls.gestioInici.vistes.FrmSignUp;
import moduls.gestioMenu.controlador.ControladorFrmMenu;
import moduls.gestioMenu.vista.FrmMenu;
import moduls.gestioUsuaris.vista.FrmUsuari;

public class Core {

    public static Configuracio conf = null;
    public static void main(String args[]) {
        SingletonInici singletonInici = new SingletonInici();
        conf = new Configuracio();

        //new ControladorInici(new FrmSignUp(), 0).iniciar(0);

       new ControladorFrmMenu(new FrmMenu()).iniciar();
    }

}
