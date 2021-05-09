package com.diego.notas.aplicacion.servicio;

import com.diego.notas.dominio.dto.NotaDTO;
import com.diego.notas.dominio.servicio.ServicioListarNotas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarNotas {

    private final ServicioListarNotas servicioListarNotas;

    @Autowired
    public ServicioAplicacionListarNotas(ServicioListarNotas servicioListarNotas) {
        this.servicioListarNotas = servicioListarNotas;
    }

    public List<NotaDTO> ejecutar() {
        return this.servicioListarNotas.listar();
    }
}
