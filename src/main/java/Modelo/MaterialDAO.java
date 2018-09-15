package Modelo;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaterialDAO {

    Conexion conexion;

    public MaterialDAO () {
        conexion = new Conexion ();
    }
    
    public String insertMaterial (String objeto, String descripcion, String categoria, String cantidad, String stock, String stock_min, String stock_max, String proveedor, String usuario_creacion, String usuario_ult_mod) {
        String rptaRegistro=null;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_insertMaterial (?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, objeto);
            cs.setString(2, descripcion);
            cs.setString(3, categoria);
            cs.setString(4, cantidad);
            cs.setString(5, stock);            
            cs.setString(6, stock_min);            
            cs.setString(7, stock_max);           
            cs.setString(8, proveedor);           
            cs.setString(9, usuario_creacion);  
            cs.setString(10, usuario_ult_mod);  
            
            int numFAfectas = cs.executeUpdate();
            
            if (numFAfectas > 0) {
                rptaRegistro = "Registro exitoso.";
            } 
            cs.close();
            acceDB.close();
        } catch(SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rptaRegistro;
    }
     
    public ArrayList<String> Llenar_cmbCategoria() {
        ArrayList<String> categorias = new ArrayList<String>();
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select categoria from materiales_categoria order by categoria");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categorias.add(rs.getString("categoria"));
            }
            ps.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedores;
    }
    
    public ArrayList<Material> listMaterial() {
        ArrayList listaMaterial = new ArrayList();
        Material material;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("Select * from materiales");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                material = new Material();
                material.setId(rs.getString(1));
                material.setObjeto(rs.getString(2));
                material.setDescripcion(rs.getString(3));
                material.setCategoria(rs.getString(4));
                material.setCantidad(rs.getString(5));
                material.setStock(rs.getString(6));
                material.setStockMin(rs.getString(7));
                material.setStockMax(rs.getString(8));
                material.setProveedor(rs.getString(9));
                listaMaterial.add(material);
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaMaterial;
    }
    
    public int insertNuevaCat (String categoria) {
        int numFA = 0;
        String insertSQL = "INSERT INTO materiales_categoria (categoria) VALUES (?)";
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
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }
    
    public int editarMaterial (String id, String objeto, String Descripcion, String categoria, String cantidad, String stock, String stockMin, String stockMax, String proveedor, String usuario_ult_mod) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_editMaterial (?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, id);
            cs.setString(2, objeto);
            cs.setString(3, Descripcion);
            cs.setString(4, categoria);
            cs.setString(5, cantidad);
            cs.setString(6, stock);            
            cs.setString(7, stockMin);            
            cs.setString(8, stockMax);           
            cs.setString(9, proveedor);           
            cs.setString(10, usuario_ult_mod);  

            numFA = cs.executeUpdate();
            cs.close();
            acceDB.close();
        } catch(SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }
    
    public int eliminarMaterial (String id) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_deleteMaterial (?)");
            cs.setString(1, id);

            numFA = cs.executeUpdate();
            cs.close();
            acceDB.close();
        } catch (Exception e) {        }
        return numFA;
    }
                              
}
