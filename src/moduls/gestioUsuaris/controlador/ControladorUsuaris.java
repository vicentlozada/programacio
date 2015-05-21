/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioUsuaris.controlador;

import classes.Upload;
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
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JViewport;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static moduls.gestioInici.model.classes.SingletonInici.imageicono;
import static moduls.gestioInici.model.classes.SingletonInici.verd;
import moduls.gestioInici.vistes.FrmSignUp;
import static moduls.gestioMenu.controlador.ControladorFrmMenu.frmMenu;
import moduls.gestioUsuaris.model.bll.GUBLL;
import moduls.gestioUsuaris.model.classes.SimpleTableModelUS;
import moduls.gestioUsuaris.model.classes.SingletonUsuaris;
import static moduls.gestioUsuaris.model.classes.SingletonUsuaris.usAl;
import moduls.gestioUsuaris.model.classes.Usuari;
import moduls.gestioUsuaris.pager.Pagina;
import static moduls.gestioUsuaris.pager.Pagina.itemsPerPage;
import moduls.gestioUsuaris.vista.FrmPagerUsuari;
import moduls.gestioUsuaris.vista.FrmUsuari;

/**
 *
 * @author Vicent
 */
public class ControladorUsuaris implements ActionListener, KeyListener, MouseListener, FocusListener {

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<>(new SimpleTableModelUS());
    public static FrmUsuari frmUsuari = new FrmUsuari();
    //public static FrmUsuari frmUsuariModificacio = new FrmUsuari();
    public static FrmPagerUsuari frmPagerUsuari = new FrmPagerUsuari();
    public static String avatar_temp;

    public ControladorUsuaris(JDialog frm, int i) {
        switch (i) {
            case 0:
                frmPagerUsuari = (FrmPagerUsuari) frm;
                break;
            case 1:
                frmUsuari = (FrmUsuari) frm;
                break;
        }
    }

    public enum Accion {

        // Finestra FrmPagerUsuari
        _TXT_FILTRE,
        _BTN_TANCAR,
        _BTN_ANTERIOR,
        _BTN_SEGUENT,
        _BTN_PRIMER,
        _BTN_ULTIM,
        _CMB_ENTRADESMOSTRADES,
        _BTN_AFEGIR,
        _BTN_MODIFICAR,
        _BTN_ELIMINAR,
        _BTN_JSON,
        _BTN_TXT,
        _BTN_XML,
        _TAULA,
        
        // Alta
        _TXT_USUARI,
        _TXT_PASSWORD,
        _BTN_GUARDAR,
        _BTN_CANCELAR,
        _TXT_NOM,
        _TXT_DNI,
        _DATA_NAIXEMENT,
        _TXT_EMAIL,
        _LBL_AVATAR,
        _CMB_TIPUS,

        // Modificació 1
        _TXT_USUARI_1,
        _TXT_PASSWORD_1,
        _BTN_GUARDAR_1,
        _BTN_CANCELAR_1,
        _TXT_NOM_1,
        _TXT_DNI_1,
        _TXT_EMAIL_1,
        _DATA_NAIXEMENT_1,
        _LBL_AVATAR_1,
        
        // Modificació 2
        _TXT_USUARI_2,
        _TXT_PASSWORD_2,
        _BTN_GUARDAR_2,
        _BTN_CANCELAR_2,
        _TXT_NOM_2,
        _TXT_DNI_2,
        _DATA_NAIXEMENT_2,
        _TXT_EMAIL_2,
        _LBL_AVATAR_2,
        _CMB_TIPUS_2

    }

    public void iniciar(int i) {

        switch (i) {

            case 0: // 

                frmPagerUsuari.setTitle("Usuaris");
                frmPagerUsuari.setVisible(true);
                frmPagerUsuari.setResizable(false);
                frmPagerUsuari.setLocationRelativeTo(null);

                frmPagerUsuari.taula.setModel(new SimpleTableModelUS());
                ((SimpleTableModelUS) frmPagerUsuari.taula.getModel()).cargar();
                frmPagerUsuari.taula.setFillsViewportHeight(true);
                frmPagerUsuari.taula.addRowSelectionInterval(0, 0); // seleccionem la primera fila 

                setAmpleColumnes(); // personalitzem l'ample de les columnes

                Pagina.inicializa();
                Pagina.initLinkBox();

                // icono de la finestra
                frmPagerUsuari.setIconImage(imageicono);

                frmPagerUsuari.cmbEntradesMostrades.setSelectedItem("" + itemsPerPage);

                // acció de tancar la finestra
                frmPagerUsuari.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        frmMenu.setEnabled(true);
                        frmPagerUsuari.dispose();
                    }
                });
                /*
                 String var = empleatMesAnticBLL();
                 if (var != null) {
                 var = "Empleat amb més temps a l'empresa: " + var;
                 frmIntEF.lblMesAntic.setText(var);
                 }
                 */
                frmPagerUsuari.lblContador.setText(String.valueOf(usAl.size()));

                frmPagerUsuari.taula.setFillsViewportHeight(true);
                frmPagerUsuari.taula.setRowSorter(sorter);

                frmPagerUsuari.taula.addRowSelectionInterval(0, 0); // seleccionem la primera fila 

                // combo mostrar nombre d'entrades per pàgina
                frmPagerUsuari.cmbEntradesMostrades.setActionCommand("_CMB_ENTRADESMOSTRADES");
                frmPagerUsuari.cmbEntradesMostrades.setName("_CMB_ENTRADESMOSTRADES");
                frmPagerUsuari.cmbEntradesMostrades.addActionListener(this);
                // botó primer registre
                frmPagerUsuari.btnPrimer.setActionCommand("_BTN_PRIMER");
                frmPagerUsuari.btnPrimer.setName("_BTN_PRIMER");
                frmPagerUsuari.btnPrimer.addActionListener(this);
                // botó darrer registre
                frmPagerUsuari.btnUltim.setActionCommand("_BTN_ULTIM");
                frmPagerUsuari.btnUltim.setName("_BTN_ULTIM");
                frmPagerUsuari.btnUltim.addActionListener(this);
                // botó següent registre
                frmPagerUsuari.btnSeguent.setActionCommand("_BTN_SEGUENT");
                frmPagerUsuari.btnSeguent.setName("_BTN_SEGUENT");
                frmPagerUsuari.btnSeguent.addActionListener(this);
                // botó anterior registre
                frmPagerUsuari.btnAnterior.setActionCommand("_BTN_ANTERIOR");
                frmPagerUsuari.btnAnterior.setName("_BTN_ANTERIOR");
                frmPagerUsuari.btnAnterior.addActionListener(this);
                // botó tancar finestra
                frmPagerUsuari.btnTancar.setActionCommand("_BTN_TANCAR");
                frmPagerUsuari.btnTancar.setName("_BTN_TANCAR");
                frmPagerUsuari.btnTancar.addActionListener(this);

                // botó afegir registre
                frmPagerUsuari.btnAfegir.setActionCommand("_BTN_AFEGIR");
                frmPagerUsuari.btnAfegir.setName("_BTN_AFEGIR");
                frmPagerUsuari.btnAfegir.addMouseListener(this);
                // botó modificar registre
                frmPagerUsuari.btnModificar.setActionCommand("_BTN_MODIFICAR");
                frmPagerUsuari.btnModificar.setName("_BTN_MODIFICAR");
                frmPagerUsuari.btnModificar.addMouseListener(this);
                // botó eliminar registre
                frmPagerUsuari.btnEliminar.setActionCommand("_BTN_ELIMINAR");
                frmPagerUsuari.btnEliminar.setName("_BTN_ELIMINAR");
                frmPagerUsuari.btnEliminar.addMouseListener(this);
                // botó guardar TXT
                frmPagerUsuari.btnTXT.setActionCommand("_BTN_TXT");
                frmPagerUsuari.btnTXT.setName("_BTN_TXT");
                frmPagerUsuari.btnTXT.addMouseListener(this);
                // botó guardar JSON
                frmPagerUsuari.btnJSON.setActionCommand("_BTN_JSON");
                frmPagerUsuari.btnJSON.setName("_BTN_JSON");
                frmPagerUsuari.btnJSON.addMouseListener(this);
                // botó guardar XML
                frmPagerUsuari.btnXML.setActionCommand("_BTN_XML");
                frmPagerUsuari.btnXML.setName("_BTN_XML");
                frmPagerUsuari.btnXML.addMouseListener(this);
                // Filtre
                frmPagerUsuari.txtFiltre.setActionCommand("_TXT_FILTRE");
                frmPagerUsuari.txtFiltre.setName("_TXT_FILTRE");
                frmPagerUsuari.txtFiltre.addKeyListener(this);

                frmPagerUsuari.taula.setName("_TAULA");
                frmPagerUsuari.taula.addMouseListener(this);
                break;
            //    
            case 1:
                frmUsuari.setTitle("Alta usuaris");
                frmUsuari.setIconImage(imageicono);
                frmUsuari.setLocationRelativeTo(null);
                frmUsuari.setVisible(true);

                ImageIcon avatar = new ImageIcon(SingletonUsuaris.us.getAvatar());
                frmUsuari.lblAvatar.setIcon(avatar);
                frmUsuari.lblUsuari.setText(SingletonUsuaris.us.getLogin());

                frmUsuari.txtUsuari.setActionCommand("_TXT_USUARI");
                frmUsuari.txtUsuari.setName("_TXT_USUARI");
                frmUsuari.txtUsuari.addActionListener(this);
                frmUsuari.txtUsuari.addKeyListener(this);
                frmUsuari.txtUsuari.addFocusListener(this);

                frmUsuari.txtPassword.setActionCommand("_TXT_PASSWORD");
                frmUsuari.txtPassword.setName("_TXT_PASSWORD");
                frmUsuari.txtPassword.addActionListener(this);
                frmUsuari.txtPassword.addKeyListener(this);
                frmUsuari.txtPassword.addFocusListener(this);

                frmUsuari.txtEmail.setActionCommand("_TXT_EMAIL");
                frmUsuari.txtEmail.setName("_TXT_EMAIL_SignUp");
                frmUsuari.txtEmail.addActionListener(this);
                frmUsuari.txtEmail.addKeyListener(this);
                frmUsuari.txtEmail.addFocusListener(this);

                frmUsuari.btnGuardar.setActionCommand("_BTN_GUARDAR");
                frmUsuari.btnGuardar.setName("_BTN_GUARDAR_1");
                frmUsuari.btnGuardar.addActionListener(this);

                frmUsuari.txtNom.setActionCommand("_TXT_NOM");
                frmUsuari.txtNom.setName("_TXT_NOM");
                frmUsuari.txtNom.addActionListener(this);
                frmUsuari.txtNom.addKeyListener(this);
                frmUsuari.txtNom.addFocusListener(this);

                frmUsuari.txtDni.setActionCommand("_TXT_DNI");
                frmUsuari.txtDni.setName("_TXT_DNI");
                frmUsuari.txtDni.addActionListener(this);
                frmUsuari.txtDni.addKeyListener(this);
                frmUsuari.txtDni.addFocusListener(this);

                frmUsuari.btnCancelar.setActionCommand("_BTN_CANCELAR");
                frmUsuari.btnCancelar.setName("_BTN_CANCELAR");
                frmUsuari.btnCancelar.addActionListener(this);

                frmUsuari.btnGuardar.setName("_BTN_GUARDAR");
                frmUsuari.btnGuardar.addActionListener(this);

                frmUsuari.DateDataNaixement.setName("_DATA_NAIXEMENT");
                frmUsuari.DateDataNaixement.addKeyListener(this);

                frmUsuari.lblAvatar.setName("_LBL_AVATAR");
                frmUsuari.lblAvatar.addMouseListener(this);

                frmUsuari.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        new ControladorUsuaris(new FrmSignUp(), 0).iniciar(0);
                        frmUsuari.dispose();
                    }
                });
                break;

            case 2:
                frmUsuari.setTitle("Modificar Usuari");
                frmUsuari.setIconImage(imageicono);
                frmUsuari.setLocationRelativeTo(null);
                frmUsuari.setVisible(true);

                if (GUBLL.cercarUsuariBLL(SingletonUsuaris.us2.getLogin())) {
                    GUBLL.omplirCampsMBLL2();
                    frmUsuari.lblcmbTipusUsuari.setVisible(false);
                    frmUsuari.cmbTipusUsuari.setVisible(false);

                    Upload.pintar_imatge(frmUsuari.lblAvatar, 80, 80, SingletonUsuaris.us.getAvatar());
                    frmUsuari.lblTipus.setText(SingletonUsuaris.us2.getTipus());

                    frmUsuari.txtUsuari.setEnabled(false);
                }
                frmUsuari.txtUsuari.setActionCommand("_TXT_USUARI_1");
                frmUsuari.txtUsuari.setName("_TXT_USUARI_1");
                frmUsuari.txtUsuari.addActionListener(this);
                frmUsuari.txtUsuari.addKeyListener(this);
                frmUsuari.txtUsuari.addFocusListener(this);

                frmUsuari.txtPassword.setActionCommand("_TXT_PASSWORD_1");
                frmUsuari.txtPassword.setName("_TXT_PASSWORD_1");
                frmUsuari.txtPassword.addActionListener(this);
                frmUsuari.txtPassword.addKeyListener(this);
                frmUsuari.txtPassword.addFocusListener(this);

                frmUsuari.txtNom.setActionCommand("_TXT_NOM_1");
                frmUsuari.txtNom.setName("_TXT_NOM_1");
                frmUsuari.txtNom.addActionListener(this);
                frmUsuari.txtNom.addKeyListener(this);
                frmUsuari.txtNom.addFocusListener(this);

                frmUsuari.txtEmail.setActionCommand("_TXT_EMAIL_1");
                frmUsuari.txtEmail.setName("_TXT_EMAIL_1");
                frmUsuari.txtEmail.addActionListener(this);
                frmUsuari.txtEmail.addKeyListener(this);
                frmUsuari.txtEmail.addFocusListener(this);

                frmUsuari.txtDni.setActionCommand("_TXT_DNI_1");
                frmUsuari.txtDni.setName("_TXT_DNI_1");
                frmUsuari.txtDni.addActionListener(this);
                frmUsuari.txtDni.addKeyListener(this);
                frmUsuari.txtDni.addFocusListener(this);

                frmUsuari.btnCancelar.setActionCommand("_BTN_CANCELAR_1");
                frmUsuari.btnCancelar.setName("_BTN_CANCELAR_1");
                frmUsuari.btnCancelar.addActionListener(this);

                frmUsuari.btnGuardar.setActionCommand("_BTN_GUARDAR_1");
                frmUsuari.btnGuardar.setName("_BTN_GUARDAR_1");
                frmUsuari.btnGuardar.addActionListener(this);

                frmUsuari.DateDataNaixement.setName("_DATA_NAIXEMENT_1");
                frmUsuari.DateDataNaixement.addKeyListener(this);

                frmUsuari.lblAvatar.setName("_LBL_AVATAR_1");
                frmUsuari.lblAvatar.addMouseListener(this);

                frmUsuari.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        frmMenu.setEnabled(true);
                        frmUsuari.dispose();
                    }
                });

                break;

            case 3:
                frmUsuari.setTitle("Modificar Usuari");
                frmUsuari.setIconImage(imageicono);
                frmUsuari.setLocationRelativeTo(null);
                frmUsuari.setVisible(true);

                GUBLL.cercarUsuari();
                GUBLL.omplirCampsMBLL();

                avatar_temp = SingletonUsuaris.us.getAvatar();

                Upload.pintar_imatge(frmUsuari.lblAvatar, 80, 80, SingletonUsuaris.us.getAvatar());
                frmUsuari.lblTipus.setText(SingletonUsuaris.us.getTipus());

                frmUsuari.txtUsuari.setEnabled(false);

                frmUsuari.cmbTipusUsuari.setActionCommand("_CMB_TIPUS_2");
                frmUsuari.cmbTipusUsuari.setName("_CMB_TIPUS_2");
                frmUsuari.cmbTipusUsuari.addKeyListener(this);

                frmUsuari.txtUsuari.setActionCommand("_TXT_USUARI_2");
                frmUsuari.txtUsuari.setName("_TXT_USUARI_2");
                frmUsuari.txtUsuari.addActionListener(this);
                frmUsuari.txtUsuari.addKeyListener(this);
                frmUsuari.txtUsuari.addFocusListener(this);

                frmUsuari.txtPassword.setActionCommand("_TXT_PASSWORD_2");
                frmUsuari.txtPassword.setName("_TXT_PASSWORD_2");
                frmUsuari.txtPassword.addActionListener(this);
                frmUsuari.txtPassword.addKeyListener(this);
                frmUsuari.txtPassword.addFocusListener(this);

                frmUsuari.txtNom.setActionCommand("_TXT_NOM_2");
                frmUsuari.txtNom.setName("_TXT_NOM_2");
                frmUsuari.txtNom.addActionListener(this);
                frmUsuari.txtNom.addKeyListener(this);
                frmUsuari.txtNom.addFocusListener(this);

                frmUsuari.txtEmail.setActionCommand("_TXT_EMAIL_2");
                frmUsuari.txtEmail.setName("_TXT_EMAIL_2");
                frmUsuari.txtEmail.addActionListener(this);
                frmUsuari.txtEmail.addKeyListener(this);
                frmUsuari.txtEmail.addFocusListener(this);

                frmUsuari.txtDni.setActionCommand("_TXT_DNI_2");
                frmUsuari.txtDni.setName("_TXT_DNI_2");
                frmUsuari.txtDni.addActionListener(this);
                frmUsuari.txtDni.addKeyListener(this);
                frmUsuari.txtDni.addFocusListener(this);

                frmUsuari.btnCancelar.setActionCommand("_BTN_CANCELAR_2");
                frmUsuari.btnCancelar.setName("_BTN_CANCELAR_2");
                frmUsuari.btnCancelar.addActionListener(this);

                frmUsuari.btnGuardar.setActionCommand("_BTN_GUARDAR_2");
                frmUsuari.btnGuardar.setName("_BTN_GUARDAR_2");
                frmUsuari.btnGuardar.addActionListener(this);

                frmUsuari.DateDataNaixement.setName("_DATA_NAIXEMENT_2");
                frmUsuari.DateDataNaixement.addKeyListener(this);

                frmUsuari.lblAvatar.setName("_LBL_AVATAR_2");
                frmUsuari.lblAvatar.addMouseListener(this);

                frmUsuari.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        new ControladorUsuaris(new FrmPagerUsuari(), 0).iniciar(0);
                        frmUsuari.dispose();
                    }
                });

                break;

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        switch (Accion.valueOf(ae.getActionCommand())) {

            // Finestra FrmInterfaceEF
            case _BTN_ANTERIOR:
                Pagina.currentPageIndex -= 1;
                Pagina.initLinkBox();
                frmPagerUsuari.taula.addRowSelectionInterval(0, 0);
                break;
            case _BTN_SEGUENT:
                Pagina.currentPageIndex += 1;
                Pagina.initLinkBox();
                frmPagerUsuari.taula.addRowSelectionInterval(0, 0);
                break;
            case _BTN_ULTIM:
                Pagina.currentPageIndex = Pagina.maxPageIndex;
                Pagina.initLinkBox();
                frmPagerUsuari.taula.addRowSelectionInterval(0, 0);
                break;
            case _BTN_PRIMER:
                Pagina.currentPageIndex = 1;
                Pagina.initLinkBox();
                frmPagerUsuari.taula.addRowSelectionInterval(0, 0);
                break;
            case _CMB_ENTRADESMOSTRADES:
                Pagina.itemsPerPage = Integer.parseInt(frmPagerUsuari.cmbEntradesMostrades.getSelectedItem().toString());
                Pagina.currentPageIndex = 1;
                Pagina.initLinkBox();
                break;
            case _BTN_TANCAR:
                frmMenu.setEnabled(true);
                frmPagerUsuari.dispose();
                break;

            // Mofificat user
            case _BTN_CANCELAR_1:
                frmMenu.setEnabled(true);
                frmUsuari.dispose();
                break;
            case _TXT_USUARI_1:
                GUBLL.demanarUsuari_1BLL();
                break;
            case _TXT_PASSWORD_1:
                GUBLL.validarContrassenya_1BLL();
                frmUsuari.txtDni.requestFocus();
                break;
            case _TXT_NOM_1:
                GUBLL.demanaNom_1BLL();
                break;
            case _TXT_DNI_1:
                GUBLL.demanaDni_1BLL();
                break;
            case _TXT_EMAIL_1:
                GUBLL.demanaEmail_1BLL();
                break;
            case _BTN_GUARDAR_1:
                if (GUBLL.guardar_1BLL()) {
                frmMenu.setEnabled(true);
                frmUsuari.dispose();
                }
                break;

            // 
            case _BTN_CANCELAR_2:
                new ControladorUsuaris(new FrmPagerUsuari(), 0).iniciar(0);
                frmUsuari.dispose();
                break;
            case _TXT_USUARI_2:
                //GUBLL.frmUsuari();
                break;
            case _TXT_PASSWORD_2:
                GUBLL.validarContrassenya_2BLL();
                frmUsuari.txtDni.requestFocus();
                break;
            case _TXT_NOM_2:
                GUBLL.validarNom_2BLL();
                frmUsuari.txtEmail.requestFocus();
                break;
            case _TXT_DNI_2:
                GUBLL.demanaDni_2BLL();
                break;
            case _TXT_EMAIL_2:
                GUBLL.validarEmail_2BLL();
                break;
            case _CMB_TIPUS_2:
                break;
            case _BTN_GUARDAR_2:
                if (GUBLL.guardar_2BLL()) {
                    new ControladorUsuaris(new FrmPagerUsuari(), 0).iniciar(0);
                    frmUsuari.dispose();
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent kt) {
        switch (Accion.valueOf(kt.getComponent().getName())) {

            //frm 1
            case _TXT_USUARI_1:
                GUBLL.validarUsuari_1BLL();
                break;
            case _TXT_PASSWORD_1:
                GUBLL.validarContrassenya_1BLL();
                break;
            case _TXT_DNI_1:
                GUBLL.validarDni_1BLL();
                break;
            case _TXT_NOM_1:
                GUBLL.validarNom_1BLL();
                break;
            case _TXT_EMAIL_1:
                GUBLL.validarEmail_1BLL();
                break;

            //frm 2
            case _TXT_USUARI_2:
                GUBLL.validarUsuari_2BLL();
                break;
            case _TXT_PASSWORD_2:
                GUBLL.validarContrassenya_2BLL();
                break;
            case _TXT_DNI_2:
                GUBLL.validarDni_2BLL();
                break;
            case _TXT_NOM_2:
                GUBLL.validarNom_2BLL();
                break;
            case _TXT_EMAIL_2:
                GUBLL.validarEmail_2BLL();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent kr) {

        switch (Accion.valueOf(kr.getComponent().getName())) {
            //frmPagerUsuari
            case _TXT_FILTRE:
                try {
                    Pagina.currentPageIndex = 1;
                    ((SimpleTableModelUS) frmPagerUsuari.taula.getModel()).filtrar();
                    if (frmPagerUsuari.taula.getRowCount() > 0) {
                        frmPagerUsuari.taula.addRowSelectionInterval(0, 0);
                    }
                } catch (Exception e) {
                }
                break;

            // frmUsuariRegistre 1
            case _TXT_USUARI_1:
                GUBLL.validarUsuari_1BLL();
                break;
            case _TXT_PASSWORD_1:
                GUBLL.validarContrassenya_1BLL();
                break;
            case _TXT_DNI_1:
                GUBLL.validarDni_1BLL();
                break;
            case _TXT_NOM_1:
                GUBLL.validarNom_1BLL();
                break;
            case _TXT_EMAIL_1:
                GUBLL.validarEmail_1BLL();
                break;

            // frmUsuariRegistre 2
            case _TXT_PASSWORD_2:
                GUBLL.validarContrassenya_2BLL();
                break;
            case _TXT_DNI_2:
                GUBLL.validarDni_2BLL();
                break;
            case _TXT_NOM_2:
                GUBLL.validarNom_2BLL();
                break;
            case _TXT_EMAIL_2:
                GUBLL.validarEmail_2BLL();
                break;

        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {

        switch (Accion.valueOf(me.getComponent().getName())) {

            // frmPagerUsuari
            case _BTN_MODIFICAR:
                int selec = posicioAbsoluta();
                if (selec == -1) {
                } else {
                    String login = (String) frmPagerUsuari.taula.getModel().getValueAt(selec, 0);
                    SingletonUsuaris.us = new Usuari(login);
                    new ControladorUsuaris(new FrmUsuari(), 1).iniciar(3);
                    //frmPagerUsuari.setEnabled(false);
                    frmPagerUsuari.dispose();
                }
                break;

            // frmUsuariRegistre 1            
            case _LBL_AVATAR_1: {
                String ruta_avatar = (Upload.pintar_guardar_imag(frmUsuari.lblAvatar, 80, 80,
                        SingletonUsuaris.us.getAvatar()));
                SingletonUsuaris.us.setAvatar(ruta_avatar);
            }
            break;

            // frmUsuariRegistre 2
            case _LBL_AVATAR_2: {
                String ruta_avatar = (Upload.pintar_guardar_imag(frmUsuari.lblAvatar, 80, 80,
                        SingletonUsuaris.us.getAvatar()));
                SingletonUsuaris.us.setAvatar(ruta_avatar);

            }
            break;

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void focusGained(FocusEvent fg) {
        switch (Accion.valueOf(fg.getComponent().getName())) {

            // 1
            case _TXT_USUARI_1:
                frmUsuari.txtUsuari.setForeground(verd);
                break;
            case _TXT_PASSWORD_1:
                frmUsuari.txtPassword.setForeground(verd);
                break;
            case _TXT_DNI_1:
                frmUsuari.txtDni.setForeground(verd);
                break;
            case _TXT_NOM_1:
                frmUsuari.txtNom.setForeground(verd);
                break;
            case _TXT_EMAIL_1:
                frmUsuari.txtEmail.setForeground(verd);
                break;
            // 2
            case _TXT_PASSWORD_2:
                frmUsuari.txtPassword.setForeground(verd);
                break;
            case _TXT_DNI_2:
                frmUsuari.txtDni.setForeground(verd);
                break;
            case _TXT_NOM_2:
                frmUsuari.txtNom.setForeground(verd);
                break;
            case _TXT_EMAIL_2:
                frmUsuari.txtEmail.setForeground(verd);
                break;
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        switch (Accion.valueOf(fe.getComponent().getName())) {

            // 1
            case _TXT_USUARI_1:
                frmUsuari.txtUsuari.setForeground(Color.BLACK);
                GUBLL.validarUsuari_1BLL();
                break;
            case _TXT_PASSWORD_1:
                frmUsuari.txtPassword.setForeground(Color.BLACK);
                GUBLL.validarContrassenya_1BLL();
                break;
            case _TXT_DNI_1:
                frmUsuari.txtDni.setForeground(Color.BLACK);
                GUBLL.validarDni_1BLL();
                break;
            case _TXT_NOM_1:
                frmUsuari.txtNom.setForeground(Color.BLACK);
                GUBLL.validarNom_1BLL();
                break;
            case _TXT_EMAIL_1:
                frmUsuari.txtEmail.setForeground(Color.BLACK);
                GUBLL.validarEmail_1BLL();
                break;

            // 2
            case _TXT_PASSWORD_2:
                frmUsuari.txtPassword.setForeground(Color.BLACK);
                GUBLL.validarContrassenya_2BLL();
                break;
            case _TXT_DNI_2:
                frmUsuari.txtDni.setForeground(Color.BLACK);
                GUBLL.validarDni_2BLL();
                break;
            case _TXT_NOM_2:
                frmUsuari.txtNom.setForeground(Color.BLACK);
                GUBLL.validarNom_2BLL();
                break;
            case _TXT_EMAIL_2:
                frmUsuari.txtEmail.setForeground(Color.BLACK);
                GUBLL.validarEmail_2BLL();
                break;

        }
    }

    /**
     * personalitzem l'ample de les columnes
     */
    private void setAmpleColumnes() {
        JViewport scroll = (JViewport) frmPagerUsuari.taula.getParent();
        int ample = scroll.getWidth();
        int ampleColumna = 0;
        TableColumnModel modelColumna = frmPagerUsuari.taula.getColumnModel();
        TableColumn columnaTaula;
        for (int i = 0; i < frmPagerUsuari.taula.getColumnCount(); i++) {
            columnaTaula = modelColumna.getColumn(i);
            switch (i) {
                case 0:
                    ampleColumna = (20 * ample) / 100;
                    break;
                case 1:
                    ampleColumna = (30 * ample) / 100;
                    break;
                case 2:
                    ampleColumna = (30 * ample) / 100;
                    break;
                case 3:
                    ampleColumna = (10 * ample) / 100;
                    break;
                case 4:
                    ampleColumna = (10 * ample) / 100;
                    break;
            }
            columnaTaula.setPreferredWidth(ampleColumna);
        }
    }

    private int posicioAbsoluta() {
        int n, selection, inicio, selection1 = 0;
        n = ((SimpleTableModelUS) frmPagerUsuari.taula.getModel()).getRowCount();
        if (n != 0) {
            inicio = (Pagina.currentPageIndex - 1) * Pagina.itemsPerPage;
            selection = frmPagerUsuari.taula.getSelectedRow();
            selection1 = inicio + selection;
        } else {
            selection1 = -1;
        }
        return selection1;
    }

}
