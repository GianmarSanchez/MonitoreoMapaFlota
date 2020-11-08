package monitoreo.modelos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

        Image img = new Image("https://upload-icon.s3.us-east-2.amazonaws.com/uploads/icons/png/4498062351543238871-512.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(40);
        view.setPreserveRatio(true);

        Button btnNuevo = new Button();
        //btnNuevo.setPrefSize(80, 80);
        btnNuevo.setGraphic(view);
        btnNuevo.setText("Nuevo");
        btnNuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                stage.setWidth(800);
                stage.setHeight(700);
                StackPane stackPane = new StackPane();
                Scene scene = new Scene(stackPane);
                stage.setScene(scene);

                // create a MapView to display the map and add it to the stack pane
                stackPane.getChildren().add(new Mapa().getMapView());

                stage.show();
            }
        });

        stackPane.getChildren().add(btnNuevo);

    }

}