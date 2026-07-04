package br.com.petshower.dto.response;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import br.com.petshower.enums.CategoriaAnimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AnimalResponseDTO {

    private Long id;
    private String nome;
    private Integer idade;
    private CategoriaAnimal categoriaAnimal;
    private ClienteResponseDTO clienteResponseDTO;
    private AtendimentoResponseDTO atendimentoResponseDTO;

}