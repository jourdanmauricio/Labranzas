package Tabla;

import Modelo.Geografia;
import Modelo.GeografiaDAO;
import Modelo.SingletonProperties;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


public class TablaGeografia {

    GeografiaDAO dao = null;

    public void visualizarGografia(JTable tabla, String provincia, String localidad){

        DefaultTableModel modeloT = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        tabla.setModel(modeloT);
        modeloT.addColumn("Id");
        modeloT.addColumn("Id provincia");
        modeloT.addColumn("Provincia");
        modeloT.addColumn("Codigo postal");
        modeloT.addColumn("Id Localidad");
        modeloT.addColumn("Localidad");
        
        dao = new GeografiaDAO();
        Geografia geografia = new Geografia();
        ArrayList<Geografia> geografias;
        geografias = dao.listGeografia(provincia, localidad);            
        int numRegistros = dao.listGeografia(provincia, localidad).size();

        Object[] columna = new Object[6];
        Iterator<Geografia> itrGeografia = geografias.iterator();         
        
        while (itrGeografia.hasNext()) {             
            geografia = itrGeografia.next();
            
            columna[0] = geografia.getId();
            columna[1] = geografia.getId_provincia();
            columna[2] = geografia.getProvincia();
            columna[3] = geografia.getCodigo_postal();
            columna[4] = geografia.getId_localidad();
            columna[5] = geografia.getLocalidad();

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
        tablaD.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(100);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(110);
        tablaD.getColumnModel().getColumn(4).setPreferredWidth(100);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(450);
        
        // Centrar header
        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tablaD.getSelectionModel().setSelectionInterval (0, 0);
    }
    
}
