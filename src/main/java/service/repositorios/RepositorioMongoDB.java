package service.repositorios;

import aplicacion.persistencia.FiguraNoEncontradaException;
import aplicacion.persistencia.RepositorioFigura;
import figuras.FiguraGeometrica;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Implementacion del Repositorio de Figuras utilizando Spring Data MongoDB.
 */
public interface RepositorioMongoDB extends RepositorioFigura, MongoRepository<FiguraGeometrica, String> {

    @Override
    default void persistirFigura(FiguraGeometrica figura) {
        this.save(figura);
    }

    @Override
    default FiguraGeometrica buscarPorId(String id) {
        Optional<FiguraGeometrica> optional = this.findById(id);

        if (!optional.isPresent())
            throw new FiguraNoEncontradaException("No se encontro Figura con id [" + id + "]");

        return optional.get();
    }

    @Override
    default List<FiguraGeometrica> buscarTodas() {
        return this.findAll();
    }

}
