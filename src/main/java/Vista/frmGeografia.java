package Vista;

import Modelo.GeografiaDAO;
import Modelo.SingletonProperties;
import Tabla.TablaGeografia;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class frmGeografia extends javax.swing.JInternalFrame {

    JTextField clipboard;
    String ori; 
    TablaGeografia tgeo = new TablaGeografia();
    GeografiaDAO geografia = new GeografiaDAO();
    int clic_tabla = 0;
       
    public frmGeografia(String origen) {
        
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
        cmbBusProvincia.removeAllItems();
        cmbProvincia.removeAllItems();
        cmbBusProvincia.addItem("*"); 
        ArrayList<String> provincia = new ArrayList();
        provincia = geografia.Llenar_cmbProvincia();
        for (int i=0; i<provincia.size();i++){
            cmbBusProvincia.addItem(provincia.get(i));
            cmbProvincia.addItem(provincia.get(i));
        }

        tgeo.visualizarGografia(jtGeografia, "*", "");  
        jTabbedPane1.setEnabledAt(1, false);
    }

    public void LimpiarElementos () {
        txtId.setText("");
        txtIdProvincia.setText("");
        txtCodigoPostal.setText("");
        cmbProvincia.setSelectedItem("Caba");
        txtIdLocalidad.setText("");
        txtLocalidad.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbBusProvincia = new javax.swing.JComboBox<>();
        txtBusLocalidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtGeografia = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        cmbProvincia = new javax.swing.JComboBox<>();
        txtIdProvincia = new javax.swing.JTextField();
        txtCodigoPostal = new javax.swing.JTextField();
        txtIdLocalidad = new javax.swing.JTextField();
        txtLocalidad = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Geografía");

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        jLabel1.setText("Provincia:");

        cmbBusProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Localidad:");

        btnListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbBusProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtBusLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbBusProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtGeografia.setModel(new javax.swing.table.DefaultTableModel(
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
        jtGeografia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtGeografiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtGeografia);

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
                .addContainerGap(24, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Localidades", jPanel1);

        jPanel2.setLayout(null);

        jLabel3.setText("Id:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(22, 26, 16, 17);

        jLabel4.setText("Id Provincia:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(22, 75, 81, 17);

        jLabel5.setText("Provincia:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(291, 75, 66, 17);

        jLabel6.setText("Código Postal: ");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(255, 26, 102, 17);

        jLabel7.setText("Id Localidad:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(22, 129, 85, 17);

        jLabel8.setText("Localidad");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(291, 129, 66, 17);

        txtId.setEditable(false);
        jPanel2.add(txtId);
        txtId.setBounds(120, 20, 86, 27);

        cmbProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cmbProvincia);
        cmbProvincia.setBounds(369, 70, 315, 27);
        jPanel2.add(txtIdProvincia);
        txtIdProvincia.setBounds(120, 70, 86, 27);
        jPanel2.add(txtCodigoPostal);
        txtCodigoPostal.setBounds(369, 21, 94, 27);
        jPanel2.add(txtIdLocalidad);
        txtIdLocalidad.setBounds(120, 120, 86, 27);
        jPanel2.add(txtLocalidad);
        txtLocalidad.setBounds(369, 124, 315, 27);

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
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7);
        jPanel7.setBounds(740, 20, 150, 240);

        jTabbedPane1.addTab("Nuevo / Modificar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

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
        int row = jtGeografia.getSelectedRow();
        txtId.setText(String.valueOf(jtGeografia.getValueAt(row, 0)));
        cmbProvincia.setSelectedItem(String.valueOf(jtGeografia.getValueAt(row, 2)));
        txtIdProvincia.setText(String.valueOf(jtGeografia.getValueAt(row, 1)));
        txtCodigoPostal.setText(String.valueOf(jtGeografia.getValueAt(row, 3)));
        txtIdLocalidad.setText(String.valueOf(jtGeografia.getValueAt(row, 4)));
        txtLocalidad.setText(String.valueOf(jtGeografia.getValueAt(row, 5)));

        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

        int row = jtGeografia.getSelectedRow();
        int rptaElimina = JOptionPane.showConfirmDialog(null, "Desea eliminar la localidad: " + String.valueOf(jtGeografia.getValueAt(row, 5) + "?"));
        if (rptaElimina==0) {
            geografia.eliminarGeografia(String.valueOf(jtGeografia.getValueAt(row, 0)));
            tgeo.visualizarGografia(jtGeografia, "*", "");
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMouseClicked
        tgeo.visualizarGografia(jtGeografia, (String)cmbBusProvincia.getSelectedItem(), txtBusLocalidad.getText());
    }//GEN-LAST:event_btnListarMouseClicked

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked

        if (txtId.getText().length()==0) {
        // Insertar
            //Calcular id Select max
            String maxId = geografia.listMaxId();
            int id = Integer.parseInt(maxId) + 1;

            geografia = new GeografiaDAO();
            String idProvincia = txtIdProvincia.getText();
            String provincia = (String)cmbProvincia.getSelectedItem();
            String codigoPostal = txtCodigoPostal.getText();
            String idLocalidad = txtIdLocalidad.getText();
            String localidad = txtLocalidad.getText();
            String usuario_creacion = "admin";
            String usuario_ult_mod = "admin";

            String rptaRegistro = geografia.insertarGeografia(String.valueOf(id), idProvincia, provincia, codigoPostal, idLocalidad, localidad, usuario_creacion, usuario_ult_mod);

            if (rptaRegistro != null) {
                tgeo.visualizarGografia(jtGeografia, "*", "");
//                LimpiarElementos();
                jTabbedPane1.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erroneo.");
            }
        } else {
            // Modificar
            int rptaEdita = JOptionPane.showConfirmDialog(null, "Desea modificar la localidad: " + txtLocalidad.getText() + "?");
            if (rptaEdita==0) {
                String id = txtId.getText();
                String idProvincia = txtIdProvincia.getText();
                String codigoPostal = txtCodigoPostal.getText();
                String provincia = (String)cmbProvincia.getSelectedItem();
                String idLocalidad = txtIdLocalidad.getText();
                String localidad = txtLocalidad.getText();
                String usuario_ult_mod = "admin";

                int rptaEdit = geografia.editarGeografia(id, idProvincia, provincia, codigoPostal, idLocalidad, localidad, usuario_ult_mod);

                if (rptaEdit <= 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la edición.");
                } else {
                    tgeo.visualizarGografia(jtGeografia, "*", "");
                    jTabbedPane1.setSelectedIndex(0);
                }
            } else {
                tgeo.visualizarGografia(jtGeografia, "*", "");
                jTabbedPane1.setSelectedIndex(0);
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

    private void jtGeografiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtGeografiaMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            //handle double click event.
            if (ori=="ListaPedido") {
                frmListaPedidos.txtProvincia.setText(String.valueOf(jtGeografia.getValueAt(jtGeografia.getSelectedRow(), 2)));
                frmListaPedidos.txtLocalidad.setText(String.valueOf(jtGeografia.getValueAt(jtGeografia.getSelectedRow(), 5)));
                frmListaPedidos.txtCodigoPostal.setText(String.valueOf(jtGeografia.getValueAt(jtGeografia.getSelectedRow(), 3)));
                this.dispose();
            }
            if (ori=="TransLoc") {
                frmTransporteLocalidad.cmbBusProvincia.setSelectedItem(String.valueOf(jtGeografia.getValueAt(jtGeografia.getSelectedRow(), 2)));
                frmTransporteLocalidad.txtBusLocalidad.setText(String.valueOf(jtGeografia.getValueAt(jtGeografia.getSelectedRow(), 5)));
                this.dispose();
            }
        }
    }//GEN-LAST:event_jtGeografiaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnListar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JComboBox<String> cmbBusProvincia;
    public javax.swing.JComboBox<String> cmbProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jtGeografia;
    public javax.swing.JTextField txtBusLocalidad;
    public javax.swing.JTextField txtCodigoPostal;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtIdLocalidad;
    public javax.swing.JTextField txtIdProvincia;
    public javax.swing.JTextField txtLocalidad;
    // End of variables declaration//GEN-END:variables
}
