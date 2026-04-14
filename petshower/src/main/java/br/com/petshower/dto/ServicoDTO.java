package br.com.petshower.dto;

import lombok.*;
import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ServicoDTO {

    @NotBlank
    private String nome;

    @NotNull
    private BigDecimal preco;

}
