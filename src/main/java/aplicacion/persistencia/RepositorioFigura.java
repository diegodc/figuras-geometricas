package aplicacion.persistencia;

import figuras.FiguraGeometrica;

import java.util.List;

/**
 * Repositorio de Figuras utilizado por el interactor.
 */
public interface RepositorioFigura {

    /**
     * Persiste la figura dada en el repositorio.
     *
     * @param figura la figura a persistir.
     */
    void persistirFigura(FiguraGeometrica figura);

    /**
     * Busca segun el id de la Figura
     *
     * @param id el id de la figura buscada
     * @return la figura buscada
     */
    FiguraGeometrica buscarPorId(String id);

    /**
     * Retorna todas las figuras.
     *
     * @return todas las figuras presentes en el repositorio
     */
    List<FiguraGeometrica> buscarTodas();

}
