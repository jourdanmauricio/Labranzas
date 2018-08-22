package Modelo;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransporteLocalidadDAO {
    
    Conexion conexion;

    public TransporteLocalidadDAO () {
        conexion = new Conexion (); 
    }    

    public ArrayList<TransporteLocalidad> listTransporteLocalidad(String provincia, String localidad) {
        ArrayList experiencia = new ArrayList();
        TransporteLocalidad transporteLocalidad;
        
        String condicion = "";
        if (!provincia.equals("*")) {
            condicion += " and pedido_envio.provincia = '"+provincia+"'";
        }
        if (!localidad.equals("")) {
            condicion += " and pedido_envio.localidad like '%"+localidad+"%'";
        }
        
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select pedido_envio.localidad, pedido_envio.provincia, pedido_envio.transporte, count(*) as cantidad, transporte.domicilio, transporte.remito, transporte.telefono, transporte.provincia from pedido_envio, transporte\n " +
                                                    " where pedido_envio.transporte = transporte.razon_social \n" + condicion +
                                                    " group by pedido_envio.localidad, pedido_envio.provincia, pedido_envio.transporte, transporte.domicilio, transporte.remito, transporte.telefono, transporte.provincia");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                transporteLocalidad = new TransporteLocalidad();
                transporteLocalidad.setLocalidad(rs.getString(1));
                transporteLocalidad.setProvincia(rs.getString(2));
                transporteLocalidad.setTransporte(rs.getString(3));
                transporteLocalidad.setCantidad(rs.getString(4));
                transporteLocalidad.setDomicilio(rs.getString(5));
                transporteLocalidad.setRemito(rs.getString(6));
                transporteLocalidad.setTelefono(rs.getString(7));
                transporteLocalidad.setObservacion(rs.getString(8));                        
                experiencia.add(transporteLocalidad);
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(TransporteLocalidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return experiencia;
    }    
}
