package monitoreo.modelos.impl;

public class EntregaProgramada  {

    private String rangoHora;
    private String fecha;
    private Double costo = 99.90;

    public EntregaProgramada(String rangoHora, String fecha)  {

        this.rangoHora = rangoHora;
        this.fecha = fecha;
    }

    public void listarEntrega() {

        System.out.println("[Entrega Programada] Entrega planificada: " + this.fecha + " - " + this.rangoHora );
    }

    public Double calcularCosto() {

        return this.costo;
    }
}
