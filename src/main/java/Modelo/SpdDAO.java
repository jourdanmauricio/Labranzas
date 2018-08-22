package Modelo;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpdDAO {

    Conexion conexion;
    
    public SpdDAO () {
        conexion = new Conexion ();
    }
    
    public ArrayList<Spd> listSpd() {
        return null;
        // return Pedido;
    }
    
    public int editarSpd (String pedido, String spd, String estado, String cemento, String vidrio, String parafina, String idProducto, String cantidad, String precio, String total, String observacion, String usuario_ult_mod) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_editSpd (?,?,?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, pedido);
            cs.setString(2, spd);
            cs.setString(3, estado);
            cs.setString(4, cemento);
            cs.setString(5, vidrio);
            cs.setString(6, parafina);            
            cs.setString(7, idProducto);            
            cs.setString(8, cantidad);           
            cs.setString(9, precio);           
            cs.setString(10, total);           
            cs.setString(11, observacion);  
            cs.setString(12, usuario_ult_mod);  

            numFA = cs.executeUpdate();
            cs.close();
            acceDB.close();
            
        } catch(SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(SpdDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }
    
        public String insertSpd (String pedido, String spd, String estado, String cemento, String vidrio, String parafina, String idProducto, String cantidad, String precio, String total, String observacion, String usuario_creacion, String usuario_ult_mod) {
        String rptaRegistro=null;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_insertSpd (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, pedido);
            cs.setString(2, spd);
            cs.setString(3, estado);
            cs.setString(4, cemento);
            cs.setString(5, vidrio);
            cs.setString(6, parafina);            
            cs.setString(7, idProducto);            
            cs.setString(8, cantidad);           
            cs.setString(9, precio);           
            cs.setString(10, total);           
            cs.setString(11, observacion);  
            cs.setString(12, usuario_creacion);  
            cs.setString(13, usuario_ult_mod);  

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
            Logger.getLogger(SpdDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rptaRegistro;
    }
    
    public ArrayList<Spd> listSpdxid(String pedidoId) {
        ArrayList listaSpd = new ArrayList();
        Spd spd;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("Select * from sub_pedido where pedido = "+pedidoId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next() ) {
                spd = new Spd();
                spd.setPedido(rs.getString(1));
                spd.setSpd(rs.getString(2));
                spd.setEstado(rs.getString(3));
                spd.setCemento(rs.getString(4));
                spd.setVidrio(rs.getString(5));
                spd.setParafina(rs.getString(6));
                spd.setIdProducto(rs.getString(7));
                spd.setCantidad(rs.getString(8));
                spd.setPrecio(rs.getString(9));
                spd.setTotal(rs.getString(10));
                spd.setObservacion(rs.getString(11));
                listaSpd.add(spd);
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch(SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(SpdDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSpd;
    }
    
    public String listSpdMax(String pedido) {
        String maxSpd = "";
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select max(sub_pedido) as spd from sub_pedido where pedido = '"+pedido+"'");
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                maxSpd= rs.getString("spd");
                if (maxSpd==null) {
                    maxSpd="0";
                }
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(SpdDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxSpd;
    }    

    public int eliminarSpd (String pedidoId, String subPedido) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_deleteSpd (?,?)");
            cs.setString(1, pedidoId);
            cs.setString(2, subPedido);

            numFA = cs.executeUpdate();
            cs.close();
            acceDB.close();
            
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(SpdDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }    
    
    public ArrayList<String> Llenar_cmbProd() {
        ArrayList<String> estados = new ArrayList<String>();
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select * from producto");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                estados.add(rs.getString("id"));
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(SpdDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estados;
    }    

    
}
