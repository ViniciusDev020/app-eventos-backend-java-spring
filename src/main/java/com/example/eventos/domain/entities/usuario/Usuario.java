package com.example.eventos.domain.entities.usuario;
import com.example.eventos.domain.entities.endereco.Endereco;
import com.example.eventos.domain.entities.evento.Evento;
import com.example.eventos.dto.usuario.DadosCadastrarUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private LocalDate nascimento;
    private String cpf;

    @Embedded
    private Endereco endereco;

    @ManyToMany
    @JoinTable(
        name = "usuarios_eventos",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> eventos;
    public Usuario(DadosCadastrarUsuario dadosCadastrarUsuario) {
        this.nome = dadosCadastrarUsuario.nome();
        this.email = dadosCadastrarUsuario.email();
        this.eventos = dadosCadastrarUsuario.eventos();
        this.nascimento = dadosCadastrarUsuario.nascimento();
        this.cpf = dadosCadastrarUsuario.cpf();
        if(dadosCadastrarUsuario.endereco() != null) {
            this.endereco = new Endereco(dadosCadastrarUsuario.endereco());
        }
    }

    public Long getId() {
        return id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;

    }

    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public void atualizar(DadosCadastrarUsuario dadosCadastrarUsuario) {
        if(dadosCadastrarUsuario.nome() != null){
            this.nome = dadosCadastrarUsuario.nome();
        }
        if(dadosCadastrarUsuario.email() != null){
            this.email = dadosCadastrarUsuario.email();
        }
        if(dadosCadastrarUsuario.nascimento() != null){
            this.nascimento = dadosCadastrarUsuario.nascimento();
        }
        if(dadosCadastrarUsuario.cpf() != null){
            this.cpf = dadosCadastrarUsuario.cpf();
        }
        if(dadosCadastrarUsuario.eventos() != null){
            this.eventos = dadosCadastrarUsuario.eventos();
        }
    }

    public String toString(){
        return this.nome + " " + this.email;
    }
}
