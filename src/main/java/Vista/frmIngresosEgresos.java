package Vista;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.jfree.chart.plot.PlotOrientation;
import Tabla.TablaIngresosEgresos;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class frmIngresosEgresos extends javax.swing.JInternalFrame {

    TablaIngresosEgresos tie = new TablaIngresosEgresos();
    
    public frmIngresosEgresos() {
        initComponents();
        tie.visualizarIngresosEgresos(jtIngresosEgresos);  
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtIngresosEgresos = new javax.swing.JTable();
        panelGraficoTorta = new javax.swing.JPanel();
        lblTorta = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Ingresos - Egresos");
        setToolTipText("");

        jtIngresosEgresos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtIngresosEgresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtIngresosEgresosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtIngresosEgresos);

        panelGraficoTorta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelGraficoTorta.setLayout(null);
        panelGraficoTorta.add(lblTorta);
        lblTorta.setBounds(0, 0, 740, 320);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelGraficoTorta, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(364, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelGraficoTorta, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtIngresosEgresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtIngresosEgresosMouseClicked

        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            //handle double click event.

            JFreeChart linea = null;
            XYSeriesCollection dataset = new XYSeriesCollection();
            XYSeries series1 = new XYSeries("Ingresos");
            XYSeries series2 = new XYSeries("Egresos");

            int row = jtIngresosEgresos.getSelectedRow();

            String anio = String.valueOf(jtIngresosEgresos.getValueAt(row, 0));
            String movimiento;

            for (int i = 0; i < jtIngresosEgresos.getRowCount(); i++) {
                movimiento = String.valueOf(jtIngresosEgresos.getValueAt(i, 1));
                if (anio.equals(String.valueOf(jtIngresosEgresos.getValueAt(i, 0))) && movimiento.equals(String.valueOf(jtIngresosEgresos.getValueAt(i, 1)))) {
                    for (int j=2;j<14;j++) {
                        if (movimiento.equals("Ingresos")) {
                            Double dato = Double.parseDouble(String.valueOf(jtIngresosEgresos.getValueAt(i, j)));
                            series1.add(j-1,dato);
                        }
                        if (movimiento.equals("Egresos")) {
                            Double dato = Double.parseDouble(String.valueOf(jtIngresosEgresos.getValueAt(i, j)));
                            series2.add(j-1,dato);
                        }
                    }
                }
            }
            dataset.addSeries(series1);
            dataset.addSeries(series2);

            linea = ChartFactory.createXYLineChart("Ingresos - Egresos por año","Meses","Montos",dataset,PlotOrientation.VERTICAL,true,true,true);

            BufferedImage graficoLinea=linea.createBufferedImage(panelGraficoTorta.getWidth(), panelGraficoTorta.getHeight());

            lblTorta.setSize(panelGraficoTorta.getSize());
            lblTorta.setIcon(new ImageIcon(graficoLinea));

            panelGraficoTorta.updateUI();
        }
    }//GEN-LAST:event_jtIngresosEgresosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtIngresosEgresos;
    public javax.swing.JLabel lblTorta;
    private javax.swing.JPanel panelGraficoTorta;
    // End of variables declaration//GEN-END:variables
}
