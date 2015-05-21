/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.configuracio.controlador;

import classes.Configuracio;
import classes.Data;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.SpinnerNumberModel;
import main.Core;
import moduls.configuracio.vista.FrmConfig;
import static moduls.gestioInici.model.classes.SingletonInici.imageicono;
import static moduls.gestioMenu.controlador.ControladorFrmMenu.frmMenu;

/**
 *
 * @author Vicent
 */
public class ControladorFrmConfig implements ActionListener {
    
    private FrmConfig finestraConfig = new FrmConfig();
    private final Configuracio con = new Configuracio("");

    /**
     *
     * @param frm
     */
    public ControladorFrmConfig(JDialog frm) {
        
        this.finestraConfig = (FrmConfig) frm;
        
    }
    
    public enum Accion {
        
        btnGuardar,
        btnPerDefecte,
        btnTancar,
        mEmpleatHores,
        mEmpleatTemporal,
        mGuardarEF,
        mMetal,
        mNimbus,
        mWindows
        
    }
    
    public void iniciar() {
        
        finestraConfig.setTitle("Configuració");
        finestraConfig.setVisible(true);
        finestraConfig.setLocationRelativeTo(null);

        // acció de tancar la finestra
        finestraConfig.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frmMenu.setEnabled(true);
                finestraConfig.dispose();
            }
        });
        // icono de la finestra
        finestraConfig.setIconImage(imageicono);
        
        switch (Core.conf.getNumdecimal()) {
            case 1:
                finestraConfig.rb1decimal.setSelected(true);
                break;
            case 2:
                finestraConfig.rb2decimal.setSelected(true);
                break;
            case 3:
                finestraConfig.rb3decimal.setSelected(true);
                break;
        }
        boolean modal = true;
        
        finestraConfig.lstRegio.setSelectedValue(Core.conf.getRegio(), modal);
        finestraConfig.lstMoneda.setSelectedValue(Core.conf.getMoneda(), modal);
        finestraConfig.lstData.setSelectedValue(Data.formato(Core.conf.getFormatdata()), modal);
        finestraConfig.lstArxiu.setSelectedValue(Core.conf.getArxiu(), modal);
        
        float min = 0.0f;
        float max = 10.0f;
        float value = Core.conf.getFactorconv();
        float stepSize = 0.01f;
        SpinnerNumberModel nm = new SpinnerNumberModel(value, min, max, stepSize);
        finestraConfig.spiFConv.setModel(nm);
        
        finestraConfig.btnPerDefecte.setActionCommand("btnPerDefecte");
        finestraConfig.btnPerDefecte.setName("btnPerDefecte");
        finestraConfig.btnPerDefecte.addActionListener(this);
        
        finestraConfig.btnGuardar.setActionCommand("btnGuardar");
        finestraConfig.btnGuardar.setName("btnGuardar");
        finestraConfig.btnGuardar.addActionListener(this);
        
        finestraConfig.btnTancar.setActionCommand("btnTancar");
        finestraConfig.btnTancar.setName("btnTancar");
        finestraConfig.btnTancar.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (Accion.valueOf(ae.getActionCommand())) {
            case btnGuardar:
                try {
                    if (finestraConfig.rb1decimal.isSelected()) {
                        Core.conf.setNumdecimal(1);
                    }
                    if (finestraConfig.rb2decimal.isSelected()) {
                        Core.conf.setNumdecimal(2);
                    }
                    if (finestraConfig.rb3decimal.isSelected()) {
                        Core.conf.setNumdecimal(3);
                    }
                    Core.conf.setRegio(finestraConfig.lstRegio.getSelectedValue().toString());
                    Core.conf.setMoneda(finestraConfig.lstMoneda.getSelectedValue().toString());
                    Core.conf.setFactorconv(Float.parseFloat(finestraConfig.spiFConv.getValue().toString()));
                    Core.conf.setFormatdata(Data.formato2(finestraConfig.lstData.getSelectedValue().toString()));
                    Core.conf.setArxiu(finestraConfig.lstArxiu.getSelectedValue().toString());
                    
                    Configuracio.canviaRegio(finestraConfig.lstRegio.getSelectedValue().toString());
                } catch (Exception e) {
                    
                }
                frmMenu.setEnabled(true);
                finestraConfig.dispose();
                break;
            case btnPerDefecte:
                try {
                    Core.conf.setFactorconv(con.getFactorconv());
                    Core.conf.setFormatdata(con.getFormatdata());
                    Core.conf.setMoneda(con.getMoneda());
                    Core.conf.setNumdecimal(con.getNumdecimal());
                    Core.conf.setRegio(con.getRegio());
                    Core.conf.setArxiu(con.getArxiu());
                    
                    switch (Core.conf.getNumdecimal()) {
                        case 1:
                            finestraConfig.rb1decimal.setSelected(true);
                            break;
                        case 2:
                            finestraConfig.rb2decimal.setSelected(true);
                            break;
                        case 3:
                            finestraConfig.rb3decimal.setSelected(true);
                            break;
                    }
                    boolean rootPaneCheckingEnabled = true;
                    finestraConfig.lstRegio.setSelectedValue(Core.conf.getRegio(), rootPaneCheckingEnabled);
                    finestraConfig.lstMoneda.setSelectedValue(Core.conf.getMoneda(), rootPaneCheckingEnabled);
                    finestraConfig.lstData.setSelectedValue(Data.formato(Core.conf.getFormatdata()), rootPaneCheckingEnabled);
                    finestraConfig.spiFConv.setValue(Core.conf.getFactorconv());
                    finestraConfig.lstArxiu.setSelectedValue(Core.conf.getArxiu(), rootPaneCheckingEnabled);
                } catch (Exception e) {
                }
                break;
            case btnTancar:
                frmMenu.setEnabled(true);
                this.finestraConfig.dispose();
                break;
        }
        
    }
    
}
