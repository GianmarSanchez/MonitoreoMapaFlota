package monitoreo.modelos;

import java.util.HashMap;
import java.util.Map;

import monitoreo.modelos.impl.Punto;
import monitoreo.modelos.patterns.IVisitor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Recojo extends Punto {

    private String direccion;
    private String comentarios;

    public Recojo(double lon, double lat) {
        super(lon, lat);
    }

    public Recojo(double lon, double lat, String direccion, String comentarios) {
        super(lon, lat);
        this.direccion = direccion;
        this.comentarios = comentarios;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getComentarios(){
        return comentarios;
    }

    public void acceptExportar(IVisitor visitor) {
        visitor.visitRecojo(this);
    }

    public Map<String, String> exportarJson()   {
        
        Map<String, String> json = new HashMap<>();
        json.put("comentarios", getComentarios());
        json.put("direccion", getDireccion());
        Gson gson = new GsonBuilder().create();
        String jsonParse = gson.toJson(json);
        System.out.println("[Visitor]-[Recojo] "+jsonParse);
        return json;
    }
}
