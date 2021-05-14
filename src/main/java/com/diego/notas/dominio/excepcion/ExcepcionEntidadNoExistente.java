package com.diego.notas.dominio.excepcion;

public class ExcepcionEntidadNoExistente extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public ExcepcionEntidadNoExistente(String mensaje) {
        super(mensaje);
    }
}
