package figuras;

public class Triangulo extends AbstractFigura {

    private final Double base;
    private final Double altura;

    /**
     * Crea un Triangulo con la base y altura dadas.
     *
     * @param base la base del triangulo
     * @param altura la altura del triangulo
     */
    public Triangulo(Double base, Double altura) {
        super(base * altura / 2);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public Double getBase() {
        return base;
    }

    @Override
    public Double getAltura() {
        return altura;
    }

    @Override
    public String getTipo() {
        return "Triangulo";
    }

    @Override
    protected String getDescripcion() {
        return "base "
                + base
                + " y altura "
                + altura;
    }

}
