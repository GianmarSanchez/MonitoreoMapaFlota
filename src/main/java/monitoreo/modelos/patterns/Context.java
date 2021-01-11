package monitoreo.modelos.patterns;

public class Context {

    private RutaStrategy strategy;

    public void setStrategy(RutaStrategy strategy) {
        this.strategy = strategy;
    }

    public Double[][] crearRuta(Double[][] puntos){
        return this.strategy.crearRuta(puntos);
    }

}
