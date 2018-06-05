package figuras;

import org.springframework.data.annotation.Id;

/**
 * Clase abstracta base de todas las figuras. Se eligio implementar algunos metodos retornando
 * null para simplificar y hacer mas claro el codigo en las subclases.
 */
public abstract class AbstractFigura implements FiguraGeometrica {

    @Id
    private String id;

    @Override
    public String getId() {
        return id;
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
    public String toString() {
        return getTipo()
                + " de superficie "
                + getSuperficie()
                + " con "
                + getDescripcion();
    }

    protected abstract String getDescripcion();

}
