package com.example.eventos.domain.entities.evento;
import com.example.eventos.domain.entities.endereco.Endereco;
import com.example.eventos.domain.entities.usuario.Usuario;
import com.example.eventos.dto.evento.DadosCadastrarEvento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "eventos")
@Entity(name = "eventos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Embedded
    private Endereco endereco;

    @ManyToMany(mappedBy = "eventos")
    @JsonIgnore
    List<Usuario> usuario;

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    public Evento(DadosCadastrarEvento dadosCadastrarEvento) {
        this.nome = dadosCadastrarEvento.nome();
        if(dadosCadastrarEvento.endereco() != null){
            this.endereco = new Endereco(dadosCadastrarEvento.endereco());
        }
    }
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }
    public void atualizar(DadosCadastrarEvento dadosCadastrarEvento) {
        if(dadosCadastrarEvento.nome() != null){
            this.nome = dadosCadastrarEvento.nome();
        }
        if(dadosCadastrarEvento.usuario() != null){
            this.usuario = dadosCadastrarEvento.usuario();
        }
    }

    public String toString(){
        return this.nome + " " + this.endereco;
    }
}
