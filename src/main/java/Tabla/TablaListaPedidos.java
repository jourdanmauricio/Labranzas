package Tabla;

import Modelo.ListaPedidoDAO;
import Modelo.ListaPedido;
import Modelo.SingletonProperties;
import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.TableCellRenderer;

public class TablaListaPedidos {
    
    ListaPedidoDAO dao = null;

    public void visualizarListaPedido(JTable tabla, String estado, String nombre, String userML){
  
        tabla.setDefaultRenderer (Object.class, new MyRender());
//        tabla.setDefaultRenderer (Object.class, new Render());
        
        DefaultTableModel modeloT = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    

        SingletonProperties sp=SingletonProperties.getInstancia();
        String path_prod= sp.getPropiedad("path_fotos_prod");
       
        tabla.setModel(modeloT);
        modeloT.addColumn("Pedido");
        modeloT.addColumn("Spd");
        modeloT.addColumn("Prod");
        modeloT.addColumn("Foto");        
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Cliente Id");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("F Venta");
        modeloT.addColumn("F Entrega");
        modeloT.addColumn("Estado");
        modeloT.addColumn("Senia");
        modeloT.addColumn("SubTotal");
        modeloT.addColumn("Desc");
        modeloT.addColumn("Total");
        modeloT.addColumn("Saldo");
        modeloT.addColumn("Envio");
        modeloT.addColumn("F Pago");
        modeloT.addColumn("Fact");
        modeloT.addColumn("Domcilio");
        modeloT.addColumn("Usuario ML");
        modeloT.addColumn("Cita");
        modeloT.addColumn("Observación");        

        dao = new ListaPedidoDAO();
        Object[] columna = new Object[22];
        ArrayList<ListaPedido> listaPedidos = dao.listPedidos(estado, nombre, userML);

        int numRegistros = dao.listPedidos(estado, nombre, userML).size();
        Iterator<ListaPedido> itrListaPedido = listaPedidos.iterator();         
        ListaPedido listaPedido = null;

        while (itrListaPedido.hasNext()) {             
            listaPedido = itrListaPedido.next();
            columna[0] = listaPedido.getPedido();
            columna[1] = listaPedido.getSpd();
            columna[2] = listaPedido.getProd();
            File fotoAp = new File(path_prod+listaPedido.getProd()+".jpg");
            if(fotoAp.isFile()){
                columna[3] = new JLabel(new ImageIcon(path_prod+listaPedido.getProd()+".jpg"));
            } else {
                columna[3] = new JLabel(new ImageIcon(path_prod+"noEncontrada.png"));
            }    
            columna[4] = listaPedido.getCant();
            columna[5] = listaPedido.getClienteId();
            columna[6] = listaPedido.getNomyap();
            columna[7] = listaPedido.getFechaCompra();
            columna[8] = listaPedido.getFechaEntrega();
            columna[9] = listaPedido.getEstado();
            columna[10] = listaPedido.getSenia();
            columna[11] = listaPedido.getSubTotal();
            columna[12] = listaPedido.getDesc();
            columna[13] = listaPedido.getTotal();
            columna[14] = listaPedido.getSaldo();
            columna[17] = listaPedido.getFact();
            columna[16] = listaPedido.getFormaPago();
            columna[15] = listaPedido.getEnvio();
            columna[18] = listaPedido.getDomEntrega();
            columna[19] = listaPedido.getUsuarioML();
            columna[20] = listaPedido.getCita();
            columna[21] = listaPedido.getObservacion();
            
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

//        DefaultTableCellRenderer MyRender = new DefaultTableCellRenderer();

        tablaD.getColumnModel().getColumn(0).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(50);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(50);
        tablaD.getColumnModel().getColumn(4).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(6).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(7).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(8).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(9).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(10).setPreferredWidth(50);
        tablaD.getColumnModel().getColumn(11).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(12).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(13).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(14).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(15).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(16).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(17).setPreferredWidth(60);        
        tablaD.getColumnModel().getColumn(18).setPreferredWidth(120);
        tablaD.getColumnModel().getColumn(19).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(20).setPreferredWidth(150);

        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        tablaD.getSelectionModel().setSelectionInterval (0, 0);
    }    
}
