package com.diego.notas.infraestructura.adaptador.repositorio;

import com.diego.notas.dominio.dto.NotaDTO;
import com.diego.notas.dominio.excepcion.ExcepcionEntidadNoExistente;
import com.diego.notas.dominio.modelo.Nota;
import com.diego.notas.dominio.modelo.mapeador.MapeadorNota;
import com.diego.notas.dominio.modelo.repositorio.RepositorioNotaJPA;
import com.diego.notas.dominio.modelo.utils.Validador;
import com.diego.notas.dominio.puerto.repositorio.RepositorioNota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
        Validador.validarNoNulo(notaDTO.getDescripcion(), "Descripción");
        Validador.validarNoVacio(notaDTO.getDescripcion(), "Descripción");
        Validador.validarNoNulo(notaDTO.getFecha(), "Fecha");

        Nota nota = mapeadorNota.dtoAEntidad(notaDTO);
        Nota notaTemporal = this.repositorio.save(nota);
        return mapeadorNota.entidadADto(notaTemporal);
    }

    @Override
    public NotaDTO encontrar(Long id) {
        Validador.validarNoNulo(id, "ID");
        Optional<Nota> nota = this.repositorio.findById(id);
        if(!nota.isPresent())
            throw new ExcepcionEntidadNoExistente("No existe una nota con el ID " + id);
        return mapeadorNota.entidadADto(nota.get());
    }
}
