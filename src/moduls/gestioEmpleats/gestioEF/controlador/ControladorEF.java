/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioEmpleats.gestioEF.controlador;

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
import llibreries.Upload;
import moduls.gestioEmpleats.gestioEF.model.bll.EFBLL;
import static moduls.gestioEmpleats.gestioEF.model.bll.EFBLL.empleatMesAnticBLL;
import moduls.gestioEmpleats.gestioEF.model.classes.EmpleatFix;
import moduls.gestioEmpleats.gestioEF.model.classes.SimpleTableModelEF;
import moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF;
import static moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF.efix;
import moduls.gestioEmpleats.gestioEF.pager.Pagina;
import static moduls.gestioEmpleats.gestioEF.pager.Pagina.itemsPerPage;
import moduls.gestioEmpleats.gestioEF.vista.FrmEF;
import moduls.gestioEmpleats.gestioEF.vista.FrmPagerEF;
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
import moduls.gestioUsuaris.model.classes.SingletonUsuari;

/**
 *
 * @author Vicent
 */
public class ControladorEF implements ActionListener, KeyListener, MouseListener, FocusListener {

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<>(new SimpleTableModelEF());
    public static FrmPagerEF frmPagerEF = new FrmPagerEF();
    public static FrmEF frmAltaEF = new FrmEF();
    public static FrmEF frmModiEF = new FrmEF();

    public ControladorEF(JDialog frm, int i) {

        switch (i) {
            case 0:
                frmPagerEF = (FrmPagerEF) frm;
                break;
            case 1:
                frmAltaEF = (FrmEF) frm;
                break;
            case 2:
                frmModiEF = (FrmEF) frm;
                break;
        }
    }

    public enum Accion {

        // Finestra FrmPagerEF
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
        // Finestra FrmAlta
        _BTN_GUARDAR1,
        _BTN_CANCELAR1,
        _BTN_TANCAR1,
        _TXT_NOM1,
        _TXT_DNI1,
        _TXT_SALARIBASE1,
        _DATA_NAIXEMENT1,
        _LBL_AVATAR1,
        _TXT_EMAIL1,
        // Finestra FrmModi
        _BTN_GUARDAR2,
        _BTN_CANCELAR2,
        _BTN_TANCAR2,
        _TXT_NOM2,
        _TXT_DNI2,
        _TXT_SALARIBASE2,
        _DATA_NAIXEMENT2,
        _LBL_AVATAR2,
        _TXT_EMAIL2

    }

    public void iniciar(int i) {

        switch (i) {

            case 0: // Finestra FrmPagerEF

                frmPagerEF.setTitle("Empleat Fix");
                frmPagerEF.setIconImage(imageicono);
                frmPagerEF.setVisible(true);
                frmPagerEF.setResizable(false);
                frmPagerEF.setLocationRelativeTo(null);

                frmPagerEF.taula.setModel(new SimpleTableModelEF());
                ((SimpleTableModelEF) frmPagerEF.taula.getModel()).cargar();
                frmPagerEF.taula.setFillsViewportHeight(true);
                frmPagerEF.taula.setRowSorter(sorter);

                EFBLL.setAmpleColumnesBLL(); // personalitzem l'ample de les columnes

                Pagina.inicializa();
                Pagina.initLinkBox();

                frmPagerEF.cmbEntradesMostrades.setSelectedItem("" + itemsPerPage);
                frmPagerEF.lblContador.setText(String.valueOf(efix.size()));

                if (!efix.isEmpty()) {
                    frmPagerEF.taula.addRowSelectionInterval(0, 0); // seleccionem la primera fila  
                }

                // acció de tancar la finestra
                frmPagerEF.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        frmMenu.setEnabled(true);
                        frmPagerEF.dispose();
                    }
                });

                String var = empleatMesAnticBLL();
                
                if (var != null) {
                    var = "Empleat amb més temps a l'empresa: " + var;
                    frmPagerEF.lblMesAntic.setText(var);
                }

                // combo mostrar nombre d'entrades per pàgina
                frmPagerEF.cmbEntradesMostrades.setActionCommand("_CMB_ENTRADESMOSTRADES");
                frmPagerEF.cmbEntradesMostrades.setName("_CMB_ENTRADESMOSTRADES");
                frmPagerEF.cmbEntradesMostrades.addActionListener(this);
                // botó primer registre
                frmPagerEF.btnPrimer.setActionCommand("_BTN_PRIMER");
                frmPagerEF.btnPrimer.setName("_BTN_PRIMER");
                frmPagerEF.btnPrimer.addActionListener(this);
                // botó darrer registre
                frmPagerEF.btnUltim.setActionCommand("_BTN_ULTIM");
                frmPagerEF.btnUltim.setName("_BTN_ULTIM");
                frmPagerEF.btnUltim.addActionListener(this);
                // botó següent registre
                frmPagerEF.btnSeguent.setActionCommand("_BTN_SEGUENT");
                frmPagerEF.btnSeguent.setName("_BTN_SEGUENT");
                frmPagerEF.btnSeguent.addActionListener(this);
                // botó anterior registre
                frmPagerEF.btnAnterior.setActionCommand("_BTN_ANTERIOR");
                frmPagerEF.btnAnterior.setName("_BTN_ANTERIOR");
                frmPagerEF.btnAnterior.addActionListener(this);
                // botó tancar finestra
                frmPagerEF.btnTancar.setActionCommand("_BTN_TANCAR");
                frmPagerEF.btnTancar.setName("_BTN_TANCAR");
                frmPagerEF.btnTancar.addActionListener(this);

                // botó afegir registre
                frmPagerEF.btnAfegir.setActionCommand("_BTN_AFEGIR");
                frmPagerEF.btnAfegir.setName("_BTN_AFEGIR");
                frmPagerEF.btnAfegir.addMouseListener(this);
                // botó modificar registre
                frmPagerEF.btnModificar.setActionCommand("_BTN_MODIFICAR");
                frmPagerEF.btnModificar.setName("_BTN_MODIFICAR");
                frmPagerEF.btnModificar.addMouseListener(this);
                // botó eliminar registre
                frmPagerEF.btnEliminar.setActionCommand("_BTN_ELIMINAR");
                frmPagerEF.btnEliminar.setName("_BTN_ELIMINAR");
                frmPagerEF.btnEliminar.addMouseListener(this);
                // botó guardar TXT
                frmPagerEF.btnTXT.setActionCommand("_BTN_TXT");
                frmPagerEF.btnTXT.setName("_BTN_TXT");
                frmPagerEF.btnTXT.addMouseListener(this);
                // botó guardar JSON
                frmPagerEF.btnJSON.setActionCommand("_BTN_JSON");
                frmPagerEF.btnJSON.setName("_BTN_JSON");
                frmPagerEF.btnJSON.addMouseListener(this);
                // botó guardar XML
                frmPagerEF.btnXML.setActionCommand("_BTN_XML");
                frmPagerEF.btnXML.setName("_BTN_XML");
                frmPagerEF.btnXML.addMouseListener(this);
                // Filtre
                frmPagerEF.txtFiltre.setActionCommand("_TXT_FILTRE");
                frmPagerEF.txtFiltre.setName("_TXT_FILTRE");
                frmPagerEF.txtFiltre.addKeyListener(this);

                frmPagerEF.taula.setName("_TAULA");
                frmPagerEF.taula.addMouseListener(this);
                break;

            case 1: // Finestra Alta

                frmAltaEF.setTitle("Empleat Fix: AFEGIR");
                frmAltaEF.setIconImage(imageicono);  // icono de la finestra
                frmAltaEF.setVisible(true);
                frmAltaEF.setResizable(false);
                frmAltaEF.setLocationRelativeTo(null);

                avatar_temp = SingletonInici.default_avatar;

                //SingletonEF.ef.setAvatar(avatar_temp);
                Upload.pintar_imatge(frmAltaEF.lblAvatar, 80, 80, avatar_temp);

                // acció de tancar la finestra
                frmAltaEF.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        frmAltaEF.dispose();
                        new ControladorEF(new FrmPagerEF(), 0).iniciar(0);

                    }
                });

                frmAltaEF.btnGuardar.setActionCommand("_BTN_GUARDAR1");
                frmAltaEF.btnGuardar.setName("_BTN_GUARDAR1");
                frmAltaEF.btnGuardar.addActionListener(this);

                frmAltaEF.btnTancar.setActionCommand("_BTN_TANCAR1");
                frmAltaEF.btnTancar.setName("_BTN_TANCAR1");
                frmAltaEF.btnTancar.addActionListener(this);

                frmAltaEF.txtNom.setActionCommand("_TXT_NOM1");
                frmAltaEF.txtNom.setName("_TXT_NOM1");
                frmAltaEF.txtNom.addActionListener(this);
                frmAltaEF.txtNom.addKeyListener(this);
                frmAltaEF.txtNom.addFocusListener(this);

                frmAltaEF.txtEmail.setActionCommand("_TXT_EMAIL1");
                frmAltaEF.txtEmail.setName("_TXT_EMAIL1");
                frmAltaEF.txtEmail.addActionListener(this);
                frmAltaEF.txtEmail.addKeyListener(this);
                frmAltaEF.txtEmail.addFocusListener(this);

                frmAltaEF.txtDni.setActionCommand("_TXT_DNI1");
                frmAltaEF.txtDni.setName("_TXT_DNI1");
                frmAltaEF.txtDni.addActionListener(this);
                frmAltaEF.txtDni.addKeyListener(this);
                frmAltaEF.txtDni.addFocusListener(this);

                frmAltaEF.txtSalariBase.setActionCommand("_TXT_SALARIBASE1");
                frmAltaEF.txtSalariBase.setName("_TXT_SALARIBASE1");
                frmAltaEF.txtSalariBase.addActionListener(this);
                frmAltaEF.txtSalariBase.addKeyListener(this);
                frmAltaEF.txtSalariBase.addFocusListener(this);

                frmAltaEF.DateDataNaixement.setName("_DATA_NAIXEMENT1");
                frmAltaEF.DateDataNaixement.addKeyListener(this);

                frmAltaEF.lblAvatar.setName("_LBL_AVATAR1");
                frmAltaEF.lblAvatar.addMouseListener(this);

                break;

            case 2: // Finestra Modi

                frmModiEF.setTitle("Empleat Fix: MODIFICAR");
                frmModiEF.setVisible(true);
                frmModiEF.setIconImage(imageicono);  // icono de la finestra              
                frmModiEF.setResizable(false);
                frmModiEF.setLocationRelativeTo(null);
               
                // acció de tancar la finestra
                frmModiEF.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        frmModiEF.dispose();
                        new ControladorEF(new FrmPagerEF(), 0).iniciar(0);
                    }
                });

                EFBLL.cercarEmpleatFix();
                EFBLL.omplirCampsMBLL();

                frmModiEF.txtDni.setEditable(false);

                frmModiEF.lblAvatar.setName("_LBL_AVATAR2");
                frmModiEF.lblAvatar.addMouseListener(this);

                frmModiEF.btnGuardar.setActionCommand("_BTN_GUARDAR2");
                frmModiEF.btnGuardar.setName("_BTN_GUARDAR2");
                frmModiEF.btnGuardar.addActionListener(this);

                frmModiEF.btnTancar.setActionCommand("_BTN_TANCAR2");
                frmModiEF.btnTancar.setName("_BTN_TANCAR2");
                frmModiEF.btnTancar.addActionListener(this);

                frmModiEF.txtNom.setActionCommand("_TXT_NOM2");
                frmModiEF.txtNom.setName("_TXT_NOM2");
                frmModiEF.txtNom.addActionListener(this);
                frmModiEF.txtNom.addKeyListener(this);
                frmModiEF.txtNom.addFocusListener(this);

                frmModiEF.txtEmail.setActionCommand("_TXT_EMAIL2");
                frmModiEF.txtEmail.setName("_TXT_EMAIL2");
                frmModiEF.txtEmail.addActionListener(this);
                frmModiEF.txtEmail.addKeyListener(this);
                frmModiEF.txtEmail.addFocusListener(this);

                frmModiEF.txtDni.setActionCommand("_TXT_DNI2");
                frmModiEF.txtDni.setName("_TXT_DNI2");
                frmModiEF.txtDni.addActionListener(this);
                frmModiEF.txtDni.addKeyListener(this);
                frmModiEF.txtDni.addFocusListener(this);

                frmModiEF.txtSalariBase.setActionCommand("_TXT_SALARIBASE2");
                frmModiEF.txtSalariBase.setName("_TXT_SALARIBASE2");
                frmModiEF.txtSalariBase.addActionListener(this);
                frmModiEF.txtSalariBase.addKeyListener(this);
                frmModiEF.txtSalariBase.addFocusListener(this);

                frmModiEF.DateDataNaixement.setName("_DATA_NAIXEMENT2");
                frmModiEF.DateDataNaixement.addKeyListener(this);
                break;
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (Accion.valueOf(ae.getActionCommand())) {
            // Finestra FrmPagerEF
            case _BTN_ANTERIOR:
                Pagina.currentPageIndex -= 1;
                Pagina.initLinkBox();
                frmPagerEF.taula.addRowSelectionInterval(0, 0);
                break;
            case _BTN_SEGUENT:
                Pagina.currentPageIndex += 1;
                Pagina.initLinkBox();
                frmPagerEF.taula.addRowSelectionInterval(0, 0);
                break;
            case _BTN_ULTIM:
                Pagina.currentPageIndex = Pagina.maxPageIndex;
                Pagina.initLinkBox();
                frmPagerEF.taula.addRowSelectionInterval(0, 0);
                break;
            case _BTN_PRIMER:
                Pagina.currentPageIndex = 1;
                Pagina.initLinkBox();
                frmPagerEF.taula.addRowSelectionInterval(0, 0);
                break;
            case _CMB_ENTRADESMOSTRADES:
                Pagina.itemsPerPage = Integer.parseInt(frmPagerEF.cmbEntradesMostrades.getSelectedItem().toString());
                Pagina.currentPageIndex = 1;
                Pagina.initLinkBox();
                break;
            case _BTN_TANCAR:
                frmMenu.setEnabled(true);
                frmPagerEF.dispose();
                break;
            case _BTN_TANCAR1:
                frmAltaEF.dispose();
                new ControladorEF(new FrmPagerEF(), 0).iniciar(0);
                break;
            case _BTN_TANCAR2:
                frmModiEF.dispose();
                new ControladorEF(new FrmPagerEF(), 0).iniciar(0);
                break;            
            case _BTN_GUARDAR1:
                EFBLL.guardarAEFBLL();
                if (EFBLL.guardarA()) {
                    new ControladorEF(new FrmPagerEF(), 0).iniciar(0);
                    String var = empleatMesAnticBLL();
                    if (var != null) {
                        var = "Empleat amb més temps a l'empresa: " + var;
                        frmPagerEF.lblMesAntic.setText(var);
                    }
                    frmAltaEF.dispose();
                }
                break;
            case _BTN_GUARDAR2:
                EFBLL.guardarMEFBLL();
                if (SingletonEF.ef != null) {
                    if (EFBLL.guardarM()) {
                        new ControladorEF(new FrmPagerEF(), 0).iniciar(0);
                        String var = empleatMesAnticBLL();
                        if (var != null) {
                            var = "Empleat amb més temps a l'empresa: " + var;
                            frmPagerEF.lblMesAntic.setText(var);
                        }
                        frmModiEF.dispose();
                    }
                }
                break;
            case _TXT_NOM1:
                EFBLL.validarNomAEFBLL();
                break;
            case _TXT_NOM2:
                EFBLL.validarNomMEFBLL();
                break;
            case _TXT_DNI1:
                EFBLL.demanaDniEFBLL();
                break;
            case _TXT_EMAIL1:
                EFBLL.validarEmailABLL();
                break;
            case _TXT_EMAIL2:
                EFBLL.validarEmailMBLL();
                break;
            case _TXT_SALARIBASE1:
                EFBLL.demanaSalariABLL();
                break;
            case _TXT_SALARIBASE2:
                EFBLL.demanaSalariMBLL();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int selec;
        String ruta_avatar;
        switch (Accion.valueOf(me.getComponent().getName())) {

            // Finestra FrmPagerEF
            case _BTN_XML:
                EFBLL.guardarArxiuXMLEFBLL();
                break;
            case _BTN_JSON:
                EFBLL.guardarArxiuJSONEFBLL();
                break;
            case _BTN_TXT:
                EFBLL.guardarArxiuTXTEFBLL();
                break;
            case _BTN_AFEGIR:
                if (SingletonEF.efix.isEmpty()) {
                    new ControladorEF(new FrmEF(), 1).iniciar(1);
                    frmPagerEF.dispose();
                } else {
                    selec = EFBLL.posicioAbsolutaBLL();
                    if (selec == -1) {
                    } else {
                        new ControladorEF(new FrmEF(), 1).iniciar(1);
                        frmPagerEF.dispose();
                    }
                }
                break;
            case _BTN_MODIFICAR:
                if (SingletonEF.efix.isEmpty()) {
                    new ControladorEF(new FrmEF(), 2).iniciar(2);
                    frmPagerEF.dispose();
                } else {
                    selec = EFBLL.posicioAbsolutaBLL();
                    if (selec == -1) {
                    } else {
                        String dni = (String) frmPagerEF.taula.getModel().getValueAt(selec, 0);
                        SingletonEF.ef2 = new EmpleatFix(dni);
                        new ControladorEF(new FrmEF(), 2).iniciar(2);
                        frmPagerEF.dispose();
                    }
                }
                break;
            case _BTN_ELIMINAR:
                if (!SingletonEF.efix.isEmpty()) {
                    selec = EFBLL.posicioAbsolutaBLL();
                    if (selec == -1) {
                    } else {
                        String dni = (String) frmPagerEF.taula.getModel().getValueAt(selec, 0);
                        SingletonEF.ef2 = new EmpleatFix(dni);
                        if (EFBLL.eliminarEF()) {
                            new ControladorEF(new FrmPagerEF(), 0).iniciar(0);
                            frmPagerEF.dispose();
                        }
                    }
                }

                break;
            case _TAULA:
                frmPagerEF.taula = (JTable) me.getSource();
                Point point = me.getPoint();
                int row = frmPagerEF.taula.rowAtPoint(point);
                if (me.getClickCount() == 2) {
                    selec = EFBLL.posicioAbsolutaBLL();
                    String dni = (String) frmPagerEF.taula.getModel().getValueAt(selec, 0);
                    SingletonEF.ef2 = new EmpleatFix(dni);
                    frmPagerEF.dispose();
                    new ControladorEF(new FrmEF(), 2).iniciar(2);
                }
                break;
            case _LBL_AVATAR2:
                ruta_avatar = (Upload.pintar_guardar_imag(frmModiEF.lblAvatar, 80, 80,
                        SingletonEF.ef.getAvatar()));
                SingletonEF.ef.setAvatar(ruta_avatar);
                break;
            case _LBL_AVATAR1:
                ruta_avatar = (Upload.pintar_guardar_imag(frmAltaEF.lblAvatar, 80, 80,
                        avatar_temp));
                avatar_temp = ruta_avatar;
                break;                
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            // Finestra FrmPagerEF 
            case _BTN_XML:
                frmPagerEF.btnXML.setText("<html><b><font color=green >XML</font><b></html>");
                break;
            case _BTN_JSON:
                frmPagerEF.btnJSON.setText("<html><b><font color=green >JSON</font><b></html>");
                break;
            case _BTN_TXT:
                frmPagerEF.btnTXT.setText("<html><b><font color=green >TXT</font><b></html>");
                break;
            case _BTN_AFEGIR:
                frmPagerEF.btnAfegir.setIcon(afegir1);
                break;
            case _BTN_MODIFICAR:
                frmPagerEF.btnModificar.setIcon(editar1);
                break;
            case _BTN_ELIMINAR:
                frmPagerEF.btnEliminar.setIcon(eliminar1);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            // Finestra FrmPagerEF
            case _BTN_XML:
                frmPagerEF.btnXML.setText("<html><b><font color=black>XML</font><b></html>");
                break;
            case _BTN_JSON:
                frmPagerEF.btnJSON.setText("<html><b><font color=black>JSON</font><b></html>");
                break;
            case _BTN_TXT:
                frmPagerEF.btnTXT.setText("<html><font color=black>TXT</font></html>");
                break;
            case _BTN_AFEGIR:
                frmPagerEF.btnAfegir.setIcon(afegir2);
                break;
            case _BTN_MODIFICAR:
                frmPagerEF.btnModificar.setIcon(editar2);
                break;
            case _BTN_ELIMINAR:
                frmPagerEF.btnEliminar.setIcon(eliminar2);
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent kt) {
        switch (Accion.valueOf(kt.getComponent().getName())) {
            case _TXT_NOM1:
                EFBLL.validarNomAEFBLL();
                break;
            case _TXT_NOM2:
                EFBLL.validarNomMEFBLL();
                break;
            case _TXT_EMAIL1:
                EFBLL.validarEmailABLL();
                break;
            case _TXT_EMAIL2:
                EFBLL.validarEmailMBLL();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent kp) {
        switch (Accion.valueOf(kp.getComponent().getName())) {
            case _TXT_DNI1:
                EFBLL.validarDniBLL();
                break;
            case _TXT_NOM1:
                EFBLL.validarNomAEFBLL();
                break;
            case _TXT_NOM2:
                EFBLL.validarNomMEFBLL();
                break;
            case _TXT_EMAIL1:
                EFBLL.validarEmailABLL();
                break;
            case _TXT_EMAIL2:
                EFBLL.validarEmailMBLL();
                break;
            case _TXT_SALARIBASE1:
                EFBLL.validarSalariABLL();
                break;
            case _TXT_SALARIBASE2:
                EFBLL.validarSalariMBLL();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //mostrar rdos de filtrar empezando por botón primero, enlace 1
        switch (Accion.valueOf(ke.getComponent().getName())) {
            case _TXT_FILTRE:
                try {
                    Pagina.currentPageIndex = 1;
                    ((SimpleTableModelEF) frmPagerEF.taula.getModel()).filtrar();
                    if (frmPagerEF.taula.getRowCount() > 0) {
                        frmPagerEF.taula.addRowSelectionInterval(0, 0);
                    }
                } catch (Exception e) {
                }
                break;
            case _TXT_DNI1:
                EFBLL.validarDniBLL();
                break;
            case _TXT_NOM1:
                EFBLL.validarNomAEFBLL();
                break;
            case _TXT_NOM2:
                EFBLL.validarNomMEFBLL();
                break;
            case _TXT_EMAIL1:
                EFBLL.validarEmailABLL();
                break;
            case _TXT_EMAIL2:
                EFBLL.validarEmailMBLL();
                break;
            case _TXT_SALARIBASE1:
                EFBLL.validarSalariABLL();
                break;
            case _TXT_SALARIBASE2:
                EFBLL.validarSalariMBLL();
                break;
        }
    }

    @Override
    public void focusGained(FocusEvent evt) {
        switch (Accion.valueOf(evt.getComponent().getName())) {
            case _TXT_DNI1:
                frmAltaEF.txtDni.setForeground(verd);
                break;
            case _TXT_NOM1:
                frmAltaEF.txtNom.setForeground(verd);
                break;
            case _TXT_NOM2:
                frmModiEF.txtNom.setForeground(verd);
                break;
            case _TXT_EMAIL1:
                frmAltaEF.txtEmail.setForeground(verd);
                break;
            case _TXT_EMAIL2:
                frmModiEF.txtEmail.setForeground(verd);
                break;
            case _TXT_SALARIBASE1:
                frmAltaEF.txtSalariBase.setForeground(verd);
                break;
            case _TXT_SALARIBASE2:
                frmModiEF.txtSalariBase.setForeground(verd);
                break;
        }
    }

    @Override
    public void focusLost(FocusEvent evt) {
        switch (Accion.valueOf(evt.getComponent().getName())) {
            case _TXT_DNI1:
                frmAltaEF.txtDni.setForeground(Color.BLACK);
                EFBLL.validarDniBLL();
                break;
            case _TXT_NOM1:
                frmAltaEF.txtNom.setForeground(Color.BLACK);
                break;
            case _TXT_NOM2:
                frmModiEF.txtNom.setForeground(Color.BLACK);
                break;
            case _TXT_EMAIL1:
                frmAltaEF.txtEmail.setForeground(Color.BLACK);
                break;
            case _TXT_EMAIL2:
                frmModiEF.txtEmail.setForeground(Color.BLACK);
                break;
            case _TXT_SALARIBASE1:
                frmAltaEF.txtSalariBase.setForeground(Color.BLACK);
                break;
            case _TXT_SALARIBASE2:
                frmModiEF.txtSalariBase.setForeground(Color.BLACK);
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

}
