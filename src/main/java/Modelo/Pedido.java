package Modelo;

public class Pedido {
    
    String id;
    String idCliente;
    String fventa;
    String fentrega;
    String estado;
    String senia;
    String subTotal;
    String pdesc;
    String total;
    String saldo;
    String fpago;
    String fact;
    String cita;
    String envio;
    String domicilioEntrega;
    String observacion;
    
    public  Pedido () {
        id = "";
        idCliente = "";
        fventa = "";
        fentrega = "";
        estado = "";
        senia = "";
        subTotal = "";
        pdesc = "";        
        total = "";
        saldo = "";
        fpago = "";
        fact = "";
        cita = "";
        envio = "";
        domicilioEntrega = "";
        observacion = "";
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getFventa() {
        return fventa;
    }

    public void setFventa(String fventa) {
        this.fventa = fventa;
    }

    public String getFentrega() {
        return fentrega;
    }

    public void setFentrega(String fentrega) {
        this.fentrega = fentrega;
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

    public String getFpago() {
        return fpago;
    }

    public void setFpago(String fpago) {
        this.fpago = fpago;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public String getCita() {
        return cita;
    }

    public void setCita(String cita) {
        this.cita = cita;
    }

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public String getDomicilioEntrega() {
        return domicilioEntrega;
    }

    public void setDomicilioEntrega(String domicilioEntrega) {
        this.domicilioEntrega = domicilioEntrega;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
