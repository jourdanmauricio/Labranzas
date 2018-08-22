package Modelo;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class ClienteDAO {
    
    Conexion conexion;
    
    public ClienteDAO () {
        conexion = new Conexion ();
    }
    
    public String insertCliente (String nom_y_ap, String DNI, String tipo, String referente, String telefono, String mail, String domicilio, String usuario_ml, String observacion, String usuario_creacion, String usuario_ult_mod) {
        String rptaRegistro=null;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_insertCliente (?,?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, nom_y_ap);
            cs.setString(2, DNI);
            cs.setString(3, tipo);
            cs.setString(4, referente);
            cs.setString(5, telefono);            
            cs.setString(6, mail);            
            cs.setString(7, domicilio);           
            cs.setString(8, usuario_ml);           
            cs.setString(9, observacion);  
            cs.setString(10, usuario_creacion);  
            cs.setString(11, usuario_ult_mod);  
            
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
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rptaRegistro;
    }
     
    public ArrayList<Cliente> listCliente(String nomyap, String userML) {
        ArrayList listaCliente = new ArrayList();
        Cliente cliente;

        String condicion = "";
        if (!nomyap.equals("")) {
            condicion += " and cliente.nom_y_ap like '%"+nomyap+"%'";
        }
        if (!userML.equals("")) {
            condicion += " and cliente.usuario_ml like '%"+userML+"%'";
        }

        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("Select * from cliente where 1 = 1  "+condicion+" ORDER BY id DESC");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next() ) {
                cliente = new Cliente();
                cliente.setId(rs.getString(1));
                cliente.setNom_y_ap(rs.getString(2));
                cliente.setDNI(rs.getString(3));
                cliente.setTipo(rs.getString(4));
                cliente.setReferente(rs.getString(5));
                cliente.setTelefono(rs.getString(6));
                cliente.setMail(rs.getString(7));
                cliente.setDomicilio(rs.getString(8));
                cliente.setUsuario_ml(rs.getString(9));
                cliente.setObservacion(rs.getString(10));
                listaCliente.add(cliente);
            }
            ps.close();
            acceDB.close();

        } catch (Exception e) {
            
        }
        return listaCliente;
    }
    
    public ArrayList<String> listClientexid(String clienteId) {
        ArrayList listaCliente = new ArrayList();
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("Select * from cliente where id = "+clienteId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                listaCliente.add(rs.getString("id"));
                listaCliente.add(rs.getString("nom_y_ap"));
                listaCliente.add(rs.getString("DNI"));
                listaCliente.add(rs.getString("tipo"));
                listaCliente.add(rs.getString("referente"));
                listaCliente.add(rs.getString("telefono"));
                listaCliente.add(rs.getString("mail"));
                listaCliente.add(rs.getString("domicilio"));                
                listaCliente.add(rs.getString("usuario_ml"));
                listaCliente.add(rs.getString("observacion"));                
            }
            rs.close();
            acceDB.close();
        } catch (Exception e) { }
        return listaCliente;
    }

    public int editarCliente (String id, String DNI, String nom_y_ap, String tipo, String referente, String telefono, String mail, String domicilio, String usuario_ml, String observacion, String usuario_ult_mod) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_editCliente (?,?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, id);
            cs.setString(2, nom_y_ap);
            cs.setString(3, DNI);
            cs.setString(4, tipo);
            cs.setString(5, referente);
            cs.setString(6, telefono);            
            cs.setString(7, mail);            
            cs.setString(8, domicilio);           
            cs.setString(9, usuario_ml);           
            cs.setString(10, observacion);  
            cs.setString(11, usuario_ult_mod);  

            numFA = cs.executeUpdate();
            
            cs.close();
            acceDB.close();
            
        } catch(SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }
    
    public int eliminarCliente (String id) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_deleteCliente (?)");
            cs.setString(1, id);

            numFA = cs.executeUpdate();

            cs.close();
            acceDB.close();
            
        } catch (Exception e) {
        }
        return numFA;
    }
                              
    public ArrayList<Cliente> buscaClientexNombre (String nombre) {
        
        ArrayList<Cliente> listaCliente = new ArrayList();
        Cliente cliente;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_buscaCxNombre(?)");
            cs.setString(1, nombre);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getString(1));
                cliente.setNom_y_ap(rs.getString(2));
                cliente.setDNI(rs.getString(3));
                cliente.setTipo(rs.getString(4));
                cliente.setReferente(rs.getString(5));
                cliente.setTelefono(rs.getString(6));
                cliente.setMail(rs.getString(7));
                cliente.setDomicilio(rs.getString(8));
                cliente.setUsuario_ml(rs.getString(9));
                cliente.setObservacion(rs.getString(10));
                listaCliente.add(cliente);
            }
            cs.close();
            acceDB.close();
        } catch (SQLException e) {
            System.out.println("Message:  " + e.getMessage());                       
            System.out.println("SQLSTATE: " + e.getSQLState());            
            System.out.println("Código de error SQL: " + e.getErrorCode());
        } catch (IOException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaCliente;
    }

    public ArrayList<Cliente> buscaClientexUser (String nombre) {
        
        ArrayList<Cliente> listaCliente = new ArrayList();
        Cliente cliente;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_buscaCxUser(?)");
            cs.setString(1, nombre);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getString(1));
                cliente.setNom_y_ap(rs.getString(2));
                cliente.setDNI(rs.getString(3));
                cliente.setTipo(rs.getString(4));
                cliente.setReferente(rs.getString(5));
                cliente.setTelefono(rs.getString(6));
                cliente.setMail(rs.getString(7));
                cliente.setDomicilio(rs.getString(8));
                cliente.setUsuario_ml(rs.getString(9));
                cliente.setObservacion(rs.getString(10));
                listaCliente.add(cliente);
            }
            cs.close();
            acceDB.close();

        } catch (SQLException e) {
            System.out.println("Message:  " + e.getMessage());                       
            System.out.println("SQLSTATE: " + e.getSQLState());            
            System.out.println("Código de error SQL: " + e.getErrorCode());
        } catch (IOException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaCliente;
    }

}
