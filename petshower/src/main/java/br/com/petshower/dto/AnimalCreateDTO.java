package br.com.petshower.dto;

import br.com.petshower.enums.CategoriaAnimal;
import jakarta.validation.constraints.*;
import lombok.*;

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
