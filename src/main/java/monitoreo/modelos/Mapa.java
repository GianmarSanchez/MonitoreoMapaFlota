package monitoreo.modelos;

import java.util.concurrent.ExecutionException;

import com.esri.arcgisruntime.concurrent.ListenableFuture;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.Viewpoint;
import com.esri.arcgisruntime.mapping.view.MapView;

public class Mapa {

    private MapView mapView;

    public Mapa()   {

        // create a MapView to display the map and add it to the stack pane
        mapView = new MapView();

        // create an ArcGISMap with the default imagery basemap
        final ArcGISMap map = new ArcGISMap(Basemap.createImagery());

        // display the map by setting the map on the map view
        mapView.setMap(map);

        // latitude, longitude, scale
        //Viewpoint viewpoint = new Viewpoint(27.3805833, 33.6321389, 6E3);
        Viewpoint viewpoint = new Viewpoint(-12.0560, -77.0844, 12000);   // UNMSM

        // take 5 seconds to move to viewpoint
        final ListenableFuture<Boolean> viewpointSetFuture = mapView.setViewpointAsync(viewpoint, 5);
        viewpointSetFuture.addDoneListener(() -> {
            try {
                boolean completed = viewpointSetFuture.get();
                if (completed) {
                    System.out.println("Acercamiento completado");
                }
            } catch (InterruptedException e) {
                System.out.println("Acercamiento interrumpido");
            } catch (ExecutionException e) {
                // Deal with exception during animation...
            }
        });
    }

    public MapView getMapView() {
        return mapView;
    }

    public void setMapView(MapView mapView) {
        this.mapView = mapView;
    }

}