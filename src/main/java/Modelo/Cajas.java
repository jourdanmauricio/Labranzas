package Modelo;

public class Cajas {

    String id;
    String objeto;
    String cantidad;
    String descObjeto;
    String largo;
    String ancho;
    String largoE;
    String anchoE;

    public Cajas () {
    
        id = "";
        objeto = "";
        cantidad = "";
        descObjeto = "";
        largo = "";
        ancho = "";
        largoE = "";
        anchoE = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescObjeto() {
        return descObjeto;
    }

    public void setDescObjeto(String descObjeto) {
        this.descObjeto = descObjeto;
    }

    public String getLargo() {
        return largo;
    }

    public void setLargo(String largo) {
        this.largo = largo;
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    public String getLargoE() {
        return largoE;
    }

    public void setLargoE(String largoE) {
        this.largoE = largoE;
    }

    public String getAnchoE() {
        return anchoE;
    }

    public void setAnchoE(String anchoE) {
        this.anchoE = anchoE;
    }
    
}
