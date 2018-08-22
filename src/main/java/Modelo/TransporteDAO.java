package Modelo;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransporteDAO {
    Conexion conexion;

    public TransporteDAO () {
        conexion = new Conexion ();
    }
    
    public String insertTransporte (String razon_social, String domicilio, String barrio, String remito, String web, String telefono, String mail, String provincia, String usuario_creacion, String usuario_ult_mod) {
        String rptaRegistro=null;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_insertTransporte (?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, razon_social);
            cs.setString(2, domicilio);
            cs.setString(3, barrio);
            cs.setString(4, remito);
            cs.setString(5, web);            
            cs.setString(6, telefono);            
            cs.setString(7, mail);           
            cs.setString(8, provincia);           
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
            Logger.getLogger(TransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rptaRegistro;
    }

    public ArrayList<Transporte> listTransporte(String razonSocial, String provincia) {
        ArrayList listaTransporte = new ArrayList();
        Transporte transporte;

        String condicion = "";
        if (!razonSocial.equals("")) {
            condicion += " and razon_social like '%"+razonSocial+"%'";
        }
        if (!provincia.equals("")) {
            condicion += " and provincia like '%"+provincia+"%'";
        }
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("Select * from transporte where 1 = 1 " +condicion+" order by razon_social");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                transporte = new Transporte();
                transporte.setId(rs.getString(1));
                transporte.setRazon_social(rs.getString(2));
                transporte.setDomicilio(rs.getString(3));
                transporte.setBarrio(rs.getString(4));
                transporte.setRemito(rs.getString(5));
                transporte.setWeb(rs.getString(6));
                transporte.setTelefono(rs.getString(7));
                transporte.setMail(rs.getString(8));
                transporte.setProvincia(rs.getString(9));
                listaTransporte.add(transporte);
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(TransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTransporte;
    }
    
        public int editarTransporte (String id, String razon_social, String domicilio, String barrio, String remito, String web, String telefono, String mail, String provincia, String usuario_ult_mod) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_editTransporte (?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, id);
            cs.setString(2, razon_social);
            cs.setString(3, domicilio);
            cs.setString(4, barrio);
            cs.setString(5, remito);
            cs.setString(6, web);            
            cs.setString(7, telefono);            
            cs.setString(8, mail);           
            cs.setString(9, provincia);           
            cs.setString(10, usuario_ult_mod);  

            numFA = cs.executeUpdate();
            cs.close();
            acceDB.close();
        } catch(SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(TransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }

    public int eliminarTransporte (String id) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_deleteTransporte (?)");
            cs.setString(1, id);

            numFA = cs.executeUpdate();
            cs.close();
            acceDB.close();
        } catch (SQLException e) {
            System.out.println("Message:  " + e.getMessage());                       
            System.out.println("SQLSTATE: " + e.getSQLState());            
            System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(TransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFA;
    }

    public ArrayList<String> Llenar_cmbTransporte() {
        ArrayList<String> transportes = new ArrayList<String>();
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select distinct(razon_social) as transporte from transporte order by razon_social");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                transportes.add(rs.getString("transporte"));
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(TransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transportes;
    }

}
