package monitoreo.modelos.impl;

public class PoliLineaRecojo extends PoliLinea {

    public PoliLineaRecojo(Double[][] puntos) {
        super(puntos);
    }

    @Override
    public void ejecutarServicio(){
        System.out.println("[PoliLinea Recojo] En ruta para Recojo");
    }
}
