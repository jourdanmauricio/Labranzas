package Modelo;

public class Spd {
    
    String pedido;
    String spd;
    String estado;
    String cemento;
    String vidrio;
    String parafina;
    String idProducto;
    String cantidad;
    String precio;
    String total;
    String observacion;
    
    public  Spd () {
        pedido = "";
        spd = "";
        estado = "";
        cemento = "";
        vidrio = "";
        parafina = "";
        idProducto = "";
        cantidad = "";
        precio = "";
        total = "";
        observacion = "";
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getSpd() {
        return spd;
    }

    public void setSpd(String spd) {
        this.spd = spd;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCemento() {
        return cemento;
    }

    public void setCemento(String cemento) {
        this.cemento = cemento;
    }

    public String getVidrio() {
        return vidrio;
    }

    public void setVidrio(String vidrio) {
        this.vidrio = vidrio;
    }

    public String getParafina() {
        return parafina;
    }

    public void setParafina(String parafina) {
        this.parafina = parafina;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
