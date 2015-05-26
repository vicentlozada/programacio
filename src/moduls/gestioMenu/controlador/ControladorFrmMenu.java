/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioMenu.controlador;

import llibreries.Upload;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import llibreries.JFrameConFondo;
import main.Core;
import moduls.configuracio.controlador.ControladorFrmConfig;
import moduls.configuracio.vista.FrmConfig;
import moduls.gestioEmpleats.gestioEF.controlador.ControladorEF;
import moduls.gestioEmpleats.gestioEF.model.bll.EFBLL;
import moduls.gestioEmpleats.gestioEF.vista.FrmInterfaceEF;
import moduls.gestioInici.model.classes.SingletonInici;
import static moduls.gestioInici.model.classes.SingletonInici.imageicono;
import moduls.gestioMenu.vista.FrmMenu;
import moduls.gestioInici.controlador.ControladorInici;
import moduls.gestioInici.vistes.FrmSignIn;
import moduls.gestioUsuaris.controlador.ControladorUsuaris;
import moduls.gestioUsuaris.model.bll.GUBLL;
import moduls.gestioUsuaris.model.classes.SingletonUsuaris;
import moduls.gestioUsuaris.vista.FrmPagerUsuari;
import moduls.gestioUsuaris.vista.FrmUsuari;
import utils.Menus;
import utils.Themes;

/**
 *
 * @author Vicent
 */
public class ControladorFrmMenu implements ActionListener {

    public static FrmMenu frmMenu = new FrmMenu();

    public ControladorFrmMenu(JFrameConFondo frm) {

        frmMenu = (FrmMenu) frm;
    }

    public enum Accion {

        M_CONFIG_GENERAL,
        M_EIXIR,
        M_EMPLEAT_FIX,
        M_EMPLEAT_HORES,
        M_EMPLEAT_TEMPORAL,
        M_GUARDAR_EF,
        M_METAL,
        M_NIMBUS,
        M_WINDOWS,
        M_USUARI,
        M_FISESSIO,
        _LBL_AVATAR,
        _LBL_USUARI

    }

    public void iniciar() {
        frmMenu.setEnabled(false);
        frmMenu.setTitle("Catering");
        frmMenu.setImagen(Core.conf.getImage());

        frmMenu.setLocationRelativeTo(null);
        frmMenu.setVisible(true);

        frmMenu.setIconImage(imageicono);
        //Maximitza el formulari
        frmMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);

        new ControladorInici(new FrmSignIn(), 0).iniciar(0);
        Upload.pintar_imatge(frmMenu.lblAvatar, 80, 80, SingletonInici.default_avatar);
        Upload.pintar_imatge(frmMenu.lblLogo, 80, 80, SingletonInici.logo);
        frmMenu.lblUsuari.setText(SingletonInici.default_login);
        frmMenu.lblTipus.setText(SingletonInici.default_tipus);

        frmMenu.mFiSessio.setActionCommand("M_FISESSIO");
        frmMenu.mFiSessio.setName("M_FISESSIO");
        frmMenu.mFiSessio.addActionListener(this);

        frmMenu.mEixir.setActionCommand("M_EIXIR");
        frmMenu.mEixir.setName("M_EIXIR");
        frmMenu.mEixir.addActionListener(this);

        frmMenu.mGuardarEF.setActionCommand("M_GUARDAR_EF");
        frmMenu.mGuardarEF.setName("M_GUARDAR_EF");
        frmMenu.mGuardarEF.addActionListener(this);

        frmMenu.mConfigGeneral.setActionCommand("M_CONFIG_GENERAL");
        frmMenu.mConfigGeneral.setName("M_CONFIG_GENERAL");
        frmMenu.mConfigGeneral.addActionListener(this);

        frmMenu.mEmpleatFix.setActionCommand("M_EMPLEAT_FIX");
        frmMenu.mEmpleatFix.setName("M_EMPLEAT_FIX");
        frmMenu.mEmpleatFix.addActionListener(this);

        frmMenu.mMetal.setActionCommand("M_METAL");
        frmMenu.mMetal.setName("M_METAL");
        frmMenu.mMetal.addActionListener(this);

        frmMenu.mNimbus.setActionCommand("M_NIMBUS");
        frmMenu.mNimbus.setName("M_NIMBUS");
        frmMenu.mNimbus.addActionListener(this);

        frmMenu.mWindows.setActionCommand("M_WINDOWS");
        frmMenu.mWindows.setName("M_WINDOWS");
        frmMenu.mWindows.addActionListener(this);

        frmMenu.mUsuari.setActionCommand("M_USUARI");
        frmMenu.mUsuari.setName("M_USUARI");
        frmMenu.mUsuari.addActionListener(this);

        frmMenu.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                eixir();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (Accion.valueOf(ae.getActionCommand())) {
            case M_CONFIG_GENERAL:
                frmMenu.setEnabled(false);
                new ControladorFrmConfig(new FrmConfig()).iniciar();
                break;
            case M_EIXIR:
                eixir();
                break;
            case M_FISESSIO:
                if (Menus.confirmar("Tancar la sessió?", "Finalitzar sessió")) {
                    if (SingletonUsuaris.us2.getEstat() == 1) {
                        byte estat = 0;
                        GUBLL.activaUsuariBLL(estat);
                    }
                    frmMenu.setEnabled(false);
                    //SingletonUsuaris.us.setLogin("login");
                    //SingletonUsuaris.us.setTipus("user");
                    //SingletonUsuaris.us.setAvatar(SingletonInici.default_avatar);
                    new ControladorInici(new FrmSignIn(), 0).iniciar(0);
                    Upload.pintar_imatge(frmMenu.lblAvatar, 80, 80, SingletonInici.default_avatar);
                    frmMenu.lblUsuari.setText(SingletonInici.default_login);
                    frmMenu.lblTipus.setText(SingletonInici.default_tipus);

                }
                break;
            case M_EMPLEAT_FIX:
                frmMenu.setEnabled(false);
                new ControladorEF(new FrmInterfaceEF(), 0).iniciar(0);
                break;
            case M_EMPLEAT_HORES:
                break;
            case M_EMPLEAT_TEMPORAL:
                break;
            case M_USUARI:
                frmMenu.setEnabled(false);
                // si és admin obrirà un pager d'usuaris
                
                if ("admin".equals(SingletonUsuaris.us2.getTipus())) {                    
                    new ControladorUsuaris(new FrmPagerUsuari(), 0).iniciar(0);
                    
                } else {
                    new ControladorUsuaris(new FrmUsuari(), 1).iniciar(2);
                }
                break;
            case M_GUARDAR_EF:                
                if ("admin".equals(SingletonUsuaris.us2.getTipus())) {
                    EFBLL.guardarArxiuEFBLL();
                }
                break;
            case M_METAL:
                try {
                    Themes.temaElegit(2);
                    SwingUtilities.updateComponentTreeUI(frmMenu);
                    Core.conf.setTema(2);
                } catch (Exception e) {
                }
                break;
            case M_NIMBUS:
                try {
                    Themes.temaElegit(1);
                    SwingUtilities.updateComponentTreeUI(frmMenu);
                    Core.conf.setTema(1);
                } catch (Exception e) {
                }
                break;
            case M_WINDOWS:
                try {
                    Themes.temaElegit(0);
                    SwingUtilities.updateComponentTreeUI(frmMenu);
                    Core.conf.setTema(0);
                } catch (Exception e) {
                }
                break;
        }
    }

    private void eixir() {
        if (SingletonUsuaris.us2.getEstat() == 1) {
            byte estat = 0;
            SingletonUsuaris.us2.setEstat(estat);
            GUBLL.activaUsuariBLL(estat);
        }
        Menus.information("Eixint de l'aplicació", "Eixir");
        frmMenu.dispose();
        System.exit(0);
    }

}
