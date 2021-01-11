package monitoreo.modelos;

import monitoreo.modelos.patterns.RutaStrategy;

public class MotoRutaStrategy implements RutaStrategy {

    public Double[][] crearRuta(Double[][] puntos) {

        Double[][] puntosEntregaVariado = {
                {-12.054456, -77.083491},
                {-12.056025, -77.081278},
                {-12.056520, -77.080370},
                {-12.057158, -77.079955},
                {-12.058076, -77.079692},
                {-12.059265, -77.079392},
                {-12.060343, -77.079129},
                {-12.059506, -77.075500},
                {-12.059249, -77.075532}
        };
        return puntosEntregaVariado;
    }
}
