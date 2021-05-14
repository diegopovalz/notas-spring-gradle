package com.diego.notas.infraestructura.controlador;

import com.diego.notas.aplicacion.servicio.ServicioAplicacionEncontrarNota;
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
    private final ServicioAplicacionEncontrarNota servicioEncontrarNota;

    @Autowired
    public ControladorNotas(ServicioAplicacionGuardarNota servicioGuardarNota,
                            ServicioAplicacionListarNotas servicioListarNotas,
                            ServicioAplicacionEncontrarNota servicioEncontrarNota) {
        this.servicioGuardarNota = servicioGuardarNota;
        this.servicioListarNotas = servicioListarNotas;
        this.servicioEncontrarNota = servicioEncontrarNota;
    }

    @PostMapping("/nota")
    public ResponseEntity<NotaDTO> guardarNota(@RequestBody NotaDTO notaDTO) {
        NotaDTO nota = this.servicioGuardarNota.ejecutar(notaDTO);
        return new ResponseEntity<>(nota, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<NotaDTO>> listar() {
        List<NotaDTO> notas = this.servicioListarNotas.ejecutar();
        return new ResponseEntity<>(notas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaDTO> encontrar(@PathVariable("id") Long id) {
        NotaDTO nota = this.servicioEncontrarNota.ejecutar(id);
        return new ResponseEntity<>(nota, HttpStatus.OK);
    }
}
