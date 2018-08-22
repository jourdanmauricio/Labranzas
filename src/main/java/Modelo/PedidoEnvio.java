package Modelo;

public class PedidoEnvio {

    String pedido;
    String referente;
    String dni;
    String telefono;
    String domEntrega;
    String localidad;
    String codigoPostal;
    String provincia;
    String envioADom;
    String transporte;
    String cantCajas;
    String obsEnvio;

    public PedidoEnvio () {

        pedido = "";
        referente = "";
        dni = "";
        telefono = "";
        domEntrega = "";
        localidad = "";
        codigoPostal = "";
        provincia = "";
        envioADom = "";
        transporte = "";
        cantCajas = "";
        obsEnvio = "";        
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getReferente() {
        return referente;
    }

    public void setReferente(String referente) {
        this.referente = referente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomEntrega() {
        return domEntrega;
    }

    public void setDomEntrega(String domEntrega) {
        this.domEntrega = domEntrega;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEnvioADdom() {
        return envioADom;
    }

    public void setEnvioADom(String envioADom) {
        this.envioADom = envioADom;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public String getCantCajas() {
        return cantCajas;
    }

    public void setCantCajas(String cantCajas) {
        this.cantCajas = cantCajas;
    }

    public String getObsEnvio() {
        return obsEnvio;
    }

    public void setObsEnvio(String obsEnvio) {
        this.obsEnvio = obsEnvio;
    }
    
}
