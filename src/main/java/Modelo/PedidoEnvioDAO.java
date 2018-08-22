package Modelo;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoEnvioDAO {

    Conexion conexion;

    public PedidoEnvioDAO () {
        conexion = new Conexion ();
    }

    public String insertarPedidoEnvio (String pedido, String referente, String dni, String telefono, String domEntrega, String localidad, String codigoPostal, String provincia, String envioADom, String transporte, String cantCajas,  String obsEnvio, String usuario_creacion, String usuario_ult_mod) {

        String rptaRegistro=null;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_insertPedidoEnvio (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, pedido);
            cs.setString(2, referente);
            cs.setString(3, dni);
            cs.setString(4, telefono);
            cs.setString(5, domEntrega);
            cs.setString(6, localidad);            
            cs.setString(7, codigoPostal);
            cs.setString(8, provincia);            
            cs.setString(9, envioADom);           
            cs.setString(10, transporte);           
            cs.setString(11, cantCajas);           
            cs.setString(12, obsEnvio);           
            cs.setString(13, usuario_creacion);  
            cs.setString(14, usuario_ult_mod);  

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
            Logger.getLogger(PedidoEnvioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rptaRegistro;
    }
        
    public ArrayList<String> listPedidoEnvio(String pedidoId) {
        ArrayList envio = new ArrayList();
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("Select * from pedido_envio where pedido = "+pedidoId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                envio.add(rs.getString("pedido"));
                envio.add(rs.getString("referente"));
                envio.add(rs.getString("dni"));
                envio.add(rs.getString("telefono"));
                envio.add(rs.getString("dom_entrega"));
                envio.add(rs.getString("localidad"));
                envio.add(rs.getString("codigo_postal"));
                envio.add(rs.getString("provincia"));                
                envio.add(rs.getString("envio_a_dom"));
                envio.add(rs.getString("transporte"));                
                envio.add(rs.getString("cant_cajas"));                
                envio.add(rs.getString("obs_envio"));                                
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(PedidoEnvioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return envio;
    }

    public int editarPedidoEnvio (String pedido, String referente, String dni, String telefono, String domEntrega, String localidad, String codigoPostal, String provincia, String envioADom, String transporte, String cantCajas,  String obsEnvio, String usuario_ult_mod) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_editPedidoEnvio (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, pedido);
            cs.setString(2, referente);
            cs.setString(3, dni);
            cs.setString(4, telefono);
            cs.setString(5, domEntrega);
            cs.setString(6, localidad);            
            cs.setString(7, codigoPostal);            
            cs.setString(8, provincia);           
            cs.setString(9, envioADom);           
            cs.setString(10, transporte);  
            cs.setString(11, cantCajas);  
            cs.setString(12, obsEnvio);  
            cs.setString(13, usuario_ult_mod);  

            numFA = cs.executeUpdate();

            cs.close();
            acceDB.close();
        } catch(SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(PedidoEnvioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }
}
