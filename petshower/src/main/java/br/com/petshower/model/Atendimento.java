package br.com.petshower.model;

import lombok.*;
import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import br.com.petshower.enums.StatusAtendimento;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @OneToMany(mappedBy="atendimento")
    private Set<AtendimentoServico> atendimentoServicos;

    @NotNull
    @Column(nullable = false)
    private Date data;

    @NotNull
    private Boolean entrega;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusAtendimento status;

}
