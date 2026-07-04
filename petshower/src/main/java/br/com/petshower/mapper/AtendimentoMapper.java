package br.com.petshower.mapper;

import br.com.petshower.model.Atendimento;
import org.springframework.stereotype.Component;
import br.com.petshower.dto.response.AtendimentoResponseDTO;

@Component
public class AtendimentoMapper {

    public static AtendimentoResponseDTO toDTO(Atendimento atendimento) {
        AtendimentoResponseDTO dto = new AtendimentoResponseDTO();
        dto.setId(atendimento.getId());
        dto.setData(atendimento.getData());
        dto.setEntrega(atendimento.getEntrega());
        dto.setDescricao(atendimento.getDescricao());
        dto.setStatus(atendimento.getStatus());
        return dto;
    }

}