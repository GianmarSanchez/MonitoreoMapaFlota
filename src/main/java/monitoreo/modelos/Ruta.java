package monitoreo.modelos;

import monitoreo.modelos.impl.PoliLinea;
import monitoreo.modelos.impl.Punto;
import monitoreo.modelos.patterns.IVisitor;

public class Ruta {

    private PoliLinea rutaLinea;
    private Punto[] puntos;

    public Ruta(PoliLinea rutaLinea, Punto[] puntos){
        this.rutaLinea = rutaLinea;
        this.puntos = puntos;
    }

    public PoliLinea getRutaLinea() {
        return rutaLinea;
    }

    public Punto[] getPuntos() {
        return puntos;
    }

    public void setRutaLinea(PoliLinea rutaLinea) {
        this.rutaLinea = rutaLinea;
    }

    public void setPuntos(Punto[] puntos) {
        this.puntos = puntos;
    }

    public void exportaRuta(IVisitor visitor)  {
    
        // exportar la informacion visitando cada nodo
        for (Punto punto : getPuntos()) {
            punto.acceptExportar(visitor);
        }
    }

}
