package com.diego.notas.dominio.servicio;

import com.diego.notas.dominio.dto.NotaDTO;
import com.diego.notas.dominio.puerto.repositorio.RepositorioNota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarNota {
    private final RepositorioNota repositorioNota;

    @Autowired
    public ServicioGuardarNota(RepositorioNota repositorioNota) {
        this.repositorioNota = repositorioNota;
    }

    public NotaDTO guardar(NotaDTO nota) {
        return this.repositorioNota.guardar(nota);
    }
}
