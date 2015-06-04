/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioEvents.controlador;

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
import static moduls.gestioEvents.controlador.ControladorEvents.frmEvents;
import moduls.gestioEvents.model.bll.GEBLL;
import moduls.gestioEvents.model.classes.Event;
import moduls.gestioEvents.model.classes.SimpleTableModelEV;
import moduls.gestioEvents.model.classes.SingletonEvent;
import static moduls.gestioEvents.model.classes.SingletonEvent.evAL;
import moduls.gestioEvents.pager.Pagina;
import static moduls.gestioEvents.pager.Pagina.itemsPerPage;
import moduls.gestioEvents.vista.FrmEvents;
import moduls.gestioEvents.vista.FrmPagerEvent;
import moduls.gestioInici.model.classes.SingletonInici;
import static moduls.gestioInici.model.classes.SingletonInici.afegir1;
import static moduls.gestioInici.model.classes.SingletonInici.afegir2;
import static moduls.gestioInici.model.classes.SingletonInici.editar1;
import static moduls.gestioInici.model.classes.SingletonInici.editar2;
import static moduls.gestioInici.model.classes.SingletonInici.eliminar1;
import static moduls.gestioInici.model.classes.SingletonInici.eliminar2;
import static moduls.gestioInici.model.classes.SingletonInici.imageicono;
import static moduls.gestioMenu.controlador.ControladorFrmMenu.frmMenu;

/**
 *
 * @author Vicent
 */
public class ControladorEvents implements ActionListener, KeyListener, MouseListener, FocusListener {

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<>(new SimpleTableModelEV());
    public static FrmEvents frmEvents = new FrmEvents();
    public static FrmPagerEvent frmPagerEvent = new FrmPagerEvent();

    public ControladorEvents(JDialog frm, int i) {
        switch (i) {
            case 0:
                frmPagerEvent = (FrmPagerEvent) frm;
                break;
            case 1:
                frmEvents = (FrmEvents) frm;
                break;
        }
    }

    public enum Accion {

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
        //
        _ACCEPTAR,
        _ACCEPTAR2,
        _CANCELAR

    }

    public void iniciar(int i) {

        switch (i) {

            case 0:
                frmPagerEvent.setTitle("Events");
                frmPagerEvent.setIconImage(imageicono);
                frmPagerEvent.setVisible(true);
                frmPagerEvent.setResizable(false);
                frmPagerEvent.setLocationRelativeTo(null);

                frmPagerEvent.taula.setModel(new SimpleTableModelEV());
                ((SimpleTableModelEV) frmPagerEvent.taula.getModel()).cargar();
                frmPagerEvent.taula.setFillsViewportHeight(true);
                frmPagerEvent.taula.setRowSorter(sorter);

                GEBLL.setAmpleColumnesBLL(); // personalitzem l'ample de les columnes

                Pagina.inicializa();
                Pagina.initLinkBox();

                frmPagerEvent.cmbEntradesMostrades.setSelectedItem("" + itemsPerPage);
                frmPagerEvent.lblContador.setText(String.valueOf(evAL.size()));

                if (!evAL.isEmpty()) {
                    frmPagerEvent.taula.addRowSelectionInterval(0, 0); // seleccionem la primera fila  
                }

                frmPagerEvent.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        frmMenu.setEnabled(true);
                        frmPagerEvent.dispose();

                    }
                });

                // combo mostrar nombre d'entrades per pàgina
                frmPagerEvent.cmbEntradesMostrades.setActionCommand("_CMB_ENTRADESMOSTRADES");
                frmPagerEvent.cmbEntradesMostrades.setName("_CMB_ENTRADESMOSTRADES");
                frmPagerEvent.cmbEntradesMostrades.addActionListener(this);
                // botó primer registre
                frmPagerEvent.btnPrimer.setActionCommand("_BTN_PRIMER");
                frmPagerEvent.btnPrimer.setName("_BTN_PRIMER");
                frmPagerEvent.btnPrimer.addActionListener(this);
                // botó darrer registre
                frmPagerEvent.btnUltim.setActionCommand("_BTN_ULTIM");
                frmPagerEvent.btnUltim.setName("_BTN_ULTIM");
                frmPagerEvent.btnUltim.addActionListener(this);
                // botó següent registre
                frmPagerEvent.btnSeguent.setActionCommand("_BTN_SEGUENT");
                frmPagerEvent.btnSeguent.setName("_BTN_SEGUENT");
                frmPagerEvent.btnSeguent.addActionListener(this);
                // botó anterior registre
                frmPagerEvent.btnAnterior.setActionCommand("_BTN_ANTERIOR");
                frmPagerEvent.btnAnterior.setName("_BTN_ANTERIOR");
                frmPagerEvent.btnAnterior.addActionListener(this);
                // botó tancar finestra
                frmPagerEvent.btnTancar.setActionCommand("_BTN_TANCAR");
                frmPagerEvent.btnTancar.setName("_BTN_TANCAR");
                frmPagerEvent.btnTancar.addActionListener(this);

                // botó afegir registre
                frmPagerEvent.btnAfegir.setActionCommand("_BTN_AFEGIR");
                frmPagerEvent.btnAfegir.setName("_BTN_AFEGIR");
                frmPagerEvent.btnAfegir.addMouseListener(this);
                // botó modificar registre
                frmPagerEvent.btnModificar.setActionCommand("_BTN_MODIFICAR");
                frmPagerEvent.btnModificar.setName("_BTN_MODIFICAR");
                frmPagerEvent.btnModificar.addMouseListener(this);
                // botó eliminar registre
                frmPagerEvent.btnEliminar.setActionCommand("_BTN_ELIMINAR");
                frmPagerEvent.btnEliminar.setName("_BTN_ELIMINAR");
                frmPagerEvent.btnEliminar.addMouseListener(this);
                // botó guardar TXT
                frmPagerEvent.btnTXT.setActionCommand("_BTN_TXT");
                frmPagerEvent.btnTXT.setName("_BTN_TXT");
                frmPagerEvent.btnTXT.addMouseListener(this);
                // botó guardar JSON
                frmPagerEvent.btnJSON.setActionCommand("_BTN_JSON");
                frmPagerEvent.btnJSON.setName("_BTN_JSON");
                frmPagerEvent.btnJSON.addMouseListener(this);
                // botó guardar XML
                frmPagerEvent.btnXML.setActionCommand("_BTN_XML");
                frmPagerEvent.btnXML.setName("_BTN_XML");
                frmPagerEvent.btnXML.addMouseListener(this);
                // Filtre
                frmPagerEvent.txtFiltre.setActionCommand("_TXT_FILTRE");
                frmPagerEvent.txtFiltre.setName("_TXT_FILTRE");
                frmPagerEvent.txtFiltre.addKeyListener(this);

                frmPagerEvent.taula.setName("_TAULA");
                frmPagerEvent.taula.addMouseListener(this);

                break;

            case 1: // 
                frmEvents.setTitle("Alta Event");
                frmEvents.setIconImage(imageicono);
                frmEvents.setLocationRelativeTo(null);
                frmEvents.setVisible(true);

                Upload.pintar_imatge(frmEvents.lbl_logo, 80, 80, SingletonInici.logo);
                frmEvents.txtEvent.setEnabled(false);
                frmEvents.txtUsuari.setEnabled(false);

                GEBLL.nouEvent();
                GEBLL.omplirArrayComboBLL();

                frmEvents.btnAcceptar.setActionCommand("_ACCEPTAR");
                frmEvents.btnAcceptar.setName("_ACCEPTAR");
                frmEvents.btnAcceptar.addActionListener(this);
                frmEvents.btnAcceptar.addKeyListener(this);

                frmEvents.btnCancelar.setActionCommand("_CANCELAR");
                frmEvents.btnCancelar.setName("_CANCELAR");
                frmEvents.btnCancelar.addActionListener(this);
                frmEvents.btnCancelar.addKeyListener(this);

                frmEvents.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        new ControladorEvents(new FrmPagerEvent(), 0).iniciar(0);
                        frmEvents.dispose();

                    }
                });

                break;

            case 2: // 
                frmEvents.setTitle("Modificar Event");
                frmEvents.setIconImage(imageicono);
                frmEvents.setLocationRelativeTo(null);
                frmEvents.setVisible(true);

                Upload.pintar_imatge(frmEvents.lbl_logo, 80, 80, SingletonInici.logo);
                frmEvents.txtEvent.setEnabled(false);
                frmEvents.txtUsuari.setEnabled(false);

                GEBLL.cercarEvent();
                GEBLL.omplirArrayComboBLL();
                GEBLL.omplirCampsMBLL();

                frmEvents.btnAcceptar.setActionCommand("_ACCEPTAR2");
                frmEvents.btnAcceptar.setName("_ACCEPTAR2");
                frmEvents.btnAcceptar.addActionListener(this);
                frmEvents.btnAcceptar.addKeyListener(this);

                frmEvents.btnCancelar.setActionCommand("_CANCELAR");
                frmEvents.btnCancelar.setName("_CANCELAR");
                frmEvents.btnCancelar.addActionListener(this);
                frmEvents.btnCancelar.addKeyListener(this);

                frmEvents.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        new ControladorEvents(new FrmPagerEvent(), 0).iniciar(0);
                        frmEvents.dispose();

                    }
                });

                break;
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (Accion.valueOf(ae.getActionCommand())) {
            //
            case _BTN_ANTERIOR:
                Pagina.currentPageIndex -= 1;
                Pagina.initLinkBox();
                frmPagerEvent.taula.addRowSelectionInterval(0, 0);
                break;
            case _BTN_SEGUENT:
                Pagina.currentPageIndex += 1;
                Pagina.initLinkBox();
                frmPagerEvent.taula.addRowSelectionInterval(0, 0);
                break;
            case _BTN_ULTIM:
                Pagina.currentPageIndex = Pagina.maxPageIndex;
                Pagina.initLinkBox();
                frmPagerEvent.taula.addRowSelectionInterval(0, 0);
                break;
            case _BTN_PRIMER:
                Pagina.currentPageIndex = 1;
                Pagina.initLinkBox();
                frmPagerEvent.taula.addRowSelectionInterval(0, 0);
                break;
            case _CMB_ENTRADESMOSTRADES:
                Pagina.itemsPerPage = Integer.parseInt(frmPagerEvent.cmbEntradesMostrades.getSelectedItem().toString());
                Pagina.currentPageIndex = 1;
                Pagina.initLinkBox();
                break;
            case _BTN_TANCAR:
                frmMenu.setEnabled(true);
                frmPagerEvent.dispose();
                break;

            //
            case _ACCEPTAR:
                if (GEBLL.guardarEvent()) {
                    new ControladorEvents(new FrmPagerEvent(), 0).iniciar(0);
                    frmEvents.dispose();
                }
                break;
            case _ACCEPTAR2:
                if (GEBLL.modificarEvent()) {
                    new ControladorEvents(new FrmPagerEvent(), 0).iniciar(0);
                    frmEvents.dispose();
                }
                break;
            case _CANCELAR:
                new ControladorEvents(new FrmPagerEvent(), 0).iniciar(0);
                frmEvents.dispose();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent kr) {
        switch (Accion.valueOf(kr.getComponent().getName())) {
            case _TXT_FILTRE:
                try {
                    Pagina.currentPageIndex = 1;
                    ((SimpleTableModelEV) frmPagerEvent.taula.getModel()).filtrar();
                    if (frmPagerEvent.taula.getRowCount() > 0) {
                        frmPagerEvent.taula.addRowSelectionInterval(0, 0);
                    }
                } catch (Exception e) {
                }
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent mc) {
        int selec;
        switch (Accion.valueOf(mc.getComponent().getName())) {
            // frmPagerEvent                
            case _BTN_AFEGIR:
                if (SingletonEvent.evAL.isEmpty()) {
                    new ControladorEvents(new FrmEvents(), 1).iniciar(1);
                    frmPagerEvent.dispose();
                } else {
                    selec = GEBLL.posicioAbsolutaBLL();
                    if (selec == -1) {
                    } else {
                        new ControladorEvents(new FrmEvents(), 1).iniciar(1);
                        frmPagerEvent.dispose();
                    }
                }
                break;

            case _BTN_MODIFICAR:
                if (!SingletonEvent.evAL.isEmpty()) {
                    selec = GEBLL.posicioAbsolutaBLL();
                    if (selec == -1) {
                    } else {
                        String valor = (String) frmPagerEvent.taula.getModel().getValueAt(selec, 0);
                        int idevent = Integer.parseInt(valor);
                        SingletonEvent.ev = new Event(idevent);
                        new ControladorEvents(new FrmEvents(), 1).iniciar(2);
                        frmPagerEvent.dispose();
                    }
                }
                break;

            case _BTN_ELIMINAR:
                if (!SingletonEvent.evAL.isEmpty()) {
                    selec = GEBLL.posicioAbsolutaBLL();
                    if (selec == -1) {
                    } else {
                        String valor = (String) frmPagerEvent.taula.getModel().getValueAt(selec, 0);
                        int idevent = Integer.parseInt(valor);
                        SingletonEvent.ev = new Event(idevent);
                        if (GEBLL.eliminarEV()) {
                            frmPagerEvent.dispose();
                            new ControladorEvents(new FrmPagerEvent(), 0).iniciar(0);
                        }
                    }
                }
                break;
            case _TAULA:
                frmPagerEvent.taula = (JTable) mc.getSource();
                Point point = mc.getPoint();
                int row = frmPagerEvent.taula.rowAtPoint(point);
                if (mc.getClickCount() == 2) {
                    selec = GEBLL.posicioAbsolutaBLL();
                    String valor = (String) frmPagerEvent.taula.getModel().getValueAt(selec, 0);
                    int idevent = Integer.parseInt(valor);
                    SingletonEvent.ev = new Event(idevent);
                    new ControladorEvents(new FrmEvents(), 1).iniciar(2);
                    frmPagerEvent.dispose();
                }
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent mp
    ) {
        switch (Accion.valueOf(mp.getComponent().getName())) {
        }
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            // Finestra FrmPagerEvent 
            case _BTN_XML:
                frmPagerEvent.btnXML.setText("<html><b><font color=green >XML</font><b></html>");
                break;
            case _BTN_JSON:
                frmPagerEvent.btnJSON.setText("<html><b><font color=green >JSON</font><b></html>");
                break;
            case _BTN_TXT:
                frmPagerEvent.btnTXT.setText("<html><b><font color=green >TXT</font><b></html>");
                break;
            case _BTN_AFEGIR:
                frmPagerEvent.btnAfegir.setIcon(afegir1);
                break;
            case _BTN_MODIFICAR:
                frmPagerEvent.btnModificar.setIcon(editar1);
                break;
            case _BTN_ELIMINAR:
                frmPagerEvent.btnEliminar.setIcon(eliminar1);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            // Finestra FrmPagerEvent
            case _BTN_XML:
                frmPagerEvent.btnXML.setText("<html><b><font color=black>XML</font><b></html>");
                break;
            case _BTN_JSON:
                frmPagerEvent.btnJSON.setText("<html><b><font color=black>JSON</font><b></html>");
                break;
            case _BTN_TXT:
                frmPagerEvent.btnTXT.setText("<html><font color=black>TXT</font></html>");
                break;
            case _BTN_AFEGIR:
                frmPagerEvent.btnAfegir.setIcon(afegir2);
                break;
            case _BTN_MODIFICAR:
                frmPagerEvent.btnModificar.setIcon(editar2);
                break;
            case _BTN_ELIMINAR:
                frmPagerEvent.btnEliminar.setIcon(eliminar2);
                break;
        }
    }

    @Override
    public void focusGained(FocusEvent e
    ) {

    }

    @Override
    public void focusLost(FocusEvent e
    ) {

    }

}
