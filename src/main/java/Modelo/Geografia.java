package Modelo;

public class Geografia {

    String id;
    String id_provincia;
    String provincia;
    String codigo_postal;
    String id_localidad;
    String localidad;

    public Geografia () {
        id = "";
        id_provincia = "";
        provincia = "";
        codigo_postal = "";
        id_localidad = "";
        localidad = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(String id_provincia) {
        this.id_provincia = id_provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getId_localidad() {
        return id_localidad;
    }

    public void setId_localidad(String id_localidad) {
        this.id_localidad = id_localidad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    
}
