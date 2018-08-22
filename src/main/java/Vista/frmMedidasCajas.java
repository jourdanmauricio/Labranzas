package Vista;

import Modelo.CajasDAO;
import Modelo.SingletonProperties;
import Tabla.TablaMedidasCajas;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class frmMedidasCajas extends javax.swing.JInternalFrame {

    JTextField clipboard;
    TablaMedidasCajas tcaj = new TablaMedidasCajas();
    CajasDAO caja = new CajasDAO();

    public frmMedidasCajas() {
        initComponents();
        SingletonProperties sp=SingletonProperties.getInstancia();
        String path_icon= sp.getPropiedad("path_img_iconos");

        btnNuevo.setIcon(new ImageIcon(path_icon+"nuevo_peque.png"));
        btnModificar.setIcon(new ImageIcon(path_icon+"editar_peque.png"));
        btnEliminar.setIcon(new ImageIcon(path_icon+"eliminar_peque.png"));
        btnRegistrar.setIcon(new ImageIcon(path_icon+"guardar_peque.png"));
        btnLimpiar.setIcon(new ImageIcon(path_icon+"limpiar_peque.png"));
        btnImprimir.setIcon(new ImageIcon(path_icon+"imprimir_peque.png"));        

        tcaj.visualizarCaja(jtMedidasCajas);  
        jTabbedPane1.setEnabledAt(1, false);
    }

    public void LimpiarElementos () {
        txtId.setText("");
        txtObjeto.setText("");
        txtCantidad.setText("");
        txtDescObjeto.setText("");
        txtLargo.setText("");
        txtAncho.setText("");
        txtLargoE.setText("");
        txtAnchoE.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtMedidasCajas = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtLargo = new javax.swing.JTextField();
        txtAncho = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLargoE = new javax.swing.JTextField();
        txtAnchoE = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtObjeto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtDescObjeto = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Medidas cajas");
        getContentPane().setLayout(null);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jtMedidasCajas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtMedidasCajas);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImprimirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1079, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Medidas cajas", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Caja"));
        jPanel3.setLayout(null);

        jLabel1.setText("Id:");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(18, 39, 60, 17);

        jLabel2.setText("Objeto:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(20, 100, 90, 17);

        jLabel3.setText("Cantidad:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 150, 80, 17);

        jLabel4.setText("Desc Objeto: ");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 200, 110, 17);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Sin envío"));
        jPanel4.setLayout(null);
        jPanel4.add(txtLargo);
        txtLargo.setBounds(80, 30, 200, 27);
        jPanel4.add(txtAncho);
        txtAncho.setBounds(80, 70, 200, 27);

        jLabel9.setText("Largo:");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(20, 30, 80, 17);

        jLabel10.setText("Ancho:");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(20, 70, 48, 17);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(20, 250, 320, 130);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Con envío"));
        jPanel5.setLayout(null);

        jLabel5.setText("Largo:");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(20, 40, 60, 17);

        jLabel6.setText("Ancho: ");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(20, 80, 60, 17);
        jPanel5.add(txtLargoE);
        txtLargoE.setBounds(80, 30, 190, 27);
        jPanel5.add(txtAnchoE);
        txtAnchoE.setBounds(80, 70, 190, 27);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(360, 250, 300, 130);

        txtId.setEditable(false);
        jPanel3.add(txtId);
        txtId.setBounds(120, 40, 210, 27);
        jPanel3.add(txtObjeto);
        txtObjeto.setBounds(120, 90, 530, 27);
        jPanel3.add(txtCantidad);
        txtCantidad.setBounds(120, 140, 530, 27);
        jPanel3.add(txtDescObjeto);
        txtDescObjeto.setBounds(120, 190, 530, 27);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnRegistrar.setPreferredSize(new java.awt.Dimension(65, 65));
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(274, 274, 274))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nuevo / Modificar", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 1280, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        LimpiarElementos();
        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        int row = jtMedidasCajas.getSelectedRow();
        txtId.setText(String.valueOf(jtMedidasCajas.getValueAt(row, 0)));
        txtObjeto.setText(String.valueOf(jtMedidasCajas.getValueAt(row, 1)));
        txtCantidad.setText(String.valueOf(jtMedidasCajas.getValueAt(row, 2)));
        txtDescObjeto.setText(String.valueOf(jtMedidasCajas.getValueAt(row, 3)));
        txtLargo.setText(String.valueOf(jtMedidasCajas.getValueAt(row, 4)));
        txtAncho.setText(String.valueOf(jtMedidasCajas.getValueAt(row, 5)));
        txtLargoE.setText(String.valueOf(jtMedidasCajas.getValueAt(row, 6)));
        txtAnchoE.setText(String.valueOf(jtMedidasCajas.getValueAt(row, 7)));

        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

        int row = jtMedidasCajas.getSelectedRow();
        int rptaElimina = JOptionPane.showConfirmDialog(null, "Desea eliminar la caja: " + String.valueOf(jtMedidasCajas.getValueAt(row, 0) + "?"));
        if (rptaElimina==0) {
            caja.eliminarCaja(String.valueOf(jtMedidasCajas.getValueAt(row, 0)));
            tcaj.visualizarCaja(jtMedidasCajas);
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked

        if (txtId.getText().length()==0) {
            caja = new CajasDAO();
            String objeto = txtObjeto.getText();
            String cantidad = txtCantidad.getText();
            String descObjeto = txtDescObjeto.getText();
            String largo = txtLargo.getText();
            String ancho = txtAncho.getText();
            String largoE = txtLargoE.getText();
            String anchoE = txtAnchoE.getText();

            String rptaRegistro = caja.insertCaja(objeto, cantidad, descObjeto, largo, ancho, largoE, anchoE);

            if (rptaRegistro != null) {
                tcaj.visualizarCaja(jtMedidasCajas);
                LimpiarElementos();
                jTabbedPane1.setSelectedIndex(0);
                jTabbedPane1.setEnabledAt(1, false);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erroneo.");
            }
        } else {
            // Modificar
            int rptaEdita = JOptionPane.showConfirmDialog(null, "Desea modificar la caja: " + txtId.getText() + "?");
            if (rptaEdita==0) {
                String id = txtId.getText();
                String objeto = txtObjeto.getText();
                String cantidad = txtCantidad.getText();
                String descObjeto = txtDescObjeto.getText();
                String largo = txtLargo.getText();
                String ancho = txtAncho.getText();
                String largoE = txtLargoE.getText();
                String AnchoE = txtAnchoE.getText();

                int rptaEdit = caja.editarCaja(id, objeto, cantidad, descObjeto, largo, ancho, largoE, AnchoE);

                if (rptaEdit <= 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la edición.");
                } else {
                    tcaj.visualizarCaja(jtMedidasCajas);
                    jTabbedPane1.setSelectedIndex(0);
                    jTabbedPane1.setEnabledAt(1, false);
                }
            } else {
                tcaj.visualizarCaja(jtMedidasCajas);
                jTabbedPane1.setSelectedIndex(0);
                jTabbedPane1.setEnabledAt(1, false);
            }
        }
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        LimpiarElementos ();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        if (jTabbedPane1.getSelectedIndex()==0) {
            jTabbedPane1.setEnabledAt(1, false);
            LimpiarElementos();
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void btnImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseClicked

        try {
            MessageFormat headerFormat = new MessageFormat("Listado Medidas de Cajas");
            MessageFormat footerFormat = new MessageFormat("- Página {0} -");
            jtMedidasCajas.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
                    
           } catch (PrinterException ex) {
               JOptionPane.showMessageDialog(null, "No se ha podido imprimir correctamente, intentalo más tarde.");
           }                 
    }//GEN-LAST:event_btnImprimirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnImprimir;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jtMedidasCajas;
    public javax.swing.JTextField txtAncho;
    public javax.swing.JTextField txtAnchoE;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtDescObjeto;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtLargo;
    public javax.swing.JTextField txtLargoE;
    public javax.swing.JTextField txtObjeto;
    // End of variables declaration//GEN-END:variables
}
