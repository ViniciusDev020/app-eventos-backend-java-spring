package com.example.eventos.controller.evento;

import com.example.eventos.domain.entities.evento.Evento;
import com.example.eventos.dto.evento.DadosCadastrarEvento;
import com.example.eventos.repository.evento.EventoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/eventos"))
public class EventoController {

    @Autowired
    EventoRepository eventoRepository;

    @GetMapping
    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    @PostMapping
    @Transactional
    public void cadastrarEvento(@RequestBody DadosCadastrarEvento evento) {
        Evento eventoSalvar = new Evento(evento);

        eventoRepository.save(eventoSalvar);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarEvento(@PathVariable Long id, @RequestBody DadosCadastrarEvento evento) {
        Evento eventoPeloId = eventoRepository.getReferenceById(id);
        eventoPeloId.atualizar(evento);
    }
}
