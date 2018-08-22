package Tabla;

import Modelo.IngresosEgresosDAO;
import Modelo.SingletonProperties;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TablaIngresosEgresos {

    IngresosEgresosDAO dao = null;

    public void visualizarIngresosEgresos(JTable tabla){
        
        Double totalAnual=0.0;

        DefaultTableModel modeloT = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        tabla.setModel(modeloT);
        modeloT.addColumn("Año"); 
        modeloT.addColumn("Movimiento");
        modeloT.addColumn("Enero");
        modeloT.addColumn("Febrero");
        modeloT.addColumn("Marzo");
        modeloT.addColumn("Abril");
        modeloT.addColumn("Mayo");
        modeloT.addColumn("Junio");
        modeloT.addColumn("Julio");
        modeloT.addColumn("Agosto");
        modeloT.addColumn("Septiembre");
        modeloT.addColumn("Octubre");
        modeloT.addColumn("Noviembre");
        modeloT.addColumn("Diciembre");        
        modeloT.addColumn("Total");        
        
        dao = new IngresosEgresosDAO();
        Object[][] ingEgre;
        ingEgre = dao.listIngresosEgresos();

        Object[] columna = new Object[15];
        
        for (int i=0;i<ingEgre.length;i++){
            for(int j=0;j<ingEgre[0].length;j++){
                columna[j] = ingEgre[i][j];
                if (j>1) {
                    totalAnual = totalAnual + Double.parseDouble(String.valueOf(ingEgre[i][j]));
                }
            }
            columna[14] = totalAnual;
            totalAnual = 0.0;
            modeloT.addRow(columna);
        }        
        SetearVistaTabla(tabla);
    }
    
    public void SetearVistaTabla (JTable tablaD) {

        // Ancho de fila y Scroll 
        SingletonProperties sp=SingletonProperties.getInstancia();
        int ancho_fila =  Integer.parseInt(sp.getPropiedad("ancho_fila"));
        tablaD.setRowHeight(ancho_fila);   
        tablaD.setAutoscrolls(true);
        tablaD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        tablaD.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(4).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(5).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(6).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(7).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(8).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(9).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(10).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(11).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(12).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(13).setCellRenderer(modelocentrar);
        
        tablaD.getColumnModel().getColumn(0).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(100);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(4).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(6).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(7).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(8).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(9).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(10).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(11).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(12).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(13).setPreferredWidth(80);        
        // Centrar header
        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tablaD.getSelectionModel().setSelectionInterval (0, 0);
    }
}
