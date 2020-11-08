package monitoreo.modelos.impl;

import javafx.scene.image.ImageView;
import monitoreo.modelos.Icono;

public class NullIcono extends Icono {
    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public ImageView getImageView() {
        System.out.println("Alerta: Imagen no disponible para icono nulo");
        return null;
    }
}
