package br.com.petshower.dto.request;

import lombok.*;
import jakarta.validation.constraints.*;
import br.com.petshower.enums.CategoriaAnimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AnimalRequestDTO {

    @NotNull
    private Long clienteId;

    @NotBlank
    private String nome;

    @NotNull
    private CategoriaAnimal categoriaAnimal;

    private Integer idade;
}
