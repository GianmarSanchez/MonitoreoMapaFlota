package monitoreo.modelos;

import com.esri.arcgisruntime.mapping.view.GraphicsOverlay;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import monitoreo.modelos.impl.ImagenIcono;
import monitoreo.modelos.impl.IconoNulo;
import monitoreo.modelos.impl.PoliLinea;
import monitoreo.modelos.impl.Punto;

public class Ventana extends Application {

    private Mapa mapaBase;
    private GraphicsOverlay graphicsOverlay;

    @Override
    public void start(Stage stage) throws Exception {

        // set the title and size of the stage and show it
        stage.setTitle("Sistema de Monitoreo de Vehiculos");
        stage.setWidth(800);
        stage.setHeight(700);
        stage.show();

        // create a JavaFX scene with a stack pane as the root node and add it to the scene
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);
        stage.setScene(scene);

        // create a MapView to display the map and add it to the stack pane
        mapaBase = new Mapa();
        mapaBase.imprimeCoordenadasActual();
        //stackPane.getChildren().add(mapaBase.getMapView());

        Icono imagen = new ImagenIcono("https://upload-icon.s3.us-east-2.amazonaws.com/uploads/icons/png/4498062351543238871-512.png");

        Button btnNuevo = new Button();
        btnNuevo.setGraphic( (imagen.getImageView()!=null)?imagen.getImageView(): new IconoNulo().getImageView() );
        btnNuevo.setText("Nuevo");
        btnNuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                muestraNuevaVentana();
            }
        });

        // https://developers.arcgis.com/java/latest/java/sample-code/change-viewpoint/
        stackPane.getChildren().add(btnNuevo);
        stackPane.setAlignment(btnNuevo, Pos.BOTTOM_CENTER);
        stackPane.setMargin(btnNuevo, new Insets(10, 10, 10, 10));


        // Crear Ruta
        graphicsOverlay = new GraphicsOverlay();
        Punto punto = new Punto(-12.0547, -77.084);
        graphicsOverlay.getGraphics().add(punto.getPunto());
        Double[][] puntos = {
                {-12.0547, -77.084},
                {-12.051457, -77.085320},
                {-12.053728, -77.084544},
                {-12.056421, -77.080346}
        };
        PoliLinea poli = new PoliLinea(puntos);
        graphicsOverlay.getGraphics().add(poli.getPoligono());

        Punto punto2 = new Punto(-12.056421, -77.080346);
        graphicsOverlay.getGraphics().add(punto2.getPunto());

        Double[][] puntos2 = {
                {-12.056421, -77.080346},
                {-12.059836, -77.079162},
                {-12.068173, -77.077901},
                {-12.072885, -77.078516}
        };
        PoliLinea poli2 = new PoliLinea(puntos2);
        graphicsOverlay.getGraphics().add(poli2.getPoligono());

        Punto punto3 = new Punto(-12.072885, -77.078516);
        graphicsOverlay.getGraphics().add(punto3.getPunto());


        mapaBase.getMapView().getGraphicsOverlays().add(graphicsOverlay);

        stackPane.getChildren().add(mapaBase.getMapView());

        // Tipo servicio - ejecutar servicio

        // crear ruta recojo
        // crear ruta entrega
        // crear punto recojo
        // crear punto entrega

    }

    public void muestraNuevaVentana() {
        Stage stage = new Stage();
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);
        stage.setScene(scene);
        stage.setTitle("Sistema de Monitoreo de Vehiculos");
        stage.setWidth(800);
        stage.setHeight(700);

        //  Clonacion de MapaBase
        Mapa mapaBase2 = (Mapa)mapaBase.copiar();

        mapaBase2.imprimeCoordenadasActual();
        stackPane.getChildren().add(mapaBase2.getMapView());

        stage.show();
    }


}
