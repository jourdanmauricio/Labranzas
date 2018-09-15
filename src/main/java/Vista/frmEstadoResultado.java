package Vista;

import Tabla.TablaCantPorProd;
import Tabla.TablaPendientesCPV;
import Tabla.TablaResultPorEstado;

public class frmEstadoResultado extends javax.swing.JInternalFrame {

    TablaResultPorEstado trpe = new TablaResultPorEstado();
    TablaCantPorProd tcpp = new TablaCantPorProd();
    TablaPendientesCPV tpcpv = new TablaPendientesCPV();
    
    public frmEstadoResultado() {
        initComponents();
        trpe.visualizarPorEstado(jtPorEstado);
        tcpp.visualizarPorProd(jtCantProd);
        tpcpv.visualizarPorProd(jtPendientesCPV);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPorEstado = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCantProd = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtPendientesCPV = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Estado Actual");
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ventas por estado"));
        jPanel1.setLayout(null);

        jtPorEstado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jtPorEstado);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 320, 211);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 340, 240);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantidad por producto"));
        jPanel2.setLayout(null);

        jtCantProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(jtCantProd);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(20, 20, 220, 540);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(380, 10, 260, 570);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pendientes x material"));
        jPanel3.setLayout(null);

        jtPendientesCPV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane3.setViewportView(jtPendientesCPV);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(20, 20, 380, 540);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(660, 10, 420, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jtCantProd;
    public javax.swing.JTable jtPendientesCPV;
    public javax.swing.JTable jtPorEstado;
    // End of variables declaration//GEN-END:variables
}
