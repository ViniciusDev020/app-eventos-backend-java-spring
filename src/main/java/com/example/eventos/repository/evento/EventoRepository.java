package com.example.eventos.repository.evento;

import com.example.eventos.domain.entities.evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
