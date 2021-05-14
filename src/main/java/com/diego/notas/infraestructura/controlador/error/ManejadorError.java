package com.diego.notas.infraestructura.controlador.error;

import com.diego.notas.dominio.excepcion.ExcepcionEntidadNoExistente;
import com.diego.notas.dominio.excepcion.ExcepcionFormatoIncorrecto;
import com.diego.notas.dominio.excepcion.ExcepcionValorNoValido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejadorError {

    private static final Logger log = LoggerFactory.getLogger(ManejadorError.class);

    @ExceptionHandler(ExcepcionFormatoIncorrecto.class)
    public final ResponseEntity<Error> manejarErrorFormato(ExcepcionFormatoIncorrecto e) {
        Error error = new Error(e.getMessage());
        log.error(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ExcepcionValorNoValido.class)
    public final ResponseEntity<Error> manejarErrorValidacion(ExcepcionValorNoValido e) {
        Error error = new Error(e.getMessage());
        log.error(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExcepcionEntidadNoExistente.class)
    public final ResponseEntity<Error> manejarErrorEntidadNoExistente(ExcepcionEntidadNoExistente e) {
        Error error = new Error(e.getMessage());
        log.error(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> manejarExcepcion(Exception e) {
        Error error = new Error(e.getMessage());
        log.error(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
