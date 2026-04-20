package br.com.petshower.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ClienteCreateDTO {

    @NotBlank
    private String nome;

    @Email
    private String email;

    @NotNull
    private String cpf;

    private String endereco;
}
