package Vista;

import Modelo.ClienteDAO;
import Modelo.MaterialDAO;
import Modelo.SingletonProperties;
import Tabla.TablaCliente;
import Tabla.TablaMaterial;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class frmMateriales extends javax.swing.JInternalFrame {
    
    JTextField clipboard;
    String ori; 
    TablaMaterial tmat = new TablaMaterial();
    MaterialDAO material = new MaterialDAO();
    int clic_tabla = 0;

    public frmMateriales(String origen) {
        initComponents();

        // Inicializo componentes
        SingletonProperties sp=SingletonProperties.getInstancia();
        String path_icon= sp.getPropiedad("path_img_iconos");

        btnNuevo.setIcon(new ImageIcon(path_icon+"nuevo_peque.png"));
        btnModificar.setIcon(new ImageIcon(path_icon+"editar_peque.png"));
        btnEliminar.setIcon(new ImageIcon(path_icon+"eliminar_peque.png"));
        btnNuevaCat.setIcon(new ImageIcon(path_icon+"nuevo_peque.png"));
        btnRegistrar.setIcon(new ImageIcon(path_icon+"guardar_peque.png"));
        btnLimpiar.setIcon(new ImageIcon(path_icon+"limpiar_peque.png"));

        ori = origen;    
        cmbCategoria.removeAllItems();
        cmbProveedor.removeAllItems();
        ArrayList<String> categorias = new ArrayList<String>();
        categorias = material.Llenar_cmbCategoria();
        for (int i=0; i<categorias.size();i++){
            cmbCategoria.addItem(categorias.get(i));
        }
        ArrayList<String> proveedores = new ArrayList<String>();
        proveedores = material.Llenar_cmbProveedor();
        for (int i=0; i<proveedores.size();i++){
            cmbProveedor.addItem(proveedores.get(i));
        }
        
        tmat.visualizarMaterial(jtMaterial);  
        jTabbedPane1.setEnabledAt(1, false);
        
    }
    
    public void LimpiarElementos () {
        txtId.setText("");
        txtObjeto.setText("");
        txtDescripcion.setText("");
        cmbCategoria.setSelectedItem("Vidrio");
        txtCantidad.setText("");
        cmbStock.setSelectedItem("N");
        txtStockMin.setText("");
        txtStockMax.setText("");
        cmbProveedor.setSelectedItem("Labranzas");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterial = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtObjeto = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtStockMin = new javax.swing.JTextField();
        txtStockMax = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbProveedor = new javax.swing.JComboBox<>();
        cmbStock = new javax.swing.JComboBox<>();
        btnNuevaCat = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Materiales");

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jtMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Rason social", "Actividad", "Telefono", "Contacto", "Mail", "Direccion", "Web", "Observacion"
            }
        ));
        jtMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMaterialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtMaterial);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Materiales", jPanel1);

        jPanel2.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Material"));
        jPanel3.setLayout(null);

        jLabel1.setText("Id:");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(10, 30, 40, 30);

        jLabel2.setText("Objeto:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 70, 70, 20);

        jLabel3.setText("Descripción:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(10, 107, 100, 30);

        jLabel4.setText("Categoría:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 147, 90, 30);

        jLabel5.setText("Cantidad:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(420, 157, 80, 20);

        jLabel6.setText("Stock:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(10, 200, 70, 30);

        jLabel7.setText("Stock Min:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(220, 200, 80, 30);

        jLabel8.setText("Stock Max:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(420, 200, 80, 30);

        jLabel9.setText("Proveedor:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(10, 240, 90, 30);
        jPanel3.add(txtId);
        txtId.setBounds(100, 30, 98, 27);
        jPanel3.add(txtObjeto);
        txtObjeto.setBounds(100, 70, 600, 27);
        jPanel3.add(txtDescripcion);
        txtDescripcion.setBounds(100, 110, 600, 27);
        jPanel3.add(txtCantidad);
        txtCantidad.setBounds(510, 150, 190, 27);
        jPanel3.add(txtStockMin);
        txtStockMin.setBounds(300, 200, 110, 27);
        jPanel3.add(txtStockMax);
        txtStockMax.setBounds(510, 200, 190, 27);

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cmbCategoria);
        cmbCategoria.setBounds(100, 150, 164, 27);

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cmbProveedor);
        cmbProveedor.setBounds(100, 240, 310, 27);

        cmbStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N" }));
        jPanel3.add(cmbStock);
        cmbStock.setBounds(100, 200, 73, 30);

        btnNuevaCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevaCatMouseClicked(evt);
            }
        });
        jPanel3.add(btnNuevaCat);
        btnNuevaCat.setBounds(280, 140, 50, 50);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 720, 290);

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

        jTabbedPane1.addTab("Nuevo / Modificar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
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
        int row = jtMaterial.getSelectedRow();
        txtId.setText(String.valueOf(jtMaterial.getValueAt(row, 0)));
        txtObjeto.setText(String.valueOf(jtMaterial.getValueAt(row, 1)));
        txtDescripcion.setText(String.valueOf(jtMaterial.getValueAt(row, 2)));
        cmbCategoria.setSelectedItem(String.valueOf(jtMaterial.getValueAt(row, 3)));
        txtCantidad.setText(String.valueOf(jtMaterial.getValueAt(row, 4)));
        cmbStock.setSelectedItem(String.valueOf(jtMaterial.getValueAt(row, 5)));
        txtStockMin.setText(String.valueOf(jtMaterial.getValueAt(row, 6)));
        txtStockMax.setText(String.valueOf(jtMaterial.getValueAt(row, 7)));
        cmbProveedor.setSelectedItem(String.valueOf(jtMaterial.getValueAt(row, 8)));

        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

        int row = jtMaterial.getSelectedRow();
        int rptaElimina = JOptionPane.showConfirmDialog(null, "Desea eliminar el material: " + String.valueOf(jtMaterial.getValueAt(row, 1) + "?"));
        if (rptaElimina==0) {
            material.eliminarMaterial(String.valueOf(jtMaterial.getValueAt(row, 0)));
            tmat.visualizarMaterial(jtMaterial);
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked

        material = new MaterialDAO();
        String id = txtId.getText();
        String objeto = txtObjeto.getText();
        String descripcion = txtDescripcion.getText();
        String categoria = (String)cmbCategoria.getSelectedItem();
        String cantidad = txtCantidad.getText();
        String stock = (String)cmbStock.getSelectedItem();
        String stockMin = txtStockMin.getText();
        String stockMax = txtStockMax.getText();
        String proveedor = (String)cmbProveedor.getSelectedItem();
        String usuario_creacion = "admin";
        String usuario_ult_mod = "admin";
            
        if (txtId.getText().length()==0) {

            String rptaRegistro = material.insertMaterial(objeto, descripcion, categoria, cantidad, stock, stockMin, stockMax, proveedor, usuario_creacion, usuario_ult_mod);

            if (rptaRegistro != null) {
                tmat.visualizarMaterial(jtMaterial);
                LimpiarElementos();
                jTabbedPane1.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erroneo.");
            }
        } else {
            // Modificar
            int rptaEdita = JOptionPane.showConfirmDialog(null, "Desea modificar el material: " + txtObjeto.getText() + "?");
            if (rptaEdita==0) {

                int rptaEdit = material.editarMaterial(id, objeto, descripcion, categoria, cantidad, stock, stockMin, stockMax, proveedor, usuario_ult_mod);

                if (rptaEdit <= 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la edición.");
                } else {
                    tmat.visualizarMaterial(jtMaterial);
                    jTabbedPane1.setSelectedIndex(0);
                }
            } else {
                tmat.visualizarMaterial(jtMaterial);
                jTabbedPane1.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        LimpiarElementos ();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnNuevaCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaCatMouseClicked
            String nuevaCategoria = JOptionPane.showInputDialog("Escribe la nueva categoría de materiales");
            int rptaRegistro = material.insertNuevaCat(nuevaCategoria);
            if (rptaRegistro > 0) {
                cmbCategoria.addItem(nuevaCategoria);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erroneo.");                
            }
    }//GEN-LAST:event_btnNuevaCatMouseClicked

    private void jtMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMaterialMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            //handle double click event.
            frmCompras.cmbInsumo.setSelectedItem(String.valueOf(jtMaterial.getValueAt(jtMaterial.getSelectedRow(), 1)));
            frmCompras.cmbCategoria.setSelectedItem(String.valueOf(jtMaterial.getValueAt(jtMaterial.getSelectedRow(), 3)));
            frmCompras.cmbProveedor.setSelectedItem(String.valueOf(jtMaterial.getValueAt(jtMaterial.getSelectedRow(), 8)));
            this.dispose();
        }
    }//GEN-LAST:event_jtMaterialMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        if (jTabbedPane1.getSelectedIndex()==0) {
            jTabbedPane1.setEnabledAt(1, false);
            LimpiarElementos();
        }

    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnNuevaCat;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JComboBox<String> cmbCategoria;
    public javax.swing.JComboBox<String> cmbProveedor;
    public javax.swing.JComboBox<String> cmbStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jtMaterial;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtObjeto;
    public javax.swing.JTextField txtStockMax;
    public javax.swing.JTextField txtStockMin;
    // End of variables declaration//GEN-END:variables
}
