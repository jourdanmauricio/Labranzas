package Modelo;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class CajasDAO {

    Conexion conexion;
    
    public CajasDAO () {
        conexion = new Conexion ();
    }
    
    public String insertCaja (String objeto, String cantidad, String descObjeto, String largo, String ancho, String largoE, String anchoE) {
        String rptaRegistro=null;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_insertCaja (?,?,?,?,?,?,?)");
            cs.setString(1, objeto);
            cs.setString(2, cantidad);
            cs.setString(3, descObjeto);
            cs.setString(4, largo);
            cs.setString(5, ancho);            
            cs.setString(6, largoE);            
            cs.setString(7, anchoE);           
            
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

    public ArrayList<Cajas> listCajas() {
        ArrayList listaCajas = new ArrayList();
        Cajas caja;

        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("Select * from cajas ORDER BY objeto DESC");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next() ) {
                caja = new Cajas();
                caja.setId(rs.getString(1));
                caja.setObjeto(rs.getString(2));
                caja.setCantidad(rs.getString(3));
                caja.setDescObjeto(rs.getString(4));
                caja.setLargo(rs.getString(5));
                caja.setAncho(rs.getString(6));
                caja.setLargoE(rs.getString(7));
                caja.setAnchoE(rs.getString(8));
                listaCajas.add(caja);
            }
            ps.close();
            acceDB.close();

        } catch (Exception e) {
        }
        return listaCajas;
    }

    public int editarCaja (String id, String objeto, String cantidad, String descObjeto, String largo, String ancho, String largoE, String anchoE) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_editCaja (?,?,?,?,?,?,?,?)");
            cs.setString(1, id);
            cs.setString(2, objeto);
            cs.setString(3, cantidad);
            cs.setString(4, descObjeto);
            cs.setString(5, largo);
            cs.setString(6, ancho);            
            cs.setString(7, largoE);            
            cs.setString(8, anchoE);           

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
    
    public int eliminarCaja (String id) {
        int numFA = 0;
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("call sp_deleteCaja (?)");
            cs.setString(1, id);

            numFA = cs.executeUpdate();

            cs.close();
            acceDB.close();
            
        } catch (Exception e) {
        }
        return numFA;
    }
}
