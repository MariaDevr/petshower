package br.com.petshower.dto;

import lombok.*;
import java.util.Date;
import br.com.petshower.enums.StatusAtendimento;
import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AtendimentoDTO {

    @NotNull
    private Long animalId;

    @NotNull
    private Date data;

    @NotNull
    private StatusAtendimento status;

    private String descricao;
}
