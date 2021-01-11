package monitoreo.modelos.patterns;

import monitoreo.modelos.impl.PoliLinea;

public interface RutaStrategy {

    Double[][] crearRuta(Double[][] puntos);

}
