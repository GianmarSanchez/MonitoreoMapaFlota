package monitoreo.modelos.patterns;

import monitoreo.modelos.Despacho;
import monitoreo.modelos.Recojo;

import java.util.Map;

public interface IVisitor {

    Map<String, String> visitRecojo(Recojo recojo);
    Map<String, String> visitDespacho(Despacho despacho);

}