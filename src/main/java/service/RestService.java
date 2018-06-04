package service;

import aplicacion.FigurasInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import service.repositorios.RepositorioMongoDB;

/**
 * Configura y ejecuta el servicio REST.
 */
@SpringBootApplication
public class RestService {

    public static void main(String[] args) {
        SpringApplication.run(RestService.class, args);
    }

    /**
     * Crea y registra el interactor de Figuras.
     *
     * @param repositorio el repositorio mongo que utilizara el interactor
     * @return un nuevo interactor que utiliza el repositorio dado
     */
    @Autowired
    @Bean
    public FigurasInteractor getInteractor2(RepositorioMongoDB repositorio) {
        return new FigurasInteractor(repositorio);
    }

}

