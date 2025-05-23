package com.example.eventos.domain.entities.endereco;
import com.example.eventos.dto.endereco.DadosCadastrarEndereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {
    public DadosCadastrarEndereco mapToDto(Endereco endereco){
        if (endereco != null) {
            return new DadosCadastrarEndereco(endereco.getEstado(), endereco.getCidade(), endereco.getRua(), endereco.getCep());
        }
        return null;
    }
}
