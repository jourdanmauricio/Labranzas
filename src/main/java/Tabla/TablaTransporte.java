package Tabla;

import Modelo.SingletonProperties;
import Modelo.Transporte;
import Modelo.TransporteDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TablaTransporte {

    TransporteDAO dao = null;

    public void visualizarTransporte(JTable tabla, String busRazonSocial, String busProvincia){

        DefaultTableModel modeloT = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        tabla.setModel(modeloT);
        modeloT.addColumn("Id"); 
        modeloT.addColumn("Razon social");
        modeloT.addColumn("Domicilio");
        modeloT.addColumn("Barrio");
        modeloT.addColumn("Remito");
        modeloT.addColumn("Web");
        modeloT.addColumn("Telefono");
        modeloT.addColumn("Mail");
        modeloT.addColumn("Provincia");  

        dao = new TransporteDAO();
        Transporte transporte = new Transporte();
        ArrayList<Transporte> transportes;

        transportes = dao.listTransporte(busRazonSocial, busProvincia);            
            
        Object[] columna = new Object[9];
        Iterator<Transporte> itrTransportes = transportes.iterator();         
        
        while (itrTransportes.hasNext()) {             
            transporte = itrTransportes.next();
            
            columna[0] = transporte.getId();
            columna[1] = transporte.getRazon_social();
            columna[2] = transporte.getDomicilio();
            columna[3] = transporte.getBarrio();
            columna[4] = transporte.getRemito();
            columna[5] = transporte.getWeb();
            columna[6] = transporte.getTelefono();
            columna[7] = transporte.getMail();
            columna[8] = transporte.getProvincia();
            
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
        tablaD.getColumnModel().getColumn(4).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(0).setPreferredWidth(40);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(180);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(120);
        tablaD.getColumnModel().getColumn(4).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(6).setPreferredWidth(170);
        tablaD.getColumnModel().getColumn(7).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(8).setPreferredWidth(120);
        
        // Centrar header
        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tablaD.getSelectionModel().setSelectionInterval (0, 0);
        tablaD.setRowHeight(30);
    }
    
}
