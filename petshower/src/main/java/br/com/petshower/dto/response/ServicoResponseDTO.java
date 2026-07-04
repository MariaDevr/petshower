package br.com.petshower.dto.response;

import lombok.Setter;
import lombok.Getter;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ServicoResponseDTO {

    private Long id;
    private String nome;
    private BigDecimal preco;

}