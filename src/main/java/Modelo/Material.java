package Modelo;

public class Material {
 
    String id;
    String objeto;
    String descripcion;
    String categoria;
    String cantidad;
    String stock;
    String stockMin;
    String stockMax;
    String proveedor;

    public Material () {
        id = "";
        objeto = "";
        descripcion = "";
        categoria = "";
        cantidad = "";
        stock = "";
        stockMin = "";
        stockMax = "";
        proveedor = "";
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getStockMin() {
        return stockMin;
    }

    public void setStockMin(String stockMin) {
        this.stockMin = stockMin;
    }

    public String getStockMax() {
        return stockMax;
    }

    public void setStockMax(String stockMax) {
        this.stockMax = stockMax;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }



}
