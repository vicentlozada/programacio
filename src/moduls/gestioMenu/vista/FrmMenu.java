/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioMenu.vista;
import llibreries.JFrameConFondo;

/**
 *
 * @author Vicent
 */
public class FrmMenu extends JFrameConFondo {

    public FrmMenu() {
        initComponents();
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblUsuari = new javax.swing.JLabel();
        lblTipus = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        mMenuppal = new javax.swing.JMenuBar();
        mArxiu = new javax.swing.JMenu();
        mGuardarArxius = new javax.swing.JMenu();
        mGuardarEF = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mFiSessio = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mEixir = new javax.swing.JMenuItem();
        mEmpleats = new javax.swing.JMenu();
        mEmpleatFix = new javax.swing.JMenuItem();
        mEmpleatTemporal = new javax.swing.JMenuItem();
        mEmpleatHores = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mEvent = new javax.swing.JMenuItem();
        mConfiguracions = new javax.swing.JMenu();
        mConfigGeneral = new javax.swing.JMenuItem();
        mApariencia = new javax.swing.JMenu();
        mNimbus = new javax.swing.JMenuItem();
        mMetal = new javax.swing.JMenuItem();
        mWindows = new javax.swing.JMenuItem();
        mUsuari = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvatar.setToolTipText("Avatar");

        lblUsuari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblTipus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipus, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        mArxiu.setText("Arxiu");
        mArxiu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mArxiuActionPerformed(evt);
            }
        });

        mGuardarArxius.setText("Guardar arxius");

        mGuardarEF.setText("Empleat Fix");
        mGuardarEF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGuardarEFActionPerformed(evt);
            }
        });
        mGuardarArxius.add(mGuardarEF);

        mArxiu.add(mGuardarArxius);
        mArxiu.add(jSeparator3);

        mFiSessio.setText("Finalitzar sessió");
        mArxiu.add(mFiSessio);
        mArxiu.add(jSeparator1);

        mEixir.setText("Eixir");
        mEixir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEixirActionPerformed(evt);
            }
        });
        mArxiu.add(mEixir);

        mMenuppal.add(mArxiu);

        mEmpleats.setText("Gestió d'Empleats");

        mEmpleatFix.setText("Empleat Fix");
        mEmpleatFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEmpleatFixActionPerformed(evt);
            }
        });
        mEmpleats.add(mEmpleatFix);

        mEmpleatTemporal.setText("Empleat Temporal");
        mEmpleats.add(mEmpleatTemporal);

        mEmpleatHores.setText("Empleat Hores");
        mEmpleats.add(mEmpleatHores);

        mMenuppal.add(mEmpleats);

        jMenu2.setText("Gestió d'Events");

        mEvent.setText("Events");
        mEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEventActionPerformed(evt);
            }
        });
        jMenu2.add(mEvent);

        mMenuppal.add(jMenu2);

        mConfiguracions.setText("Configuracions");
        mConfiguracions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConfiguracionsActionPerformed(evt);
            }
        });

        mConfigGeneral.setText("Generals");
        mConfigGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConfigGeneralActionPerformed(evt);
            }
        });
        mConfiguracions.add(mConfigGeneral);

        mApariencia.setText("Apariència");

        mNimbus.setText("Nimbus");
        mNimbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNimbusActionPerformed(evt);
            }
        });
        mApariencia.add(mNimbus);

        mMetal.setText("Metal");
        mMetal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mMetalActionPerformed(evt);
            }
        });
        mApariencia.add(mMetal);

        mWindows.setText("Windows");
        mWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mWindowsActionPerformed(evt);
            }
        });
        mApariencia.add(mWindows);

        mConfiguracions.add(mApariencia);

        mUsuari.setText("Gestió d'Usuaris");
        mConfiguracions.add(mUsuari);

        mMenuppal.add(mConfiguracions);

        setJMenuBar(mMenuppal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mArxiuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mArxiuActionPerformed
    }//GEN-LAST:event_mArxiuActionPerformed

    private void mEixirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEixirActionPerformed
      
    }//GEN-LAST:event_mEixirActionPerformed

    private void mConfiguracionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConfiguracionsActionPerformed
    }//GEN-LAST:event_mConfiguracionsActionPerformed

    private void mConfigGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConfigGeneralActionPerformed

    }//GEN-LAST:event_mConfigGeneralActionPerformed

    private void mNimbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNimbusActionPerformed

    }//GEN-LAST:event_mNimbusActionPerformed

    private void mMetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mMetalActionPerformed
       
    }//GEN-LAST:event_mMetalActionPerformed

    private void mWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mWindowsActionPerformed

    }//GEN-LAST:event_mWindowsActionPerformed

    private void mEmpleatFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEmpleatFixActionPerformed

    }//GEN-LAST:event_mEmpleatFixActionPerformed

    private void mGuardarEFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGuardarEFActionPerformed

    }//GEN-LAST:event_mGuardarEFActionPerformed

    private void mEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEventActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mEventActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    public javax.swing.JLabel lblAvatar;
    public javax.swing.JLabel lblLogo;
    public javax.swing.JLabel lblTipus;
    public javax.swing.JLabel lblUsuari;
    private javax.swing.JMenu mApariencia;
    private javax.swing.JMenu mArxiu;
    public javax.swing.JMenuItem mConfigGeneral;
    private javax.swing.JMenu mConfiguracions;
    public javax.swing.JMenuItem mEixir;
    public javax.swing.JMenuItem mEmpleatFix;
    private javax.swing.JMenuItem mEmpleatHores;
    private javax.swing.JMenuItem mEmpleatTemporal;
    public javax.swing.JMenu mEmpleats;
    public javax.swing.JMenuItem mEvent;
    public javax.swing.JMenuItem mFiSessio;
    private javax.swing.JMenu mGuardarArxius;
    public javax.swing.JMenuItem mGuardarEF;
    private javax.swing.JMenuBar mMenuppal;
    public javax.swing.JMenuItem mMetal;
    public javax.swing.JMenuItem mNimbus;
    public javax.swing.JMenuItem mUsuari;
    public javax.swing.JMenuItem mWindows;
    // End of variables declaration//GEN-END:variables
}
