/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioEmpleats.gestioEF.controlador;

import classes.Data;
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
import javax.swing.JViewport;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import main.Core;
import moduls.gestioEmpleats.gestioEF.model.bll.EFBLL;
import static moduls.gestioEmpleats.gestioEF.model.bll.EFBLL.empleatMesAnticBLL;
import moduls.gestioEmpleats.gestioEF.model.classes.EmpleatFix;
import moduls.gestioEmpleats.gestioEF.model.classes.SimpleTableModelEF;
import moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF;
import static moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF.efix;
import moduls.gestioEmpleats.gestioEF.pager.Pagina;
import static moduls.gestioEmpleats.gestioEF.pager.Pagina.itemsPerPage;
import moduls.gestioEmpleats.gestioEF.vista.FrmAltaEF;
import moduls.gestioEmpleats.gestioEF.vista.FrmInterfaceEF;
import moduls.gestioEmpleats.gestioEF.vista.FrmModiEF;
import static moduls.gestioInici.model.classes.SingletonInici.afegir1;
import static moduls.gestioInici.model.classes.SingletonInici.afegir2;
import static moduls.gestioInici.model.classes.SingletonInici.buit;
import static moduls.gestioInici.model.classes.SingletonInici.editar1;
import static moduls.gestioInici.model.classes.SingletonInici.editar2;
import static moduls.gestioInici.model.classes.SingletonInici.eliminar1;
import static moduls.gestioInici.model.classes.SingletonInici.eliminar2;
import static moduls.gestioInici.model.classes.SingletonInici.imageicono;
import static moduls.gestioInici.model.classes.SingletonInici.verd;
import static moduls.gestioMenu.controlador.ControladorFrmMenu.frmMenu;
import moduls.gestioUsuaris.model.classes.SingletonUsuari;
import utils.Format;

/**
 *
 * @author Vicent
 */
public class ControladorEF implements ActionListener, KeyListener, MouseListener, FocusListener {

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<>(new SimpleTableModelEF());
    public static FrmInterfaceEF frmIntEF = new FrmInterfaceEF();
    public static FrmAltaEF frmAltaEF = new FrmAltaEF();
    public static FrmModiEF frmModiEF = new FrmModiEF();

    public ControladorEF(JDialog frm, int i) {

        switch (i) {
            case 0:
                frmIntEF = (FrmInterfaceEF) frm;
                break;
            case 1:
                frmAltaEF = (FrmAltaEF) frm;
                break;
            case 2:
                frmModiEF = (FrmModiEF) frm;
                break;
        }
    }

    private void noEditables() {

        frmModiEF.txtNom.setEditable(false);
        frmModiEF.txtEmail.setEditable(false);
        frmModiEF.txtSalariBase.setEditable(false);
        frmModiEF.btnGuardar.setVisible(false);
        frmModiEF.btnCancelar.setVisible(false);
        frmModiEF.DateDataNaixement.setEnabled(false);
        frmModiEF.DateDatacontratacio.setEnabled(false);
        frmModiEF.txtSalariBase.setEditable(false);
        frmModiEF.lblAvatar.setEnabled(false);
    }

    public enum Accion {

        // Finestra FrmInterfaceEF
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

            case 0: // Finestra FrmInterfaceEF

                frmIntEF.setTitle("Empleat Fix");
                frmIntEF.setVisible(true);
                frmIntEF.setResizable(false);
                frmIntEF.setLocationRelativeTo(null);

                frmIntEF.taula.setModel(new SimpleTableModelEF());
                ((SimpleTableModelEF) frmIntEF.taula.getModel()).cargar();
                frmIntEF.taula.setFillsViewportHeight(true);
                frmIntEF.taula.addRowSelectionInterval(0, 0); // seleccionem la primera fila 

                setAmpleColumnes(); // personalitzem l'ample de les columnes

                Pagina.inicializa();
                Pagina.initLinkBox();

                // icono de la finestra
                frmIntEF.setIconImage(imageicono);

                frmIntEF.cmbEntradesMostrades.setSelectedItem("" + itemsPerPage);

                // acció de tancar la finestra
                frmIntEF.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        frmMenu.setEnabled(true);
                        frmIntEF.dispose();
                    }
                });

                String var = empleatMesAnticBLL();
                if (var != null) {
                    var = "Empleat amb més temps a l'empresa: " + var;
                    frmIntEF.lblMesAntic.setText(var);
                }

                frmIntEF.lblContador.setText(String.valueOf(efix.size()));
                //FrmInterfaceEF.lblContador.setText("" + FrmInterfaceEF.taula.getRowCount()); // indiquem les files en tot moment 

                frmIntEF.taula.setFillsViewportHeight(true);
                frmIntEF.taula.setRowSorter(sorter);

                frmIntEF.taula.addRowSelectionInterval(0, 0); // seleccionem la primera fila 

                if ("user".equals(SingletonUsuari.us2.getTipus())) {
                    frmIntEF.btnAfegir.setVisible(false);
                    frmIntEF.btnEliminar.setVisible(false);
                    frmIntEF.btnModificar.setVisible(true);
                    frmIntEF.btnJSON.setVisible(false);
                    frmIntEF.btnTXT.setVisible(false);
                    frmIntEF.btnXML.setVisible(false);
                }

                // combo mostrar nombre d'entrades per pàgina
                frmIntEF.cmbEntradesMostrades.setActionCommand("_CMB_ENTRADESMOSTRADES");
                frmIntEF.cmbEntradesMostrades.setName("_CMB_ENTRADESMOSTRADES");
                frmIntEF.cmbEntradesMostrades.addActionListener(this);
                // botó primer registre
                frmIntEF.btnPrimer.setActionCommand("_BTN_PRIMER");
                frmIntEF.btnPrimer.setName("_BTN_PRIMER");
                frmIntEF.btnPrimer.addActionListener(this);
                // botó darrer registre
                frmIntEF.btnUltim.setActionCommand("_BTN_ULTIM");
                frmIntEF.btnUltim.setName("_BTN_ULTIM");
                frmIntEF.btnUltim.addActionListener(this);
                // botó següent registre
                frmIntEF.btnSeguent.setActionCommand("_BTN_SEGUENT");
                frmIntEF.btnSeguent.setName("_BTN_SEGUENT");
                frmIntEF.btnSeguent.addActionListener(this);
                // botó anterior registre
                frmIntEF.btnAnterior.setActionCommand("_BTN_ANTERIOR");
                frmIntEF.btnAnterior.setName("_BTN_ANTERIOR");
                frmIntEF.btnAnterior.addActionListener(this);
                // botó tancar finestra
                frmIntEF.btnTancar.setActionCommand("_BTN_TANCAR");
                frmIntEF.btnTancar.setName("_BTN_TANCAR");
                frmIntEF.btnTancar.addActionListener(this);

                // botó afegir registre
                frmIntEF.btnAfegir.setActionCommand("_BTN_AFEGIR");
                frmIntEF.btnAfegir.setName("_BTN_AFEGIR");
                frmIntEF.btnAfegir.addMouseListener(this);
                // botó modificar registre
                frmIntEF.btnModificar.setActionCommand("_BTN_MODIFICAR");
                frmIntEF.btnModificar.setName("_BTN_MODIFICAR");
                frmIntEF.btnModificar.addMouseListener(this);
                // botó eliminar registre
                frmIntEF.btnEliminar.setActionCommand("_BTN_ELIMINAR");
                frmIntEF.btnEliminar.setName("_BTN_ELIMINAR");
                frmIntEF.btnEliminar.addMouseListener(this);
                // botó guardar TXT
                frmIntEF.btnTXT.setActionCommand("_BTN_TXT");
                frmIntEF.btnTXT.setName("_BTN_TXT");
                frmIntEF.btnTXT.addMouseListener(this);
                // botó guardar JSON
                frmIntEF.btnJSON.setActionCommand("_BTN_JSON");
                frmIntEF.btnJSON.setName("_BTN_JSON");
                frmIntEF.btnJSON.addMouseListener(this);
                // botó guardar XML
                frmIntEF.btnXML.setActionCommand("_BTN_XML");
                frmIntEF.btnXML.setName("_BTN_XML");
                frmIntEF.btnXML.addMouseListener(this);
                // Filtre
                frmIntEF.txtFiltre.setActionCommand("_TXT_FILTRE");
                frmIntEF.txtFiltre.setName("_TXT_FILTRE");
                frmIntEF.txtFiltre.addKeyListener(this);

                frmIntEF.taula.setName("_TAULA");
                frmIntEF.taula.addMouseListener(this);
                break;

            case 1: // Finestra FrmAltaEF

                frmAltaEF.setTitle("Empleat Fix: AFEGIR");
                frmAltaEF.setVisible(true);
                frmAltaEF.setResizable(false);
                frmAltaEF.setLocationRelativeTo(null);

                // icono de la finestra
                frmAltaEF.setIconImage(imageicono);

                // acció de tancar la finestra
                frmAltaEF.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        frmIntEF.setEnabled(true);
                        frmAltaEF.dispose();
                    }
                });

                frmAltaEF.btnCancelar.setActionCommand("_BTN_CANCELAR1");
                frmAltaEF.btnCancelar.setName("_BTN_CANCELAR1");
                frmAltaEF.btnCancelar.addActionListener(this);

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
                break;

            case 2: // Finestra FrmModiEF

                frmModiEF.setTitle("Empleat Fix: MODIFICAR");
                frmModiEF.setVisible(true);
                // frmModiEF.txtAvatar.setVisible(false);
                frmModiEF.setResizable(false);
                frmModiEF.setLocationRelativeTo(null);

                // icono de la finestra
                frmModiEF.setIconImage(imageicono);

                // acció de tancar la finestra
                frmModiEF.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        frmIntEF.setEnabled(true);
                        frmModiEF.dispose();
                    }
                });

                EFBLL.cercarEmpleatFix();
                this.omplirCampsM();

                frmModiEF.txtDni.setEditable(false);

                if ("user".equals(SingletonUsuari.us2.getTipus())) {
                    noEditables();
                }
                frmModiEF.lblAvatar.setName("_LBL_AVATAR2");
                frmModiEF.lblAvatar.addMouseListener(this);

                frmModiEF.btnCancelar.setActionCommand("_BTN_CANCELAR2");
                frmModiEF.btnCancelar.setName("_BTN_CANCELAR2");
                frmModiEF.btnCancelar.addActionListener(this);

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
            // Finestra FrmInterfaceEF
            case _BTN_ANTERIOR:
                Pagina.currentPageIndex -= 1;
                Pagina.initLinkBox();
                frmIntEF.taula.addRowSelectionInterval(0, 0);
                break;
            case _BTN_SEGUENT:
                Pagina.currentPageIndex += 1;
                Pagina.initLinkBox();
                frmIntEF.taula.addRowSelectionInterval(0, 0);
                break;
            case _BTN_ULTIM:
                Pagina.currentPageIndex = Pagina.maxPageIndex;
                Pagina.initLinkBox();
                frmIntEF.taula.addRowSelectionInterval(0, 0);
                break;
            case _BTN_PRIMER:
                Pagina.currentPageIndex = 1;
                Pagina.initLinkBox();
                frmIntEF.taula.addRowSelectionInterval(0, 0);
                break;
            case _CMB_ENTRADESMOSTRADES:
                Pagina.itemsPerPage = Integer.parseInt(frmIntEF.cmbEntradesMostrades.getSelectedItem().toString());
                Pagina.currentPageIndex = 1;
                Pagina.initLinkBox();
                break;
            case _BTN_TANCAR:
                frmMenu.setEnabled(true);
                frmIntEF.dispose();
                break;
            case _BTN_TANCAR1:
                frmIntEF.setEnabled(true);
                frmAltaEF.dispose();
                break;
            case _BTN_TANCAR2:
                frmIntEF.setEnabled(true);
                frmModiEF.dispose();
                break;
            case _LBL_AVATAR2:
                break;

            case _BTN_CANCELAR1:
                this.cancelarEFA();
                break;
            case _BTN_CANCELAR2:
                EFBLL.cercarEmpleatFix();
                this.omplirCampsM();
                break;
            case _BTN_GUARDAR1:
                EFBLL.guardarAEFBLL();
                if (EFBLL.guardarA()) {
                    ((SimpleTableModelEF) frmIntEF.taula.getModel()).cargar();
                    frmIntEF.taula.setFillsViewportHeight(true);
                    frmIntEF.taula.setRowSorter(sorter);
                    frmIntEF.taula.addRowSelectionInterval(0, 0); // seleccionem la primera fila 
                    Pagina.inicializa();
                    Pagina.initLinkBox();
                    frmIntEF.lblContador.setText(String.valueOf(efix.size()));
                    frmIntEF.txtFiltre.setText(null);
                    frmIntEF.setEnabled(true);

                    String var = empleatMesAnticBLL();
                    if (var != null) {
                        var = "Empleat amb més temps a l'empresa: " + var;
                        frmIntEF.lblMesAntic.setText(var);
                    }

                    frmAltaEF.dispose();
                }
                break;
            case _BTN_GUARDAR2:
                EFBLL.guardarMEFBLL();
                if (SingletonEF.ef != null) {
                    if (EFBLL.guardarM()) {
                        ((SimpleTableModelEF) frmIntEF.taula.getModel()).cargar();
                        frmIntEF.taula.setFillsViewportHeight(true);
                        frmIntEF.taula.setRowSorter(sorter);
                        frmIntEF.taula.addRowSelectionInterval(0, 0); // seleccionem la primera fila 
                        frmIntEF.lblContador.setText(String.valueOf(efix.size()));
                        Pagina.inicializa();
                        Pagina.initLinkBox();
                        frmIntEF.txtFiltre.setText(null);
                        frmIntEF.setEnabled(true);

                        String var = empleatMesAnticBLL();
                        if (var != null) {
                            var = "Empleat amb més temps a l'empresa: " + var;
                            frmIntEF.lblMesAntic.setText(var);
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
        switch (Accion.valueOf(me.getComponent().getName())) {

            // Finestra FrmInterfaceEF
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
                selec = posicioAbsoluta();
                if (selec == -1) {
                } else {
                    frmIntEF.setEnabled(false);
                    new ControladorEF(new FrmAltaEF(), 1).iniciar(1);
                }
                break;
            case _BTN_MODIFICAR:
                selec = posicioAbsoluta();
                if (selec == -1) {
                } else {
                    String dni = (String) frmIntEF.taula.getModel().getValueAt(selec, 0);
                    SingletonEF.ef2 = new EmpleatFix(dni);
                    frmIntEF.setEnabled(false);
                    new ControladorEF(new FrmModiEF(), 2).iniciar(2);
                }
                break;
            case _BTN_ELIMINAR:

                selec = posicioAbsoluta();
                if (selec == -1) {
                    // Menus.warning("Selecciona primer", "Atenció!");
                } else {
                    String dni = (String) frmIntEF.taula.getModel().getValueAt(selec, 0);
                    SingletonEF.ef = new EmpleatFix(dni);
                    if (EFBLL.eliminarEF()) {
                        ((SimpleTableModelEF) frmIntEF.taula.getModel()).cargar();
                        frmIntEF.taula.setFillsViewportHeight(true);
                        frmIntEF.taula.setRowSorter(sorter);
                        frmIntEF.taula.addRowSelectionInterval(0, 0); // seleccionem la primera fila 
                        frmIntEF.lblContador.setText(String.valueOf(efix.size()));
                        Pagina.inicializa();
                        Pagina.initLinkBox();
                        frmIntEF.txtFiltre.setText(null);
                    }
                }

                break;
            case _TAULA:

                frmIntEF.taula = (JTable) me.getSource();
                Point point = me.getPoint();
                int row = frmIntEF.taula.rowAtPoint(point);
                if (me.getClickCount() == 2) {
                    int sel = posicioAbsoluta();
                    String dni = (String) frmIntEF.taula.getModel().getValueAt(sel, 0);
                    SingletonEF.ef = new EmpleatFix(dni);
                    frmIntEF.setEnabled(false);
                    new ControladorEF(new FrmModiEF(), 2).iniciar(2);
                }

                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            // Finestra FrmInterfaceEF 
            case _BTN_XML:
                frmIntEF.btnXML.setText("<html><b><font color=green >XML</font><b></html>");
                break;
            case _BTN_JSON:
                frmIntEF.btnJSON.setText("<html><b><font color=green >JSON</font><b></html>");
                break;
            case _BTN_TXT:
                frmIntEF.btnTXT.setText("<html><b><font color=green >TXT</font><b></html>");
                break;
            case _BTN_AFEGIR:
                frmIntEF.btnAfegir.setIcon(afegir1);
                break;
            case _BTN_MODIFICAR:
                frmIntEF.btnModificar.setIcon(editar1);
                break;
            case _BTN_ELIMINAR:
                frmIntEF.btnEliminar.setIcon(eliminar1);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            // Finestra FrmInterfaceEF
            case _BTN_XML:
                frmIntEF.btnXML.setText("<html><b><font color=black>XML</font><b></html>");
                break;
            case _BTN_JSON:
                frmIntEF.btnJSON.setText("<html><b><font color=black>JSON</font><b></html>");
                break;
            case _BTN_TXT:
                frmIntEF.btnTXT.setText("<html><font color=black>TXT</font></html>");
                break;
            case _BTN_AFEGIR:
                frmIntEF.btnAfegir.setIcon(afegir2);
                break;
            case _BTN_MODIFICAR:
                frmIntEF.btnModificar.setIcon(editar2);
                break;
            case _BTN_ELIMINAR:
                frmIntEF.btnEliminar.setIcon(eliminar2);
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
                    ((SimpleTableModelEF) frmIntEF.taula.getModel()).filtrar();
                    if (frmIntEF.taula.getRowCount() > 0) {
                        frmIntEF.taula.addRowSelectionInterval(0, 0);
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

    private int posicioAbsoluta() {
        int n, selection, inicio, selection1 = 0;
        n = ((SimpleTableModelEF) frmIntEF.taula.getModel()).getRowCount();
        if (n != 0) {
            inicio = (Pagina.currentPageIndex - 1) * Pagina.itemsPerPage;
            selection = frmIntEF.taula.getSelectedRow();
            selection1 = inicio + selection;
        } else {
            selection1 = -1;
        }
        return selection1;
    }

    /**
     * personalitzem l'ample de les columnes
     */
    private void setAmpleColumnes() {
        JViewport scroll = (JViewport) frmIntEF.taula.getParent();
        int ample = scroll.getWidth();
        int ampleColumna = 0;
        TableColumnModel modelColumna = frmIntEF.taula.getColumnModel();
        TableColumn columnaTaula;
        for (int i = 0; i < frmIntEF.taula.getColumnCount(); i++) {
            columnaTaula = modelColumna.getColumn(i);
            switch (i) {
                case 0:
                    ampleColumna = (17 * ample) / 100;
                    break;
                case 1:
                    ampleColumna = (30 * ample) / 100;
                    break;
                case 2:
                    ampleColumna = (18 * ample) / 100;
                    break;
                case 3:
                    ampleColumna = (18 * ample) / 100;
                    break;
                case 4:
                    ampleColumna = (17 * ample) / 100;
                    break;
            }
            columnaTaula.setPreferredWidth(ampleColumna);
        }
    }

    /**
     * ompli els camps en frm modificar
     *
     * @param ef
     */
    private void omplirCampsM() {
        float soubase1 = SingletonEF.ef.getSoubase();
        float soubase2 = soubase1 * Core.conf.getFactorconv();
        float sou1 = SingletonEF.ef.getSou();
        float sou2 = sou1 * Core.conf.getFactorconv();

        frmModiEF.txtDni.setText(SingletonEF.ef.getDni());
        frmModiEF.txtNom.setText(SingletonEF.ef.getNom());
        frmModiEF.txtEmail.setText(SingletonEF.ef.getEmail());
        frmModiEF.DateDataNaixement.setDate(Data.datatodate(SingletonEF.ef.getDatanaixement()));

        frmModiEF.DateDatacontratacio.setDate(Data.datatodate(SingletonEF.ef.getDatacontratacio()));
        frmModiEF.txtSalariBase.setText("" + soubase2);
        frmModiEF.lblEdat.setText("" + SingletonEF.ef.getEdat());
        frmModiEF.lblAntiguitat1.setText("" + SingletonEF.ef.getAntiguitat());
        frmModiEF.lblAntiguitat2.setText("" + SingletonEF.ef.getPercent());
        frmModiEF.lblSalari.setText(Format.formatConfig(sou2, Core.conf));
        frmModiEF.lblbDni.setIcon(buit);
        frmModiEF.lblbNom.setIcon(buit);
        frmModiEF.lblbDnaixement.setIcon(buit);
        frmModiEF.lblbDcontratacio.setIcon(buit);
        frmModiEF.lblbSalariBase.setIcon(buit);
        frmModiEF.lblbEmail.setIcon(buit);
    }

    public static void cancelarEFA() {
        frmAltaEF.txtNom.setText(null);
        frmAltaEF.txtDni.setText(null);
        frmAltaEF.DateDataNaixement.setCalendar(null);
        frmAltaEF.DateDatacontratacio.setCalendar(null);
        frmAltaEF.txtSalariBase.setText(null);
        frmAltaEF.lblEdat.setText(null);
        frmAltaEF.lblSalari.setText(null);
        frmAltaEF.lblbDni.setIcon(buit);
        frmAltaEF.lblbNom.setIcon(buit);
        frmAltaEF.lblbSalariBase.setIcon(buit);
        frmAltaEF.lblbDnaixement.setIcon(buit);
        frmAltaEF.lblbDcontratacio.setIcon(buit);
        frmAltaEF.lblAntiguitat1.setText(null);
        frmAltaEF.lblAntiguitat2.setText(null);
        frmAltaEF.txtDni.requestFocus();
    }

}
