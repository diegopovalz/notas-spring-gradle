package com.diego.notas.dominio.servicio;

import com.diego.notas.dominio.dto.NotaDTO;
import com.diego.notas.dominio.puerto.repositorio.RepositorioNota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioEncontrarNota {
    private final RepositorioNota repositorioNota;

    @Autowired
    public ServicioEncontrarNota(RepositorioNota repositorioNota) {
        this.repositorioNota = repositorioNota;
    }

    public NotaDTO encontrar(Long id) {
        return this.repositorioNota.encontrar(id);
    }
}
