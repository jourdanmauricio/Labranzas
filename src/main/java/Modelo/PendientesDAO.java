package Modelo;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PendientesDAO {

    Conexion conexion;    

    public PendientesDAO () {
        conexion = new Conexion ();
    }    
    public ArrayList<Pendientes> listPendiente(String sector) {
        ArrayList listaPendientes = new ArrayList();
        Pendientes pendiente;

        String condicion = " and spd." + sector + " = 'N'";

        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("SELECT spd.pedido as Pedido, spd.sub_pedido as Spd, cli.nom_y_ap as Nom, spd.id_producto as Prod, spd.cantidad as Cant, spd.cemento as CE, spd.vidrio as VI, spd.parafina as PA, ped.envio as env, spd.observacion FROM sub_pedido spd, pedido ped, cliente cli WHERE ped.id = spd.pedido AND cli.id = ped.id_cliente AND ped.estado in ('Activo', 'Pedido') AND spd.estado NOT IN ('Cancelado', 'Terminado', 'Entregado') " + condicion);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next() ) {
                pendiente = new Pendientes();
                pendiente.setPedido(rs.getString(1));
                pendiente.setSubPedido(rs.getString(2));
                pendiente.setNombre(rs.getString(3));
                pendiente.setIdProducto(rs.getString(4));
                pendiente.setCantidad(rs.getString(5));
                pendiente.setCemento(rs.getString(6));
                pendiente.setVidrio(rs.getString(7));
                pendiente.setParafina(rs.getString(8));
                pendiente.setEnvio(rs.getString(9));
                pendiente.setObservacion(rs.getString(10));
                listaPendientes.add(pendiente);
            }
            ps.close();
            rs.close();
            acceDB.close();
        } catch (Exception e) {         }
        return listaPendientes;
    }
        
    public boolean editarSpd (String pedido, String spd, String cemento, String vidrio, String parafina, String usuario_ult_mod) {
        boolean resultado = false;
        
        try {
            Connection acceDB = conexion.getConexion();

            Statement sentencia = acceDB.createStatement();
            String updSpd = "update sub_pedido set cemento = '"+ cemento +"', vidrio = '" + vidrio +"', parafina = '"+parafina+"', usuario_ult_mod = '"+usuario_ult_mod+"' where pedido = "+pedido+" and sub_pedido = "+spd;
            sentencia.executeUpdate(updSpd);

            PreparedStatement ps = acceDB.prepareStatement("UPDATE sub_pedido SET cemento= ?, vidrio = ?, parafina = ?, usuario_ult_mod = ? WHERE pedido = ? AND sub_pedido = ?");

            // set the preparedstatement parameters
            ps.setString(1,cemento);
            ps.setString(2,vidrio);
            ps.setString(3,parafina);
            ps.setString(4,usuario_ult_mod);
            ps.setString(5,pedido);
            ps.setString(6,spd);

            ps.executeUpdate();
            ps.close();
            acceDB.close();
            
            resultado = true;
            
        } catch(SQLException e) {
                resultado = false;
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(PendientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
