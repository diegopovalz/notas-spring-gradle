package com.diego.notas.dominio.excepcion;

public class ExcepcionValorNoValido extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public ExcepcionValorNoValido(String mensaje) {
        super(mensaje);
    }
}
