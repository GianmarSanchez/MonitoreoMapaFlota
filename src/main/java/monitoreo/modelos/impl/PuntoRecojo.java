package monitoreo.modelos.impl;

public class PuntoRecojo extends Punto{

    public PuntoRecojo(Double latitud, Double longitud) {
        super(latitud, longitud);
    }

    @Override
    public Double getPrecio() {
        System.out.println("[Punto Recojo] Precio del punto 2 $");
        return 2.0;
    }

    @Override
    public void ejecutarServicio() {
        System.out.println("[Punto] Ejecutando punto");
    }
}
