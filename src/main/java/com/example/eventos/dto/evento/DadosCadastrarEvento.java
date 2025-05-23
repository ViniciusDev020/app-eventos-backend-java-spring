package com.example.eventos.dto.evento;

import com.example.eventos.domain.entities.usuario.Usuario;
import com.example.eventos.dto.endereco.DadosCadastrarEndereco;

import java.util.List;

public record DadosCadastrarEvento(
        String nome,
        DadosCadastrarEndereco endereco,

        List<Usuario> usuario
) {
}
