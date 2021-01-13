package monitoreo.modelos;


import monitoreo.modelos.patterns.IVisitor;

import java.util.Map;

public class JSONExportVisitor implements IVisitor {

    @Override
    public Map<String, String> visitRecojo(Recojo recojo) {

        return recojo.exportarJson();
    }

    @Override
    public Map<String, String> visitDespacho(Despacho despacho) {

        return despacho.exportarJson();
    }

}
