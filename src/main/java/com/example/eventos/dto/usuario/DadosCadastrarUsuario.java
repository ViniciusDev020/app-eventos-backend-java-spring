package com.example.eventos.dto.usuario;

import com.example.eventos.domain.entities.endereco.Endereco;
import com.example.eventos.domain.entities.evento.Evento;
import com.example.eventos.dto.endereco.DadosCadastrarEndereco;

import java.time.LocalDate;
import java.util.List;

public record DadosCadastrarUsuario(
        String nome,
        String email,

        String cpf,
        LocalDate nascimento,

        DadosCadastrarEndereco endereco,
        List<Evento> eventos
) {
}
