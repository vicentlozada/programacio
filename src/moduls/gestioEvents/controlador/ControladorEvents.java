/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioEvents.controlador;

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
import llibreries.Upload;
import moduls.gestioEvents.model.bll.GEBLL;
import moduls.gestioEvents.vista.FrmEvents;
import moduls.gestioInici.model.classes.SingletonInici;
import static moduls.gestioInici.model.classes.SingletonInici.imageicono;
import static moduls.gestioMenu.controlador.ControladorFrmMenu.frmMenu;

/**
 *
 * @author Vicent
 */
public class ControladorEvents implements ActionListener, KeyListener, MouseListener, FocusListener {

    public static FrmEvents frmEvents = new FrmEvents();

    public ControladorEvents(JDialog frm, int i) {
        switch (i) {
            case 0:
                frmEvents = (FrmEvents) frm;
                break;
        }
    }

    public enum Accion {

        _ACCEPTAR,
        _CANCELAR

    }

    public void iniciar(int i) {

        switch (i) {

            case 0: // 
                frmEvents.setTitle("Alta Event");
                frmEvents.setIconImage(imageicono);
                frmEvents.setLocationRelativeTo(null);
                frmEvents.setVisible(true);

                Upload.pintar_imatge(frmEvents.lbl_logo, 80, 80, SingletonInici.logo);
                frmEvents.txtEvent.setEnabled(false);
                frmEvents.txtUsuari.setEnabled(false);

                GEBLL.omplirEvent();
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
                        frmMenu.setEnabled(true);
                        frmEvents.dispose();

                    }
                });

                break;
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (Accion.valueOf(ae.getActionCommand())) {
            case _ACCEPTAR:
                if (GEBLL.guardarEvent()) {
                    frmMenu.setEnabled(true);
                    frmEvents.dispose();
                }
                break;
            case _CANCELAR:
                frmMenu.setEnabled(true);
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
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent mc) {
        switch (Accion.valueOf(mc.getComponent().getName())) {

//            case _CMBTIPUS:
            //              GEBLL.omplirArrayBLL();
            //            break;
        }
    }

    @Override
    public void mousePressed(MouseEvent mp) {
        switch (Accion.valueOf(mp.getComponent().getName())) {
            //      case _CMBTIPUS:
            //        GEBLL.omplirArrayBLL();
            //      break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            //case _CMBTIPUS:
            //  GEBLL.omplirArrayBLL();
            //break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

}
