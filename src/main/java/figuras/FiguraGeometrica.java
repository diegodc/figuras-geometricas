package figuras;

/**
 * Interface comun para todas las figuras, cada metodo retorna el valor correspondiente,
 * o null en caso que la figura no posea la caracteristica.
 */
public interface FiguraGeometrica {

    /**
     * Utilizada para identificar a la figura univocamente.
     *
     * @return el id de la figura
     */
    String getId();

    /**
     * Retorna la superficie (area) de la figura.
     *
     * @return la superficie de la figura
     */
    Double getSuperficie();

    /**
     * Retorna la base de la figura.
     *
     * @return la base de la figura o null si no corresponde al tipo de figura.
     */
    Double getBase();

    /**
     * Retorna la altura de la figura.
     *
     * @return la altura de la figura o null si no corresponde al tipo de figura.
     */
    Double getAltura();

    /**
     * Retorna el diametro de la figura.
     *
     * @return la diametro de la figura o null si no corresponde al tipo de figura.
     */
    Double getDiametro();

    /**
     * Retorna el tipo de esta figura.
     *
     * @return el tipo de la figura
     */
    String getTipo();

}
