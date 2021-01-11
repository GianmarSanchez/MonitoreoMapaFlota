package monitoreo.modelos;

import monitoreo.modelos.impl.Punto;
import monitoreo.modelos.patterns.Visitor;

public class Despacho extends Punto {

    private String direccion;
    private String comentarios;
    private String documento;

    public Despacho(double lon, double lat) {
        super(lon, lat);
    }

    public Despacho(double lon, double lat, String direccion, String comentarios, String documento) {
        super(lon, lat);
        this.direccion = direccion;
        this.comentarios = comentarios;
        this.documento = documento;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getComentarios(){
        return comentarios;
    }

    public String getDocumento(){
        return documento;
    }

    public void accept(Visitor visitor) {
        visitor.visitDespacho(this);
    }

}
