package monitoreo.modelos.impl;

public class PuntoEntrega extends Punto{

    public PuntoEntrega(Double latitud, Double longitud) {
        super(latitud, longitud);
    }

    @Override
    public Double getPrecio() {
        System.out.println("[Punto entrega] Precio del punto de entrega 0 $");
        return 0.0;
    }

    @Override
    public void ejecutarServicio(){
        System.out.println("[Punto entrega] Ejecutando entrega en punto");
    }
}
