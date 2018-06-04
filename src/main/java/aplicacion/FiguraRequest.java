package aplicacion;

/**
 * Contiene los datos para hacer un request a la aplicacion de Figuras.
 */
public class FiguraRequest {

    private String tipo;

    private Double[] parametros;

    /**
     * Para uso interno por Spring y Jackson.
     */
    public FiguraRequest() {}

    /**
     * Crea un nuevo request con los datos datos. Los parametros deben ser los adecuados para el tipo de figura.
     *
     * @param tipo el tipo de figura que se desea ingresar
     * @param parametros los parametros de la figura
     */
    public FiguraRequest(String tipo, Double[] parametros) {
        this.tipo = tipo;
        this.parametros = parametros;
    }

    /**
     * Retorna el tipo de figura geometrica.
     *
     * @return el tipo de figura a crear
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Retorna los parametros para la construccion de la figura.
     *
     * @return los parametros de la figura.
     */
    public Double[] getParametros() {
        return parametros;
    }


}
