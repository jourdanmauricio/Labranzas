package Vista;

import Modelo.PendientesDAO;
import Modelo.SingletonProperties;
import Tabla.TablaPendientes;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable.PrintMode;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class frmPendientes extends javax.swing.JInternalFrame {

    TablaPendientes tpen = new TablaPendientes();
    PendientesDAO pen = new PendientesDAO();
    private JLabel label1,label2;
        
    public frmPendientes() {
        initComponents();

        // Inicializo componentes
        SingletonProperties sp=SingletonProperties.getInstancia();
        String path_icon= sp.getPropiedad("path_img_iconos");

        btnListar.setIcon(new ImageIcon(path_icon+"busqueda_peque.png"));
        btnImprimir.setIcon(new ImageIcon(path_icon+"imprimir_peque.png"));
        btnGuardar.setIcon(new ImageIcon(path_icon+"guardar_peque.png"));

        tpen.visualizarPendientes(jtPendientes, (String)cmbSector.getSelectedItem());  

        int rowPendientes = jtPendientes.getSelectedRow();    
        txtPedido.setText(String.valueOf(jtPendientes.getValueAt(rowPendientes, 0)));
        txtSpd.setText(String.valueOf(jtPendientes.getValueAt(rowPendientes, 1)));                    
        cmbCemento.setSelectedItem(String.valueOf(jtPendientes.getValueAt(rowPendientes, 6)));
        cmbVidrio.setSelectedItem(String.valueOf(jtPendientes.getValueAt(rowPendientes, 7)));        
        cmbParafina.setSelectedItem(String.valueOf(jtPendientes.getValueAt(rowPendientes, 8)));
        
        // Agrego change al jtable
        ListSelectionModel rowSM = jtPendientes.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //Ignore extra messages.
                if (e.getValueIsAdjusting()) return;
                ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if (lsm.isSelectionEmpty()) {
                    //no rows are selected
                } else {
                    int row = lsm.getMinSelectionIndex();
                    //selectedRow is selected
                    int rowPendientes = jtPendientes.getSelectedRow();   
                    txtPedido.setText(String.valueOf(jtPendientes.getValueAt(rowPendientes, 0)));
                    txtSpd.setText(String.valueOf(jtPendientes.getValueAt(rowPendientes, 1)));                    
                    cmbCemento.setSelectedItem(String.valueOf(jtPendientes.getValueAt(rowPendientes, 6)));
                    cmbVidrio.setSelectedItem(String.valueOf(jtPendientes.getValueAt(rowPendientes, 7)));        
                    cmbParafina.setSelectedItem(String.valueOf(jtPendientes.getValueAt(rowPendientes, 8)));
                } 
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtPendientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbSector = new javax.swing.JComboBox<>();
        btnListar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtPedido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSpd = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbCemento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbVidrio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbParafina = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pendientes de vidrio, cemento y parafina");
        getContentPane().setLayout(null);

        jtPendientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtPendientes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 102, 1140, 410);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));
        jPanel1.setLayout(null);

        jLabel1.setText("Pendiente:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(18, 34, 76, 17);

        cmbSector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cemento", "Vidrio", "Parafina" }));
        jPanel1.add(cmbSector);
        cmbSector.setBounds(106, 29, 286, 27);

        btnListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarMouseClicked(evt);
            }
        });
        jPanel1.add(btnListar);
        btnListar.setBounds(1044, 17, 60, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 1140, 80);

        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(970, 540, 60, 50);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido"));

        jLabel5.setText("Pedido:");

        txtPedido.setEditable(false);

        jLabel6.setText("Sub pedido:");

        txtSpd.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtSpd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtSpd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 530, 380, 70);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sectores"));

        jLabel2.setText("Cemento:");

        cmbCemento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N", "-" }));

        jLabel3.setText("Vidrio:");

        cmbVidrio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N", "-" }));

        jLabel4.setText("Parafina:");

        cmbParafina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N", "-" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(cmbCemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(cmbVidrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(cmbParafina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbCemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbVidrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbParafina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(410, 530, 490, 70);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImprimirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(1180, 110, 100, 250);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMouseClicked
        tpen.visualizarPendientes(jtPendientes, (String)cmbSector.getSelectedItem());  
    }//GEN-LAST:event_btnListarMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

        String pedido = txtPedido.getText();
        String subPedido = txtSpd.getText();
        String cemento = (String)cmbCemento.getSelectedItem();
        String vidrio = (String)cmbVidrio.getSelectedItem();
        String parafina = (String)cmbParafina.getSelectedItem();
        String usuario_ult_mod = "admin";
                
        if (pen.editarSpd(pedido, subPedido, cemento, vidrio, parafina, usuario_ult_mod)) {  // Si el método "actualizar" retorna true
            JOptionPane.showMessageDialog(null, "El sub_pedido ha sido actualizado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error!, no se ha podido actualizar el sub_pedido.", "Error", JOptionPane.ERROR_MESSAGE);
        }        
        tpen.visualizarPendientes(jtPendientes, (String)cmbSector.getSelectedItem());  
        
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseClicked

        try {
            MessageFormat headerFormat = new MessageFormat("Listado pendientes: " + (String)cmbSector.getSelectedItem());
            MessageFormat footerFormat = new MessageFormat("- Página {0} -");
            jtPendientes.print(PrintMode.FIT_WIDTH, headerFormat, footerFormat);
                    
           } catch (PrinterException ex) {
               JOptionPane.showMessageDialog(null, "No se ha podido imprimir correctamente, intentalo más tarde.");
           }                 
    }//GEN-LAST:event_btnImprimirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnImprimir;
    public javax.swing.JButton btnListar;
    public javax.swing.JComboBox<String> cmbCemento;
    public javax.swing.JComboBox<String> cmbParafina;
    public javax.swing.JComboBox<String> cmbSector;
    public javax.swing.JComboBox<String> cmbVidrio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtPendientes;
    public javax.swing.JTextField txtPedido;
    public javax.swing.JTextField txtSpd;
    // End of variables declaration//GEN-END:variables
}
