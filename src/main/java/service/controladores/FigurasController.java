package service.controladores;

import aplicacion.FiguraRequest;
import aplicacion.FigurasInteractor;
import figuras.FiguraGeometrica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar los requests al recurso Figuras.
 */
@RestController
@RequestMapping("figuras")
public class FigurasController {

    private final FigurasInteractor interactor;

    /**
     * Crea un controlador que utiliza el interactor provisto.
     *
     * @param interactor el interactor utilizado por este controlador.
     */
    @Autowired
    public FigurasController(FigurasInteractor interactor) {
        this.interactor = interactor;
    }

    /**
     * Ingresa nuevas Figuras a la aplicacion.
     *
     * @param request el request pasado
     * @return la nueva figura ingresada
     */
    @PostMapping
    public FiguraGeometrica ingresarFigura(@RequestBody FiguraRequest request) {
        return interactor.ingresarFigura(request);
    }

    /**
     * Retorna todas las figuras presentes en la aplicacion.
     *
     * @return las figuras registradas en la aplicacion
     */
    @GetMapping
    public List<FiguraGeometrica> getFiguras() {
        return interactor.getFiguras();
    }

    /**
     * Retorna una figura segun el id provisto.
     *
     * @param figuraId el id de la figura buscada
     * @return la figura con el Id dado
     */
    @GetMapping("/{figuraId}")
    public FiguraGeometrica getFiguraPorId(@PathVariable String figuraId) {
        return interactor.getFiguraPorId(figuraId);
    }

}
