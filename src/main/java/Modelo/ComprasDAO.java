package Modelo;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ComprasDAO {
    
    Conexion conexion;

    public ComprasDAO () {
        conexion = new Conexion ();
    }    

    public String insertCompra (String fecha_compra, String insumo, String categoria, String cantidad, String precio, String total, String proveedor, String observacion, String usuario_creacion, String usuario_ult_mod) {
        String rptaRegistro=null;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_insertCompra (?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, fecha_compra);
            cs.setString(2, insumo);
            cs.setString(3, categoria);
            cs.setString(4, cantidad);
            cs.setString(5, precio);            
            cs.setString(6, total);            
            cs.setString(7, proveedor);           
            cs.setString(8, observacion);           
            cs.setString(9, usuario_creacion);  
            cs.setString(10, usuario_ult_mod);  
            
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
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedores;
    }
    
    public ArrayList<String> Llenar_cmbInsumos() {
        ArrayList<String> insumos = new ArrayList<String>();
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select objeto from materiales order by objeto");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                insumos.add(rs.getString("objeto"));
            }
            ps.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insumos;
    }
  
    public ArrayList<Compras> listCompra(String categoria, String prov) {
        ArrayList listaCompra = new ArrayList();
        Compras compra;
        
        String condicion = "";
        if (!categoria.equals("*")) {
            condicion += " and categoria = '"+categoria+"'";
        }
        if (!prov.equals("*")) {
            condicion += " and proveedor = '"+prov+"'";
        }        
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("Select * from compras where 1 = 1 "+condicion+" order by fecha_compra desc");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                compra = new Compras();
                compra.setId(rs.getString(1));
                compra.setFecha_compra(rs.getString(2));
                compra.setInsumo(rs.getString(3));
                compra.setCategoria(rs.getString(4));
                compra.setCantidad(rs.getString(5));
                compra.setPrecio(rs.getString(6));
                compra.setTotal(rs.getString(7));
                compra.setProveedor(rs.getString(8));
                compra.setObservacion(rs.getString(9));
                listaCompra.add(compra);
            }
            rs.close();
            acceDB.close();

        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCompra;
    }

    public int editarCompra (String id, String fecha_compra, String insumo, String categoria, String cantidad, String precio, String total, String proveedor, String observacion, String usuario_ult_mod) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_editCompra(?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, id);
            cs.setString(2, fecha_compra);
            cs.setString(3, insumo);
            cs.setString(4, categoria);
            cs.setString(5, cantidad);
            cs.setString(6, precio);            
            cs.setString(7, total);            
            cs.setString(8, proveedor);           
            cs.setString(9, observacion);           
            cs.setString(10, usuario_ult_mod);  

            numFA = cs.executeUpdate();
            
            cs.close();
            acceDB.close();
        } catch(SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }

    public int eliminarCompra (String id) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_deleteCompra (?)");
            cs.setString(1, id);

            numFA = cs.executeUpdate();

            cs.close();
            acceDB.close();
        } catch (Exception e) {  }
        return numFA;
    }
}
