package br.com.petshower.dto.response;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ClienteResponseDTO {

    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private String endereco;
    private Set<AnimalResponseDTO> animaisResponseDTO;

}