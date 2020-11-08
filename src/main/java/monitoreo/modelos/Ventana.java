package monitoreo.modelos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ventana extends Application {

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
        stackPane.getChildren().add(new Mapa().getMapView());

    }

}