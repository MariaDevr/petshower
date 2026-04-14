package br.com.petshower.model;

import lombok.*;
import java.util.Set;
import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="servico")
    private Set<AtendimentoServico> atendimentoServicos;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotNull
    @Column(nullable = false)
    private BigDecimal preco;
}
