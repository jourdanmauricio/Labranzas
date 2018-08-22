package Tabla;

import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Modelo.SingletonProperties;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TablaProveedores {

    ProveedorDAO dao = null;

    public void visualizarProveedor(JTable tabla){

        DefaultTableModel modeloT = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        tabla.setModel(modeloT);
        modeloT.addColumn("Id");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Actividad");
        modeloT.addColumn("Teléfono");
        modeloT.addColumn("Contacto");
        modeloT.addColumn("Mail");
        modeloT.addColumn("Dirección");
        modeloT.addColumn("Web");
        modeloT.addColumn("Observación");
        
        dao = new ProveedorDAO();
        Proveedor proveedor = new Proveedor();
        ArrayList<Proveedor> proveedores;
        proveedores = dao.listProveedor();
        int numRegistros = dao.listProveedor().size();

        Object[] columna = new Object[9];
        Iterator<Proveedor> itrProveedores = proveedores.iterator();         
        
        while (itrProveedores.hasNext()) {             
            proveedor = itrProveedores.next();
            
            columna[0] = proveedor.getId();
            columna[1] = proveedor.getRazonSocial();
            columna[2] = proveedor.getActividad();
            columna[3] = proveedor.getTelefono();
            columna[4] = proveedor.getContacto();
            columna[5] = proveedor.getMail();
            columna[6] = proveedor.getDireccion();
            columna[7] = proveedor.getWeb();
            columna[8] = proveedor.getObservacion();

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
        tablaD.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(5).setCellRenderer(modelocentrar);
        
        tablaD.getColumnModel().getColumn(0).setPreferredWidth(40);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(160);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(4).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(6).setPreferredWidth(170);
        tablaD.getColumnModel().getColumn(7).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(8).setPreferredWidth(150);
        
        // Centrar header
        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tablaD.getSelectionModel().setSelectionInterval (0, 0);
    }
}

