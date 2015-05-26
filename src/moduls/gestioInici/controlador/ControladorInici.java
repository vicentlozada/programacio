/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioInici.controlador;

import llibreries.Upload;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import moduls.gestioInici.vistes.FrmMail;
import static moduls.gestioInici.controlador.ControladorInici.frmSignUp;
import moduls.gestioInici.model.bll.GIBLL;
import moduls.gestioInici.model.classes.SingletonInici;
import static moduls.gestioMenu.controlador.ControladorFrmMenu.frmMenu;
import static moduls.gestioInici.model.classes.SingletonInici.buit;
import static moduls.gestioInici.model.classes.SingletonInici.imageicono;
import static moduls.gestioInici.model.classes.SingletonInici.verd;
import moduls.gestioInici.vistes.FrmSignIn;
import moduls.gestioInici.vistes.FrmSignUp;
import moduls.gestioUsuaris.model.bll.GUBLL;
import moduls.gestioUsuaris.model.classes.SingletonUsuaris;

/**
 *
 * @author Vicent
 */
public class ControladorInici implements ActionListener, KeyListener, MouseListener, FocusListener {

    public static FrmSignIn frmSignIn = new FrmSignIn();
    public static FrmSignUp frmSignUp = new FrmSignUp();
    public static FrmMail frmMail = new FrmMail();

    public ControladorInici(JDialog frm, int i) {
        switch (i) {
            case 0:
                frmSignIn = (FrmSignIn) frm;
                break;
            case 1:
                frmSignUp = (FrmSignUp) frm;
                break;
            case 2:
                frmMail = (FrmMail) frm;
                break;

        }
    }

    public enum Accion {

        // frmSignIn
        _TXT_USUARI_SignIn,
        _TXT_PASSWORD_SignIn,
        _LBL_REGISTRAR_SignIn,
        _LBL_RECORDAR_SignIn,
        _BTN_INICI_SESSIO_SignIn,
        // frmSignUp
        _TXT_USUARI_SignUp,
        _TXT_PASSWORD_SignUp,
        _DATA_NAIXEMENT_SignUp,
        _TXT_EMAIL_SignUp,
        _BTN_REGISTRE_SignUp,
        // frmMail
        _BTN_ENVIAR_CORREU_RECORDAR,
        _BTN_ENVIAR_CORREU_REGISTRE,
        _TXT_EMAIL

    }

    public void iniciar(int i) {

        switch (i) {
            case 0:
                frmSignIn.setTitle("Inici de sessió");
                frmSignIn.setIconImage(imageicono);
                frmSignIn.setLocationRelativeTo(null);
                frmSignIn.setVisible(true);

                Upload.pintar_imatge(frmSignIn.lblLogo, 80, 80, SingletonInici.logo);

                frmSignIn.btnIniciSessio.setActionCommand("_BTN_INICI_SESSIO_SignIn");
                frmSignIn.btnIniciSessio.setName("_BTN_INICI_SESSIO_SignIn");
                frmSignIn.btnIniciSessio.addActionListener(this);
                frmSignIn.txtUsuari.addKeyListener(this);

                frmSignIn.txtUsuari.setActionCommand("_TXT_USUARI_SignIn");
                frmSignIn.txtUsuari.setName("_TXT_USUARI_SignIn");
                frmSignIn.txtUsuari.addActionListener(this);
                frmSignIn.txtUsuari.addKeyListener(this);
                frmSignIn.txtUsuari.addFocusListener(this);

                frmSignIn.txtPassword.setActionCommand("_TXT_PASSWORD_SignIn");
                frmSignIn.txtPassword.setName("_TXT_PASSWORD_SignIn");
                frmSignIn.txtPassword.addActionListener(this);
                frmSignIn.txtPassword.addKeyListener(this);

                frmSignIn.lblRecordar.setName("_LBL_RECORDAR_SignIn");
                frmSignIn.lblRecordar.addMouseListener(this);

                frmSignIn.lblRegistrar.setName("_LBL_REGISTRAR_SignIn");
                frmSignIn.lblRegistrar.addMouseListener(this);

                frmSignIn.lblRecordar.setText("<html><a href=\"\">Recordar dades d'inici</a></html>");
                frmSignIn.lblRegistrar.setText("<html><a href=\"\">Nou Usuari? Registra't!</a></html>");

                frmSignIn.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        GIBLL.eixir();
                    }
                });
                break;
            case 1:
                frmSignUp.setTitle("Registre");
                frmSignUp.setIconImage(imageicono);
                frmSignUp.setLocationRelativeTo(null);
                frmSignUp.setVisible(true);

                frmSignUp.txtUsuari.setActionCommand("_TXT_USUARI_SignUp");
                frmSignUp.txtUsuari.setName("_TXT_USUARI_SignUp");
                frmSignUp.txtUsuari.addActionListener(this);
                frmSignUp.txtUsuari.addKeyListener(this);
                frmSignUp.txtUsuari.addFocusListener(this);

                frmSignUp.txtPassword.setActionCommand("_TXT_PASSWORD_SignUp");
                frmSignUp.txtPassword.setName("_TXT_PASSWORD_SignUp");
                frmSignUp.txtPassword.addActionListener(this);
                frmSignUp.txtPassword.addKeyListener(this);
                frmSignUp.txtPassword.addFocusListener(this);

                frmSignUp.txtEmail.setActionCommand("_TXT_EMAIL_SignUp");
                frmSignUp.txtEmail.setName("_TXT_EMAIL_SignUp");
                frmSignUp.txtEmail.addActionListener(this);
                frmSignUp.txtEmail.addKeyListener(this);
                frmSignUp.txtEmail.addFocusListener(this);

                frmSignUp.btnRegistre.setActionCommand("_BTN_REGISTRE_SignUp");
                frmSignUp.btnRegistre.setName("_BTN_REGISTRE_SignUp");
                frmSignUp.btnRegistre.addActionListener(this);

                frmSignUp.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        new ControladorInici(new FrmSignIn(), 0).iniciar(0);
                        frmSignUp.dispose();
                    }
                });
                break;

            case 2:
                frmMail.setTitle("Recordar dades");
                frmMail.setIconImage(imageicono);
                frmMail.setLocationRelativeTo(null);
                frmMail.setVisible(true);

                frmMail.btnEnviarCorreu.setActionCommand("_BTN_ENVIAR_CORREU_RECORDAR");
                frmMail.btnEnviarCorreu.setName("_BTN_ENVIAR_CORREU_RECORDAR");
                frmMail.btnEnviarCorreu.addActionListener(this);

                frmMail.txtEmail.setActionCommand("_TXT_EMAIL");
                frmMail.txtEmail.setName("_TXT_EMAIL");
                frmMail.txtEmail.addActionListener(this);
                frmMail.txtEmail.addKeyListener(this);
                frmMail.txtEmail.addFocusListener(this);

                frmMail.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        new ControladorInici(new FrmSignIn(), 0).iniciar(0);
                        frmMail.dispose();                      
                    }
                });

                break;
            case 3:
                frmMail.setTitle("Registre");
                frmMail.setIconImage(imageicono);
                frmMail.setLocationRelativeTo(null);
                frmMail.setVisible(true);

                frmMail.txtEmail.setVisible(false);
                frmMail.lblEmail.setVisible(false);

                frmMail.btnEnviarCorreu.setActionCommand("_BTN_ENVIAR_CORREU_REGISTRE");
                frmMail.btnEnviarCorreu.setName("_BTN_ENVIAR_CORREU_REGISTRE");
                frmMail.btnEnviarCorreu.addActionListener(this);

                frmMail.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        new ControladorInici(new FrmSignIn(), 0).iniciar(0);
                        frmMail.dispose();
                        frmSignUp.dispose();
                    }
                });

                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (Accion.valueOf(ae.getActionCommand())) {

            // frmSignIn
            case _TXT_USUARI_SignIn:
                GIBLL.demanaUsuari_0BLL();
                break;
            case _TXT_PASSWORD_SignIn:
                GIBLL.demanaContrassenya_0BLL();
                break;
            case _BTN_INICI_SESSIO_SignIn:
                if (GIBLL.iniciSessioBLL()) {
                    byte estat = 1;
                    SingletonUsuaris.us2.setEstat(estat);
                    GUBLL.activaUsuariBLL(estat);

                    frmMenu.setEnabled(true);
                    frmSignIn.dispose();
                    Upload.pintar_imatge(frmMenu.lblAvatar, 80, 80, SingletonUsuaris.us2.getAvatar());

                    frmMenu.lblUsuari.setText(SingletonUsuaris.us2.getLogin());
                    frmMenu.lblTipus.setText(SingletonUsuaris.us2.getTipus());

                } else {
                    frmSignIn.txtUsuari.setText(null);
                    frmSignIn.lblbUsuari.setIcon(buit);
                    frmSignIn.txtPassword.setText(null);
                    frmSignIn.lblbPassword.setIcon(buit);
                }
                break;

            // frmSignUp
            case _TXT_USUARI_SignUp:
                GIBLL.demanaUsuari_1BLL();
                break;
            case _TXT_PASSWORD_SignUp:
                GIBLL.demanaContrassenya_1BLL();
                break;
            case _TXT_EMAIL_SignUp:
                GIBLL.demanaEmail_1BLL();
                break;
            case _BTN_REGISTRE_SignUp:
                if (GIBLL.guardar_1BLL()) {
                    new ControladorInici(new FrmMail(), 2).iniciar(3);
                    frmSignUp.setEnabled(false);
                    //new ControladorInici(new FrmSignIn(), 0).iniciar(0);
                }

                break;

            //  frmMail
            case _TXT_EMAIL:
                GIBLL.demanaEmail_3BLL();
                break;

            case _BTN_ENVIAR_CORREU_RECORDAR:
                GIBLL.enviarCorreuBLL();
                break;
            case _BTN_ENVIAR_CORREU_REGISTRE:
                GIBLL.enviarCorreuRegistreBLL();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent kt) {
        switch (Accion.valueOf(kt.getComponent().getName())) {

            // frmSingnIn
            case _TXT_USUARI_SignIn:
                GIBLL.validarUsuari_0BLL();
                break;
            case _TXT_PASSWORD_SignIn:
                GIBLL.validarContrassenya_0BLL();
                break;

            //frmSignUp
            case _TXT_USUARI_SignUp:
                GIBLL.validarUsuari_1BLL();
                break;
            case _TXT_PASSWORD_SignUp:
                GIBLL.validarContrassenya_1BLL();
                break;
            case _TXT_EMAIL_SignUp:
                GIBLL.validarEmail_1BLL();
                break;

            // frmMail
            case _TXT_EMAIL:
                GIBLL.validarEmail_3BLL();
                break;

        }
    }

    @Override
    public void keyPressed(KeyEvent kp) {

    }

    @Override
    public void keyReleased(KeyEvent kr) {
        switch (Accion.valueOf(kr.getComponent().getName())) {

            // frm SignIn
            case _TXT_USUARI_SignIn:
                GIBLL.validarUsuari_0BLL();
                break;
            case _TXT_PASSWORD_SignIn:
                GIBLL.validarContrassenya_0BLL();
                break;

            // frmSignUp
            case _TXT_USUARI_SignUp:
                GIBLL.validarUsuari_1BLL();
                break;
            case _TXT_PASSWORD_SignUp:
                GIBLL.validarContrassenya_1BLL();
                break;
            case _TXT_EMAIL_SignUp:
                GIBLL.validarEmail_1BLL();
                break;

            // frmMail
            case _TXT_EMAIL:
                GIBLL.validarEmail_3BLL();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        switch (Accion.valueOf(me.getComponent().getName())) {

            //frmSignIn
            case _LBL_RECORDAR_SignIn:
                new ControladorInici(new FrmMail(), 2).iniciar(2);
                frmSignIn.dispose();
                break;

            case _LBL_REGISTRAR_SignIn:
                new ControladorInici(new FrmSignUp(), 1).iniciar(1);
                frmSignIn.dispose();
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent mp) {

        switch (Accion.valueOf(mp.getComponent().getName())) {

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void focusGained(FocusEvent fg) {
        switch (Accion.valueOf(fg.getComponent().getName())) {

            // frmSignIn
            case _TXT_USUARI_SignIn:
                frmSignIn.txtUsuari.setForeground(verd);
                break;
            // frmSignUp
            case _TXT_USUARI_SignUp:
                frmSignUp.txtUsuari.setForeground(verd);
                break;
            case _TXT_EMAIL_SignUp:
                frmSignUp.txtEmail.setForeground(verd);
                break;

            // frmMail
            case _TXT_EMAIL:
                frmMail.txtEmail.setForeground(verd);
                break;
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        switch (Accion.valueOf(fe.getComponent().getName())) {

            // frmSignIn
            case _TXT_USUARI_SignIn:
                frmSignIn.txtUsuari.setForeground(Color.BLACK);
                GIBLL.validarUsuari_0BLL();
                break;

            case _TXT_USUARI_SignUp:
                frmSignUp.txtUsuari.setForeground(Color.BLACK);
                GIBLL.validarUsuari_1BLL();
                break;
            case _TXT_PASSWORD_SignUp:
                frmSignUp.txtPassword.setForeground(Color.BLACK);
                GIBLL.validarContrassenya_1BLL();
                break;
            case _TXT_EMAIL_SignUp:
                frmSignUp.txtEmail.setForeground(Color.BLACK);
                GIBLL.validarEmail_1BLL();
                break;
            // frmMail
            case _TXT_EMAIL:
                frmMail.txtEmail.setForeground(Color.BLACK);
                GIBLL.validarEmail_3BLL();
                break;
        }
    }

}
