/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioUsuaris.controlador;

import llibreries.Upload;
import java.awt.Color;
import java.awt.Point;
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
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import moduls.gestioInici.model.classes.SingletonInici;
import static moduls.gestioInici.model.classes.SingletonInici.afegir1;
import static moduls.gestioInici.model.classes.SingletonInici.afegir2;
import static moduls.gestioInici.model.classes.SingletonInici.avatar_temp;
import static moduls.gestioInici.model.classes.SingletonInici.editar1;
import static moduls.gestioInici.model.classes.SingletonInici.editar2;
import static moduls.gestioInici.model.classes.SingletonInici.eliminar1;
import static moduls.gestioInici.model.classes.SingletonInici.eliminar2;
import static moduls.gestioInici.model.classes.SingletonInici.imageicono;
import static moduls.gestioInici.model.classes.SingletonInici.verd;
import static moduls.gestioMenu.controlador.ControladorFrmMenu.frmMenu;
import moduls.gestioUsuaris.model.bll.GUBLL;
import moduls.gestioUsuaris.model.classes.SimpleTableModelUS;
import moduls.gestioUsuaris.model.classes.SingletonUsuari;
import static moduls.gestioUsuaris.model.classes.SingletonUsuari.usAl;
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
    public static FrmPagerUsuari frmPagerUsuari = new FrmPagerUsuari();


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
        // frmUsuari
        _TXT_USUARI,
        _TXT_PASSWORD,
        _BTN_AFEGIR_USUARI,
        _BTN_CANCELAR,
        _BTN_CANCELAR_2,
        _TXT_NOM,
        _TXT_DNI,
        _DATA_NAIXEMENT,
        _TXT_EMAIL,
        _LBL_AVATAR_DEFAULT,
        _LBL_AVATAR,
        _CMB_TIPUS,
        _BTN_MODIFICAR_USUARI,
        _BTN_MODIFICAR_USUARI_2

    }

    public void iniciar(int i) {

        switch (i) {

            case 0: // 

                frmPagerUsuari.setTitle("Usuaris");
                frmPagerUsuari.setIconImage(imageicono); // icono de la finestra                
                frmPagerUsuari.setVisible(true);
                frmPagerUsuari.setResizable(false);
                frmPagerUsuari.setLocationRelativeTo(null);

                frmPagerUsuari.taula.setModel(new SimpleTableModelUS());
                ((SimpleTableModelUS) frmPagerUsuari.taula.getModel()).cargar();
                frmPagerUsuari.taula.setFillsViewportHeight(true);
                frmPagerUsuari.taula.setRowSorter(sorter);

                GUBLL.setAmpleColumnesBLL(); // personalitzem l'ample de les columnes

                Pagina.inicializa();
                Pagina.initLinkBox();

                frmPagerUsuari.cmbEntradesMostrades.setSelectedItem("" + itemsPerPage);
                frmPagerUsuari.lblContador.setText(String.valueOf(usAl.size()));            
                
                if (!usAl.isEmpty()) {
                    frmPagerUsuari.taula.addRowSelectionInterval(0, 0); // seleccionem la primera fila  
                }                   

                // acció de tancar la finestra
                frmPagerUsuari.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        frmMenu.setEnabled(true);
                        frmPagerUsuari.dispose();
                    }
                });

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
                frmUsuari.setTitle("Alta Usuaris");
                frmUsuari.setIconImage(imageicono);
                frmUsuari.setLocationRelativeTo(null);
                frmUsuari.setVisible(true);

                avatar_temp = SingletonInici.default_avatar;
                SingletonUsuari.us.setAvatar(avatar_temp);              
                
                Upload.pintar_imatge(frmUsuari.lblAvatar, 80, 80, avatar_temp);
                frmUsuari.lblTipus.setText(SingletonInici.default_tipus);

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
                frmUsuari.txtEmail.setName("_TXT_EMAIL");
                frmUsuari.txtEmail.addActionListener(this);
                frmUsuari.txtEmail.addKeyListener(this);
                frmUsuari.txtEmail.addFocusListener(this);

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

                frmUsuari.btnGuardar.setActionCommand("_BTN_AFEGIR_USUARI");
                frmUsuari.btnGuardar.setName("_BTN_AFEGIR_USUARI");
                frmUsuari.btnGuardar.addActionListener(this);

                frmUsuari.btnCancelar.setActionCommand("_BTN_CANCELAR");
                frmUsuari.btnCancelar.setName("_BTN_CANCELAR");
                frmUsuari.btnCancelar.addActionListener(this);

                frmUsuari.DateDataNaixement.setName("_DATA_NAIXEMENT");
                frmUsuari.DateDataNaixement.addKeyListener(this);

                frmUsuari.lblAvatar.setName("_LBL_AVATAR_DEFAULT");
                frmUsuari.lblAvatar.addMouseListener(this);

                frmUsuari.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        new ControladorUsuaris(new FrmPagerUsuari(), 0).iniciar(0);
                        frmUsuari.dispose();
                    }
                });
                break;

            case 2:
                frmUsuari.setTitle("Modificar Usuari");
                frmUsuari.setIconImage(imageicono);
                frmUsuari.setLocationRelativeTo(null);
                frmUsuari.setVisible(true);

                if (GUBLL.cercarUsuariBLL(SingletonUsuari.us2.getLogin())) {
                    GUBLL.omplirCampsMBLL();
                    frmUsuari.lblcmbTipusUsuari.setVisible(false);
                    frmUsuari.cmbTipusUsuari.setVisible(false);

                    Upload.pintar_imatge(frmUsuari.lblAvatar, 80, 80, SingletonUsuari.us.getAvatar());
                    frmUsuari.lblTipus.setText(SingletonUsuari.us2.getTipus());

                    frmUsuari.txtUsuari.setEnabled(false);
                }
                
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

                frmUsuari.txtNom.setActionCommand("_TXT_NOM");
                frmUsuari.txtNom.setName("_TXT_NOM");
                frmUsuari.txtNom.addActionListener(this);
                frmUsuari.txtNom.addKeyListener(this);
                frmUsuari.txtNom.addFocusListener(this);

                frmUsuari.txtEmail.setActionCommand("_TXT_EMAIL");
                frmUsuari.txtEmail.setName("_TXT_EMAIL");
                frmUsuari.txtEmail.addActionListener(this);
                frmUsuari.txtEmail.addKeyListener(this);
                frmUsuari.txtEmail.addFocusListener(this);

                frmUsuari.txtDni.setActionCommand("_TXT_DNI");
                frmUsuari.txtDni.setName("_TXT_DNI");
                frmUsuari.txtDni.addActionListener(this);
                frmUsuari.txtDni.addKeyListener(this);
                frmUsuari.txtDni.addFocusListener(this);

                frmUsuari.btnCancelar.setActionCommand("_BTN_CANCELAR_2");
                frmUsuari.btnCancelar.setName("_BTN_CANCELAR_2");
                frmUsuari.btnCancelar.addActionListener(this);

                frmUsuari.btnGuardar.setActionCommand("_BTN_MODIFICAR_USUARI_2");
                frmUsuari.btnGuardar.setName("_BTN_MODIFICAR_USUARI_2");
                frmUsuari.btnGuardar.addActionListener(this);

                frmUsuari.DateDataNaixement.setName("_DATA_NAIXEMENT");
                frmUsuari.DateDataNaixement.addKeyListener(this);

                frmUsuari.lblAvatar.setName("_LBL_AVATAR");
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

                avatar_temp = SingletonUsuari.us.getAvatar();

                Upload.pintar_imatge(frmUsuari.lblAvatar, 80, 80, SingletonUsuari.us.getAvatar());
                frmUsuari.lblTipus.setText(SingletonUsuari.us.getTipus());

                frmUsuari.txtUsuari.setEnabled(false);

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

                frmUsuari.txtNom.setActionCommand("_TXT_NOM");
                frmUsuari.txtNom.setName("_TXT_NOM");
                frmUsuari.txtNom.addActionListener(this);
                frmUsuari.txtNom.addKeyListener(this);
                frmUsuari.txtNom.addFocusListener(this);

                frmUsuari.txtEmail.setActionCommand("_TXT_EMAIL");
                frmUsuari.txtEmail.setName("_TXT_EMAIL");
                frmUsuari.txtEmail.addActionListener(this);
                frmUsuari.txtEmail.addKeyListener(this);
                frmUsuari.txtEmail.addFocusListener(this);

                frmUsuari.txtDni.setActionCommand("_TXT_DNI");
                frmUsuari.txtDni.setName("_TXT_DNI");
                frmUsuari.txtDni.addActionListener(this);
                frmUsuari.txtDni.addKeyListener(this);
                frmUsuari.txtDni.addFocusListener(this);

                frmUsuari.btnCancelar.setActionCommand("_BTN_CANCELAR");
                frmUsuari.btnCancelar.setName("_BTN_CANCELAR");
                frmUsuari.btnCancelar.addActionListener(this);

                frmUsuari.btnGuardar.setActionCommand("_BTN_MODIFICAR_USUARI");
                frmUsuari.btnGuardar.setName("_BTN_MODIFICAR_USUARI");
                frmUsuari.btnGuardar.addActionListener(this);

                frmUsuari.DateDataNaixement.setName("_DATA_NAIXEMENT");
                frmUsuari.DateDataNaixement.addKeyListener(this);

                frmUsuari.lblAvatar.setName("_LBL_AVATAR");
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

            // frmPagerUsuari
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

            // frmUsuari
            case _BTN_CANCELAR:
                new ControladorUsuaris(new FrmPagerUsuari(), 0).iniciar(0);
                frmUsuari.dispose();
                break;
            case _BTN_CANCELAR_2:
                frmMenu.setEnabled(true);
                frmUsuari.dispose();
                frmUsuari.dispose();
                break;
            case _BTN_AFEGIR_USUARI:
                if (GUBLL.afegirUsuariBLL()) {
                    frmMenu.setEnabled(true);
                    frmUsuari.dispose();
                }
                break;
            case _TXT_USUARI:
                GUBLL.demanaUsuariBLL();
                break;
            case _TXT_PASSWORD:
                GUBLL.demanaContrassenyaBLL();
                break;
            case _TXT_NOM:
                GUBLL.demanaNomBLL();
                break;
            case _TXT_DNI:
                GUBLL.demanaDniBLL();
                break;
            case _TXT_EMAIL:
                GUBLL.validarEmailBLL();
                break;
            case _BTN_MODIFICAR_USUARI:
                if (GUBLL.modificarUsuariBLL()) {
                    new ControladorUsuaris(new FrmPagerUsuari(), 0).iniciar(0);
                    frmUsuari.dispose();
                }
                break;
            case _BTN_MODIFICAR_USUARI_2:
                if (GUBLL.modificarUsuariBLL()) {
                    frmMenu.setEnabled(true);
                    frmUsuari.dispose();
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent kt) {
        switch (Accion.valueOf(kt.getComponent().getName())) {
            case _TXT_USUARI:
                GUBLL.validarUsuariBLL();
                break;
            case _TXT_PASSWORD:
                GUBLL.validarContrassenyaBLL();
                break;
            case _TXT_DNI:
                GUBLL.validarDniBLL();
                break;
            case _TXT_NOM:
                GUBLL.validarNomBLL();
                break;
            case _TXT_EMAIL:
                GUBLL.validarEmailBLL();
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
            case _TXT_USUARI:
                GUBLL.validarUsuariBLL();
                break;
            case _TXT_PASSWORD:
                GUBLL.validarContrassenyaBLL();
                break;
            case _TXT_DNI:
                GUBLL.validarDniBLL();
                break;
            case _TXT_NOM:
                GUBLL.validarNomBLL();
                break;
            case _TXT_EMAIL:
                GUBLL.validarEmailBLL();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int selec;
        switch (Accion.valueOf(me.getComponent().getName())) {
            // frmPagerUsuari
            case _BTN_MODIFICAR:
                selec = GUBLL.posicioAbsolutaBLL();
                if (selec == -1) {
                } else {
                    String login = (String) frmPagerUsuari.taula.getModel().getValueAt(selec, 0);
                    SingletonUsuari.us = new Usuari(login);
                    new ControladorUsuaris(new FrmUsuari(), 1).iniciar(3);
                    frmPagerUsuari.dispose();
                }
                break;
            case _BTN_AFEGIR:
                if (!SingletonUsuari.usAl.isEmpty()) {
                    selec = GUBLL.posicioAbsolutaBLL();
                    if (selec == -1) {
                    } else {
                        new ControladorUsuaris(new FrmUsuari(), 1).iniciar(1);
                        frmPagerUsuari.dispose();
                    }
                }
                break;
            case _BTN_ELIMINAR:
                if (!SingletonUsuari.usAl.isEmpty()) {
                    selec = GUBLL.posicioAbsolutaBLL();
                    if (selec == -1) {
                    } else {
                        String login = (String) frmPagerUsuari.taula.getModel().getValueAt(selec, 0);
                        SingletonUsuari.us = new Usuari(login);
                        if (!SingletonUsuari.us.equals(SingletonUsuari.us2)) {
                            if (GUBLL.eliminarUS()) {
                                new ControladorUsuaris(new FrmPagerUsuari(), 0).iniciar(0);
                                frmPagerUsuari.dispose();
                            }
                        }
                    }
                }
                break;
            // 
            case _LBL_AVATAR_DEFAULT:
                String ruta_avatar = (Upload.pintar_guardar_imag(frmUsuari.lblAvatar, 80, 80,
                        SingletonInici.default_avatar));
                SingletonUsuari.us.setAvatar(ruta_avatar);
                break;
            case _LBL_AVATAR:
                ruta_avatar = (Upload.pintar_guardar_imag(frmUsuari.lblAvatar, 80, 80,
                        SingletonUsuari.us.getAvatar()));
                SingletonUsuari.us.setAvatar(ruta_avatar);
                break;
            case _TAULA:
                frmPagerUsuari.taula = (JTable) me.getSource();
                Point point = me.getPoint();
                int row = frmPagerUsuari.taula.rowAtPoint(point);
                if (me.getClickCount() == 2) {
                    selec = GUBLL.posicioAbsolutaBLL();
                    String login = (String) frmPagerUsuari.taula.getModel().getValueAt(selec, 0);
                    SingletonUsuari.us = new Usuari(login);
                    frmPagerUsuari.dispose();
                    new ControladorUsuaris(new FrmUsuari(), 1).iniciar(3);
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
    public void mouseEntered(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            // Finestra FrmInterfaceEF 
            case _BTN_XML:
                frmPagerUsuari.btnXML.setText("<html><b><font color=green >XML</font><b></html>");
                break;
            case _BTN_JSON:
                frmPagerUsuari.btnJSON.setText("<html><b><font color=green >JSON</font><b></html>");
                break;
            case _BTN_TXT:
                frmPagerUsuari.btnTXT.setText("<html><b><font color=green >TXT</font><b></html>");
                break;
            case _BTN_AFEGIR:
                frmPagerUsuari.btnAfegir.setIcon(afegir1);
                break;
            case _BTN_MODIFICAR:
                frmPagerUsuari.btnModificar.setIcon(editar1);
                break;
            case _BTN_ELIMINAR:
                frmPagerUsuari.btnEliminar.setIcon(eliminar1);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            // Finestra FrmInterfaceEF
            case _BTN_XML:
                frmPagerUsuari.btnXML.setText("<html><b><font color=black>XML</font><b></html>");
                break;
            case _BTN_JSON:
                frmPagerUsuari.btnJSON.setText("<html><b><font color=black>JSON</font><b></html>");
                break;
            case _BTN_TXT:
                frmPagerUsuari.btnTXT.setText("<html><font color=black>TXT</font></html>");
                break;
            case _BTN_AFEGIR:
                frmPagerUsuari.btnAfegir.setIcon(afegir2);
                break;
            case _BTN_MODIFICAR:
                frmPagerUsuari.btnModificar.setIcon(editar2);
                break;
            case _BTN_ELIMINAR:
                frmPagerUsuari.btnEliminar.setIcon(eliminar2);
                break;
        }
    }

    @Override
    public void focusGained(FocusEvent fg) {
        switch (Accion.valueOf(fg.getComponent().getName())) {
            case _TXT_USUARI:
                frmUsuari.txtUsuari.setForeground(verd);
                break;
            case _TXT_PASSWORD:
                frmUsuari.txtPassword.setForeground(verd);
                break;
            case _TXT_DNI:
                frmUsuari.txtDni.setForeground(verd);
                break;
            case _TXT_NOM:
                frmUsuari.txtNom.setForeground(verd);
                break;
            case _TXT_EMAIL:
                frmUsuari.txtEmail.setForeground(verd);
                break;
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        switch (Accion.valueOf(fe.getComponent().getName())) {
            case _TXT_USUARI:
                frmUsuari.txtUsuari.setForeground(Color.BLACK);
                GUBLL.validarUsuariBLL();
                break;
            case _TXT_PASSWORD:
                frmUsuari.txtPassword.setForeground(Color.BLACK);
                GUBLL.validarContrassenyaBLL();
                break;
            case _TXT_DNI:
                frmUsuari.txtDni.setForeground(Color.BLACK);
                GUBLL.validarDniBLL();
                break;
            case _TXT_NOM:
                frmUsuari.txtNom.setForeground(Color.BLACK);
                GUBLL.validarNomBLL();
                break;
            case _TXT_EMAIL:
                frmUsuari.txtEmail.setForeground(Color.BLACK);
                GUBLL.validarEmailBLL();
                break;
        }
    }

}
