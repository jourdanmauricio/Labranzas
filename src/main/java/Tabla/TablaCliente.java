package Tabla;

import Modelo.ClienteDAO;
import Modelo.Cliente;
import Modelo.SingletonProperties;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TablaCliente {

    ClienteDAO dao = null;

    public void visualizarCliente(JTable tabla, String nombre, String userML, String clienteId){

        tabla.setDefaultRenderer (Object.class, new Render());

        DefaultTableModel modeloT = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        tabla.setModel(modeloT);
        modeloT.addColumn("Id");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("DNI");
        modeloT.addColumn("Tipo");
        modeloT.addColumn("Referente");
        modeloT.addColumn("Telefono");
        modeloT.addColumn("Mail");
        modeloT.addColumn("Domicilio");
        modeloT.addColumn("Usuario_ML");
        modeloT.addColumn("Observacion");
        
        dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        ArrayList<Cliente> clientes;
        clientes = dao.listCliente(nombre, userML);            
        int numRegistros = dao.listCliente(nombre, userML).size();

        Object[] columna = new Object[10];
        Iterator<Cliente> itrClientes = clientes.iterator();         
        
        while (itrClientes.hasNext()) {             
            cliente = itrClientes.next();
            
            columna[0] = cliente.getId();
            columna[1] = cliente.getNom_y_ap();
            columna[2] = cliente.getDNI();
            columna[3] = cliente.getTipo();
            columna[4] = cliente.getReferente();
            columna[5] = cliente.getTelefono();
            columna[6] = cliente.getMail();
            columna[7] = cliente.getDomicilio();
            columna[8] = cliente.getUsuario_ml();
            columna[9] = cliente.getObservacion();

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
//        tablaD.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
//        tablaD.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
//        tablaD.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
//        tablaD.getColumnModel().getColumn(5).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(0).setPreferredWidth(40);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(160);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(4).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(110);
        tablaD.getColumnModel().getColumn(6).setPreferredWidth(170);
        tablaD.getColumnModel().getColumn(7).setPreferredWidth(100);
        tablaD.getColumnModel().getColumn(8).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(9).setPreferredWidth(120);
        
        
        // Centrar header
        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tablaD.getSelectionModel().setSelectionInterval (0, 0);
    }
}

