package Vista;

import Modelo.RespuestaMLDAO;
import Modelo.SingletonProperties;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class frmRespuestasML extends javax.swing.JInternalFrame {
    
    RespuestaMLDAO respuesta = new RespuestaMLDAO();
    JTextArea clipboard;
    
    public frmRespuestasML() {
        initComponents();
        
        cmbId.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                
                String resp = respuesta.Llenar_txaRespuesta((String)cmbId.getSelectedItem());
                txaResp.setText(resp);
            }
        });
        
        SingletonProperties sp=SingletonProperties.getInstancia();
        String path_icon= sp.getPropiedad("path_img_iconos");

        btnInsertar.setIcon(new ImageIcon(path_icon+"guardar_peque.png"));
        btnCopiar.setIcon(new ImageIcon(path_icon+"copiar_peque.png"));
        btnGuardar.setIcon(new ImageIcon(path_icon+"editar_peque.png"));
        btnEliminar.setIcon(new ImageIcon(path_icon+"eliminar_peque.png"));
        
        cmbId.removeAllItems();
        ArrayList<String> id = new ArrayList();
        id = respuesta.Llenar_cmbId();
        for (int i=0; i<id.size();i++){
            cmbId.addItem(id.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu = new javax.swing.JPopupMenu();
        jMCopy = new javax.swing.JMenuItem();
        jMPaste = new javax.swing.JMenuItem();
        jMCut = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaResp = new javax.swing.JTextArea();
        txtId = new javax.swing.JTextField();
        cmbId = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaNuevaResp = new javax.swing.JTextArea();
        btnInsertar = new javax.swing.JButton();
        btnCopiar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        jMCopy.setText("Copy");
        jMCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCopyActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMCopy);

        jMPaste.setText("Paste");
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
        setTitle("Respuestas Mercado Libre");
        getContentPane().setLayout(null);

        jLabel1.setText("Id: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(32, 32, 38, 17);

        txaResp.setColumns(20);
        txaResp.setRows(5);
        txaResp.setComponentPopupMenu(jPopupMenu);
        jScrollPane1.setViewportView(txaResp);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(58, 260, 760, 87);

        txtId.setComponentPopupMenu(jPopupMenu);
        getContentPane().add(txtId);
        txtId.setBounds(82, 27, 143, 27);

        cmbId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbId);
        cmbId.setBounds(90, 200, 300, 27);

        jLabel2.setText("Id:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 197, 40, 30);

        txaNuevaResp.setColumns(20);
        txaNuevaResp.setRows(5);
        txaNuevaResp.setComponentPopupMenu(jPopupMenu);
        jScrollPane2.setViewportView(txaNuevaResp);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(56, 81, 760, 87);

        btnInsertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertarMouseClicked(evt);
            }
        });
        getContentPane().add(btnInsertar);
        btnInsertar.setBounds(840, 80, 50, 50);

        btnCopiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCopiarMouseClicked(evt);
            }
        });
        btnCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCopiar);
        btnCopiar.setBounds(840, 260, 50, 50);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(null);

        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(180, 20, 60, 50);

        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(30, 20, 60, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(550, 370, 270, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarMouseClicked

        if (txtId.getText().length()==0 && txaNuevaResp.getText().length()==0) {
            JOptionPane.showMessageDialog(null, "Debe completar el ID de respuesta!");
        } else {
            String id = txtId.getText();
            String resp = txaNuevaResp.getText();

            String rptaRegistro = respuesta.insertarRespuesta (id, resp);

            if (rptaRegistro != null) {
                cmbId.addItem(id);
                cmbId.setSelectedItem(id);
                txaResp.setText(txaNuevaResp.getText());
                txtId.setText("");
                txaNuevaResp.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Registro erroneo.");
            }        
        }
    }//GEN-LAST:event_btnInsertarMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        String id = (String)cmbId.getSelectedItem();
        int rptaEdita = JOptionPane.showConfirmDialog(null, "Desea modificar la respuesta: " + id + "?");
        if (rptaEdita==0) {
            String resp = txaResp.getText();

            int rptaEdit = respuesta.editarRespuesta(id, resp);

            if (rptaEdit <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la edición.");
            }
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        String id = (String)cmbId.getSelectedItem();
        int rptaElimina = JOptionPane.showConfirmDialog(null, "Desea eliminar la respuesta: " + id + "?");
        if (rptaElimina==0) {
            respuesta.eliminarRespuesta(id);
            cmbId.removeItem(id);
            txaResp.setText("");
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void jMCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCopyActionPerformed
        clipboard = (JTextArea) jPopupMenu.getInvoker();
        clipboard.copy();
    }//GEN-LAST:event_jMCopyActionPerformed

    private void jMPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMPasteActionPerformed
        clipboard = (JTextArea) jPopupMenu.getInvoker();
        clipboard.paste();
    }//GEN-LAST:event_jMPasteActionPerformed

    private void jMCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCutActionPerformed
        clipboard = (JTextArea) jPopupMenu.getInvoker();
        clipboard.cut();
    }//GEN-LAST:event_jMCutActionPerformed

    private void btnCopiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCopiarMouseClicked

    }//GEN-LAST:event_btnCopiarMouseClicked

    private void btnCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarActionPerformed
        txaResp.selectAll();
        clipboard = txaResp;
        clipboard.copy();
    }//GEN-LAST:event_btnCopiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCopiar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnInsertar;
    public javax.swing.JComboBox<String> cmbId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMCopy;
    private javax.swing.JMenuItem jMCut;
    private javax.swing.JMenuItem jMPaste;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea txaNuevaResp;
    public javax.swing.JTextArea txaResp;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
