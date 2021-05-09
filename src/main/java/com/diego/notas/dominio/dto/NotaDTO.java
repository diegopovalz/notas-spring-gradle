package com.diego.notas.dominio.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
//Data Transfer Object, Patrón de diseño Builder
public class NotaDTO {
    private Long id;
    private String fecha;
    private String descripcion;
}
