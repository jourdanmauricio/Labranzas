package Vista;

import Modelo.ClienteDAO;
import Modelo.SingletonProperties;
import Tabla.TablaCliente;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class frmClientes extends javax.swing.JInternalFrame {
    
    JTextField clipboard;
    String ori; 
    TablaCliente tcli = new TablaCliente();
    ClienteDAO cliente = new ClienteDAO();
    int clic_tabla = 0;

    public frmClientes(String origen) {

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
        cmbTipo.removeAllItems();
        cmbTipo.addItem("Resindencial");
        cmbTipo.addItem("Empresa");
        
        tcli.visualizarCliente(jtCliente, "", "", "");  
        jTabbedPane1.setEnabledAt(1, false);
    }
    
    public void LimpiarElementos () {
        txtId.setText("");
        txtNombre.setText("");
        txtDni.setText("");
        cmbTipo.setSelectedItem("Residencial");
        txtReferente.setText("");
        txtTelefono.setText("");
        txtMail.setText("");
        txtDomicilio.setText("");
        txtUsuarioMl.setText("");
        txtObservacion.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu = new javax.swing.JPopupMenu();
        jMCopy = new javax.swing.JMenuItem();
        jMPaste = new javax.swing.JMenuItem();
        jMCut = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtBusNom = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtBusUser = new javax.swing.JTextField();
        btnListar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtReferente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        txtUsuarioMl = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        txtObservacion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        jMCopy.setText("Copy");
        jMCopy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMCopyMouseClicked(evt);
            }
        });
        jMCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCopyActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMCopy);

        jMPaste.setText("Paste");
        jMPaste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMPasteMouseClicked(evt);
            }
        });
        jMPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMPasteActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMPaste);

        jMCut.setText("Cut");
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
        setTitle("Clientes");

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setLayout(null);

        jtCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCliente);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 99, 1130, 630);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(2285, 0, 0, 101);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));
        jPanel5.setLayout(null);

        jLabel11.setText("Nombre:");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(6, 34, 61, 17);

        txtBusNom.setComponentPopupMenu(jPopupMenu);
        jPanel5.add(txtBusNom);
        txtBusNom.setBounds(85, 29, 247, 27);

        jLabel12.setText("User ML:");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(355, 34, 60, 17);

        txtBusUser.setComponentPopupMenu(jPopupMenu);
        jPanel5.add(txtBusUser);
        txtBusUser.setBounds(433, 29, 142, 27);

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
        jPanel5.add(btnListar);
        btnListar.setBounds(1048, 17, 54, 55);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(2, 12, 1130, 80);

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

        jPanel1.add(jPanel6);
        jPanel6.setBounds(1140, 20, 110, 320);

        jTabbedPane1.addTab("Clientes", jPanel1);

        jPanel2.setName("NuevoCli"); // NOI18N
        jPanel2.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel1.setText("Id:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Referente:");

        txtId.setEditable(false);
        txtId.setComponentPopupMenu(jPopupMenu);

        txtNombre.setComponentPopupMenu(jPopupMenu);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtReferente.setComponentPopupMenu(jPopupMenu);

        jLabel4.setText("DNI:");

        txtDni.setComponentPopupMenu(jPopupMenu);

        jLabel5.setText("Tipo:");

        jLabel6.setText("Teléfono:");

        txtTelefono.setComponentPopupMenu(jPopupMenu);

        jLabel7.setText("Mail:");

        jLabel8.setText("Usuario_Ml:");

        txtMail.setComponentPopupMenu(jPopupMenu);

        txtUsuarioMl.setComponentPopupMenu(jPopupMenu);

        jLabel9.setText("Obs:");

        txtDomicilio.setComponentPopupMenu(jPopupMenu);

        jLabel10.setText("Domicilio:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jLabel7))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(txtReferente)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbTipo, 0, 175, Short.MAX_VALUE))
                                            .addComponent(txtMail))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel6)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsuarioMl, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtTelefono)))
                            .addComponent(txtDomicilio)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObservacion)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReferente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(txtUsuarioMl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(12, 12, 709, 330);

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

        jPanel2.add(jPanel7);
        jPanel7.setBounds(740, 20, 150, 320);

        jTabbedPane1.addTab("Nuevo / Modficar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClienteMouseClicked
                
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            //handle double click event.
            frmListaPedidos.txtCliente.setText(String.valueOf(jtCliente.getValueAt(jtCliente.getSelectedRow(), 1)));
            frmListaPedidos.txtClienteId.setText(String.valueOf(jtCliente.getValueAt(jtCliente.getSelectedRow(), 0)));
            frmListaPedidos.txtDomEntrega.setText(String.valueOf(jtCliente.getValueAt(jtCliente.getSelectedRow(), 7)));
            if (String.valueOf(jtCliente.getValueAt(jtCliente.getSelectedRow(), 7)).equals("Caba")) {
                frmListaPedidos.cmbEnvio.setSelectedItem("N");
            } else {
                frmListaPedidos.cmbEnvio.setSelectedItem("S");
            }
            this.dispose();
        }
    }//GEN-LAST:event_jtClienteMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        LimpiarElementos();
        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMouseClicked
        tcli.visualizarCliente(jtCliente, txtBusNom.getText(), txtBusUser.getText(),"");
    }//GEN-LAST:event_btnListarMouseClicked

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
    
        if (txtId.getText().length()==0) {
            cliente = new ClienteDAO();
            String nombre = txtNombre.getText();
            String dni = txtDni.getText();
            String tipo = (String)cmbTipo.getSelectedItem();
            String referente = txtReferente.getText();
            String telefono = txtTelefono.getText();
            String mail = txtMail.getText();
            String domicilio = txtDomicilio.getText();
            String usuario_ml = txtUsuarioMl.getText();
            String observacion = txtObservacion.getText();
            String usuario_creacion = "admin";
            String usuario_ult_mod = "admin";

            String rptaRegistro = cliente.insertCliente(nombre, dni, tipo, referente, telefono, mail, domicilio, usuario_ml, observacion, usuario_creacion, usuario_ult_mod);

            if (rptaRegistro != null) {
                tcli.visualizarCliente(jtCliente, "", "", "");        
                LimpiarElementos();
                jTabbedPane1.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erroneo.");                
            }
        } else {
            // Modificar
            int rptaEdita = JOptionPane.showConfirmDialog(null, "Desea modificar el cliente: " + txtNombre.getText() + "?");
            if (rptaEdita==0) {
                String id = txtId.getText();
                String dni = txtDni.getText();
                String nombre = txtNombre.getText();
                String tipo = (String)cmbTipo.getSelectedItem();
                String referente = txtReferente.getText();
                String telefono = txtTelefono.getText();
                String mail = txtMail.getText();
                String domicilio = txtDomicilio.getText();
                String usuario_ml = txtUsuarioMl.getText();
                String observacion = txtObservacion.getText();
                String usuario_ult_mod = "admin";

                int rptaEdit = cliente.editarCliente(id, dni, nombre, tipo, referente, telefono, mail, domicilio, usuario_ml, observacion, usuario_ult_mod);

                if (rptaEdit <= 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la edición.");
                } else {
                    tcli.visualizarCliente(jtCliente, "", "", "");      
                    jTabbedPane1.setSelectedIndex(0);
                }
            } else {
                tcli.visualizarCliente(jtCliente, "", "", "");      
                jTabbedPane1.setSelectedIndex(0);
            }    
        }
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        int row = jtCliente.getSelectedRow();
        txtId.setText(String.valueOf(jtCliente.getValueAt(row, 0)));
        txtNombre.setText(String.valueOf(jtCliente.getValueAt(row, 1)));
        txtDni.setText(String.valueOf(jtCliente.getValueAt(row, 2)));
        cmbTipo.setSelectedItem(String.valueOf(jtCliente.getValueAt(row, 3)));
        txtReferente.setText(String.valueOf(jtCliente.getValueAt(row, 4)));
        txtTelefono.setText(String.valueOf(jtCliente.getValueAt(row, 5)));
        txtMail.setText(String.valueOf(jtCliente.getValueAt(row, 6)));
        txtDomicilio.setText(String.valueOf(jtCliente.getValueAt(row, 7)));
        txtUsuarioMl.setText(String.valueOf(jtCliente.getValueAt(row, 8)));
        txtObservacion.setText(String.valueOf(jtCliente.getValueAt(row, 9)));

        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setSelectedIndex(1);          

    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        
        int row = jtCliente.getSelectedRow();    
        int rptaElimina = JOptionPane.showConfirmDialog(null, "Desea eliminar el cliente: " + String.valueOf(jtCliente.getValueAt(row, 1) + "?"));
        if (rptaElimina==0) {
            cliente.eliminarCliente(String.valueOf(jtCliente.getValueAt(row, 0)));
            tcli.visualizarCliente(jtCliente, "", "", "");     
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        LimpiarElementos ();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void jMCopyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMCopyMouseClicked
    }//GEN-LAST:event_jMCopyMouseClicked

    private void jMPasteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMPasteMouseClicked
    }//GEN-LAST:event_jMPasteMouseClicked

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

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        if (jTabbedPane1.getSelectedIndex()==0) {
            jTabbedPane1.setEnabledAt(1, false);
            LimpiarElementos();
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnListar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jtCliente;
    public javax.swing.JTextField txtBusNom;
    public javax.swing.JTextField txtBusUser;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtDomicilio;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtMail;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtObservacion;
    public javax.swing.JTextField txtReferente;
    public javax.swing.JTextField txtTelefono;
    public javax.swing.JTextField txtUsuarioMl;
    // End of variables declaration//GEN-END:variables
}
