package com.diego.notas.dominio.modelo.utils;

import com.diego.notas.dominio.excepcion.ExcepcionValorNoValido;

public class Validador {

    private Validador() { }

    public static void validarNoNulo(Object value, String name) {
        if(value == null) {
            throw new ExcepcionValorNoValido(name + " no puede ser nulo");
        }
    }

    public static void validarNoVacio(String value, String name) {
        if(value.isEmpty()) {
            throw new ExcepcionValorNoValido(name + " no puede ser vacío");
        }
    }
}
