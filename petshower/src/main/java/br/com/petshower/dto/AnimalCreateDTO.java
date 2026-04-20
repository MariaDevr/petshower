package br.com.petshower.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import br.com.petshower.enums.CategoriaAnimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AnimalCreateDTO {

    @NotNull
    private Long clienteId;

    @NotBlank
    private String nome;

    @NotNull
    private CategoriaAnimal categoriaAnimal;

    private Integer idade;
}
