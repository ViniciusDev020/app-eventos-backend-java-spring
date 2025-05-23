package com.example.eventos.controller.usuario;

import com.example.eventos.domain.entities.endereco.EnderecoMapper;
import com.example.eventos.domain.entities.evento.Evento;
import com.example.eventos.domain.entities.usuario.Usuario;
import com.example.eventos.dto.evento.DadosCadastrarEvento;
import com.example.eventos.dto.usuario.DadosCadastrarUsuario;
import com.example.eventos.repository.evento.EventoRepository;
import com.example.eventos.repository.usuario.UsuarioRepository;
import jakarta.persistence.Embedded;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(("/usuarios"))
@Service
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EventoRepository eventoRepository;

    @Embedded
    EnderecoMapper mapper = new EnderecoMapper();

    @GetMapping
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios;
    }

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody DadosCadastrarUsuario usuario) {
        List<Evento> eventos = usuario.eventos();

        if(eventos != null && !eventos.isEmpty()) {
            eventos.forEach(evento -> {
                Evento eventoPeloId = eventoRepository.getReferenceById(evento.getId());

               eventoPeloId.atualizar(new DadosCadastrarEvento(evento.getNome(), mapper.mapToDto(evento.getEndereco()), evento.getUsuario()));
            });
        }

        Usuario usuarioSalvar = new Usuario(usuario);

        usuarioRepository.save(usuarioSalvar);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarUsuario(@PathVariable Long id, @RequestBody DadosCadastrarUsuario usuario) {
        Usuario usuarioPeloId = usuarioRepository.getReferenceById(id);

        usuarioPeloId.atualizar(usuario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void removerUsuario(@PathVariable Long id) {
        Usuario usuarioPeloId = usuarioRepository.getReferenceById(id);
        usuarioRepository.delete(usuarioPeloId);
    }

}
