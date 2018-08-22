package Tabla;

import Modelo.Pendientes;
import Modelo.PendientesDAO;
import Modelo.SingletonProperties;
import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.TableCellRenderer;

public class TablaPendientes {

    PendientesDAO dao = null;

    public void visualizarPendientes(JTable tabla, String sector){

        tabla.setDefaultRenderer (Object.class, new Render());
        DefaultTableModel modeloT = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        tabla.setModel(modeloT);
        modeloT.addColumn("Pedido");
        modeloT.addColumn("SubPedido");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Prod");
        modeloT.addColumn("Foto");        
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Cemento");
        modeloT.addColumn("Vidrio");
        modeloT.addColumn("Parafina");
        modeloT.addColumn("Envio");
        modeloT.addColumn("Observacion");
        
        dao = new PendientesDAO();
        Pendientes pendiente = new Pendientes();
        ArrayList<Pendientes> pendientes;
        pendientes = dao.listPendiente(sector);            
        int numRegistros = dao.listPendiente(sector).size();

        Object[] columna = new Object[11];
        Iterator<Pendientes> itrPendientes = pendientes.iterator();         

        SingletonProperties sp=SingletonProperties.getInstancia();
        String path_prod= sp.getPropiedad("path_fotos_prod");
        
        while (itrPendientes.hasNext()) {             
            pendiente = itrPendientes.next();
            
            columna[0] = pendiente.getPedido();
            columna[1] = pendiente.getSubPedido();
            columna[2] = pendiente.getNombre();
            columna[3] = pendiente.getIdProducto();
            File fotoAp = new File(path_prod+pendiente.getIdProducto()+".jpg");
            if(fotoAp.isFile()){
                columna[4] = new JLabel(new ImageIcon(path_prod+pendiente.getIdProducto()+".jpg"));
            } else {
                columna[4] = new JLabel(new ImageIcon(path_prod+"noEncontrada.png"));
            }    
            columna[5] = pendiente.getCantidad();
            columna[6] = pendiente.getCemento();
            columna[7] = pendiente.getVidrio();
            columna[8] = pendiente.getParafina();
            columna[9] = pendiente.getEnvio();
            columna[10] = pendiente.getObservacion();

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

/*        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        tablaD.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(5).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(6).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(7).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(8).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(9).setCellRenderer(modelocentrar);  
*/
        tablaD.getColumnModel().getColumn(0).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(200);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(6).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(7).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(8).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(9).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(10).setPreferredWidth(150);
        
        
        // Centrar header
        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tablaD.getSelectionModel().setSelectionInterval (0, 0);
    }
}






