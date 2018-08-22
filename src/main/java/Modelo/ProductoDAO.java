package Modelo;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO {

    Conexion conexion;

    public ProductoDAO () {
        conexion = new Conexion ();
    }
    
    public String insertProducto (String id, String estado, String descripcion, String desc_abrev, String categoria, String precio_mayor, String precio_menor, String cantidad, String cant_min, String foto, String visible, String orden, String foto_det_1, String foto_det_2,  String foto_det_3, String cemento, String vidrio, String parafina, String proveedor, String usuario_creacion, String usuario_ult_mod) {
        String rptaRegistro=null;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_insertProducto (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, id);
            cs.setString(2, estado);
            cs.setString(3, descripcion);
            cs.setString(4, desc_abrev);
            cs.setString(5, categoria);
            cs.setString(6, precio_mayor);            
            cs.setString(7, precio_menor);           
            cs.setString(8, cantidad);
            cs.setString(9, cant_min);
            cs.setString(10, foto);
            cs.setString(11, visible);
            cs.setString(12, orden);
            cs.setString(13, foto_det_1);
            cs.setString(14, foto_det_2);
            cs.setString(15, foto_det_3);
            cs.setString(16, cemento);
            cs.setString(17, vidrio);
            cs.setString(18, parafina);
            cs.setString(19, proveedor);
            cs.setString(20, usuario_creacion);  
            cs.setString(21, usuario_ult_mod);  
            
            int numFAfectas = cs.executeUpdate();
            
            if (numFAfectas > 0) {
                rptaRegistro = "Registro exitoso.";
            } 
            cs.close();
            acceDB.close();
        } 
            catch(SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
            } catch (IOException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rptaRegistro;
    }
    
    public String listProductoxid(String producto) {
        String prod = "";
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select id from producto where id = '"+producto+"'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prod= rs.getString("id");
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prod;
    }    

    public ArrayList<String> Llenar_cmbCategoria() {
        ArrayList<String> categorias = new ArrayList<String>();
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select categoria from categoria");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categorias.add(rs.getString("categoria"));
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorias;
    }

    public ArrayList<String> Llenar_cmbProveedor() {
        ArrayList<String> proveedores = new ArrayList<String>();
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select razon_social from proveedores order by razon_social");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                proveedores.add(rs.getString("razon_social"));
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedores;
        }

    public ArrayList<Producto> listProducto(String estado, String categoria) {
        ArrayList listaProducto = new ArrayList();
        Producto producto;
        
        String condicion = " where 1 = 1";
        if (!estado.equals("*")) {
            condicion += " and producto.estado = '"+estado+"'";
        }
        if (!categoria.equals("*")) {
            condicion += " and producto.categoria = '"+categoria+"'";
        }

        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("Select * from producto " + condicion);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getString(1));
                producto.setEstado(rs.getString(2));
                producto.setDescripcion(rs.getString(3));
                producto.setDescripAbrev(rs.getString(4));
                producto.setCategoria(rs.getString(5));
                producto.setPrecio_mayor(rs.getString(6));
                producto.setPrecio_menor(rs.getString(7));
                producto.setCantidad(rs.getString(8));
                producto.setCant_min(rs.getString(9));
                producto.setFoto(rs.getString(10));
                producto.setVisible(rs.getString(11));
                producto.setOrden(rs.getString(12));
                producto.setFoto_det_1(rs.getString(13));
                producto.setFoto_det_2(rs.getString(14));
                producto.setFoto_det_3(rs.getString(15));
                producto.setCemento(rs.getString(16));
                producto.setVidrio(rs.getString(17));
                producto.setParafina(rs.getString(18));
                producto.setProveedor(rs.getString(19));
                listaProducto.add(producto);
            }

            ps.close();
            rs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProducto;
    }
    
    public int insertNuevaCat (String categoria) {
        int numFA = 0;
        String insertSQL = "INSERT INTO categoria (categoria) VALUES (?)";
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement(insertSQL);
            ps.setString(1, categoria);
            numFA = ps.executeUpdate();

            ps.close();
            acceDB.close();
            
        } catch(SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {        
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }

    public int editarProducto (String id, String estado, String descripcion, String desc_abrev, String categoria, String precio_mayor, String precio_menor, String cantidad, String cant_min, String foto, String visible, String orden, String foto_det_1, String foto_det_2,  String foto_det_3, String cemento, String vidrio, String parafina, String proveedor, String usuario_ult_mod) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_editProducto (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, id);
            cs.setString(2, estado);
            cs.setString(3, descripcion);
            cs.setString(4, desc_abrev);
            cs.setString(5, categoria);
            cs.setString(6, precio_mayor);            
            cs.setString(7, precio_menor);            
            cs.setString(8, cantidad);           
            cs.setString(9, cant_min);
            cs.setString(10, foto);
            cs.setString(11, visible);
            cs.setString(12, orden);
            cs.setString(13, foto_det_1);
            cs.setString(14, foto_det_2);
            cs.setString(15, foto_det_3);
            cs.setString(16, cemento);
            cs.setString(17, vidrio);
            cs.setString(18, parafina);
            cs.setString(19, proveedor);
            cs.setString(20, usuario_ult_mod);  
            numFA = cs.executeUpdate();
            
            cs.close();
            acceDB.close();
        } catch(SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }

    public int eliminarProducto (String id) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_deleteProducto (?)");
            cs.setString(1, id);

            numFA = cs.executeUpdate();
            cs.close();
            acceDB.close();
        } catch (Exception e) {        }
        return numFA;
    }
}
