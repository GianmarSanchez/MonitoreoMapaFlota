package monitoreo;

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;

import monitoreo.modelos.Ventana;

import javafx.application.Application;

public class Server {

    public static void main(String[] args) {

        System.out.println("Iniciando servidor");

        //ArcGISRuntimeEnvironment.setInstallDirectory("/home/narugami/Downloads/arcgis-runtime-sdk-java-100.9.0");
        ArcGISRuntimeEnvironment.setInstallDirectory("C://Aplicaciones//arcgis-runtime-sdk-java-100.9.0");

        Application.launch(Ventana.class, args);
    }

}
