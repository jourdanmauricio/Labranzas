package Modelo;

public class Cliente {
    
    String id;
    String nom_y_ap;
    String DNI;
    String tipo;
    String referente;
    String telefono;
    String mail;
    String domicilio;
    String usuario_ml;
    String observacion;
    
    public Cliente () {
        id = "";
        nom_y_ap = "";
        DNI = "";
        tipo = "";
        referente = "";
        telefono = "";
        mail = "";
        domicilio = "";
        observacion = "";
       
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom_y_ap() {
        return nom_y_ap;
    }

    public void setNom_y_ap(String nom_y_ap) {
        this.nom_y_ap = nom_y_ap;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReferente() {
        return referente;
    }

    public void setReferente(String referente) {
        this.referente = referente;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getUsuario_ml() {
        return usuario_ml;
    }

    public void setUsuario_ml(String usuario_ml) {
        this.usuario_ml = usuario_ml;
    }
}