package monitoreo.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import monitoreo.modelos.impl.RecojoTipoServicio;
import monitoreo.modelos.patterns.Visitor;

import java.util.HashMap;
import java.util.Map;

public class JSONExportVisitor implements Visitor {

    @Override
    public Map<String, String> visitRecojo(Recojo recojo) {
        Map<String, String> json = new HashMap<>();
        json.put("comentarios", recojo.getComentarios());
        json.put("direccion", recojo.getDireccion());
        Gson gson = new GsonBuilder().create();
        String jsonParse = gson.toJson(json);
        System.out.println("[Visitor][Recojo] "+jsonParse);
        return json;
    }

    @Override
    public Map<String, String> visitDespacho(Despacho despacho) {
        Map<String, String> json = new HashMap <>();
        json.put("comentarios", despacho.getComentarios());
        json.put("direccion", despacho.getDireccion());
        json.put("documento", despacho.getDocumento());
        Gson gson = new GsonBuilder().create();
        String jsonParse = gson.toJson(json);
        System.out.println("[Visitor][Despacho] "+jsonParse);
        return json;
    }

}
