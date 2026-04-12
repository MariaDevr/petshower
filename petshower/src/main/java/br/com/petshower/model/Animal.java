package br.com.petshower.model;

import br.com.petshower.enums.CategoriaAnimal;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy="animal")
    private Set<Atendimento> atendimentos;

    private String nome;
    private int idade;

    @Enumerated(EnumType.STRING)
    private CategoriaAnimal categoriaAnimal;
}
