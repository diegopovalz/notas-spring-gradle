package com.diego.notas.aplicacion.servicio;

import com.diego.notas.dominio.dto.NotaDTO;
import com.diego.notas.dominio.servicio.ServicioEncontrarNota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEncontrarNota {
    private final ServicioEncontrarNota servicioEncontrarNota;

    @Autowired
    public ServicioAplicacionEncontrarNota(ServicioEncontrarNota servicioEncontrarNota) {
        this.servicioEncontrarNota = servicioEncontrarNota;
    }

    public NotaDTO ejecutar(Long id) {
        return this.servicioEncontrarNota.encontrar(id);
    }
}
