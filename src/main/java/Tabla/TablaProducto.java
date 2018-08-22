package Tabla;

import Modelo.ProductoDAO;
import Modelo.Producto;
import Modelo.SingletonProperties;
import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.TableCellRenderer;

public class TablaProducto {

    ProductoDAO dao = null;    
    
    public void visualizarProducto (JTable tablaD, String estado, String categoria) {

        tablaD.setDefaultRenderer(Object.class, new Render());        
        DefaultTableModel modeloT = new DefaultTableModel() {
            @Override 
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        SingletonProperties sp=SingletonProperties.getInstancia();
        String path_prod= sp.getPropiedad("path_fotos_prod");

        tablaD.setModel(modeloT);
        modeloT.addColumn("Id");
        modeloT.addColumn("Foto");
        modeloT.addColumn("Estado");
        modeloT.addColumn("Descripción");
        modeloT.addColumn("Desc abrev");
        modeloT.addColumn("Categoria");
        modeloT.addColumn("P Mayor");
        modeloT.addColumn("P Menor");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Cant min");
        modeloT.addColumn("Foto");
        modeloT.addColumn("Visible");
        modeloT.addColumn("Orden");
        modeloT.addColumn("Foto 1");
        modeloT.addColumn("Foto 2");
        modeloT.addColumn("Foto 3");
        modeloT.addColumn("Cemento");
        modeloT.addColumn("Vidrio");        
        modeloT.addColumn("Parafina");        
        modeloT.addColumn("Proveedor");    
        dao = new ProductoDAO();
        Producto producto = new Producto();

        Object[] columna = new Object[20];
        int numRegistros = dao.listProducto(estado, categoria).size();
 
        ArrayList<Producto> productos = dao.listProducto(estado, categoria);
        Iterator<Producto> itrProducto = productos.iterator();         

        while (itrProducto.hasNext()) {             
            producto = itrProducto.next();
            columna[0] = producto.getId();
            File fotoAp = new File(path_prod+producto.getId()+".jpg");
            if(fotoAp.isFile()){
                columna[1] = new JLabel(new ImageIcon(path_prod+producto.getId()+".jpg"));
            } else {
                columna[1] = new JLabel(new ImageIcon(path_prod+"noEncontrada.png"));
            }    
            columna[2] = producto.getEstado();
            columna[3] = producto.getDescripcion();
            columna[4] = producto.getDescripAbrev();
            columna[5] = producto.getCategoria();
            columna[6] = producto.getPrecio_mayor();
            columna[7] = producto.getPrecio_menor();
            columna[8] = producto.getCantidad();
            columna[9] = producto.getCant_min();
            columna[10] = producto.getFoto();
            columna[11] = producto.getVisible();
            columna[12] = producto.getOrden();
            columna[13] = producto.getFoto_det_1();
            columna[14] = producto.getFoto_det_2();
            columna[15] = producto.getFoto_det_3();
            columna[16] = producto.getCemento();
            columna[17] = producto.getVidrio();            
            columna[18] = producto.getParafina();            
            columna[19] = producto.getProveedor();                        

            modeloT.addRow(columna);
        }    
        SetearVistaTabla (tablaD);
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
        tablaD.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(5).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(6).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(7).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(8).setCellRenderer(modelocentrar);
        tablaD.getColumnModel().getColumn(9).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(11).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(12).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(16).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(17).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(18).setCellRenderer(modelocentrar);        
        tablaD.getColumnModel().getColumn(19).setCellRenderer(modelocentrar);                
*/
        tablaD.getColumnModel().getColumn(0).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(2).setPreferredWidth(80);
        tablaD.getColumnModel().getColumn(3).setPreferredWidth(200);
        tablaD.getColumnModel().getColumn(4).setPreferredWidth(150);
        tablaD.getColumnModel().getColumn(5).setPreferredWidth(120);
        tablaD.getColumnModel().getColumn(6).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(7).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(8).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(9).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(10).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(11).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(12).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(13).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(14).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(15).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(16).setPreferredWidth(70);
        tablaD.getColumnModel().getColumn(17).setPreferredWidth(60);
        tablaD.getColumnModel().getColumn(18).setPreferredWidth(70);        
        tablaD.getColumnModel().getColumn(19).setPreferredWidth(100);        
        TableCellRenderer rendererFromHeader = tablaD.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);    
    }
}
