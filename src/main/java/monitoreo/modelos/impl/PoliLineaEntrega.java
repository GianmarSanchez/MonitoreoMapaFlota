package monitoreo.modelos.impl;

public class PoliLineaEntrega extends PoliLinea {

    public PoliLineaEntrega(Double[][] puntos) {
        super(puntos);
    }

    @Override
    public void ejecutarServicio(){
        System.out.println("[PoliLineaEntrega] En ruta para Entrega");
        System.out.println("[PoliLineaEntrega] Notificando receptor");
    }
}
