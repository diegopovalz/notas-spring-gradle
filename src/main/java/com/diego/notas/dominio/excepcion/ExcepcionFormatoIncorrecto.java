package com.diego.notas.dominio.excepcion;

public class ExcepcionFormatoIncorrecto extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public ExcepcionFormatoIncorrecto(String mensaje) {
        super(mensaje);
    }
}
