package Modelo;

public class ListaPedido {

    String pedido;
    String spd;
    String prod;
    String cant;
    String clienteId;
    String nomyap;
    String fechaCompra;
    String fechaEntrega;
    String estado;
    String senia;
    String desc;
    String subTotal;
    String total;
    String saldo;
    String fact;
    String formaPago;
    String envio;
    String domEntrega;
    String usuarioML;
    String cita;
    String observacion;
    
        public ListaPedido () {

        pedido = "";
        spd = "";
        prod = "";
        cant = "";
        clienteId = "";
        nomyap = "";
        fechaCompra = "";
        fechaEntrega = "";
        estado = "";
        senia = "";
        subTotal = "";        
        desc = "";
        total = "";
        saldo = "";
        fact = "";
        formaPago = "";
        envio = "";
        domEntrega = "";
        usuarioML="";
        cita = "";
        observacion = "";        
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCita() {
        return cita;
    }

    public String getDomEntrega() {
        return domEntrega;
    }

    public void setDomEntrega(String domEntrega) {
        this.domEntrega = domEntrega;
    }

    public void setCita(String cita) {
        this.cita = cita;
    }
    
    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getUsuarioML() {
        return usuarioML;
    }

    public void setUsuarioML(String usuarioML) {
        this.usuarioML = usuarioML;
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

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public String getNomyap() {
        return nomyap;
    }

    public void setNomyap(String nomyap) {
        this.nomyap = nomyap;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSenia() {
        return senia;
    }

    public void setSenia(String senia) {
        this.senia = senia;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
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

