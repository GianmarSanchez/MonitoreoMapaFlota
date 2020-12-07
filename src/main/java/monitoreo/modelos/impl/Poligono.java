package monitoreo.modelos.impl;

import com.esri.arcgisruntime.geometry.*;
import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.symbology.SimpleFillSymbol;
import com.esri.arcgisruntime.symbology.SimpleLineSymbol;
import monitoreo.modelos.interfaces.IGrafico;

public class Poligono implements IGrafico {

    private Graphic poligono;

    private static final SpatialReference SPATIAL_REFERENCE = SpatialReferences.getWgs84();

    public Poligono() {
        // create a green (0xFF005000) simple line symbol
        SimpleLineSymbol outlineSymbol = new SimpleLineSymbol(SimpleLineSymbol.Style.SOLID, 0xFF005000, 3.0f);
        
        // create a new point collection for polygon
        PointCollection points = new PointCollection(SPATIAL_REFERENCE);

        // create and add points to the point collection
        points.add(new Point(-77.08396, -12.05462));
        points.add(new Point(-77.089, -12.059));
        points.add(new Point(-77.084, -12.059));
        points.add(new Point(-77.08396, -12.05462));

        // create the polyline from the point collection
        Polyline polygon = new Polyline(points);

        // create the graphic with polyline and symbol
        System.out.println(polygon.toJson().toString());
        this.poligono = new Graphic(polygon, outlineSymbol);

    }

    public Graphic getPoligono(){
        return this.poligono;
    }

    @Override
    public void mover(Integer x, Integer Y) {

    }

    @Override
    public void dibujar() {

    }
}
