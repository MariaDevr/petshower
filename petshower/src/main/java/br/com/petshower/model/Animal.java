package br.com.petshower.model;

import lombok.*;
import java.util.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import br.com.petshower.enums.CategoriaAnimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    @OneToMany(mappedBy="animal")
    private Set<Atendimento> atendimentos;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    private int idade;

    @Enumerated(EnumType.STRING)
    private CategoriaAnimal categoriaAnimal;
}
