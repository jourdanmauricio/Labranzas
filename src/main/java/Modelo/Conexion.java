
package Modelo;

import com.mysql.jdbc.Connection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    //private final String base = "activos3";
    //private final String user = "root";
    //private final String password = "mau10ti0";
    // private final String url = "jdbc:mysql://localhost:3306/" + base;
    private String user;
    private String password;
    private String base;
    private String servidor;
    private String puerto;
    private String url;

    Properties prop = new Properties();
    
    private Connection con = null;
    
    public Connection getConexion() throws FileNotFoundException, IOException
    {
        
        try{

            SingletonProperties sp=SingletonProperties.getInstancia();
            int ancho_fila = Integer.parseInt(sp.getPropiedad("ancho_fila"));

            user = sp.getPropiedad("usuario"); 
            password = sp.getPropiedad("pass"); 
            base = sp.getPropiedad("base_de_datos"); 
            servidor = sp.getPropiedad("servidor"); 
            puerto = sp.getPropiedad("port"); 
            
            url = "jdbc:mysql://"+servidor+":"+puerto+"/"+base;
              
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            
        } catch(SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      return con;  
    }

}
