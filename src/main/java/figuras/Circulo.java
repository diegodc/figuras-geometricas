package figuras;

public class Circulo extends AbstractFigura {

    private final Double diametro;

    /**
     * Crea un circulo del diametro dado.
     *
     * @param diametro el diametro de este Circulo
     */
    public Circulo(Double diametro) {
        this.diametro = diametro;
    }

    @Override
    public Double getSuperficie() {
        return Math.PI * Math.pow(diametro / 2, 2);
    }

    @Override
    public Double getDiametro() {
        return diametro;
    }

    @Override
    public String getTipo() {
        return "Circulo";
    }

    @Override
    protected String getDescripcion() {
        return "diametro "
                + diametro;
    }

}
