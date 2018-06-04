package service;

import aplicacion.persistencia.FiguraNoEncontradaException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Define los diferentes handlers de exepciones para el servicio REST.
 */
@ControllerAdvice
public class HandlerExcepciones {

    @ExceptionHandler(FiguraNoEncontradaException.class)
    public final ResponseEntity<String> figuraNoEncontrada(FiguraNoEncontradaException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<String> argumentosIlegales(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<String> mensajeIncorrecto(HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().body("Error en el request");
    }

}
