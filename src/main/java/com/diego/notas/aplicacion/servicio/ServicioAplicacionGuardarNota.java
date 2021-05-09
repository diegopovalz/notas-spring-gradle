package com.diego.notas.aplicacion.servicio;

import com.diego.notas.dominio.dto.NotaDTO;
import com.diego.notas.dominio.servicio.ServicioGuardarNota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarNota {

    private final ServicioGuardarNota servicioGuardarNota;

    @Autowired
    public ServicioAplicacionGuardarNota(ServicioGuardarNota servicioGuardarNota) {
        this.servicioGuardarNota = servicioGuardarNota;
    }

    public NotaDTO ejecutar(NotaDTO nota) {
        return this.servicioGuardarNota.guardar(nota);
    }
}
