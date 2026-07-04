package br.com.petshower.dto.request;

import lombok.*;
import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ClienteRequestDTO {

    @NotBlank
    private String nome;

    @Email
    private String email;

    @NotNull
    private String cpf;

    private String endereco;
}
