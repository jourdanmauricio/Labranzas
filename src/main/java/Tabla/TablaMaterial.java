package Tabla;

import Modelo.Material;
import Modelo.MaterialDAO;
import Modelo.SingletonProperties;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TablaMaterial {

    MaterialDAO dao = null;

    public void visualizarMaterial(JTable tabla){

        DefaultTableModel modeloT = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        tabla.setModel(modeloT);
        modeloT.addColumn("Id");
        modeloT.addColumn("Objeto");
        modeloT.addColumn("Descripción");
        modeloT.addColumn("Categoría");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Stock");
        modeloT.addColumn("Stock Min");
        modeloT.addColumn("Stock Max");
        modeloT.addColumn("Proveedor");
        
        dao = new MaterialDAO();
        Material material = new Material();
        ArrayList<Material> materiales;
        materiales = dao.listMaterial();            
        int numRegistros = dao.listMaterial().size();

        Object[] columna = new Object[9];
        Iterator<Material> itrMateriales = materiales.iterator();         
        
        while (itrMateriales.hasNext()) {             
            material = itrMateriales.next();
            
            columna[0] = material.getId();
            columna[1] = material.getObjeto();
            columna[2] = material.getDescripcion();
            columna[3] = material.getCategoria();
            columna[4] = material.getCantidad();
            columna[5] = material.getStock();
            columna[6] = material.getStockMin();
            columna[7] = material.getStockMax();
            columna[8] = material.getProveedor();

            modeloT.addRow(columna);
        }
        SetearVistaTabla(tabla);
    }
    
    public void SetearVistaTabla (JTable tablaD) {

        SingletonProperties sp=SingletonProperties.getInstancia();
        int ancho_fila =  Integer.parseInt(sp.getPropiedad("ancho_fila"));
        tablaD.setRowHeight(ancho_fila);   
        tablaD.setAutoscrolls(true);
        tablaD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        tablaD.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(4).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(5).setCellRenderer(modelocentrar);  
        tablaD.getColumnModel().getColumn(6).setCellRenderer(modelocentrar);  
        tablaD.getColumnModel().getColumn(7).setCellRenderer(modelocentrar);          
        
        tablaD.getColumnModel().getColumn(0).setPreferredWidth(40);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(250);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(250);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(100);
        tablaD.getColumnModel().getColumn(4).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(50);
        tablaD.getColumnModel().getColumn(6).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(7).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(8).setPreferredWidth(240);
        
        // Centrar header
        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tablaD.getSelectionModel().setSelectionInterval (0, 0);
    }

}

