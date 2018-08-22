package Modelo;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RespuestaMLDAO {

    Conexion conexion;

    public RespuestaMLDAO () {
        conexion = new Conexion ();
    }

    public String insertarRespuesta (String id, String respuesta) {
        String rptaRegistro=null;
        
        try {
            Connection acceDB = conexion.getConexion();
            System.out.println("Entro en insertRespuesta");
            CallableStatement cs = acceDB.prepareCall("call sp_insertRespuesta (?,?)");
            cs.setString(1, id);
            cs.setString(2, respuesta);
            
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
            Logger.getLogger(GeografiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rptaRegistro;        
    }

    public ArrayList<String> Llenar_cmbId() {
        ArrayList<String> id = new ArrayList<String>();
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select id from respuestas");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id.add(rs.getString("id"));
            }
            ps.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(GeografiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public String Llenar_txaRespuesta(String Id) {
        String resp=""; 
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select respuesta from respuestas where id = '"+Id+"'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resp = rs.getString("respuesta");
            }
            ps.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(GeografiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public int eliminarRespuesta (String id) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_deleteRespuesta (?)");
            cs.setString(1, id);

            numFA = cs.executeUpdate();

            cs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(GeografiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }    

    public int editarRespuesta (String id, String respuesta)  {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_editRespuesta (?,?)");
            cs.setString(1, id);
            cs.setString(2, respuesta);

            numFA = cs.executeUpdate();

            cs.close();
            acceDB.close();
        } catch(SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(GeografiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }    
}
