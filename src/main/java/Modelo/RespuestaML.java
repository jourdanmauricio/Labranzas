package Modelo;

public class RespuestaML {

    String id;
    String respuesta;

    public RespuestaML () {
        
        id = "";
        respuesta = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
