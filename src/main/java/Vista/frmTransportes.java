package Vista;

import Modelo.SingletonProperties;
import Modelo.TransporteDAO;
import Tabla.TablaTransporte;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class frmTransportes extends javax.swing.JInternalFrame {

    JTextField clipboard;
    String ori; 
    TablaTransporte ttrans = new TablaTransporte();
    TransporteDAO transporte = new TransporteDAO();
    int clic_tabla = 0;

    public frmTransportes(String origen) {
        initComponents();
        // Inicializo componentes
        SingletonProperties sp=SingletonProperties.getInstancia();
        String path_icon= sp.getPropiedad("path_img_iconos");

        btnListar.setIcon(new ImageIcon(path_icon+"busqueda_peque.png"));
        btnNuevo.setIcon(new ImageIcon(path_icon+"nuevo_peque.png"));
        btnModificar.setIcon(new ImageIcon(path_icon+"editar_peque.png"));
        btnEliminar.setIcon(new ImageIcon(path_icon+"eliminar_peque.png"));
        btnRegistrar.setIcon(new ImageIcon(path_icon+"guardar_peque.png"));
        btnLimpiar.setIcon(new ImageIcon(path_icon+"limpiar_peque.png"));

        ori = origen;            
        ttrans.visualizarTransporte(jtTransporte, "", "");  
        jTabbedPane2.setEnabledAt(1, false);
    }
    
    public void LimpiarElementos () {
        txtId.setText("");
        txtRasonSocial.setText("");
        txtDomicilio.setText("");
        txtBarrio.setText("");
        cmbRemito.setSelectedItem("S");
        txtWeb.setText("");
        txtTelefono.setText("");
        txtMail.setText("");
        txtBusProvincia.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu = new javax.swing.JPopupMenu();
        jMCopy = new javax.swing.JMenuItem();
        jMPaste = new javax.swing.JMenuItem();
        jMCut = new javax.swing.JMenuItem();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPTransportes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTransporte = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtBusRazonSocial = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBusProvincia = new javax.swing.JTextField();
        btnListar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPNuevo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRasonSocial = new javax.swing.JTextField();
        txtDomicilio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbRemito = new javax.swing.JComboBox<>();
        txtBarrio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtWeb = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        jMCopy.setText("Copiar");
        jMCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCopyActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMCopy);

        jMPaste.setText("Pegar");
        jMPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMPasteActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMPaste);

        jMCut.setText("Cortar");
        jMCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCutActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMCut);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Transportes");
        setPreferredSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(null);

        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        jtTransporte.setModel(new javax.swing.table.DefaultTableModel(
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
        jtTransporte.setMinimumSize(new java.awt.Dimension(300, 72));
        jtTransporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtTransporteMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTransporteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTransporte);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        jLabel9.setText("Razon social:");

        txtBusRazonSocial.setComponentPopupMenu(jPopupMenu);

        jLabel10.setText("Provincia:");

        txtBusProvincia.setComponentPopupMenu(jPopupMenu);
        txtBusProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusProvinciaActionPerformed(evt);
            }
        });

        btnListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarMouseClicked(evt);
            }
        });
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 391, Short.MAX_VALUE)
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBusRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtBusProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPTransportesLayout = new javax.swing.GroupLayout(jPTransportes);
        jPTransportes.setLayout(jPTransportesLayout);
        jPTransportesLayout.setHorizontalGroup(
            jPTransportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTransportesLayout.createSequentialGroup()
                .addGroup(jPTransportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPTransportesLayout.setVerticalGroup(
            jPTransportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPTransportesLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPTransportesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Trnasportes", jPTransportes);

        jLabel1.setText("Razon Social:");

        jLabel2.setText("Domicilio:");

        txtRasonSocial.setComponentPopupMenu(jPopupMenu);
        txtRasonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRasonSocialActionPerformed(evt);
            }
        });

        txtDomicilio.setComponentPopupMenu(jPopupMenu);

        jLabel3.setText("Barrio:");

        jLabel4.setText("Remito:");

        cmbRemito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N" }));

        txtBarrio.setComponentPopupMenu(jPopupMenu);

        jLabel5.setText("Web:");

        jLabel6.setText("Telefono:");

        jLabel7.setText("Mail:");

        txtWeb.setComponentPopupMenu(jPopupMenu);

        txtTelefono.setComponentPopupMenu(jPopupMenu);

        txtMail.setComponentPopupMenu(jPopupMenu);

        jLabel8.setText("Provincias:");

        txtProvincia.setComponentPopupMenu(jPopupMenu);
        txtProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvinciaActionPerformed(evt);
            }
        });

        jLabel11.setText("Id:");

        txtId.setEditable(false);

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

        javax.swing.GroupLayout jPNuevoLayout = new javax.swing.GroupLayout(jPNuevo);
        jPNuevo.setLayout(jPNuevoLayout);
        jPNuevoLayout.setHorizontalGroup(
            jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPNuevoLayout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPNuevoLayout.createSequentialGroup()
                        .addGroup(jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPNuevoLayout.createSequentialGroup()
                                .addComponent(txtBarrio)
                                .addGap(110, 110, 110)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbRemito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addComponent(txtDomicilio)
                            .addComponent(txtRasonSocial)
                            .addComponent(txtProvincia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPNuevoLayout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtWeb, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(206, 206, 206)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1254, 1254, 1254))))
        );
        jPNuevoLayout.setVerticalGroup(
            jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNuevoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPNuevoLayout.createSequentialGroup()
                        .addGroup(jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtRasonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbRemito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPNuevoLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPNuevoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addGap(18, 18, 18)
                        .addGroup(jPNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(231, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Nuevo / Modificar", jPNuevo);

        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(12, 12, 1290, 647);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRasonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRasonSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRasonSocialActionPerformed

    private void txtProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProvinciaActionPerformed

    private void jtTransporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTransporteMouseClicked
                
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            if (ori=="ListaPedido") {
                evt.consume();
                //handle double click event.
                frmListaPedidos.cmbTransporte.setSelectedItem(String.valueOf(jtTransporte.getValueAt(jtTransporte.getSelectedRow(), 1)));
                this.dispose();
            }
        } 
    }//GEN-LAST:event_jtTransporteMouseClicked

    private void jtTransporteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTransporteMousePressed
    }//GEN-LAST:event_jtTransporteMousePressed

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        jTabbedPane2.setEnabledAt(1, true);
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        int row = jtTransporte.getSelectedRow();
        txtId.setText(String.valueOf(jtTransporte.getValueAt(row, 0)));
        txtRasonSocial.setText(String.valueOf(jtTransporte.getValueAt(row, 1)));
        txtDomicilio.setText(String.valueOf(jtTransporte.getValueAt(row, 2)));
        txtBarrio.setText(String.valueOf(jtTransporte.getValueAt(row, 3)));
        cmbRemito.setSelectedItem(String.valueOf(jtTransporte.getValueAt(row, 4)));
        txtWeb.setText(String.valueOf(jtTransporte.getValueAt(row, 5)));
        txtTelefono.setText(String.valueOf(jtTransporte.getValueAt(row, 6)));
        txtMail.setText(String.valueOf(jtTransporte.getValueAt(row, 7)));
        txtProvincia.setText(String.valueOf(jtTransporte.getValueAt(row, 8)));

        jTabbedPane2.setEnabledAt(1, true);
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

        int row = jtTransporte.getSelectedRow();
        int rptaElimina = JOptionPane.showConfirmDialog(null, "Desea eliminar el transporte: " + String.valueOf(jtTransporte.getValueAt(row, 1) + "?"));
        if (rptaElimina==0) {
            transporte.eliminarTransporte(String.valueOf(jtTransporte.getValueAt(row, 0)));
            ttrans.visualizarTransporte(jtTransporte, "", "");
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBusProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusProvinciaActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListarActionPerformed

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        if (jTabbedPane2.getSelectedIndex()==0) {
            jTabbedPane2.setEnabledAt(1, false);
            LimpiarElementos();
        }
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked

        if (txtId.getText().length()==0) {
        // Insertar    
            transporte = new TransporteDAO();
            String razonSocial = txtRasonSocial.getText();
            String domicilio = txtDomicilio.getText();
            String barrio = txtBarrio.getText();
            String remito = (String)cmbRemito.getSelectedItem();
            String web = txtWeb.getText();
            String telefono = txtTelefono.getText();
            String mail = txtMail.getText();
            String provincia = txtProvincia.getText();
            String usuario_creacion = "admin";
            String usuario_ult_mod = "admin";
            
            String rptaRegistro = transporte.insertTransporte(razonSocial, domicilio, barrio, remito, web, telefono, mail, provincia, usuario_creacion, usuario_ult_mod);
          
            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
                ttrans.visualizarTransporte(jtTransporte, "", "");  
                LimpiarElementos();
                jTabbedPane2.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erroneo.");                
            }
        } else {
            // Modificar
            int rptaEdita = JOptionPane.showConfirmDialog(null, "Desea modificar el tranporte: " + txtRasonSocial.getText() + "?");
            if (rptaEdita==0) {
                String id = txtId.getText();
                String rasonSocial = txtRasonSocial.getText();
                String domicilio = txtDomicilio.getText();
                String barrio = txtBarrio.getText();
                String remito = (String)cmbRemito.getSelectedItem();
                String web = txtWeb.getText();
                String telefono = txtTelefono.getText();
                String mail = txtMail.getText();
                String provincia = txtProvincia.getText();
                String usuario_ult_mod = "admin";
                int rptaEdit = transporte.editarTransporte(id, rasonSocial, domicilio, barrio, remito, web, telefono, mail, provincia, usuario_ult_mod);

                if (rptaEdit <= 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la edición.");
                } else {
                    ttrans.visualizarTransporte(jtTransporte, "", "");
                    jTabbedPane2.setSelectedIndex(0);
                }
            } else {
                ttrans.visualizarTransporte(jtTransporte, "", "");
                jTabbedPane2.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        LimpiarElementos ();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMouseClicked
        ttrans.visualizarTransporte(jtTransporte, txtBusRazonSocial.getText(), txtBusProvincia.getText());
    }//GEN-LAST:event_btnListarMouseClicked

    private void jMCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCopyActionPerformed
        clipboard = (JTextField) jPopupMenu.getInvoker();
        clipboard.copy();
    }//GEN-LAST:event_jMCopyActionPerformed

    private void jMPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMPasteActionPerformed
        clipboard = (JTextField) jPopupMenu.getInvoker();
        clipboard.paste();
    }//GEN-LAST:event_jMPasteActionPerformed

    private void jMCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCutActionPerformed
        clipboard = (JTextField) jPopupMenu.getInvoker();
        clipboard.cut();
    }//GEN-LAST:event_jMCutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnListar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JComboBox<String> cmbRemito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMCopy;
    private javax.swing.JMenuItem jMCut;
    private javax.swing.JMenuItem jMPaste;
    private javax.swing.JPanel jPNuevo;
    private javax.swing.JPanel jPTransportes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JTable jtTransporte;
    public javax.swing.JTextField txtBarrio;
    public javax.swing.JTextField txtBusProvincia;
    public javax.swing.JTextField txtBusRazonSocial;
    public javax.swing.JTextField txtDomicilio;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtMail;
    public javax.swing.JTextField txtProvincia;
    public javax.swing.JTextField txtRasonSocial;
    public javax.swing.JTextField txtTelefono;
    public javax.swing.JTextField txtWeb;
    // End of variables declaration//GEN-END:variables
}
