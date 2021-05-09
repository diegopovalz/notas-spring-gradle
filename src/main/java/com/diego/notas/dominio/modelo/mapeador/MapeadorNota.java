package com.diego.notas.dominio.modelo.mapeador;

import com.diego.notas.dominio.dto.NotaDTO;
import com.diego.notas.dominio.modelo.Nota;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapeadorNota {

    private final DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public Nota dtoAEntidad(NotaDTO notaDTO) {
        try {
            return Nota.builder()
                    .descripcion(notaDTO.getDescripcion())
                    .fecha(formato.parse(notaDTO.getFecha()))
                    .build();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public NotaDTO entidadADto(Nota nota) {
        return NotaDTO.builder()
                .id(nota.getId())
                .descripcion(nota.getDescripcion())
                .fecha(formato.format(nota.getFecha()))
                .build();
    }

    public List<NotaDTO> listaNotasANotaDto(List<Nota> notas) {
        return notas.stream()
                .map(n -> entidadADto(n))
                .collect(Collectors.toList());
    }
}
