package monitoreo.modelos;

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
import monitoreo.modelos.interfaces.ITipoServicio;
import monitoreo.modelos.patterns.Context;

public class Ventana extends Application {

    private Mapa mapaBase;
    //private GraphicsOverlay graphicsOverlay;

    @Override
    public void start(Stage stage) throws Exception {

        FachadaMapa facade = new FachadaMapa(stage);
        facade.mostrarMapa();

        facade.getMapaBase().imprimeCoordenadasActual();

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
        facade.getStackPane().getChildren().add(btnNuevo);
        facade.getStackPane().setAlignment(btnNuevo, Pos.BOTTOM_CENTER);
        facade.getStackPane().setMargin(btnNuevo, new Insets(10, 10, 10, 10));


        /*
        // Entregas programadas para una misma ruta
        // Double costoTotal = 0.0; No es necesario usar un acumulador
        GuiaEntrega guia = new GuiaEntrega();
        guia.agregarEntrega(new EntregaProgramada("09:00-10:00", "14/12/2020"));
        guia.agregarEntrega(new EntregaProgramada("10:00-11:00", "14/12/2020"));
        guia.agregarEntrega(new EntregaProgramada("12:00-13:00", "14/12/2020"));
        guia.listarEntrega();

        GuiaEntrega guiaGeneral = new GuiaEntrega();
        guiaGeneral.agregarEntrega(new EntregaProgramada("13:00-14:00", "15/12/2020"));
        guiaGeneral.agregarEntrega(new EntregaProgramada("15:00-16:00", "15/12/2020"));
        guiaGeneral.agregarEntrega(guia);

        System.out.println("[Cliente][Guia General] Costo total "+guiaGeneral.calcularCosto());



        // Crear ruta con entrega y recojo
        // Alertas y notificaciones
        // Eliminar clases que repiten comportamiento
        ITipoServicio recojo = new RecojoTipoServicio();
        ITipoServicio entrega = new EntregaTipoServicio();

        //graphicsOverlay = new GraphicsOverlay();
        Punto puntoRecojo = new Punto(recojo, -12.054901, -77.085470);
        puntoRecojo.ejecutarServicio();
        //graphicsOverlay.getGraphics().add(puntoRecojo.getPunto());
        facade.addGraphicsOverlay(puntoRecojo.getGrafico());


        Double[][] puntosEntrega = {
                {-12.054901, -77.085470},
                {-12.051833, -77.087903},
                {-12.061104, -77.084243},
                {-12.060876, -77.082660},
                {-12.067592, -77.081687},
                {-12.072936, -77.083132}
        };
        PoliLinea poliEntrega = new PoliLinea(entrega, puntosEntrega);
        //graphicsOverlay.getGraphics().add(poliEntrega.getPoligono());
        facade.addGraphicsOverlay(poliEntrega.getGrafico());
        poliEntrega.ejecutarServicio();

        Punto puntoEntrega = new Punto(entrega,-12.072936, -77.083132);
        //graphicsOverlay.getGraphics().add(puntoEntrega.getPunto());
        facade.addGraphicsOverlay(puntoEntrega.getGrafico());
        puntoEntrega.ejecutarServicio();

        //facade.getMapaBase().getMapView().getGraphicsOverlays().add(graphicsOverlay);
        facade.addGraphicOverlay();
        //facade.getStackPane().getChildren().add(mapaBase.getMapView());
        facade.stackAddMapView();

        */


        // Strategy, algoritmos de creacion de ruta
        Double[][] puntos = {
            {-12.054456, -77.083491},  // inicio
            {-12.059279, -77.075558}   // fin
        };
        Context context = new Context();
        context.setStrategy(new CamionRutaStrategy());
        context.setStrategy(new MotoRutaStrategy());
        Double[][] puntosEntregaOptimizado = context.crearRuta(puntos);
        PoliLinea rutaLinea = new PoliLinea(puntosEntregaOptimizado);
        facade.addGraphicsOverlay(rutaLinea.getGrafico());

        // generar puntos
        Recojo recojo = new Recojo(puntos[0][0], puntos[0][1], "UNMSM", "Recoger en la entrada");
        Despacho entrega = new Despacho(puntos[1][0], puntos[1][1], "Terapias infantiles", "Despachar libros", "123456798");
        Punto[] puntosRuta = { recojo, entrega };

        // creacion de la ruta optimizada, incluye puntos
        Ruta ruta = new Ruta(rutaLinea, puntosRuta);


        // exportar la informacion visitando cada nodo
        JSONExportVisitor jsonVisitor = new JSONExportVisitor();
        for (Punto punto : ruta.getPuntos()) {
            punto.accept(jsonVisitor);
        }

        // XXX: gson pretty print

        //facade.getMapaBase().getMapView().getGraphicsOverlays().add(graphicsOverlay);
        facade.addGraphicOverlay();
        //facade.getStackPane().getChildren().add(mapaBase.getMapView());
        facade.stackAddMapView();

    }

    public void muestraNuevaVentana() {
        Stage stageN = new Stage();
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);
        stageN.setScene(scene);
        stageN.setTitle("Sistema de Monitoreo de Vehiculos");
        stageN.setWidth(800);
        stageN.setHeight(700);

        //  Clonacion de MapaBase
        Mapa mapaBase2 = (Mapa)mapaBase.copiar();

        mapaBase2.imprimeCoordenadasActual();
        stackPane.getChildren().add(mapaBase2.getMapView());

        stageN.show();
    }


}

