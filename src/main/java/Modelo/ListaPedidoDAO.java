package Modelo;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaPedidoDAO {

    Conexion conexion;

    public ListaPedidoDAO () {
        conexion = new Conexion ();
    }
    
    public ArrayList<ListaPedido> listPedidos(String estado, String nomyap, String userML) {
        ArrayList listaPedidos = new ArrayList();
        ListaPedido pedidos;

        String condicion = "";
        if (!estado.equals("*")) {
            condicion += " and pedido.estado = '"+estado+"'";
        }
        if (!nomyap.equals("*")) {
            condicion += " and cliente.nom_y_ap like '%"+nomyap+"%'";
        }
        if (!userML.equals("*")) {
            condicion += " and cliente.usuario_ml like '%"+userML+"%'";
        }

        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("SELECT pedido.id, sub_pedido.sub_pedido, sub_pedido.id_producto, sub_pedido.cantidad, cliente.id, cliente.nom_y_ap, pedido.fventa, pedido.fentrega, pedido.estado, pedido.senia, pedido.sub_total, pedido.descuento, pedido.total, pedido.saldo, pedido.fact, pedido.forma_pago, pedido.envio, pedido.domicilio_entrega, cliente.usuario_ml, pedido.cita, pedido.observacion FROM pedido, sub_pedido, cliente, producto WHERE pedido.id_cliente = cliente.id and sub_pedido.pedido = pedido.id and producto.id = sub_pedido.id_producto "+condicion+" order by pedido.id desc");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pedidos = new ListaPedido();
                pedidos.setPedido(rs.getString(1));
                pedidos.setSpd(rs.getString(2));
                pedidos.setProd(rs.getString(3));
                pedidos.setCant(rs.getString(4));
                pedidos.setClienteId(rs.getString(5));
                pedidos.setNomyap(rs.getString(6));
                pedidos.setFechaCompra(rs.getString(7));
                pedidos.setFechaEntrega(rs.getString(8));
                pedidos.setEstado(rs.getString(9));
                pedidos.setSenia(rs.getString(10));
                pedidos.setSubTotal(rs.getString(11));
                pedidos.setDesc(rs.getString(12));                
                pedidos.setTotal(rs.getString(13));
                pedidos.setSaldo(rs.getString(14));
                pedidos.setFact(rs.getString(15));
                pedidos.setFormaPago(rs.getString(16));
                pedidos.setEnvio(rs.getString(17));
                pedidos.setDomEntrega(rs.getString(18));
                pedidos.setUsuarioML(rs.getString(19));
                pedidos.setCita(rs.getString(20));
                pedidos.setObservacion(rs.getString(21));
                listaPedidos.add(pedidos);
            }
            rs.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(ListaPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPedidos;
    }    
    
    public ArrayList<String> Llenar_cmbEstado() {
        ArrayList<String> estados = new ArrayList<String>();
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement ps = acceDB.prepareCall("select estado from estado_pedido");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                estados.add(rs.getString("estado"));
            }
            ps.close();
            acceDB.close();
        } catch (SQLException e) {
                System.out.println("Message:  " + e.getMessage());                       
                System.out.println("SQLSTATE: " + e.getSQLState());            
                System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(ListaPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estados;
    }
    
    public Object[][] listPedPorEstado() {
        Object [][] pedxestado = null; 
        
    try {
        java.sql.Connection acceDB = conexion.getConexion();
        CallableStatement ps = acceDB.prepareCall("select estado, sum(total) as total, count(*) as cantidad from pedido group by estado");
        ResultSet pedxest = ps.executeQuery();

        pedxestado = new Object[4][3];
       
        int i = 0;
        while (pedxest.next()) {
            pedxestado[i][0] = pedxest.getString(1);
            pedxestado[i][1] = pedxest.getString(2);                
            pedxestado[i][2] = pedxest.getString(3);
            i=i+1;
        }

        ps.close();
        acceDB.close();
        }catch (SQLException e) {
            System.out.println("Message:  " + e.getMessage());                       
            System.out.println("SQLSTATE: " + e.getSQLState());            
            System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(IngresosEgresosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedxestado;
    }    

    public Object[][] listCantPorProd() {
        Object [][] cantxprod = null; 
        int filas=0;
        
    try {
        java.sql.Connection acceDB = conexion.getConexion();
        CallableStatement ps = acceDB.prepareCall("select id_producto as prod, sum(cantidad) as cantidad from sub_pedido where estado <> 'Cancelado'  group by id_producto order by cantidad desc");
        ResultSet prodxcant = ps.executeQuery();
        
        if (prodxcant.last()) {
            filas = prodxcant.getRow();
        }
            
        cantxprod = new Object[filas][2];
        
        prodxcant.first();
        for (int i=0;i<filas;i++) {
            cantxprod[i][0] = prodxcant.getString(1);
            cantxprod[i][1] = prodxcant.getString(2);
            prodxcant.next();
        }

        ps.close();
        acceDB.close();
        }catch (SQLException e) {
            System.out.println("Message:  " + e.getMessage());                       
            System.out.println("SQLSTATE: " + e.getSQLState());            
            System.out.println("Código de error SQL: " + e.getErrorCode()); 
        } catch (IOException ex) {
            Logger.getLogger(IngresosEgresosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantxprod;
    }    
           
}
