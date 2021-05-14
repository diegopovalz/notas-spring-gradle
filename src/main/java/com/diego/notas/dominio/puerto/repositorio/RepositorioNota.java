package com.diego.notas.dominio.puerto.repositorio;

import com.diego.notas.dominio.dto.NotaDTO;

import java.util.List;

//Puerto
public interface RepositorioNota {
    List<NotaDTO> listar();
    NotaDTO guardar(NotaDTO nota);
    NotaDTO encontrar(Long id);
}
