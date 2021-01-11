package monitoreo.modelos;

import monitoreo.modelos.impl.PoliLinea;
import monitoreo.modelos.patterns.RutaStrategy;

public class CamionRutaStrategy implements RutaStrategy {

    public Double[][] crearRuta(Double[][] puntos) {

        Double[][] puntosEntregaVariado = {
            {-12.054456, -77.083491},
            {-12.053510, -77.084607},
            {-12.051269, -77.085371},
            {-12.049934, -77.076910},
            {-12.049819, -77.075715},
            {-12.049354, -77.071379},
            {-12.049451, -77.071354},
            {-12.050152, -77.071312},
            {-12.051030, -77.071231},
            {-12.051804, -77.071147},
            {-12.052032, -77.071068},
            {-12.054760, -77.070884},
            {-12.054577, -77.069197},
            {-12.057725, -77.068353},
            {-12.059279, -77.075558}
        };
        return puntosEntregaVariado;
    }
}
