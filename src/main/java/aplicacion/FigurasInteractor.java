package aplicacion;

import aplicacion.persistencia.RepositorioFigura;
import figuras.FiguraGeometrica;
import figuras.factory.FigurasFactory;

import java.util.List;

/**
 * El interactor expone las funciones de la aplicacion separando a la misma de los frameworks utilizados.
 */
public class FigurasInteractor {

    private RepositorioFigura repositorio;

    /**
     * Crea un nuevo interactor asociado al repositorio dado.
     *
     * @param repositorio el repositorio usado por este interactor
     */
    public FigurasInteractor(RepositorioFigura repositorio) {
        this.repositorio = repositorio;
    }

    /**
     * Crea e ingresa una nueva figura en la aplicacion.
     *
     * Parametros segun tipo:
     * 'Circulo": [radio] la longitud del radio del circulo
     * 'Cuadrado": [lado] la longitud de los lados del cuadrado
     * 'Circulo": [base, altura] la longitud de la base y la altura (en ese orden) del triangulo
     *
     * @param request tipo y parametros de la figura
     * @return la nueva figura creada
     */
    public FiguraGeometrica ingresarFigura(FiguraRequest request) {
        FiguraGeometrica figura = crearFigura(request);
        repositorio.persistirFigura(figura);
        return figura;
    }

    private FiguraGeometrica crearFigura(FiguraRequest request) {
        return FigurasFactory.crear(request.getTipo(), request.getParametros());
    }

    /**
     * Busca en la aplicacion una figura con el id dado.
     *
     * @param id el id de la figura
     * @return la figura encontrada
     */
    public FiguraGeometrica getFiguraPorId(String id) {
        return repositorio.buscarPorId(id);
    }

    /**
     * Busca las figuras en la aplicacion.
     *
     * @return todas la figuras registradas
     */
    public List<FiguraGeometrica> getFiguras() {
        return repositorio.buscarTodas();
    }

}
