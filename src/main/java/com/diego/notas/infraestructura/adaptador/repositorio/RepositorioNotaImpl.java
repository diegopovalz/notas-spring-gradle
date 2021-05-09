package com.diego.notas.infraestructura.adaptador.repositorio;

import com.diego.notas.dominio.dto.NotaDTO;
import com.diego.notas.dominio.modelo.Nota;
import com.diego.notas.dominio.modelo.mapeador.MapeadorNota;
import com.diego.notas.dominio.modelo.repositorio.RepositorioNotaJPA;
import com.diego.notas.dominio.puerto.repositorio.RepositorioNota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//Adaptador/Implementación del Repositorio
public class RepositorioNotaImpl implements RepositorioNota {

    private final RepositorioNotaJPA repositorio;
    private final MapeadorNota mapeadorNota;

    @Autowired
    public RepositorioNotaImpl(RepositorioNotaJPA repositorio, MapeadorNota mapeadorNota) {
        this.repositorio = repositorio;
        this.mapeadorNota = mapeadorNota;
    }

    @Override
    public List<NotaDTO> listar() {
        List<Nota> notas = this.repositorio.findAll();
        return mapeadorNota.listaNotasANotaDto(notas);
    }

    @Override
    public NotaDTO guardar(NotaDTO notaDTO) {
        Nota nota = mapeadorNota.dtoAEntidad(notaDTO);
        Nota notaTemporal = this.repositorio.save(nota);
        return mapeadorNota.entidadADto(notaTemporal);
    }
}
