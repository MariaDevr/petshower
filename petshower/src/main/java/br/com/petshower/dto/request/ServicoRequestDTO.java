package br.com.petshower.dto.request;

import lombok.*;
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ServicoRequestDTO {

    @NotBlank
    private String nome;

    @NotNull
    private BigDecimal preco;

}
