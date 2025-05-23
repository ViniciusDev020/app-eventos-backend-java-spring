package com.example.eventos.domain.entities.endereco;
import com.example.eventos.dto.endereco.DadosCadastrarEndereco;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Embeddable
public class Endereco {
    private String estado;
    private String cidade;
    private String rua;
    private String cep;
    public Endereco(DadosCadastrarEndereco endereco) {
        this.estado = endereco.estado();
        this.cidade = endereco.cidade();
        this.rua = endereco.rua();
        this.cep = endereco.cep();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public  String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    void atualizar(DadosCadastrarEndereco endereco){
        if(endereco.cidade() != null){
            this.cidade = endereco.cidade();
        }
        if(endereco.estado() != null){
            this.estado = endereco.estado();
        }
        if(endereco.rua() != null){
            this.rua = endereco.rua();
        }
        if(endereco.cep() != null){
            this.cep = endereco.cep();
        }
    }

    public String toString(){
        return this.estado + " " + this.cidade + " " + this.rua + " " + this.cep;
    }
}
