package figuras;

public class Cuadrado extends AbstractFigura {

    private final Double longitudLado;

    /**
     * Crea un Cuadrado con la longitud de sus lados.
     *
     * @param longitudLado la longitud de cualquier lado del cuadrado.
     */
    public Cuadrado(Double longitudLado) {
        this.longitudLado = longitudLado;
    }

    @Override
    public Double getSuperficie() {
        return Math.pow(longitudLado, 2);
    }

    @Override
    public Double getBase() {
        return longitudLado;
    }

    @Override
    public Double getAltura() {
        return longitudLado;
    }

    @Override
    public String getTipo() {
        return "Cuadrado";
    }

    @Override
    protected String getDescripcion() {
        return "lado "
                + longitudLado;
    }

}
