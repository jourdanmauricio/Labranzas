package Vista;

import Modelo.ProductoDAO;
import Modelo.SingletonProperties;
import Tabla.TablaProducto;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class frmProductos extends javax.swing.JInternalFrame {
    
    JTextField clipboard;
    String ori; 
    TablaProducto tprod = new TablaProducto();
    ProductoDAO producto = new ProductoDAO();
    int clic_tabla = 0;

    public frmProductos(String origen) {
        initComponents();

        ori = origen;    
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
        
        producto = new ProductoDAO();
    // Cargo los combo de búsqueda
        cmbBusCat.removeAllItems();
        ArrayList<String> categorias = new ArrayList<String>();
        categorias = producto.Llenar_cmbCategoria();
        cmbCategoria.removeAllItems();
        cmbBusCat.addItem("*");
        for (int i=0; i<categorias.size();i++){
            cmbCategoria.addItem(categorias.get(i));
            cmbBusCat.addItem(categorias.get(i));
        }
        ArrayList<String> proveedores = new ArrayList<String>();
        proveedores = producto.Llenar_cmbProveedor();
        cmbProveedor.removeAllItems();
        for(int i = 0; i < proveedores.size(); i++) {
            cmbProveedor.addItem(proveedores.get(i));
        }

        tprod.visualizarProducto(jtProducto, (String)cmbBusEst.getSelectedItem(), (String)cmbBusCat.getSelectedItem());  
    }
    
    public void LimpiarElementos() {
     
        txtId.setText("");
        txtDescripcion.setText("");
        txtDescAbrev.setText("");
        cmbEstado.setSelectedItem("Activo");
        cmbCategoria.setSelectedItem("centro_de_mesa");
        txtPrecioMayor.setText("");
        txtPrecioMenor.setText("");
        txtCantidad.setText("");
        txtCantMin.setText("");
        txtFoto.setText("");
        cmbVisible.setSelectedItem("N");
        txtOrden.setText("");
        txtFotoDet1.setText("");
        txtFotoDet2.setText("");
        txtFotoDet3.setText("");
        cmbCemento.setSelectedItem("S");
        cmbVidrio.setSelectedItem("S");
        cmbParafina.setSelectedItem("S");         
        cmbProveedor.setSelectedItem("Labranzas");    
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jtProducto = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        cmbBusEst = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cmbBusCat = new javax.swing.JComboBox<>();
        btnListar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtDescAbrev = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtCantMin = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbCategoria = new javax.swing.JComboBox<>();
        txtPrecioMayor = new javax.swing.JTextField();
        txtPrecioMenor = new javax.swing.JTextField();
        cmbVisible = new javax.swing.JComboBox<>();
        txtOrden = new javax.swing.JTextField();
        txtFoto = new javax.swing.JTextField();
        txtFotoDet1 = new javax.swing.JTextField();
        txtFotoDet2 = new javax.swing.JTextField();
        txtFotoDet3 = new javax.swing.JTextField();
        cmbCemento = new javax.swing.JComboBox<>();
        cmbVidrio = new javax.swing.JComboBox<>();
        cmbParafina = new javax.swing.JComboBox<>();
        cmbProveedor = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
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
        jMPaste.setToolTipText("");
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
        setTitle("Productos");

        jPanel1.setLayout(null);

        jtProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        jtProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtProducto);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(12, 105, 1110, 500);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));
        jPanel3.setLayout(null);

        jLabel20.setText("Estado:");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(20, 30, 70, 30);

        cmbBusEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Baja", "*" }));
        jPanel3.add(cmbBusEst);
        cmbBusEst.setBounds(90, 30, 130, 27);

        jLabel19.setText("Categoría:");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(250, 30, 90, 30);

        cmbBusCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cmbBusCat);
        cmbBusCat.setBounds(330, 30, 139, 27);

        btnListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarMouseClicked(evt);
            }
        });
        jPanel3.add(btnListar);
        btnListar.setBounds(1040, 20, 56, 55);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 9, 1110, 90);

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
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(1140, 10, 100, 330);

        jTabbedPane1.addTab("Productos", jPanel1);

        jPanel2.setLayout(null);

        jLabel1.setText("Estado:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(54, 172, 70, 17);

        jLabel2.setText("Proveedor:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(29, 411, 100, 17);

        jLabel3.setText("Parafina:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(253, 359, 70, 17);

        jLabel4.setText("Vidrio:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(447, 359, 50, 17);

        jLabel5.setText("Cemento:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(37, 359, 80, 17);

        jLabel6.setText("Foto 3:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(534, 314, 70, 17);

        jLabel7.setText("Foto 2:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(59, 314, 60, 17);

        jLabel8.setText("Foto 1:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(534, 266, 60, 17);

        jLabel9.setText("Orden:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(877, 221, 60, 17);

        jLabel10.setText("Visible:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(675, 221, 70, 17);

        jLabel11.setText("Foto:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(70, 266, 50, 17);

        jLabel12.setText("Precio Mayor:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(12, 221, 110, 17);

        jLabel13.setText("Cant Min:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(817, 127, 80, 17);

        jLabel14.setText("Cantidad:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(655, 127, 90, 17);

        jLabel15.setText("Desc Abrev:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(24, 127, 100, 17);

        jLabel16.setText("Precio Menor:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(336, 221, 140, 17);

        jLabel17.setText("Categoría:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(509, 172, 80, 17);

        jLabel18.setText("Descripción:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(20, 82, 100, 17);

        txtDescripcion.setComponentPopupMenu(jPopupMenu);
        jPanel2.add(txtDescripcion);
        txtDescripcion.setBounds(124, 77, 861, 27);

        txtDescAbrev.setComponentPopupMenu(jPopupMenu);
        txtDescAbrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescAbrevActionPerformed(evt);
            }
        });
        jPanel2.add(txtDescAbrev);
        txtDescAbrev.setBounds(124, 122, 513, 27);

        txtCantidad.setComponentPopupMenu(jPopupMenu);
        jPanel2.add(txtCantidad);
        txtCantidad.setBounds(739, 122, 60, 27);

        txtCantMin.setComponentPopupMenu(jPopupMenu);
        jPanel2.add(txtCantMin);
        txtCantMin.setBounds(900, 122, 85, 27);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Baja" }));
        jPanel2.add(cmbEstado);
        cmbEstado.setBounds(124, 167, 309, 27);

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cmbCategoria);
        cmbCategoria.setBounds(599, 167, 386, 27);

        txtPrecioMayor.setComponentPopupMenu(jPopupMenu);
        jPanel2.add(txtPrecioMayor);
        txtPrecioMayor.setBounds(124, 216, 123, 27);

        txtPrecioMenor.setComponentPopupMenu(jPopupMenu);
        jPanel2.add(txtPrecioMenor);
        txtPrecioMenor.setBounds(445, 216, 132, 27);

        cmbVisible.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N" }));
        jPanel2.add(cmbVisible);
        cmbVisible.setBounds(735, 216, 60, 27);

        txtOrden.setComponentPopupMenu(jPopupMenu);
        jPanel2.add(txtOrden);
        txtOrden.setBounds(938, 216, 40, 27);

        txtFoto.setComponentPopupMenu(jPopupMenu);
        jPanel2.add(txtFoto);
        txtFoto.setBounds(124, 261, 392, 27);

        txtFotoDet1.setComponentPopupMenu(jPopupMenu);
        jPanel2.add(txtFotoDet1);
        txtFotoDet1.setBounds(599, 261, 386, 27);

        txtFotoDet2.setComponentPopupMenu(jPopupMenu);
        jPanel2.add(txtFotoDet2);
        txtFotoDet2.setBounds(124, 309, 392, 27);

        txtFotoDet3.setComponentPopupMenu(jPopupMenu);
        jPanel2.add(txtFotoDet3);
        txtFotoDet3.setBounds(599, 309, 386, 27);

        cmbCemento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N", "-" }));
        jPanel2.add(cmbCemento);
        cmbCemento.setBounds(124, 354, 111, 27);

        cmbVidrio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N", "-" }));
        jPanel2.add(cmbVidrio);
        cmbVidrio.setBounds(326, 354, 103, 27);

        cmbParafina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N", "-" }));
        jPanel2.add(cmbParafina);
        cmbParafina.setBounds(502, 354, 110, 27);

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cmbProveedor);
        cmbProveedor.setBounds(124, 406, 488, 27);

        jLabel21.setText("Código:");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(50, 30, 70, 30);

        txtId.setComponentPopupMenu(jPopupMenu);
        jPanel2.add(txtId);
        txtId.setBounds(124, 32, 148, 27);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(null);

        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });
        jPanel4.add(btnRegistrar);
        btnRegistrar.setBounds(20, 30, 90, 70);

        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });
        jPanel4.add(btnLimpiar);
        btnLimpiar.setBounds(20, 150, 90, 70);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(1050, 80, 130, 270);

        jTabbedPane1.addTab("Nuevo / Modificar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1262, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescAbrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescAbrevActionPerformed
    }//GEN-LAST:event_txtDescAbrevActionPerformed

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        LimpiarElementos();
        txtId.setEditable(true);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        int row = jtProducto.getSelectedRow();
        txtId.setText(String.valueOf(jtProducto.getValueAt(row, 0)));
        txtDescripcion.setText(String.valueOf(jtProducto.getValueAt(row, 3)));
        txtDescAbrev.setText(String.valueOf(jtProducto.getValueAt(row, 4)));
        txtCantidad.setText(String.valueOf(jtProducto.getValueAt(row, 8)));
        txtCantMin.setText(String.valueOf(jtProducto.getValueAt(row, 9)));
        cmbEstado.setSelectedItem(String.valueOf(jtProducto.getValueAt(row, 2)));
        cmbCategoria.setSelectedItem(String.valueOf(jtProducto.getValueAt(row, 5)));
        txtPrecioMayor.setText(String.valueOf(jtProducto.getValueAt(row, 6)));
        txtPrecioMenor.setText(String.valueOf(jtProducto.getValueAt(row, 7)));
        cmbVisible.setSelectedItem(String.valueOf(jtProducto.getValueAt(row, 11)));
        txtOrden.setText(String.valueOf(jtProducto.getValueAt(row, 12)));
        txtFoto.setText(String.valueOf(jtProducto.getValueAt(row, 10)));
        txtFotoDet1.setText(String.valueOf(jtProducto.getValueAt(row, 13)));
        txtFotoDet2.setText(String.valueOf(jtProducto.getValueAt(row, 14)));        
        txtFotoDet3.setText(String.valueOf(jtProducto.getValueAt(row, 15)));
        cmbCemento.setSelectedItem(String.valueOf(jtProducto.getValueAt(row, 16)));
        cmbVidrio.setSelectedItem(String.valueOf(jtProducto.getValueAt(row, 17)));
        cmbParafina.setSelectedItem(String.valueOf(jtProducto.getValueAt(row, 18)));        
        cmbProveedor.setSelectedItem(String.valueOf(jtProducto.getValueAt(row, 19))); 
        txtId.setEditable(false);

        jTabbedPane1.setSelectedIndex(1); 
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

        int row = jtProducto.getSelectedRow();
        int rptaElimina = JOptionPane.showConfirmDialog(null, "Desea eliminar el producto: " + String.valueOf(jtProducto.getValueAt(row, 1) + "?"));
        if (rptaElimina==0) {
            producto.eliminarProducto(String.valueOf(jtProducto.getValueAt(row, 0)));
            tprod.visualizarProducto(jtProducto, (String)cmbBusEst.getSelectedItem(), (String)cmbBusCat.getSelectedItem());  
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMouseClicked
        tprod.visualizarProducto(jtProducto, (String)cmbBusEst.getSelectedItem(), (String)cmbBusCat.getSelectedItem());  
    }//GEN-LAST:event_btnListarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        LimpiarElementos();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void jtProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductoMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            //handle double click event.
            SingletonProperties sp=SingletonProperties.getInstancia();
            String path_prod= sp.getPropiedad("path_fotos_prod");

            frmListaPedidos.txtProd.setText(String.valueOf(jtProducto.getValueAt(jtProducto.getSelectedRow(), 0)));
            frmListaPedidos.txtPrecio.setText(String.valueOf(jtProducto.getValueAt(jtProducto.getSelectedRow(), 7)));
            String prod = String.valueOf(jtProducto.getValueAt(jtProducto.getSelectedRow(), 0));
            String url = path_prod+prod+".jpg";
            String notFoundUrl = path_prod + "noEncontrada.png";
            File fotoAp = new File(url);
            if(fotoAp.isFile()){
                ImageIcon icon = new ImageIcon(url);  
                frmListaPedidos.lblProdFoto.setIcon(icon);  
            } else {
                ImageIcon icon = new ImageIcon(notFoundUrl);  
                frmListaPedidos.lblProdFoto.setIcon(icon);  
            }    
            frmListaPedidos.cmbCemento.setSelectedItem(String.valueOf(jtProducto.getValueAt(jtProducto.getSelectedRow(), 16)));
            frmListaPedidos.cmbVidrio.setSelectedItem(String.valueOf(jtProducto.getValueAt(jtProducto.getSelectedRow(), 17)));
            frmListaPedidos.cmbParafina.setSelectedItem(String.valueOf(jtProducto.getValueAt(jtProducto.getSelectedRow(), 18)));            
            // Calcular total SPD
            double cantidad=Double.parseDouble(frmListaPedidos.txtCant.getText());
            double precio=Double.parseDouble(frmListaPedidos.txtPrecio.getText());
            double total= cantidad*precio;
            frmListaPedidos.txtTotalSpd.setText(""+total); 
            
            this.dispose();
        }
    }//GEN-LAST:event_jtProductoMouseClicked

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked

        if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El código de producto es obligatorio!");
            } else {
               String prod = producto.listProductoxid(txtId.getText());
                String id = txtId.getText();
                String descripcion = txtDescripcion.getText();
                String descAbrev = txtDescAbrev.getText();
                String estado = (String)cmbEstado.getSelectedItem();
                String categoria = (String)cmbCategoria.getSelectedItem();
                String precioMayor = txtPrecioMayor.getText();
                String precioMenor = txtPrecioMenor.getText();
                String cantidad = txtCantidad.getText();
                String cantMin = txtCantMin.getText();
                String foto = txtFoto.getText();
                String visible = (String)cmbVisible.getSelectedItem();
                String orden = txtOrden.getText();
                String fotoDet1 = txtFotoDet1.getText();
                String fotoDet2 = txtFotoDet2.getText();
                String fotoDet3 = txtFotoDet3.getText();
                String cemento = (String)cmbCemento.getSelectedItem();
                String vidrio = (String)cmbVidrio.getSelectedItem();            
                String parafina = (String)cmbParafina.getSelectedItem();            
                String proveedor = (String)cmbProveedor.getSelectedItem();                        
                String usuario_creacion = "admin";
                String usuario_ult_mod = "admin";
                if (prod.equals("")) {

                    String rptaRegistro = producto.insertProducto(id, estado, descripcion, descAbrev, categoria, precioMayor, precioMenor, cantidad, cantMin, foto, visible, orden, fotoDet1, fotoDet2, fotoDet3, cemento, vidrio, parafina, proveedor, usuario_creacion, usuario_ult_mod);

                    if (rptaRegistro != null) {
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                        LimpiarElementos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Registro erroneo.");                
                    }
               } else {
                    int rptaEdita = JOptionPane.showConfirmDialog(null, "Desea modificar el producto");
                    if (rptaEdita==0) {
                        int rptaEdit = producto.editarProducto(id, estado, descripcion, descAbrev, categoria, precioMayor, precioMenor, cantidad, cantMin, foto, visible, orden, fotoDet1, fotoDet2, fotoDet3, cemento, vidrio, parafina, proveedor, usuario_ult_mod); 
                        if (rptaEdit <= 0) {
                            JOptionPane.showMessageDialog(null, "No se pudo realizar la edición.");
                        }
               } 
            }
            tprod.visualizarProducto(jtProducto, (String)cmbBusEst.getSelectedItem(), (String)cmbBusCat.getSelectedItem());  
            jTabbedPane1.setSelectedIndex(0); 
        }
    }//GEN-LAST:event_btnRegistrarMouseClicked

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
    public javax.swing.JComboBox<String> cmbBusCat;
    public javax.swing.JComboBox<String> cmbBusEst;
    public javax.swing.JComboBox<String> cmbCategoria;
    public javax.swing.JComboBox<String> cmbCemento;
    public javax.swing.JComboBox<String> cmbEstado;
    public javax.swing.JComboBox<String> cmbParafina;
    public javax.swing.JComboBox<String> cmbProveedor;
    public javax.swing.JComboBox<String> cmbVidrio;
    public javax.swing.JComboBox<String> cmbVisible;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jtProducto;
    public javax.swing.JTextField txtCantMin;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtDescAbrev;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtFoto;
    public javax.swing.JTextField txtFotoDet1;
    public javax.swing.JTextField txtFotoDet2;
    public javax.swing.JTextField txtFotoDet3;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtOrden;
    public javax.swing.JTextField txtPrecioMayor;
    public javax.swing.JTextField txtPrecioMenor;
    // End of variables declaration//GEN-END:variables
}
