package Modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

public class Backup {
    private int BUFFER = 10485760;  
    //para guardar en memmoria
    private StringBuffer temp = null;
    //para guardar el archivo SQL
    private FileWriter  fichero = null;
    private PrintWriter pw = null;
    
    public boolean CrearBackup(String host, String port, String user, String password, String db, String file_backup){
    boolean ok=false;
    try{       
        //sentencia para crear el BackUp
         Process run = Runtime.getRuntime().exec(
        "mysqldump --host=" + host + " --port=" + port +
        " --user=" + user + " --password=" + password +
        " --compact --complete-insert --extended-insert --skip-quote-names" +
        " --skip-comments --routines " + db);
        //se guarda en memoria el backup
        InputStream in = run.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        temp = new StringBuffer();
        int count;
        char[] cbuf = new char[BUFFER];
        while ((count = br.read(cbuf, 0, BUFFER)) != -1)
            temp.append(cbuf, 0, count);
        br.close();
        in.close();        
//         se crea y escribe el archivo SQL 
        fichero = new FileWriter(file_backup);
        pw = new PrintWriter(fichero);                                                    
        pw.println(temp.toString());  
        ok=true;
   }
    catch (Exception ex){
            ex.printStackTrace();
    } finally {
       try {           
         if (null != fichero)
              fichero.close();
       } catch (Exception e2) {
           e2.printStackTrace();
       }
    }   
    return ok; 
 }  
    
    public boolean restore(String user, String password, String db, String file_backup, String source){
        boolean ok=false;       
            
        Conexion conexion;

        Statement sentencia = null;
        conexion = new Conexion ();

        try {

            Connection acceDB = conexion.getConexion();

            sentencia = acceDB.createStatement();
            String comsSQLborra = "DROP DATABASE " + db;
            sentencia.executeUpdate(comsSQLborra);

            sentencia = acceDB.createStatement();
            String comsSQL = "CREATE DATABASE "+db;
            sentencia.executeUpdate(comsSQL);
       
            Process p = Runtime
            .getRuntime()
            .exec("mysql -u root -pmau10ti0 activos3");

            OutputStream os = p.getOutputStream();
            FileInputStream fis = new FileInputStream("/home/mauricio/Dropbox/BD/activos3.sql");
            byte[] buffer = new byte[1000];

            int leido = fis.read(buffer);
            while (leido > 0) {
                os.write(buffer, 0, leido);
                leido = fis.read(buffer);
            }

            os.flush();
            os.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return false;
    }
}    

    
    
