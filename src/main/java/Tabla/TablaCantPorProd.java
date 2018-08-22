package Tabla;

import Modelo.ListaPedidoDAO;
import Modelo.SingletonProperties;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TablaCantPorProd {

    ListaPedidoDAO dao = null;

    public void visualizarPorProd(JTable tabla){
  
        tabla.setDefaultRenderer (Object.class, new MyRender());
//        tabla.setDefaultRenderer (Object.class, new Render());
        
        DefaultTableModel modeloT = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    

        tabla.setModel(modeloT);
        modeloT.addColumn("Producto");
        modeloT.addColumn("Cantidad");

        dao = new ListaPedidoDAO();
        Object[][] cantxprod;
        cantxprod = dao.listCantPorProd();

        Object[] columna = new Object[2];
        
        for (int i=0;i<cantxprod.length;i++){
            for(int j=0;j<2;j++){
                columna[j] = cantxprod[i][j];
            }
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
        
        tablaD.getColumnModel().getColumn(0).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(100);
        // Centrar header
        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tablaD.getSelectionModel().setSelectionInterval (0, 0);
    }    
}
