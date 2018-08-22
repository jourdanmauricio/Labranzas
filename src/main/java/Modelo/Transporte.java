package Modelo;

public class Transporte {
    String id; 
    String razon_social;
    String domicilio;
    String barrio;
    String remito;
    String web;
    String telefono;
    String mail;
    String provincia;  
    
    public Transporte () {
        id = "";
        razon_social = "";
        domicilio = "";
        barrio = "";
        remito = "";
        web = "";
        telefono = "";
        mail = "";
        provincia = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getRemito() {
        return remito;
    }

    public void setRemito(String remito) {
        this.remito = remito;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
