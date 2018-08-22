package Tabla;

import Modelo.Compras;
import Modelo.ComprasDAO;
import Modelo.SingletonProperties;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TablaCompra {

    ComprasDAO dao = null;

    public void visualizarCompra(JTable tabla, String categoria, String prov){

        DefaultTableModel modeloT = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        tabla.setModel(modeloT);
        modeloT.addColumn("Id");
        modeloT.addColumn("Fecha Compra");
        modeloT.addColumn("Insumo");
        modeloT.addColumn("Categoria");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Precio");
        modeloT.addColumn("Total");
        modeloT.addColumn("Proveedor");
        modeloT.addColumn("Observacion");
        
        dao = new ComprasDAO();
        Compras compra = new Compras();
        ArrayList<Compras> compras;
        compras = dao.listCompra(categoria, prov);            
        int numRegistros = dao.listCompra(categoria, prov).size();

        Object[] columna = new Object[9];
        Iterator<Compras> itrCompras = compras.iterator();         
        
        while (itrCompras.hasNext()) {             
            compra = itrCompras.next();
            
            columna[0] = compra.getId();
            columna[1] = compra.getFecha_compra();
            columna[2] = compra.getInsumo();
            columna[3] = compra.getCategoria();
            columna[4] = compra.getCantidad();
            columna[5] = compra.getPrecio();
            columna[6] = compra.getTotal();
            columna[7] = compra.getProveedor();
            columna[8] = compra.getObservacion();

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
        tablaD.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(4).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(5).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(6).setCellRenderer(modelocentrar);                
        tablaD.getColumnModel().getColumn(0).setPreferredWidth(40);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(110);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(250);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(4).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(6).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(7).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(8).setPreferredWidth(150);
        
        // Centrar header
        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tablaD.getSelectionModel().setSelectionInterval (0, 0);
        
    }
    
    
}
