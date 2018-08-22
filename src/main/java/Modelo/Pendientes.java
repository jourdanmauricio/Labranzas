package Modelo;

public class Pendientes {
    
    String pedido;
    String subPedido;
    String nombre;
    String idProducto;
    String cantidad; 
    String cemento;
    String vidrio;
    String parafina;
    String envio;
    String observacion;
    
    public Pendientes () {

        pedido= "";
        subPedido= "";
        nombre= "";
        idProducto= "";
        cantidad= ""; 
        cemento= "";
        vidrio = "";
        parafina= "";
        envio= "";
        observacion= "";
    }

    public String getVidrio() {
        return vidrio;
    }

    public void setVidrio(String vidrio) {
        this.vidrio = vidrio;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getSubPedido() {
        return subPedido;
    }

    public void setSubPedido(String subPedido) {
        this.subPedido = subPedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCemento() {
        return cemento;
    }

    public void setCemento(String cemento) {
        this.cemento = cemento;
    }

    public String getParafina() {
        return parafina;
    }

    public void setParafina(String parafina) {
        this.parafina = parafina;
    }

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    
}
