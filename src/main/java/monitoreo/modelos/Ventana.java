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
import monitoreo.modelos.impl.*;
import monitoreo.modelos.interfaces.IGrafico;

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


        // Entregas programadas para una misma ruta
        Double costoTotal = 0.0;
        EntregaProgramada entrega1 = new EntregaProgramada("09:00-10:00", "23/07/2020");
        costoTotal += entrega1.calcularCosto();

        EntregaProgramada entrega2 = new EntregaProgramada("09:00-10:00", "23/07/2020");
        costoTotal += entrega2.calcularCosto();

        EntregaProgramada entrega3 = new EntregaProgramada("09:00-10:00", "23/07/2020");
        costoTotal += entrega3.calcularCosto();

        System.out.println("[Cliente] Costo total "+costoTotal);


        // Crear ruta con entrega y recojo
        // Alertas y notificaciones
        graphicsOverlay = new GraphicsOverlay();
        Punto puntoRecojo = new PuntoRecojo(-12.054901, -77.085470);
        puntoRecojo.ejecutarServicio();
        graphicsOverlay.getGraphics().add(puntoRecojo.getPunto());
        Double[][] puntosEntrega = {
                {-12.054901, -77.085470},
                {-12.051833, -77.087903},
                {-12.061104, -77.084243},
                {-12.060876, -77.082660},
                {-12.067592, -77.081687},
                {-12.072936, -77.083132}
        };
        PoliLinea poliEntrega = new PoliLineaEntrega(puntosEntrega);
        graphicsOverlay.getGraphics().add(poliEntrega.getPoligono());
        poliEntrega.ejecutarServicio();

        Punto puntoEntrega = new Punto(-12.072936, -77.083132);
        graphicsOverlay.getGraphics().add(puntoEntrega.getPunto());
        puntoEntrega.ejecutarServicio();

        mapaBase.getMapView().getGraphicsOverlays().add(graphicsOverlay);

        stackPane.getChildren().add(mapaBase.getMapView());

        // especifar la parte a mejorar

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
