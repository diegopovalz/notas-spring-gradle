package com.diego.notas.dominio.servicio;

import com.diego.notas.dominio.dto.NotaDTO;
import com.diego.notas.dominio.puerto.repositorio.RepositorioNota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioListarNotas {
    private final RepositorioNota repositorioNota;

    @Autowired
    public ServicioListarNotas(RepositorioNota repositorioNota) {
        this.repositorioNota = repositorioNota;
    }

    public List<NotaDTO> listar() {
        return this.repositorioNota.listar();
    }
}
