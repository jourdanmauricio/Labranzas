package Modelo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SingletonProperties {
    private static SingletonProperties instancia=null;
    private Properties p;
    
    private SingletonProperties() {
        p= new Properties();
//        try {
    
//            Properties p = new Properties();
            try {

            File jarPath=new File(SingletonProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            String propertiesPath=jarPath.getParentFile().getAbsolutePath();
//            System.out.println(" propertiesPath-"+propertiesPath);
//            p.load(new FileInputStream(propertiesPath+"/conf.properties"));
            p.load(new FileInputStream(new File(propertiesPath+"/conf.properties")));
            } catch (IOException e1) {
            e1.printStackTrace();
            }
    

//            p.load(new FileInputStream(new File("src/main/java/Modelo/conf.properties")));
//        } catch (IOException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }    
    
    public static SingletonProperties getInstancia() {
 
        if (instancia==null) {
            instancia=new SingletonProperties();
        }
        return instancia;
    }
 
    public String getPropiedad(String clave) {
 
        return p.getProperty(clave);
    }
}    

