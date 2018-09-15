package Tabla;

import Modelo.ListaPedidoDAO;
import Modelo.ListaPedido;
import Modelo.SingletonProperties;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        modeloT.addColumn("Días");
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
        Object[] columna = new Object[23];
        ArrayList<ListaPedido> listaPedidos = dao.listPedidos(estado, nombre, userML);

        int numRegistros = dao.listPedidos(estado, nombre, userML).size();
        Iterator<ListaPedido> itrListaPedido = listaPedidos.iterator();         
        ListaPedido listaPedido = null;

        while (itrListaPedido.hasNext()) {             
            listaPedido = itrListaPedido.next();
            
                        Calendar fechaAct = new GregorianCalendar();
            int año = fechaAct.get(Calendar.YEAR);
            int mes = fechaAct.get(Calendar.MONTH);
            int dia = fechaAct.get(Calendar.DAY_OF_MONTH);

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = listaPedido.getFechaCompra();
            Date fechaEntrega = null;
            Date fechaActual = null;
            try {
                fechaEntrega = formato.parse(fecha);
                fechaActual = formato.parse(año + "-" + (mes+1) + "-" + dia);
            } catch (ParseException ex) {
                Logger.getLogger(MyRender.class.getName()).log(Level.SEVERE, null, ex);
            }

            long startTime = fechaEntrega.getTime();
            long endTime = fechaActual.getTime();
            long diffTime = startTime - endTime;
            long diffDays = diffTime / (1000 * 60 * 60 * 24);
            int days = (int)( (fechaActual.getTime() - fechaEntrega.getTime()) / (1000 * 60 * 60 * 24));            

            columna[0] = days;
            columna[1] = listaPedido.getPedido();
            columna[2] = listaPedido.getSpd();
            columna[3] = listaPedido.getProd();
            File fotoAp = new File(path_prod+listaPedido.getProd()+".jpg");
            if(fotoAp.isFile()){
                columna[4] = new JLabel(new ImageIcon(path_prod+listaPedido.getProd()+".jpg"));
            } else {
                columna[4] = new JLabel(new ImageIcon(path_prod+"noEncontrada.png"));
            }    
            columna[5] = listaPedido.getCant();
            columna[6] = listaPedido.getClienteId();
            columna[7] = listaPedido.getNomyap();
            columna[8] = listaPedido.getFechaCompra();
            columna[9] = listaPedido.getFechaEntrega();
            columna[10] = listaPedido.getEstado();
            columna[11] = listaPedido.getSenia();
            columna[12] = listaPedido.getSubTotal();
            columna[13] = listaPedido.getDesc();
            columna[14] = listaPedido.getTotal();
            columna[15] = listaPedido.getSaldo();
            columna[18] = listaPedido.getFact();
            columna[17] = listaPedido.getFormaPago();
            columna[16] = listaPedido.getEnvio();
            columna[19] = listaPedido.getDomEntrega();
            columna[20] = listaPedido.getUsuarioML();
            columna[21] = listaPedido.getCita();
            columna[22] = listaPedido.getObservacion();
            
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

        tablaD.getColumnModel().getColumn(0).setPreferredWidth(40);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(50);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(4).setPreferredWidth(50);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(6).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(7).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(8).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(9).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(10).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(11).setPreferredWidth(50);
        tablaD.getColumnModel().getColumn(12).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(13).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(14).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(15).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(16).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(17).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(18).setPreferredWidth(60);        
        tablaD.getColumnModel().getColumn(19).setPreferredWidth(120);
        tablaD.getColumnModel().getColumn(20).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(21).setPreferredWidth(150);

        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        tablaD.getSelectionModel().setSelectionInterval (0, 0);
    }    
}
