package Tabla;

import Modelo.CajasDAO;
import Modelo.Cajas;
import Modelo.SingletonProperties;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TablaMedidasCajas {

    CajasDAO dao = null;

    public void visualizarCaja(JTable tabla){

        DefaultTableModel modeloT = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        tabla.setModel(modeloT);
        modeloT.addColumn("Id");
        modeloT.addColumn("Objeto");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Desc Objeto");
        modeloT.addColumn("largo");
        modeloT.addColumn("Ancho");
        modeloT.addColumn("Largo Envío");        
        modeloT.addColumn("Ancho Envío");        

        dao = new CajasDAO();
        Cajas caja = new Cajas();
        ArrayList<Cajas> cajas;
        cajas = dao.listCajas();            
        int numRegistros = dao.listCajas().size();

        Object[] columna = new Object[8];
        Iterator<Cajas> itrCajas = cajas.iterator();         
        
        while (itrCajas.hasNext()) {             
            caja = itrCajas.next();
            
            columna[0] = caja.getId();
            columna[1] = caja.getObjeto();
            columna[2] = caja.getCantidad();
            columna[3] = caja.getDescObjeto();
            columna[4] = caja.getLargo();
            columna[5] = caja.getAncho();
            columna[6] = caja.getLargoE();
            columna[7] = caja.getAnchoE();

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
        tablaD.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(4).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(5).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(6).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(7).setCellRenderer(modelocentrar);                
        tablaD.getColumnModel().getColumn(0).setPreferredWidth(40);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(250);
        tablaD.getColumnModel().getColumn(4).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(6).setPreferredWidth(100);
        tablaD.getColumnModel().getColumn(7).setPreferredWidth(100);
        
        // Centrar header
        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tablaD.getSelectionModel().setSelectionInterval (0, 0);
    }
}
