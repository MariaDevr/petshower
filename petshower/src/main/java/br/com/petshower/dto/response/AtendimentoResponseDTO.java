package br.com.petshower.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import br.com.petshower.enums.StatusAtendimento;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AtendimentoResponseDTO {

    private Long id;
    private Date data;
    private Boolean entrega;
    private String descricao;
    private StatusAtendimento status;
    private AnimalResponseDTO animalResponseDTO;

}