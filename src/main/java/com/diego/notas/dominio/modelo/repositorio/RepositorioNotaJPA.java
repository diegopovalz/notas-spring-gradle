package com.diego.notas.dominio.modelo.repositorio;

import com.diego.notas.dominio.modelo.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioNotaJPA extends JpaRepository<Nota, Long> {

}
