package monitoreo.modelos;


import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.mapping.view.GraphicsOverlay;
import javafx.scene.layout.StackPane;

public class FachadaMapa {

    private GraphicsOverlay graphicsOverlay;

    public FachadaMapa(){
        graphicsOverlay = new GraphicsOverlay();
    }

    public Mapa mostrarMapa(StackPane stackPane)  {

        Mapa mapaBase = new Mapa();
        mapaBase.imprimeCoordenadasActual();
        stackPane.getChildren().add(mapaBase.getMapView());
        return mapaBase;
    }

    public void addgraphicsOverlay(Graphic graphic){
        this.graphicsOverlay.getGraphics().add(graphic);
    }
}