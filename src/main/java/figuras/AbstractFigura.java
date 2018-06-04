package figuras;

import org.springframework.data.annotation.Id;

/**
 * Clase abstracta base de todas las figuras. Se eligio implementar algunos metodos retornando
 * null para simplificar y hacer mas claro el codigo en las subclases.
 */
public abstract class AbstractFigura implements FiguraGeometrica {

    @Id
    private String id;

    private final Double superficie;

    AbstractFigura(Double superficie) {
        this.superficie = superficie;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Double getSuperficie() {
        return superficie;
    }

    @Override
    public Double getBase() {
        return null;
    }

    @Override
    public Double getAltura() {
        return null;
    }

    @Override
    public Double getDiametro() {
        return null;
    }

    @Override
    public String getTipo() {
        return null;
    }

    @Override
    public String toString() {
        return getTipo()
                + " de superficie "
                + superficie
                + " con "
                + getDescripcion();
    }

    protected abstract String getDescripcion();

}
