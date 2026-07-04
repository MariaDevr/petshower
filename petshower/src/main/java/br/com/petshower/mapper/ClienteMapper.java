package br.com.petshower.mapper;

import br.com.petshower.model.Cliente;
import org.springframework.stereotype.Component;
import br.com.petshower.dto.response.ClienteResponseDTO;

@Component
public class ClienteMapper {

    public static ClienteResponseDTO toDTO(Cliente cliente) {
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setCpf(cliente.getCpf());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        dto.setEndereco(cliente.getEndereco());
        return dto;
    }
}
