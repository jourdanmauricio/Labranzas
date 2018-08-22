package Modelo;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeografiaDAO {
    
    Conexion conexion;
    
    public GeografiaDAO () {
        conexion = new Conexion ();
    }

    public String insertarGeografia (String id, String idProvincia, String provincia, String codigoPostal, String idLocalidad, String localidad, String usuario_creacion, String usuario_ult_mod) {
        String rptaRegistro=null;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_insertGeografia (?,?,?,?,?,?,?,?)");
            cs.setString(1, id);
            cs.setString(2, idProvincia);
            cs.setString(3, provincia);
            cs.setString(4, codigoPostal);
            cs.setString(5, idLocalidad);            
            cs.setString(6, localidad);            
            cs.setString(7, usuario_creacion);  
            cs.setString(8, usuario_ult_mod);  
            
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
        
    public ArrayList<Geografia> listGeografia(String provincia, String localidad) {
        ArrayList listaGeografia = new ArrayList();
        Geografia geografia;

        String condicion = "";
        if (!provincia.equals("*")) {
            condicion += " and provincia = '"+provincia+"'";
        }
        if (!localidad.equals("")) {
            condicion += " and localidad like '%"+localidad+"%'";
        }
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("Select * from localidad where 1 = 1  "+condicion);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next() ) {
                geografia = new Geografia();
                geografia.setId(rs.getString(1));
                geografia.setId_provincia(rs.getString(2));
                geografia.setProvincia(rs.getString(3));
                geografia.setCodigo_postal(rs.getString(4));
                geografia.setId_localidad(rs.getString(5));
                geografia.setLocalidad(rs.getString(6));
                listaGeografia.add(geografia);
            }

            ps.close();
            acceDB.close();
        } catch (Exception e) {  }
        return listaGeografia;
    }    
    
    public ArrayList<String> Llenar_cmbProvincia() {
        ArrayList<String> provincias = new ArrayList<String>();
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select distinct(provincia) as prov from localidad order by provincia");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                provincias.add(rs.getString("prov"));
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
        return provincias;
    }

    public int eliminarGeografia (String id) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_deleteGeografia (?)");
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

    public int editarGeografia (String id, String idProvincia, String provincia, String codigoPostal, String idLocalidad, String localidad, String usuario_ult_mod)  {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_editGeografia (?,?,?,?,?,?,?)");
            cs.setString(1, id);
            cs.setString(2, idProvincia);
            cs.setString(3, provincia);
            cs.setString(4, codigoPostal);
            cs.setString(5, idLocalidad);
            cs.setString(6, localidad);            
            cs.setString(7, usuario_ult_mod);  

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

    public String listMaxId() {
        String maxId = "";
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select max(id) as id from localidad");
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                maxId= rs.getString("id");
                if (maxId==null) {
                    maxId="0";
                }
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
        return maxId;
    }    
}
