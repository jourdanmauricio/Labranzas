package Tabla;

import Modelo.SingletonProperties;
import Modelo.SpdDAO;
import Modelo.Spd;
import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.TableCellRenderer;

public class TablaSpd {
    
    SpdDAO dao = null;

    public void visualizarSpd(JTable tabla, String pedidoId){

        tabla.setDefaultRenderer(Object.class, new Render());
        
        DefaultTableModel modeloT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        
        SingletonProperties sp=SingletonProperties.getInstancia();
        String path_prod= sp.getPropiedad("path_fotos_prod");

        tabla.setModel(modeloT);        
        modeloT.addColumn("Pedido");
        modeloT.addColumn("Spd");
        modeloT.addColumn("Estado");
        modeloT.addColumn("Cemento");
        modeloT.addColumn("Vidrio");
        modeloT.addColumn("Parafina");
        modeloT.addColumn("Prod");
        modeloT.addColumn("Foto");        
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Precio");
        modeloT.addColumn("Total");
        modeloT.addColumn("Observacion");

        dao = new SpdDAO();
        Spd spd = new Spd();
        ArrayList<Spd> spds;
        
        Object[] columna = new Object[12];
        spds = dao.listSpdxid(pedidoId);
        Iterator<Spd> itrSpds = spds.iterator();         

        while (itrSpds.hasNext()) {             
            spd = itrSpds.next();
            columna[0] = spd.getPedido();
            columna[1] = spd.getSpd();
            columna[2] = spd.getEstado();
            columna[3] = spd.getCemento();
            columna[4] = spd.getVidrio();
            columna[5] = spd.getParafina();
            columna[6] = spd.getIdProducto();
            File fotoAp = new File(path_prod+spd.getIdProducto()+".jpg");
            if(fotoAp.isFile()){
                columna[7] = new JLabel(new ImageIcon(path_prod+spd.getIdProducto()+".jpg"));
            } else {
                columna[7] = new JLabel(new ImageIcon(path_prod+"noEncontrada.png"));
            }    
            columna[8] = spd.getCantidad();
            columna[9] = spd.getPrecio();
            columna[10] = spd.getTotal();
            columna[11] = spd.getObservacion();
            
            modeloT.addRow(columna);
        }
        SetearVistaTabla (tabla);
    }        
    
    public void limparTspd (JTable tablaD) {
        
        DefaultTableModel tb = (DefaultTableModel) tablaD.getModel();
        tb.setRowCount(0);
        
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
        tablaD.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(4).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(5).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(6).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(8).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(9).setCellRenderer(modelocentrar);  
*/
        tablaD.getColumnModel().getColumn(0).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(1).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(90);
        tablaD.getColumnModel().getColumn(4).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(6).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(7).setPreferredWidth(50);
        tablaD.getColumnModel().getColumn(8).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(9).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(10).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(11).setPreferredWidth(250);

        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tablaD.getSelectionModel().setSelectionInterval (0, 0);
    }    
    
}
