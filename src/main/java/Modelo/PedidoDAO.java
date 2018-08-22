package Modelo;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDAO {

    Conexion conexion;
    
    public PedidoDAO () {
        conexion = new Conexion ();
    }
    
    public ArrayList<Pedido> listPedido() {
        return null;
        // return Pedido;
    }
    
    public String listPedidoMax() {
        String maxPedido = "";
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select max(id) as pedido from pedido");
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                maxPedido= rs.getString("pedido");
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxPedido;
    }    
    
    public String insertarPedido (String clienteId, String fventa, String fentrega, String estado, String senia, String subTotal, String pdesc, String total, String saldo, String fpago, String fact, String cita, String envio, String domicilioEntrega, String observacion, String usuario_creacion, String usuario_ult_mod) {
        String rptaRegistro=null;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_insertPedido (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, clienteId);
            cs.setString(2, fventa);
            cs.setString(3, fentrega);
            cs.setString(4, estado);
            cs.setString(5, senia);
            cs.setString(6, subTotal);            
            cs.setString(7, pdesc);
            cs.setString(8, total);            
            cs.setString(9, saldo);           
            cs.setString(10, fpago);           
            cs.setString(11, fact);           
            cs.setString(12, cita);           
            cs.setString(13, envio);           
            cs.setString(14, domicilioEntrega);           
            cs.setString(15, observacion);  
            cs.setString(16, usuario_creacion);  
            cs.setString(17, usuario_ult_mod);  

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
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rptaRegistro;
    }
    
    public int editarPedido (String id, String clienteId, String fventa, String fentrega, String estado, String senia, String subTotal, String pdesc, String total, String saldo, String fpago, String fact, String cita, String envio, String domicilioEntrega, String observacion, String usuario_ult_mod) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_editPedido (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, id);
            cs.setString(2, clienteId);
            cs.setString(3, fventa);
            cs.setString(4, fentrega);
            cs.setString(5, estado);
            cs.setString(6, senia);            
            cs.setString(7, subTotal);                        
            cs.setString(8, pdesc);            
            cs.setString(9, total);            
            cs.setString(10, saldo);           
            cs.setString(11, fpago);           
            cs.setString(12, fact);           
            cs.setString(13, cita);           
            cs.setString(14, envio);           
            cs.setString(15, domicilioEntrega);           
            cs.setString(16, observacion);  
            cs.setString(17, usuario_ult_mod);  

            numFA = cs.executeUpdate();

            cs.close();
            acceDB.close();
        } catch(SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }
    
    public ArrayList<Pedido> listPedidoxid(String pedidoId) {
        ArrayList listaPedido = new ArrayList();
        Pedido pedido;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("Select * from pedido where id = "+pedidoId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next() ) {
                pedido = new Pedido();
                pedido.setId(rs.getString(1));
                pedido.setIdCliente(rs.getString(2));
                pedido.setFventa(rs.getString(3));
                pedido.setFentrega(rs.getString(4));
                pedido.setEstado(rs.getString(5));
                pedido.setSenia(rs.getString(6));
                pedido.setTotal(rs.getString(7));
                pedido.setSaldo(rs.getString(8));
                pedido.setFpago(rs.getString(9));
                pedido.setFact(rs.getString(10));
                pedido.setCita(rs.getString(11));
                pedido.setEnvio(rs.getString(12));
                pedido.setDomicilioEntrega(rs.getString(13));
                pedido.setObservacion(rs.getString(14));
                listaPedido.add(pedido);
            }

            ps.close();
            rs.close();
            acceDB.close();
        } catch (Exception e) {        }
        return listaPedido;
    }
    
    public int eliminarPedido (String id) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_deletePedido (?)");
            cs.setString(1, id);

            numFA = cs.executeUpdate();
            cs.close();
            acceDB.close();
            
        } catch (Exception e) {        }
        return numFA;
    }    
}
