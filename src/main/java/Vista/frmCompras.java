package Vista;

import Modelo.ComprasDAO;
import Modelo.SingletonProperties;
import Tabla.TablaCompra;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class frmCompras extends javax.swing.JInternalFrame {

    JTextField clipboard;
    String ori; 
    TablaCompra tcom = new TablaCompra();
    ComprasDAO compra = new ComprasDAO();
    int clic_tabla = 0;
    
    public frmCompras(String origen) {
        initComponents();
        // Inicializo componentes
        SingletonProperties sp=SingletonProperties.getInstancia();
        String path_icon= sp.getPropiedad("path_img_iconos");

        btnListar.setIcon(new ImageIcon(path_icon+"busqueda_peque.png"));
        btnNuevo.setIcon(new ImageIcon(path_icon+"nuevo_peque.png"));
        btnModificar.setIcon(new ImageIcon(path_icon+"editar_peque.png"));
        btnEliminar.setIcon(new ImageIcon(path_icon+"eliminar_peque.png"));
        btnBusInsumo.setIcon(new ImageIcon(path_icon+"busqueda_peque.png"));
        btnRegistrar.setIcon(new ImageIcon(path_icon+"guardar_peque.png"));
        btnLimpiar.setIcon(new ImageIcon(path_icon+"limpiar_peque.png"));
        
        ori = origen;    

        cmbCategoria.removeAllItems();
        cmbBusCat.removeAllItems();
        cmbProveedor.removeAllItems();
        cmbBusProv.removeAllItems();
        cmbInsumo.removeAllItems();

        cmbBusCat.addItem("*");
        ArrayList<String> categorias = new ArrayList<String>();
        categorias = compra.Llenar_cmbCategoria();
        for (int i=0; i<categorias.size();i++){
            cmbCategoria.addItem(categorias.get(i));
            cmbBusCat.addItem(categorias.get(i));
        }

        cmbBusProv.addItem("*");
        ArrayList<String> proveedores = new ArrayList<String>();
        proveedores = compra.Llenar_cmbProveedor();
        for (int i=0; i<proveedores.size();i++){
            cmbProveedor.addItem(proveedores.get(i));
            cmbBusProv.addItem(proveedores.get(i));
        }

        ArrayList<String> insumos = new ArrayList<String>();
        insumos = compra.Llenar_cmbInsumos();
        for (int i=0; i<insumos.size();i++){
            cmbInsumo.addItem(insumos.get(i));
        }
        
        txtCantidad.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtCantidad.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtCantidad.getText().length()==0) {
                    txtCantidad.setText("0");
                }
                calculaTotal();
            }
        });

        txtPrecio.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtPrecio.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtPrecio.getText().length()==0) {
                    txtPrecio.setText("0");
                }
                calculaTotal();
            }
        });

        tcom.visualizarCompra(jtCompra,(String)cmbBusCat.getSelectedItem(), (String)cmbBusProv.getSelectedItem());  
        jTabbedPane1.setEnabledAt(1, false);
    }

     public void calculaTotal() {
        double total = 0;
        double cantidad=Double.parseDouble(txtCantidad.getText());
        double precio=Double.parseDouble(txtPrecio.getText());
        total = cantidad*precio;
        txtTotal.setText(""+total); 
     }
    
    public void LimpiarElementos () {
//        txtId.setText("");
        Calendar hoy = new GregorianCalendar();
        dtFechaCompra.setCalendar(hoy);
        cmbInsumo.setSelectedItem("Florero cristina");
        cmbCategoria.setSelectedItem("Vidrio");   
        txtCantidad.setText("1");
        txtPrecio.setText("1");        
        txtTotal.setText("1");                
        cmbProveedor.setSelectedItem("Arte Glass");           
        txtObs.setText("");                        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cmbBusCat = new javax.swing.JComboBox<>();
        btnListar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbBusProv = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCompra = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbInsumo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox<>();
        txtObs = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        dtFechaCompra = new com.toedter.calendar.JDateChooser();
        btnBusInsumo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Compras");
        getContentPane().setLayout(null);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));
        jPanel3.setLayout(null);

        cmbBusCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cmbBusCat);
        cmbBusCat.setBounds(100, 30, 280, 27);

        btnListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarMouseClicked(evt);
            }
        });
        jPanel3.add(btnListar);
        btnListar.setBounds(1010, 20, 60, 50);

        jLabel10.setText("Categoria:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(10, 27, 80, 30);

        jLabel11.setText("Proveedor:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(480, 30, 100, 30);

        cmbBusProv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cmbBusProv);
        cmbBusProv.setBounds(570, 30, 380, 27);

        jtCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtCompra);

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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Compras", jPanel1);

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos compra"));
        jPanel4.setLayout(null);

        jLabel1.setText("Id:");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(18, 34, 40, 17);

        jLabel2.setText("Fecha:");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(18, 77, 70, 17);

        txtId.setEditable(false);
        jPanel4.add(txtId);
        txtId.setBounds(113, 29, 160, 27);

        jLabel3.setText("Insumo:");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(20, 130, 80, 17);

        cmbInsumo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cmbInsumo);
        cmbInsumo.setBounds(115, 130, 430, 27);

        jLabel4.setText("Cantidad:");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(18, 189, 90, 17);

        jLabel5.setText("Precio:");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(350, 190, 60, 17);

        jLabel6.setText("Total:");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(714, 189, 60, 17);
        jPanel4.add(txtCantidad);
        txtCantidad.setBounds(120, 180, 130, 27);
        jPanel4.add(txtPrecio);
        txtPrecio.setBounds(420, 180, 112, 27);
        jPanel4.add(txtTotal);
        txtTotal.setBounds(766, 184, 138, 27);

        jLabel7.setText("Proveedor:");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(18, 234, 100, 17);

        jLabel8.setText("Ovservación:");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(18, 279, 110, 17);

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cmbProveedor);
        cmbProveedor.setBounds(114, 229, 790, 27);
        jPanel4.add(txtObs);
        txtObs.setBounds(119, 274, 785, 27);

        jLabel9.setText("Categoria:");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(714, 127, 100, 17);

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cmbCategoria);
        cmbCategoria.setBounds(798, 122, 106, 27);
        jPanel4.add(dtFechaCompra);
        dtFechaCompra.setBounds(113, 77, 184, 27);

        btnBusInsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBusInsumoMouseClicked(evt);
            }
        });
        jPanel4.add(btnBusInsumo);
        btnBusInsumo.setBounds(560, 120, 60, 50);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(263, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nueva / Modificar", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 1269, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked

        String id = txtId.getText();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaCompra = formatoFecha.format(dtFechaCompra.getDate());
        String insumo = (String)cmbInsumo.getSelectedItem();
        String categoria = (String)cmbCategoria.getSelectedItem();
        String cantidad = txtCantidad.getText();
        String precio = txtPrecio.getText();
        String total = txtTotal.getText();
        String proveedor = (String)cmbProveedor.getSelectedItem();
        String observacion = txtObs.getText();
        String usuario_creacion = "admin";
        String usuario_ult_mod = "admin";

        if (txtId.getText().length()==0) {
            compra = new ComprasDAO();

            String rptaRegistro = compra.insertCompra(fechaCompra, insumo, categoria, cantidad, precio, total, proveedor, observacion, usuario_creacion, usuario_ult_mod);

            if (rptaRegistro != null) {
                tcom.visualizarCompra(jtCompra, "*", "*");
                LimpiarElementos();
                jTabbedPane1.setEnabledAt(1, false);                
                jTabbedPane1.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erroneo.");
            }
        } else {
            // Modificar
            int rptaEdita = JOptionPane.showConfirmDialog(null, "Desea modificar la compra: " + txtId.getText() + "?");
            if (rptaEdita==0) {

                int rptaEdit = compra.editarCompra(id, fechaCompra, insumo, categoria, cantidad, precio, total, proveedor, observacion, usuario_ult_mod);

                if (rptaEdit <= 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la edición.");
                } else {
                    tcom.visualizarCompra(jtCompra, "*", "*");
                    jTabbedPane1.setEnabledAt(1, false);
                    txtId.setText("");
                    LimpiarElementos();
                    jTabbedPane1.setSelectedIndex(0);
                }
            } else {

            }
        }
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        LimpiarElementos ();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        LimpiarElementos();
        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        int row = jtCompra.getSelectedRow();
        txtId.setText(String.valueOf(jtCompra.getValueAt(row, 0)));
        try {
            Date fechaParseada= new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(jtCompra.getValueAt(row, 1)));            
            dtFechaCompra.setDate(fechaParseada);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        cmbInsumo.setSelectedItem(String.valueOf(jtCompra.getValueAt(row, 2)));
        cmbCategoria.setSelectedItem(String.valueOf(jtCompra.getValueAt(row, 3)));
        txtCantidad.setText(String.valueOf(jtCompra.getValueAt(row, 4)));
        txtPrecio.setText(String.valueOf(jtCompra.getValueAt(row, 5)));
        txtTotal.setText(String.valueOf(jtCompra.getValueAt(row, 6)));        
        cmbProveedor.setSelectedItem(String.valueOf(jtCompra.getValueAt(row, 7)));
        txtObs.setText(String.valueOf(jtCompra.getValueAt(row, 8)));

        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

/*        int row = jtCliente.getSelectedRow();
        int rptaElimina = JOptionPane.showConfirmDialog(null, "Desea eliminar el cliente: " + String.valueOf(jtCliente.getValueAt(row, 1) + "?"));
        if (rptaElimina==0) {
            cliente.eliminarCliente(String.valueOf(jtCliente.getValueAt(row, 0)));
            tcli.visualizarCliente(jtCliente, "", "", "");
        }
*/
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMouseClicked
        tcom.visualizarCompra(jtCompra, (String)cmbBusCat.getSelectedItem(), (String)cmbBusProv.getSelectedItem());
    }//GEN-LAST:event_btnListarMouseClicked

    private void btnBusInsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusInsumoMouseClicked
        frmMateriales materiales = new frmMateriales("compra");

        frmPrincipal.Escritorio.add(materiales);
        try {
            materiales.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        materiales.toFront();
        materiales.setVisible(true);
    
    }//GEN-LAST:event_btnBusInsumoMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        if (jTabbedPane1.getSelectedIndex()==0) {
            jTabbedPane1.setEnabledAt(1, false);
            txtId.setText("");
            LimpiarElementos();
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBusInsumo;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnListar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JComboBox<String> cmbBusCat;
    public javax.swing.JComboBox<String> cmbBusProv;
    public static javax.swing.JComboBox<String> cmbCategoria;
    public static javax.swing.JComboBox<String> cmbInsumo;
    public static javax.swing.JComboBox<String> cmbProveedor;
    public com.toedter.calendar.JDateChooser dtFechaCompra;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jtCompra;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtObs;
    public javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
