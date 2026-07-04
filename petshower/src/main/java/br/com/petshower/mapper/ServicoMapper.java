package br.com.petshower.mapper;

import br.com.petshower.model.Servico;
import org.springframework.stereotype.Component;
import br.com.petshower.dto.response.ServicoResponseDTO;

@Component
public class ServicoMapper {

    public static ServicoResponseDTO toDTO(Servico servico) {
        ServicoResponseDTO dto = new ServicoResponseDTO();
        dto.setId(servico.getId());
        dto.setNome(servico.getNome());
        dto.setPreco(servico.getPreco());
        return dto;
    }

}
