package br.com.petshower.dto;

import lombok.*;
import java.util.Date;
import jakarta.validation.constraints.*;
import br.com.petshower.enums.StatusAtendimento;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AtendimentoCreateDTO {

    @NotNull
    private Long animalId;

    @NotNull
    private Date data;

    @NotNull
    private StatusAtendimento status;

    @NotNull
    private Boolean entrega;

    private String descricao;
}
