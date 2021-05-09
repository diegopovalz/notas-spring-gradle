package com.diego.notas.infraestructura.controlador;

import com.diego.notas.aplicacion.servicio.ServicioAplicacionGuardarNota;
import com.diego.notas.aplicacion.servicio.ServicioAplicacionListarNotas;
import com.diego.notas.dominio.dto.NotaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class ControladorNotas {

    private final ServicioAplicacionGuardarNota servicioGuardarNota;
    private final ServicioAplicacionListarNotas servicioListarNotas;

    @Autowired
    public ControladorNotas(ServicioAplicacionGuardarNota servicioGuardarNota, ServicioAplicacionListarNotas servicioListarNotas) {
        this.servicioGuardarNota = servicioGuardarNota;
        this.servicioListarNotas = servicioListarNotas;
    }

    @PostMapping("")
    public ResponseEntity<NotaDTO> guardarNota(@RequestBody NotaDTO notaDTO) {
        NotaDTO nota = this.servicioGuardarNota.ejecutar(notaDTO);
        return new ResponseEntity<>(nota, HttpStatus.OK);
    }

    @GetMapping("/nota/{id}")
    public ResponseEntity<List<NotaDTO>> listar(@PathVariable("id") Long id) {
        List<NotaDTO> notas = this.servicioListarNotas.ejecutar();
        return new ResponseEntity<>(notas, HttpStatus.OK);
    }
}
