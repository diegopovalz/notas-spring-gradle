package com.diego.notas.dominio.modelo.utils;

public class Validador {

    public static void validarNoNulo(Object value, String name) {
        if(value == null) {
            throw new RuntimeException(name + " no puede ser nulo");
        }
    }

    public static void validarNoVacio(String value, String name) {
        if(value.isEmpty()) {
            throw new RuntimeException(name + " no puede ser vacío");
        }
    }
}
