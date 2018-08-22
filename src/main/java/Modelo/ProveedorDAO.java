package Modelo;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProveedorDAO {

    Conexion conexion;
    
    public ProveedorDAO () {
        conexion = new Conexion ();
    }
        
    public String insertProveedor (String razonSocial, String actividad, String telefono, String contacto, String mail, String direccion, String web, String observacion, String usuario_creacion, String usuario_ult_mod) {
        String rptaRegistro=null;

        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_insertProveedor(?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, razonSocial);
            cs.setString(2, actividad);
            cs.setString(3, telefono);
            cs.setString(4, contacto);
            cs.setString(5, mail);            
            cs.setString(6, direccion);            
            cs.setString(7, web);           
            cs.setString(8, observacion);           
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
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rptaRegistro;
    }

    public ArrayList<Proveedor> listProveedor() {
        ArrayList listaProveedor = new ArrayList();
        Proveedor proveedor;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("Select * from proveedores");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next() ) {
                proveedor = new Proveedor();
                proveedor.setId(rs.getString(1));
                proveedor.setRazonSocial(rs.getString(2));
                proveedor.setActividad(rs.getString(3));
                proveedor.setTelefono(rs.getString(4));
                proveedor.setContacto(rs.getString(5));
                proveedor.setMail(rs.getString(6));
                proveedor.setDireccion(rs.getString(7));
                proveedor.setWeb(rs.getString(8));
                proveedor.setObservacion(rs.getString(9));
                listaProveedor.add(proveedor);
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch (Exception e) {        }
        return listaProveedor;
    }
    
    public int editarProveedor (String id, String razonSocial, String actividad, String telefono, String contacto, String mail, String direccion, String web, String observacion, String usuario_ult_mod) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_editProveedor (?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, id);
            cs.setString(2, razonSocial);
            cs.setString(3, actividad);
            cs.setString(4, telefono);
            cs.setString(5, contacto);
            cs.setString(6, mail);            
            cs.setString(7, direccion);            
            cs.setString(8, web);           
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
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }
 
    public int eliminarProveedor (String id) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_deleteProveedor(?)");
            cs.setString(1, id);

            numFA = cs.executeUpdate();
            cs.close();
            acceDB.close();
            
        } catch (Exception e) {        }
        return numFA;
    }
}
