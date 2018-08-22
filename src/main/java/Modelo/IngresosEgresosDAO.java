package Modelo;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IngresosEgresosDAO {

    Conexion conexion;

    public IngresosEgresosDAO () {
        conexion = new Conexion (); 
    }    
    
public Object[][] listIngresosEgresos() {

    Object [][] ingresosEgresos = null; 
    String anio_anterior = "";
    String anio = "";
    String mes;
    int i = 0;
    int j = 0;
    try {
        Connection acceDB = conexion.getConexion();
        CallableStatement ps = acceDB.prepareCall("SELECT YEAR( fecha_compra ) AS ANIO, MONTH( fecha_compra ) AS MES, sum( total ) AS TOTAL FROM compras GROUP BY YEAR( fecha_compra ) , MONTH( fecha_compra ) ORDER BY YEAR( fecha_compra ) , MONTH( fecha_compra)");
        ResultSet compras = ps.executeQuery();

        ps = acceDB.prepareCall("SELECT YEAR( fecha_compra ) AS ANIO FROM compras GROUP BY YEAR( fecha_compra ) ");
        ResultSet cantAnios = ps.executeQuery();

        ps = acceDB.prepareCall("SELECT YEAR(fventa) as ANIO, MONTH(fventa) as MES, sum(total) as TOTAL FROM pedido WHERE estado <> 'Cancelado' GROUP BY YEAR(fventa), MONTH(fventa) ORDER BY YEAR(fventa), MONTH(fventa)");
        ResultSet ventas = ps.executeQuery();

        cantAnios.last();
        int filasCompras = (cantAnios.getRow()*2);
        
        ingresosEgresos = new Object[filasCompras][14];
        
        for (i=0;i<filasCompras;i++){
            for(j=0;j<14;j++){
                ingresosEgresos[i][j] = 0;
            }
        }        

        i = 0;
        j = 0;
        
        while (compras.next()) {
            anio = compras.getString(1);
            mes = compras.getString(2);
            
            if (j==0) {
                anio_anterior = anio;
                ingresosEgresos[i][0] = anio;
                ingresosEgresos[i][1] = "Egresos";
                ingresosEgresos[i+1][0] = anio;
                ingresosEgresos[i+1][1] = "Ingresos";
                j=1;
            }
            
            if (!anio_anterior.equals(anio)) {
                i=i+2;
                ingresosEgresos[i][0] = anio;
                ingresosEgresos[i][1] = "Egresos";
                ingresosEgresos[i+1][0] = anio;
                ingresosEgresos[i+1][1] = "Ingresos";
                anio_anterior = anio;
            }
            ingresosEgresos[i][Integer.parseInt(compras.getString(2))+1] = compras.getString(3);

        } 
        
        i = 0;
        j = 0;

        while (ventas.next()) {
            anio = ventas.getString(1);
            mes = ventas.getString(2);
            
            if (j==0) {
                anio_anterior = anio;
                ingresosEgresos[i+1][0] = anio;
                ingresosEgresos[i+1][1] = "Ingresos";
                j=1;
            }
            
            if (!anio_anterior.equals(anio)) {
                i=i+2;
                ingresosEgresos[i+1][0] = anio;
                ingresosEgresos[i+1][1] = "Ingresos";
                anio_anterior = anio;
            }
            ingresosEgresos[i+1][Integer.parseInt(ventas.getString(2))+1] = ventas.getString(3);
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
        return ingresosEgresos;
    }    
}
