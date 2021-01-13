package monitoreo.modelos;

import java.util.HashMap;
import java.util.Map;

import monitoreo.modelos.impl.Punto;
import monitoreo.modelos.patterns.IVisitor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    public String getDireccion() {
        return direccion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public String getDocumento() {
        return documento;
    }

    public void acceptExportar(IVisitor visitor) {
        visitor.visitDespacho(this);
    }

    public Map<String, String> exportarJson() {

        Map<String, String> json = new HashMap<>();
        json.put("comentarios", getComentarios());
        json.put("direccion", getDireccion());
        json.put("documento", getDocumento());
        Gson gson = new GsonBuilder().create();
        String jsonParse = gson.toJson(json);
        System.out.println("[Visitor]-[Despacho] " + jsonParse);
        return json;
    }

}
