package Tabla;

import Modelo.SingletonProperties;
import Modelo.TransporteLocalidadDAO;
import Modelo.TransporteLocalidad;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TablaTranspoteLocalidad {

    TransporteLocalidadDAO dao = null;

    public void visualizarTransporteLocalidad(JTable tabla, String provincia, String localidad){

        DefaultTableModel modeloT = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        tabla.setModel(modeloT);
        modeloT.addColumn("Localidad"); 
        modeloT.addColumn("Provincia");
        modeloT.addColumn("Transporte");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Domicilio");
        modeloT.addColumn("Remito");
        modeloT.addColumn("teléfono");
        modeloT.addColumn("Observación");

        dao = new TransporteLocalidadDAO();
        TransporteLocalidad transLocalidad = new TransporteLocalidad();
        ArrayList<TransporteLocalidad> transLocs;
        transLocs = dao.listTransporteLocalidad(provincia, localidad);
        int numRegistros = dao.listTransporteLocalidad(provincia, localidad).size();

        Object[] columna = new Object[8];
        Iterator<TransporteLocalidad> itrtransLoc = transLocs.iterator();         
        
        while (itrtransLoc.hasNext()) {             
            transLocalidad = itrtransLoc.next();
            
            columna[0] = transLocalidad.getLocalidad();
            columna[1] = transLocalidad.getProvincia();
            columna[2] = transLocalidad.getTransporte();
            columna[3] = transLocalidad.getCantidad();
            columna[4] = transLocalidad.getDomicilio();
            columna[5] = transLocalidad.getRemito();
            columna[6] = transLocalidad.getTelefono();
            columna[7] = transLocalidad.getObservacion();
            modeloT.addRow(columna);
        }
        SetearVistaTabla(tabla);
    }
    
    public void SetearVistaTabla (JTable tablaD) {

        // Ancho de fila y Scroll 
        SingletonProperties sp=SingletonProperties.getInstancia();
        int ancho_fila =  Integer.parseInt(sp.getPropiedad("ancho_fila"));
        tablaD.setRowHeight(ancho_fila);   

        tablaD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablaD.setAutoscrolls(true);
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        tablaD.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(5).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(0).setPreferredWidth(200);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(180);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(4).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(6).setPreferredWidth(170);
        tablaD.getColumnModel().getColumn(7).setPreferredWidth(180);
        
        // Centrar header
        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tablaD.getSelectionModel().setSelectionInterval (0, 0);
    }
    
}
    
